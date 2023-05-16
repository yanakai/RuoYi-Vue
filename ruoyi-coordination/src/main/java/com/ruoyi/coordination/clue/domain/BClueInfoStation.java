package com.ruoyi.coordination.clue.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台--污染线索处置--空气站点预警状态对象 b_clue_info_station
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public class BClueInfoStation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 站点预警主键id */
    private Long earlyId;

    /** 站点code */
    @Excel(name = "站点code")
    private String stationCode;

    /** 站点名称 */
    @Excel(name = "站点名称")
    private String stationName;

    /** 站点类型 */
    @Excel(name = "站点类型")
    private String stationType;

    /** 站点所属区域code */
    @Excel(name = "站点所属区域code")
    private String regionCode;

    /** 站点所属区域名称 */
    @Excel(name = "站点所属区域名称")
    private String regionName;

    /** 站点所属责任单位id */
    @Excel(name = "站点所属责任单位id")
    private Long deptId;

    /** 站点所属责任单位名称 */
    @Excel(name = "站点所属责任单位名称")
    private String deptName;

    /** 站点预警状态：0：未预警；2：已预警 */
    @Excel(name = "站点预警状态：0：未预警；2：已预警")
    private String earlyState;

    /** 创建单位id */
    @Excel(name = "创建单位id")
    private Long createDeptId;

    /** 创建单位名称 */
    @Excel(name = "创建单位名称")
    private String createDeptName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

    /** 创建人名称 */
    @Excel(name = "创建人名称")
    private String createUserName;

    public void setEarlyId(Long earlyId) 
    {
        this.earlyId = earlyId;
    }

    public Long getEarlyId() 
    {
        return earlyId;
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
    public void setRegionCode(String regionCode) 
    {
        this.regionCode = regionCode;
    }

    public String getRegionCode() 
    {
        return regionCode;
    }
    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setEarlyState(String earlyState) 
    {
        this.earlyState = earlyState;
    }

    public String getEarlyState() 
    {
        return earlyState;
    }
    public void setCreateDeptId(Long createDeptId) 
    {
        this.createDeptId = createDeptId;
    }

    public Long getCreateDeptId() 
    {
        return createDeptId;
    }
    public void setCreateDeptName(String createDeptName) 
    {
        this.createDeptName = createDeptName;
    }

    public String getCreateDeptName() 
    {
        return createDeptName;
    }
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
    }
    public void setCreateUserName(String createUserName) 
    {
        this.createUserName = createUserName;
    }

    public String getCreateUserName() 
    {
        return createUserName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("earlyId", getEarlyId())
            .append("stationCode", getStationCode())
            .append("stationName", getStationName())
            .append("stationType", getStationType())
            .append("regionCode", getRegionCode())
            .append("regionName", getRegionName())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("earlyState", getEarlyState())
            .append("createTime", getCreateTime())
            .append("createDeptId", getCreateDeptId())
            .append("createDeptName", getCreateDeptName())
            .append("createUserId", getCreateUserId())
            .append("createUserName", getCreateUserName())
            .toString();
    }
}
