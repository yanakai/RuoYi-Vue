package com.ruoyi.web.controller.clue;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.coordination.clue.domain.dto.BCITaskAndFile;
import com.ruoyi.coordination.clue.domain.dto.BCITaskAndReceive;
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
import com.ruoyi.coordination.clue.domain.BClueInfoTask;
import com.ruoyi.coordination.clue.service.IBClueInfoTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--污染线索处置----线索主任务Controller
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/clue/task")
public class BClueInfoTaskController extends BaseController
{
    @Autowired
    private IBClueInfoTaskService bClueInfoTaskService;

    /**
     * 查询协同平台--污染线索处置----线索主任务列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(BClueInfoTask bClueInfoTask)
    {
        startPage();
        List<BClueInfoTask> list = bClueInfoTaskService.selectBClueInfoTaskList(bClueInfoTask);
        return getDataTable(list);
    }

    /**
     * 查询协同平台--污染线索处置----催办任务列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:list')")
    @GetMapping("/urgingList")
    public TableDataInfo urgingList(BClueInfoTask bClueInfoTask)
    {
        startPage();
        List<BCITaskAndReceive> list = bClueInfoTaskService.selectBClueInfoUrgingTaskList(bClueInfoTask);
        return getDataTable(list);
    }

    /**
     * 查询协同平台--污染线索处置----待办任务列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:list')")
    @GetMapping("/toDoList")
    public TableDataInfo toDoList(BCITaskAndReceive bClueInfoTask)
    {
        startPage();
        List<BCITaskAndReceive> list = bClueInfoTaskService.selectBClueInfoTaskToDoList(bClueInfoTask);
        return getDataTable(list);
    }

    /**
     * 导出协同平台--污染线索处置----线索主任务列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:export')")
    @Log(title = "协同平台--污染线索处置----线索主任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoTask bClueInfoTask)
    {
        List<BClueInfoTask> list = bClueInfoTaskService.selectBClueInfoTaskList(bClueInfoTask);
        ExcelUtil<BClueInfoTask> util = new ExcelUtil<BClueInfoTask>(BClueInfoTask.class);
        util.exportExcel(response, list, "协同平台--污染线索处置----线索主任务数据");
    }

    /**
     * 获取协同平台--污染线索处置----线索主任务详细信息
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(bClueInfoTaskService.selectBClueInfoTaskByTaskId(taskId));
    }

    /**
     * 新增协同平台--污染线索处置----线索主任务
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:add')")
    @Log(title = "协同平台--污染线索处置----线索主任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BClueInfoTask bClueInfoTask)
    {
        return toAjax(bClueInfoTaskService.insertBClueInfoTask(bClueInfoTask));
    }

    /**
     * 修改协同平台--污染线索处置----线索主任务
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:edit')")
    @Log(title = "协同平台--污染线索处置----线索主任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BCITaskAndFile bClueInfoTask)
    {
        return toAjax(bClueInfoTaskService.updateBClueInfoTask(bClueInfoTask));
    }

    /**
     * 删除协同平台--污染线索处置----线索主任务
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:remove')")
    @Log(title = "协同平台--污染线索处置----线索主任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(bClueInfoTaskService.deleteBClueInfoTaskByTaskIds(taskIds));
    }
    /**
     * 查询协同平台--污染线索处置----来源分析
     */
    //@PreAuthorize("@ss.hasPermi('clue:task:list')")
    @GetMapping("/sourceAnalysis")
    public AjaxResult sourceAnalysis(BCITaskAndReceive bClueInfoTask)
    {
        List<Map<String,Object>> list = bClueInfoTaskService.getSourceAnalysis(bClueInfoTask);
        return success(list);
    }
}
