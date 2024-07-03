package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasWateroutPutUnorganized;
import com.ruoyi.business.base.mapper.TBasWateroutPutUnorganizedMapper;
import com.ruoyi.business.base.service.ITBasWateroutPutUnorganizedService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础信息--企业--废水无组织排口Service业务层处理
 *
 * @author lx
 * @date 2024-07-04
 */
@Service
public class TBasWateroutPutUnorganizedServiceImpl implements ITBasWateroutPutUnorganizedService {
    @Autowired
    private TBasWateroutPutUnorganizedMapper tBasWateroutPutUnorganizedMapper;

    /**
     * 查询基础信息--企业--废水无组织排口
     *
     * @param id 基础信息--企业--废水无组织排口主键
     * @return 基础信息--企业--废水无组织排口
     */
    @Override
    public TBasWateroutPutUnorganized selectTBasWateroutPutUnorganizedById(Long id) {
        return tBasWateroutPutUnorganizedMapper.selectTBasWateroutPutUnorganizedById(id);
    }

    /**
     * 查询基础信息--企业--废水无组织排口列表
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 基础信息--企业--废水无组织排口
     */
    @Override
    public List<TBasWateroutPutUnorganized> selectTBasWateroutPutUnorganizedList(TBasWateroutPutUnorganized tBasWateroutPutUnorganized) {
        return tBasWateroutPutUnorganizedMapper.selectTBasWateroutPutUnorganizedList(tBasWateroutPutUnorganized);
    }

    /**
     * 新增基础信息--企业--废水无组织排口
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 结果
     */
    @Override
    public int insertTBasWateroutPutUnorganized(TBasWateroutPutUnorganized tBasWateroutPutUnorganized) {
        tBasWateroutPutUnorganized.setCreateTime(DateUtils.getNowDate());
        return tBasWateroutPutUnorganizedMapper.insertTBasWateroutPutUnorganized(tBasWateroutPutUnorganized);
    }

    /**
     * 修改基础信息--企业--废水无组织排口
     *
     * @param tBasWateroutPutUnorganized 基础信息--企业--废水无组织排口
     * @return 结果
     */
    @Override
    public int updateTBasWateroutPutUnorganized(TBasWateroutPutUnorganized tBasWateroutPutUnorganized) {
        tBasWateroutPutUnorganized.setUpdateTime(DateUtils.getNowDate());
        return tBasWateroutPutUnorganizedMapper.updateTBasWateroutPutUnorganized(tBasWateroutPutUnorganized);
    }

    /**
     * 批量删除基础信息--企业--废水无组织排口
     *
     * @param ids 需要删除的基础信息--企业--废水无组织排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutPutUnorganizedByIds(Long[] ids) {
        return tBasWateroutPutUnorganizedMapper.deleteTBasWateroutPutUnorganizedByIds(ids);
    }

    /**
     * 删除基础信息--企业--废水无组织排口信息
     *
     * @param id 基础信息--企业--废水无组织排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutPutUnorganizedById(Long id) {
        return tBasWateroutPutUnorganizedMapper.deleteTBasWateroutPutUnorganizedById(id);
    }
}
