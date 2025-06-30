package com.ruoyi.business.envProt.mapper;

import com.ruoyi.business.envProt.domain.EnvMangeEvaluate;

import java.util.List;

/**
 * 企业环评环保管理-环评Mapper接口
 */
public interface EnvMangeEvaluateMapper {

    /**
     * 查询企业环评环保管理-环评列表
     */
    List<EnvMangeEvaluate> selectMangeEvaluateList(String mProjectId);

    /**
     * 新增企业环评环保管理-环评
     */
    int insertMangeEvaluate(EnvMangeEvaluate info);

    /**
     * 修改企业环评环保管理-环评
     */
    int updateMangeEvaluate(EnvMangeEvaluate info);

    /**
     * 删除企业环评环保管理-环评
     */
    int deleteMangeEvaluateById(String mEvaluateId);

    /**
     * 查询企业环评环保管理-环评id
     */
    List<String> getMangeEvaluateIdByProjectId(String mProjectId);

    /**
     * 删除项目关联环评信息
     */
    int deleteMangeEvaluateByProjectId(String mProjectId);
}
