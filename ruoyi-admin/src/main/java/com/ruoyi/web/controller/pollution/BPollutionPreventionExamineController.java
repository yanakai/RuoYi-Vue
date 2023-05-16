package com.ruoyi.web.controller.pollution;

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
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionExamine;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionExamineService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---污染防治目标--任务审核记录Controller
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@RestController
@RequestMapping("/pollution/examine")
public class BPollutionPreventionExamineController extends BaseController
{
    @Autowired
    private IBPollutionPreventionExamineService bPollutionPreventionExamineService;

    /**
     * 查询协同平台---污染防治目标--任务审核记录列表
     */
    // @PreAuthorize("@ss.hasPermi('pollution:examine:list')")
    @GetMapping("/list")
    public TableDataInfo list(BPollutionPreventionExamine bPollutionPreventionExamine)
    {
        startPage();
        List<BPollutionPreventionExamine> list = bPollutionPreventionExamineService.selectBPollutionPreventionExamineList(bPollutionPreventionExamine);
        return getDataTable(list);
    }

    /**
     * 导出协同平台---污染防治目标--任务审核记录列表
     */
    // @PreAuthorize("@ss.hasPermi('pollution:examine:export')")
    @Log(title = "协同平台---污染防治目标--任务审核记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BPollutionPreventionExamine bPollutionPreventionExamine)
    {
        List<BPollutionPreventionExamine> list = bPollutionPreventionExamineService.selectBPollutionPreventionExamineList(bPollutionPreventionExamine);
        ExcelUtil<BPollutionPreventionExamine> util = new ExcelUtil<BPollutionPreventionExamine>(BPollutionPreventionExamine.class);
        util.exportExcel(response, list, "协同平台---污染防治目标--任务审核记录数据");
    }

    /**
     * 获取协同平台---污染防治目标--任务审核记录详细信息
     */
    // @PreAuthorize("@ss.hasPermi('pollution:examine:query')")
    @GetMapping(value = "/{exId}")
    public AjaxResult getInfo(@PathVariable("exId") Long exId)
    {
        return success(bPollutionPreventionExamineService.selectBPollutionPreventionExamineByExId(exId));
    }

    /**
     * 新增协同平台---污染防治目标--任务审核记录
     */
    // @PreAuthorize("@ss.hasPermi('pollution:examine:add')")
    @Log(title = "协同平台---污染防治目标--任务审核记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BPollutionPreventionExamine bPollutionPreventionExamine)
    {
        return toAjax(bPollutionPreventionExamineService.insertBPollutionPreventionExamine(bPollutionPreventionExamine));
    }

    /**
     * 修改协同平台---污染防治目标--任务审核记录
     */
    // @PreAuthorize("@ss.hasPermi('pollution:examine:edit')")
    @Log(title = "协同平台---污染防治目标--任务审核记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BPollutionPreventionExamine bPollutionPreventionExamine)
    {
        return toAjax(bPollutionPreventionExamineService.updateBPollutionPreventionExamine(bPollutionPreventionExamine));
    }

    /**
     * 删除协同平台---污染防治目标--任务审核记录
     */
    // @PreAuthorize("@ss.hasPermi('pollution:examine:remove')")
    @Log(title = "协同平台---污染防治目标--任务审核记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{exIds}")
    public AjaxResult remove(@PathVariable Long[] exIds)
    {
        return toAjax(bPollutionPreventionExamineService.deleteBPollutionPreventionExamineByExIds(exIds));
    }
}
