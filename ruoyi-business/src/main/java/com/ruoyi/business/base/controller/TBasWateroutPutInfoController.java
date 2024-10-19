package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasWateroutPutInfo;
import com.ruoyi.business.base.service.ITBasWateroutPutInfoService;
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
 * 基础信息--企业--废水排口Controller
 *
 * @author lx
 * @date 2024-06-27
 */
@Api(value = "业务模块-企业--废水排口", tags = "企业档案-废水排口")
@RestController
@RequestMapping("/business/base/waterOutPutInfo")
public class TBasWateroutPutInfoController extends BaseController {
    @Autowired
    private ITBasWateroutPutInfoService tBasWateroutPutInfoService;

    /**
     * 查询基础信息--企业--废水排口列表
     */
    @Deprecated
    @ApiOperation("获取废水排口列表")
//    @PreAuthorize("@ss.hasPermi('business:waterOutPutInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasWateroutPutInfo tBasWateroutPutInfo) {
        startPage();
        List<TBasWateroutPutInfo> list = tBasWateroutPutInfoService.selectTBasWateroutPutInfoList(tBasWateroutPutInfo);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废水排口列表
     */
    @Deprecated
    @ApiOperation("导出废水排口列表")
//    @PreAuthorize("@ss.hasPermi('business:waterOutPutInfo:export')")
    @Log(title = "基础信息--企业--废水排口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasWateroutPutInfo tBasWateroutPutInfo) {
        List<TBasWateroutPutInfo> list = tBasWateroutPutInfoService.selectTBasWateroutPutInfoList(tBasWateroutPutInfo);
        ExcelUtil<TBasWateroutPutInfo> util = new ExcelUtil<TBasWateroutPutInfo>(TBasWateroutPutInfo.class);
        util.exportExcel(response, list, "基础信息--企业--废水排口数据");
    }

    /**
     * 获取基础信息--企业--废水排口详细信息
     */
    @ApiOperation("获取废水排口详细信息")
//    @PreAuthorize("@ss.hasPermi('business:waterOutPutInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasWateroutPutInfoService.selectTBasWateroutPutInfoById(id));
    }

    /**
     * 新增基础信息--企业--废水排口
     */
    @ApiOperation("新增废水排口")
//    @PreAuthorize("@ss.hasPermi('business:waterOutPutInfo:add')")
    @Log(title = "基础信息--企业--废水排口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasWateroutPutInfo tBasWateroutPutInfo) {
        tBasWateroutPutInfo.setCreateBy(getUsername());
        tBasWateroutPutInfo.setCreateName(getUsername());
        return toAjax(tBasWateroutPutInfoService.insertTBasWateroutPutInfo(tBasWateroutPutInfo));
    }

    /**
     * 修改基础信息--企业--废水排口
     */
    @ApiOperation("修改废水排口")
//    @PreAuthorize("@ss.hasPermi('business:waterOutPutInfo:edit')")
    @Log(title = "基础信息--企业--废水排口", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasWateroutPutInfo tBasWateroutPutInfo) {
        tBasWateroutPutInfo.setUpdateBy(getUsername());
        tBasWateroutPutInfo.setUpdateName(getUsername());
        return toAjax(tBasWateroutPutInfoService.updateTBasWateroutPutInfo(tBasWateroutPutInfo));
    }

    /**
     * 删除基础信息--企业--废水排口
     */
    @ApiOperation("删除废水排口")
//    @PreAuthorize("@ss.hasPermi('business:waterOutPutInfo:remove')")
    @Log(title = "基础信息--企业--废水排口", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasWateroutPutInfoService.deleteTBasWateroutPutInfoByIds(ids));
    }
}
