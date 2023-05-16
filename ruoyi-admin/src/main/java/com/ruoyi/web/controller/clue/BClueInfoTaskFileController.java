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
import com.ruoyi.coordination.clue.domain.BClueInfoTaskFile;
import com.ruoyi.coordination.clue.service.IBClueInfoTaskFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--污染线索处置----线索主任务关联的附件Controller
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/clue/taskFile")
public class BClueInfoTaskFileController extends BaseController
{
    @Autowired
    private IBClueInfoTaskFileService bClueInfoTaskFileService;

    /**
     * 查询协同平台--污染线索处置----线索主任务关联的附件列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:taskFile:list')")
    @GetMapping("/list")
    public AjaxResult list(BClueInfoTaskFile bClueInfoTaskFile)
    {
//        startPage();
        List<BClueInfoTaskFile> list = bClueInfoTaskFileService.selectBClueInfoTaskFileList(bClueInfoTaskFile);
        return success(list);
    }

    /**
     * 导出协同平台--污染线索处置----线索主任务关联的附件列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:taskFile:export')")
    @Log(title = "协同平台--污染线索处置----线索主任务关联的附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoTaskFile bClueInfoTaskFile)
    {
        List<BClueInfoTaskFile> list = bClueInfoTaskFileService.selectBClueInfoTaskFileList(bClueInfoTaskFile);
        ExcelUtil<BClueInfoTaskFile> util = new ExcelUtil<BClueInfoTaskFile>(BClueInfoTaskFile.class);
        util.exportExcel(response, list, "协同平台--污染线索处置----线索主任务关联的附件数据");
    }

    /**
     * 获取协同平台--污染线索处置----线索主任务关联的附件详细信息
     */
    //@PreAuthorize("@ss.hasPermi('clue:taskFile:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return success(bClueInfoTaskFileService.selectBClueInfoTaskFileByFileId(fileId));
    }

    /**
     * 新增协同平台--污染线索处置----线索主任务关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('clue:taskFile:add')")
    @Log(title = "协同平台--污染线索处置----线索主任务关联的附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BClueInfoTaskFile bClueInfoTaskFile)
    {
        return toAjax(bClueInfoTaskFileService.insertBClueInfoTaskFile(bClueInfoTaskFile));
    }

    /**
     * 修改协同平台--污染线索处置----线索主任务关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('clue:taskFile:edit')")
    @Log(title = "协同平台--污染线索处置----线索主任务关联的附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BClueInfoTaskFile bClueInfoTaskFile)
    {
        return toAjax(bClueInfoTaskFileService.updateBClueInfoTaskFile(bClueInfoTaskFile));
    }

    /**
     * 删除协同平台--污染线索处置----线索主任务关联的附件
     */
    //@PreAuthorize("@ss.hasPermi('clue:taskFile:remove')")
    @Log(title = "协同平台--污染线索处置----线索主任务关联的附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(bClueInfoTaskFileService.deleteBClueInfoTaskFileByFileIds(fileIds));
    }
}
