package com.ruoyi.coordination.clue.mapper;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoReceive;

/**
 * 协同平台--污染线索处置----线索主任务接收单位Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface BClueInfoReceiveMapper 
{
    /**
     * 查询协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param receiveId 协同平台--污染线索处置----线索主任务接收单位主键
     * @return 协同平台--污染线索处置----线索主任务接收单位
     */
    public BClueInfoReceive selectBClueInfoReceiveByReceiveId(Long receiveId);

    /**
     * 查询协同平台--污染线索处置----线索主任务接收单位列表
     * 
     * @param bClueInfoReceive 协同平台--污染线索处置----线索主任务接收单位
     * @return 协同平台--污染线索处置----线索主任务接收单位集合
     */
    public List<BClueInfoReceive> selectBClueInfoReceiveList(BClueInfoReceive bClueInfoReceive);

    /**
     * 新增协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param bClueInfoReceive 协同平台--污染线索处置----线索主任务接收单位
     * @return 结果
     */
    public int insertBClueInfoReceive(BClueInfoReceive bClueInfoReceive);

    /**
     * 修改协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param bClueInfoReceive 协同平台--污染线索处置----线索主任务接收单位
     * @return 结果
     */
    public int updateBClueInfoReceive(BClueInfoReceive bClueInfoReceive);

    /**
     * 删除协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param receiveId 协同平台--污染线索处置----线索主任务接收单位主键
     * @return 结果
     */
    public int deleteBClueInfoReceiveByReceiveId(Long receiveId);

    /**
     * 批量删除协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param receiveIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBClueInfoReceiveByReceiveIds(Long[] receiveIds);

    int insertBClueInfoReceiveList(List<BClueInfoReceive> list);
}
