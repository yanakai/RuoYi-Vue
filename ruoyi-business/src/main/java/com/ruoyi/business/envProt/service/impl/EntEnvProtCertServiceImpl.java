package com.ruoyi.business.envProt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.envProt.domain.EntEnvProtCert;
import com.ruoyi.business.envProt.domain.EntEnvProtCertReq;
import com.ruoyi.business.envProt.mapper.EntEnvProtCertMapper;
import com.ruoyi.business.envProt.service.EntEnvProtCertService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.CellUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.SecurityUtils;
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
import java.util.List;

/**
 * 企业环保证书基础Service业务层处理
 */
@Slf4j
@Service
public class EntEnvProtCertServiceImpl implements EntEnvProtCertService {

    @Autowired
    private EntEnvProtCertMapper entEnvProtCertMapper;
    @Autowired
    public void setEntEnvProtCertMapper(EntEnvProtCertMapper entEnvProtCertMapper) {
        this.entEnvProtCertMapper = entEnvProtCertMapper;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    @Override
    public AjaxResult selectEntEnvProtCertList(EntEnvProtCertReq req) {
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new EntEnvProtCertReq();
        }
        if (null == req.getCurrent() || req.getCurrent() < 1) {
            req.setCurrent(1);
        }
        if (null == req.getSize() || req.getSize() < 1) {
            req.setSize(10);
        }
        // 添加权限
        if (SecurityUtils.isNotAdmin()) {
            req.setEntCodes(SecurityUtils.getEntCodes());
        }
        PageHelper.startPage(req.getCurrent(), req.getSize());
        List<EntEnvProtCert> list = entEnvProtCertMapper.selectEntEnvProtCertList(req);
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    @Override
    @Log(title = "企业环保证书基础", businessType = BusinessType.EXPORT)
    public void exportEntEnvProtCert(EntEnvProtCertReq req, HttpServletResponse response) {
        if (null == req) {
            req = new EntEnvProtCertReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/环保证书列表模版.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            // 添加权限
            if (SecurityUtils.isNotAdmin()) {
                req.setEntCodes(SecurityUtils.getEntCodes());
            }
            List<EntEnvProtCert> list = entEnvProtCertMapper.selectEntEnvProtCertList(req);
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
                for (EntEnvProtCert cert : list) {
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
                    cell.setCellValue(cert.getEntName());
                    // 证书名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(cert.getProtCertName());
                    // 发证机构
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(cert.getIssueOffice());
                    // 有效期
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(cert.getBeginDate() + "至" + cert.getEndDate());
                    // 发证日期
                    cell = CellUtils.getCell(row, cellIndex, style);
                    cell.setCellValue(cert.getIssueDate());
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业环保证书列表.xlsx", "UTF-8"));
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
    @Log(title = "企业环保证书基础", businessType = BusinessType.INSERT)
    public AjaxResult insertEntEnvProtCert(EntEnvProtCert cert) {
        cert.setProtCertId(IdUtils.fastSimpleUUID());
        cert.setCreateUser(SecurityUtils.getUserName());
        cert.setCreateTime(LocalDateTime.now());
        cert.setUpdateUser(cert.getCreateUser());
        cert.setUpdateTime(cert.getCreateTime());
        int count = entEnvProtCertMapper.insertEntEnvProtCert(cert);
        if (count > 0 && null != cert.getAnnexIds() && cert.getAnnexIds().size() > 0) {
            annexService.updateAnnex(cert.getProtCertId(), Constants.ANNEX_EntEnvProtCert, cert.getAnnexIds());
        }
        return AjaxResult.success(count);
    }

    @Override
    @Log(title = "企业环保证书基础", businessType = BusinessType.UPDATE)
    public AjaxResult updateEntEnvProtCert(EntEnvProtCert cert) {
        cert.setUpdateUser(SecurityUtils.getUserName());
        cert.setUpdateTime(LocalDateTime.now());
        return AjaxResult.success(entEnvProtCertMapper.updateEntEnvProtCert(cert));
    }

    @Override
    @Log(title = "企业环保证书基础", businessType = BusinessType.DELETE)
    public AjaxResult deleteEntEnvProtCertByProtCertIds(List<String> protCertIds) {
        if (null == protCertIds || protCertIds.size() < 1) {
            return AjaxResult.error("请求信息为空");
        }
        int count = entEnvProtCertMapper.deleteEntEnvProtCertByProtCertIds(protCertIds);
        if (count > 0) {
            // 删除附件
            protCertIds.forEach( e -> annexService.updateAnnex(e, Constants.ANNEX_EntEnvProtCert, null));
        }
        return AjaxResult.success(count);
    }
}
