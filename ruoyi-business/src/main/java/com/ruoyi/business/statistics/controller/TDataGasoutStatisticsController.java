package com.ruoyi.business.statistics.controller;

import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 废气排口--日报统计数据Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-统计分析", tags = "废气排口--月季度年统计数据")
@RestController
@RequestMapping("/business/statistics/dataGasoutStatistics")
public class TDataGasoutStatisticsController extends BaseController {
    @Autowired
    private ITDataGasoutDayStatisticsService tDataGasoutDayStatisticsService;

    /**
     * 查询废气排口--月统计数据列表
     */
    @ApiOperation("月监测报表数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/month/list")
    public TableDataInfo monthList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 导出废气排口--月报统计数据列表
     */
    @ApiOperation("导出月监测报表数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "废气排口--月监测报表数据列表", businessType = BusinessType.EXPORT)
    @PostMapping("/month/export")
    public void monthExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "废气排口--月监测报表数据");
    }

    /**
     * 查询废气排口--季度统计数据列表
     */
    @ApiOperation("季度监测报表数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/quarter/list")
    public TableDataInfo quarterList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutQuarterStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 导出废气排口--季度报统计数据列表
     */
    @ApiOperation("导出季度监测报表数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "废气排口--季度监测报表数据列表", businessType = BusinessType.EXPORT)
    @PostMapping("/quarter/export")
    public void quarterExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutQuarterStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "废气排口--季度监测报表数据");
    }

    /**
     * 查询废气排口--年统计数据列表
     */
    @ApiOperation("年监测报表数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/year/list")
    public TableDataInfo yearList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 导出废气排口--年报统计数据列表
     */
    @ApiOperation("导出年监测报表数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "废气排口--年监测报表数据列表", businessType = BusinessType.EXPORT)
    @PostMapping("/year/export")
    public void yearExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "废气排口--年监测报表数据");
    }


}
