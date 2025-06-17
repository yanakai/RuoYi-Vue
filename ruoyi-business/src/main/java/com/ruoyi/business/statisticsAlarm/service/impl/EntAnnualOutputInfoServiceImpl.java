package com.ruoyi.business.statisticsAlarm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.statisticsAlarm.domain.EntAnnualOutputInfo;
import com.ruoyi.business.statisticsAlarm.domain.EntAnnualOutputInfoReq;
import com.ruoyi.business.statisticsAlarm.mapper.EntAnnualOutputInfoMapper;
import com.ruoyi.business.statisticsAlarm.service.EntAnnualOutputInfoService;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.CellUtils;
import com.ruoyi.common.utils.PageUtils;
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
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

/**
 * 企业年排量信息记录Service业务层处理
 */
@Slf4j
@Service
public class EntAnnualOutputInfoServiceImpl implements EntAnnualOutputInfoService {

    private EntAnnualOutputInfoMapper entAnnualOutputInfoMapper;
    @Autowired
    public void setEntAnnualOutputInfoMapper(EntAnnualOutputInfoMapper entAnnualOutputInfoMapper) {
        this.entAnnualOutputInfoMapper = entAnnualOutputInfoMapper;
    }

    @Override
    public AjaxResult selectEntAnnualOutputInfoList(EntAnnualOutputInfoReq req) {
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new EntAnnualOutputInfoReq();
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
        List<EntAnnualOutputInfo> list = getList(req);
        // 判断报警
        checkAlarm(list);
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    @Override
    public void exportEntAnnualOutputInfo(EntAnnualOutputInfoReq req, HttpServletResponse response) {
        if (null == req) {
            req = new EntAnnualOutputInfoReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/企业年排量数据列表.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            // 添加权限
            if (SecurityUtils.isNotAdmin()) {
                req.setEntCodes(SecurityUtils.getEntCodes());
            }
            List<EntAnnualOutputInfo> list = getList(req);
            // 判断报警
            checkAlarm(list);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex= 4;// 从第5行开始插入

            rowIndex = 3;// 首行
            Row templateRow = sheet.getRow(rowIndex);
            CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
            CellStyle style = workbook.createCellStyle();
            // 复制单元格样式
            CellUtils.copyCellStyle(templateStyle, style);
            if (null != list && list.size() > 0) {
                int index = 0;
                Row row;
                Cell cell;
                for (EntAnnualOutputInfo info : list) {
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
                    // 排口类型
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    if (Constants.POLLUTION_TYPE_GAS.equals(info.getOutPutType())) {
                        cell.setCellValue("废气排口");
                    } else if (Constants.POLLUTION_TYPE_WATER.equals(info.getOutPutType())) {
                        cell.setCellValue("废水排口");
                    } else {
                        cell.setCellValue("");
                    }
                    // 污染因子编码
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getPollutantCode());
                    // 污染因子中文名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getPollutantNameCn());
                    // 污染因子英文名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getPollutantNameEn());
                    // 排放时间（年）
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getAnnualNum());
                    // 年排放量
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getAnnualCount().setScale(3, BigDecimal.ROUND_HALF_UP).toString());
                    // 年排放量限值
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getAnnualEmissionLimit().setScale(3, BigDecimal.ROUND_HALF_UP).toString());
                    // 截止当前排放量限值
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(info.getPresentEmissionLimit().setScale(3, BigDecimal.ROUND_HALF_UP).toString());
                    // 报警类型
                    cell = CellUtils.getCell(row, cellIndex, style);
                    cell.setCellValue(info.getAlarmType());
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业年排量数据列表.xlsx", "UTF-8"));
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

    private List<EntAnnualOutputInfo> getList(EntAnnualOutputInfoReq req) {
        if (null == req) {
            return Collections.emptyList();
        }
        if (Constants.POLLUTION_TYPE_GAS.equals(req.getOutPutType())
                || Constants.POLLUTION_TYPE_WATER.equals(req.getOutPutType())
        ) {
            return entAnnualOutputInfoMapper.selectEntAnnualOutputInfoList(req);
        }
        return Collections.emptyList();
    }

    private void checkAlarm(List<EntAnnualOutputInfo> list) {
        if (null == list || list.size() < 1) {
            return;
        }
        // 判断报警
        for (EntAnnualOutputInfo info : list) {
            if (null != info.getAnnualCount()) {
                // 超过年排量，报警
                if (null != info.getAnnualEmissionLimit() &&
                        info.getAnnualEmissionLimit().compareTo(info.getAnnualCount()) < 0) {
                    info.setAlarmType("已超标");
                    continue;
                }
                // 超过当前排量，预警
                if (null != info.getPresentEmissionLimit() &&
                        info.getPresentEmissionLimit().compareTo(info.getAnnualCount()) < 0) {
                    info.setAlarmType("即将超标");
                }
            }
        }
    }
}
