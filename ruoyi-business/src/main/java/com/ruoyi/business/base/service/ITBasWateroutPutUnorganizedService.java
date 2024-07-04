package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.TBasWateroutPutUnorganized;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 基础信息--企业--废水无组织排口Service接口
 *
 * @author lx
 * @date 2024-07-04
 */
public interface ITBasWateroutPutUnorganizedService {
    /**
     * 查询基础信息--企业--废水无组织排口
     *
     * @param id 基础信息--企业--废水无组织排口主键
     * @return 基础信息--企业--废水无组织排口
     */
    public TBasWateroutPutUnorganized selectTBasWateroutPutUnorganizedById(Long id);

    /**
     * 查询基础信息--企业--废水无组织排口列表
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 基础信息--企业--废水无组织排口集合
     */
    public List<TBasWateroutPutUnorganized> selectTBasWateroutPutUnorganizedList(TBasWateroutPutUnorganized tBasWateroutPutUnorganized);

    /**
     * 新增基础信息--企业--废水无组织排口
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 结果
     */
    public int insertTBasWateroutPutUnorganized(TBasWateroutPutUnorganized tBasWateroutPutUnorganized);

    /**
     * 修改基础信息--企业--废水无组织排口
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 结果
     */
    public int updateTBasWateroutPutUnorganized(TBasWateroutPutUnorganized tBasWateroutPutUnorganized);

    /**
     * 批量删除基础信息--企业--废水无组织排口
     *
     * @param ids 需要删除的基础信息--企业--废水无组织排口主键集合
     * @return 结果
     */
    @Transactional
    public int deleteTBasWateroutPutUnorganizedByIds(Long[] ids);

    /**
     * 删除基础信息--企业--废水无组织排口信息
     *
     * @param id 基础信息--企业--废水无组织排口主键
     * @return 结果
     */
    @Transactional
    public int deleteTBasWateroutPutUnorganizedById(Long id);
}
