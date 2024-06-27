package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.TBasEnterprise;

import java.util.List;

/**
 * 基础信息---企业基础Service接口
 *
 * @author ruoyi
 * @date 2024-06-26
 */
public interface ITBasEnterpriseService {
    /**
     * 查询基础信息---企业基础
     *
     * @param id 基础信息---企业基础主键
     * @return 基础信息---企业基础
     */
    TBasEnterprise selectTBasEnterpriseById(Long id);

    /**
     * 查询基础信息---企业基础列表
     *
     * @param tBasEnterprise 基础信息---企业基础
     * @return 基础信息---企业基础集合
     */
    List<TBasEnterprise> selectTBasEnterpriseList(TBasEnterprise tBasEnterprise);

    /**
     * 新增基础信息---企业基础
     *
     * @param tBasEnterprise 基础信息---企业基础
     * @return 结果
     */
    int insertTBasEnterprise(TBasEnterprise tBasEnterprise);

    /**
     * 修改基础信息---企业基础
     *
     * @param tBasEnterprise 基础信息---企业基础
     * @return 结果
     */
    int updateTBasEnterprise(TBasEnterprise tBasEnterprise);

    /**
     * 批量删除基础信息---企业基础
     *
     * @param ids 需要删除的基础信息---企业基础主键集合
     * @return 结果
     */
    int deleteTBasEnterpriseByIds(Long[] ids);

    /**
     * 删除基础信息---企业基础信息
     *
     * @param id 基础信息---企业基础主键
     * @return 结果
     */
    int deleteTBasEnterpriseById(Long id);
}