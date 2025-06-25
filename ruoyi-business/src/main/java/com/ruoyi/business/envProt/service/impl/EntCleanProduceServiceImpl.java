package com.ruoyi.business.envProt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.enums.AnnexTypeEnum;
import com.ruoyi.business.envProt.domain.EntCleanProduce;
import com.ruoyi.business.envProt.domain.EntCleanProduceReq;
import com.ruoyi.business.envProt.mapper.EntCleanProduceMapper;
import com.ruoyi.business.envProt.service.EntCleanProduceService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.CellUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.reflect.CurrentSizeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

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
    public AjaxResult selectCleanProduceById(String cleanProduceId) {
        EntCleanProduce info = entCleanProduceMapper.selectCleanProduceById(cleanProduceId);
        if (null == info) {
            return AjaxResult.error("清洁生产信息为空");
        }
        info.setAnnexInfoList(annexService.selectAnnexList(cleanProduceId, AnnexTypeEnum.entCleanProduce.name()));
        return AjaxResult.success(info);
    }

    @Override
    public AjaxResult selectCleanProduceList(EntCleanProduceReq req) {
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new EntCleanProduceReq();
        }
        // 添加权限
        if (SecurityUtils.isNotAdmin()) {
            req.setPermEntCode(SecurityUtils.getEntCode());
        }
        // 分页参数设置
        CurrentSizeUtils.currentAndSize(req, "getCurrent", "setCurrent", 1);
        CurrentSizeUtils.currentAndSize(req, "getSize", "setSize", 10);
        PageHelper.startPage(req.getCurrent(), req.getSize());
        List<EntCleanProduce> list = entCleanProduceMapper.selectCleanProduceList(req);
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    @Override
    @Log(title = "企业清洁生产基础", businessType = BusinessType.EXPORT)
    public void exportCleanProduce(EntCleanProduceReq req, HttpServletResponse response) {
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
                req.setPermEntCode(SecurityUtils.getEntCode());
            }
            List<EntCleanProduce> list = entCleanProduceMapper.selectCleanProduceList(req);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex;// 从第5行开始插入

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
                    // 名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getCleanName());
                    // 编制单位
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getEntName());
                    // 编制时间
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(null == produce.getMakeDate() ? "" : produce.getMakeDate().toString());
                    // 审核重点
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getAuditFocus());
                    // 方案情况
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getPlanInfo());
                    // 减排效果
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getReduceEffect());
                    // 工作进展
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(produce.getWorkProgress());
                    // 实施时间
                    cell = CellUtils.getCell(row, cellIndex, style);
                    cell.setCellValue(null == produce.getEffectiveDate() ? "" : produce.getEffectiveDate().toString());
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
                    log.error("outputStream close", e);
                }
            }
        }
    }

    @Override
    @Log(title = "企业清洁生产基础", businessType = BusinessType.INSERT)
    public AjaxResult insertCleanProduce(EntCleanProduce produce) {
        if (StringUtils.isEmpty(produce.getEntCode())) {
            produce.setEntCode(SecurityUtils.getEntCode());
        }
        produce.setCleanProduceId(UlidCreator.getMonotonicUlid().toString());
        int count = entCleanProduceMapper.insertCleanProduce(produce);
        if (count > 0 && null != produce.getAnnexIds() && produce.getAnnexIds().size() > 0) {
            annexService.updateAnnex(produce.getCleanProduceId(), AnnexTypeEnum.entCleanProduce.name(), produce.getAnnexIds());
        }
        return AjaxResult.success(count);
    }

    @Override
    @Log(title = "企业清洁生产基础", businessType = BusinessType.UPDATE)
    public AjaxResult updateCleanProduce(EntCleanProduce produce) {
        int count = entCleanProduceMapper.updateCleanProduce(produce);
        if (count > 0 ) {
            annexService.updateAnnex(produce.getCleanProduceId(), AnnexTypeEnum.entCleanProduce.name(), produce.getAnnexIds());
        }
        return AjaxResult.success();
    }

    @Override
    @Log(title = "企业清洁生产基础", businessType = BusinessType.DELETE)
    public AjaxResult deleteCleanProduceByIds(List<String> ids) {
        if (null == ids || ids.size() < 1) {
            return AjaxResult.error("请求信息为空");
        }
        int count = entCleanProduceMapper.deleteCleanProduceByIds(ids);
        if (count > 0) {
            // 删除附件
            ids.forEach( e -> annexService.updateAnnex(e, AnnexTypeEnum.entCleanProduce.name(), null));
        }
        return AjaxResult.success(count);
    }
}
