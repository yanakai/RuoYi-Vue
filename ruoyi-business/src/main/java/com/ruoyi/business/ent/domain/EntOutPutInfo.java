package com.ruoyi.business.ent.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.business.annex.domain.AnnexInfo;
import com.ruoyi.business.enums.OutPutStatusEnum;
import com.ruoyi.business.enums.OutPutTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 企业排口对象 t_bas_ent_out_put_info
 */
@Data
public class EntOutPutInfo {

    /**
     * 企业排口主键id
     */
    private String outPutId;

    /**
     * 关联企业编码
     */
    private String entCode;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 排放口编码
     */
    private String outPutCode;

    /**
     * 排放口名称
     */
    private String outPutName;

    /**
     * 排放口类型
     * 参见 {@link OutPutTypeEnum}
     */
    private Integer outPutType;

    /**
     * 排放口状态
     * 参见 {@link OutPutStatusEnum}
     */
    private Integer outPutStatus;

    /**
     * 经度
     */
    private Float longitude;

    /**
     * 维度
     */
    private Float latitude;

    /**
     * 排放口高度
     */
    private Float outPutHeight;

    /**
     * 排放口位置
     */
    private String outPutPosition;

    /**
     * 排放口设备mn号
     */
    private String mnNum;

    /**
     * 数据传输率，%
     */
    private Float transRate;

    /**
     * 数据有效率，%
     */
    private Float validRate;

    /** 创建人 */
    private String createUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /** 更新人 */
    private String updateUser;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /** 污染物名称列表 */
    private String pollutantCode;
    private String pollutantName;

    /** 备注 */
    private String remark;

    /** 关注 */
    private boolean attention;

    /** 附件列表（更新时用） */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<String> annexIdList;
    /** 附件列表（查询时用） */
    private List<AnnexInfo> annexInfoList;
}
