package com.ruoyi.web.controller.clue;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.coordination.clue.domain.dto.BCIRecordAndFile;
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
import com.ruoyi.coordination.clue.domain.BClueInfoRecord;
import com.ruoyi.coordination.clue.service.IBClueInfoRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--污染线索处置--接收单位上报记录
Controller
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/clue/record")
public class BClueInfoRecordController extends BaseController
{
    @Autowired
    private IBClueInfoRecordService bClueInfoRecordService;

    /**
     * 查询协同平台--污染线索处置--接收单位上报记录
列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(BClueInfoRecord bClueInfoRecord)
    {
        startPage();
        List<BClueInfoRecord> list = bClueInfoRecordService.selectBClueInfoRecordList(bClueInfoRecord);
        return getDataTable(list);
    }

    //@PreAuthorize("@ss.hasPermi('clue:record:list')")
    @GetMapping("/recordList")
    public AjaxResult recordList(BClueInfoRecord bClueInfoRecord)
    {
        List<BCIRecordAndFile> list = bClueInfoRecordService.selectBClueInfoRecordAndList(bClueInfoRecord);
        return success(list);
    }

    /**
     * 导出协同平台--污染线索处置--接收单位上报记录
列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:record:export')")
    @Log(title = "协同平台--污染线索处置--接收单位上报记录 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoRecord bClueInfoRecord)
    {
        List<BClueInfoRecord> list = bClueInfoRecordService.selectBClueInfoRecordList(bClueInfoRecord);
        ExcelUtil<BClueInfoRecord> util = new ExcelUtil<BClueInfoRecord>(BClueInfoRecord.class);
        util.exportExcel(response, list, "协同平台--污染线索处置--接收单位上报记录数据");
    }

    /**
     * 获取协同平台--污染线索处置--接收单位上报记录
详细信息
     */
    //@PreAuthorize("@ss.hasPermi('clue:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(bClueInfoRecordService.selectBClueInfoRecordByRecordId(recordId));
    }

    /**
     * 新增协同平台--污染线索处置--接收单位上报记录

     */
    //@PreAuthorize("@ss.hasPermi('clue:record:add')")
    @Log(title = "协同平台--污染线索处置--接收单位上报记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BCIRecordAndFile bClueInfoRecord)
    {
        return toAjax(bClueInfoRecordService.insertBClueInfoRecord(bClueInfoRecord));
    }

    /**
     * 修改协同平台--污染线索处置--接收单位上报记录

     */
    //@PreAuthorize("@ss.hasPermi('clue:record:edit')")
    @Log(title = "协同平台--污染线索处置--接收单位上报记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BClueInfoRecord bClueInfoRecord)
    {
        return toAjax(bClueInfoRecordService.updateBClueInfoRecord(bClueInfoRecord));
    }

    /**
     * 删除协同平台--污染线索处置--接收单位上报记录

     */
    //@PreAuthorize("@ss.hasPermi('clue:record:remove')")
    @Log(title = "协同平台--污染线索处置--接收单位上报记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(bClueInfoRecordService.deleteBClueInfoRecordByRecordIds(recordIds));
    }
}
