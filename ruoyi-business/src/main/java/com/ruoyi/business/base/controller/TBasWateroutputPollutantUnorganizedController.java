package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasWateroutputPollutantUnorganized;
import com.ruoyi.business.base.service.ITBasWateroutputPollutantUnorganizedService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 基础信息--企业--废水无组织排口污染物信息Controller
 *
 * @author lx
 * @date 2024-07-04
 */
//类标记无用，删除
@Deprecated
//@Api(value = "业务模块-企业信息", tags = "基础信息-企业废水无组织排口污染物信息")
//@RestController
//@RequestMapping("/business/base/wateroutputPollUnorganized")
public class TBasWateroutputPollutantUnorganizedController extends BaseController {
    @Autowired
    private ITBasWateroutputPollutantUnorganizedService tBasWateroutputPollutantUnorganizedService;

    /**
     * 查询基础信息--企业--废水无组织排口污染物信息列表
     */
    @ApiOperation("获取废水无组织排口污染物信息列表")
    @PreAuthorize("@ss.hasPermi('business:wateroutputPollUnorganized:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized) {
        startPage();
        List<TBasWateroutputPollutantUnorganized> list = tBasWateroutputPollutantUnorganizedService.selectTBasWateroutputPollutantUnorganizedList(tBasWateroutputPollutantUnorganized);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废水无组织排口污染物信息列表
     */
    @ApiOperation("导出废水无组织排口污染物信息列表")
    @PreAuthorize("@ss.hasPermi('business:wateroutputPollUnorganized:export')")
    @Log(title = "基础信息--企业--废水无组织排口污染物信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized) {
        List<TBasWateroutputPollutantUnorganized> list = tBasWateroutputPollutantUnorganizedService.selectTBasWateroutputPollutantUnorganizedList(tBasWateroutputPollutantUnorganized);
        ExcelUtil<TBasWateroutputPollutantUnorganized> util = new ExcelUtil<TBasWateroutputPollutantUnorganized>(TBasWateroutputPollutantUnorganized.class);
        util.exportExcel(response, list, "基础信息--企业--废水无组织排口污染物信息数据");
    }

    /**
     * 获取基础信息--企业--废水无组织排口污染物信息详细信息
     */
    @ApiOperation("获取废水无组织排口污染物信息详细信息")
    @PreAuthorize("@ss.hasPermi('business:wateroutputPollUnorganized:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasWateroutputPollutantUnorganizedService.selectTBasWateroutputPollutantUnorganizedById(id));
    }

    /**
     * 新增基础信息--企业--废水无组织排口污染物信息
     */
    @ApiOperation("新增废水无组织排口污染物信息")
    @PreAuthorize("@ss.hasPermi('business:wateroutputPollUnorganized:add')")
    @Log(title = "基础信息--企业--废水无组织排口污染物信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized) {
        return toAjax(tBasWateroutputPollutantUnorganizedService.insertTBasWateroutputPollutantUnorganized(tBasWateroutputPollutantUnorganized));
    }

    /**
     * 修改基础信息--企业--废水无组织排口污染物信息
     */
    @ApiOperation("修改废水无组织排口污染物信息")
    @PreAuthorize("@ss.hasPermi('business:wateroutputPollUnorganized:edit')")
    @Log(title = "基础信息--企业--废水无组织排口污染物信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized) {
        return toAjax(tBasWateroutputPollutantUnorganizedService.updateTBasWateroutputPollutantUnorganized(tBasWateroutputPollutantUnorganized));
    }

    /**
     * 删除基础信息--企业--废水无组织排口污染物信息
     */
    @ApiOperation("删除废水无组织排口污染物信息")
    @PreAuthorize("@ss.hasPermi('business:wateroutputPollUnorganized:remove')")
    @Log(title = "基础信息--企业--废水无组织排口污染物信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasWateroutputPollutantUnorganizedService.deleteTBasWateroutputPollutantUnorganizedByIds(ids));
    }
}
