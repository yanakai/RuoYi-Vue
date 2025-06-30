package com.ruoyi.business.envProt.service;

import com.ruoyi.business.envProt.domain.EnvMangeProject;
import com.ruoyi.business.envProt.domain.EnvMangeReq;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletResponse;

/**
 * 企业环评环保管理-项目Service接口
 */
public interface EnvMangeProjectService {

    /**
     * 查询企业环评环保管理-项目列表
     */
    AjaxResult selectMangeProjectList(EnvMangeReq req);

    /**
     * 导出企业环评环保管理-项目列表
     */
    void exportMangeProject(EnvMangeReq req, HttpServletResponse response);

    /**
     * 导出企业环评环保管理-项目详情
     * 单个导出时会同步导出对应的环评及环保验收信息
     */
    void exportMangeProjectById(String id, HttpServletResponse response);

    /**
     * 新增企业环评环保管理-项目
     */
    AjaxResult insertMangeProject(EnvMangeProject info);

    /**
     * 修改企业环评环保管理-项目
     */
    AjaxResult updateMangeProject(EnvMangeProject info);

    /**
     * 删除企业环评环保管理-项目信息
     */
    AjaxResult deleteMangeProjectById(String id);
}
