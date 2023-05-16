package com.ruoyi.web.controller.clue;

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
import com.ruoyi.coordination.clue.domain.BClueInfoRecordFile;
import com.ruoyi.coordination.clue.service.IBClueInfoRecordFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--污染线索处置--上报记录关联的附件Controller
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/clue/recordFile")
public class BClueInfoRecordFileController extends BaseController
{
    @Autowired
    private IBClueInfoRecordFileService bClueInfoRecordFileService;

    /**
     * 查询协同平台--污染线索处置--上报记录关联的附件列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:recordFile:list')")
    @GetMapping("/list")
    public TableDataInfo list(BClueInfoRecordFile bClueInfoRecordFile)
    {
        startPage();
        List<BClueInfoRecordFile> list = bClueInfoRecordFileService.selectBClueInfoRecordFileList(bClueInfoRecordFile);
        return getDataTable(list);
    }

    /**
     * 导出协同平台--污染线索处置--上报记录关联的附件列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:recordFile:export')")
    @Log(title = "协同平台--污染线索处置--上报记录关联的附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoRecordFile bClueInfoRecordFile)
    {
        List<BClueInfoRecordFile> list = bClueInfoRecordFileService.selectBClueInfoRecordFileList(bClueInfoRecordFile);
        ExcelUtil<BClueInfoRecordFile> util = new ExcelUtil<BClueInfoRecordFile>(BClueInfoRecordFile.class);
        util.exportExcel(response, list, "协同平台--污染线索处置--上报记录关联的附件数据");
    }

    /**
     * 获取协同平台--污染线索处置--上报记录关联的附件详细信息
     */
    //@PreAuthorize("@ss.hasPermi('clue:recordFile:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return success(bClueInfoRecordFileService.selectBClueInfoRecordFileByFileId(fileId));
    }

    /**
     * 新增协同平台--污染线索处置--上报记录关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('clue:recordFile:add')")
    @Log(title = "协同平台--污染线索处置--上报记录关联的附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BClueInfoRecordFile bClueInfoRecordFile)
    {
        return toAjax(bClueInfoRecordFileService.insertBClueInfoRecordFile(bClueInfoRecordFile));
    }

    /**
     * 修改协同平台--污染线索处置--上报记录关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('clue:recordFile:edit')")
    @Log(title = "协同平台--污染线索处置--上报记录关联的附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BClueInfoRecordFile bClueInfoRecordFile)
    {
        return toAjax(bClueInfoRecordFileService.updateBClueInfoRecordFile(bClueInfoRecordFile));
    }

    /**
     * 删除协同平台--污染线索处置--上报记录关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('clue:recordFile:remove')")
    @Log(title = "协同平台--污染线索处置--上报记录关联的附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(bClueInfoRecordFileService.deleteBClueInfoRecordFileByFileIds(fileIds));
    }
}
