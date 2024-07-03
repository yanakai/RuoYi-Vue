package com.ruoyi.business.statistics.controller;

import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;
import com.ruoyi.business.statistics.service.ITDataWateroutHourStatisticsService;
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
 * 废水排口--小时报统计数据Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-统计分析", tags = "废水排口--小时报统计数据")
@RestController
@RequestMapping("/business/statistics/dataWateroutHourStatistics")
public class TDataWateroutHourStatisticsController extends BaseController {
    @Autowired
    private ITDataWateroutHourStatisticsService tDataWateroutHourStatisticsService;

    /**
     * 查询废水排口--小时报统计数据列表
     */
    @ApiOperation("获取废水排口--小时报统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutHourStatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDataWateroutHourStatistics tDataWateroutHourStatistics) {
        startPage();
        List<TDataWateroutHourStatistics> list = tDataWateroutHourStatisticsService.selectTDataWateroutHourStatisticsList(tDataWateroutHourStatistics);
        return getDataTable(list);
    }

    /**
     * 导出废水排口--小时报统计数据列表
     */
    @ApiOperation("导出废水排口--小时报统计数据列表")
    @PreAuthorize("@ss.hasPermi('business:dataWateroutHourStatistics:export')")
    @Log(title = "废水排口--小时报统计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDataWateroutHourStatistics tDataWateroutHourStatistics) {
        List<TDataWateroutHourStatistics> list = tDataWateroutHourStatisticsService.selectTDataWateroutHourStatisticsList(tDataWateroutHourStatistics);
        ExcelUtil<TDataWateroutHourStatistics> util = new ExcelUtil<TDataWateroutHourStatistics>(TDataWateroutHourStatistics.class);
        util.exportExcel(response, list, "废水排口--小时报统计数据数据");
    }

    /**
     * 获取废水排口--小时报统计数据详细信息
     */
//    @ApiOperation("获取废水排口--小时报统计数据详细信息")
//    @PreAuthorize("@ss.hasPermi('business:dataWateroutHourStatistics:query')")
//    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tDataWateroutHourStatisticsService.selectTDataWateroutHourStatisticsById(id));
    }

    /**
     * 新增废水排口--小时报统计数据
     */
//    @ApiOperation("新增废水排口--小时报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataWateroutHourStatistics:add')")
//    @Log(title = "废水排口--小时报统计数据", businessType = BusinessType.INSERT)
//    @PostMapping
    public AjaxResult add(@RequestBody TDataWateroutHourStatistics tDataWateroutHourStatistics) {
        return toAjax(tDataWateroutHourStatisticsService.insertTDataWateroutHourStatistics(tDataWateroutHourStatistics));
    }

    /**
     * 修改废水排口--小时报统计数据
     */
//    @ApiOperation("修改废水排口--小时报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataWateroutHourStatistics:edit')")
//    @Log(title = "废水排口--小时报统计数据", businessType = BusinessType.UPDATE)
//    @PutMapping
    public AjaxResult edit(@RequestBody TDataWateroutHourStatistics tDataWateroutHourStatistics) {
        return toAjax(tDataWateroutHourStatisticsService.updateTDataWateroutHourStatistics(tDataWateroutHourStatistics));
    }

    /**
     * 删除废水排口--小时报统计数据
     */
//    @ApiOperation("删除废水排口--小时报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataWateroutHourStatistics:remove')")
//    @Log(title = "废水排口--小时报统计数据", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tDataWateroutHourStatisticsService.deleteTDataWateroutHourStatisticsByIds(ids));
    }
}
