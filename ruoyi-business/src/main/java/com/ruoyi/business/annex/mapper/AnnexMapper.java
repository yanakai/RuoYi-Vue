package com.ruoyi.business.annex.mapper;


import com.ruoyi.business.annex.domain.AnnexInfo;
import com.ruoyi.business.annex.domain.AnnexReq;

import java.util.List;

public interface AnnexMapper {

    /**
     * 查询附件
     */
    List<AnnexInfo> selectAnnexList(AnnexReq req);

    /**
     * 添加附件
     */
    void insertAnnex(AnnexInfo annexInfo);

    /**
     * 修改附件信息
     */
    int updateAnnex(String sourceType, String sourceId, List<String> annexIds);

    /**
     * 批量删除附件
     */
    int deleteAnnexByIds(String[] ids);

    /**
     * 按附件来源删除
     */
    void deleteAnnexBySource(String sourceType, List<String> sourceIds);

    /**
     * 按附件来源删除，排除指定附件id
     */
    void deleteAnnexBySourceExclude(String sourceType, String sourceId, List<String> annexIds);
}
