package com.ruoyi.business.onlineMonitoring.controller;

import com.ruoyi.business.onlineMonitoring.dto.WateroutDTO;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.business.statistics.service.IWateroutService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 废水在线监测 Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-废水在线监测", tags = "废水在线监测")
@RestController
@RequestMapping("/business/onlinemonitoring/waterout")
public class WateroutController extends BaseController {
    @Autowired
    private ITDataGasoutDayStatisticsService tDataGasoutDayStatisticsService;

    @Resource
    private IWateroutService wateroutService;

    /**
     * 小时数据报警
     */
    @ApiOperation("废水在线监测")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(WateroutDTO wateroutDTO) {
        return wateroutService.selectDataList(wateroutDTO);
    }

    /**
     * 小时数据报警导出
     */
    @ApiOperation("废水在线监测导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "废水在线监测导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
//        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutMonthStatisticsList(tDataGasoutStatisticsDTO);
//        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
//        util.exportExcel(response, list, "废水在线监测导出");
    }
}
