package com.ruoyi.web.controller.index;

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
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecordFile;
import com.ruoyi.coordination.index.service.IBIndexEvaluationRecordFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---指标管理--上报记录关联的附件Controller
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@RestController
@RequestMapping("/index/recordFile")
public class BIndexEvaluationRecordFileController extends BaseController
{
    @Autowired
    private IBIndexEvaluationRecordFileService bIndexEvaluationRecordFileService;

    /**
     * 查询协同平台---指标管理--上报记录关联的附件列表
     */
    //@PreAuthorize("@ss.hasPermi('index:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(BIndexEvaluationRecordFile bIndexEvaluationRecordFile)
    {
        startPage();
        List<BIndexEvaluationRecordFile> list = bIndexEvaluationRecordFileService.selectBIndexEvaluationRecordFileList(bIndexEvaluationRecordFile);
        return getDataTable(list);
    }

    /**
     * 导出协同平台---指标管理--上报记录关联的附件列表
     */
    //@PreAuthorize("@ss.hasPermi('index:file:export')")
    @Log(title = "协同平台---指标管理--上报记录关联的附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BIndexEvaluationRecordFile bIndexEvaluationRecordFile)
    {
        List<BIndexEvaluationRecordFile> list = bIndexEvaluationRecordFileService.selectBIndexEvaluationRecordFileList(bIndexEvaluationRecordFile);
        ExcelUtil<BIndexEvaluationRecordFile> util = new ExcelUtil<BIndexEvaluationRecordFile>(BIndexEvaluationRecordFile.class);
        util.exportExcel(response, list, "协同平台---指标管理--上报记录关联的附件数据");
    }

    /**
     * 获取协同平台---指标管理--上报记录关联的附件详细信息
     */
    //@PreAuthorize("@ss.hasPermi('index:file:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return success(bIndexEvaluationRecordFileService.selectBIndexEvaluationRecordFileByFileId(fileId));
    }

    /**
     * 新增协同平台---指标管理--上报记录关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('index:file:add')")
    @Log(title = "协同平台---指标管理--上报记录关联的附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BIndexEvaluationRecordFile bIndexEvaluationRecordFile)
    {
        return toAjax(bIndexEvaluationRecordFileService.insertBIndexEvaluationRecordFile(bIndexEvaluationRecordFile));
    }

    /**
     * 修改协同平台---指标管理--上报记录关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('index:file:edit')")
    @Log(title = "协同平台---指标管理--上报记录关联的附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BIndexEvaluationRecordFile bIndexEvaluationRecordFile)
    {
        return toAjax(bIndexEvaluationRecordFileService.updateBIndexEvaluationRecordFile(bIndexEvaluationRecordFile));
    }

    /**
     * 删除协同平台---指标管理--上报记录关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('index:file:remove')")
    @Log(title = "协同平台---指标管理--上报记录关联的附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(bIndexEvaluationRecordFileService.deleteBIndexEvaluationRecordFileByFileIds(fileIds));
    }
}
