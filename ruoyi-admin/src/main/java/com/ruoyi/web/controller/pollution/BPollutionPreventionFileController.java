package com.ruoyi.web.controller.pollution;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
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
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionFile;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 协同平台---污染防治目标--文件解读Controller
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@RestController
@RequestMapping("/pollution/file")
public class BPollutionPreventionFileController extends BaseController
{
    @Autowired
    private IBPollutionPreventionFileService bPollutionPreventionFileService;

    /**
     * 查询协同平台---污染防治目标--文件解读列表
     */
    //  @PreAuthorize("@ss.hasPermi('pollution:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(BPollutionPreventionFile bPollutionPreventionFile)
    {
        startPage();
        List<BPollutionPreventionFile> list = bPollutionPreventionFileService.selectBPollutionPreventionFileList(bPollutionPreventionFile);
        return getDataTable(list);
    }

    /**
     * 导出协同平台---污染防治目标--文件解读列表
     */
    //  @PreAuthorize("@ss.hasPermi('pollution:file:export')")
    @Log(title = "协同平台---污染防治目标--文件解读", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BPollutionPreventionFile bPollutionPreventionFile)
    {
        List<BPollutionPreventionFile> list = bPollutionPreventionFileService.selectBPollutionPreventionFileList(bPollutionPreventionFile);
        ExcelUtil<BPollutionPreventionFile> util = new ExcelUtil<BPollutionPreventionFile>(BPollutionPreventionFile.class);
        util.exportExcel(response, list, "协同平台---污染防治目标--文件解读数据");
    }

    /**
     * 获取协同平台---污染防治目标--文件解读详细信息
     */
    //  @PreAuthorize("@ss.hasPermi('pollution:file:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return success(bPollutionPreventionFileService.selectBPollutionPreventionFileByFileId(fileId));
    }

    /**
     * 新增协同平台---污染防治目标--文件解读
     */
    //  @PreAuthorize("@ss.hasPermi('pollution:file:add')")
    @Log(title = "协同平台---污染防治目标--文件解读", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BPollutionPreventionFile bPollutionPreventionFile)
    {
        return toAjax(bPollutionPreventionFileService.insertBPollutionPreventionFile(bPollutionPreventionFile));
    }

    /**
     * 修改协同平台---污染防治目标--文件解读
     */
    //  @PreAuthorize("@ss.hasPermi('pollution:file:edit')")
    @Log(title = "协同平台---污染防治目标--文件解读", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BPollutionPreventionFile bPollutionPreventionFile)
    {
        return toAjax(bPollutionPreventionFileService.updateBPollutionPreventionFile(bPollutionPreventionFile));
    }

    /**
     * 删除协同平台---污染防治目标--文件解读
     */
    //  @PreAuthorize("@ss.hasPermi('pollution:file:remove')")
    @Log(title = "协同平台---污染防治目标--文件解读", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(bPollutionPreventionFileService.deleteBPollutionPreventionFileByFileIds(fileIds));
    }

}
