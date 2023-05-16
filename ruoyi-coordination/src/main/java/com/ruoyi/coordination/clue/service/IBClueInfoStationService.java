package com.ruoyi.coordination.clue.service;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoStation;

/**
 * 协同平台--污染线索处置--空气站点预警状态Service接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface IBClueInfoStationService 
{
    /**
     * 查询协同平台--污染线索处置--空气站点预警状态
     * 
     * @param earlyId 协同平台--污染线索处置--空气站点预警状态主键
     * @return 协同平台--污染线索处置--空气站点预警状态
     */
    public BClueInfoStation selectBClueInfoStationByEarlyId(Long earlyId);

    /**
     * 查询协同平台--污染线索处置--空气站点预警状态列表
     * 
     * @param bClueInfoStation 协同平台--污染线索处置--空气站点预警状态
     * @return 协同平台--污染线索处置--空气站点预警状态集合
     */
    public List<BClueInfoStation> selectBClueInfoStationList(BClueInfoStation bClueInfoStation);

    /**
     * 新增协同平台--污染线索处置--空气站点预警状态
     * 
     * @param bClueInfoStation 协同平台--污染线索处置--空气站点预警状态
     * @return 结果
     */
    public int insertBClueInfoStation(BClueInfoStation bClueInfoStation);

    /**
     * 修改协同平台--污染线索处置--空气站点预警状态
     * 
     * @param bClueInfoStation 协同平台--污染线索处置--空气站点预警状态
     * @return 结果
     */
    public int updateBClueInfoStation(BClueInfoStation bClueInfoStation);

    /**
     * 批量删除协同平台--污染线索处置--空气站点预警状态
     * 
     * @param earlyIds 需要删除的协同平台--污染线索处置--空气站点预警状态主键集合
     * @return 结果
     */
    public int deleteBClueInfoStationByEarlyIds(Long[] earlyIds);

    /**
     * 删除协同平台--污染线索处置--空气站点预警状态信息
     * 
     * @param earlyId 协同平台--污染线索处置--空气站点预警状态主键
     * @return 结果
     */
    public int deleteBClueInfoStationByEarlyId(Long earlyId);
}
