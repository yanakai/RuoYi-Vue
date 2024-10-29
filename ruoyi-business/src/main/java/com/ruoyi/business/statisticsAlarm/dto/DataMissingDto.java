package com.ruoyi.business.statisticsAlarm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.business.common.BaseDto;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

/**
 * 数据缺失dto
 */
@Data
public class DataMissingDto extends BaseDto {
    /**
     * 排口名称
     */
    @ApiParam(name = "outPutName", value = "排口名称",hidden = true)
    private String outPutName;

    @ApiParam(name = "outPutCode" ,value = "接口编码")
    private String outPutCode;

    /**
     * 接口类型
     */
    @ApiParam(name = "outPutEnum", value = "接口类型")
    private OutPutEnum outPutEnum;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "监测时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date monitorTime;

    private String missingTime;

    private String entCode;

    private String alarmType;
}
