package com.ruoyi.business.base.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 基础信息--企业--废气无组织排口对象 t_bas_gasout_put_unorganized
 *
 * @author lx
 * @date 2024-07-13
 */
public class TBasGasoutPutUnorganized extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 废气排放口编码
     */
    @Excel(name = "废气排放口编码")
    private String outPutCode;

    /**
     * 废气排放口名称
     */
    @Excel(name = "废气排放口名称")
    private String outPutName;

    /**
     * 监测点类型（数据字典monitoring_point_type：3扬尘  4VOC）
     */
    @Excel(name = "监测点类型", readConverterExp = "数=据字典monitoring_point_type：3扬尘,4=VOC")
    private String monitoringPointType;

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
     * 数据来源
     */
    @Excel(name = "数据来源")
    private String dataSource;

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
    private Integer outPutStatus;

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
    @Excel(name = "创建人")
    private String createName;

    /**
     * 修改人
     */
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

    public String getMonitoringPointType() {
        return monitoringPointType;
    }

    public void setMonitoringPointType(String monitoringPointType) {
        this.monitoringPointType = monitoringPointType;
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

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
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

    public Integer getOutPutStatus() {
        return outPutStatus;
    }

    public void setOutPutStatus(Integer outPutStatus) {
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
                .append("monitoringPointType", getMonitoringPointType())
                .append("entCode", getEntCode())
                .append("entName", getEntName())
                .append("dataSource", getDataSource())
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
