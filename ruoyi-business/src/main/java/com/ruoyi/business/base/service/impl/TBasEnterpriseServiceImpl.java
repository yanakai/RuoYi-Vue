package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasEnterprise;
import com.ruoyi.business.base.dto.TBasEnterpriseBaseInfoDto;
import com.ruoyi.business.base.mapper.TBasEnterpriseMapper;
import com.ruoyi.business.base.service.ITBasEnterpriseService;
import com.ruoyi.common.annotation.DataEntScope;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ISysDeptService deptService;

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
    @DataEntScope
    public List<TBasEnterprise> selectTBasEnterpriseList(TBasEnterprise tBasEnterprise) {
        return tBasEnterpriseMapper.selectTBasEnterpriseList(tBasEnterprise);
    }

    /**
     * 新增基础信息---企业基础
     * 2024-12-7 增加企业保存后，自动保存一条部门信息
     * @param tBasEnterprise 基础信息---企业基础
     * @return 结果
     */
    @Override
    public int insertTBasEnterprise(TBasEnterprise tBasEnterprise) {
        tBasEnterprise.setCreateTime(DateUtils.getNowDate());
        int result = tBasEnterpriseMapper.insertTBasEnterprise(tBasEnterprise);
        // 保存部门信息
        SysDept sysDept = new SysDept();
        sysDept.setCreateTime(new Date());
        sysDept.setAncestors("0");
        sysDept.setLeader(tBasEnterprise.getEnvManagerPersion());
        sysDept.setCreateBy(tBasEnterprise.getCreateBy());
        sysDept.setDeptName(tBasEnterprise.getEntName());
        sysDept.setEntCode(tBasEnterprise.getEntCode());
        sysDept.setEntName(tBasEnterprise.getEntName());
        sysDept.setSocialCreditCode(tBasEnterprise.getSocialCreditCode());
        sysDept.setCreateTime(new Date());
        deptService.insertDept(sysDept);
        return result;
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

    @Override
    @DataEntScope
    public List<TBasEnterpriseBaseInfoDto> selectTBasEnterpriseBaseList(TBasEnterpriseBaseInfoDto tBasEnterpriseBaseInfoDto) {
        return tBasEnterpriseMapper.selectTBasEnterpriseBaseList(tBasEnterpriseBaseInfoDto);
    }
}
