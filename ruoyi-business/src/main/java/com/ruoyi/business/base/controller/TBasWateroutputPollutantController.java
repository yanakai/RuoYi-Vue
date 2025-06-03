package com.ruoyi.business.base.controller;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.business.base.domain.OutputPollutantAutoHead;
import com.ruoyi.business.base.domain.TBasWateroutputPollutant;
import com.ruoyi.business.base.service.ITBasWateroutputPollutantService;
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
 * 基础信息--企业--废水排口污染物基本信息Controller
 *
 * @author lx
 * @date 2024-06-27
 */
@Api(value = "业务模块-企业-废水排口污染物基本信息", tags = "企业档案-废水排口污染物基本信息")
@RestController
@RequestMapping("/business/base/waterOutputPollutant")
public class TBasWateroutputPollutantController extends BaseController {
    @Autowired
    private ITBasWateroutputPollutantService tBasWateroutputPollutantService;

    /**
     * 废水排口污染物基本信息自动表头列表
     */
    @ApiOperation("获取废水排口污染物基本信息自动表头列表")
    @GetMapping("/autoHead")
    public List<OutputPollutantAutoHead> autoHead(String entCode, String outPutCode) {
        return tBasWateroutputPollutantService.selectOutputPollutantAutoHead(entCode, outPutCode);
    }

    /**
     * 查询基础信息--企业--废水排口污染物基本信息列表
     */
    @ApiOperation("获取废水排口污染物基本信息列表")
//    @PreAuthorize("@ss.hasPermi('business:waterOutputPollutant:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasWateroutputPollutant tBasWateroutputPollutant) {
        startPage();
        List<TBasWateroutputPollutant> list = tBasWateroutputPollutantService.selectTBasWateroutputPollutantList(tBasWateroutputPollutant);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废水排口污染物基本信息列表
     */
    @ApiOperation("导出废水排口污染物基本信息列表")
//    @PreAuthorize("@ss.hasPermi('business:waterOutputPollutant:export')")
    @Log(title = "基础信息--企业--废水排口污染物基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasWateroutputPollutant tBasWateroutputPollutant) {
        List<TBasWateroutputPollutant> list = tBasWateroutputPollutantService.selectTBasWateroutputPollutantList(tBasWateroutputPollutant);
        ExcelUtil<TBasWateroutputPollutant> util = new ExcelUtil<TBasWateroutputPollutant>(TBasWateroutputPollutant.class);
        util.exportExcel(response, list, "基础信息--企业--废水排口污染物基本信息数据");
    }

    /**
     * 获取基础信息--企业--废水排口污染物基本信息详细信息
     */
    @ApiOperation("获取废水排口污染物基本信息详细信息")
//    @PreAuthorize("@ss.hasPermi('business:waterOutputPollutant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasWateroutputPollutantService.selectTBasWateroutputPollutantById(id));
    }

    /**
     * 新增基础信息--企业--废水排口污染物基本信息
     */
    @ApiOperation("新增废水排口污染物基本信息")
//    @PreAuthorize("@ss.hasPermi('business:waterOutputPollutant:add')")
    @Log(title = "基础信息--企业--废水排口污染物基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasWateroutputPollutant tBasWateroutputPollutant) {
        tBasWateroutputPollutant.setCreateBy(getUsername());
        tBasWateroutputPollutant.setCreateName(getUsername());
        if(StrUtil.isEmpty(tBasWateroutputPollutant.getOutPutCode())){
            return AjaxResult.error("废水排放口编码不能为空");
        }
        return toAjax(tBasWateroutputPollutantService.insertTBasWateroutputPollutant(tBasWateroutputPollutant));
    }

    /**
     * 修改基础信息--企业--废水排口污染物基本信息
     */
    @ApiOperation("修改废水排口污染物基本信息")
//    @PreAuthorize("@ss.hasPermi('business:waterOutputPollutant:edit')")
    @Log(title = "基础信息--企业--废水排口污染物基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasWateroutputPollutant tBasWateroutputPollutant) {
        tBasWateroutputPollutant.setUpdateBy(getUsername());
        tBasWateroutputPollutant.setUpdateName(getUsername());
        return toAjax(tBasWateroutputPollutantService.updateTBasWateroutputPollutant(tBasWateroutputPollutant));
    }

    /**
     * 删除基础信息--企业--废水排口污染物基本信息
     */
    @ApiOperation("删除废水排口污染物基本信息")
//    @PreAuthorize("@ss.hasPermi('business:waterOutputPollutant:remove')")
    @Log(title = "基础信息--企业--废水排口污染物基本信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasWateroutputPollutantService.deleteTBasWateroutputPollutantByIds(ids));
    }
}
