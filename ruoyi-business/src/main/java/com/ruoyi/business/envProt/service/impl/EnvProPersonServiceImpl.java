package com.ruoyi.business.envProt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.envProt.domain.*;
import com.ruoyi.business.envProt.mapper.EnvProPersonMapper;
import com.ruoyi.business.envProt.service.EnvProPersonService;
import com.ruoyi.business.enums.AnnexTypeEnum;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.CellUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.reflect.CurrentSizeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 企业环保人员Service业务层处理
 */
@Slf4j
@Service
public class EnvProPersonServiceImpl implements EnvProPersonService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private EnvProPersonMapper envProPersonMapper;
    @Autowired
    public void setEnvProPersonMapper(EnvProPersonMapper envProPersonMapper) {
        this.envProPersonMapper = envProPersonMapper;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    @Override
    public AjaxResult selectProPersonById(String proPersonId) {
        EnvProPerson info = envProPersonMapper.selectProPersonById(proPersonId);
        if (null == info) {
            return AjaxResult.error("企业环保人员信息为空");
        }
        // 判断在职离职
        fillPoll(Collections.singletonList(info), LocalDate.now());
        info.setAnnexInfoList(annexService.selectAnnexList(proPersonId, AnnexTypeEnum.entEnvProPerson.name()));
        return AjaxResult.success(info);
    }

    @Override
    public AjaxResult selectProPersonList(EnvProPersonReq req) {
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new EnvProPersonReq();
        }
        // 判断权限，非admin账号只能查自己企业的信息
        if (SecurityUtils.isNotAdmin()) {
            req.setPermEntCode(SecurityUtils.getEntCode());
        }
        // 分页参数设置
        CurrentSizeUtils.currentAndSize(req, "getCurrent", "setCurrent", 1);
        CurrentSizeUtils.currentAndSize(req, "getSize", "setSize", 10);
        PageHelper.startPage(req.getCurrent(), req.getSize());
        List<EnvProPerson> list = envProPersonMapper.selectProPersonList(req);
        // 判断在职离职
        fillPoll(list, req.getNow());
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    private void fillPoll(List<EnvProPerson> list, LocalDate now) {
        if (null == list || list.size() < 1) {
            return;
        }
        list.forEach( e -> {
            if (null == e.getEntryDate() || e.getEntryDate().isAfter(now)) {
                // 未入职：入职开始时间为空，或者在当前时间之后
                e.setStatus(2);
            } else {
                if (null == e.getResignDate() || e.getResignDate().isAfter(now)) {
                    // 在职：离职时间为空，或离职时间在当前时间之后
                    e.setStatus(1);
                } else {
                    // 离职
                    e.setStatus(0);
                }
            }
        });
    }

    @Override
    public void exportProPerson(EnvProPersonReq req, HttpServletResponse response) {
        if (null == req) {
            req = new EnvProPersonReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/环保人员列表模版.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            // 判断权限，非admin账号只能查自己企业的信息
            if (SecurityUtils.isNotAdmin()) {
                req.setPermEntCode(SecurityUtils.getEntCode());
            }
            List<EnvProPerson> list = envProPersonMapper.selectProPersonList(req);
            // 判断在职离职
            fillPoll(list, req.getNow());
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
                for (EnvProPerson person : list) {
                    index++;
                    sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                    row = sheet.createRow(rowIndex);
                    rowIndex++;

                    int cellIndex = 0;
                    // 序号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(index);
                    // 环保人员姓名
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(person.getProName());
                    // 环保人员编号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(person.getProCode());
                    // 性别
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    if (null != person.getProSex()) {
                        if (0 == person.getProSex()) {
                            cell.setCellValue("男");
                        } else if (1 == person.getProSex()) {
                            cell.setCellValue("女");
                        } else {
                            cell.setCellValue("");
                        }
                    } else {
                        cell.setCellValue("");
                    }
                    // 出生日期
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(null == person.getBirthDate() ? "" : person.getBirthDate().toString());
                    // 联系电话
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(person.getTelPhone());
                    // 职称/证书
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(person.getProTitle());
                    // 岗位
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(person.getProPost());
                    // 住址
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(person.getAddress());
                    // 入职时间
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(null == person.getEntryDate() ? "" : person.getEntryDate().toString());
                    // 离职时间
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(null == person.getResignDate() ? "" : person.getResignDate().toString());
                    // 备注
                    cell = CellUtils.getCell(row, cellIndex, style);
                    cell.setCellValue(person.getRemark());
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("环保人员列表.xlsx", "UTF-8"));
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
    public void downloadTemplate(HttpServletResponse response) {
        OutputStream outputStream = null;
        try {
            String templatePath = "template/环保人员列表模版.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex;// 从第5行开始插入

            rowIndex = 2;// 首行
            Row templateRow = sheet.getRow(rowIndex);
            CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
            CellStyle style = workbook.createCellStyle();
            // 复制单元格样式
            CellUtils.copyCellStyle(templateStyle, style);
            Row row;
            Cell cell;
            sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
            row = sheet.createRow(rowIndex);

            int cellIndex = 0;
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(1);
            setDefaultVal(row, cellIndex++, "xxx", style);
            setDefaultVal(row, cellIndex++, "xxx", style);
            setDefaultVal(row, cellIndex++, "男", style);
            setDefaultVal(row, cellIndex++, LocalDate.now().toString(), style);
            setDefaultVal(row, cellIndex++, "1234567889", style);
            setDefaultVal(row, cellIndex++, "xxx", style);
            setDefaultVal(row, cellIndex++, "xxx", style);
            setDefaultVal(row, cellIndex++, "xxx", style);
            setDefaultVal(row, cellIndex++, LocalDate.now().toString(), style);
            setDefaultVal(row, cellIndex++, LocalDate.now().toString(), style);
            setDefaultVal(row, cellIndex, "xxx", style);

            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("环保人员列表模板.xlsx", "UTF-8"));
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
    public AjaxResult importTemplate(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (StringUtils.isBlank(fileName)) {
            return AjaxResult.error("导入文件名称为空");
        }
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (!".xlsx".equals(fileType)) {
            return AjaxResult.error("不支持 " + fileType + " 文件类型");
        }
        List<EnvProPerson> infos = new ArrayList<>();
        try {
            String entCode = SecurityUtils.getEntCode();
            Workbook wb = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = wb.getSheetAt(0);
            // 过滤表头行，第一、二行
            List<String> errs = new ArrayList<>();
            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                // 获取当前行的数据
                Row row = sheet.getRow(i);
                if (null == row)
                    continue;
                int index = 1;// 略过序号列
                EnvProPerson info = new EnvProPerson();
                info.setEntCode(entCode);
                info.setProPersonId(UlidCreator.getMonotonicUlid().toString());

                String value = getCellStringVal(row, index++);
                if (null == value) {
                    // 人员姓名为略过
                    continue;
                } else {
                    info.setProName(value);
                }
                value = getCellStringVal(row, index++);
                if (null == value) {
                    errs.add("第" + (i + 1) + "行员工编号为空");
                } else {
                    info.setProCode(value);
                }
                value = getCellStringVal(row, index++);
                if ("男".equals(value)) {
                    info.setProSex(0);
                } else if ("女".equals(value)){
                    info.setProSex(1);
                }
                value = getCellStringDateVal(row, index++);
                if (null != value) {
                    LocalDate dateTime = strToLocalDate(value);
                    if (null == dateTime) {
                        errs.add("第" + (i + 1) + "行出生日期格式错误");
                    } else {
                        info.setBirthDate(dateTime);
                    }
                }
                value = getCellStringVal(row, index++);
                if (null == value) {
                    errs.add("第" + (i + 1) + "行联系电话为空");
                } else {
                    info.setTelPhone(value);
                }
                value = getCellStringVal(row, index++);
                if (null != value) {
                    info.setProTitle(value);
                }
                value = getCellStringVal(row, index++);
                if (null != value) {
                    info.setProPost(value);
                }
                value = getCellStringVal(row, index++);
                if (null != value) {
                    info.setAddress(value);
                }
                value = getCellStringDateVal(row, index++);
                if (null != value) {
                    LocalDate dateTime = strToLocalDate(value);
                    if (null == dateTime) {
                        errs.add("第" + (i + 1) + "行入职时间格式错误");
                    } else {
                        info.setEntryDate(dateTime);
                    }
                }
                value = getCellStringDateVal(row, index++);
                if (null != value) {
                    LocalDate dateTime = strToLocalDate(value);
                    if (null == dateTime) {
                        errs.add("第" + (i + 1) + "行离职时间格式错误");
                    } else {
                        info.setResignDate(dateTime);
                    }
                }
                value = getCellStringVal(row, index);
                if (null != value) {
                    info.setRemark(value);
                }
                infos.add(info);
            }
            if (errs.size() > 0) {
                return AjaxResult.error("文件内容异常，请检查", errs);
            }
            // 插入数据
            if (infos.size() > 0) {
                envProPersonMapper.batchInsertProPerson(infos);
            }
        } catch (Exception e) {
            return AjaxResult.error("导入文件解析失败", e.getMessage());
        }
        return AjaxResult.success(infos);
    }

    private LocalDate strToLocalDate(String value) {
        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            return null;
        }
    }

    private String getCellStringVal(Row row, int index) {
        Cell cell = row.getCell(index);
        if (null == cell) {
            return null;
        }
        String value = null;
        if (CellType.NUMERIC.equals(cell.getCellType())) {
            value = (long)cell.getNumericCellValue() + "";
        } else if (CellType.STRING.equals(cell.getCellType())) {
            value = cell.getStringCellValue().trim();
        }
        return value;
    }

    private String getCellStringDateVal(Row row, int index) {
        Cell cell = row.getCell(index);
        if (null == cell) {
            return null;
        }
        String value = null;
        if (CellType.NUMERIC.equals(cell.getCellType())) {
            if (DateUtil.isCellDateFormatted(cell)) {
                // 处理格式化的日期单元格
                Date javaDate = cell.getDateCellValue();
                value = sdf.format(javaDate);
            } else {
                // 处理Excel内部日期数值
                double excelDateValue = cell.getNumericCellValue();
                // Excel的日期基准是1900-01-01（Windows版）
                // 注意：Excel错误地将1900年视为闰年
                LocalDate baseDate = LocalDate.of(1899, 12, 30);
                // 调整Excel的日期计算错误（1900年不是闰年）
                if (excelDateValue >= 61) {
                    excelDateValue -= 1; // 修正Excel的闰年错误
                }
                value = baseDate.plusDays((long) excelDateValue).toString();
            }
        } else if (CellType.STRING.equals(cell.getCellType())) {
            value = cell.getStringCellValue().trim();
        }
        return value;
    }

    @Override
    @Log(title = "企业环保人员", businessType = BusinessType.INSERT)
    public AjaxResult insertProPerson(EnvProPerson info) {
        // 判断权限，非admin账号只能查自己企业的信息
        if (SecurityUtils.isNotAdmin()) {
            info.setEntCode(SecurityUtils.getEntCode());
        }
        info.setProPersonId(UlidCreator.getMonotonicUlid().toString());
        int count = envProPersonMapper.insertProPerson(info);
        if (count > 0 && null != info.getAnnexIds() && info.getAnnexIds().size() > 0) {
            annexService.updateAnnex(info.getProPersonId(), AnnexTypeEnum.entEnvProPerson.name(), info.getAnnexIds());
        }
        return AjaxResult.success(info);
    }

    @Override
    @Log(title = "企业环保人员", businessType = BusinessType.UPDATE)
    public AjaxResult updateProPerson(EnvProPerson info) {
        envProPersonMapper.updateProPerson(info);
        return AjaxResult.success();
    }

    @Override
    @Log(title = "企业环保人员", businessType = BusinessType.DELETE)
    public AjaxResult deleteProPersonByIds(List<String> ids) {
        if (null == ids || ids.size() < 1) {
            return AjaxResult.error("请求信息为空");
        }
        int count = envProPersonMapper.deleteProPersonByIds(ids);
        if (count > 0) {
            // 删除附件
            ids.forEach( e -> annexService.updateAnnex(e, AnnexTypeEnum.entEnvProPerson.name(), null));
        }
        return AjaxResult.success(count);
    }
}
