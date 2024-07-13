package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasWateroutPutUnorganized;
import com.ruoyi.business.base.service.ITBasWateroutPutUnorganizedService;
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
 * 基础信息--企业--废水无组织排口Controller
 *
 * @author lx
 * @date 2024-07-04
 */
//类标记无用，删除
@Deprecated
//@Api(value = "业务模块-企业信息", tags = "基础信息-企业废水无组织排口")
//@RestController
//@RequestMapping("/business/base/wateroutPutUnorganized")
public class TBasWateroutPutUnorganizedController extends BaseController {
    @Autowired
    private ITBasWateroutPutUnorganizedService tBasWateroutPutUnorganizedService;

    /**
     * 查询基础信息--企业--废水无组织排口列表
     */
    @ApiOperation("获取废水无组织排口列表")
    @PreAuthorize("@ss.hasPermi('business:wateroutPutUnorganized:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasWateroutPutUnorganized tBasWateroutPutUnorganized) {
        startPage();
        List<TBasWateroutPutUnorganized> list = tBasWateroutPutUnorganizedService.selectTBasWateroutPutUnorganizedList(tBasWateroutPutUnorganized);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废水无组织排口列表
     */
    @ApiOperation("导出废水无组织排口列表")
    @PreAuthorize("@ss.hasPermi('business:wateroutPutUnorganized:export')")
    @Log(title = "基础信息--企业--废水无组织排口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasWateroutPutUnorganized tBasWateroutPutUnorganized) {
        List<TBasWateroutPutUnorganized> list = tBasWateroutPutUnorganizedService.selectTBasWateroutPutUnorganizedList(tBasWateroutPutUnorganized);
        ExcelUtil<TBasWateroutPutUnorganized> util = new ExcelUtil<TBasWateroutPutUnorganized>(TBasWateroutPutUnorganized.class);
        util.exportExcel(response, list, "基础信息--企业--废水无组织排口数据");
    }

    /**
     * 获取基础信息--企业--废水无组织排口详细信息
     */
    @ApiOperation("获取废水无组织排口详细信息")
    @PreAuthorize("@ss.hasPermi('business:wateroutPutUnorganized:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasWateroutPutUnorganizedService.selectTBasWateroutPutUnorganizedById(id));
    }

    /**
     * 新增基础信息--企业--废水无组织排口
     */
    @ApiOperation("新增废水无组织排口")
    @PreAuthorize("@ss.hasPermi('business:wateroutPutUnorganized:add')")
    @Log(title = "基础信息--企业--废水无组织排口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasWateroutPutUnorganized tBasWateroutPutUnorganized) {
        return toAjax(tBasWateroutPutUnorganizedService.insertTBasWateroutPutUnorganized(tBasWateroutPutUnorganized));
    }

    /**
     * 修改基础信息--企业--废水无组织排口
     */
    @ApiOperation("修改废水无组织排口")
    @PreAuthorize("@ss.hasPermi('business:wateroutPutUnorganized:edit')")
    @Log(title = "基础信息--企业--废水无组织排口", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasWateroutPutUnorganized tBasWateroutPutUnorganized) {
        return toAjax(tBasWateroutPutUnorganizedService.updateTBasWateroutPutUnorganized(tBasWateroutPutUnorganized));
    }

    /**
     * 删除基础信息--企业--废水无组织排口
     */
    @ApiOperation("删除废水无组织排口")
    @PreAuthorize("@ss.hasPermi('business:wateroutPutUnorganized:remove')")
    @Log(title = "基础信息--企业--废水无组织排口", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasWateroutPutUnorganizedService.deleteTBasWateroutPutUnorganizedByIds(ids));
    }
}
