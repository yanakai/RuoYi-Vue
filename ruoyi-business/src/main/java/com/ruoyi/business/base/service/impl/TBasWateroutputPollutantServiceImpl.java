package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasWateroutputPollutant;
import com.ruoyi.business.base.mapper.TBasWateroutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasWateroutputPollutantService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础信息--企业--废水排口污染物基本信息Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasWateroutputPollutantServiceImpl implements ITBasWateroutputPollutantService {
    @Autowired
    private TBasWateroutputPollutantMapper tBasWateroutputPollutantMapper;

    /**
     * 查询基础信息--企业--废水排口污染物基本信息
     *
     * @param id 基础信息--企业--废水排口污染物基本信息主键
     * @return 基础信息--企业--废水排口污染物基本信息
     */
    @Override
    public TBasWateroutputPollutant selectTBasWateroutputPollutantById(Long id) {
        return tBasWateroutputPollutantMapper.selectTBasWateroutputPollutantById(id);
    }

    /**
     * 查询基础信息--企业--废水排口污染物基本信息列表
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 基础信息--企业--废水排口污染物基本信息
     */
    @Override
    public List<TBasWateroutputPollutant> selectTBasWateroutputPollutantList(TBasWateroutputPollutant tBasWateroutputPollutant) {
        return tBasWateroutputPollutantMapper.selectTBasWateroutputPollutantList(tBasWateroutputPollutant);
    }

    /**
     * 新增基础信息--企业--废水排口污染物基本信息
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 结果
     */
    @Override
    public int insertTBasWateroutputPollutant(TBasWateroutputPollutant tBasWateroutputPollutant) {
        tBasWateroutputPollutant.setCreateTime(DateUtils.getNowDate());
        return tBasWateroutputPollutantMapper.insertTBasWateroutputPollutant(tBasWateroutputPollutant);
    }

    /**
     * 修改基础信息--企业--废水排口污染物基本信息
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 结果
     */
    @Override
    public int updateTBasWateroutputPollutant(TBasWateroutputPollutant tBasWateroutputPollutant) {
        tBasWateroutputPollutant.setUpdateTime(DateUtils.getNowDate());
        return tBasWateroutputPollutantMapper.updateTBasWateroutputPollutant(tBasWateroutputPollutant);
    }

    /**
     * 批量删除基础信息--企业--废水排口污染物基本信息
     *
     * @param ids 需要删除的基础信息--企业--废水排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutputPollutantByIds(Long[] ids) {
        return tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantByIds(ids);
    }

    /**
     * 删除基础信息--企业--废水排口污染物基本信息信息
     *
     * @param id 基础信息--企业--废水排口污染物基本信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutputPollutantById(Long id) {
        return tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantById(id);
    }
}
