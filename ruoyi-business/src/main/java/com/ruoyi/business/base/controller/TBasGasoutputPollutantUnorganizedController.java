package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasGasoutputPollutantUnorganized;
import com.ruoyi.business.base.service.ITBasGasoutputPollutantUnorganizedService;
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
 * 基础信息--企业--废气无组织排口污染物信息Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-企业信息", tags = "企业档案-企业废气无组织排口污染物信息")
@RestController
@RequestMapping("/business/base/gasoutputPollutantUnorganized")
public class TBasGasoutputPollutantUnorganizedController extends BaseController {
    @Autowired
    private ITBasGasoutputPollutantUnorganizedService tBasGasoutputPollutantUnorganizedService;

    /**
     * 查询基础信息--企业--废气无组织排口污染物信息列表
     */
    @ApiOperation("获取废气无组织排口污染物信息列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutputPollutantUnorganized:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized) {
        startPage();
        List<TBasGasoutputPollutantUnorganized> list = tBasGasoutputPollutantUnorganizedService.selectTBasGasoutputPollutantUnorganizedList(tBasGasoutputPollutantUnorganized);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废气无组织排口污染物信息列表
     */
    @ApiOperation("导出废气无组织排口污染物信息列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutputPollutantUnorganized:export')")
    @Log(title = "基础信息--企业--废气无组织排口污染物信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized) {
        List<TBasGasoutputPollutantUnorganized> list = tBasGasoutputPollutantUnorganizedService.selectTBasGasoutputPollutantUnorganizedList(tBasGasoutputPollutantUnorganized);
        ExcelUtil<TBasGasoutputPollutantUnorganized> util = new ExcelUtil<TBasGasoutputPollutantUnorganized>(TBasGasoutputPollutantUnorganized.class);
        util.exportExcel(response, list, "基础信息--企业--废气无组织排口污染物信息数据");
    }

    /**
     * 获取基础信息--企业--废气无组织排口污染物信息详细信息
     */
    @ApiOperation("获取废气无组织排口污染物信息详细信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutputPollutantUnorganized:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasGasoutputPollutantUnorganizedService.selectTBasGasoutputPollutantUnorganizedById(id));
    }

    /**
     * 新增基础信息--企业--废气无组织排口污染物信息
     */
    @ApiOperation("新增废气无组织排口污染物信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutputPollutantUnorganized:add')")
    @Log(title = "基础信息--企业--废气无组织排口污染物信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized) {
        return toAjax(tBasGasoutputPollutantUnorganizedService.insertTBasGasoutputPollutantUnorganized(tBasGasoutputPollutantUnorganized));
    }

    /**
     * 修改基础信息--企业--废气无组织排口污染物信息
     */
    @ApiOperation("修改废气无组织排口污染物信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutputPollutantUnorganized:edit')")
    @Log(title = "基础信息--企业--废气无组织排口污染物信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized) {
        return toAjax(tBasGasoutputPollutantUnorganizedService.updateTBasGasoutputPollutantUnorganized(tBasGasoutputPollutantUnorganized));
    }

    /**
     * 删除基础信息--企业--废气无组织排口污染物信息
     */
    @ApiOperation("删除废气无组织排口污染物信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutputPollutantUnorganized:remove')")
    @Log(title = "基础信息--企业--废气无组织排口污染物信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasGasoutputPollutantUnorganizedService.deleteTBasGasoutputPollutantUnorganizedByIds(ids));
    }
}
