package com.ruoyi.business.statisticsAlarm.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjUtil;
import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.business.statisticsAlarm.domain.*;
import com.ruoyi.business.statisticsAlarm.dto.*;
import com.ruoyi.business.statisticsAlarm.service.*;
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
import java.util.*;
import java.util.stream.Collectors;

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

    @Resource
    private ITDataMonitorFaultHourService tDataMonitorFaultHourService;

    /**
     * 小时数据报警
     */
    @ApiOperation("小时数据报警")
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
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
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/emissions")
    public TableDataInfo emissionList(VOutPutDayStatistics vOutPutDayStatistics) {
        startPage();
        List<AlarmEmissionsDto> list = vOutPutHourStatisticsService.selectAlarmEmissionsDtoList(vOutPutDayStatistics);
        return getDataTable(list);
    }

    /**
     * 排放量报警导出
     */
    @ApiOperation("排放量报警导出")
    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "排放量报警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/emission/export")
    public void emissionExport(HttpServletResponse response, VOutPutDayStatistics vOutPutDayStatistics) {
        List<AlarmEmissionsDto> list = vOutPutHourStatisticsService.selectAlarmEmissionsDtoList(vOutPutDayStatistics);
        ExcelUtil<AlarmEmissionsDto> util = new ExcelUtil<>(AlarmEmissionsDto.class);
        util.exportExcel(response, list, "排放量报警导出");
    }

    /**
     * 异常报警
     */
    @ApiOperation("异常报警")
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
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
     *
     * http://182.92.7.39:9527/prod-api/business/statisticsAlarm/alarm/DataMissing?pageNum=1&pageSize=10&outPutEnum=GASOUT&params%5BbeginTime%5D=2024-10-26&params%5BendTime%5D=2024-10-26
     */
    @ApiOperation("小时数据缺失预警")
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/alarm/DataMissing")
    public TableDataInfo dataMissing(DataMissingDto dataMissingDto) {
        startPage();
        //
        TDataMonitorFaultHour tDataMonitorFaultHour = getDataMonitorFaultHourByDataMissingDto(dataMissingDto);
        List<TDataMonitorFaultHour> list = tDataMonitorFaultHourService.selectTDataMonitorFaultHourList(tDataMonitorFaultHour);
        List<DataMissingDto> result = new ArrayList<>();
        result = list.stream().map(
                tDataMonitorFaultHour1 -> {
                    DataMissingDto dataMissingDto1 = new DataMissingDto();
                    dataMissingDto1.setOutPutName(tDataMonitorFaultHour1.getOutPutName());
                    dataMissingDto1.setOutPutCode(tDataMonitorFaultHour1.getOutPutCode());
                   // dataMissingDto1.setOutPutEnum(OutPutEnum.valueOf(tDataMonitorFaultHour1.getDataType()));
                    dataMissingDto1.setMonitorTime(tDataMonitorFaultHour1.getFaultTime());
                    dataMissingDto1.setMissingTime(tDataMonitorFaultHour1.getFaultTimeDesc());
                    return dataMissingDto1;
                }
        ).collect(Collectors.toList());

        return getDataTable(result);
    }

    /**
     * 数据缺失报警导出
     */
    @ApiOperation("小时数据缺失预警导出")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "小时数据缺失预警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/DataMissing/export")
    public void dataMissingExport(HttpServletResponse response,DataMissingDto dataMissingDto) {
        TDataMonitorFaultHour tDataMonitorFaultHour = getDataMonitorFaultHourByDataMissingDto(dataMissingDto);
        List<TDataMonitorFaultHour> list = tDataMonitorFaultHourService.selectTDataMonitorFaultHourList(tDataMonitorFaultHour);
//        List<DataMissingDto> list = vOutPutHourStatisticsService.selectDataMissingList(dataMissingDto);
        ExcelUtil<TDataMonitorFaultHour> util = new ExcelUtil<>(TDataMonitorFaultHour.class);
        util.exportExcel(response, list, "小时数据缺失预警导出");
    }

    private TDataMonitorFaultHour getDataMonitorFaultHourByDataMissingDto(DataMissingDto dataMissingDto) {
        TDataMonitorFaultHour tDataMonitorFaultHour = new TDataMonitorFaultHour();
        //数据类型；1：废气；2：废水
        //报警类型：1：小时数据整体缺失；2：小时数据单个污染因子缺失
        tDataMonitorFaultHour.setAlarmType("1");
        tDataMonitorFaultHour.setFaultTime(dataMissingDto.getMonitorTime());
        tDataMonitorFaultHour.setParams(dataMissingDto.getParams());
        String dataType = "1";
        if(dataMissingDto.getOutPutEnum().equals(OutPutEnum.GASOUT)){
            dataType = "1";
        }else if(dataMissingDto.getOutPutEnum().equals(OutPutEnum.WATEROUT)){
            dataType = "2";
        }
        tDataMonitorFaultHour.setDataType(dataType);
        return tDataMonitorFaultHour;
    }

    /**
     * 小时数据缺项预警
     */
    @Deprecated
    @ApiOperation("传输有效率预警")
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
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
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
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
