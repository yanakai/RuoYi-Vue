package com.ruoyi.business.envProt.service;

import com.ruoyi.business.envProt.domain.EnvMangeEvaluate;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.List;

/**
 * 企业环评环保管理-环评Service接口
 */
public interface EnvMangeEvaluateService {

    /**
     * 查询企业环评环保管理-环评列表
     */
    AjaxResult selectMangeEvaluateList(String mProjectId);

    /**
     * 查询企业环评环保管理-项目关联的全部环评列表
     */
    List<EnvMangeEvaluate> selectMangeEvaluateByProjectId(String mProjectId);

    /**
     * 新增企业环评环保管理-环评
     */
    AjaxResult insertMangeEvaluate(EnvMangeEvaluate info);

    /**
     * 修改企业环评环保管理-环评
     */
    AjaxResult updateMangeEvaluate(EnvMangeEvaluate info);

    /**
     * 删除企业环评环保管理-环评信息
     */
    AjaxResult deleteMangeEvaluateById(String id);

    /**
     * 删除企业环评环保管理-环评信息
     */
    void deleteMangeEvaluateByProjectId(String mProjectId);
}
