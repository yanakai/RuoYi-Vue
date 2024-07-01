package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasEnterprise;
import com.ruoyi.business.base.service.ITBasEnterpriseService;
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
 * 基础信息---企业基础Controller
 *
 * @author ruoyi
 * @date 2024-06-26
 */
@Api(value = "业务模块-企业信息", tags = "基础信息-企业基础信息")
@RestController
@RequestMapping("/business/base/enterprise")
public class TBasEnterpriseController extends BaseController {
    @Autowired
    private ITBasEnterpriseService tBasEnterpriseService;

    /**
     * 查询基础信息---企业基础列表
     */
    @ApiOperation("获取企业信息列表")
    @PreAuthorize("@ss.hasPermi('business:enterprise:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBasEnterprise tBasEnterprise) {
        startPage();
        List<TBasEnterprise> list = tBasEnterpriseService.selectTBasEnterpriseList(tBasEnterprise);
        return getDataTable(list);
    }

    /**
     * 导出基础信息---企业基础列表
     */
    @ApiOperation("导出基础信息---企业基础列表")
    @PreAuthorize("@ss.hasPermi('business:enterprise:export')")
    @Log(title = "基础信息---企业基础", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasEnterprise tBasEnterprise) {
        List<TBasEnterprise> list = tBasEnterpriseService.selectTBasEnterpriseList(tBasEnterprise);
        ExcelUtil<TBasEnterprise> util = new ExcelUtil<TBasEnterprise>(TBasEnterprise.class);
        util.exportExcel(response, list, "基础信息---企业基础数据");
    }

    /**
     * 获取基础信息---企业基础详细信息
     */
    @ApiOperation("获取基础信息---企业基础详细信息")
    @PreAuthorize("@ss.hasPermi('business:enterprise:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tBasEnterpriseService.selectTBasEnterpriseById(id));
    }

    /**
     * 新增基础信息---企业基础
     */
    @ApiOperation("新增基础信息---企业基础")
    @PreAuthorize("@ss.hasPermi('business:enterprise:add')")
    @Log(title = "基础信息---企业基础", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasEnterprise tBasEnterprise) {
        tBasEnterprise.setCreateUser(getUsername());
        tBasEnterprise.setCreateBy(getUsername());
        return toAjax(tBasEnterpriseService.insertTBasEnterprise(tBasEnterprise));
    }

    /**
     * 修改基础信息---企业基础
     */
    @ApiOperation("修改基础信息---企业基础")
    @PreAuthorize("@ss.hasPermi('business:enterprise:edit')")
    @Log(title = "基础信息---企业基础", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasEnterprise tBasEnterprise) {
        tBasEnterprise.setUpdateUser(getUsername());
        tBasEnterprise.setUpdateBy(getUsername());
        return toAjax(tBasEnterpriseService.updateTBasEnterprise(tBasEnterprise));
    }

    /**
     * 删除基础信息---企业基础
     */
    @ApiOperation("删除基础信息---企业基础")
    @PreAuthorize("@ss.hasPermi('business:enterprise:remove')")
    @Log(title = "基础信息---企业基础", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBasEnterpriseService.deleteTBasEnterpriseByIds(ids));
    }
}
