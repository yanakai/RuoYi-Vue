package com.ruoyi.business.ent.service.impl;

import cn.hutool.core.map.MapUtil;
import com.github.f4b6a3.ulid.UlidCreator;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.ent.domain.EntOutPutInfo;
import com.ruoyi.business.ent.domain.EntOutPutReq;
import com.ruoyi.business.ent.mapper.EntOutPutMapper;
import com.ruoyi.business.ent.service.EntOutPutInfoService;
import com.ruoyi.business.enums.AnnexTypeEnum;
import com.ruoyi.business.enums.OutPutStatusEnum;
import com.ruoyi.business.enums.OutPutTypeEnum;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.CellUtils;
import com.ruoyi.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 企业排口Service业务层处理
 */
@Slf4j
@Service
public class EntOutPutInfoServiceImpl implements EntOutPutInfoService {

    private EntOutPutMapper entOutPutMapper;
    @Autowired
    public void setEntOutPutMapper(EntOutPutMapper entOutPutMapper) {
        this.entOutPutMapper = entOutPutMapper;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    @Override
    public AjaxResult selectOutPutById(String outPutId) {
        EntOutPutInfo info = entOutPutMapper.selectOutPutById(outPutId);
        if (null == info) {
            return AjaxResult.error("排口信息为空");
        }
        info.setAnnexInfoList(annexService.selectAnnexList(outPutId, AnnexTypeEnum.entOutPut.name()));
        return AjaxResult.success(info);
    }

    @Override
    public AjaxResult selectOutPutList(EntOutPutReq req) {
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new EntOutPutReq();
        }
        if (null == req.getSize() || req.getSize() < 1) {
            req.setSize(10);
        }
        // 添加权限
        if (SecurityUtils.isNotAdmin()) {
            req.setEntCodes(SecurityUtils.getEntCodes());
        }
        long count = entOutPutMapper.selectOutPutListCount(req);
        result.put("total", count);
        List<EntOutPutInfo> list;
        if (count > 0) {
            list = entOutPutMapper.selectOutPutList(req);
        } else {
            list = new ArrayList<>();
        }
        result.put("data", list);
        // 设置检测污染物列表、是否关注等信息
        fillPoll(list, req.getOutPutType());
        return result;
    }

    private void fillPoll(List<EntOutPutInfo> list, Integer outPutType) {
        if (null == list || list.size() < 1) {
            return;
        }
        /* 获取排口的污染物列表 */
        List<Map<String, String>> pollList = entOutPutMapper.selectPollutantByType(outPutType);
        Map<String, String> pollCodeName = pollList.stream()
                .collect(Collectors.toMap(e -> MapUtil.getStr(e, "pollutantCode"),
                        e -> MapUtil.getStr(e, "pollutantName"),
                        (k1, k2) -> k1));
        Map<String, EntOutPutInfo> outPutMap = new HashMap<>();
        list.forEach( e -> {
            outPutMap.put(e.getOutPutId(), e);
            StringBuilder pollutantName = new StringBuilder();
            if (null != e.getPollutantCode()) {
                for (String s : e.getPollutantCode().split(",")) {
                    if (pollCodeName.containsKey(s)) {
                        pollutantName.append("、").append(pollCodeName.get(s));
                    }
                }
            }
            if (pollutantName.length() > 0) {
                e.setPollutantName(pollutantName.substring(1));
            } else {
                e.setPollutantName(null);
            }
        });
        /* 获取是否关注信息，列表数据太多时全查 */
        List<Map<String, Object>> userList = entOutPutMapper.selectUserPutInfoList(SecurityUtils.getUserId());
        userList.forEach( e -> {
            String outPutId = MapUtil.getStr(e, "outPutId");
            if (outPutMap.containsKey(outPutId)) {
                int count = MapUtil.getInt(e, "count", 0);
                outPutMap.get(outPutId).setAttention(count > 0);// 大于0表示关注了
            }
        });
    }

    @Override
    @Log(title = "导出企业企业排口列表", businessType = BusinessType.EXPORT)
    public void exportOutPut(EntOutPutReq req, HttpServletResponse response) {
        if (null == req) {
            req = new EntOutPutReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/企业污染排放口列表模版.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            // 添加权限
            if (SecurityUtils.isNotAdmin()) {
                req.setEntCodes(SecurityUtils.getEntCodes());
            }
            List<EntOutPutInfo> list = entOutPutMapper.selectOutPutList(req);
            // 设置检测污染物列表、是否关注等信息
            fillPoll(list, req.getOutPutType());
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex;// 从第5行开始插入

            rowIndex = 1;// 首行
            Row templateRow = sheet.getRow(rowIndex);
            CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
            CellStyle style = workbook.createCellStyle();
            // 复制单元格样式
            CellUtils.copyCellStyle(templateStyle, style);
            if (null != list && list.size() > 0) {
                int index = 0;
                Row row;
                Cell cell;
                for (EntOutPutInfo info : list) {
                    index++;
                    sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                    row = sheet.createRow(rowIndex);
                    rowIndex++;

                    int cellIndex = 0;
                    // 序号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(index);
                    // 企业名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getEntName());
                    // 排口名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getOutPutName());
                    // 排口编码
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getOutPutCode());
                    // 监测点类型
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(OutPutTypeEnum.getNameByCode(info.getOutPutType()));
                    // 排放状态
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(OutPutStatusEnum.getNameByCode(info.getOutPutStatus()));
                    // 检测污染物
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getPollutantName());
                    // 数采仪MN号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getMnNum());
                    // 中心经度
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(null == info.getLongitude() ? "" : Float.toString(info.getLongitude()));
                    // 中心纬度
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(null == info.getLatitude() ? "" : Float.toString(info.getLatitude()));
                    // 是否关注
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.isAttention() ? "关注" : "未关注");
                    // 备注
                    cell = CellUtils.getCell(row, cellIndex, style);
                    cell.setCellValue(info.getRemark());
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业污染排放口列表.xlsx", "UTF-8"));
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e){
            log.error("按模板导出文件失败", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    @Log(title = "新增企业排口", businessType = BusinessType.INSERT)
    public AjaxResult insertOutPut(EntOutPutInfo info) {
        // 单调递增 ULID (适合高并发)
        info.setOutPutId(UlidCreator.getMonotonicUlid().toString());
        info.setCreateUser(SecurityUtils.getUserName());
        info.setCreateTime(LocalDateTime.now());
        info.setUpdateUser(info.getCreateUser());
        info.setUpdateTime(info.getCreateTime());
        int result = entOutPutMapper.insertOutPut(info);
        if (result > 0){
            // 设置附件
            if (info.getAnnexIdList() != null && info.getAnnexIdList().size() > 0) {
                annexService.updateAnnex(info.getOutPutId(), AnnexTypeEnum.entOutPut.name(), info.getAnnexIdList());
            }
        }
        return AjaxResult.success(info);
    }

    @Override
    @Log(title = "修改企业排口", businessType = BusinessType.UPDATE)
    public AjaxResult updateOutPut(EntOutPutInfo info) {
        info.setUpdateUser(SecurityUtils.getUserName());
        info.setUpdateTime(LocalDateTime.now());
        int result = entOutPutMapper.updateOutPut(info);
        // 修改附件信息
        if (result > 0) {
            annexService.updateAnnex(info.getOutPutId(), AnnexTypeEnum.entOutPut.name(), info.getAnnexIdList());
        }
        return AjaxResult.success(info);
    }

    @Override
    @Log(title = "删除企业排口", businessType = BusinessType.DELETE)
    public AjaxResult deleteOutPutByIds(List<String> outPutIds) {
        int result = entOutPutMapper.deleteOutPutByIds(outPutIds);
        if (result > 0) {
            // 删除企业排口对应的污染物
            entOutPutMapper.deleteOutPutPollutantByOutPutIds(outPutIds);
            // 删除排口的附件
            outPutIds.forEach( e -> annexService.updateAnnex(e, AnnexTypeEnum.entOutPut.name(), null));
        }
        return AjaxResult.success();
    }
}
