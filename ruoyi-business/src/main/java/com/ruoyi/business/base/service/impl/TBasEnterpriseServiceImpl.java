package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasEnterprise;
import com.ruoyi.business.base.mapper.TBasEnterpriseMapper;
import com.ruoyi.business.base.service.ITBasEnterpriseService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础信息---企业基础Service业务层处理
 *
 * @author ruoyi
 * @date 2024-06-26
 */
@Service
public class TBasEnterpriseServiceImpl implements ITBasEnterpriseService {
    @Autowired
    private TBasEnterpriseMapper tBasEnterpriseMapper;

    /**
     * 查询基础信息---企业基础
     *
     * @param id 基础信息---企业基础主键
     * @return 基础信息---企业基础
     */
    @Override
    public TBasEnterprise selectTBasEnterpriseById(Long id) {
        return tBasEnterpriseMapper.selectTBasEnterpriseById(id);
    }

    /**
     * 查询基础信息---企业基础列表
     *
     * @param tBasEnterprise 基础信息---企业基础
     * @return 基础信息---企业基础
     */
    @Override
    public List<TBasEnterprise> selectTBasEnterpriseList(TBasEnterprise tBasEnterprise) {
        return tBasEnterpriseMapper.selectTBasEnterpriseList(tBasEnterprise);
    }

    /**
     * 新增基础信息---企业基础
     *
     * @param tBasEnterprise 基础信息---企业基础
     * @return 结果
     */
    @Override
    public int insertTBasEnterprise(TBasEnterprise tBasEnterprise) {
        tBasEnterprise.setCreateTime(DateUtils.getNowDate());
        return tBasEnterpriseMapper.insertTBasEnterprise(tBasEnterprise);
    }

    /**
     * 修改基础信息---企业基础
     *
     * @param tBasEnterprise 基础信息---企业基础
     * @return 结果
     */
    @Override
    public int updateTBasEnterprise(TBasEnterprise tBasEnterprise) {
        tBasEnterprise.setUpdateTime(DateUtils.getNowDate());
        return tBasEnterpriseMapper.updateTBasEnterprise(tBasEnterprise);
    }

    /**
     * 批量删除基础信息---企业基础
     *
     * @param ids 需要删除的基础信息---企业基础主键
     * @return 结果
     */
    @Override
    public int deleteTBasEnterpriseByIds(Long[] ids) {
        return tBasEnterpriseMapper.deleteTBasEnterpriseByIds(ids);
    }

    /**
     * 删除基础信息---企业基础信息
     *
     * @param id 基础信息---企业基础主键
     * @return 结果
     */
    @Override
    public int deleteTBasEnterpriseById(Long id) {
        return tBasEnterpriseMapper.deleteTBasEnterpriseById(id);
    }
}
