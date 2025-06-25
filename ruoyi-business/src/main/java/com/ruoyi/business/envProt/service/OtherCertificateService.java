package com.ruoyi.business.envProt.service;

import com.ruoyi.business.envProt.domain.OtherCertificate;
import com.ruoyi.business.envProt.domain.OtherCertificateReq;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 其他证书Service接口
 */
public interface OtherCertificateService {

    /**
     * 查询其他证书详情
     */
    AjaxResult selectOtherCertificateById(String otherId);

    /**
     * 查询其他证书列表
     */
    AjaxResult selectOtherCertificateList(OtherCertificateReq req);

    /**
     * 导出其他证书列表
     */
    void exportOtherCertificate(OtherCertificateReq req, HttpServletResponse response);

    /**
     * 新增其他证书
     */
    AjaxResult insertOtherCertificate(OtherCertificate info);

    /**
     * 修改其他证书
     */
    AjaxResult updateOtherCertificate(OtherCertificate info);

    /**
     * 批量删除其他证书
     */
    AjaxResult deleteOtherCertificateByIds(List<String> ids);
}
