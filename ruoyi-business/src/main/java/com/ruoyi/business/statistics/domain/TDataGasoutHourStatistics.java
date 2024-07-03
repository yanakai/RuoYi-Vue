package com.ruoyi.business.statistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 废气排口--小时报统计数据对象 t_data_gasout_hour_statistics
 *
 * @author lx
 * @date 2024-07-04
 */
public class TDataGasoutHourStatistics extends BaseEntity {
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
     * 流量
     */
    @Excel(name = "流量")
    private String volumeFlow;

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
    private String ycIsAlram;

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

    public String getVolumeFlow() {
        return volumeFlow;
    }

    public void setVolumeFlow(String volumeFlow) {
        this.volumeFlow = volumeFlow;
    }

    public String getVelocityFlow() {
        return velocityFlow;
    }

    public void setVelocityFlow(String velocityFlow) {
        this.velocityFlow = velocityFlow;
    }

    public String getYcAvgValue() {
        return ycAvgValue;
    }

    public void setYcAvgValue(String ycAvgValue) {
        this.ycAvgValue = ycAvgValue;
    }

    public String getYcZsavgValue() {
        return ycZsavgValue;
    }

    public void setYcZsavgValue(String ycZsavgValue) {
        this.ycZsavgValue = ycZsavgValue;
    }

    public String getYcEmissions() {
        return ycEmissions;
    }

    public void setYcEmissions(String ycEmissions) {
        this.ycEmissions = ycEmissions;
    }

    public String getYcIsAlram() {
        return ycIsAlram;
    }

    public void setYcIsAlram(String ycIsAlram) {
        this.ycIsAlram = ycIsAlram;
    }

    public String getSo2AvgValue() {
        return so2AvgValue;
    }

    public void setSo2AvgValue(String so2AvgValue) {
        this.so2AvgValue = so2AvgValue;
    }

    public String getSo2ZsavgValue() {
        return so2ZsavgValue;
    }

    public void setSo2ZsavgValue(String so2ZsavgValue) {
        this.so2ZsavgValue = so2ZsavgValue;
    }

    public String getSo2Emissions() {
        return so2Emissions;
    }

    public void setSo2Emissions(String so2Emissions) {
        this.so2Emissions = so2Emissions;
    }

    public String getSo2IsAlarm() {
        return so2IsAlarm;
    }

    public void setSo2IsAlarm(String so2IsAlarm) {
        this.so2IsAlarm = so2IsAlarm;
    }

    public String getNoAvgValue() {
        return noAvgValue;
    }

    public void setNoAvgValue(String noAvgValue) {
        this.noAvgValue = noAvgValue;
    }

    public String getNoZsavgValue() {
        return noZsavgValue;
    }

    public void setNoZsavgValue(String noZsavgValue) {
        this.noZsavgValue = noZsavgValue;
    }

    public String getNoEmissions() {
        return noEmissions;
    }

    public void setNoEmissions(String noEmissions) {
        this.noEmissions = noEmissions;
    }

    public String getNoSiAlarm() {
        return noSiAlarm;
    }

    public void setNoSiAlarm(String noSiAlarm) {
        this.noSiAlarm = noSiAlarm;
    }

    public String getOxygenContent() {
        return oxygenContent;
    }

    public void setOxygenContent(String oxygenContent) {
        this.oxygenContent = oxygenContent;
    }

    public String getYqTemperature() {
        return yqTemperature;
    }

    public void setYqTemperature(String yqTemperature) {
        this.yqTemperature = yqTemperature;
    }

    public String getYqHumidity() {
        return yqHumidity;
    }

    public void setYqHumidity(String yqHumidity) {
        this.yqHumidity = yqHumidity;
    }

    public String getYqPressure() {
        return yqPressure;
    }

    public void setYqPressure(String yqPressure) {
        this.yqPressure = yqPressure;
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
                .append("volumeFlow", getVolumeFlow())
                .append("velocityFlow", getVelocityFlow())
                .append("ycAvgValue", getYcAvgValue())
                .append("ycZsavgValue", getYcZsavgValue())
                .append("ycEmissions", getYcEmissions())
                .append("ycIsAlram", getYcIsAlram())
                .append("so2AvgValue", getSo2AvgValue())
                .append("so2ZsavgValue", getSo2ZsavgValue())
                .append("so2Emissions", getSo2Emissions())
                .append("so2IsAlarm", getSo2IsAlarm())
                .append("noAvgValue", getNoAvgValue())
                .append("noZsavgValue", getNoZsavgValue())
                .append("noEmissions", getNoEmissions())
                .append("noSiAlarm", getNoSiAlarm())
                .append("oxygenContent", getOxygenContent())
                .append("yqTemperature", getYqTemperature())
                .append("yqHumidity", getYqHumidity())
                .append("yqPressure", getYqPressure())
                .toString();
    }
}
