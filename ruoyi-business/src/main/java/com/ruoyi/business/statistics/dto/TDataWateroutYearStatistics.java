package com.ruoyi.business.statistics.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.business.onlineMonitoring.dto.DataEnum;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 废水排口--日报统计数据对象 t_data_waterout_day_statistics
 *
 * @author lx
 * @date 2024-07-08
 */
@Data
public class TDataWateroutYearStatistics extends BaseEntity {
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
     * 监测时间
     */
    @JsonFormat(pattern = "yyyy")
    @Excel(name = "数据监测时间", width = 30, dateFormat = "yyyy")
    private Date monitorTime;

    private String monitorTimeStr;

    /**
     * 废水流量均值
     */
    @Excel(name = "废水流量均值")
    private String volumeAvgFlow;

    /**
     * 废水总流量
     */
    @Excel(name = "废水总流量")
    private String volumeTotalFlow;

    /**
     * PH值
     */
    @Excel(name = "PH值")
    private String phValue;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String phIsAlarm;

    /**
     * 氨氮均值
     */
    @Excel(name = "氨氮均值")
    private String anAvgValue;

    /**
     * 氨氮排放量
     */
    @Excel(name = "氨氮排放量")
    private String anEmissions;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String anIsAlarm;

    /**
     * 化学需氧量均值
     */
    @Excel(name = "化学需氧量均值")
    private String codAvgValue;

    /**
     * 化学需氧量排放量
     */
    @Excel(name = "化学需氧量排放量")
    private String codEmissions;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String codIsAlarm;

    /**
     * 氮氧化物均值
     */
    @Excel(name = "氮氧化物均值")
    private String noAvgValue;

    /**
     * 氮氧化物排放量
     */
    @Excel(name = "氮氧化物排放量 ")
    private String noEmissions;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String noIsAlarm;

    /**
     * 总磷均值
     */
    @Excel(name = "总磷均值")
    private String tpAvgValue;

    /**
     * 总磷排放量
     */
    @Excel(name = "总磷排放量 ")
    private String tpEmissions;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String tpIsAlarm;

    /**
     * 总氮均值
     */
    @Excel(name = "总氮均值")
    private String tnAvgValue;

    /**
     * 总氮排放量
     */
    @Excel(name = "总氮排放量")
    private String tnEmissions;

    /**
     * 报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警
     */
    @Excel(name = "报警状态：0：正常；1：区间报警；2：超大值报警；3：超小值报警；4：零值报警；5：恒值报警")
    private String tnIsAlarm;

    private DataEnum dataEnum;

}
