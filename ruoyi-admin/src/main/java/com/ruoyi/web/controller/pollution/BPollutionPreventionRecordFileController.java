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
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionRecordFile;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionRecordFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---污染防治目标--上报记录关联的附件Controller
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@RestController
@RequestMapping("/pollution/recordFile")
public class BPollutionPreventionRecordFileController extends BaseController
{
    @Autowired
    private IBPollutionPreventionRecordFileService bPollutionPreventionRecordFileService;

    /**
     * 查询协同平台---污染防治目标--上报记录关联的附件列表
     */
    @PreAuthorize("@ss.hasPermi('pollution:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(BPollutionPreventionRecordFile bPollutionPreventionRecordFile)
    {
        startPage();
        List<BPollutionPreventionRecordFile> list = bPollutionPreventionRecordFileService.selectBPollutionPreventionRecordFileList(bPollutionPreventionRecordFile);
        return getDataTable(list);
    }

    /**
     * 导出协同平台---污染防治目标--上报记录关联的附件列表
     */
    @PreAuthorize("@ss.hasPermi('pollution:file:export')")
    @Log(title = "协同平台---污染防治目标--上报记录关联的附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BPollutionPreventionRecordFile bPollutionPreventionRecordFile)
    {
        List<BPollutionPreventionRecordFile> list = bPollutionPreventionRecordFileService.selectBPollutionPreventionRecordFileList(bPollutionPreventionRecordFile);
        ExcelUtil<BPollutionPreventionRecordFile> util = new ExcelUtil<BPollutionPreventionRecordFile>(BPollutionPreventionRecordFile.class);
        util.exportExcel(response, list, "协同平台---污染防治目标--上报记录关联的附件数据");
    }

    /**
     * 获取协同平台---污染防治目标--上报记录关联的附件详细信息
     */
    @PreAuthorize("@ss.hasPermi('pollution:file:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return success(bPollutionPreventionRecordFileService.selectBPollutionPreventionRecordFileByFileId(fileId));
    }

    /**
     * 新增协同平台---污染防治目标--上报记录关联的附件
     */
    @PreAuthorize("@ss.hasPermi('pollution:file:add')")
    @Log(title = "协同平台---污染防治目标--上报记录关联的附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BPollutionPreventionRecordFile bPollutionPreventionRecordFile)
    {
        return toAjax(bPollutionPreventionRecordFileService.insertBPollutionPreventionRecordFile(bPollutionPreventionRecordFile));
    }

    /**
     * 修改协同平台---污染防治目标--上报记录关联的附件
     */
    @PreAuthorize("@ss.hasPermi('pollution:file:edit')")
    @Log(title = "协同平台---污染防治目标--上报记录关联的附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BPollutionPreventionRecordFile bPollutionPreventionRecordFile)
    {
        return toAjax(bPollutionPreventionRecordFileService.updateBPollutionPreventionRecordFile(bPollutionPreventionRecordFile));
    }

    /**
     * 删除协同平台---污染防治目标--上报记录关联的附件
     */
    @PreAuthorize("@ss.hasPermi('pollution:file:remove')")
    @Log(title = "协同平台---污染防治目标--上报记录关联的附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(bPollutionPreventionRecordFileService.deleteBPollutionPreventionRecordFileByFileIds(fileIds));
    }
}
