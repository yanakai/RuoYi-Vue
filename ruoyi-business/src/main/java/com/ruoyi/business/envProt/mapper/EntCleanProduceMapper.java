package com.ruoyi.business.envProt.mapper;

import com.ruoyi.business.envProt.domain.EntCleanProduce;
import com.ruoyi.business.envProt.domain.EntCleanProduceReq;

import java.util.List;

/**
 * 企业清洁生产基础Mapper接口
 */
public interface EntCleanProduceMapper {

    /**
     * 查询企业清洁生产
     */
    EntCleanProduce selectCleanProduceById(String cleanProduceId);

    /**
     * 查询企业清洁生产基础列表
     */
    List<EntCleanProduce> selectCleanProduceList(EntCleanProduceReq req);

    /**
     * 新增企业清洁生产基础
     */
    int insertCleanProduce(EntCleanProduce produce);

    /**
     * 修改企业清洁生产基础
     */
    int updateCleanProduce(EntCleanProduce produce);

    /**
     * 批量删除企业清洁生产基础
     */
    int deleteCleanProduceByIds(List<String> cleanProduceIds);
}
