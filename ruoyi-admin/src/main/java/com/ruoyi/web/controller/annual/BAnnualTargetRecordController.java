package com.ruoyi.web.controller.annual;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.coordination.annual.domain.BAnnualTargetRecordFile;
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
import com.ruoyi.coordination.annual.domain.BAnnualTargetRecord;
import com.ruoyi.coordination.annual.service.IBAnnualTargetRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---年度任务目标--任务接收单位上报记录Controller
 *
 * @author yanakai@126.com
 * @date 2023-04-20
 */
@RestController
@RequestMapping("/annual/record")
public class BAnnualTargetRecordController extends BaseController
{
    @Autowired
    private IBAnnualTargetRecordService bAnnualTargetRecordService;

    /**
     * 查询协同平台---年度任务目标--任务接收单位上报记录列表
     */
    /*@PreAuthorize("@ss.hasPermi('annual:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(BAnnualTargetRecord bAnnualTargetRecord)
    {
        startPage();
        List<BAnnualTargetRecord> list = bAnnualTargetRecordService.selectBAnnualTargetRecordList(bAnnualTargetRecord);
        return getDataTable(list);
    }*/
    /**
     * 查询协同平台---年度任务目标--任务接收单位上报记录列表
     */
    @PreAuthorize("@ss.hasPermi('annual:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(BAnnualTargetRecord bAnnualTargetRecord)
    {
        startPage();
        List<BAnnualTargetRecord> list = bAnnualTargetRecordService.selectBAnnualTargetRecordList(bAnnualTargetRecord);
        return getDataTable(list);
    }


    /**
     * 导出协同平台---年度任务目标--任务接收单位上报记录列表
     */
    @PreAuthorize("@ss.hasPermi('annual:record:export')")
    @Log(title = "协同平台---年度任务目标--任务接收单位上报记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BAnnualTargetRecord bAnnualTargetRecord)
    {
        List<BAnnualTargetRecord> list = bAnnualTargetRecordService.selectBAnnualTargetRecordList(bAnnualTargetRecord);
        ExcelUtil<BAnnualTargetRecord> util = new ExcelUtil<BAnnualTargetRecord>(BAnnualTargetRecord.class);
        util.exportExcel(response, list, "协同平台---年度任务目标--任务接收单位上报记录数据");
    }

    /**
     * 获取协同平台---年度任务目标--任务接收单位上报记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('annual:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(bAnnualTargetRecordService.selectBAnnualTargetRecordByRecordId(recordId));
    }

    /**
     * 新增协同平台---年度任务目标--任务接收单位上报记录
     */
    /*@PreAuthorize("@ss.hasPermi('annual:record:add')")
    @Log(title = "协同平台---年度任务目标--任务接收单位上报记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BAnnualTargetRecord bAnnualTargetRecord)
    {
        return toAjax(bAnnualTargetRecordService.insertBAnnualTargetRecord(bAnnualTargetRecord));
    }*/

    //新增任务上报记录
    @PreAuthorize("@ss.hasPermi('annual:record:add')")
    @Log(title = "协同平台---年度任务目标--任务接收单位上报记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult addRecord(@RequestBody BAnnualTargetRecord bAnnualTargetRecord, @RequestBody BAnnualTargetRecordFile file)
    {
        return toAjax(bAnnualTargetRecordService.insertBAnnualTargetRecordAndFile(bAnnualTargetRecord,file));
    }

    /**
     * 修改协同平台---年度任务目标--任务接收单位上报记录
     */
    @PreAuthorize("@ss.hasPermi('annual:record:edit')")
    @Log(title = "协同平台---年度任务目标--任务接收单位上报记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BAnnualTargetRecord bAnnualTargetRecord)
    {
        return toAjax(bAnnualTargetRecordService.updateBAnnualTargetRecord(bAnnualTargetRecord));
    }

    /**
     * 删除协同平台---年度任务目标--任务接收单位上报记录
     */
    @PreAuthorize("@ss.hasPermi('annual:record:remove')")
    @Log(title = "协同平台---年度任务目标--任务接收单位上报记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(bAnnualTargetRecordService.deleteBAnnualTargetRecordByRecordIds(recordIds));
    }
}