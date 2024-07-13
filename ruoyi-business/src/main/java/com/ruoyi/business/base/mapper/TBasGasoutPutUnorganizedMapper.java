package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.TBasGasoutPutUnorganized;

import java.util.List;

/**
 * 基础信息--企业--废气无组织排口Mapper接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface TBasGasoutPutUnorganizedMapper {
    /**
     * 查询基础信息--企业--废气无组织排口
     *
     * @param id 基础信息--企业--废气无组织排口主键
     * @return 基础信息--企业--废气无组织排口
     */
    TBasGasoutPutUnorganized selectTBasGasoutPutUnorganizedById(Long id);

    /**
     * 查询基础信息--企业--废气无组织排口列表
     *
     * @param tBasGasoutPutUnorganized 基础信息--企业--废气无组织排口
     * @return 基础信息--企业--废气无组织排口集合
     */
    List<TBasGasoutPutUnorganized> selectTBasGasoutPutUnorganizedList(TBasGasoutPutUnorganized tBasGasoutPutUnorganized);

    /**
     * 新增基础信息--企业--废气无组织排口
     *
     * @param tBasGasoutPutUnorganized 基础信息--企业--废气无组织排口
     * @return 结果
     */
    int insertTBasGasoutPutUnorganized(TBasGasoutPutUnorganized tBasGasoutPutUnorganized);

    /**
     * 修改基础信息--企业--废气无组织排口
     *
     * @param tBasGasoutPutUnorganized 基础信息--企业--废气无组织排口
     * @return 结果
     */
    int updateTBasGasoutPutUnorganized(TBasGasoutPutUnorganized tBasGasoutPutUnorganized);

    /**
     * 删除基础信息--企业--废气无组织排口
     *
     * @param id 基础信息--企业--废气无组织排口主键
     * @return 结果
     */
    int deleteTBasGasoutPutUnorganizedById(Long id);

    /**
     * 批量删除基础信息--企业--废气无组织排口
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteTBasGasoutPutUnorganizedByIds(Long[] ids);
}
