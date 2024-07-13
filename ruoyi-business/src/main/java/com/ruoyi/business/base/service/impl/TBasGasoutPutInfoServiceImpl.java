package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.TBasGasoutPutInfo;
import com.ruoyi.business.base.mapper.TBasGasoutPutInfoMapper;
import com.ruoyi.business.base.mapper.TBasGasoutputPollutantMapper;
import com.ruoyi.business.base.service.ITBasGasoutPutInfoService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础信息--企业--废气排口Service业务层处理
 *
 * @author lx
 * @date 2024-06-27
 */
@Service
public class TBasGasoutPutInfoServiceImpl implements ITBasGasoutPutInfoService {
    @Autowired
    private TBasGasoutPutInfoMapper tBasGasoutPutInfoMapper;
    @Resource
    private TBasGasoutputPollutantMapper tBasGasoutputPollutantMapper;

    /**
     * 查询基础信息--企业--废气排口
     *
     * @param id 基础信息--企业--废气排口主键
     * @return 基础信息--企业--废气排口
     */
    @Override
    public TBasGasoutPutInfo selectTBasGasoutPutInfoById(Long id) {
        return tBasGasoutPutInfoMapper.selectTBasGasoutPutInfoById(id);
    }

    /**
     * 查询基础信息--企业--废气排口列表
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 基础信息--企业--废气排口
     */
    @Override
    public List<TBasGasoutPutInfo> selectTBasGasoutPutInfoList(TBasGasoutPutInfo tBasGasoutPutInfo) {
        return tBasGasoutPutInfoMapper.selectTBasGasoutPutInfoList(tBasGasoutPutInfo);
    }

    /**
     * 新增基础信息--企业--废气排口
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 结果
     */
    @Override
    public int insertTBasGasoutPutInfo(TBasGasoutPutInfo tBasGasoutPutInfo) {
        tBasGasoutPutInfo.setCreateTime(DateUtils.getNowDate());
        return tBasGasoutPutInfoMapper.insertTBasGasoutPutInfo(tBasGasoutPutInfo);
    }

    /**
     * 修改基础信息--企业--废气排口
     *
     * @param tBasGasoutPutInfo 基础信息--企业--废气排口
     * @return 结果
     */
    @Override
    public int updateTBasGasoutPutInfo(TBasGasoutPutInfo tBasGasoutPutInfo) {
        tBasGasoutPutInfo.setUpdateTime(DateUtils.getNowDate());
        return tBasGasoutPutInfoMapper.updateTBasGasoutPutInfo(tBasGasoutPutInfo);
    }

    /**
     * 批量删除基础信息--企业--废气排口
     *
     * @param ids 需要删除的基础信息--企业--废气排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutPutInfoByIds(Long[] ids) {
        //删除废气排口污染物基本信息
        tBasGasoutputPollutantMapper.deleteTBasGasoutputPollutantByInfoIds(ids);
        return tBasGasoutPutInfoMapper.deleteTBasGasoutPutInfoByIds(ids);
    }

    /**
     * 删除基础信息--企业--废气排口信息
     *
     * @param id 基础信息--企业--废气排口主键
     * @return 结果
     */
    @Override
    public int deleteTBasGasoutPutInfoById(Long id) {
        //删除废气排口污染物基本信息
        tBasGasoutputPollutantMapper.deleteTBasGasoutputPollutantByInfoId(id);
        return tBasGasoutPutInfoMapper.deleteTBasGasoutPutInfoById(id);
    }
}
