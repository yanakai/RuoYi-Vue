package com.ruoyi.business.statistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 废水排口--小时报统计数据对象 t_data_waterout_hour_statistics
 *
 * @author lx
 * @date 2024-07-04
 */
public class TDataWateroutHourStatistics extends BaseEntity {
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
     * 污染因子code
     */
    @Excel(name = "污染因子code")
    private String pollutantCode;

    /**
     * 监测时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "监测时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date monitorTime;

    /**
     * 流量
     */
    @Excel(name = "流量")
    private String volumeFlow;

    /**
     * PH值
     */
    @Excel(name = "PH值")
    private String phValue;

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
     * 氮氧化物均值
     */
    @Excel(name = "氮氧化物均值")
    private String noValue;

    /**
     * 氮氧化物排放量
     */
    @Excel(name = "氮氧化物排放量 ")
    private String noEmissions;

    /**
     * 总磷均值
     */
    @Excel(name = "总磷均值")
    private String tpValue;

    /**
     * 总磷排放量
     */
    @Excel(name = "总磷排放量 ")
    private String tpEmissions;

    /**
     * 总氮均值
     */
    @Excel(name = "总氮均值")
    private String tnValue;

    /**
     * 总氮排放量
     */
    @Excel(name = "总氮排放量")
    private String tnEmissions;

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

    public String getPollutantCode() {
        return pollutantCode;
    }

    public void setPollutantCode(String pollutantCode) {
        this.pollutantCode = pollutantCode;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public String getVolumeFlow() {
        return volumeFlow;
    }

    public void setVolumeFlow(String volumeFlow) {
        this.volumeFlow = volumeFlow;
    }

    public String getPhValue() {
        return phValue;
    }

    public void setPhValue(String phValue) {
        this.phValue = phValue;
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

    public String getNoValue() {
        return noValue;
    }

    public void setNoValue(String noValue) {
        this.noValue = noValue;
    }

    public String getNoEmissions() {
        return noEmissions;
    }

    public void setNoEmissions(String noEmissions) {
        this.noEmissions = noEmissions;
    }

    public String getTpValue() {
        return tpValue;
    }

    public void setTpValue(String tpValue) {
        this.tpValue = tpValue;
    }

    public String getTpEmissions() {
        return tpEmissions;
    }

    public void setTpEmissions(String tpEmissions) {
        this.tpEmissions = tpEmissions;
    }

    public String getTnValue() {
        return tnValue;
    }

    public void setTnValue(String tnValue) {
        this.tnValue = tnValue;
    }

    public String getTnEmissions() {
        return tnEmissions;
    }

    public void setTnEmissions(String tnEmissions) {
        this.tnEmissions = tnEmissions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("entCode", getEntCode())
                .append("entName", getEntName())
                .append("outPutCode", getOutPutCode())
                .append("outPutName", getOutPutName())
                .append("pollutantCode", getPollutantCode())
                .append("monitorTime", getMonitorTime())
                .append("updateTime", getUpdateTime())
                .append("volumeFlow", getVolumeFlow())
                .append("phValue", getPhValue())
                .append("anAvgValue", getAnAvgValue())
                .append("anEmissions", getAnEmissions())
                .append("codAvgValue", getCodAvgValue())
                .append("codEmissions", getCodEmissions())
                .append("noValue", getNoValue())
                .append("noEmissions", getNoEmissions())
                .append("tpValue", getTpValue())
                .append("tpEmissions", getTpEmissions())
                .append("tnValue", getTnValue())
                .append("tnEmissions", getTnEmissions())
                .toString();
    }
}
