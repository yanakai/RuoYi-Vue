package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasGasoutputPollutant;
import com.ruoyi.business.base.service.ITBasGasoutputPollutantService;
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
 * 基础信息--企业--废气排口污染物基本信息Controller
 *
 * @author lx
 * @date 2024-06-27
 */
@Api(value = "业务模块-企业--废气排口污染物基本信息", tags = "企业档案-废气排口污染物基本信息")
@RestController
@RequestMapping("/business/base/gasoutPutPollutant")
public class TBasGasoutputPollutantController extends BaseController {
    @Autowired
    private ITBasGasoutputPollutantService tBasGasoutputPollutantService;

    /**
     * 查询基础信息--企业--废气排口污染物基本信息列表
     */
    @Deprecated
    @ApiOperation("获取废气排口污染物基本信息列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutPollutant:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasGasoutputPollutant tBasGasoutputPollutant) {
        startPage();
        List<TBasGasoutputPollutant> list = tBasGasoutputPollutantService.selectTBasGasoutputPollutantList(tBasGasoutputPollutant);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废气排口污染物基本信息列表
     */
    @Deprecated
    @ApiOperation("导出废气排口污染物基本信息列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutPollutant:export')")
    @Log(title = "基础信息--企业--废气排口污染物基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasGasoutputPollutant tBasGasoutputPollutant) {
        List<TBasGasoutputPollutant> list = tBasGasoutputPollutantService.selectTBasGasoutputPollutantList(tBasGasoutputPollutant);
        ExcelUtil<TBasGasoutputPollutant> util = new ExcelUtil<TBasGasoutputPollutant>(TBasGasoutputPollutant.class);
        util.exportExcel(response, list, "基础信息--企业--废气排口污染物基本信息数据");
    }

    /**
     * 获取基础信息--企业--废气排口污染物基本信息详细信息
     */
    @ApiOperation("获取废气排口污染物基本信息详细信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutPollutant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasGasoutputPollutantService.selectTBasGasoutputPollutantById(id));
    }

    /**
     * 新增基础信息--企业--废气排口污染物基本信息
     */
    @ApiOperation("新增废气排口污染物基本信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutPollutant:add')")
    @Log(title = "基础信息--企业--废气排口污染物基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasGasoutputPollutant tBasGasoutputPollutant) {
        tBasGasoutputPollutant.setCreateBy(getUsername());
        tBasGasoutputPollutant.setCreateName(getUsername());
        if (tBasGasoutputPollutant.getOutPutCode() == null) {
            return AjaxResult.error("排口编号不能为空");
        }

        return toAjax(tBasGasoutputPollutantService.insertTBasGasoutputPollutant(tBasGasoutputPollutant));
    }

    /**
     * 修改基础信息--企业--废气排口污染物基本信息
     */
    @ApiOperation("修改废气排口污染物基本信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutPollutant:edit')")
    @Log(title = "基础信息--企业--废气排口污染物基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasGasoutputPollutant tBasGasoutputPollutant) {
        tBasGasoutputPollutant.setUpdateBy(getUsername());
        tBasGasoutputPollutant.setUpdateName(getUsername());
        return toAjax(tBasGasoutputPollutantService.updateTBasGasoutputPollutant(tBasGasoutputPollutant));
    }

    /**
     * 删除基础信息--企业--废气排口污染物基本信息
     */
    @ApiOperation("删除废气排口污染物基本信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutPollutant:remove')")
    @Log(title = "基础信息--企业--废气排口污染物基本信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasGasoutputPollutantService.deleteTBasGasoutputPollutantByIds(ids));
    }
}
