package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasGasoutPutUnorganized;
import com.ruoyi.business.base.service.ITBasGasoutPutUnorganizedService;
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
 * 基础信息--企业--废气无组织排口Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-企业信息", tags = "基础信息-企业废气无组织排口")
@RestController
@RequestMapping("/business/base/gasoutPutUnorganized")
public class TBasGasoutPutUnorganizedController extends BaseController {
    @Autowired
    private ITBasGasoutPutUnorganizedService tBasGasoutPutUnorganizedService;

    /**
     * 查询基础信息--企业--废气无组织排口列表
     */
    @ApiOperation("获取废气无组织排口列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutUnorganized:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasGasoutPutUnorganized tBasGasoutPutUnorganized) {
        startPage();
        List<TBasGasoutPutUnorganized> list = tBasGasoutPutUnorganizedService.selectTBasGasoutPutUnorganizedList(tBasGasoutPutUnorganized);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废气无组织排口列表
     */
    @ApiOperation("导出废气无组织排口列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutUnorganized:export')")
    @Log(title = "基础信息--企业--废气无组织排口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasGasoutPutUnorganized tBasGasoutPutUnorganized) {
        List<TBasGasoutPutUnorganized> list = tBasGasoutPutUnorganizedService.selectTBasGasoutPutUnorganizedList(tBasGasoutPutUnorganized);
        ExcelUtil<TBasGasoutPutUnorganized> util = new ExcelUtil<TBasGasoutPutUnorganized>(TBasGasoutPutUnorganized.class);
        util.exportExcel(response, list, "基础信息--企业--废气无组织排口数据");
    }

    /**
     * 获取基础信息--企业--废气无组织排口详细信息
     */
    @ApiOperation("获取废气无组织排口详细信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutUnorganized:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasGasoutPutUnorganizedService.selectTBasGasoutPutUnorganizedById(id));
    }

    /**
     * 新增基础信息--企业--废气无组织排口
     */
    @ApiOperation("新增废气无组织排口")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutUnorganized:add')")
    @Log(title = "基础信息--企业--废气无组织排口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasGasoutPutUnorganized tBasGasoutPutUnorganized) {
        return toAjax(tBasGasoutPutUnorganizedService.insertTBasGasoutPutUnorganized(tBasGasoutPutUnorganized));
    }

    /**
     * 修改基础信息--企业--废气无组织排口
     */
    @ApiOperation("修改废气无组织排口")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutUnorganized:edit')")
    @Log(title = "基础信息--企业--废气无组织排口", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasGasoutPutUnorganized tBasGasoutPutUnorganized) {
        return toAjax(tBasGasoutPutUnorganizedService.updateTBasGasoutPutUnorganized(tBasGasoutPutUnorganized));
    }

    /**
     * 删除基础信息--企业--废气无组织排口
     */
    @ApiOperation("删除废气无组织排口")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutUnorganized:remove')")
    @Log(title = "基础信息--企业--废气无组织排口", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasGasoutPutUnorganizedService.deleteTBasGasoutPutUnorganizedByIds(ids));
    }
}
