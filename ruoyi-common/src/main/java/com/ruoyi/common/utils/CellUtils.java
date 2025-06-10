package com.ruoyi.common.utils;

import org.apache.poi.ss.usermodel.*;

public class CellUtils {

    public static Cell getCell(Row row, int index, CellStyle style) {
        Cell cell = row.createCell(index);
        cell.setCellStyle(style);
        return cell;
    }

    public static void copyCellStyle(CellStyle source, CellStyle to) {
        to.cloneStyleFrom(source); // 复制模板样式
        to.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
        to.setBorderTop(BorderStyle.THIN);
        to.setBorderBottom(BorderStyle.THIN);
        to.setBorderLeft(BorderStyle.THIN);
        to.setBorderRight(BorderStyle.THIN);
        to.setTopBorderColor(IndexedColors.BLACK.getIndex());
        to.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        to.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        to.setRightBorderColor(IndexedColors.BLACK.getIndex());
        // 设置背景颜色
        to.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    }
}
