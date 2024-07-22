package com.ruoyi.business.statisticsAlarm.dto;

import com.ruoyi.business.common.BaseDto;
import io.swagger.annotations.ApiParam;
import lombok.Data;


/**
 * 数据缺失dto
 */
@Data
public class DataEmissionDto extends BaseDto {
    /**
     * 排口名称
     */
    @ApiParam(name = "outPutName", value = "排口名称")
    private String outPutName;
    /**
     * 接口类型
     */
    @ApiParam(name = "outPutEnum", value = "接口类型")
    private OutPutEnum outPutEnum;

    // 许可排放污染物（这里假设是一个列表或数组，因为通常不会只针对一种污染物设定许可）
    @ApiParam(name = "permittedPollutants", value = "许可排放污染物")
    private String permittedPollutants; // 或者使用具体的类，比如Pollutant对象列表

    // 累计排放量（这里假设是针对所有污染物的总累计量，或者可以针对每种污染物分别定义）
    @ApiParam(name = "totalCumulativeEmission", value = "累计排放量")
    private double totalCumulativeEmission; // 如果需要针对每种污染物，则可能需要一个Map或列表来存储

    // 许可排放量（同样，这里假设是针对所有污染物的总许可量）
    @ApiParam(name = "permittedEmissionLimit", value = "许可排放量")
    private double permittedEmissionLimit; // 如果需要细分，则处理方式与累计排放量类似

    // 状态（这取决于状态的具体含义，比如是否超过许可、是否运行中等）
    @ApiParam(name = "status", value = "状态")
    private String status; // 或者使用枚举类型Enum来定义可能的状态，如StatusEnum status;
}
