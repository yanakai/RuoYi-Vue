package com.ruoyi.business.envProt.service;

import com.ruoyi.business.envProt.domain.EntCleanProduce;
import com.ruoyi.business.envProt.domain.EntCleanProduceReq;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业清洁生产基础Service接口
 */
public interface EntCleanProduceService {

    /**
     * 查询企业清洁生产基础列表
     */
    AjaxResult selectEntCleanProduceList(EntCleanProduceReq req);

    /**
     * 导出企业清洁生产基础列表
     */
    void exportEntCleanProduce(EntCleanProduceReq req, HttpServletResponse response);

    /**
     * 新增企业清洁生产基础
     */
    AjaxResult insertEntCleanProduce(EntCleanProduce produce);

    /**
     * 修改企业清洁生产基础
     */
    AjaxResult updateEntCleanProduce(EntCleanProduce produce);

    /**
     * 企业清洁生产审核
     */
    AjaxResult entCleanProduceAudit(EntCleanProduce produce);

    /**
     * 批量删除企业清洁生产基础
     */
    AjaxResult deleteEntCleanProduceByCleanProduceIds(List<String> cleanProduceIds);
}
