package com.ruoyi.business.sys.controller;

import com.ruoyi.business.sys.domain.TDistricts;
import com.ruoyi.business.sys.service.ITDistrictsService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 地区Controller
 *
 * @author lx
 * @date 2024-07-01
 */
@RestController
@RequestMapping("/business/sys/districts")
public class TDistrictsController extends BaseController {
    @Autowired
    private ITDistrictsService tDistrictsService;

    /**
     * 查询地区列表
     */
    @PreAuthorize("@ss.hasPermi('business:districts:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDistricts tDistricts) {
        startPage();
        List<TDistricts> list = tDistrictsService.selectTDistrictsList(tDistricts);
        return getDataTable(list);
    }

    /**
     * 导出地区列表
     */
    @PreAuthorize("@ss.hasPermi('business:districts:export')")
    @Log(title = "地区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDistricts tDistricts) {
        List<TDistricts> list = tDistrictsService.selectTDistrictsList(tDistricts);
        ExcelUtil<TDistricts> util = new ExcelUtil<TDistricts>(TDistricts.class);
        util.exportExcel(response, list, "地区数据");
    }

    /**
     * 获取地区详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:districts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(tDistrictsService.selectTDistrictsById(id));
    }

    /**
     * 新增地区
     */
    @PreAuthorize("@ss.hasPermi('business:districts:add')")
    @Log(title = "地区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDistricts tDistricts) {
        return toAjax(tDistrictsService.insertTDistricts(tDistricts));
    }

    /**
     * 修改地区
     */
    @PreAuthorize("@ss.hasPermi('business:districts:edit')")
    @Log(title = "地区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDistricts tDistricts) {
        return toAjax(tDistrictsService.updateTDistricts(tDistricts));
    }

    /**
     * 删除地区
     */
    @PreAuthorize("@ss.hasPermi('business:districts:remove')")
    @Log(title = "地区", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(tDistrictsService.deleteTDistrictsByIds(ids));
    }
}
