package com.ruoyi.business.statisticsAlarm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 排口小时报警统计视图对象 v_out_put_hour_statistics
 *
 * @author lx
 * @date 2024-07-19
 */
public class VOutPutHourStatistics extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 企业名称
     */
    @Excel(name = "企业名称")
    private String entName;

    /**
     * 企业编码
     */
    @Excel(name = "企业编码")
    private String entCode;

    /**
     * 排口编码
     */
    @Excel(name = "排口编码")
    private String outPutCode;

    /**
     * 排口名称
     */
    @Excel(name = "排口名称")
    private String outPutName;

    /**
     * 监测时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH")
    @Excel(name = "监测时间", width = 30, dateFormat = "yyyy-MM-dd HH")
    private Date monitorTime;

    /**
     * 排口类型
     */
    @Excel(name = "排口类型")
    private String outPutType;

    /**
     * 污染物名称
     */
    @Excel(name = "污染物名称")
    private String pollutantNameCn;

    /**
     * 报警状态
     */
    @Excel(name = "报警状态")
    private String alarm;

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode;
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

    public String getOutPutType() {
        return outPutType;
    }

    public void setOutPutType(String outPutType) {
        this.outPutType = outPutType;
    }

    public String getPollutantNameCn() {
        return pollutantNameCn;
    }

    public void setPollutantNameCn(String pollutantNameCn) {
        this.pollutantNameCn = pollutantNameCn;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("entName", getEntName())
                .append("entCode", getEntCode())
                .append("outPutCode", getOutPutCode())
                .append("outPutName", getOutPutName())
                .append("monitorTime", getMonitorTime())
                .append("outPutType", getOutPutType())
                .append("pollutantNameCn", getPollutantNameCn())
                .append("alarm", getAlarm())
                .toString();
    }
}
