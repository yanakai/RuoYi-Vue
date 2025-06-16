package com.ruoyi.business.annex.mapper;


import com.ruoyi.business.annex.domain.AnnexInfo;
import com.ruoyi.business.annex.domain.AnnexReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnexMapper {

    /**
     * 查询附件
     */
    List<AnnexInfo> selectAnnexList(AnnexReq req);

    /**
     * 查询附件
     */
    List<AnnexInfo> selectAnnexListBySource(@Param("sourceId") String sourceId, @Param("sourceType") String sourceType);

    /**
     * 添加附件
     */
    void insertAnnex(AnnexInfo annexInfo);

    /**
     * 修改附件信息
     */
    void updateAnnex(@Param("sourceId") String sourceId, @Param("sourceType") String sourceType, @Param("annexIds") List<String> annexIds);

    /**
     * 批量删除附件
     */
    void deleteAnnexByIds(List<String> ids);
}
