package com.ruoyi.business.envProt.service;

import com.ruoyi.business.envProt.domain.EntEnvProtCert;
import com.ruoyi.business.envProt.domain.EntEnvProtCertReq;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业环保证书基础Service接口
 */
public interface EntEnvProtCertService {

    /**
     * 查询企业环保证书基础列表
     */
    AjaxResult selectEntEnvProtCertList(EntEnvProtCertReq req);

    /**
     * 导出企业环保证书基础
     */
    void exportEntEnvProtCert(EntEnvProtCertReq req, HttpServletResponse response);

    /**
     * 新增企业环保证书基础
     */
    AjaxResult insertEntEnvProtCert(EntEnvProtCert cert);

    /**
     * 修改企业环保证书基础
     */
    AjaxResult updateEntEnvProtCert(EntEnvProtCert cert);

    /**
     * 批量删除企业环保证书基础
     */
    AjaxResult deleteEntEnvProtCertByProtCertIds(List<String> protCertIds);
}
