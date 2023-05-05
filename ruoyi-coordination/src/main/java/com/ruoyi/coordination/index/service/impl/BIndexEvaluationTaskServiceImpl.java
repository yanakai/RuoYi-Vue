package com.ruoyi.coordination.index.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.coordination.index.domain.BIndexEvaluationReceive;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTaskFile;
import com.ruoyi.coordination.index.domain.dto.EvaTaskAndFile;
import com.ruoyi.coordination.index.domain.dto.EvaTaskAndReceive;
import com.ruoyi.coordination.index.mapper.BIndexEvaluationReceiveMapper;
import com.ruoyi.coordination.index.mapper.BIndexEvaluationTaskFileMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.service.impl.SysDeptServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.index.mapper.BIndexEvaluationTaskMapper;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTask;
import com.ruoyi.coordination.index.service.IBIndexEvaluationTaskService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台--指标管理--指标主任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@Service
public class BIndexEvaluationTaskServiceImpl implements IBIndexEvaluationTaskService 
{
    @Autowired
    private BIndexEvaluationTaskMapper bIndexEvaluationTaskMapper;
    @Autowired
    private BIndexEvaluationTaskFileMapper taskFileMapper;
    @Autowired
    private BIndexEvaluationReceiveMapper receiveMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询协同平台--指标管理--指标主任务
     * 
     * @param taskId 协同平台--指标管理--指标主任务主键
     * @return 协同平台--指标管理--指标主任务
     */
    @Override
    public BIndexEvaluationTask selectBIndexEvaluationTaskByTaskId(Long taskId)
    {
        return bIndexEvaluationTaskMapper.selectBIndexEvaluationTaskByTaskId(taskId);
    }

    /**
     * 查询协同平台--指标管理--指标主任务列表
     * 
     * @param bIndexEvaluationTask 协同平台--指标管理--指标主任务
     * @return 协同平台--指标管理--指标主任务
     */
    @Override
    public List<BIndexEvaluationTask> selectBIndexEvaluationTaskList(BIndexEvaluationTask bIndexEvaluationTask)
    {
        return bIndexEvaluationTaskMapper.selectBIndexEvaluationTaskList(bIndexEvaluationTask);
    }

    /**
     * 新增协同平台--指标管理--指标主任务
     * 
     * @param bIndexEvaluationTask 协同平台--指标管理--指标主任务
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBIndexEvaluationTask(EvaTaskAndFile bIndexEvaluationTask)
    {
        bIndexEvaluationTask.setCreateTime(DateUtils.getNowDate());
        //创建任务，赋值属性
        BIndexEvaluationTask task = new BIndexEvaluationTask();
        //添加任务创建人相关信息
        task.setCreateUserId(SecurityUtils.getUserId());
        task.setCreateUserName(SecurityUtils.getUsername());
        task.setCreateDeptId(SecurityUtils.getDeptId());
        task.setCreateDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        BeanUtils.copyProperties(bIndexEvaluationTask,task);
        //任务添加
        int num = bIndexEvaluationTaskMapper.insertBIndexEvaluationTask(task);
        //获取任务附件集合
        List<BIndexEvaluationTaskFile> fileList = bIndexEvaluationTask.getFileList();
        if (!fileList.isEmpty()){
            fileList.forEach(f -> f.setTaskId(task.getTaskId()));
            //批量添加附件
            taskFileMapper.insertBatchBIndexEvaluationTaskFile(fileList);
        }
        //下级单位接收任务
        //获取接收单位的id数组
        Long[] deptIds = bIndexEvaluationTask.getDeptIds();
        List<BIndexEvaluationReceive> evaluationReceives = new ArrayList<>();
        if (deptIds.length > 0 && deptIds != null){
            //查询接收单位相关信息
            List<SysDept> deptList = sysDeptMapper.getDeptList(deptIds);
            for (SysDept sysDept : deptList) {
                //创建任务接收表数据
                BIndexEvaluationReceive evaluationReceive = new BIndexEvaluationReceive();
                evaluationReceive.setTaskId(task.getTaskId());
                evaluationReceive.setReceiveDeptId(sysDept.getDeptId());
                evaluationReceive.setReceiveDeptName(sysDept.getDeptName());
                evaluationReceive.setReceiveTime(DateUtils.getNowDate());
                evaluationReceives.add(evaluationReceive);
            }
            //批量新增任务接收
            receiveMapper.insertBatchBIndexEvaluationReceive(evaluationReceives);
        }
        return num;
    }

    /**
     * 修改协同平台--指标管理--指标主任务
     * 
     * @param bIndexEvaluationTask 协同平台--指标管理--指标主任务
     * @return 结果
     */
    @Override
    public int updateBIndexEvaluationTask(BIndexEvaluationTask bIndexEvaluationTask)
    {
        return bIndexEvaluationTaskMapper.updateBIndexEvaluationTask(bIndexEvaluationTask);
    }

    /**
     * 批量删除协同平台--指标管理--指标主任务
     * 
     * @param taskIds 需要删除的协同平台--指标管理--指标主任务主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationTaskByTaskIds(Long[] taskIds)
    {
        return bIndexEvaluationTaskMapper.deleteBIndexEvaluationTaskByTaskIds(taskIds);
    }

    /**
     * 删除协同平台--指标管理--指标主任务信息
     * 
     * @param taskId 协同平台--指标管理--指标主任务主键
     * @return 结果
     */
    @Override
    public int deleteBIndexEvaluationTaskByTaskId(Long taskId)
    {
        return bIndexEvaluationTaskMapper.deleteBIndexEvaluationTaskByTaskId(taskId);
    }

    @Override
    public List<EvaTaskAndReceive> selectBIndexEvaluationTaskListByDeptId(EvaTaskAndReceive bIndexEvaluationTask) {

        return bIndexEvaluationTaskMapper.selectBIndexEvaluationTaskListByDeptId(bIndexEvaluationTask);
    }
}
