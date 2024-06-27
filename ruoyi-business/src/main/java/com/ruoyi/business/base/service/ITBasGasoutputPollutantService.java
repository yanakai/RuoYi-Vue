package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.TBasGasoutputPollutant;

import java.util.List;

/**
 * 基础信息--企业--废气排口污染物基本信息Service接口
 *
 * @author lx
 * @date 2024-06-27
 */
public interface ITBasGasoutputPollutantService {
    /**
     * 查询基础信息--企业--废气排口污染物基本信息
     *
     * @param id 基础信息--企业--废气排口污染物基本信息主键
     * @return 基础信息--企业--废气排口污染物基本信息
     */
    TBasGasoutputPollutant selectTBasGasoutputPollutantById(Long id);

    /**
     * 查询基础信息--企业--废气排口污染物基本信息列表
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 基础信息--企业--废气排口污染物基本信息集合
     */
    List<TBasGasoutputPollutant> selectTBasGasoutputPollutantList(TBasGasoutputPollutant tBasGasoutputPollutant);

    /**
     * 新增基础信息--企业--废气排口污染物基本信息
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 结果
     */
    int insertTBasGasoutputPollutant(TBasGasoutputPollutant tBasGasoutputPollutant);

    /**
     * 修改基础信息--企业--废气排口污染物基本信息
     *
     * @param tBasGasoutputPollutant 基础信息--企业--废气排口污染物基本信息
     * @return 结果
     */
    int updateTBasGasoutputPollutant(TBasGasoutputPollutant tBasGasoutputPollutant);

    /**
     * 批量删除基础信息--企业--废气排口污染物基本信息
     *
     * @param ids 需要删除的基础信息--企业--废气排口污染物基本信息主键集合
     * @return 结果
     */
    int deleteTBasGasoutputPollutantByIds(Long[] ids);

    /**
     * 删除基础信息--企业--废气排口污染物基本信息信息
     *
     * @param id 基础信息--企业--废气排口污染物基本信息主键
     * @return 结果
     */
    int deleteTBasGasoutputPollutantById(Long id);
}