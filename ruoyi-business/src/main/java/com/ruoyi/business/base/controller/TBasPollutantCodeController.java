package com.ruoyi.business.base.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.base.domain.TBasPollutantCode;
import com.ruoyi.business.base.service.ITBasPollutantCodeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数采报文对应的污染因子关系 2017版本和2003版Controller
 * 
 * @author lx
 * @date 2024-07-21
 */
@Api(value = "业务模块-污染排口", tags = "企业档案-污染因子关系")
@RestController
@RequestMapping("/business/base/pollutantCode")
public class TBasPollutantCodeController extends BaseController
{
    @Autowired
    private ITBasPollutantCodeService tBasPollutantCodeService;

    /**
     * 查询数采报文对应的污染因子关系 2017版本和2003版列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TBasPollutantCode tBasPollutantCode){
        startPage();
        List<TBasPollutantCode> list = tBasPollutantCodeService.selectTBasPollutantCodeList(tBasPollutantCode);
        return getDataTable(list);
    }

    /**
     * 导出数采报文对应的污染因子关系 2017版本和2003版列表
     *//*
    @PreAuthorize("@ss.hasPermi('business:pollutantCode:export')")
    @Log(title = "数采报文对应的污染因子关系 2017版本和2003版", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBasPollutantCode tBasPollutantCode)
    {
        List<TBasPollutantCode> list = tBasPollutantCodeService.selectTBasPollutantCodeList(tBasPollutantCode);
        ExcelUtil<TBasPollutantCode> util = new ExcelUtil<TBasPollutantCode>(TBasPollutantCode.class);
        util.exportExcel(response, list, "数采报文对应的污染因子关系 2017版本和2003版数据");
    }

    *//**
     * 获取数采报文对应的污染因子关系 2017版本和2003版详细信息
     *//*
    @PreAuthorize("@ss.hasPermi('business:pollutantCode:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tBasPollutantCodeService.selectTBasPollutantCodeById(id));
    }

    *//**
     * 新增数采报文对应的污染因子关系 2017版本和2003版
     *//*
    @PreAuthorize("@ss.hasPermi('business:pollutantCode:add')")
    @Log(title = "数采报文对应的污染因子关系 2017版本和2003版", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBasPollutantCode tBasPollutantCode)
    {
        return toAjax(tBasPollutantCodeService.insertTBasPollutantCode(tBasPollutantCode));
    }

    *//**
     * 修改数采报文对应的污染因子关系 2017版本和2003版
     *//*
    @PreAuthorize("@ss.hasPermi('business:pollutantCode:edit')")
    @Log(title = "数采报文对应的污染因子关系 2017版本和2003版", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBasPollutantCode tBasPollutantCode)
    {
        return toAjax(tBasPollutantCodeService.updateTBasPollutantCode(tBasPollutantCode));
    }

    *//**
     * 删除数采报文对应的污染因子关系 2017版本和2003版
     *//*
    @PreAuthorize("@ss.hasPermi('business:pollutantCode:remove')")
    @Log(title = "数采报文对应的污染因子关系 2017版本和2003版", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tBasPollutantCodeService.deleteTBasPollutantCodeByIds(ids));
    }*/
}
