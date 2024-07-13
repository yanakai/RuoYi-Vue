package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.TBasWateroutPutUnorganized;

import java.util.List;

/**
 * 基础信息--企业--废水无组织排口Mapper接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface TBasWateroutPutUnorganizedMapper {
    /**
     * 查询基础信息--企业--废水无组织排口
     *
     * @param id 基础信息--企业--废水无组织排口主键
     * @return 基础信息--企业--废水无组织排口
     */
    TBasWateroutPutUnorganized selectTBasWateroutPutUnorganizedById(Long id);

    /**
     * 查询基础信息--企业--废水无组织排口列表
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 基础信息--企业--废水无组织排口集合
     */
    List<TBasWateroutPutUnorganized> selectTBasWateroutPutUnorganizedList(TBasWateroutPutUnorganized tBasWateroutPutUnorganized);

    /**
     * 新增基础信息--企业--废水无组织排口
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 结果
     */
    int insertTBasWateroutPutUnorganized(TBasWateroutPutUnorganized tBasWateroutPutUnorganized);

    /**
     * 修改基础信息--企业--废水无组织排口
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 结果
     */
    int updateTBasWateroutPutUnorganized(TBasWateroutPutUnorganized tBasWateroutPutUnorganized);

    /**
     * 删除基础信息--企业--废水无组织排口
     *
     * @param id 基础信息--企业--废水无组织排口主键
     * @return 结果
     */
    int deleteTBasWateroutPutUnorganizedById(Long id);

    /**
     * 批量删除基础信息--企业--废水无组织排口
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTBasWateroutPutUnorganizedByIds(Long[] ids);
}
