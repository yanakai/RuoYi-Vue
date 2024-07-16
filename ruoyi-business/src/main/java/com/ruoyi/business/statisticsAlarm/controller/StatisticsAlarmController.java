package com.ruoyi.business.statisticsAlarm.controller;

import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;
import com.ruoyi.business.statistics.domain.TDataWateroutHourStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.business.statisticsAlarm.domain.TDataGasoutControlHour;
import com.ruoyi.business.statisticsAlarm.domain.TDataWateroutControlHour;
import com.ruoyi.business.statisticsAlarm.dto.AlarmHourDto;
import com.ruoyi.business.statisticsAlarm.dto.OutControlHourDto;
import com.ruoyi.business.statisticsAlarm.service.IStatisticsAlarmService;
import com.ruoyi.business.statisticsAlarm.service.ITDataGasoutControlHourService;
import com.ruoyi.business.statisticsAlarm.service.ITDataWateroutControlHourService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
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
import java.util.List;

/**
 * 分级预警报警 Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Api(value = "业务模块-分级预警报警", tags = "分级预警报警")
@RestController
@RequestMapping("/business/statisticsAlarm")
public class StatisticsAlarmController extends BaseController {
    @Resource
    private ITDataGasoutDayStatisticsService tDataGasoutDayStatisticsService;
    @Resource
    private ITDataWateroutControlHourService tDataWateroutControlHourService;
    @Resource
    private ITDataGasoutControlHourService tDataGasoutControlHourService;
    @Resource
    private IStatisticsAlarmService iStatisticsAlarmService;

    /**
     * 小时数据报警
     */
    @ApiOperation("小时数据报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/hour")
    public TableDataInfo hourList(AlarmHourDto alarmHourDto) {
        startPage();
        if(alarmHourDto.getOutPutEnum().name().equals("gasout")) {
            List<TDataGasoutHourStatistics> list = iStatisticsAlarmService.selectTDataGasout4alarmList(alarmHourDto);
            return getDataTable(list);
        } else if (alarmHourDto.getOutPutEnum().name().equals("waterout")) {
            List<TDataWateroutHourStatistics> list = iStatisticsAlarmService.selectTDataWaterout4alarmList(alarmHourDto);
            return getDataTable(list);
        }
        return getDataTable(null);
    }

    /**
     * 小时数据报警导出
     */
    @ApiOperation("小时数据报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "小时数据报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/hour/export")
    public void hourExport(HttpServletResponse response, AlarmHourDto alarmHourDto) {
        if(alarmHourDto.getOutPutEnum().name().equals("gasout")) {
            List<TDataGasoutHourStatistics> list = iStatisticsAlarmService.selectTDataGasout4alarmList(alarmHourDto);
            ExcelUtil<TDataGasoutHourStatistics> util = new ExcelUtil<>(TDataGasoutHourStatistics.class);
            util.exportExcel(response, list, "小时数据报警导出");
        } else if (alarmHourDto.getOutPutEnum().name().equals("waterout")) {
            List<TDataWateroutHourStatistics> list = iStatisticsAlarmService.selectTDataWaterout4alarmList(alarmHourDto);
            ExcelUtil<TDataWateroutHourStatistics> util = new ExcelUtil<>(TDataWateroutHourStatistics.class);
            util.exportExcel(response, list, "小时数据报警导出");
        }
    }

    private List getHourList(AlarmHourDto alarmHourDto){
        if(alarmHourDto.getOutPutEnum().name().equals("gasout")) {
            return iStatisticsAlarmService.selectTDataGasout4alarmList(alarmHourDto);
        } else if (alarmHourDto.getOutPutEnum().name().equals("waterout")) {
            return iStatisticsAlarmService.selectTDataWaterout4alarmList(alarmHourDto);
        }
       return null;
    }


    /**
     * 排放量报警
     */
    @ApiOperation("排放量报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/emissions")
    public TableDataInfo emissionList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutQuarterStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 排放量报警导出
     */
    @ApiOperation("排放量报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "排放量报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/emission/export")
    public void emissionExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutQuarterStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "排放量报警导出");
    }

    /**
     * 异常报警
     */
    @ApiOperation("异常报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/exception")
    public TableDataInfo exceptionList(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 异常报警导出
     */
    @ApiOperation("异常报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "异常报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/exception/export")
    public void exceptionExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "异常报警导出");
    }

    /**
     * 数据缺失报警
     */
    @ApiOperation("数据缺失报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/DataMissing")
    public TableDataInfo dataMissing(TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        startPage();
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(list);
    }

    /**
     * 数据缺失报警导出
     */
    @ApiOperation("数据缺失报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "数据缺失报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/DataMissing/export")
    public void dataMissingExport(HttpServletResponse response, TDataGasoutStatisticsDTO tDataGasoutStatisticsDTO) {
        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<TDataGasoutDayStatistics> util = new ExcelUtil<TDataGasoutDayStatistics>(TDataGasoutDayStatistics.class);
        util.exportExcel(response, list, "数据缺失报警");
    }

    /**
     * 小时数据预警
     */
    @ApiOperation("小时数据预警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/warning/hour")
    public TableDataInfo warningHourList(OutControlHourDto outControlHourDto) {
        startPage();
        if(outControlHourDto.getOutPutEnum().name().equals("gasout")){
            //废气排口
            List<TDataGasoutControlHour> list = tDataGasoutControlHourService.selectTDataGasoutControlHourList(outControlHourDto);
            return getDataTable(list);
        }else if(outControlHourDto.getOutPutEnum().name().equals("waterout")){
            //废水排口
            List<TDataWateroutControlHour> list = tDataWateroutControlHourService.selectTDataWateroutControlHourList(outControlHourDto);
            return getDataTable(list);
        }
        return getDataTable(null);
    }

    /**
     * 小时数据预警导出
     */
    @ApiOperation("小时数据预警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "小时数据预警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/warning/hour/export")
    public void warningHourExport(HttpServletResponse response, OutControlHourDto outControlHourDto) {

        if(outControlHourDto.getOutPutEnum().name().equals("gasout")){
            //废气排口
            List<TDataGasoutControlHour> list = tDataGasoutControlHourService.selectTDataGasoutControlHourList(outControlHourDto);
            ExcelUtil<TDataGasoutControlHour> util = new ExcelUtil<>(TDataGasoutControlHour.class);
            util.exportExcel(response, list, "小时数据预警导出");
        }else if(outControlHourDto.getOutPutEnum().name().equals("waterout")){
            //废水排口
            List<TDataWateroutControlHour> list = tDataWateroutControlHourService.selectTDataWateroutControlHourList(outControlHourDto);
            ExcelUtil<TDataWateroutControlHour> util = new ExcelUtil<>(TDataWateroutControlHour.class);
            util.exportExcel(response, list, "小时数据预警导出");
        }
    }
}
