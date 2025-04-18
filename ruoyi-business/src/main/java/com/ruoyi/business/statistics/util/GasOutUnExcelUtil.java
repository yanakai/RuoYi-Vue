package com.ruoyi.business.statistics.util;

import cn.hutool.core.map.MapUtil;
import com.ruoyi.business.statistics.dto.PollutantInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

@Slf4j
public class GasOutUnExcelUtil {
    /** 通用单元格格式 */
    private static CellStyle style;
    /** 黑色加粗单元格格式 */
    private static CellStyle boldNormalStyle;

    /**
     * 导出废气无组织监测数据
     */
    public static void exportGasOutUnFile(HttpServletResponse response, List<PollutantInfo> codes,
                                       List<Map<String, Object>> list, String fileName, String sheetName){
        try {
            //内存中保留1000条数据，以免内存溢出，其余写入硬盘
            SXSSFWorkbook workbook = new SXSSFWorkbook();
            // 初始化单元格样式
            initStyle(workbook);

            //获取该工作区的第一个sheet
            SXSSFSheet sheet1 = workbook.createSheet(sheetName);
            int excelRow = 0;
            // 创建首行
            Row row = sheet1.createRow(excelRow ++);

            //创建标题行
            List<String> titleNames = new ArrayList<>();
            titleNames.add("监测时间");
            for (PollutantInfo info : codes) {
                if (StringUtils.isEmpty(info.getPollutantUnitCn())) {
                    titleNames.add(info.getPollutantNameCn());
                } else {
                    titleNames.add(info.getPollutantNameCn() + "（" + info.getPollutantUnitCn() + "）");
                }
            }
            int titleNameSize = titleNames.size();
            Cell cell = null;
            for(int i = 0; i < titleNameSize; i++){
                //创建该行下的每一列，并写入标题数据
                cell = getBoldNormalCell(row, i);
                cell.setCellValue(titleNames.get(i));
            }
            // 自动调整列宽
            sheet1.trackAllColumnsForAutoSizing();
            if (null != cell) {
                sheet1.autoSizeColumn(0, true);
                sheet1.setColumnWidth(0, sheet1.getColumnWidth(0) * 2);
                for (int i = 1; i <= cell.getColumnIndex(); i++) {
                    sheet1.autoSizeColumn(i, true);
                    sheet1.setColumnWidth(i, sheet1.getColumnWidth(i) * 12 / 10);
                }
            }
            int j;
            // 设置内容行
            if (null != list && list.size() > 0) {
                for (Map<String, Object> map : list) {
                    j = 0;
                    row = sheet1.createRow(excelRow ++);
                    cell = getCell(row, j++);
                    cell.setCellValue(MapUtil.getStr(map, "monitorTime")); // 监测时间
                    Double val;
                    for (PollutantInfo info : codes) {
                        val = MapUtil.getDouble(map, info.getPollutantCode());
                        cell = getCell(row, j++);
                        if (null != val) {
                            cell.setCellValue(bigDecimal(val, 2)); // 污染物数据
                        } else {
                            cell.setCellValue(""); // 污染物数据为空
                        }
                    }
                }
            }
            // 将excel数据写入流中
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            log.error("download error", e);
        }
    }

    /** 精度转换 */
    public static double bigDecimal(double value, int scale){
        if(scale < 0)
            return value;
        return BigDecimal.valueOf(value).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private static Cell getCell(Row row, int index){
        Cell cell = row.createCell(index);
        cell.setCellStyle(GasOutUnExcelUtil.style);
        return cell;
    }

    private static Cell getBoldNormalCell(Row row, int index){
        Cell cell = row.createCell(index);
        cell.setCellStyle(GasOutUnExcelUtil.boldNormalStyle);
        return cell;
    }

    /** 初始化单元格样式 */
    private static void initStyle(SXSSFWorkbook workbook) {
        // 创建通用单元格格式
        Font font = getFont(workbook);
        font.setColor(font.COLOR_NORMAL);
        font.setBold(false);
        CellStyle style = getStyle(workbook);
        style.setFont(font);
        GasOutUnExcelUtil.style = style;
        // 创建黑色加粗单元格格式
        font = getFont(workbook);
        font.setColor(font.COLOR_NORMAL);
        font.setBold(true);
        style = getStyle(workbook);
        style.setFont(font);
        GasOutUnExcelUtil.boldNormalStyle = style;
    }

    /** 创建字体格式 */
    private static Font getFont(SXSSFWorkbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("宋体");
        return font;
    }

    /** 创建单元格格式 */
    private static CellStyle getStyle(SXSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setFillPattern(FillPatternType.NO_FILL);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 设置所有边框
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
}