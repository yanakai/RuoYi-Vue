package com.ruoyi.coordination.clue.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.coordination.clue.domain.BClueInfoTaskFile;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndFile;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndReceive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoTaskMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoTask;
import com.ruoyi.coordination.clue.service.IBClueInfoTaskService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 协同平台--污染线索处置----线索主任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@Service
public class BClueInfoTaskServiceImpl implements IBClueInfoTaskService
{
    @Autowired
    private BClueInfoTaskMapper bClueInfoTaskMapper;
    @Autowired
    private BClueInfoReceiveServiceImpl receiveService;
    @Autowired
    private BClueInfoTaskFileServiceImpl taskFileService;

    /**
     * 查询协同平台--污染线索处置----线索主任务
     * 
     * @param taskId 协同平台--污染线索处置----线索主任务主键
     * @return 协同平台--污染线索处置----线索主任务
     */
    @Override
    public BClueInfoTask selectBClueInfoTaskByTaskId(Long taskId)
    {
        return bClueInfoTaskMapper.selectBClueInfoTaskByTaskId(taskId);
    }

    /**
     * 查询协同平台--污染线索处置----线索主任务列表
     * 
     * @param bClueInfoTask 协同平台--污染线索处置----线索主任务
     * @return 协同平台--污染线索处置----线索主任务
     */
    @Override
    public List<BClueInfoTask> selectBClueInfoTaskList(BClueInfoTask bClueInfoTask)
    {
        return bClueInfoTaskMapper.selectBClueInfoTaskList(bClueInfoTask);
    }

    /**
     * 新增协同平台--污染线索处置----线索主任务
     * 
     * @param bClueInfoTask 协同平台--污染线索处置----线索主任务
     * @return 结果
     */
    @Override
    public int insertBClueInfoTask(BClueInfoTask bClueInfoTask)
    {
        bClueInfoTask.setCreateTime(DateUtils.getNowDate());
        return bClueInfoTaskMapper.insertBClueInfoTask(bClueInfoTask);
    }

    /**
     * 修改协同平台--污染线索处置----线索主任务
     * 
     * @param bClueInfoTask 协同平台--污染线索处置----线索主任务
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBClueInfoTask(BCITaskAndFile bClueInfoTask)
    {
        List<BClueInfoTaskFile> fileList = bClueInfoTask.getFileList();
        int i = 0;
        //附件批量添加
        if (fileList != null&&fileList.size() > 0){
            fileList.forEach(f -> f.setTaskId(bClueInfoTask.getTaskId()));
            i = taskFileService.insertTaskFileList(fileList);
        }
        //接收表批量添加
        Long[] deptIds = bClueInfoTask.getDeptIds();
        if (deptIds != null && deptIds.length > 0){
            i = receiveService.insertReceiveList(deptIds, bClueInfoTask);
        }
        return i;
    }

    /**
     * 批量删除协同平台--污染线索处置----线索主任务
     * 
     * @param taskIds 需要删除的协同平台--污染线索处置----线索主任务主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoTaskByTaskIds(Long[] taskIds)
    {
        return bClueInfoTaskMapper.deleteBClueInfoTaskByTaskIds(taskIds);
    }

    /**
     * 删除协同平台--污染线索处置----线索主任务信息
     * 
     * @param taskId 协同平台--污染线索处置----线索主任务主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoTaskByTaskId(Long taskId)
    {
        return bClueInfoTaskMapper.deleteBClueInfoTaskByTaskId(taskId);
    }

    @Override
    public List<BCITaskAndReceive> selectBClueInfoTaskToDoList(BCITaskAndReceive bClueInfoTask) {
        bClueInfoTask.setReceiveDeptId(SecurityUtils.getDeptId());
        return bClueInfoTaskMapper.selectBClueInfoTaskToDoList(bClueInfoTask);
    }

    @Override
    public List<BCITaskAndReceive> selectBClueInfoUrgingTaskList(BClueInfoTask bClueInfoTask) {
        bClueInfoTask.setCreateDeptId(SecurityUtils.getDeptId());
        return bClueInfoTaskMapper.selectBClueInfoUrgingTaskList(bClueInfoTask);
    }

    @Override
    public List<Map<String, Object>> getSourceAnalysis(BCITaskAndReceive bClueInfoTask) {

        return bClueInfoTaskMapper.getSourceAnalysis(bClueInfoTask);
    }
}
