package com.ruoyi.business.statisticsAlarm.dto;

import com.ruoyi.business.statistics.dto.TDataGasoutRealOrMinuteStatistics;
import com.ruoyi.business.statistics.dto.TDataWateroutRealOrMinuteStatistics;
import com.ruoyi.business.statisticsAlarm.domain.TDataGasoutControlHour;
import com.ruoyi.business.statisticsAlarm.domain.TDataWateroutControlHour;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.List;

@Data
public class HourlyWarningDto {

    private static final long serialVersionUID = 1L;
    @ApiParam(name = "entName", value = "企业名称")
    private String entName;
    @ApiParam(name = "entCode", value = "企业编码")
    private String entCode;
    /**
     * 排口编码
     */
    @ApiParam(name = "outPutCode", value = "排口编码")
    private String outPutCode;
    /**
     * 排口名称
     */
    @ApiParam(name = "outPutName", value = "排口名称")
    private String outPutName;

    @ApiParam(name = "outputType", value = "排口类型 废水、废气")
    private String outPutType; //

    //污染物因子数据
    private List<TDataGasoutControlHour> gasoutControlHourList;

    private List<TDataWateroutControlHour> wateroutControlHourList;
    //分钟数据list
    private List<TDataGasoutRealOrMinuteStatistics> gasoutRealOrMinuteStatisticsList;

    private List<TDataWateroutRealOrMinuteStatistics> wateroutRealOrMinuteStatisticsList;
}