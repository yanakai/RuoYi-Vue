package com.ruoyi.business.statisticsAlarm.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 废气排口--小时剩余排放平均值对象 t_data_gasout_control_hour
 *
 * @author lx
 * @date 2024-07-13
 */
public class TDataGasoutControlHour extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 企业编码
     */
    @Excel(name = "企业编码")
    private String entCode;

    /**
     * 企业名称
     */
    @Excel(name = "企业名称")
    private String entName;

    /**
     * 废气排口编码
     */
    @Excel(name = "废气排口编码")
    private String outPutCode;

    /**
     * 废气排口名称
     */
    @Excel(name = "废气排口名称")
    private String outPutName;

    /**
     * 污染因子编码
     */
    private String pollutantCode;

    /**
     * 污染因子名称--英文
     */
    private String pollutantNameEn;

    /**
     * 污染因子名称--中文
     */
    private String pollutantNameCn;

    /**
     * 污染物浓度限值
     */
    private String standardValue;

    /**
     * 当前小时污染物累计平均值
     */
    private String avgValue;

    /**
     * 当前小时剩余控制平均值
     */
    private String surplusValue;


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

    public String getPollutantNameEn() {
        return pollutantNameEn;
    }

    public void setPollutantNameEn(String pollutantNameEn) {
        this.pollutantNameEn = pollutantNameEn;
    }

    public String getPollutantNameCn() {
        return pollutantNameCn;
    }

    public void setPollutantNameCn(String pollutantNameCn) {
        this.pollutantNameCn = pollutantNameCn;
    }

    public String getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue;
    }

    public String getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(String avgValue) {
        this.avgValue = avgValue;
    }

    public String getSurplusValue() {
        return surplusValue;
    }

    public void setSurplusValue(String surplusValue) {
        this.surplusValue = surplusValue;
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
                .append("pollutantNameEn", getPollutantNameEn())
                .append("pollutantNameCn", getPollutantNameCn())
                .append("standardValue", getStandardValue())
                .append("avgValue", getAvgValue())
                .append("surplusValue", getSurplusValue())
                .toString();
    }
}
