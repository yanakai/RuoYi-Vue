package com.ruoyi.business.base.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

/**
 * 基础信息--企业--废水排口对象 t_bas_waterout_put_info
 *
 * @author lx
 * @date 2024-06-27
 */
@Data
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
     * 数据传输率，‰(表中存储)
     */
    @JsonIgnore
    private Integer transRateI;
    /**
     * 数据传输率，%
     */
    @Excel(name = "数据传输率")
    private Float transRate;

    public void setTransRateI(Integer transRateI) {
        this.transRateI = transRateI;
        this.transRate = null == transRateI ? null : transRateI / 100.0f;
    }

    public void setTransRate(Float transRate) {
        this.transRate = transRate;
        this.transRateI = null == transRate ? null : (int)(transRate * 100);
    }

    /**
     * 数据有效率，‰(表中存储)
     */
    @JsonIgnore
    private Integer efficientI;
    /**
     * 数据有效率，%
     */
    @Excel(name = "数据传输率")
    private Float efficient;

    public void setEfficientI(Integer efficientI) {
        this.efficientI = efficientI;
        this.efficient = null == efficientI ? null : efficientI / 100.0f;
    }

    public void setEfficient(Float efficient) {
        this.efficient = efficient;
        this.efficientI = null == efficient ? null : (int)(efficient * 100);
    }

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

    private List<TBasUploadFiles> uploadFilesList;

}
