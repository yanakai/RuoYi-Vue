package com.ruoyi.business.envProt.service.impl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.enums.AnnexTypeEnum;
import com.ruoyi.business.envProt.domain.OtherCertificate;
import com.ruoyi.business.envProt.domain.OtherCertificateReq;
import com.ruoyi.business.envProt.mapper.OtherCertificateMapper;
import com.ruoyi.business.envProt.service.OtherCertificateService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.CellUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.reflect.CurrentSizeUtils;
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
import java.util.List;

/**
 * 其他证书Service业务层处理
 */
@Slf4j
@Service
public class OtherCertificateServiceImpl implements OtherCertificateService {

    private OtherCertificateMapper otherCertificateMapper;
    @Autowired
    public void setOtherCertificateMapper(OtherCertificateMapper otherCertificateMapper) {
        this.otherCertificateMapper = otherCertificateMapper;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    @Override
    public AjaxResult selectOtherCertificateById(String otherId) {
        OtherCertificate info = otherCertificateMapper.selectOtherCertificateById(otherId);
        if (null == info) {
            return AjaxResult.error("其他证书信息为空");
        }
        info.setAnnexInfoList(annexService.selectAnnexList(otherId, AnnexTypeEnum.otherCertificate.name()));
        return AjaxResult.success(info);
    }

    @Override
    public AjaxResult selectOtherCertificateList(OtherCertificateReq req){
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new OtherCertificateReq();
        }
        // 判断权限，非admin账号只能查自己账号
        if (SecurityUtils.isNotAdmin()) {
            req.setUserId(SecurityUtils.getUserId() + "");
        }
        // 分页参数设置
        CurrentSizeUtils.currentAndSize(req, "getCurrent", "setCurrent", 1);
        CurrentSizeUtils.currentAndSize(req, "getSize", "setSize", 10);
        PageHelper.startPage(req.getCurrent(), req.getSize());
        List<OtherCertificate> list = otherCertificateMapper.selectOtherCertificateList(req);
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    @Override
    public void exportOtherCertificate(OtherCertificateReq req, HttpServletResponse response){
        if (null == req) {
            req = new OtherCertificateReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/其他证书模版.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            // 判断权限，非admin账号只能查自己企业的信息
            if (SecurityUtils.isNotAdmin()) {
                req.setUserId(SecurityUtils.getUserId() + "");
            }
            List<OtherCertificate> list = otherCertificateMapper.selectOtherCertificateList(req);
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
                for (OtherCertificate cert : list) {
                    index++;
                    sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                    row = sheet.createRow(rowIndex);
                    rowIndex++;

                    int cellIndex = 0;
                    // 序号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(index);
                    // 证书名称
                    setDefaultVal(row, cellIndex++, cert.getCertName(), style);
                    // 发证机构
                    setDefaultVal(row, cellIndex++, cert.getIssueOffice(), style);
                    // 归属
                    setDefaultVal(row, cellIndex++, cert.getCertBelong(), style);
                    // 归属类型
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    if (null != cert.getBelongType()) {
                        if (1 == cert.getBelongType()) {
                            cell.setCellValue("机构");
                        } else if (2 == cert.getBelongType()) {
                            cell.setCellValue("个人");
                        } else {
                            cell.setCellValue("");
                        }
                    } else {
                        cell.setCellValue("");
                    }
                    // 有效日期
                    if (null != cert.getBeginDate() && null != cert.getEndDate()) {
                        setDefaultVal(row, cellIndex++, cert.getBeginDate().toString() + "至" + cert.getEndDate().toString(), style);
                    } else {
                        setDefaultVal(row, cellIndex++, "", style);
                    }
                    // 发证日期
                    setDefaultVal(row, cellIndex++, null == cert.getIssueDate() ? "" : cert.getIssueDate().toString(), style);
                    // 备注
                    setDefaultVal(row, cellIndex, cert.getRemark(), style);
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("其他证书列表.xlsx", "UTF-8"));
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

    private void setDefaultVal(Row row, int index, String val, CellStyle style) {
        Cell cell = CellUtils.getCell(row, index, style);
        cell.setCellValue(val);
    }

    @Override
    @Log(title = "其他证书", businessType = BusinessType.INSERT)
    public AjaxResult insertOtherCertificate(OtherCertificate info) {
        // userId设置
        if (StringUtils.isEmpty(info.getUserId())) {
            info.setUserId(SecurityUtils.getUserId() + "");
        }
        info.setOtherId(UlidCreator.getMonotonicUlid().toString());
        int count = otherCertificateMapper.insertOtherCertificate(info);
        if (count > 0 && null != info.getAnnexIds() && info.getAnnexIds().size() > 0) {
            annexService.updateAnnex(info.getOtherId(), AnnexTypeEnum.otherCertificate.name(), info.getAnnexIds());
        }
        return AjaxResult.success(info);
    }

    @Override
    @Log(title = "其他证书", businessType = BusinessType.UPDATE)
    public AjaxResult updateOtherCertificate(OtherCertificate info) {
        int count = otherCertificateMapper.updateOtherCertificate(info);
        if (count > 0 ) {
            annexService.updateAnnex(info.getOtherId(), AnnexTypeEnum.otherCertificate.name(), info.getAnnexIds());
        }
        return AjaxResult.success();
    }

    @Override
    @Log(title = "其他证书", businessType = BusinessType.DELETE)
    public AjaxResult deleteOtherCertificateByIds(List<String> ids) {
        if (null == ids || ids.size() < 1) {
            return AjaxResult.error("请求信息为空");
        }
        int count = otherCertificateMapper.deleteOtherCertificateByIds(ids);
        if (count > 0) {
            // 删除附件
            ids.forEach( e -> annexService.updateAnnex(e, AnnexTypeEnum.otherCertificate.name(), null));
        }
        return AjaxResult.success(count);
    }
}
