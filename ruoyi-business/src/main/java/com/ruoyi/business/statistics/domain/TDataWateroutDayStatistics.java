package com.ruoyi.business.statistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 废水排口--日报统计数据对象 t_data_waterout_day_statistics
 *
 * @author lx
 * @date 2024-07-08
 */
public class TDataWateroutDayStatistics extends BaseEntity {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "监测时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date monitorTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getOutPutCode() {
        return outPutCode;
    }

    public void setOutPutCode(String outPutCode) {
        this.outPutCode = outPutCode;
    }

    public String getOutPutName() {
        return outPutName;
    }

    public void setOutPutName(String outPutName) {
        this.outPutName = outPutName;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public String getVolumeAvgFlow() {
        return volumeAvgFlow;
    }

    public void setVolumeAvgFlow(String volumeAvgFlow) {
        this.volumeAvgFlow = volumeAvgFlow;
    }

    public String getVolumeTotalFlow() {
        return volumeTotalFlow;
    }

    public void setVolumeTotalFlow(String volumeTotalFlow) {
        this.volumeTotalFlow = volumeTotalFlow;
    }

    public String getPhValue() {
        return phValue;
    }

    public void setPhValue(String phValue) {
        this.phValue = phValue;
    }

    public String getPhIsAlarm() {
        return phIsAlarm;
    }

    public void setPhIsAlarm(String phIsAlarm) {
        this.phIsAlarm = phIsAlarm;
    }

    public String getAnAvgValue() {
        return anAvgValue;
    }

    public void setAnAvgValue(String anAvgValue) {
        this.anAvgValue = anAvgValue;
    }

    public String getAnEmissions() {
        return anEmissions;
    }

    public void setAnEmissions(String anEmissions) {
        this.anEmissions = anEmissions;
    }

    public String getAnIsAlarm() {
        return anIsAlarm;
    }

    public void setAnIsAlarm(String anIsAlarm) {
        this.anIsAlarm = anIsAlarm;
    }

    public String getCodAvgValue() {
        return codAvgValue;
    }

    public void setCodAvgValue(String codAvgValue) {
        this.codAvgValue = codAvgValue;
    }

    public String getCodEmissions() {
        return codEmissions;
    }

    public void setCodEmissions(String codEmissions) {
        this.codEmissions = codEmissions;
    }

    public String getCodIsAlarm() {
        return codIsAlarm;
    }

    public void setCodIsAlarm(String codIsAlarm) {
        this.codIsAlarm = codIsAlarm;
    }

    public String getNoAvgValue() {
        return noAvgValue;
    }

    public void setNoAvgValue(String noAvgValue) {
        this.noAvgValue = noAvgValue;
    }

    public String getNoEmissions() {
        return noEmissions;
    }

    public void setNoEmissions(String noEmissions) {
        this.noEmissions = noEmissions;
    }

    public String getNoIsAlarm() {
        return noIsAlarm;
    }

    public void setNoIsAlarm(String noIsAlarm) {
        this.noIsAlarm = noIsAlarm;
    }

    public String getTpAvgValue() {
        return tpAvgValue;
    }

    public void setTpAvgValue(String tpAvgValue) {
        this.tpAvgValue = tpAvgValue;
    }

    public String getTpEmissions() {
        return tpEmissions;
    }

    public void setTpEmissions(String tpEmissions) {
        this.tpEmissions = tpEmissions;
    }

    public String getTpIsAlarm() {
        return tpIsAlarm;
    }

    public void setTpIsAlarm(String tpIsAlarm) {
        this.tpIsAlarm = tpIsAlarm;
    }

    public String getTnAvgValue() {
        return tnAvgValue;
    }

    public void setTnAvgValue(String tnAvgValue) {
        this.tnAvgValue = tnAvgValue;
    }

    public String getTnEmissions() {
        return tnEmissions;
    }

    public void setTnEmissions(String tnEmissions) {
        this.tnEmissions = tnEmissions;
    }

    public String getTnIsAlarm() {
        return tnIsAlarm;
    }

    public void setTnIsAlarm(String tnIsAlarm) {
        this.tnIsAlarm = tnIsAlarm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("entCode", getEntCode())
                .append("entName", getEntName())
                .append("outPutCode", getOutPutCode())
                .append("outPutName", getOutPutName())
                .append("monitorTime", getMonitorTime())
                .append("updateTime", getUpdateTime())
                .append("volumeAvgFlow", getVolumeAvgFlow())
                .append("volumeTotalFlow", getVolumeTotalFlow())
                .append("phValue", getPhValue())
                .append("phIsAlarm", getPhIsAlarm())
                .append("anAvgValue", getAnAvgValue())
                .append("anEmissions", getAnEmissions())
                .append("anIsAlarm", getAnIsAlarm())
                .append("codAvgValue", getCodAvgValue())
                .append("codEmissions", getCodEmissions())
                .append("codIsAlarm", getCodIsAlarm())
                .append("noAvgValue", getNoAvgValue())
                .append("noEmissions", getNoEmissions())
                .append("noIsAlarm", getNoIsAlarm())
                .append("tpAvgValue", getTpAvgValue())
                .append("tpEmissions", getTpEmissions())
                .append("tpIsAlarm", getTpIsAlarm())
                .append("tnAvgValue", getTnAvgValue())
                .append("tnEmissions", getTnEmissions())
                .append("tnIsAlarm", getTnIsAlarm())
                .toString();
    }
}
