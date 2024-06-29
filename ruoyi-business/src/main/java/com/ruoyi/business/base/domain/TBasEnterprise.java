package com.ruoyi.business.base.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基础信息---企业基础对象 t_bas_enterprise
 *
 * @author ruoyi
 * @date 2024-06-26
 */
@ApiModel("基础信息---企业基础")
public class TBasEnterprise extends BaseEntity {
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
     * 社会统一信用代码
     */
    @Excel(name = "社会统一信用代码")
    private String socialCreditCode;

    /**
     * 企业简称
     */
    @Excel(name = "企业简称")
    private String shorterName;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 行政区划
     */
    @Excel(name = "行政区划")
    private String region;

    /**
     * 企业状态
     */
    @Excel(name = "企业状态")
    private String entStatus;

    /**
     * 企业规模
     */
    @Excel(name = "企业规模")
    private String entScale;

    /**
     * 企业类型
     */
    @Excel(name = "企业类型")
    private String entType;

    /**
     * 行业类型
     */
    @Excel(name = "行业类型")
    private String industryType;

    /**
     * 污染源类别
     */
    private String pollutionClass;

    /**
     * 环保管理人员
     */
    @Excel(name = "环保管理人员")
    private String envManagerPersion;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String linkManPhone;

    /**
     * 联系人邮箱
     */
    @Excel(name = "联系人邮箱")
    private String linkManeMail;

    /**
     * 企业介绍
     */
    private String entIntroduction;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    @ApiModelProperty(hidden = true)
    private String createUser;

    /**
     * 更新人
     */
    @Excel(name = "更新人")
    @ApiModelProperty(hidden = true)
    private String updateUser;

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

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public String getShorterName() {
        return shorterName;
    }

    public void setShorterName(String shorterName) {
        this.shorterName = shorterName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEntStatus() {
        return entStatus;
    }

    public void setEntStatus(String entStatus) {
        this.entStatus = entStatus;
    }

    public String getEntScale() {
        return entScale;
    }

    public void setEntScale(String entScale) {
        this.entScale = entScale;
    }

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getPollutionClass() {
        return pollutionClass;
    }

    public void setPollutionClass(String pollutionClass) {
        this.pollutionClass = pollutionClass;
    }

    public String getEnvManagerPersion() {
        return envManagerPersion;
    }

    public void setEnvManagerPersion(String envManagerPersion) {
        this.envManagerPersion = envManagerPersion;
    }

    public String getLinkManPhone() {
        return linkManPhone;
    }

    public void setLinkManPhone(String linkManPhone) {
        this.linkManPhone = linkManPhone;
    }

    public String getLinkManeMail() {
        return linkManeMail;
    }

    public void setLinkManeMail(String linkManeMail) {
        this.linkManeMail = linkManeMail;
    }

    public String getEntIntroduction() {
        return entIntroduction;
    }

    public void setEntIntroduction(String entIntroduction) {
        this.entIntroduction = entIntroduction;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("entCode", getEntCode())
                .append("entName", getEntName())
                .append("socialCreditCode", getSocialCreditCode())
                .append("shorterName", getShorterName())
                .append("address", getAddress())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("region", getRegion())
                .append("entStatus", getEntStatus())
                .append("entScale", getEntScale())
                .append("entType", getEntType())
                .append("industryType", getIndustryType())
                .append("pollutionClass", getPollutionClass())
                .append("envManagerPersion", getEnvManagerPersion())
                .append("linkManPhone", getLinkManPhone())
                .append("linkManeMail", getLinkManeMail())
                .append("entIntroduction", getEntIntroduction())
                .append("createUser", getCreateUser())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("updateUser", getUpdateUser())
                .toString();
    }
}
