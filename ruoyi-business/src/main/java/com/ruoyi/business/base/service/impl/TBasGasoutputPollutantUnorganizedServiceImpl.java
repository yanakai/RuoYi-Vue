package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasGasoutputPollutantUnorganized;
import com.ruoyi.business.base.mapper.TBasGasoutputPollutantUnorganizedMapper;
import com.ruoyi.business.base.service.ITBasGasoutputPollutantUnorganizedService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础信息--企业--废气无组织排口污染物信息Service业务层处理
 *
 * @author lx
 * @date 2024-07-04
 */
@Service
public class TBasGasoutputPollutantUnorganizedServiceImpl implements ITBasGasoutputPollutantUnorganizedService {
    @Autowired
    private TBasGasoutputPollutantUnorganizedMapper tBasGasoutputPollutantUnorganizedMapper;

    /**
     * 查询基础信息--企业--废气无组织排口污染物信息
     *
     * @param id 基础信息--企业--废气无组织排口污染物信息主键
     * @return 基础信息--企业--废气无组织排口污染物信息
     */
    @Override
    public TBasGasoutputPollutantUnorganized selectTBasGasoutputPollutantUnorganizedById(Long id) {
        return tBasGasoutputPollutantUnorganizedMapper.selectTBasGasoutputPollutantUnorganizedById(id);
    }

    /**
     * 查询基础信息--企业--废气无组织排口污染物信息列表
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 基础信息--企业--废气无组织排口污染物信息
     */
    @Override
    public List<TBasGasoutputPollutantUnorganized> selectTBasGasoutputPollutantUnorganizedList(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized) {
        return tBasGasoutputPollutantUnorganizedMapper.selectTBasGasoutputPollutantUnorganizedList(tBasGasoutputPollutantUnorganized);
    }

    /**
     * 新增基础信息--企业--废气无组织排口污染物信息
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 结果
     */
    @Override
    public int insertTBasGasoutputPollutantUnorganized(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized) {
        tBasGasoutputPollutantUnorganized.setCreateTime(DateUtils.getNowDate());
        return tBasGasoutputPollutantUnorganizedMapper.insertTBasGasoutputPollutantUnorganized(tBasGasoutputPollutantUnorganized);
    }

    /**
     * 修改基础信息--企业--废气无组织排口污染物信息
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 结果
     */
    @Override
    public int updateTBasGasoutputPollutantUnorganized(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized) {
        tBasGasoutputPollutantUnorganized.setUpdateTime(DateUtils.getNowDate());
        return tBasGasoutputPollutantUnorganizedMapper.updateTBasGasoutputPollutantUnorganized(tBasGasoutputPollutantUnorganized);
    }

    /**
     * 批量删除基础信息--企业--废气无组织排口污染物信息
     *
     * @param ids 需要删除的基础信息--企业--废气无组织排口污染物信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutputPollutantUnorganizedByIds(Long[] ids) {
        return tBasGasoutputPollutantUnorganizedMapper.deleteTBasGasoutputPollutantUnorganizedByIds(ids);
    }

    /**
     * 删除基础信息--企业--废气无组织排口污染物信息信息
     *
     * @param id 基础信息--企业--废气无组织排口污染物信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutputPollutantUnorganizedById(Long id) {
        return tBasGasoutputPollutantUnorganizedMapper.deleteTBasGasoutputPollutantUnorganizedById(id);
    }
}
