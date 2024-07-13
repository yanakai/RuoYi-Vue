package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.TBasGasoutputPollutantUnorganized;

import java.util.List;

/**
 * 基础信息--企业--废气无组织排口污染物信息Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface ITBasGasoutputPollutantUnorganizedService {
    /**
     * 查询基础信息--企业--废气无组织排口污染物信息
     *
     * @param id 基础信息--企业--废气无组织排口污染物信息主键
     * @return 基础信息--企业--废气无组织排口污染物信息
     */
    TBasGasoutputPollutantUnorganized selectTBasGasoutputPollutantUnorganizedById(Long id);

    /**
     * 查询基础信息--企业--废气无组织排口污染物信息列表
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 基础信息--企业--废气无组织排口污染物信息集合
     */
    List<TBasGasoutputPollutantUnorganized> selectTBasGasoutputPollutantUnorganizedList(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized);

    /**
     * 新增基础信息--企业--废气无组织排口污染物信息
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 结果
     */
    int insertTBasGasoutputPollutantUnorganized(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized);

    /**
     * 修改基础信息--企业--废气无组织排口污染物信息
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 结果
     */
    int updateTBasGasoutputPollutantUnorganized(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized);

    /**
     * 批量删除基础信息--企业--废气无组织排口污染物信息
     *
     * @param ids 需要删除的基础信息--企业--废气无组织排口污染物信息主键集合
     * @return 结果
     */
    int deleteTBasGasoutputPollutantUnorganizedByIds(Long[] ids);

    /**
     * 删除基础信息--企业--废气无组织排口污染物信息信息
     *
     * @param id 基础信息--企业--废气无组织排口污染物信息主键
     * @return 结果
     */
    int deleteTBasGasoutputPollutantUnorganizedById(Long id);
}
