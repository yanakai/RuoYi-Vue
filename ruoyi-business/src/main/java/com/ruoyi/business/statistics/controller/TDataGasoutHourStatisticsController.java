package com.ruoyi.business.statistics.controller;

import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;
import com.ruoyi.business.statistics.service.ITDataGasoutHourStatisticsService;
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
 * 废气排口--小时报统计数据Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-统计分析", tags = "废气排口--小时报统计数据")
@RestController
@RequestMapping("/business/statistics/dataGasoutHourStatistics")
public class TDataGasoutHourStatisticsController extends BaseController {
    @Autowired
    private ITDataGasoutHourStatisticsService tDataGasoutHourStatisticsService;

    /**
     * 查询废气排口--小时报统计数据列表
     */
    @ApiOperation("获取废气排口--小时报统计数据列表")
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutHourStatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDataGasoutHourStatistics tDataGasoutHourStatistics) {
        startPage();
        List<TDataGasoutHourStatistics> list = tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsList(tDataGasoutHourStatistics);
        return getDataTable(list);
    }

    /**
     * 导出废气排口--小时报统计数据列表
     */
    @ApiOperation("导出废气排口--小时报统计数据列表")
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutHourStatistics:export')")
    @Log(title = "废气排口--小时报统计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDataGasoutHourStatistics tDataGasoutHourStatistics) {
        List<TDataGasoutHourStatistics> list = tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsList(tDataGasoutHourStatistics);
        ExcelUtil<TDataGasoutHourStatistics> util = new ExcelUtil<TDataGasoutHourStatistics>(TDataGasoutHourStatistics.class);
        util.exportExcel(response, list, "废气排口--小时报统计数据数据");
    }

    /**
     * 获取废气排口--小时报统计数据详细信息
     */
//    @ApiOperation("获取废气排口--小时报统计数据详细信息")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutHourStatistics:query')")
//    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsById(id));
    }

    /**
     * 新增废气排口--小时报统计数据
     */
//    @ApiOperation("新增废气排口--小时报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutHourStatistics:add')")
//    @Log(title = "废气排口--小时报统计数据", businessType = BusinessType.INSERT)
//    @PostMapping
    public AjaxResult add(@RequestBody TDataGasoutHourStatistics tDataGasoutHourStatistics) {
        return toAjax(tDataGasoutHourStatisticsService.insertTDataGasoutHourStatistics(tDataGasoutHourStatistics));
    }

    /**
     * 修改废气排口--小时报统计数据
     */
//    @ApiOperation("修改废气排口--小时报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutHourStatistics:edit')")
//    @Log(title = "废气排口--小时报统计数据", businessType = BusinessType.UPDATE)
//    @PutMapping
    public AjaxResult edit(@RequestBody TDataGasoutHourStatistics tDataGasoutHourStatistics) {
        return toAjax(tDataGasoutHourStatisticsService.updateTDataGasoutHourStatistics(tDataGasoutHourStatistics));
    }

    /**
     * 删除废气排口--小时报统计数据
     */
//    @ApiOperation("删除废气排口--小时报统计数据")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutHourStatistics:remove')")
//    @Log(title = "废气排口--小时报统计数据", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tDataGasoutHourStatisticsService.deleteTDataGasoutHourStatisticsByIds(ids));
    }
}
