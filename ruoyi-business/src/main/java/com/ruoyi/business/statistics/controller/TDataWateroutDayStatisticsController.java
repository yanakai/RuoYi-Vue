package com.ruoyi.business.statistics.controller;

import com.ruoyi.business.statistics.domain.TDataWateroutDayStatistics;
import com.ruoyi.business.statistics.service.ITDataWateroutDayStatisticsService;
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
 * 废水排口--日报统计数据Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-统计分析", tags = "废水排口--日报统计数据")
@RestController
@RequestMapping("/business/statistics/dataWateroutDayStatistics")
public class TDataWateroutDayStatisticsController extends BaseController {
    @Autowired
    private ITDataWateroutDayStatisticsService tDataWateroutDayStatisticsService;

    /**
     * 查询废水排口--日报统计数据列表
     */
    @ApiOperation("获取废水排口--日报统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDataWateroutDayStatistics tDataWateroutDayStatistics) {
        startPage();
        List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutDayStatisticsList(tDataWateroutDayStatistics);
        return getDataTable(list);
    }

    /**
     * 导出废水排口--日报统计数据列表
     */
    @ApiOperation("导出废水排口--日报统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:export')")
    @Log(title = "废水排口--日报统计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDataWateroutDayStatistics tDataWateroutDayStatistics) {
        List<TDataWateroutDayStatistics> list = tDataWateroutDayStatisticsService.selectTDataWateroutDayStatisticsList(tDataWateroutDayStatistics);
        ExcelUtil<TDataWateroutDayStatistics> util = new ExcelUtil<TDataWateroutDayStatistics>(TDataWateroutDayStatistics.class);
        util.exportExcel(response, list, "废水排口--日报统计数据数据");
    }

    /**
     * 获取废水排口--日报统计数据详细信息
     */
//    @ApiOperation("获取废水排口--日报统计数据详细信息")
//    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:query')")
//    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tDataWateroutDayStatisticsService.selectTDataWateroutDayStatisticsById(id));
    }

    /**
     * 新增废水排口--日报统计数据
     */
//    @ApiOperation("新增废水排口--日报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:add')")
//    @Log(title = "废水排口--日报统计数据", businessType = BusinessType.INSERT)
//    @PostMapping
    public AjaxResult add(@RequestBody TDataWateroutDayStatistics tDataWateroutDayStatistics) {
        return toAjax(tDataWateroutDayStatisticsService.insertTDataWateroutDayStatistics(tDataWateroutDayStatistics));
    }

    /**
     * 修改废水排口--日报统计数据
     */
//    @ApiOperation("修改废水排口--日报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:edit')")
//    @Log(title = "废水排口--日报统计数据", businessType = BusinessType.UPDATE)
//    @PutMapping
    public AjaxResult edit(@RequestBody TDataWateroutDayStatistics tDataWateroutDayStatistics) {
        return toAjax(tDataWateroutDayStatisticsService.updateTDataWateroutDayStatistics(tDataWateroutDayStatistics));
    }

    /**
     * 删除废水排口--日报统计数据
     */
//    @ApiOperation("删除废水排口--日报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataWateroutDayStatistics:remove')")
//    @Log(title = "废水排口--日报统计数据", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tDataWateroutDayStatisticsService.deleteTDataWateroutDayStatisticsByIds(ids));
    }
}
