package com.ruoyi.business.envProt.service;

import com.ruoyi.business.envProt.domain.EnvMangeCheck;
import com.ruoyi.business.envProt.domain.EnvMangeReq;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.List;

/**
 * 企业环评环保管理-环保验收Service接口
 */
public interface EnvMangeCheckService {

    /**
     * 查询企业环评环保管理-环保验收列表
     */
    AjaxResult selectMangeCheckList(EnvMangeReq req);

    /**
     * 查询企业环评环保管理-项目关联的全部环保验收列表
     */
    List<EnvMangeCheck> selectMangeCheckByProjectId(String mProjectId);

    /**
     * 新增企业环评环保管理-环保验收
     */
    AjaxResult insertMangeCheck(EnvMangeCheck info);

    /**
     * 修改企业环评环保管理-环保验收
     */
    AjaxResult updateMangeCheck(EnvMangeCheck info);

    /**
     * 删除企业环评环保管理-环保验收信息
     */
    AjaxResult deleteMangeCheckById(String id);

    /**
     * 删除企业环评环保管理-环保验收信息
     */
    void deleteMangeCheckByProjectId(String mProjectId);
}
