package com.ruoyi.web.controller.annual;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.coordination.annual.domain.BAnnualTargetTask;
import com.ruoyi.coordination.annual.service.IBAnnualTargetTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;


/**
 * @BelongsProject: RuoYi-Vue
 * @BelongsPackage: com.ruoyi.web.controller.annual
 * @Author: yanakai@126.com
 * @CreateTime: 2023-04-20  15:16
 * @Description: 协同平台--年度目标任务--任务主Controller
 * @Version: 1.0
 */
public class BAnnualTargetTaskController extends BaseController {
    @Autowired
    private IBAnnualTargetTaskService bAnnualTargetTaskService;

    /**
     * 查询协同平台--年度目标任务--任务主列表
     */
    @PreAuthorize("@ss.hasPermi('annual:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(BAnnualTargetTask bAnnualTargetTask)
    {
        startPage();
        List<BAnnualTargetTask> list = bAnnualTargetTaskService.selectBAnnualTargetTaskList(bAnnualTargetTask);
        return getDataTable(list);
    }

    /**
     * 导出协同平台--年度目标任务--任务主列表
     */
    @PreAuthorize("@ss.hasPermi('annual:task:export')")
    @Log(title = "协同平台--年度目标任务--任务主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BAnnualTargetTask bAnnualTargetTask)
    {
        List<BAnnualTargetTask> list = bAnnualTargetTaskService.selectBAnnualTargetTaskList(bAnnualTargetTask);
        ExcelUtil<BAnnualTargetTask> util = new ExcelUtil<BAnnualTargetTask>(BAnnualTargetTask.class);
        util.exportExcel(response, list, "协同平台--年度目标任务--任务主数据");
    }

    /**
     * 获取协同平台--年度目标任务--任务主详细信息
     */
    @PreAuthorize("@ss.hasPermi('annual:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(bAnnualTargetTaskService.selectBAnnualTargetTaskByTaskId(taskId));
    }

    /**
     * 新增协同平台--年度目标任务--任务主
     */
    @PreAuthorize("@ss.hasPermi('annual:task:add')")
    @Log(title = "协同平台--年度目标任务--任务主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BAnnualTargetTask bAnnualTargetTask)
    {
        return toAjax(bAnnualTargetTaskService.insertBAnnualTargetTask(bAnnualTargetTask));
    }

    /**
     * 修改协同平台--年度目标任务--任务主
     */
    @PreAuthorize("@ss.hasPermi('annual:task:edit')")
    @Log(title = "协同平台--年度目标任务--任务主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BAnnualTargetTask bAnnualTargetTask)
    {
        return toAjax(bAnnualTargetTaskService.updateBAnnualTargetTask(bAnnualTargetTask));
    }

    /**
     * 删除协同平台--年度目标任务--任务主
     */
    @PreAuthorize("@ss.hasPermi('annual:task:remove')")
    @Log(title = "协同平台--年度目标任务--任务主", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(bAnnualTargetTaskService.deleteBAnnualTargetTaskByTaskIds(taskIds));
    }
}
