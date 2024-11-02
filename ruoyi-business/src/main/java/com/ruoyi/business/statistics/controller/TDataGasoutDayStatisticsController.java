package com.ruoyi.business.statistics.controller;

import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
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
@Api(value = "业务模块-统计分析", tags = "废气排口--日报统计数据")
@RestController
@RequestMapping("/business/statistics/dataGasoutDayStatistics")
public class TDataGasoutDayStatisticsController extends BaseController {
    @Autowired
    private ITDataGasoutDayStatisticsService tDataGasoutDayStatisticsService;

    /**
     * 查询废气排口--日报统计数据列表
     */
    @ApiOperation("获取废气排口--日报统计数据列表")
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDataGasoutDayStatistics tDataGasoutDayStatistics) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutDayStatisticsList(tDataGasoutDayStatistics);
        return getDataTable(list);
    }

    /**
     * 导出废气排口--日报统计数据列表
     */
    @ApiOperation("导出废气排口--日报统计数据列表")
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "废气排口--日报统计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDataGasoutDayStatistics tDataGasoutDayStatistics) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutDayStatisticsList(tDataGasoutDayStatistics);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "废气排口--日报统计数据数据");
    }

    /**
     * 获取废气排口--日报统计数据详细信息
     */
//    @ApiOperation("获取废气排口--日报统计数据详细信息")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:query')")
//    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tDataGasoutDayStatisticsService.selectTDataGasoutDayStatisticsById(id));
    }

    /**
     * 新增废气排口--日报统计数据
     */
//    @ApiOperation("新增废气排口--日报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:add')")
//    @Log(title = "废气排口--日报统计数据", businessType = BusinessType.INSERT)
//    @PostMapping
    public AjaxResult add(@RequestBody TDataGasoutDayStatistics tDataGasoutDayStatistics) {
        return toAjax(tDataGasoutDayStatisticsService.insertTDataGasoutDayStatistics(tDataGasoutDayStatistics));
    }

    /**
     * 修改废气排口--日报统计数据
     */
//    @ApiOperation("修改废气排口--日报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:edit')")
//    @Log(title = "废气排口--日报统计数据", businessType = BusinessType.UPDATE)
//    @PutMapping
    public AjaxResult edit(@RequestBody TDataGasoutDayStatistics tDataGasoutDayStatistics) {
        return toAjax(tDataGasoutDayStatisticsService.updateTDataGasoutDayStatistics(tDataGasoutDayStatistics));
    }

    /**
     * 删除废气排口--日报统计数据
     */
//    @ApiOperation("删除废气排口--日报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:remove')")
//    @Log(title = "废气排口--日报统计数据", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tDataGasoutDayStatisticsService.deleteTDataGasoutDayStatisticsByIds(ids));
    }
}
