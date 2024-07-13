package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.TBasWateroutputPollutantUnorganized;

import java.util.List;

/**
 * 基础信息--企业--废水无组织排口污染物信息Mapper接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface TBasWateroutputPollutantUnorganizedMapper {
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
     * 删除基础信息--企业--废水无组织排口污染物信息
     *
     * @param id 基础信息--企业--废水无组织排口污染物信息主键
     * @return 结果
     */
    int deleteTBasWateroutputPollutantUnorganizedById(Long id);

    /**
     * 批量删除基础信息--企业--废水无组织排口污染物信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTBasWateroutputPollutantUnorganizedByIds(Long[] ids);

    int deleteTBasWateroutputPollutantUnorganizedByOutputId(Long id);

    int deleteTBasWateroutputPollutantUnorganizedByOutputIds(Long[] ids);
}
