package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasGasoutPutUnorganized;
import com.ruoyi.business.base.mapper.TBasGasoutPutUnorganizedMapper;
import com.ruoyi.business.base.mapper.TBasGasoutputPollutantUnorganizedMapper;
import com.ruoyi.business.base.service.ITBasGasoutPutUnorganizedService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础信息--企业--废气无组织排口Service业务层处理
 *
 * @author lx
 * @date 2024-07-04
 */
@Service
public class TBasGasoutPutUnorganizedServiceImpl implements ITBasGasoutPutUnorganizedService {
    @Autowired
    private TBasGasoutPutUnorganizedMapper tBasGasoutPutUnorganizedMapper;
    @Resource
    private TBasGasoutputPollutantUnorganizedMapper tBasGasoutputPollutantUnorganizedMapper;

    /**
     * 查询基础信息--企业--废气无组织排口
     *
     * @param id 基础信息--企业--废气无组织排口主键
     * @return 基础信息--企业--废气无组织排口
     */
    @Override
    public TBasGasoutPutUnorganized selectTBasGasoutPutUnorganizedById(Long id) {
        return tBasGasoutPutUnorganizedMapper.selectTBasGasoutPutUnorganizedById(id);
    }

    /**
     * 查询基础信息--企业--废气无组织排口列表
     *
     * @param tBasGasoutPutUnorganized 基础信息--企业--废气无组织排口
     * @return 基础信息--企业--废气无组织排口
     */
    @Override
    public List<TBasGasoutPutUnorganized> selectTBasGasoutPutUnorganizedList(TBasGasoutPutUnorganized tBasGasoutPutUnorganized) {
        return tBasGasoutPutUnorganizedMapper.selectTBasGasoutPutUnorganizedList(tBasGasoutPutUnorganized);
    }

    /**
     * 新增基础信息--企业--废气无组织排口
     *
     * @param tBasGasoutPutUnorganized 基础信息--企业--废气无组织排口
     * @return 结果
     */
    @Override
    public int insertTBasGasoutPutUnorganized(TBasGasoutPutUnorganized tBasGasoutPutUnorganized) {
        tBasGasoutPutUnorganized.setCreateTime(DateUtils.getNowDate());
        return tBasGasoutPutUnorganizedMapper.insertTBasGasoutPutUnorganized(tBasGasoutPutUnorganized);
    }

    /**
     * 修改基础信息--企业--废气无组织排口
     *
     * @param tBasGasoutPutUnorganized 基础信息--企业--废气无组织排口
     * @return 结果
     */
    @Override
    public int updateTBasGasoutPutUnorganized(TBasGasoutPutUnorganized tBasGasoutPutUnorganized) {
        tBasGasoutPutUnorganized.setUpdateTime(DateUtils.getNowDate());
        return tBasGasoutPutUnorganizedMapper.updateTBasGasoutPutUnorganized(tBasGasoutPutUnorganized);
    }

    /**
     * 批量删除基础信息--企业--废气无组织排口
     *
     * @param ids 需要删除的基础信息--企业--废气无组织排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutPutUnorganizedByIds(Long[] ids) {
        tBasGasoutputPollutantUnorganizedMapper.deleteTBasGasoutputPollutantUnorganizedByGasoutputIds(ids);
        return tBasGasoutPutUnorganizedMapper.deleteTBasGasoutPutUnorganizedByIds(ids);
    }

    /**
     * 删除基础信息--企业--废气无组织排口信息
     *
     * @param id 基础信息--企业--废气无组织排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutPutUnorganizedById(Long id) {
        tBasGasoutputPollutantUnorganizedMapper.deleteTBasGasoutputPollutantUnorganizedByGasoutputId(id);
        return tBasGasoutPutUnorganizedMapper.deleteTBasGasoutPutUnorganizedById(id);
    }
}
