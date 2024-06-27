package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasGasoutputPollutant;
import com.ruoyi.business.base.mapper.TBasGasoutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasGasoutputPollutantService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础信息--企业--废气排口污染物基本信息Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasGasoutputPollutantServiceImpl implements ITBasGasoutputPollutantService {
    @Autowired
    private TBasGasoutputPollutantMapper tBasGasoutputPollutantMapper;

    /**
     * 查询基础信息--企业--废气排口污染物基本信息
     *
     * @param id 基础信息--企业--废气排口污染物基本信息主键
     * @return 基础信息--企业--废气排口污染物基本信息
     */
    @Override
    public TBasGasoutputPollutant selectTBasGasoutputPollutantById(Long id) {
        return tBasGasoutputPollutantMapper.selectTBasGasoutputPollutantById(id);
    }

    /**
     * 查询基础信息--企业--废气排口污染物基本信息列表
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 基础信息--企业--废气排口污染物基本信息
     */
    @Override
    public List<TBasGasoutputPollutant> selectTBasGasoutputPollutantList(TBasGasoutputPollutant tBasGasoutputPollutant) {
        return tBasGasoutputPollutantMapper.selectTBasGasoutputPollutantList(tBasGasoutputPollutant);
    }

    /**
     * 新增基础信息--企业--废气排口污染物基本信息
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 结果
     */
    @Override
    public int insertTBasGasoutputPollutant(TBasGasoutputPollutant tBasGasoutputPollutant) {
        tBasGasoutputPollutant.setCreateTime(DateUtils.getNowDate());
        return tBasGasoutputPollutantMapper.insertTBasGasoutputPollutant(tBasGasoutputPollutant);
    }

    /**
     * 修改基础信息--企业--废气排口污染物基本信息
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 结果
     */
    @Override
    public int updateTBasGasoutputPollutant(TBasGasoutputPollutant tBasGasoutputPollutant) {
        tBasGasoutputPollutant.setUpdateTime(DateUtils.getNowDate());
        return tBasGasoutputPollutantMapper.updateTBasGasoutputPollutant(tBasGasoutputPollutant);
    }

    /**
     * 批量删除基础信息--企业--废气排口污染物基本信息
     *
     * @param ids 需要删除的基础信息--企业--废气排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutputPollutantByIds(Long[] ids) {
        return tBasGasoutputPollutantMapper.deleteTBasGasoutputPollutantByIds(ids);
    }

    /**
     * 删除基础信息--企业--废气排口污染物基本信息信息
     *
     * @param id 基础信息--企业--废气排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutputPollutantById(Long id) {
        return tBasGasoutputPollutantMapper.deleteTBasGasoutputPollutantById(id);
    }
}
