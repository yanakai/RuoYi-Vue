package com.ruoyi.business.envProt.mapper;

import com.ruoyi.business.envProt.domain.EnvMangeCheck;

import java.util.List;

/**
 * 企业环评环保管理-环保验收Mapper接口
 */
public interface EnvMangeCheckMapper {

    /**
     * 查询企业环评环保管理-环保验收列表
     */
    List<EnvMangeCheck> selectMangeCheckList(String mProjectId);

    /**
     * 新增企业环评环保管理-环保验收
     */
    int insertMangeCheck(EnvMangeCheck info);

    /**
     * 修改企业环评环保管理-环保验收
     */
    int updateMangeCheck(EnvMangeCheck info);

    /**
     * 删除企业环评环保管理-环保验收
     */
    int deleteMangeCheckById(String mCheckId);

    /**
     * 查询企业环评环保管理-环保验收id
     */
    List<String> getMangeCheckIdByProjectId(String mProjectId);

    /**
     * 删除项目关联环保验收信息
     */
    int deleteMangeCheckByProjectId(String mProjectId);
}
