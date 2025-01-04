package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TBasUserPutInfoMapper;
import com.ruoyi.system.domain.TBasUserPutInfo;
import com.ruoyi.system.service.ITBasUserPutInfoService;

/**
 * 用户收藏关注排口信息Service业务层处理
 * 
 * @author liux
 * @date 2025-01-04
 */
@Service
public class TBasUserPutInfoServiceImpl implements ITBasUserPutInfoService 
{
    @Autowired
    private TBasUserPutInfoMapper tBasUserPutInfoMapper;

    /**
     * 查询用户收藏关注排口信息
     * 
     * @param id 用户收藏关注排口信息主键
     * @return 用户收藏关注排口信息
     */
    @Override
    public TBasUserPutInfo selectTBasUserPutInfoById(Long id)
    {
        return tBasUserPutInfoMapper.selectTBasUserPutInfoById(id);
    }

    /**
     * 查询用户收藏关注排口信息列表
     * 
     * @param tBasUserPutInfo 用户收藏关注排口信息
     * @return 用户收藏关注排口信息
     */
    @Override
    public List<TBasUserPutInfo> selectTBasUserPutInfoList(TBasUserPutInfo tBasUserPutInfo)
    {
        return tBasUserPutInfoMapper.selectTBasUserPutInfoList(tBasUserPutInfo);
    }

    /**
     * 新增用户收藏关注排口信息
     * 
     * @param tBasUserPutInfo 用户收藏关注排口信息
     * @return 结果
     */
    @Override
    public int insertTBasUserPutInfo(TBasUserPutInfo tBasUserPutInfo)
    {
        tBasUserPutInfo.setCreateTime(DateUtils.getNowDate());
        return tBasUserPutInfoMapper.insertTBasUserPutInfo(tBasUserPutInfo);
    }

    /**
     * 修改用户收藏关注排口信息
     * 
     * @param tBasUserPutInfo 用户收藏关注排口信息
     * @return 结果
     */
    @Override
    public int updateTBasUserPutInfo(TBasUserPutInfo tBasUserPutInfo)
    {
        return tBasUserPutInfoMapper.updateTBasUserPutInfo(tBasUserPutInfo);
    }

    /**
     * 批量删除用户收藏关注排口信息
     * 
     * @param ids 需要删除的用户收藏关注排口信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasUserPutInfoByIds(Long[] ids)
    {
        return tBasUserPutInfoMapper.deleteTBasUserPutInfoByIds(ids);
    }

    /**
     * 删除用户收藏关注排口信息信息
     * 
     * @param id 用户收藏关注排口信息主键
     * @return 结果
     */
    @Override
    public int deleteTBasUserPutInfoById(Long id)
    {
        return tBasUserPutInfoMapper.deleteTBasUserPutInfoById(id);
    }

    @Override
    public List<Map<String, Object>> selectTBasGasoutPutInfo(Long id) {
        return tBasUserPutInfoMapper.selectTBasGasoutPutInfo(id);
    }

    @Override
    public List<Map<String, Object>> selectTBasWaterPutInfo(Long id) {
        return tBasUserPutInfoMapper.selectTBasWaterPutInfo(id);
    }
}
