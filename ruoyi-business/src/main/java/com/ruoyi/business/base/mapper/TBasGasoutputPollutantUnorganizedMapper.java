package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.TBasGasoutputPollutantUnorganized;

import java.util.List;

/**
 * 基础信息--企业--废气无组织排口污染物信息Mapper接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface TBasGasoutputPollutantUnorganizedMapper {
    /**
     * 查询基础信息--企业--废气无组织排口污染物信息
     *
     * @param id 基础信息--企业--废气无组织排口污染物信息主键
     * @return 基础信息--企业--废气无组织排口污染物信息
     */
    public TBasGasoutputPollutantUnorganized selectTBasGasoutputPollutantUnorganizedById(Long id);

    /**
     * 查询基础信息--企业--废气无组织排口污染物信息列表
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 基础信息--企业--废气无组织排口污染物信息集合
     */
    public List<TBasGasoutputPollutantUnorganized> selectTBasGasoutputPollutantUnorganizedList(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized);

    /**
     * 新增基础信息--企业--废气无组织排口污染物信息
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 结果
     */
    public int insertTBasGasoutputPollutantUnorganized(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized);

    /**
     * 修改基础信息--企业--废气无组织排口污染物信息
     *
     * @param tBasGasoutputPollutantUnorganized 基础信息--企业--废气无组织排口污染物信息
     * @return 结果
     */
    public int updateTBasGasoutputPollutantUnorganized(TBasGasoutputPollutantUnorganized tBasGasoutputPollutantUnorganized);

    /**
     * 删除基础信息--企业--废气无组织排口污染物信息
     *
     * @param id 基础信息--企业--废气无组织排口污染物信息主键
     * @return 结果
     */
    public int deleteTBasGasoutputPollutantUnorganizedById(Long id);

    /**
     * 批量删除基础信息--企业--废气无组织排口污染物信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBasGasoutputPollutantUnorganizedByIds(Long[] ids);
}
