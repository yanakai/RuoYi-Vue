package com.ruoyi.business.envProt.mapper;

import java.util.List;
import com.ruoyi.business.envProt.domain.EnvProPerson;
import com.ruoyi.business.envProt.domain.EnvProPersonReq;
import org.apache.ibatis.annotations.Param;

/**
 * 企业环保人员Mapper接口
 */
public interface EnvProPersonMapper {

    /**
     * 获取企业环保人员详细信息
     */
    EnvProPerson selectProPersonById(String envProPersonId);

    /**
     * 查询企业环保人员列表
     */
    List<EnvProPerson> selectProPersonList(EnvProPersonReq req);

    /**
     * 新增企业环保人员
     */
    int insertProPerson(EnvProPerson info);

    /**
     * 修改企业环保人员
     */
    int updateProPerson(EnvProPerson info);

    /**
     * 删除企业环保人员
     */
    int deleteProPersonByIds(@Param("ids") List<String> ids);

    /**
     * 模板导入新增企业环保人员
     */
    void batchInsertProPerson(List<EnvProPerson> infos);
}
