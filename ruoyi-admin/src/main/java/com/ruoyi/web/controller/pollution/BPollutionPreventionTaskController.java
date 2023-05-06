package com.ruoyi.web.controller.pollution;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.coordination.pollution.domain.dto.BPPTaskAndFile;
import com.ruoyi.coordination.pollution.domain.dto.BPPTaskAndReceive;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionTask;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--污染防治目标--主任务Controller
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@RestController
@RequestMapping("/pollution/task")
public class BPollutionPreventionTaskController extends BaseController
{
    @Autowired
    private IBPollutionPreventionTaskService bPollutionPreventionTaskService;

    /**
     * 查询协同平台--污染防治目标--主任务列表
     */
    // @PreAuthorize("@ss.hasPermi('pollution:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(BPollutionPreventionTask bPollutionPreventionTask)
    {
        startPage();
        List<BPollutionPreventionTask> list = bPollutionPreventionTaskService.selectBPollutionPreventionTaskList(bPollutionPreventionTask);
        return getDataTable(list);
    }

    /**
     * 查询协同平台--污染防治目标--任务待办列表
     */
    // @PreAuthorize("@ss.hasPermi('pollution:task:list')")
    @GetMapping("/daiBanList")
    public TableDataInfo daiBanList(BPPTaskAndReceive bPollutionPreventionTask)
    {
        startPage();
        List<BPPTaskAndReceive> list = bPollutionPreventionTaskService.selectBPollutionPreventionTaskListByDeptId(bPollutionPreventionTask);
        return getDataTable(list);
    }

    /**
     * 导出协同平台--污染防治目标--主任务列表
     */
    // @PreAuthorize("@ss.hasPermi('pollution:task:export')")
    @Log(title = "协同平台--污染防治目标--主任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BPollutionPreventionTask bPollutionPreventionTask)
    {
        List<BPollutionPreventionTask> list = bPollutionPreventionTaskService.selectBPollutionPreventionTaskList(bPollutionPreventionTask);
        ExcelUtil<BPollutionPreventionTask> util = new ExcelUtil<BPollutionPreventionTask>(BPollutionPreventionTask.class);
        util.exportExcel(response, list, "协同平台--污染防治目标--主任务数据");
    }

    /**
     * 获取协同平台--污染防治目标--主任务详细信息
     */
    // @PreAuthorize("@ss.hasPermi('pollution:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(bPollutionPreventionTaskService.selectBPollutionPreventionTaskByTaskId(taskId));
    }

    /**
     * 新增协同平台--污染防治目标--主任务
     */
    // @PreAuthorize("@ss.hasPermi('pollution:task:add')")
    @Log(title = "协同平台--污染防治目标--主任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BPPTaskAndFile bppTaskAndFile)
    {
        return toAjax(bPollutionPreventionTaskService.insertBPollutionPreventionTask(bppTaskAndFile));
    }

    /**
     * 修改协同平台--污染防治目标--主任务
     */
    // @PreAuthorize("@ss.hasPermi('pollution:task:edit')")
    @Log(title = "协同平台--污染防治目标--主任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BPollutionPreventionTask bPollutionPreventionTask)
    {
        return toAjax(bPollutionPreventionTaskService.updateBPollutionPreventionTask(bPollutionPreventionTask));
    }

    /**
     * 删除协同平台--污染防治目标--主任务
     */
    // @PreAuthorize("@ss.hasPermi('pollution:task:remove')")
    @Log(title = "协同平台--污染防治目标--主任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(bPollutionPreventionTaskService.deleteBPollutionPreventionTaskByTaskIds(taskIds));
    }
}
