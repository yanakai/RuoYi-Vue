package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasWateroutPutInfo;
import com.ruoyi.business.base.mapper.TBasWateroutPutInfoMapper;
import com.ruoyi.business.base.mapper.TBasWateroutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasWateroutPutInfoService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础信息--企业--废水排口Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasWateroutPutInfoServiceImpl implements ITBasWateroutPutInfoService {
    @Autowired
    private TBasWateroutPutInfoMapper tBasWateroutPutInfoMapper;
    @Resource
    private TBasWateroutputPollutantMapper tBasWateroutputPollutantMapper;

    /**
     * 查询基础信息--企业--废水排口
     *
     * @param id 基础信息--企业--废水排口主键
     * @return 基础信息--企业--废水排口
     */
    @Override
    public TBasWateroutPutInfo selectTBasWateroutPutInfoById(Long id) {
        return tBasWateroutPutInfoMapper.selectTBasWateroutPutInfoById(id);
    }

    /**
     * 查询基础信息--企业--废水排口列表
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 基础信息--企业--废水排口
     */
    @Override
    public List<TBasWateroutPutInfo> selectTBasWateroutPutInfoList(TBasWateroutPutInfo tBasWateroutPutInfo) {
        return tBasWateroutPutInfoMapper.selectTBasWateroutPutInfoList(tBasWateroutPutInfo);
    }

    /**
     * 新增基础信息--企业--废水排口
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 结果
     */
    @Override
    public int insertTBasWateroutPutInfo(TBasWateroutPutInfo tBasWateroutPutInfo) {
        tBasWateroutPutInfo.setCreateTime(DateUtils.getNowDate());
        return tBasWateroutPutInfoMapper.insertTBasWateroutPutInfo(tBasWateroutPutInfo);
    }

    /**
     * 修改基础信息--企业--废水排口
     *
     * @param tBasWateroutPutInfo 基础信息--企业--废水排口
     * @return 结果
     */
    @Override
    public int updateTBasWateroutPutInfo(TBasWateroutPutInfo tBasWateroutPutInfo) {
        tBasWateroutPutInfo.setUpdateTime(DateUtils.getNowDate());
        return tBasWateroutPutInfoMapper.updateTBasWateroutPutInfo(tBasWateroutPutInfo);
    }

    /**
     * 批量删除基础信息--企业--废水排口
     *
     * @param ids 需要删除的基础信息--企业--废水排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutPutInfoByIds(Long[] ids) {
        //删除废水排口污染物基本信息
        tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantByInfoIds(ids);
        return tBasWateroutPutInfoMapper.deleteTBasWateroutPutInfoByIds(ids);
    }

    /**
     * 删除基础信息--企业--废水排口信息
     *
     * @param id 基础信息--企业--废水排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasWateroutPutInfoById(Long id) {
        //删除废水排口污染物基本信息
        tBasWateroutputPollutantMapper.deleteTBasWateroutputPollutantByInfoId(id);
        return tBasWateroutPutInfoMapper.deleteTBasWateroutPutInfoById(id);
    }
}
