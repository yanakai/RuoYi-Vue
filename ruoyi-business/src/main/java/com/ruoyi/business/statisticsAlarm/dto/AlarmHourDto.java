package com.ruoyi.business.statisticsAlarm.dto;

import com.ruoyi.business.common.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@ApiModel
@Data
public class AlarmHourDto extends BaseDto {
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
    @ApiParam(name = "outPutEnum", value = "接口类型")
    private OutPutEnum outPutEnum;
}
