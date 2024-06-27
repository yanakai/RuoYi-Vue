package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasGasoutPutInfo;
import com.ruoyi.business.base.service.ITBasGasoutPutInfoService;
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
 * 基础信息--企业--废气排口Controller
 *
 * @author lx
 * @date 2024-06-27
 */
@Api(value = "业务模块-企业-废气排口", tags = "基础信息-废气排口")
@RestController
@RequestMapping("/business/base/gasoutPutInfo")
public class TBasGasoutPutInfoController extends BaseController {
    @Autowired
    private ITBasGasoutPutInfoService tBasGasoutPutInfoService;

    /**
     * 查询基础信息--企业--废气排口列表
     */
    @ApiOperation("获取废气排口列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasGasoutPutInfo tBasGasoutPutInfo) {
        startPage();
        List<TBasGasoutPutInfo> list = tBasGasoutPutInfoService.selectTBasGasoutPutInfoList(tBasGasoutPutInfo);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废气排口列表
     */
    @ApiOperation("导出废气排口列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutInfo:export')")
    @Log(title = "基础信息--企业--废气排口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasGasoutPutInfo tBasGasoutPutInfo) {
        List<TBasGasoutPutInfo> list = tBasGasoutPutInfoService.selectTBasGasoutPutInfoList(tBasGasoutPutInfo);
        ExcelUtil<TBasGasoutPutInfo> util = new ExcelUtil<TBasGasoutPutInfo>(TBasGasoutPutInfo.class);
        util.exportExcel(response, list, "基础信息--企业--废气排口数据");
    }

    /**
     * 获取基础信息--企业--废气排口详细信息
     */
    @ApiOperation("获取废气排口详细信息")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasGasoutPutInfoService.selectTBasGasoutPutInfoById(id));
    }

    /**
     * 新增基础信息--企业--废气排口
     */
    @ApiOperation("新增废气排口")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutInfo:add')")
    @Log(title = "基础信息--企业--废气排口", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasGasoutPutInfo tBasGasoutPutInfo) {
        return toAjax(tBasGasoutPutInfoService.insertTBasGasoutPutInfo(tBasGasoutPutInfo));
    }

    /**
     * 修改基础信息--企业--废气排口
     */
    @ApiOperation("修改废气排口")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutInfo:edit')")
    @Log(title = "基础信息--企业--废气排口", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasGasoutPutInfo tBasGasoutPutInfo) {
        return toAjax(tBasGasoutPutInfoService.updateTBasGasoutPutInfo(tBasGasoutPutInfo));
    }

    /**
     * 删除基础信息--企业--废气排口
     */
    @ApiOperation("删除废气排口")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutInfo:remove')")
    @Log(title = "基础信息--企业--废气排口", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasGasoutPutInfoService.deleteTBasGasoutPutInfoByIds(ids));
    }
}
