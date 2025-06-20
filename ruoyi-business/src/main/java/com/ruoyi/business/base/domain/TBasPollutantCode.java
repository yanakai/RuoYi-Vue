package com.ruoyi.business.base.domain;

import com.alibaba.fastjson2.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数采报文对应的污染因子关系 2017版本和2003版对象 t_bas_pollutant_code
 * 
 * @author lx
 * @date 2024-07-21
 */
public class TBasPollutantCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 2017版报文编码 */
    @Excel(name = "2017版报文编码")
    private String code2017;

    /** 2005版报文编码 */
    @Excel(name = "2005版报文编码")
    private String code2005;

    /** 污染因子实际编码--以HJ-2017协议为主 */
    @Excel(name = "污染因子实际编码--以HJ-2017协议为主")
    private String pollutantCode;

    /** 污染因子名称--英文 */
    @Excel(name = "污染因子名称--英文")
    private String pollutantNameEn;

    /** 污染因子名称--中文 */
    @Excel(name = "污染因子名称--中文")
    private String pollutantNameCn;

    /** 污染因子类型：1：废水；2：废气； */
    @Excel(name = "污染因子类型：1：废水；2：废气；")
    private Long pollutantType;

    /** 污染因子单位--英文 */
    @Excel(name = "污染因子单位--英文")
    private String pollutantUnitEn;

    /** 污染因子单位--中文 */
    @Excel(name = "污染因子单位--中文")
    private String pollutantUnitCn;

    /** 使用状态：0：未使用；1：正在使用 */
    @Excel(name = "使用状态：0：未使用；1：正在使用")
    private Long pollutantStatus;

    /** 排序码 */
    @Excel(name = "排序码")
    private Long pollutantSort;

    /** 监测因子 */
    @JsonIgnore
    private String monFactorStr;
    private JSONArray monFactor;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public String getCode2017() {
        return code2017;
    }

    public void setCode2017(String code2017) {
        this.code2017 = code2017;
    }

    public String getCode2005() {
        return code2005;
    }

    public void setCode2005(String code2005) {
        this.code2005 = code2005;
    }

    public void setPollutantCode(String pollutantCode)
    {
        this.pollutantCode = pollutantCode;
    }

    public String getPollutantCode() 
    {
        return pollutantCode;
    }
    public void setPollutantNameEn(String pollutantNameEn) 
    {
        this.pollutantNameEn = pollutantNameEn;
    }

    public String getPollutantNameEn() 
    {
        return pollutantNameEn;
    }
    public void setPollutantNameCn(String pollutantNameCn) 
    {
        this.pollutantNameCn = pollutantNameCn;
    }

    public String getPollutantNameCn() 
    {
        return pollutantNameCn;
    }
    public void setPollutantType(Long pollutantType) 
    {
        this.pollutantType = pollutantType;
    }

    public Long getPollutantType() 
    {
        return pollutantType;
    }
    public void setPollutantUnitEn(String pollutantUnitEn) 
    {
        this.pollutantUnitEn = pollutantUnitEn;
    }

    public String getPollutantUnitEn() 
    {
        return pollutantUnitEn;
    }
    public void setPollutantUnitCn(String pollutantUnitCn) 
    {
        this.pollutantUnitCn = pollutantUnitCn;
    }

    public String getPollutantUnitCn() 
    {
        return pollutantUnitCn;
    }
    public void setPollutantStatus(Long pollutantStatus) 
    {
        this.pollutantStatus = pollutantStatus;
    }

    public Long getPollutantStatus() 
    {
        return pollutantStatus;
    }
    public void setPollutantSort(Long pollutantSort) 
    {
        this.pollutantSort = pollutantSort;
    }

    public Long getPollutantSort() 
    {
        return pollutantSort;
    }

    public JSONArray getMonFactor() {
        return monFactor;
    }

    public void setMonFactorStr(String monFactorStr) {
        this.monFactor = JSONArray.parse(monFactorStr);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code2017", getCode2017())
            .append("code2005", getCode2005())
            .append("pollutantCode", getPollutantCode())
            .append("pollutantNameEn", getPollutantNameEn())
            .append("pollutantNameCn", getPollutantNameCn())
            .append("pollutantType", getPollutantType())
            .append("pollutantUnitEn", getPollutantUnitEn())
            .append("pollutantUnitCn", getPollutantUnitCn())
            .append("pollutantStatus", getPollutantStatus())
            .append("pollutantSort", getPollutantSort())
            .toString();
    }
}
