package com.ruoyi.coordination.annual.service.impl;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.coordination.annual.domain.BAnnualTargetReceive;
import com.ruoyi.coordination.annual.domain.BAnnualTargetTaskFile;
import com.ruoyi.coordination.annual.mapper.BAnnualTargetTaskFileMapper;
import com.ruoyi.coordination.annual.service.IBAnnualTargetReceiveService;
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
    public int insertBAnnualTargetTaskAndRec(BAnnualTargetTask bAnnualTargetTask, String deptIds, BAnnualTargetTaskFile file) {
        int taskId = bAnnualTargetTaskMapper.insertBAnnualTargetTask(bAnnualTargetTask);
        file.setTaskId(Long.parseLong(String.valueOf(taskId)));
        int i = taskFileMapper.insertBAnnualTargetTaskFile(file);

        List<BAnnualTargetReceive> targetReceiveList = null;
        if (StringUtils.isNotEmpty(deptIds)){
            //应完成任务数
            ZonedDateTime startTime = bAnnualTargetTask.getStartTime().toInstant().atZone(ZoneId.systemDefault());
            ZonedDateTime endTime = bAnnualTargetTask.getEndTime().toInstant().atZone(ZoneId.systemDefault());
            long time = 0;
            switch (bAnnualTargetTask.getReportingCycle()){
                case "日":
                    time = startTime.until(endTime,ChronoUnit.DAYS);
                    break;
                case "周":
                    time = startTime.until(endTime, ChronoUnit.WEEKS);
                    break;
                case "月":
                    time = startTime.until(endTime,ChronoUnit.MONTHS);
                    break;
//                case "季度":
//                    time = startTime.until(endTime,ChronoUnit.WEEKS);
//                    break;
                case "年":
                    time = startTime.until(endTime,ChronoUnit.YEARS);
                    break;
            }

            String[] split = deptIds.split(",");

            targetReceiveList = new ArrayList<>();
            for (String s : split) {
                BAnnualTargetReceive bAnnualTargetReceive = new BAnnualTargetReceive();
                bAnnualTargetReceive.setTaskId(Long.parseLong(String.valueOf(taskId)));
                bAnnualTargetReceive.setCreateDeptId(bAnnualTargetTask.getCreateDeptId());
                bAnnualTargetReceive.setCreateDeptName(bAnnualTargetTask.getCreateDeptName());
                bAnnualTargetReceive.setCreateUserId(bAnnualTargetTask.getCreateUserId());
                bAnnualTargetReceive.setCreateUserName(bAnnualTargetTask.getCreateUserName());
                bAnnualTargetReceive.setAnswerTaskNum(time);
                bAnnualTargetReceive.setReceiveDeptId(Long.parseLong(s));
                //TODO 查询接收单位相关信息并对属性赋值
                bAnnualTargetReceive.setReceiveState("1");
                bAnnualTargetReceive.setReceiveTime(DateUtils.getNowDate());
                targetReceiveList.add(bAnnualTargetReceive);
            }
        }
        return ibAnnualTargetReceiveService.insertBatchTargetReceive(targetReceiveList);
    }

}
