package com.ruoyi.business.envProt.mapper;

import com.ruoyi.business.envProt.domain.EntOutPollutantPermit;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitCount;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitCountReq;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitReq;

import java.util.List;

/**
 * 企业排污许可基础Mapper接口
 */
public interface EntOutPollutantPermitMapper {

    /**
     * 查询企业排污许可基础列表
     */
    List<EntOutPollutantPermit> selectEntOutPollutantPermitList(EntOutPollutantPermitReq req);

    /**
     * 新增企业排污许可基础
     */
    int insertEntOutPollutantPermit(EntOutPollutantPermit permit);

    /**
     * 修改企业排污许可基础
     */
    int updateEntOutPollutantPermit(EntOutPollutantPermit permit);

    /**
     * 批量删除企业排污许可基础
     */
    int deleteEntOutPollutantPermitByPollPermitIds(List<String> pollPermitIds);
    
    /**
     * 查询企业排污许可总量基础列表
     */
    List<EntOutPollutantPermitCount> selectEntOutPollutantPermitCountList(EntOutPollutantPermitCountReq count);

    /**
     * 新增企业排污许可总量基础
     */
    int insertEntOutPollutantPermitCount(EntOutPollutantPermitCount count);

    /**
     * 修改企业排污许可总量基础
     */
    int updateEntOutPollutantPermitCount(EntOutPollutantPermitCount count);

    /**
     * 批量删除企业排污许可总量基础
     */
    void deleteEntOutPollutantPermitCountByPollPermitIds(List<String> pollPermitIds);

    /**
     * 批量删除企业排污许可总量基础
     */
    int deleteEntOutPollutantPermitCountByPollPermitCountIds(List<String> pollPermitCountIds);
}
