package com.ruoyi.business.statisticsAlarm.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.ruoyi.business.onlineMonitoring.dto.DataEnum;
import com.ruoyi.business.onlineMonitoring.dto.GasoutDTO;
import com.ruoyi.business.onlineMonitoring.dto.WateroutDTO;
import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.domain.TDataGasoutHourStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutMonthStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutRealOrMinuteStatistics;
import com.ruoyi.business.statistics.dto.TDataGasoutStatisticsDTO;
import com.ruoyi.business.statistics.dto.TDataWateroutRealOrMinuteStatistics;
import com.ruoyi.business.statistics.service.IGasoutService;
import com.ruoyi.business.statistics.service.ITDataGasoutDayStatisticsService;
import com.ruoyi.business.statistics.service.ITDataGasoutHourStatisticsService;
import com.ruoyi.business.statistics.service.IWateroutService;
import com.ruoyi.business.statisticsAlarm.domain.*;
import com.ruoyi.business.statisticsAlarm.dto.*;
import com.ruoyi.business.statisticsAlarm.service.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
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

    @Autowired
    private IGasoutService gasoutService;
    @Autowired
    private IWateroutService wateroutService;

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
        List<VOutPutHourStatistics> list = vOutPutHourStatisticsService.selectVOutPutHourStatisticsListV2(vOutPutHourStatistics);
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
        List<VOutPutHourStatistics> list = vOutPutHourStatisticsService.selectVOutPutHourStatisticsListV2(vOutPutHourStatistics);
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
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
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
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
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
        tDataMonitorFaultHour.setAlarmType(StrUtil.emptyToDefault(dataMissingDto.getAlarmType(),"1"));
        tDataMonitorFaultHour.setFaultTime(dataMissingDto.getMonitorTime());
        tDataMonitorFaultHour.setParams(dataMissingDto.getParams());
        tDataMonitorFaultHour.setOutPutCode(dataMissingDto.getOutPutCode());
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
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "传输有效率预警导出", businessType = BusinessType.EXPORT)
    @PostMapping("/alarm/transmissionEfficiency/export")
    public void transmissionEfficiency(HttpServletResponse response, DataEfficiencyDto dataEfficiencyDto) {
//        List<TDataGasoutDayStatistics> list = tDataGasoutDayStatisticsService.selectTDataGasoutYearStatisticsList(tDataGasoutStatisticsDTO);
        ExcelUtil<DataEfficiencyDto> util = new ExcelUtil<>(DataEfficiencyDto.class);
        util.exportExcel(response, new ArrayList<>(), "传输有效率预警导出");
    }

    //小时预警
    @ApiOperation("首页统计排口数据")
    @GetMapping("/index/hourlyWarning")
    public R<List<HourlyWarningDto>> indexHourlyWarning(OutControlHourDto outControlHourDto) {
        List<HourlyWarningDto> list = new ArrayList<>();
        outControlHourDto.setOutPutEnum(OutPutEnum.GASOUT);
        List<TDataGasoutControlHour> gasoutList = tDataGasoutControlHourService.selectTDataGasoutControlHourList(outControlHourDto);

        //对gasoutList进行聚合
        Map<String,List<TDataGasoutControlHour>> map = gasoutList.stream().collect(
                Collectors.groupingBy(tDataGasoutControlHour -> tDataGasoutControlHour.getEntCode()+"_"+tDataGasoutControlHour.getOutPutCode()+"_"+tDataGasoutControlHour.getOutPutName()));
        List<HourlyWarningDto> gasoutControlHourList = map.entrySet().stream().map(key -> {
            String[] keyArr = key.getKey().split("_");
            HourlyWarningDto hourlyWarningDto = new HourlyWarningDto();
            hourlyWarningDto.setEntCode(keyArr[0]);
            hourlyWarningDto.setOutPutCode(keyArr[1]);
            hourlyWarningDto.setOutPutName(keyArr[2]);
            hourlyWarningDto.setOutPutType(OutPutEnum.GASOUT.getCode());
            hourlyWarningDto.setGasoutControlHourList(map.get(key.getKey()));
            //查询当天分钟数据
            GasoutDTO gasoutDTO = new GasoutDTO();
            gasoutDTO.setEntCode(keyArr[0]);
            gasoutDTO.setOutPutCode(keyArr[1]);
            gasoutDTO.setDataEnum(DataEnum.minute);
            gasoutDTO.setParams(getParams());
            TableDataInfo tableDataInfo = gasoutService.selectDataList(gasoutDTO);
//            hourlyWarningDto.setGasoutRealOrMinuteStatisticsList((List<TDataGasoutRealOrMinuteStatistics>) tableDataInfo.getRows());
            setHourlyWarningDto(hourlyWarningDto,tableDataInfo);
            return hourlyWarningDto;
        }
        ).collect(Collectors.toList());

        outControlHourDto.setOutPutEnum(OutPutEnum.WATEROUT);
        List<TDataWateroutControlHour> waterList = tDataWateroutControlHourService.selectTDataWateroutControlHourList(outControlHourDto);
        //对waterList进行聚合
        Map<String,List<TDataWateroutControlHour>> waterMap = waterList.stream().collect(
                Collectors.groupingBy(tDataWateroutControlHour -> tDataWateroutControlHour.getEntCode()+"_"+tDataWateroutControlHour.getOutPutCode()+"_"+tDataWateroutControlHour.getOutPutName()));
        List<HourlyWarningDto> waterControlHourList = waterMap.entrySet().stream().map(key -> {
            String[] keyArr = key.getKey().split("_");
            HourlyWarningDto hourlyWarningDto = new HourlyWarningDto();
            hourlyWarningDto.setEntCode(keyArr[0]);
            hourlyWarningDto.setOutPutCode(keyArr[1]);
            hourlyWarningDto.setOutPutName(keyArr[2]);
            hourlyWarningDto.setOutPutType(OutPutEnum.WATEROUT.getCode());
            hourlyWarningDto.setWateroutControlHourList(waterMap.get(key.getKey()));

            //查询当天分钟数据
            WateroutDTO wateroutDTO = new WateroutDTO();
            wateroutDTO.setEntCode(keyArr[0]);
            wateroutDTO.setOutPutCode(keyArr[1]);
            wateroutDTO.setDataEnum(DataEnum.minute);
            wateroutDTO.setParams(getParams());
            TableDataInfo tableDataInfo = wateroutService.selectDataList(wateroutDTO);
//            hourlyWarningDto.setWateroutRealOrMinuteStatisticsList((List<TDataWateroutRealOrMinuteStatistics>) tableDataInfo.getRows());
            return hourlyWarningDto;
        }).collect(Collectors.toList());
        //list 合并 gasoutControlHourList waterControlHourList
        list.addAll(gasoutControlHourList);
        list.addAll(waterControlHourList);
        return R.ok(list);
    }

    //TODO  分页优化
    @Deprecated
    @ApiOperation("首页统计排口数据")
    @GetMapping("/index/hourlyWarningPage")
    public TableDataInfo hourlyWarningPage(OutControlHourDto outControlHourDto) {
        startPage();
        List<HourlyWarningDto> list = new ArrayList<>();
        outControlHourDto.setOutPutEnum(OutPutEnum.GASOUT);
        List<TDataGasoutControlHour> gasoutList = tDataGasoutControlHourService.selectTDataGasoutControlHourList(outControlHourDto);

        //对gasoutList进行聚合
        Map<String,List<TDataGasoutControlHour>> map = gasoutList.stream().collect(
                Collectors.groupingBy(tDataGasoutControlHour -> tDataGasoutControlHour.getEntCode()+"_"+tDataGasoutControlHour.getOutPutCode()+"_"+tDataGasoutControlHour.getOutPutName()));

        List<HourlyWarningDto> gasoutControlHourList = map.entrySet().stream().map(key -> {
                    String[] keyArr = key.getKey().split("_");
                    HourlyWarningDto hourlyWarningDto = new HourlyWarningDto();
                    hourlyWarningDto.setEntCode(keyArr[0]);
                    hourlyWarningDto.setOutPutCode(keyArr[1]);
                    hourlyWarningDto.setOutPutName(keyArr[2]);
                    hourlyWarningDto.setOutPutType(OutPutEnum.GASOUT.getCode());
                    hourlyWarningDto.setGasoutControlHourList(map.get(key.getKey()));
                    //查询当天分钟数据
                    GasoutDTO gasoutDTO = new GasoutDTO();
                    gasoutDTO.setEntCode(keyArr[0]);
                    gasoutDTO.setOutPutCode(keyArr[1]);
                    gasoutDTO.setDataEnum(DataEnum.minute);
                    gasoutDTO.setParams(getParams());
                    TableDataInfo tableDataInfo = gasoutService.selectDataList(gasoutDTO);
                    setHourlyWarningDto(hourlyWarningDto,tableDataInfo);
                    //hourlyWarningDto.setGasoutRealOrMinuteStatisticsList((List<TDataGasoutRealOrMinuteStatistics>) tableDataInfo.getRows());
                    return hourlyWarningDto;
                }
        ).collect(Collectors.toList());

        outControlHourDto.setOutPutEnum(OutPutEnum.WATEROUT);
        List<TDataWateroutControlHour> waterList = tDataWateroutControlHourService.selectTDataWateroutControlHourList(outControlHourDto);
        //对waterList进行聚合
        Map<String,List<TDataWateroutControlHour>> waterMap = waterList.stream().collect(
                Collectors.groupingBy(tDataWateroutControlHour -> tDataWateroutControlHour.getEntCode()+"_"+tDataWateroutControlHour.getOutPutCode()+"_"+tDataWateroutControlHour.getOutPutName()));
        List<HourlyWarningDto> waterControlHourList = waterMap.entrySet().stream().map(key -> {
            String[] keyArr = key.getKey().split("_");
            HourlyWarningDto hourlyWarningDto = new HourlyWarningDto();
            hourlyWarningDto.setEntCode(keyArr[0]);
            hourlyWarningDto.setOutPutCode(keyArr[1]);
            hourlyWarningDto.setOutPutName(keyArr[2]);
            hourlyWarningDto.setOutPutType(OutPutEnum.WATEROUT.getCode());
            hourlyWarningDto.setWateroutControlHourList(waterMap.get(key.getKey()));

            //查询当天分钟数据
            WateroutDTO wateroutDTO = new WateroutDTO();
            wateroutDTO.setEntCode(keyArr[0]);
            wateroutDTO.setOutPutCode(keyArr[1]);
            wateroutDTO.setDataEnum(DataEnum.minute);
            wateroutDTO.setParams(getParams());
            TableDataInfo tableDataInfo = wateroutService.selectDataList(wateroutDTO);
//            hourlyWarningDto.setWateroutRealOrMinuteStatisticsList((List<TDataWateroutRealOrMinuteStatistics>) tableDataInfo.getRows());
            return hourlyWarningDto;
        }).collect(Collectors.toList());
        //list 合并 gasoutControlHourList waterControlHourList
        list.addAll(gasoutControlHourList);
        list.addAll(waterControlHourList);
        return getDataTable(list);
    }

    private void setHourlyWarningDto (HourlyWarningDto hourlyWarningDto,TableDataInfo tableDataInfo){
        hourlyWarningDto.getGasoutControlHourList().forEach(t -> {
            log.info("hourlyWarningDto:{},t:{};{}",hourlyWarningDto,t.getPollutantNameCn(),tableDataInfo.getRows());
           List<Map<String,Object>> result = new ArrayList<>();
           if(StrUtil.equals(hourlyWarningDto.getOutPutType(),"gasout")){
               if(StrUtil.equals(t.getPollutantNameCn(),"二氧化硫")) {
                   tableDataInfo.getRows().forEach(t1 -> {
                       log.info("t1:{}",t1);
                       Map<String,Object> map = new HashMap<>();
                       map.put("monTime",((TDataGasoutMonthStatistics)t1).getMonitorTime());
                       map.put("avgValue",((TDataGasoutMonthStatistics)t1).getSo2AvgValue());
                       map.put("zsavgValue",((TDataGasoutMonthStatistics)t1).getSo2ZsavgValue());
                       result.add(map);
                   });
               }else if(StrUtil.equals(t.getPollutantNameCn(),"氮氧化物")) {
                   tableDataInfo.getRows().forEach(t1 -> {
                       Map<String,Object> map = new HashMap<>();
                       map.put("monTime",((TDataGasoutMonthStatistics)t1).getMonitorTime());
                       map.put("avgValue",((TDataGasoutMonthStatistics)t1).getNoAvgValue());
                       map.put("zsavgValue",((TDataGasoutMonthStatistics)t1).getNoZsavgValue());
                       result.add(map);
                   });
               }else if(StrUtil.equals(t.getPollutantNameCn(),"烟尘")) {
                   tableDataInfo.getRows().forEach(t1 -> {
                       Map<String,Object> map = new HashMap<>();
                       map.put("monTime",((TDataGasoutMonthStatistics)t1).getMonitorTime());
                       map.put("avgValue",((TDataGasoutMonthStatistics)t1).getYcAvgValue());
                       map.put("zsavgValue",((TDataGasoutMonthStatistics)t1).getYcZsavgValue());
                       result.add(map);
                   });
               }
           }

            t.setDataList(result);
        });
    }

    private Map<String, Object> getParams() {
        Map<String, Object> params = MapUtil.newHashMap();
        params.put("beginTime",DateUtil.format(DateUtil.beginOfDay(DateUtil.date()), "yyyy-MM-dd HH:mm") );
        params.put("endTime", DateUtil.format(DateUtil.endOfDay(DateUtil.date()), "yyyy-MM-dd HH:mm") );
        return params;
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
    //@PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
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


    @Resource
    private ITDataGasoutHourStatisticsService tDataGasoutHourStatisticsService;

    /**
     * 查询废水排口--月统计数据列表
     * TODO 待确定统计需求开发
     * 达标率=达标数据条数/总数据条数  2024-12-14 增加根据排口统计达标率
     */
    @ApiOperation("获取首页统计数据")
    @GetMapping("/index")
    public R index(IndexDataDto indexDataDto) {
        //达标率、传输有效率、今日标记完成率
        IndexDataDto.Statistics achievementRateDto = new IndexDataDto.Statistics ();
        IndexDataDto.Statistics  transmissionEfficiencyDto = new IndexDataDto.Statistics ();
        IndexDataDto.Statistics  todayCompletionRateDto = new IndexDataDto.Statistics ();
        if(ObjUtil.isNotNull(indexDataDto)){
            if(StrUtil.equals(indexDataDto.getOutPutType(),"gasout") && StrUtil.isNotEmpty(indexDataDto.getOutPutCode())&& StrUtil.isNotEmpty(indexDataDto.getEntCode())){
                TDataGasoutHourStatistics tDataGasoutHourStatistics = new TDataGasoutHourStatistics();
                tDataGasoutHourStatistics.setEntCode(indexDataDto.getEntCode());
                tDataGasoutHourStatistics.setOutPutCode(indexDataDto.getOutPutCode());
                float total = tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsCount(tDataGasoutHourStatistics);

                HashMap<String, Object> params = MapUtil.newHashMap();
                params.put("isAlarm",true);
                tDataGasoutHourStatistics.setParams(params);
                float complete = total - tDataGasoutHourStatisticsService.selectTDataGasoutHourStatisticsCount(tDataGasoutHourStatistics);
                achievementRateDto.setTotal(total);
                achievementRateDto.setComplete(complete);
                achievementRateDto.setRate(complete/total);
            }else if(StrUtil.equals(indexDataDto.getOutPutType(),"waterout")){
                //TODO 待确定统计需求开发

            }



        }


        indexDataDto.setAchievementRateDto(achievementRateDto);
        indexDataDto.setTransmissionEfficiencyDto(transmissionEfficiencyDto);
        indexDataDto.setTodayCompletionRateDto(todayCompletionRateDto);
        return R.ok(indexDataDto);
    }

}
@Data
class IndexDataDto{
    private String entCode;
    private String outPutCode;
    private String outPutType;

    //达标率
    Statistics achievementRateDto;
    //传输有效率
    Statistics transmissionEfficiencyDto;
    //今日标记完成率
    Statistics todayCompletionRateDto;
    @Data
    static
    class Statistics{
        //总数
        private float total;
        //已完成
        private float complete;
        //比率
        private float rate;
    }
}

