package com.ruoyi.business.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 污染排口信息对象 v_out_put_info
 * 
 * @author lx
 * @date 2024-07-13
 */
public class VOutPutInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outPutCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outPutName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String entCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String entName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mnNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String latitude;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String longitude;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String monitoringPointType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pollutantName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOutPutCode(String outPutCode) 
    {
        this.outPutCode = outPutCode;
    }

    public String getOutPutCode() 
    {
        return outPutCode;
    }
    public void setOutPutName(String outPutName) 
    {
        this.outPutName = outPutName;
    }

    public String getOutPutName() 
    {
        return outPutName;
    }
    public void setEntCode(String entCode) 
    {
        this.entCode = entCode;
    }

    public String getEntCode() 
    {
        return entCode;
    }
    public void setEntName(String entName) 
    {
        this.entName = entName;
    }

    public String getEntName() 
    {
        return entName;
    }
    public void setMnNum(String mnNum) 
    {
        this.mnNum = mnNum;
    }

    public String getMnNum() 
    {
        return mnNum;
    }
    public void setLatitude(String latitude) 
    {
        this.latitude = latitude;
    }

    public String getLatitude() 
    {
        return latitude;
    }
    public void setLongitude(String longitude) 
    {
        this.longitude = longitude;
    }

    public String getLongitude() 
    {
        return longitude;
    }
    public void setMonitoringPointType(String monitoringPointType) 
    {
        this.monitoringPointType = monitoringPointType;
    }

    public String getMonitoringPointType() 
    {
        return monitoringPointType;
    }
    public void setPollutantName(String pollutantName) 
    {
        this.pollutantName = pollutantName;
    }

    public String getPollutantName() 
    {
        return pollutantName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("outPutCode", getOutPutCode())
            .append("outPutName", getOutPutName())
            .append("entCode", getEntCode())
            .append("entName", getEntName())
            .append("mnNum", getMnNum())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("monitoringPointType", getMonitoringPointType())
            .append("pollutantName", getPollutantName())
            .append("createTime", getCreateTime())
            .toString();
    }
}
