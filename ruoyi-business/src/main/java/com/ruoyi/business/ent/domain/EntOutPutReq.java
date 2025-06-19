package com.ruoyi.business.ent.domain;

import lombok.Data;

import java.util.List;

/**
 * 企业排口对象 t_bas_ent_out_put_info
 */
@Data
public class EntOutPutReq {

    /** 当前页 */
    private Integer current;
    /** 页大小 */
    private Integer size;

    /**
     * 企业名称(模糊)
     */
    private String entName;

    /**
     * 排放口编码(模糊)
     */
    private String outPutCode;

    /**
     * 排放口名称(模糊)
     */
    private String outPutName;

    /**
     * 排放口类型，1废水、2废气、3无组织、4VOC
     */
    private Integer outPutType;

    /**
     * 排放口状态
     */
    private Integer outPutStatus;

    /**
     * 排放口设备mn号(模糊)
     */
    private String mnNum;

    /** 权限管理 */
    private List<String> entCodes;
}
