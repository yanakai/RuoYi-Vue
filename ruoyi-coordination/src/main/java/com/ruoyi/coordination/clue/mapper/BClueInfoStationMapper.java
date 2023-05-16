package com.ruoyi.coordination.clue.mapper;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoStation;

/**
 * 协同平台--污染线索处置--空气站点预警状态Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface BClueInfoStationMapper 
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
     * 删除协同平台--污染线索处置--空气站点预警状态
     * 
     * @param earlyId 协同平台--污染线索处置--空气站点预警状态主键
     * @return 结果
     */
    public int deleteBClueInfoStationByEarlyId(Long earlyId);

    /**
     * 批量删除协同平台--污染线索处置--空气站点预警状态
     * 
     * @param earlyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBClueInfoStationByEarlyIds(Long[] earlyIds);
}
