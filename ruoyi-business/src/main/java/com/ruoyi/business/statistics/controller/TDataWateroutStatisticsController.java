package com.ruoyi.business.statistics.controller;

import com.ruoyi.business.statistics.domain.TDataWateroutDayStatistics;
import com.ruoyi.business.statistics.dto.TDataWateroutMonthStatistics;
import com.ruoyi.business.statistics.dto.TDataWateroutStatisticsDTO;
import com.ruoyi.business.statistics.dto.TDataWateroutYearStatistics;
import com.ruoyi.business.statistics.service.ITDataWateroutDayStatisticsService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 废水排口--日报统计数据Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-统计分析", tags = "废水排口--月季度年统计数据")
@RestController
@RequestMapping("/business/statistics/dataWateroutStatistics")
public class TDataWateroutStatisticsController extends BaseController {
    @Autowired
    private ITDataWateroutDayStatisticsService tDataWateroutDayStatisticsService;

    /**
     * 查询废水排口--月统计数据列表
     */
    @ApiOperation("获取废水排口--月统计数据列表")
    @ApiParam(name = "outPutCode", value = "废水排口编号")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:list')")
    @GetMapping("/monthList")
    public TableDataInfo monthList(TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO) {
        startPage();
        List<TDataWateroutMonthStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutMonthStatisticsList(tDataWateroutDayStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 导出废水排口--日报统计数据列表
     */
    @ApiOperation("导出废水排口--月统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:export')")
    @Log(title = "废水排口--日报统计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/month/export")
    public void monthExport(HttpServletResponse response, TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO) {
        List<TDataWateroutMonthStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutMonthStatisticsList(tDataWateroutDayStatisticsDTO);
        ExcelUtil<TDataWateroutMonthStatistics> util = new ExcelUtil<TDataWateroutMonthStatistics>(TDataWateroutMonthStatistics.class);
        util.exportExcel(response, list, "废水排口--日报统计数据数据");
    }

    /**
     * 查询废水排口--季度统计数据列表
     */
    @ApiOperation("获取废水排口--季度统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:list')")
    @GetMapping("/quarterList")
    public TableDataInfo quarterList(TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO) {
        startPage();
        List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutQuarterStatisticsList(tDataWateroutDayStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 导出废水排口--季度统计数据列表
     */
    @ApiOperation("导出废水排口--季度统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:export')")
    @Log(title = "废水排口--季度统计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/quarter/export")
    public void quarterExport(HttpServletResponse response, TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO) {
        List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutQuarterStatisticsList(tDataWateroutDayStatisticsDTO);
        ExcelUtil<TDataWateroutDayStatistics> util = new ExcelUtil<TDataWateroutDayStatistics>(TDataWateroutDayStatistics.class);
        util.exportExcel(response, list, "废水排口--季度统计数据数据");
    }

    /**
     * 查询废水排口--年统计数据列表
     */
    @ApiOperation("获取废水排口--年统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:list')")
    @GetMapping("/yearList")
    public TableDataInfo yearList(TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO) {
        startPage();
        List<TDataWateroutYearStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutYearStatisticsList(tDataWateroutDayStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 导出废水排口--年统计数据列表
     */
    @ApiOperation("导出废水排口--年统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:export')")
    @Log(title = "废水排口--年统计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/year/export")
    public void yearExport(HttpServletResponse response, TDataWateroutStatisticsDTO tDataWateroutDayStatisticsDTO) {
        List<TDataWateroutYearStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutYearStatisticsList(tDataWateroutDayStatisticsDTO);
        ExcelUtil<TDataWateroutYearStatistics> util = new ExcelUtil<TDataWateroutYearStatistics>(TDataWateroutYearStatistics.class);
        util.exportExcel(response, list, "废水排口--年统计数据数据");
    }
}
