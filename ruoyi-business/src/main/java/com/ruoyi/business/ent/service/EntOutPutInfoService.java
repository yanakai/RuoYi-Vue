package com.ruoyi.business.ent.service;

import com.ruoyi.business.ent.domain.EntOutPutInfo;
import com.ruoyi.business.ent.domain.EntOutPutReq;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业排口Service接口
 */
public interface EntOutPutInfoService {

    /**
     * 查询企业排口详情
     */
    AjaxResult selectOutPutById(String outPutId);

    /**
     * 查询企业排口列表
     */
    AjaxResult selectOutPutList(EntOutPutReq req);

    /**
     * 导出企业企业排口列表
     * 按模版导出
     */
    void exportOutPut(EntOutPutReq req, HttpServletResponse response);

    /**
     * 新增企业排口
     */
    AjaxResult insertOutPut(EntOutPutInfo info);

    /**
     * 修改企业排口
     */
    AjaxResult updateOutPut(EntOutPutInfo info);

    /**
     * 删除企业排口
     */
    AjaxResult deleteOutPutByIds(List<String> outPutIds);
}
