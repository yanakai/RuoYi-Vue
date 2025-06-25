package com.ruoyi.business.envProt.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.business.envProt.domain.EntCleanProduce;
import com.ruoyi.business.envProt.domain.EntCleanProduceReq;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业清洁生产基础Service接口
 */
public interface EntCleanProduceService {

    /**
     * 查询企业清洁生产详情
     */
    AjaxResult selectCleanProduceById(String cleanProduceId);

    /**
     * 查询企业清洁生产基础列表
     */
    AjaxResult selectCleanProduceList(EntCleanProduceReq req);

    /**
     * 导出企业清洁生产基础列表
     */
    void exportCleanProduce(EntCleanProduceReq req, HttpServletResponse response);

    /**
     * 新增企业清洁生产基础
     */
    AjaxResult insertCleanProduce(EntCleanProduce produce);

    /**
     * 修改企业清洁生产基础
     */
    AjaxResult updateCleanProduce(EntCleanProduce produce);

    /**
     * 批量删除企业清洁生产基础
     */
    AjaxResult deleteCleanProduceByIds(List<String> ids);
}
