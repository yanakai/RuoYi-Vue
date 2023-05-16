package com.ruoyi.coordination.clue.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.coordination.clue.domain.BClueInfoStationDetail;

/**
 * 协同平台--污染线索处置--空气站点详情Service接口
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
public interface IBClueInfoStationDetailService 
{
    /**
     * 查询协同平台--污染线索处置--空气站点详情
     * 
     * @param stationId 协同平台--污染线索处置--空气站点详情主键
     * @return 协同平台--污染线索处置--空气站点详情
     */
    public BClueInfoStationDetail selectBClueInfoStationDetailByStationId(Long stationId);

    /**
     * 查询协同平台--污染线索处置--空气站点详情列表
     * 
     * @param bClueInfoStationDetail 协同平台--污染线索处置--空气站点详情
     * @return 协同平台--污染线索处置--空气站点详情集合
     */
    public List<BClueInfoStationDetail> selectBClueInfoStationDetailList(BClueInfoStationDetail bClueInfoStationDetail);

    /**
     * 新增协同平台--污染线索处置--空气站点详情
     * 
     * @param bClueInfoStationDetail 协同平台--污染线索处置--空气站点详情
     * @return 结果
     */
    public int insertBClueInfoStationDetail(BClueInfoStationDetail bClueInfoStationDetail);

    /**
     * 修改协同平台--污染线索处置--空气站点详情
     * 
     * @param bClueInfoStationDetail 协同平台--污染线索处置--空气站点详情
     * @return 结果
     */
    public int updateBClueInfoStationDetail(BClueInfoStationDetail bClueInfoStationDetail);

    /**
     * 批量删除协同平台--污染线索处置--空气站点详情
     * 
     * @param stationIds 需要删除的协同平台--污染线索处置--空气站点详情主键集合
     * @return 结果
     */
    public int deleteBClueInfoStationDetailByStationIds(Long[] stationIds);

    /**
     * 删除协同平台--污染线索处置--空气站点详情信息
     * 
     * @param stationId 协同平台--污染线索处置--空气站点详情主键
     * @return 结果
     */
    public int deleteBClueInfoStationDetailByStationId(Long stationId);

    List<Map<String, Object>> selectRegionDict();

    List<Map<String, Object>> selectUnitDict();

}
