package com.ruoyi.business.statisticsAlarm.dto;

import com.ruoyi.business.common.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@ApiModel
@Data
public class AlarmEmissionsDto extends BaseDto {
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
    private String outPutType; // 产出类型
    @ApiParam(name = "monitoringPointType", value = "监测点类型：1 废水 2 废气")
    private String monitoringPointType; // 监测点类型
    private String pollutantNameCn; // 污染物名称（中文）
    private Double emissions; // 排放量（总和）
    private Double annualLimitValue; // 年度限值
    private String monthlyLimitValue;// 月度限值--预留字段（逗号分隔，12个值）
}
