package com.ruoyi.business.base.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 基础信息--企业--废水排口对象 t_bas_waterout_put_info
 *
 * @author lx
 * @date 2024-06-27
 */
@ApiModel("基础信息--企业--废水排口")
public class TBasWateroutPutInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 废水排放口编码
     */
    @Excel(name = "废水排放口编码")
    private String outPutCode;

    /**
     * 废水排放口名称
     */
    @Excel(name = "废水排放口名称")
    private String outPutName;

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
     * 经度
     */
    @Excel(name = "经度")
    private String longitude;

    /**
     * 维度
     */
    @Excel(name = "维度")
    private String latitude;

    /**
     * 排放口高度
     */
    @Excel(name = "排放口高度")
    private BigDecimal outPutHeight;

    /**
     * 排放口位置
     */
    @Excel(name = "排放口位置")
    private String outPutPosition;

    /**
     * 排放口类型
     */
    @Excel(name = "排放口类型")
    private String outPutType;

    /**
     * 排放口状态
     */
    @Excel(name = "排放口状态")
    private String outPutStatus;

    /**
     * 排放口图片
     */
    @Excel(name = "排放口图片")
    private String outPutImage;

    /**
     * 排放口设备mn号
     */
    @Excel(name = "排放口设备mn号")
    private String mnNum;

    /**
     * 创建人
     */
    @ApiModelProperty(hidden = true)
    @Excel(name = "创建人")
    private String createName;

    /**
     * 修改人
     */
    @ApiModelProperty(hidden = true)
    @Excel(name = "修改人")
    private String updateName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getOutPutHeight() {
        return outPutHeight;
    }

    public void setOutPutHeight(BigDecimal outPutHeight) {
        this.outPutHeight = outPutHeight;
    }

    public String getOutPutPosition() {
        return outPutPosition;
    }

    public void setOutPutPosition(String outPutPosition) {
        this.outPutPosition = outPutPosition;
    }

    public String getOutPutType() {
        return outPutType;
    }

    public void setOutPutType(String outPutType) {
        this.outPutType = outPutType;
    }

    public String getOutPutStatus() {
        return outPutStatus;
    }

    public void setOutPutStatus(String outPutStatus) {
        this.outPutStatus = outPutStatus;
    }

    public String getOutPutImage() {
        return outPutImage;
    }

    public void setOutPutImage(String outPutImage) {
        this.outPutImage = outPutImage;
    }

    public String getMnNum() {
        return mnNum;
    }

    public void setMnNum(String mnNum) {
        this.mnNum = mnNum;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("outPutCode", getOutPutCode())
                .append("outPutName", getOutPutName())
                .append("entCode", getEntCode())
                .append("entName", getEntName())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("outPutHeight", getOutPutHeight())
                .append("outPutPosition", getOutPutPosition())
                .append("outPutType", getOutPutType())
                .append("outPutStatus", getOutPutStatus())
                .append("outPutImage", getOutPutImage())
                .append("mnNum", getMnNum())
                .append("createTime", getCreateTime())
                .append("createName", getCreateName())
                .append("updateTime", getUpdateTime())
                .append("updateName", getUpdateName())
                .append("remark", getRemark())
                .toString();
    }
}
