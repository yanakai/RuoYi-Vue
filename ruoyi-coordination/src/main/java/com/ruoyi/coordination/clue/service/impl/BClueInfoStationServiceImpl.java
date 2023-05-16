package com.ruoyi.coordination.clue.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoStationMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoStation;
import com.ruoyi.coordination.clue.service.IBClueInfoStationService;

/**
 * 协同平台--污染线索处置--空气站点预警状态Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@Service
public class BClueInfoStationServiceImpl implements IBClueInfoStationService 
{
    @Autowired
    private BClueInfoStationMapper bClueInfoStationMapper;

    /**
     * 查询协同平台--污染线索处置--空气站点预警状态
     * 
     * @param earlyId 协同平台--污染线索处置--空气站点预警状态主键
     * @return 协同平台--污染线索处置--空气站点预警状态
     */
    @Override
    public BClueInfoStation selectBClueInfoStationByEarlyId(Long earlyId)
    {
        return bClueInfoStationMapper.selectBClueInfoStationByEarlyId(earlyId);
    }

    /**
     * 查询协同平台--污染线索处置--空气站点预警状态列表
     * 
     * @param bClueInfoStation 协同平台--污染线索处置--空气站点预警状态
     * @return 协同平台--污染线索处置--空气站点预警状态
     */
    @Override
    public List<BClueInfoStation> selectBClueInfoStationList(BClueInfoStation bClueInfoStation)
    {
        return bClueInfoStationMapper.selectBClueInfoStationList(bClueInfoStation);
    }

    /**
     * 新增协同平台--污染线索处置--空气站点预警状态
     * 
     * @param bClueInfoStation 协同平台--污染线索处置--空气站点预警状态
     * @return 结果
     */
    @Override
    public int insertBClueInfoStation(BClueInfoStation bClueInfoStation)
    {
        bClueInfoStation.setCreateTime(DateUtils.getNowDate());
        return bClueInfoStationMapper.insertBClueInfoStation(bClueInfoStation);
    }

    /**
     * 修改协同平台--污染线索处置--空气站点预警状态
     * 
     * @param bClueInfoStation 协同平台--污染线索处置--空气站点预警状态
     * @return 结果
     */
    @Override
    public int updateBClueInfoStation(BClueInfoStation bClueInfoStation)
    {
        return bClueInfoStationMapper.updateBClueInfoStation(bClueInfoStation);
    }

    /**
     * 批量删除协同平台--污染线索处置--空气站点预警状态
     * 
     * @param earlyIds 需要删除的协同平台--污染线索处置--空气站点预警状态主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoStationByEarlyIds(Long[] earlyIds)
    {
        return bClueInfoStationMapper.deleteBClueInfoStationByEarlyIds(earlyIds);
    }

    /**
     * 删除协同平台--污染线索处置--空气站点预警状态信息
     * 
     * @param earlyId 协同平台--污染线索处置--空气站点预警状态主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoStationByEarlyId(Long earlyId)
    {
        return bClueInfoStationMapper.deleteBClueInfoStationByEarlyId(earlyId);
    }
}
