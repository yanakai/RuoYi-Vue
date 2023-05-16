package com.ruoyi.web.controller.clue;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.coordination.clue.domain.BClueInfoTask;
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
import com.ruoyi.coordination.clue.domain.BClueInfoExamine;
import com.ruoyi.coordination.clue.service.IBClueInfoExamineService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---污染防治目标--任务审核记录Controller
 * 
 * @author ruoyi
 * @date 2023-05-12
 */
@RestController
@RequestMapping("/clue/examine")
public class BClueInfoExamineController extends BaseController
{
    @Autowired
    private IBClueInfoExamineService bClueInfoExamineService;

    /**
     * 查询协同平台---污染防治目标--任务审核记录列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:examine:list')")
    @GetMapping("/list")
    public TableDataInfo list(BClueInfoExamine bClueInfoExamine)
    {
        startPage();
        List<BClueInfoExamine> list = bClueInfoExamineService.selectBClueInfoExamineList(bClueInfoExamine);
        return getDataTable(list);
    }

    /**
     * 查询协同平台---污染防治目标--任务审核记录待办列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:examine:list')")
    @GetMapping("/toDoList")
    public TableDataInfo toDoList(BCITaskAndReceive bClueInfoExamine)
    {
        startPage();
        List<BCITaskAndReceive> list = bClueInfoExamineService.selectBClueInfoExamineToDoList(bClueInfoExamine);
        return getDataTable(list);
    }

    /**
     * 导出协同平台---污染防治目标--任务审核记录列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:examine:export')")
    @Log(title = "协同平台---污染防治目标--任务审核记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoExamine bClueInfoExamine)
    {
        List<BClueInfoExamine> list = bClueInfoExamineService.selectBClueInfoExamineList(bClueInfoExamine);
        ExcelUtil<BClueInfoExamine> util = new ExcelUtil<BClueInfoExamine>(BClueInfoExamine.class);
        util.exportExcel(response, list, "协同平台---污染防治目标--任务审核记录数据");
    }

    /**
     * 获取协同平台---污染防治目标--任务审核记录详细信息
     */
    //@PreAuthorize("@ss.hasPermi('clue:examine:query')")
    @GetMapping(value = "/{exId}")
    public AjaxResult getInfo(@PathVariable("exId") Long exId)
    {
        return success(bClueInfoExamineService.selectBClueInfoExamineByExId(exId));
    }

    /**
     * 新增协同平台---污染防治目标--任务审核记录
     */
    //@PreAuthorize("@ss.hasPermi('clue:examine:add')")
    @Log(title = "协同平台---污染防治目标--任务审核记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BClueInfoExamine bClueInfoExamine)
    {
        return toAjax(bClueInfoExamineService.insertBClueInfoExamine(bClueInfoExamine));
    }

    /**
     * 修改协同平台---污染防治目标--任务审核记录
     */
    //@PreAuthorize("@ss.hasPermi('clue:examine:edit')")
    @Log(title = "协同平台---污染防治目标--任务审核记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BClueInfoExamine bClueInfoExamine)
    {
        return toAjax(bClueInfoExamineService.updateBClueInfoExamine(bClueInfoExamine));
    }

    /**
     * 删除协同平台---污染防治目标--任务审核记录
     */
    //@PreAuthorize("@ss.hasPermi('clue:examine:remove')")
    @Log(title = "协同平台---污染防治目标--任务审核记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{exIds}")
    public AjaxResult remove(@PathVariable Long[] exIds)
    {
        return toAjax(bClueInfoExamineService.deleteBClueInfoExamineByExIds(exIds));
    }
}
