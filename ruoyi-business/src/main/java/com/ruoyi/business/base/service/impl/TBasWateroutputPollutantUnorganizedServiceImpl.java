package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasWateroutputPollutantUnorganized;
import com.ruoyi.business.base.mapper.TBasWateroutputPollutantUnorganizedMapper;
import com.ruoyi.business.base.service.ITBasWateroutputPollutantUnorganizedService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础信息--企业--废水无组织排口污染物信息Service业务层处理
 *
 * @author lx
 * @date 2024-07-04
 */
@Service
public class TBasWateroutputPollutantUnorganizedServiceImpl implements ITBasWateroutputPollutantUnorganizedService {
    @Autowired
    private TBasWateroutputPollutantUnorganizedMapper tBasWateroutputPollutantUnorganizedMapper;

    /**
     * 查询基础信息--企业--废水无组织排口污染物信息
     *
     * @param id 基础信息--企业--废水无组织排口污染物信息主键
     * @return 基础信息--企业--废水无组织排口污染物信息
     */
    @Override
    public TBasWateroutputPollutantUnorganized selectTBasWateroutputPollutantUnorganizedById(Long id) {
        return tBasWateroutputPollutantUnorganizedMapper.selectTBasWateroutputPollutantUnorganizedById(id);
    }

    /**
     * 查询基础信息--企业--废水无组织排口污染物信息列表
     *
     * @param tBasWateroutputPollutantUnorganized 基础信息--企业--废水无组织排口污染物信息
     * @return 基础信息--企业--废水无组织排口污染物信息
     */
    @Override
    public List<TBasWateroutputPollutantUnorganized> selectTBasWateroutputPollutantUnorganizedList(TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized) {
        return tBasWateroutputPollutantUnorganizedMapper.selectTBasWateroutputPollutantUnorganizedList(tBasWateroutputPollutantUnorganized);
    }

    /**
     * 新增基础信息--企业--废水无组织排口污染物信息
     *
     * @param tBasWateroutputPollutantUnorganized 基础信息--企业--废水无组织排口污染物信息
     * @return 结果
     */
    @Override
    public int insertTBasWateroutputPollutantUnorganized(TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized) {
        tBasWateroutputPollutantUnorganized.setCreateTime(DateUtils.getNowDate());
        return tBasWateroutputPollutantUnorganizedMapper.insertTBasWateroutputPollutantUnorganized(tBasWateroutputPollutantUnorganized);
    }

    /**
     * 修改基础信息--企业--废水无组织排口污染物信息
     *
     * @param tBasWateroutputPollutantUnorganized 基础信息--企业--废水无组织排口污染物信息
     * @return 结果
     */
    @Override
    public int updateTBasWateroutputPollutantUnorganized(TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized) {
        tBasWateroutputPollutantUnorganized.setUpdateTime(DateUtils.getNowDate());
        return tBasWateroutputPollutantUnorganizedMapper.updateTBasWateroutputPollutantUnorganized(tBasWateroutputPollutantUnorganized);
    }

    /**
     * 批量删除基础信息--企业--废水无组织排口污染物信息
     *
     * @param ids 需要删除的基础信息--企业--废水无组织排口污染物信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutputPollutantUnorganizedByIds(Long[] ids) {
        return tBasWateroutputPollutantUnorganizedMapper.deleteTBasWateroutputPollutantUnorganizedByIds(ids);
    }

    /**
     * 删除基础信息--企业--废水无组织排口污染物信息信息
     *
     * @param id 基础信息--企业--废水无组织排口污染物信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutputPollutantUnorganizedById(Long id) {
        return tBasWateroutputPollutantUnorganizedMapper.deleteTBasWateroutputPollutantUnorganizedById(id);
    }
}
