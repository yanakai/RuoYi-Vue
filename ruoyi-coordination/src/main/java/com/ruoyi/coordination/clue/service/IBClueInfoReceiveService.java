package com.ruoyi.coordination.clue.service;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoReceive;
import com.ruoyi.coordination.clue.domain.dto.BCIReceive;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndFile;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台--污染线索处置----线索主任务接收单位Service接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface IBClueInfoReceiveService 
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
    int insertBClueInfoReceive(BCIReceive bClueInfoReceive);

    /**
     * 修改协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param bClueInfoReceive 协同平台--污染线索处置----线索主任务接收单位
     * @return 结果
     */
    public int updateBClueInfoReceive(BClueInfoReceive bClueInfoReceive);

    /**
     * 批量删除协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param receiveIds 需要删除的协同平台--污染线索处置----线索主任务接收单位主键集合
     * @return 结果
     */
    public int deleteBClueInfoReceiveByReceiveIds(Long[] receiveIds);

    /**
     * 删除协同平台--污染线索处置----线索主任务接收单位信息
     * 
     * @param receiveId 协同平台--污染线索处置----线索主任务接收单位主键
     * @return 结果
     */
    public int deleteBClueInfoReceiveByReceiveId(Long receiveId);

    int insertReceiveList(Long[] deptIds, BCITaskAndFile bClueInfoTask);
}
