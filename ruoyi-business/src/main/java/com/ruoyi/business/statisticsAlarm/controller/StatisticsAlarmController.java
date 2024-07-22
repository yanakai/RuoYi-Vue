package com.ruoyi.business.statisticsAlarm.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.business.statisticsAlarm.domain.TDataGasoutControlHour;
import com.ruoyi.business.statisticsAlarm.domain.TDataWateroutControlHour;
import com.ruoyi.business.statisticsAlarm.domain.VOutPutHourStatistics;
import com.ruoyi.business.statisticsAlarm.dto.*;
import com.ruoyi.business.statisticsAlarm.service.IStatisticsAlarmService;
import com.ruoyi.business.statisticsAlarm.service.ITDataGasoutControlHourService;
import com.ruoyi.business.statisticsAlarm.service.ITDataWateroutControlHourService;
import com.ruoyi.business.statisticsAlarm.service.IVOutPutHourStatisticsService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
    @Resource
    private IVOutPutHourStatisticsService vOutPutHourStatisticsService;

    /**
     * 小时数据报警
     */
    @ApiOperation("小时数据报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/hour")
    public TableDataInfo hourList(AlarmHourDto alarmHourDto) {
        startPage();
        VOutPutHourStatistics vOutPutHourStatistics = new VOutPutHourStatistics();
        BeanUtil.copyProperties(alarmHourDto, vOutPutHourStatistics);
        if(ObjUtil.isNotNull(alarmHourDto) && ObjUtil.isNotNull(alarmHourDto.getOutPutEnum())){
            vOutPutHourStatistics.setOutPutType(alarmHourDto.getOutPutEnum().getName());
        }
        List<VOutPutHourStatistics> list = vOutPutHourStatisticsService.selectVOutPutHourStatisticsList(vOutPutHourStatistics);
        return getDataTable(list);
    }

    /**
     * 小时数据报警导出
     */
    @ApiOperation("小时数据报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "小时数据报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/hour/export")
    public void hourExport(HttpServletResponse response, AlarmHourDto alarmHourDto) {
        VOutPutHourStatistics vOutPutHourStatistics = new VOutPutHourStatistics();
        BeanUtil.copyProperties(alarmHourDto, vOutPutHourStatistics);
        if(ObjUtil.isNotNull(alarmHourDto) && ObjUtil.isNotNull(alarmHourDto.getOutPutEnum())){
            vOutPutHourStatistics.setOutPutType(alarmHourDto.getOutPutEnum().getName());
        }
        List<VOutPutHourStatistics> list = vOutPutHourStatisticsService.selectVOutPutHourStatisticsList(vOutPutHourStatistics);
        ExcelUtil<VOutPutHourStatistics> util = new ExcelUtil<>(VOutPutHourStatistics.class);
        util.exportExcel(response, list, "小时数据报警导出");
    }

    /**
     * 排放量报警
     */
    @ApiOperation("排放量报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/emissions")
    public TableDataInfo emissionList(DataEmissionDto dataEmissionDto) {
        startPage();
        return getDataTable(new ArrayList<>());
    }

    /**
     * 排放量报警导出
     */
    @Deprecated
    @ApiOperation("排放量报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "排放量报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/emission/export")
    public void emissionExport(HttpServletResponse response, DataEmissionDto dataEmissionDto) {
        VOutPutHourStatistics vOutPutHourStatistics = new VOutPutHourStatistics();
        ExcelUtil<DataEmissionDto> util = new ExcelUtil<>(DataEmissionDto.class);
        util.exportExcel(response, new ArrayList<>(), "排放量报警导出");
    }

    /**
     * 异常报警
     */
    @ApiOperation("异常报警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/exception")
    public TableDataInfo exceptionList(AlarmHourDto alarmHourDto) {
        startPage();
        VOutPutHourStatistics vOutPutHourStatistics = new VOutPutHourStatistics();
        BeanUtil.copyProperties(alarmHourDto, vOutPutHourStatistics);
        if(ObjUtil.isNotNull(alarmHourDto) && ObjUtil.isNotNull(alarmHourDto.getOutPutEnum())){
            vOutPutHourStatistics.setOutPutType(alarmHourDto.getOutPutEnum().getName());
        }
        List<VOutPutHourStatistics> list = vOutPutHourStatisticsService.selectVOutPutHourEmissionsList(vOutPutHourStatistics);
        return getDataTable(list);
    }

    /**
     * 异常报警导出
     */
    @ApiOperation("异常报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "异常报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/exception/export")
    public void exceptionExport(HttpServletResponse response, AlarmHourDto alarmHourDto) {
        VOutPutHourStatistics vOutPutHourStatistics = new VOutPutHourStatistics();
        BeanUtil.copyProperties(alarmHourDto, vOutPutHourStatistics);
        if(ObjUtil.isNotNull(alarmHourDto) && ObjUtil.isNotNull(alarmHourDto.getOutPutEnum())){
            vOutPutHourStatistics.setOutPutType(alarmHourDto.getOutPutEnum().getName());
        }
        List<VOutPutHourStatistics> list = vOutPutHourStatisticsService.selectVOutPutHourEmissionsList(vOutPutHourStatistics);
        ExcelUtil<VOutPutHourStatistics> util = new ExcelUtil<>(VOutPutHourStatistics.class);
        util.exportExcel(response, list, "排放量报警导出");
    }

    /**
     * 数据缺失报警
     */
    @ApiOperation("小时数据缺失预警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/DataMissing")
    public TableDataInfo dataMissing(DataMissingDto dataMissingDto) {
        startPage();
        List<DataMissingDto> list = vOutPutHourStatisticsService.selectDataMissingList(dataMissingDto);
        return getDataTable(list);
    }

    /**
     * 数据缺失报警导出
     */
    @ApiOperation("小时数据缺失预警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "数据缺失报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/DataMissing/export")
    public void dataMissingExport(HttpServletResponse response,DataMissingDto dataMissingDto) {
        List<DataMissingDto> list = vOutPutHourStatisticsService.selectDataMissingList(dataMissingDto);
        ExcelUtil<DataMissingDto> util = new ExcelUtil<>(DataMissingDto.class);
        util.exportExcel(response, list, "数据缺失报警");
    }

    /**
     * 小时数据缺项预警
     */
    @ApiOperation("传输有效率预警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/transmissionEfficiency")
    public TableDataInfo transmissionEfficiency(DataEfficiencyDto dataEfficiencyDto) {
        startPage();
//        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        return getDataTable(new ArrayList<>());
    }

    /**
     * 小时数据缺项预警导出
     */
    @Deprecated
    @ApiOperation("传输有效率预警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "传输有效率预警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/transmissionEfficiency/export")
    public void transmissionEfficiency(HttpServletResponse response, DataEfficiencyDto dataEfficiencyDto) {
//        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<DataEfficiencyDto> util = new ExcelUtil<>(DataEfficiencyDto.class);
        util.exportExcel(response, new ArrayList<>(), "传输有效率预警导出");
    }

    /**
     * 小时数据预警
     */
    @ApiOperation("小时数据预警")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/warning/hour")
    public TableDataInfo warningHourList(OutControlHourDto outControlHourDto) {
        startPage();
        if(ObjUtil.isNotNull(outControlHourDto) && ObjUtil.isNotNull(outControlHourDto.getOutPutEnum())){
            if (outControlHourDto.getOutPutEnum().name().equals("GASOUT")) {
                //废气排口
                List<TDataGasoutControlHour> list = tDataGasoutControlHourService.selectTDataGasoutControlHourList(outControlHourDto);
                return getDataTable(list);
            } else if (outControlHourDto.getOutPutEnum().name().equals("WATEROUT")) {
                //废水排口
                List<TDataWateroutControlHour> list = tDataWateroutControlHourService.selectTDataWateroutControlHourList(outControlHourDto);
                return getDataTable(list);
            }
        }
        return getDataTable(new ArrayList<>());
    }

    /**
     * 小时数据预警导出
     */
    @ApiOperation("小时数据预警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "小时数据预警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/warning/hour/export")
    public void warningHourExport(HttpServletResponse response, OutControlHourDto outControlHourDto) {
        if(ObjUtil.isNotNull(outControlHourDto) && ObjUtil.isNotNull(outControlHourDto.getOutPutEnum())){
            if (outControlHourDto.getOutPutEnum().name().equals("GASOUT")) {
                //废气排口
                List<TDataGasoutControlHour> list = tDataGasoutControlHourService.selectTDataGasoutControlHourList(outControlHourDto);
                ExcelUtil<TDataGasoutControlHour> util = new ExcelUtil<>(TDataGasoutControlHour.class);
                util.exportExcel(response, list, "小时数据预警导出");
            } else if (outControlHourDto.getOutPutEnum().name().equals("WATEROUT")) {
                //废水排口
                List<TDataWateroutControlHour> list = tDataWateroutControlHourService.selectTDataWateroutControlHourList(outControlHourDto);
                ExcelUtil<TDataWateroutControlHour> util = new ExcelUtil<>(TDataWateroutControlHour.class);
                util.exportExcel(response, list, "小时数据预警导出");
            }
        }
    }
}
