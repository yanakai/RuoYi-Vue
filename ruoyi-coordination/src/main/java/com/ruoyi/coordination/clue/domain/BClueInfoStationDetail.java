package com.ruoyi.coordination.clue.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台--污染线索处置--空气站点详情对象 b_clue_info_station_detail
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
public class BClueInfoStationDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 站点主键id */
    private Long stationId;

    /** 站点编码 */
    @Excel(name = "站点编码")
    private String stationCode;

    /** 站点名称 */
    @Excel(name = "站点名称")
    private String stationName;

    /** 站点类型 */
    @Excel(name = "站点类型")
    private String stationType;

    /** 所属区划编码 */
    @Excel(name = "所属区划编码")
    private String divisionCode;

    /** 所属区划名称 */
    @Excel(name = "所属区划名称")
    private String divisionName;

    /** 责任单位id */
    @Excel(name = "责任单位id")
    private String responsibilityUnitId;

    /** 责任单位名称 */
    @Excel(name = "责任单位名称")
    private String responsibilityUnitName;

    public void setStationId(Long stationId) 
    {
        this.stationId = stationId;
    }

    public Long getStationId() 
    {
        return stationId;
    }
    public void setStationCode(String stationCode) 
    {
        this.stationCode = stationCode;
    }

    public String getStationCode() 
    {
        return stationCode;
    }
    public void setStationName(String stationName) 
    {
        this.stationName = stationName;
    }

    public String getStationName() 
    {
        return stationName;
    }
    public void setStationType(String stationType) 
    {
        this.stationType = stationType;
    }

    public String getStationType() 
    {
        return stationType;
    }
    public void setDivisionCode(String divisionCode) 
    {
        this.divisionCode = divisionCode;
    }

    public String getDivisionCode() 
    {
        return divisionCode;
    }
    public void setDivisionName(String divisionName) 
    {
        this.divisionName = divisionName;
    }

    public String getDivisionName() 
    {
        return divisionName;
    }
    public void setResponsibilityUnitId(String responsibilityUnitId) 
    {
        this.responsibilityUnitId = responsibilityUnitId;
    }

    public String getResponsibilityUnitId() 
    {
        return responsibilityUnitId;
    }
    public void setResponsibilityUnitName(String responsibilityUnitName) 
    {
        this.responsibilityUnitName = responsibilityUnitName;
    }

    public String getResponsibilityUnitName() 
    {
        return responsibilityUnitName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stationId", getStationId())
            .append("stationCode", getStationCode())
            .append("stationName", getStationName())
            .append("stationType", getStationType())
            .append("divisionCode", getDivisionCode())
            .append("divisionName", getDivisionName())
            .append("responsibilityUnitId", getResponsibilityUnitId())
            .append("responsibilityUnitName", getResponsibilityUnitName())
            .toString();
    }
}
