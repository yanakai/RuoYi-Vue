package com.ruoyi.business.envProt.mapper;

import com.ruoyi.business.envProt.domain.EnvMangeProject;
import com.ruoyi.business.envProt.domain.EnvMangeReq;

import java.util.List;

/**
 * 企业环评环保管理-项目Mapper接口
 */
public interface EnvMangeProjectMapper {

    /**
     * 查询企业环评环保管理-项目
     */
    EnvMangeProject selectMangeProjectById(String mProjectId);

    /**
     * 查询企业环评环保管理-项目列表
     */
    List<EnvMangeProject> selectMangeProjectList(EnvMangeReq req);

    /**
     * 新增企业环评环保管理-项目
     */
    int insertMangeProject(EnvMangeProject info);

    /**
     * 修改企业环评环保管理-项目
     */
    int updateMangeProject(EnvMangeProject info);

    /**
     * 删除企业环评环保管理-项目
     */
    int deleteMangeProjectById(String mProjectId);
}
