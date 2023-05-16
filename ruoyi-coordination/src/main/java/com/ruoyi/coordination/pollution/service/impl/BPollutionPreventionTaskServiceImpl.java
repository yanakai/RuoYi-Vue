package com.ruoyi.coordination.pollution.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTaskFile;
import com.ruoyi.coordination.pollution.domain.dto.BPPTaskAndFile;
import com.ruoyi.coordination.pollution.domain.dto.BPPTaskAndReceive;
import com.ruoyi.coordination.pollution.domain.enums.BPPTaskLevelEnum;
import com.ruoyi.coordination.pollution.domain.enums.BPPTaskTypeEnum;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionTaskFileMapper;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionReceiveService;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.pollution.mapper.BPollutionPreventionTaskMapper;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTask;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionTaskService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台--污染防治目标--主任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@Service
public class BPollutionPreventionTaskServiceImpl implements IBPollutionPreventionTaskService 
{
    @Autowired
    private BPollutionPreventionTaskMapper bPollutionPreventionTaskMapper;
    @Autowired
    private BPollutionPreventionTaskFileMapper taskFileMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private IBPollutionPreventionReceiveService receiveService;

    /**
     * 查询协同平台--污染防治目标--主任务
     * 
     * @param taskId 协同平台--污染防治目标--主任务主键
     * @return 协同平台--污染防治目标--主任务
     */
    @Override
    public BPollutionPreventionTask selectBPollutionPreventionTaskByTaskId(Long taskId)
    {
        return bPollutionPreventionTaskMapper.selectBPollutionPreventionTaskByTaskId(taskId);
    }

    /**
     * 查询协同平台--污染防治目标--主任务列表
     * 
     * @param bPollutionPreventionTask 协同平台--污染防治目标--主任务
     * @return 协同平台--污染防治目标--主任务
     */
    @Override
    public List<BPollutionPreventionTask> selectBPollutionPreventionTaskList(BPollutionPreventionTask bPollutionPreventionTask)
    {
        List<SysDept> sysDepts = sysDeptMapper.selectChildrenDeptById(SecurityUtils.getDeptId());
        List<Long> childDeptIds = sysDepts.stream().map(d -> d.getDeptId()).collect(Collectors.toList());
        childDeptIds.add(SecurityUtils.getDeptId());
        List<BPollutionPreventionTask> taskList = bPollutionPreventionTaskMapper.selectBPollutionPreventionTaskList(bPollutionPreventionTask, childDeptIds);
        taskList.forEach(t -> {
            t.setTaskTypeName(BPPTaskTypeEnum.getByValue(t.getTaskType()));
            t.setTaskLevelName(BPPTaskLevelEnum.getByValue(t.getTaskLevel()));
        });
        return taskList;
    }

    /**
     * 新增协同平台--污染防治目标--主任务
     * 
     * @param bppTaskAndFile 协同平台--污染防治目标--主任务
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBPollutionPreventionTask(BPPTaskAndFile bppTaskAndFile)
    {
        //创建主任务
        BPollutionPreventionTask bPollutionPreventionTask = new BPollutionPreventionTask();
        //主任务复制属性
        BeanUtils.copyProperties(bppTaskAndFile,bPollutionPreventionTask);
        bPollutionPreventionTask.setCreateUserId(SecurityUtils.getUserId());
        bPollutionPreventionTask.setCreateUserName(SecurityUtils.getUsername());
        bPollutionPreventionTask.setCreateDeptId(SecurityUtils.getDeptId());
        SysDept sysDept = sysDeptMapper.selectDeptById(SecurityUtils.getDeptId());
        bPollutionPreventionTask.setCreateDeptName(sysDept.getDeptName());
        bPollutionPreventionTask.setCreateTime(DateUtils.getNowDate());
        if (sysDept.getParentId().equals("0")){ //即当前为市级
            bPollutionPreventionTask.setTaskSource("市发任务");
        }else {
            bPollutionPreventionTask.setTaskSource("县级任务");
        }
        int num = bPollutionPreventionTaskMapper.insertBPollutionPreventionTask(bPollutionPreventionTask);

        //获取附件集合  判断
        List<BPollutionPreventionTaskFile> fileList = bppTaskAndFile.getFileList();
        if (fileList.size() > 0){
            fileList.forEach(f -> f.setTaskId(bPollutionPreventionTask.getTaskId()));
            //批量添加附件
            taskFileMapper.insertBPollutionPreventionTaskFileList(fileList);
        }

        //下级单位接收任务
        Long[] deptIds = bppTaskAndFile.getDeptIds();
        receiveService.insertReceiveList(deptIds,bPollutionPreventionTask);

        return num;
    }

    /**
     * 修改协同平台--污染防治目标--主任务
     * 
     * @param bPollutionPreventionTask 协同平台--污染防治目标--主任务
     * @return 结果
     */
    @Override
    public int updateBPollutionPreventionTask(BPollutionPreventionTask bPollutionPreventionTask)
    {
        return bPollutionPreventionTaskMapper.updateBPollutionPreventionTask(bPollutionPreventionTask);
    }

    /**
     * 批量删除协同平台--污染防治目标--主任务
     * 
     * @param taskIds 需要删除的协同平台--污染防治目标--主任务主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionTaskByTaskIds(Long[] taskIds)
    {
        return bPollutionPreventionTaskMapper.deleteBPollutionPreventionTaskByTaskIds(taskIds);
    }

    /**
     * 删除协同平台--污染防治目标--主任务信息
     * 
     * @param taskId 协同平台--污染防治目标--主任务主键
     * @return 结果
     */
    @Override
    public int deleteBPollutionPreventionTaskByTaskId(Long taskId)
    {
        return bPollutionPreventionTaskMapper.deleteBPollutionPreventionTaskByTaskId(taskId);
    }

    @Override
    public List<BPPTaskAndReceive> selectBPollutionPreventionTaskListByDeptId(BPPTaskAndReceive bPollutionPreventionTask) {

        Long deptId = SecurityUtils.getDeptId();
        List<BPPTaskAndReceive> taskList = bPollutionPreventionTaskMapper.selectBPollutionPreventionTaskListByDeptId(bPollutionPreventionTask, deptId);
        taskList.forEach(t -> {
            t.setTaskTypeName(BPPTaskTypeEnum.getByValue(t.getTaskType()));
            t.setTaskLevelName(BPPTaskLevelEnum.getByValue(t.getTaskLevel()));
        });
        return taskList;
    }

    @Override
    public List<BPPTaskAndReceive> selectBPollutionPreventionExTaskListByDeptId(BPPTaskAndReceive bPollutionPreventionTask) {
        Long deptId = SecurityUtils.getDeptId();
        List<BPPTaskAndReceive> taskList = bPollutionPreventionTaskMapper.selectBPollutionPreventionExTaskListByDeptId(bPollutionPreventionTask, deptId);
        taskList.forEach(t -> {
            t.setTaskTypeName(BPPTaskTypeEnum.getByValue(t.getTaskType()));
            t.setTaskLevelName(BPPTaskLevelEnum.getByValue(t.getTaskLevel()));
        });
        return taskList;
    }
}
