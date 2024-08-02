package com.ruoyi.business.statistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.business.onlineMonitoring.dto.DataEnum;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 废气排口--日报统计数据对象 t_data_gasout_day_statistics
 *
 * @author lx
 * @date 2024-07-08
 */
@Data
public class TDataGasoutDayStatistics extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 企业code
     */
    @Excel(name = "企业code")
    private String entCode;

    /**
     * 企业名称
     */
    @Excel(name = "企业名称")
    private String entName;

    /**
     * 废气排口code
     */
    @Excel(name = "废气排口code")
    private String outPutCode;

    /**
     * 废气排口名称
     */
    @Excel(name = "废气排口名称")
    private String outPutName;

    /**
     * 数据监测时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "数据监测时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date monitorTime;

    /**
     * 废气流量均值
     */
    @Excel(name = "废气流量均值")
    private String volumeAvgFlow;

    /**
     * 废气总流量
     */
    @Excel(name = "废气总流量")
    private String volumeTotalFlow;

    /**
     * 流速
     */
    @Excel(name = "流速")
    private String velocityFlow;

    /**
     * 烟尘均值
     */
    @Excel(name = "烟尘均值")
    private String ycAvgValue;

    /**
     * 烟尘折算值
     */
    @Excel(name = "烟尘折算值")
    private String ycZsavgValue;

    /**
     * 烟尘排放量
     */
    @Excel(name = "烟尘排放量")
    private String ycEmissions;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String ycIsAlarm;

    /**
     * so2均值
     */
    @Excel(name = "so2均值")
    private String so2AvgValue;

    /**
     * so2折算均值
     */
    @Excel(name = "so2折算均值")
    private String so2ZsavgValue;

    /**
     * so2排放量
     */
    @Excel(name = "so2排放量")
    private String so2Emissions;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String so2IsAlarm;

    /**
     * 氮氧化物均值
     */
    @Excel(name = "氮氧化物均值")
    private String noAvgValue;

    /**
     * 氮氧化物折算均值
     */
    @Excel(name = "氮氧化物折算均值")
    private String noZsavgValue;

    /**
     * 氮氧化物排放量
     */
    @Excel(name = "氮氧化物排放量")
    private String noEmissions;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String noSiAlarm;

    /**
     * 氧含量
     */
    @Excel(name = "氧含量")
    private String oxygenContent;

    /**
     * 烟气温度
     */
    @Excel(name = "烟气温度")
    private String yqTemperature;

    /**
     * 烟气湿度
     */
    @Excel(name = "烟气湿度")
    private String yqHumidity;

    /**
     * 烟气静压
     */
    @Excel(name = "烟气静压")
    private String yqPressure;
    private DataEnum dataEnum;
}
