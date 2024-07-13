package com.ruoyi.business.statisticsAlarm.controller;

import com.ruoyi.business.statisticsAlarm.domain.TDataWateroutControlHour;
import com.ruoyi.business.statisticsAlarm.service.ITDataWateroutControlHourService;
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
 * 废水排口--小时剩余排放平均值Controller
 *
 * @author lx
 * @date 2024-07-13
 */
//@RestController
//@RequestMapping("/statisticsAlarm/alarm")
public class TDataWateroutControlHourController extends BaseController {
    @Autowired
    private ITDataWateroutControlHourService tDataWateroutControlHourService;

//    /**
//     * 查询废水排口--小时剩余排放平均值列表
//     */
//    @PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(TDataWateroutControlHour tDataWateroutControlHour) {
//        startPage();
//        List<TDataWateroutControlHour> list = tDataWateroutControlHourService.selectTDataWateroutControlHourList(tDataWateroutControlHour);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出废水排口--小时剩余排放平均值列表
//     */
//    @PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:export')")
//    @Log(title = "废水排口--小时剩余排放平均值", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, TDataWateroutControlHour tDataWateroutControlHour) {
//        List<TDataWateroutControlHour> list = tDataWateroutControlHourService.selectTDataWateroutControlHourList(tDataWateroutControlHour);
//        ExcelUtil<TDataWateroutControlHour> util = new ExcelUtil<TDataWateroutControlHour>(TDataWateroutControlHour.class);
//        util.exportExcel(response, list, "废水排口--小时剩余排放平均值数据");
//    }

    /**
     * 获取废水排口--小时剩余排放平均值详细信息
     */
    @PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tDataWateroutControlHourService.selectTDataWateroutControlHourById(id));
    }

    /**
     * 新增废水排口--小时剩余排放平均值
     */
    @PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:add')")
    @Log(title = "废水排口--小时剩余排放平均值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDataWateroutControlHour tDataWateroutControlHour) {
        return toAjax(tDataWateroutControlHourService.insertTDataWateroutControlHour(tDataWateroutControlHour));
    }

    /**
     * 修改废水排口--小时剩余排放平均值
     */
    @PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:edit')")
    @Log(title = "废水排口--小时剩余排放平均值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDataWateroutControlHour tDataWateroutControlHour) {
        return toAjax(tDataWateroutControlHourService.updateTDataWateroutControlHour(tDataWateroutControlHour));
    }

    /**
     * 删除废水排口--小时剩余排放平均值
     */
    @PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:remove')")
    @Log(title = "废水排口--小时剩余排放平均值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tDataWateroutControlHourService.deleteTDataWateroutControlHourByIds(ids));
    }
}
