package com.ruoyi.business.statisticsAlarm.controller;

import com.ruoyi.business.statisticsAlarm.domain.TDataGasoutControlHour;
import com.ruoyi.business.statisticsAlarm.service.ITDataGasoutControlHourService;
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
 * 废气排口--小时剩余排放平均值Controller
 *
 * @author lx
 * @date 2024-07-13
 */
//@RestController
//@RequestMapping("/statisticsAlarm/alarm")
public class TDataGasoutControlHourController extends BaseController {
    @Autowired
    private ITDataGasoutControlHourService tDataGasoutControlHourService;

//    /**
//     * 查询废气排口--小时剩余排放平均值列表
//     */
//    @PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(TDataGasoutControlHour tDataGasoutControlHour) {
//        startPage();
//        List<TDataGasoutControlHour> list = tDataGasoutControlHourService.selectTDataGasoutControlHourList(tDataGasoutControlHour);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出废气排口--小时剩余排放平均值列表
//     */
//    @PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:export')")
//    @Log(title = "废气排口--小时剩余排放平均值", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, TDataGasoutControlHour tDataGasoutControlHour) {
//        List<TDataGasoutControlHour> list = tDataGasoutControlHourService.selectTDataGasoutControlHourList(tDataGasoutControlHour);
//        ExcelUtil<TDataGasoutControlHour> util = new ExcelUtil<TDataGasoutControlHour>(TDataGasoutControlHour.class);
//        util.exportExcel(response, list, "废气排口--小时剩余排放平均值数据");
//    }

    /**
     * 获取废气排口--小时剩余排放平均值详细信息
     */
    //@PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tDataGasoutControlHourService.selectTDataGasoutControlHourById(id));
    }

    /**
     * 新增废气排口--小时剩余排放平均值
     */
    //@PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:add')")
    @Log(title = "废气排口--小时剩余排放平均值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDataGasoutControlHour tDataGasoutControlHour) {
        return toAjax(tDataGasoutControlHourService.insertTDataGasoutControlHour(tDataGasoutControlHour));
    }

    /**
     * 修改废气排口--小时剩余排放平均值
     */
    //@PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:edit')")
    @Log(title = "废气排口--小时剩余排放平均值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDataGasoutControlHour tDataGasoutControlHour) {
        return toAjax(tDataGasoutControlHourService.updateTDataGasoutControlHour(tDataGasoutControlHour));
    }

    /**
     * 删除废气排口--小时剩余排放平均值
     */
    //@PreAuthorize("@ss.hasPermi('statisticsAlarm:alarm:remove')")
    @Log(title = "废气排口--小时剩余排放平均值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tDataGasoutControlHourService.deleteTDataGasoutControlHourByIds(ids));
    }
}
