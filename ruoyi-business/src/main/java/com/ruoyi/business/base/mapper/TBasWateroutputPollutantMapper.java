package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.TBasWateroutputPollutant;

import java.util.List;

/**
 * 基础信息--企业--废水排口污染物基本信息Mapper接口
 *
 * @author lx
 * @date 2024-06-27
 */
public interface TBasWateroutputPollutantMapper {
    /**
     * 查询基础信息--企业--废水排口污染物基本信息
     *
     * @param id 基础信息--企业--废水排口污染物基本信息主键
     * @return 基础信息--企业--废水排口污染物基本信息
     */
    TBasWateroutputPollutant selectTBasWateroutputPollutantById(Long id);

    /**
     * 查询基础信息--企业--废水排口污染物基本信息列表
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 基础信息--企业--废水排口污染物基本信息集合
     */
    List<TBasWateroutputPollutant> selectTBasWateroutputPollutantList(TBasWateroutputPollutant tBasWateroutputPollutant);

    /**
     * 新增基础信息--企业--废水排口污染物基本信息
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 结果
     */
    int insertTBasWateroutputPollutant(TBasWateroutputPollutant tBasWateroutputPollutant);

    /**
     * 修改基础信息--企业--废水排口污染物基本信息
     *
     * @param tBasWateroutputPollutant 基础信息--企业--废水排口污染物基本信息
     * @return 结果
     */
    int updateTBasWateroutputPollutant(TBasWateroutputPollutant tBasWateroutputPollutant);

    /**
     * 删除基础信息--企业--废水排口污染物基本信息
     *
     * @param id 基础信息--企业--废水排口污染物基本信息主键
     * @return 结果
     */
    int deleteTBasWateroutputPollutantById(Long id);

    /**
     * 批量删除基础信息--企业--废水排口污染物基本信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTBasWateroutputPollutantByIds(Long[] ids);
}
