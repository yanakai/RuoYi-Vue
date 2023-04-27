package com.ruoyi.web.controller.index;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.coordination.index.domain.dto.EvaTaskAndFile;
import com.ruoyi.coordination.index.domain.dto.EvaTaskAndReceive;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.coordination.index.domain.BIndexEvaluationTask;
import com.ruoyi.coordination.index.service.IBIndexEvaluationTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--指标管理--指标主任务Controller
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@RestController
@RequestMapping("/index/task")
public class BIndexEvaluationTaskController extends BaseController
{
    @Autowired
    private IBIndexEvaluationTaskService bIndexEvaluationTaskService;

    /**
     * 查询协同平台--指标管理--指标主任务列表
     */
    //@PreAuthorize("@ss.hasPermi('index:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(BIndexEvaluationTask bIndexEvaluationTask)
    {
        startPage();
        List<BIndexEvaluationTask> list = bIndexEvaluationTaskService.selectBIndexEvaluationTaskList(bIndexEvaluationTask);
        return getDataTable(list);
    }

    /**
     * 查询协同平台--指标管理--指标单位接收任务列表
     */
    //@PreAuthorize("@ss.hasPermi('index:task:list')")
    @GetMapping("/listByDeptId")
    public TableDataInfo listByDeptId(EvaTaskAndReceive bIndexEvaluationTask)
    {
        startPage();
        bIndexEvaluationTask.setReceiveDeptId(SecurityUtils.getDeptId());
        List<EvaTaskAndReceive> list = bIndexEvaluationTaskService.selectBIndexEvaluationTaskListByDeptId(bIndexEvaluationTask);
        return getDataTable(list);
    }


    /**
     * 导出协同平台--指标管理--指标主任务列表
     */
    //@PreAuthorize("@ss.hasPermi('index:task:export')")
    @Log(title = "协同平台--指标管理--指标主任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BIndexEvaluationTask bIndexEvaluationTask)
    {
        List<BIndexEvaluationTask> list = bIndexEvaluationTaskService.selectBIndexEvaluationTaskList(bIndexEvaluationTask);
        ExcelUtil<BIndexEvaluationTask> util = new ExcelUtil<BIndexEvaluationTask>(BIndexEvaluationTask.class);
        util.exportExcel(response, list, "协同平台--指标管理--指标主任务数据");
    }

    /**
     * 获取协同平台--指标管理--指标主任务详细信息
     */
    //@PreAuthorize("@ss.hasPermi('index:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(bIndexEvaluationTaskService.selectBIndexEvaluationTaskByTaskId(taskId));
    }

    /**
     * 新增协同平台--指标管理--指标主任务
     */
    //@PreAuthorize("@ss.hasPermi('index:task:add')")
    @Log(title = "协同平台--指标管理--指标主任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EvaTaskAndFile bIndexEvaluationTask)
    {
        return toAjax(bIndexEvaluationTaskService.insertBIndexEvaluationTask(bIndexEvaluationTask));
    }

    /**
     * 修改协同平台--指标管理--指标主任务
     */
    //@PreAuthorize("@ss.hasPermi('index:task:edit')")
    @Log(title = "协同平台--指标管理--指标主任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BIndexEvaluationTask bIndexEvaluationTask)
    {
        return toAjax(bIndexEvaluationTaskService.updateBIndexEvaluationTask(bIndexEvaluationTask));
    }

    /**
     * 删除协同平台--指标管理--指标主任务
     */
    //@PreAuthorize("@ss.hasPermi('index:task:remove')")
    @Log(title = "协同平台--指标管理--指标主任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(bIndexEvaluationTaskService.deleteBIndexEvaluationTaskByTaskIds(taskIds));
    }
}
