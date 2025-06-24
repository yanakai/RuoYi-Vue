package com.ruoyi.business.envProt.mapper;

import com.ruoyi.business.envProt.domain.EntOutPollutantPermit;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitCount;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitCountReq;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业排污许可基础Mapper接口
 */
public interface EntOutPollutantPermitMapper {

    /**
     * 查询企业排污许可基础列表
     */
    EntOutPollutantPermit selectEntOutPollutantPermitByEntCode(@Param("entCode") String entCode);

    /**
     * 查询企业排污许可基础列表
     */
    List<EntOutPollutantPermit> selectEntOutPollutantPermitList(EntOutPollutantPermitReq req);

    /**
     * 判断是否已存在
     */
    int checkExistEntOutPollutantPermit(@Param("entCode") String entCode);

    /**
     * 新增企业排污许可基础
     */
    void insertEntOutPollutantPermit(EntOutPollutantPermit permit);

    /**
     * 修改企业排污许可基础
     */
    void updateEntOutPollutantPermit(EntOutPollutantPermit permit);
    
    /**
     * 查询企业排污许可总量基础列表
     */
    List<EntOutPollutantPermitCount> selectEntOutPollutantPermitCountList(EntOutPollutantPermitCountReq count);

    /**
     * 新增企业排污许可总量基础
     */
    void insertEntOutPollutantPermitCount(EntOutPollutantPermitCount count);

    /**
     * 修改企业排污许可总量基础
     */
    void updateEntOutPollutantPermitCount(EntOutPollutantPermitCount count);

    /**
     * 批量删除企业排污许可总量基础
     */
    void deleteEntOutPollutantPermitCountByPollPermitCountIds(List<String> pollPermitCountIds);
}
