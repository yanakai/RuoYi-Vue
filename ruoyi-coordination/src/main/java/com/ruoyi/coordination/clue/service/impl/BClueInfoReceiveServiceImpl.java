package com.ruoyi.coordination.clue.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.coordination.clue.domain.dto.BCIReceive;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndFile;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoReceiveMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoReceive;
import com.ruoyi.coordination.clue.service.IBClueInfoReceiveService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台--污染线索处置----线索主任务接收单位Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@Service
public class BClueInfoReceiveServiceImpl implements IBClueInfoReceiveService 
{
    @Autowired
    private BClueInfoReceiveMapper bClueInfoReceiveMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param receiveId 协同平台--污染线索处置----线索主任务接收单位主键
     * @return 协同平台--污染线索处置----线索主任务接收单位
     */
    @Override
    public BClueInfoReceive selectBClueInfoReceiveByReceiveId(Long receiveId)
    {
        return bClueInfoReceiveMapper.selectBClueInfoReceiveByReceiveId(receiveId);
    }

    /**
     * 查询协同平台--污染线索处置----线索主任务接收单位列表
     * 
     * @param bClueInfoReceive 协同平台--污染线索处置----线索主任务接收单位
     * @return 协同平台--污染线索处置----线索主任务接收单位
     */
    @Override
    public List<BClueInfoReceive> selectBClueInfoReceiveList(BClueInfoReceive bClueInfoReceive)
    {
        return bClueInfoReceiveMapper.selectBClueInfoReceiveList(bClueInfoReceive);
    }

    /**
     * 新增协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param bClueInfoReceive 协同平台--污染线索处置----线索主任务接收单位
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBClueInfoReceive(BCIReceive bClueInfoReceive)
    {
        bClueInfoReceive.setCreateTime(DateUtils.getNowDate());
        bClueInfoReceive.setCreateUserId(SecurityUtils.getUserId());
        bClueInfoReceive.setCreateUserName(SecurityUtils.getUsername());
        bClueInfoReceive.setCreateDeptId(SecurityUtils.getDeptId());
        bClueInfoReceive.setReceiveDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        bClueInfoReceive.setReceiveState("0");
        bClueInfoReceive.setUrgingState("0");
        Long[] deptIds = bClueInfoReceive.getDeptIds();
        List<BClueInfoReceive> list = new ArrayList<>();
        if (deptIds != null && deptIds.length > 0){
            for (Long deptId : deptIds) {
                BClueInfoReceive receive = new BClueInfoReceive();
                BeanUtils.copyProperties(bClueInfoReceive,receive);
                receive.setReceiveDeptId(deptId);
                receive.setReceiveTime(DateUtils.getNowDate());
                receive.setReceiveDeptName(sysDeptMapper.selectDeptById(deptId).getDeptName());
                list.add(receive);
            }
        }
        int i = bClueInfoReceiveMapper.insertBClueInfoReceiveList(list);
        // 更新父级接收记录的状态
        Long receivePid = bClueInfoReceive.getReceivePid();
        BClueInfoReceive receive = new BClueInfoReceive();
        receive.setReceiveId(receivePid);
        receive.setReceiveState("2"); //状态改为 已下发
        bClueInfoReceiveMapper.updateBClueInfoReceive(receive);
        return i;
    }

    /**
     * 修改协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param bClueInfoReceive 协同平台--污染线索处置----线索主任务接收单位
     * @return 结果
     */
    @Override
    public int updateBClueInfoReceive(BClueInfoReceive bClueInfoReceive)
    {
        return bClueInfoReceiveMapper.updateBClueInfoReceive(bClueInfoReceive);
    }

    /**
     * 批量删除协同平台--污染线索处置----线索主任务接收单位
     * 
     * @param receiveIds 需要删除的协同平台--污染线索处置----线索主任务接收单位主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoReceiveByReceiveIds(Long[] receiveIds)
    {
        return bClueInfoReceiveMapper.deleteBClueInfoReceiveByReceiveIds(receiveIds);
    }

    /**
     * 删除协同平台--污染线索处置----线索主任务接收单位信息
     * 
     * @param receiveId 协同平台--污染线索处置----线索主任务接收单位主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoReceiveByReceiveId(Long receiveId)
    {
        return bClueInfoReceiveMapper.deleteBClueInfoReceiveByReceiveId(receiveId);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertReceiveList(Long[] deptIds, BCITaskAndFile bClueInfoTask) {
        List<BClueInfoReceive> receiveList = Arrays.stream(deptIds).map(d -> {
            BClueInfoReceive receive = new BClueInfoReceive();
            receive.setTaskId(bClueInfoTask.getTaskId());
            receive.setDisseminateComments(bClueInfoTask.getDisseminateComments());
            receive.setReceiveTime(DateUtils.getNowDate());
            receive.setReceiveDeptId(d);
            receive.setReceiveDeptName(sysDeptMapper.selectDeptById(d).getDeptName());
            receive.setCreateUserId(SecurityUtils.getUserId());
            receive.setCreateUserName(SecurityUtils.getUsername());
            receive.setCreateDeptId(SecurityUtils.getDeptId());
            receive.setCreateDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
            receive.setCreateTime(DateUtils.getNowDate());
            if (bClueInfoTask.getReceiveId() != null){
                receive.setReceivePid(bClueInfoTask.getReceiveId());
            }
            receive.setReceiveState("0"); //接收状态默认为0
            receive.setUrgingState("0"); //催办状态默认为0
            return receive;
        }).collect(Collectors.toList());
        if (bClueInfoTask.getReceiveId() != null){
            BClueInfoReceive receive = new BClueInfoReceive();
            receive.setReceiveId(bClueInfoTask.getReceiveId());
            receive.setReceiveState("2");
            bClueInfoReceiveMapper.updateBClueInfoReceive(receive);
        }

        return bClueInfoReceiveMapper.insertBClueInfoReceiveList(receiveList);
    }
}
