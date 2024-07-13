package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.TBasWateroutputPollutantUnorganized;

import java.util.List;

/**
 * 基础信息--企业--废水无组织排口污染物信息Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface ITBasWateroutputPollutantUnorganizedService {
    /**
     * 查询基础信息--企业--废水无组织排口污染物信息
     *
     * @param id 基础信息--企业--废水无组织排口污染物信息主键
     * @return 基础信息--企业--废水无组织排口污染物信息
     */
    TBasWateroutputPollutantUnorganized selectTBasWateroutputPollutantUnorganizedById(Long id);

    /**
     * 查询基础信息--企业--废水无组织排口污染物信息列表
     *
     * @param tBasWateroutputPollutantUnorganized 基础信息--企业--废水无组织排口污染物信息
     * @return 基础信息--企业--废水无组织排口污染物信息集合
     */
    List<TBasWateroutputPollutantUnorganized> selectTBasWateroutputPollutantUnorganizedList(TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized);

    /**
     * 新增基础信息--企业--废水无组织排口污染物信息
     *
     * @param tBasWateroutputPollutantUnorganized 基础信息--企业--废水无组织排口污染物信息
     * @return 结果
     */
    int insertTBasWateroutputPollutantUnorganized(TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized);

    /**
     * 修改基础信息--企业--废水无组织排口污染物信息
     *
     * @param tBasWateroutputPollutantUnorganized 基础信息--企业--废水无组织排口污染物信息
     * @return 结果
     */
    int updateTBasWateroutputPollutantUnorganized(TBasWateroutputPollutantUnorganized tBasWateroutputPollutantUnorganized);

    /**
     * 批量删除基础信息--企业--废水无组织排口污染物信息
     *
     * @param ids 需要删除的基础信息--企业--废水无组织排口污染物信息主键集合
     * @return 结果
     */
    int deleteTBasWateroutputPollutantUnorganizedByIds(Long[] ids);

    /**
     * 删除基础信息--企业--废水无组织排口污染物信息信息
     *
     * @param id 基础信息--企业--废水无组织排口污染物信息主键
     * @return 结果
     */
    int deleteTBasWateroutputPollutantUnorganizedById(Long id);
}
