package com.ruoyi.coordination.annual.service.impl;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.coordination.annual.domain.BAnnualTargetReceive;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTaskFile;
import com.ruoyi.coordination.annual.domain.dto.TaskAndFile;
import com.ruoyi.coordination.annual.mapper.BAnnualTargetTaskFileMapper;
import com.ruoyi.coordination.annual.service.IBAnnualTargetReceiveService;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.annual.mapper.BAnnualTargetTaskMapper;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTask;
import com.ruoyi.coordination.annual.service.IBAnnualTargetTaskService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 协同平台--年度目标任务--任务主Service业务层处理
 * @author: yanakai@126.com
 * @date: 2023/4/20 15:11
 * @param: null
 * @return:
 **/
@Service
public class BAnnualTargetTaskServiceImpl implements IBAnnualTargetTaskService
{
    @Autowired
    private BAnnualTargetTaskMapper bAnnualTargetTaskMapper;
    @Autowired
    private BAnnualTargetTaskFileMapper taskFileMapper;
    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private IBAnnualTargetReceiveService ibAnnualTargetReceiveService;

    /**
     * 查询协同平台--年度目标任务--任务主
     *
     * @param taskId 协同平台--年度目标任务--任务主主键
     * @return 协同平台--年度目标任务--任务主
     */
    @Override
    public BAnnualTargetTask selectBAnnualTargetTaskByTaskId(Long taskId)
    {
        return bAnnualTargetTaskMapper.selectBAnnualTargetTaskByTaskId(taskId);
    }





    /**
     * 查询协同平台--年度目标任务--任务主列表
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 协同平台--年度目标任务--任务主
     */
    @Override
    public List<BAnnualTargetTask> selectBAnnualTargetTaskList(BAnnualTargetTask bAnnualTargetTask)
    {
        return bAnnualTargetTaskMapper.selectBAnnualTargetTaskList(bAnnualTargetTask);
    }
    /**
     * 查询协同平台--年度目标任务--任务主列表及附件
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 协同平台--年度目标任务--任务主
     */
    @Override
    public List<TaskAndFile> selectBAnnualTargetTaskListAndFile(BAnnualTargetTask bAnnualTargetTask){
        return bAnnualTargetTaskMapper.selectBAnnualTargetTaskListAndFile(bAnnualTargetTask);
    }

    /**
     * 新增协同平台--年度目标任务--任务主
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 结果
     */
    @Override
    public int insertBAnnualTargetTask(BAnnualTargetTask bAnnualTargetTask)
    {
        bAnnualTargetTask.setCreateTime(DateUtils.getNowDate());
        return bAnnualTargetTaskMapper.insertBAnnualTargetTask(bAnnualTargetTask);
    }



    /**
     * 修改协同平台--年度目标任务--任务主
     *
     * @param bAnnualTargetTask 协同平台--年度目标任务--任务主
     * @return 结果
     */
    @Override
    public int updateBAnnualTargetTask(BAnnualTargetTask bAnnualTargetTask)
    {
        return bAnnualTargetTaskMapper.updateBAnnualTargetTask(bAnnualTargetTask);
    }

    /**
     * 批量删除协同平台--年度目标任务--任务主
     *
     * @param taskIds 需要删除的协同平台--年度目标任务--任务主主键
     * @return 结果
     */
    @Override
    public int deleteBAnnualTargetTaskByTaskIds(Long[] taskIds)
    {
        return bAnnualTargetTaskMapper.deleteBAnnualTargetTaskByTaskIds(taskIds);
    }

    /**
     * 删除协同平台--年度目标任务--任务主信息
     *
     * @param taskId 协同平台--年度目标任务--任务主主键
     * @return 结果
     */
    @Override
    public int deleteBAnnualTargetTaskByTaskId(Long taskId)
    {
        return bAnnualTargetTaskMapper.deleteBAnnualTargetTaskByTaskId(taskId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBAnnualTargetTaskAndRec(TaskAndFile bAnnualTargetTask) {
        BAnnualTargetTask task = new BAnnualTargetTask();
        BeanUtils.copyProperties(bAnnualTargetTask,task);
        Long[] deptIds = bAnnualTargetTask.getDeptIds();
        if (deptIds.length > 0){
            task.setTaskState("1");
        }
        Long deptId = SecurityUtils.getDeptId();
        task.setCreateDeptId(deptId);
        task.setCreateDeptName(deptService.selectDeptById(deptId).getDeptName());
        task.setCreateUserId(SecurityUtils.getUserId());
        task.setCreateUserName(SecurityUtils.getUsername());
        task.setCreateTime(DateUtils.getNowDate());
        bAnnualTargetTaskMapper.insertBAnnualTargetTask(task);

        Long taskId = task.getTaskId();
        List<BAnnualTargetTaskFile> fileList = bAnnualTargetTask.getFileList();
        if (fileList.size() > 0){
            fileList.forEach(f -> f.setTaskId(taskId));
            int i = taskFileMapper.insertListBAnnualTargetTaskFiles(fileList);
        }
        List<BAnnualTargetReceive> targetReceiveList = null;
        if (StringUtils.isNotEmpty(bAnnualTargetTask.getDeptIds())){
            //应完成任务数
            ZonedDateTime startTime = task.getStartTime().toInstant().atZone(ZoneId.systemDefault());
            ZonedDateTime endTime = task.getEndTime().toInstant().atZone(ZoneId.systemDefault());
            long time = 0;
            switch (task.getReportingCycle()){
                case "1":
                    time = startTime.until(endTime,ChronoUnit.DAYS);
                    break;
                case "2":
                    time = startTime.until(endTime, ChronoUnit.WEEKS);
                    break;
                case "3":
                    time = startTime.until(endTime,ChronoUnit.MONTHS);
                    break;
                case "4":
                    time = startTime.until(endTime,ChronoUnit.MONTHS)/3;
                    break;
                case "5":
                    time = startTime.until(endTime,ChronoUnit.YEARS);
                    break;
            }

            targetReceiveList = new ArrayList<>();
            for (Long s : bAnnualTargetTask.getDeptIds()) {
                BAnnualTargetReceive bAnnualTargetReceive = new BAnnualTargetReceive();
                bAnnualTargetReceive.setTaskId(Long.parseLong(String.valueOf(taskId)));
                bAnnualTargetReceive.setCreateDeptId(task.getCreateDeptId());
                bAnnualTargetReceive.setCreateDeptName(task.getCreateDeptName());
                bAnnualTargetReceive.setCreateUserId(task.getCreateUserId());
                bAnnualTargetReceive.setCreateUserName(task.getCreateUserName());
                bAnnualTargetReceive.setAnswerTaskNum(time);
                bAnnualTargetReceive.setReceiveDeptId(s);
                SysDept sysDept = deptService.selectDeptById(s);
                bAnnualTargetReceive.setReceiveDeptName(sysDept.getDeptName());
                bAnnualTargetReceive.setReceiveState("1");
                bAnnualTargetReceive.setReceiveTime(DateUtils.getNowDate());
                targetReceiveList.add(bAnnualTargetReceive);
            }
        }
        return ibAnnualTargetReceiveService.insertBatchTargetReceive(targetReceiveList);
    }

    @Override
    public List<TaskAndFile> selectBAnnualTargetTaskByDeptId(BAnnualTargetTask bAnnualTargetTask, Long deptId) {

        return bAnnualTargetTaskMapper.selectBAnnualTargetTaskListAndFileByDept(bAnnualTargetTask,deptId);
    }

}
