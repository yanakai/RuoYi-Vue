package com.ruoyi.business.envProt.service.impl;

import cn.hutool.core.map.MapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.envProt.domain.EntCleanProduce;
import com.ruoyi.business.envProt.domain.EntCleanProduceReq;
import com.ruoyi.business.envProt.mapper.EntCleanProduceMapper;
import com.ruoyi.business.envProt.service.EntCleanProduceService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.*;
import com.ruoyi.common.utils.uuid.IdUtils;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业清洁生产基础Service业务层处理
 */
@Slf4j
@Service
public class EntCleanProduceServiceImpl implements EntCleanProduceService {

    private EntCleanProduceMapper entCleanProduceMapper;
    @Autowired
    public void setEntCleanProduceMapper(EntCleanProduceMapper entCleanProduceMapper) {
        this.entCleanProduceMapper = entCleanProduceMapper;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    @Override
    public AjaxResult selectEntCleanProduceList(EntCleanProduceReq req) {
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new EntCleanProduceReq();
        }
        if (null == req.getCurrent() || req.getCurrent() < 1) {
            req.setCurrent(1);
        }
        if (null == req.getSize() || req.getSize() < 1) {
            req.setSize(10);
        }
        // 添加权限
        if (!SecurityUtils.isNotAdmin()) {
            req.setEntCodes(SecurityUtils.getEntCodes());
        }
        PageHelper.startPage(req.getCurrent(), req.getSize());
        List<EntCleanProduce> list = entCleanProduceMapper.selectEntCleanProduceList(req);
        // 设置字典信息
        fillPoll(list);
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    private void fillPoll(List<EntCleanProduce> list) {
        if (null == list || list.size() < 1) {
            return;
        }
        /* 获取信息
         clean_produce_progress: 清洁生产工作进展
         */
        List<SysDictData> dictList = DictUtils.getDictCache("clean_produce_progress");
        if (null != dictList && dictList.size() > 0) {
            /* dictLabel: "工程车辆"; dictType: "ent_product"; dictValue: "gccl" */
            Map<String, String> cleanMap = new HashMap<>();
            dictList.forEach( e -> {
                String dictType = e.getDictType();
                if ("clean_produce_progress".equals(dictType)) {
                    cleanMap.put(e.getDictValue(), e.getDictLabel());
                }
            });
            for (EntCleanProduce p : list) {
                p.setWorkProgressDesc(cleanMap.get(p.getWorkProgress()));
            }
        }
    }

    @Override
    @Log(title = "企业清洁生产基础", businessType = BusinessType.EXPORT)
    public void exportEntCleanProduce(EntCleanProduceReq req, HttpServletResponse response) {
        if (null == req) {
            req = new EntCleanProduceReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/清洁生产列表模版.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            // 添加权限
            if (SecurityUtils.isNotAdmin()) {
                req.setEntCodes(SecurityUtils.getEntCodes());
            }
            List<EntCleanProduce> list = entCleanProduceMapper.selectEntCleanProduceList(req);
            // 设置字典信息
            fillPoll(list);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex= 4;// 从第5行开始插入

            rowIndex = 2;// 首行
            Row templateRow = sheet.getRow(rowIndex);
            CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
            CellStyle style = workbook.createCellStyle();
            // 复制单元格样式
            CellUtils.copyCellStyle(templateStyle, style);
            if (null != list && list.size() > 0) {
                int index = 0;
                Row row;
                Cell cell;
                for (EntCleanProduce produce : list) {
                    index++;
                    sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                    row = sheet.createRow(rowIndex);
                    rowIndex++;

                    int cellIndex = 0;
                    // 序号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(index);
                    // 单位名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getEntName());
                    // 名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getCleanName());
                    //编制单位
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getMakeUnit());
                    // 编制时间
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getMakeDate());
                    // 审核重点
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getAuditInfo());
                    // 方案情况
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getPlanInfo());
                    // 预计减排效果
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getMayReduce());
                    // 工作进展
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getWorkProgressDesc());
                    // 计划实施时间
                    cell = CellUtils.getCell(row, cellIndex, style);
                    cell.setCellValue(produce.getPlanDate());
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业清洁生产列表.xlsx", "UTF-8"));
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
    @Log(title = "企业清洁生产基础", businessType = BusinessType.INSERT)
    public AjaxResult insertEntCleanProduce(EntCleanProduce produce) {
        produce.setCleanProduceId(IdUtils.fastSimpleUUID());
        produce.setCreateUser(SecurityUtils.getUserName());
        produce.setCreateTime(LocalDateTime.now());
        produce.setUpdateUser(produce.getCreateUser());
        produce.setUpdateTime(produce.getCreateTime());
        int count = entCleanProduceMapper.insertEntCleanProduce(produce);
        if (count > 0 && null != produce.getAnnexIds() && produce.getAnnexIds().size() > 0) {
            annexService.updateAnnex(produce.getCleanProduceId(), Constants.ANNEX_EntCleanProduce, produce.getAnnexIds());
        }
        return AjaxResult.success(count);
    }

    @Override
    @Log(title = "企业清洁生产基础", businessType = BusinessType.UPDATE)
    public AjaxResult updateEntCleanProduce(EntCleanProduce produce) {
        produce.setUpdateUser(SecurityUtils.getUserName());
        produce.setUpdateTime(LocalDateTime.now());
        return AjaxResult.success(entCleanProduceMapper.updateEntCleanProduce(produce));
    }

    @Override
    @Log(title = "企业清洁生产审核", businessType = BusinessType.UPDATE)
    public AjaxResult entCleanProduceAudit(EntCleanProduce produce) {
        produce.setAuditUser(SecurityUtils.getUserName());
        produce.setAuditTime(LocalDateTime.now());
        return AjaxResult.success(entCleanProduceMapper.entCleanProduceAudit(produce));
    }

    @Override
    @Log(title = "企业清洁生产基础", businessType = BusinessType.DELETE)
    public AjaxResult deleteEntCleanProduceByCleanProduceIds(List<String> cleanProduceIds) {
        if (null == cleanProduceIds || cleanProduceIds.size() < 1) {
            return AjaxResult.error("请求信息为空");
        }
        int count = entCleanProduceMapper.deleteEntCleanProduceByCleanProduceIds(cleanProduceIds);
        if (count > 0) {
            // 删除附件
            cleanProduceIds.forEach( e -> annexService.updateAnnex(e, Constants.ANNEX_EntCleanProduce, null));
        }
        return AjaxResult.success(count);
    }
}
