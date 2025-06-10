package com.ruoyi.business.envProt.mapper;

import com.ruoyi.business.envProt.domain.EntEnvProtCert;
import com.ruoyi.business.envProt.domain.EntEnvProtCertReq;

import java.util.List;

/**
 * 企业环保证书基础Mapper接口
 */
public interface EntEnvProtCertMapper {

    /**
     * 查询企业环保证书基础列表
     */
    List<EntEnvProtCert> selectEntEnvProtCertList(EntEnvProtCertReq req);

    /**
     * 新增企业环保证书基础
     */
    int insertEntEnvProtCert(EntEnvProtCert cert);

    /**
     * 修改企业环保证书基础
     */
    int updateEntEnvProtCert(EntEnvProtCert cert);

    /**
     * 批量删除企业环保证书基础
     */
    int deleteEntEnvProtCertByProtCertIds(List<String> protCertIds);
}
