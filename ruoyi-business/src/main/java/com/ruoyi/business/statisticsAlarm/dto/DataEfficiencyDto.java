package com.ruoyi.business.statisticsAlarm.dto;

import com.ruoyi.business.common.BaseDto;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

/**
 * 传输有效率预警dto
 */
@Data
public class DataEfficiencyDto extends BaseDto {
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

    private Date monitorTime;

    // 应当有效个数
    private int expectedValidCount;

    // 实际有效个数
    private int actualValidCount;

    // 有效率
    private double effectivenessRate; // 或者使用float，取决于您需要的精度

}
