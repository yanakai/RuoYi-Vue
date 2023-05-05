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
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecord;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---污染防治目标--任务接收单位上报记录Controller
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@RestController
@RequestMapping("/pollution/record")
public class BPollutionPreventionRecordController extends BaseController
{
    @Autowired
    private IBPollutionPreventionRecordService bPollutionPreventionRecordService;

    /**
     * 查询协同平台---污染防治目标--任务接收单位上报记录列表
     */
    @PreAuthorize("@ss.hasPermi('pollution:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(BPollutionPreventionRecord bPollutionPreventionRecord)
    {
        startPage();
        List<BPollutionPreventionRecord> list = bPollutionPreventionRecordService.selectBPollutionPreventionRecordList(bPollutionPreventionRecord);
        return getDataTable(list);
    }

    /**
     * 导出协同平台---污染防治目标--任务接收单位上报记录列表
     */
    @PreAuthorize("@ss.hasPermi('pollution:record:export')")
    @Log(title = "协同平台---污染防治目标--任务接收单位上报记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BPollutionPreventionRecord bPollutionPreventionRecord)
    {
        List<BPollutionPreventionRecord> list = bPollutionPreventionRecordService.selectBPollutionPreventionRecordList(bPollutionPreventionRecord);
        ExcelUtil<BPollutionPreventionRecord> util = new ExcelUtil<BPollutionPreventionRecord>(BPollutionPreventionRecord.class);
        util.exportExcel(response, list, "协同平台---污染防治目标--任务接收单位上报记录数据");
    }

    /**
     * 获取协同平台---污染防治目标--任务接收单位上报记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('pollution:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(bPollutionPreventionRecordService.selectBPollutionPreventionRecordByRecordId(recordId));
    }

    /**
     * 新增协同平台---污染防治目标--任务接收单位上报记录
     */
    @PreAuthorize("@ss.hasPermi('pollution:record:add')")
    @Log(title = "协同平台---污染防治目标--任务接收单位上报记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BPollutionPreventionRecord bPollutionPreventionRecord)
    {
        return toAjax(bPollutionPreventionRecordService.insertBPollutionPreventionRecord(bPollutionPreventionRecord));
    }

    /**
     * 修改协同平台---污染防治目标--任务接收单位上报记录
     */
    @PreAuthorize("@ss.hasPermi('pollution:record:edit')")
    @Log(title = "协同平台---污染防治目标--任务接收单位上报记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BPollutionPreventionRecord bPollutionPreventionRecord)
    {
        return toAjax(bPollutionPreventionRecordService.updateBPollutionPreventionRecord(bPollutionPreventionRecord));
    }

    /**
     * 删除协同平台---污染防治目标--任务接收单位上报记录
     */
    @PreAuthorize("@ss.hasPermi('pollution:record:remove')")
    @Log(title = "协同平台---污染防治目标--任务接收单位上报记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(bPollutionPreventionRecordService.deleteBPollutionPreventionRecordByRecordIds(recordIds));
    }
}
