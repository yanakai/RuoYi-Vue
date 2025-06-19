package com.ruoyi.business.annex.domain;

import lombok.Data;

import java.util.List;

@Data
public class AnnexReq {
    /** 附件主键id */
    private String annexId;

    /** 附件归属id */
    private List<String> sourceIds;
    /** 附件归属id的类型 */
    private String sourceType;

    public AnnexReq(List<String> sourceIds, String sourceType) {
        this.sourceIds = sourceIds;
        this.sourceType = sourceType;
    }
}
