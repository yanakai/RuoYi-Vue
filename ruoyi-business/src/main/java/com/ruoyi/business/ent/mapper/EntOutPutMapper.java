package com.ruoyi.business.ent.mapper;

import com.ruoyi.business.ent.domain.EntOutPutInfo;
import com.ruoyi.business.ent.domain.EntOutPutReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 企业排口Mapper接口
 */
public interface EntOutPutMapper {

    /**
     * 查询企业排口列表
     */
    List<EntOutPutInfo> selectOutPutList(EntOutPutReq req);

    /**
     * 企业排口信息
     */
    EntOutPutInfo selectOutPutById(@Param("outPutId") String outPutId);

    /**
     * 新增企业排口
     */
    int insertOutPut(EntOutPutInfo info);

    /**
     * 修改企业排口
     */
    int updateOutPut(EntOutPutInfo info);

    /**
     * 删除企业排口
     */
    int deleteOutPutByIds(@Param("outPutIds") List<String> outPutIds);

    /**
     * 删除企业排口对应的污染物
     */
    void deleteOutPutPollutantByOutPutIds(@Param("outPutIds") List<String> outPutIds);

    /**
     * 查询污染物列表
     */
    List<Map<String, String>> selectPollutantByType(@Param("outPutType") Integer outPutType);

    /**
     * 查询企业排口的关注情况
     */
    List<Map<String, Object>> selectUserPutInfoList(@Param("userId") Long userId);
}