package com.ruoyi.business.statisticsAlarm.controller;

import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 分级预警报警 Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-分级预警报警", tags = "分级预警报警")
@RestController
@RequestMapping("/business/statisticsAlarm")
public class StatisticsAlarmController extends BaseController {
    @Autowired
    private ITDataGasoutDayStatisticsService tDataGasoutDayStatisticsService;

    /**
     * 小时数据报警
     */
    @ApiOperation("小时数据报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/hour")
    public TableDataInfo hourList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 小时数据报警导出
     */
    @ApiOperation("小时数据报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "小时数据报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/hour/export")
    public void hourExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "小时数据报警导出");
    }

    /**
     * 排放量报警
     */
    @ApiOperation("排放量报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/emissions")
    public TableDataInfo emissionList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutQuarterStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 排放量报警导出
     */
    @ApiOperation("排放量报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "排放量报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/emission/export")
    public void emissionExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutQuarterStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "排放量报警导出");
    }

    /**
     * 异常报警
     */
    @ApiOperation("异常报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/exception")
    public TableDataInfo exceptionList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 异常报警导出
     */
    @ApiOperation("异常报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "异常报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/exception/export")
    public void exceptionExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "异常报警导出");
    }

    /**
     * 数据缺失报警
     */
    @ApiOperation("数据缺失报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/DataMissing")
    public TableDataInfo dataMissing(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 数据缺失报警导出
     */
    @ApiOperation("数据缺失报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "数据缺失报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/DataMissing/export")
    public void dataMissingExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "数据缺失报警");
    }

    /**
     * 小时数据预警
     */
    @ApiOperation("小时数据预警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/warning/hour")
    public TableDataInfo warningHourList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 小时数据预警导出
     */
    @ApiOperation("小时数据预警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "小时数据预警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/warning/hour/export")
    public void warningHourExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "小时数据预警导出");
    }
}
