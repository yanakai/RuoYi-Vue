package com.ruoyi.business.ent.mapper;

import com.ruoyi.business.ent.domain.EntOutputPollutant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业排口污染物信息Mapper接口
 */
public interface EntOutputPollutantMapper {

    /**
     * 查询企业排口污染物信息
     */
    EntOutputPollutant selectOutputPollutantById(@Param("outPutPollId") String outPutPollId);

    /**
     * 查询企业排口污染物信息
     */
    List<EntOutputPollutant> selectOutputPollutantByOutPutId(@Param("outPutId") String outPutId);

    /**
     * 新增企业排口污染物信息
     */
    int insertOutputPollutant(EntOutputPollutant poll);

    /**
     * 修改企业排口污染物信息
     */
    int updateOutputPollutant(EntOutputPollutant poll);

    /**
     * 删除企业排口污染物信息
     */
    int deleteOutputPollutantById(@Param("outPutPollId") String outPutPollId);

    /**
     * 修改排口信息中的污染物列表
     */
    void updateOutPutPollCodeById(@Param("outPutId") String outPutId);
}
