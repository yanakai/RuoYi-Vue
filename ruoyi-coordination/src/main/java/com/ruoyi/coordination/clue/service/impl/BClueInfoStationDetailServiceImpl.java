package com.ruoyi.coordination.clue.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoStationDetailMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoStationDetail;
import com.ruoyi.coordination.clue.service.IBClueInfoStationDetailService;

/**
 * 协同平台--污染线索处置--空气站点详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
@Service
public class BClueInfoStationDetailServiceImpl implements IBClueInfoStationDetailService 
{
    @Autowired
    private BClueInfoStationDetailMapper bClueInfoStationDetailMapper;

    /**
     * 查询协同平台--污染线索处置--空气站点详情
     * 
     * @param stationId 协同平台--污染线索处置--空气站点详情主键
     * @return 协同平台--污染线索处置--空气站点详情
     */
    @Override
    public BClueInfoStationDetail selectBClueInfoStationDetailByStationId(Long stationId)
    {
        return bClueInfoStationDetailMapper.selectBClueInfoStationDetailByStationId(stationId);
    }

    /**
     * 查询协同平台--污染线索处置--空气站点详情列表
     * 
     * @param bClueInfoStationDetail 协同平台--污染线索处置--空气站点详情
     * @return 协同平台--污染线索处置--空气站点详情
     */
    @Override
    public List<BClueInfoStationDetail> selectBClueInfoStationDetailList(BClueInfoStationDetail bClueInfoStationDetail)
    {
        return bClueInfoStationDetailMapper.selectBClueInfoStationDetailList(bClueInfoStationDetail);
    }

    /**
     * 新增协同平台--污染线索处置--空气站点详情
     * 
     * @param bClueInfoStationDetail 协同平台--污染线索处置--空气站点详情
     * @return 结果
     */
    @Override
    public int insertBClueInfoStationDetail(BClueInfoStationDetail bClueInfoStationDetail)
    {
        return bClueInfoStationDetailMapper.insertBClueInfoStationDetail(bClueInfoStationDetail);
    }

    /**
     * 修改协同平台--污染线索处置--空气站点详情
     * 
     * @param bClueInfoStationDetail 协同平台--污染线索处置--空气站点详情
     * @return 结果
     */
    @Override
    public int updateBClueInfoStationDetail(BClueInfoStationDetail bClueInfoStationDetail)
    {
        return bClueInfoStationDetailMapper.updateBClueInfoStationDetail(bClueInfoStationDetail);
    }

    /**
     * 批量删除协同平台--污染线索处置--空气站点详情
     * 
     * @param stationIds 需要删除的协同平台--污染线索处置--空气站点详情主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoStationDetailByStationIds(Long[] stationIds)
    {
        return bClueInfoStationDetailMapper.deleteBClueInfoStationDetailByStationIds(stationIds);
    }

    /**
     * 删除协同平台--污染线索处置--空气站点详情信息
     * 
     * @param stationId 协同平台--污染线索处置--空气站点详情主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoStationDetailByStationId(Long stationId)
    {
        return bClueInfoStationDetailMapper.deleteBClueInfoStationDetailByStationId(stationId);
    }

    @Override
    public List<Map<String, Object>> selectRegionDict() {
        return bClueInfoStationDetailMapper.selectRegionDict();
    }

    @Override
    public List<Map<String, Object>> selectUnitDict() {
        return bClueInfoStationDetailMapper.selectUnitDict();
    }
}
