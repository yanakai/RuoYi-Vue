package com.ruoyi.web.controller.index;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.coordination.index.domain.dto.EvaRecordAndFile;
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
import com.ruoyi.coordination.index.domain.BIndexEvaluationRecord;
import com.ruoyi.coordination.index.service.IBIndexEvaluationRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---指标管理--指标任务接收单位上报记录Controller
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@RestController
@RequestMapping("/index/record")
public class BIndexEvaluationRecordController extends BaseController
{
    @Autowired
    private IBIndexEvaluationRecordService bIndexEvaluationRecordService;

    /**
     * 查询协同平台---指标管理--指标任务接收单位上报记录列表
     */
    //@PreAuthorize("@ss.hasPermi('index:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(BIndexEvaluationRecord bIndexEvaluationRecord)
    {
        startPage();
        List<BIndexEvaluationRecord> list = bIndexEvaluationRecordService.selectBIndexEvaluationRecordList(bIndexEvaluationRecord);
        return getDataTable(list);
    }

    /**
     * 查询协同平台---指标管理--指标任务接收单位上报记录列表无分页
     */
    //@PreAuthorize("@ss.hasPermi('index:record:list')")
    @GetMapping("/recordList")
    public AjaxResult records(BIndexEvaluationRecord bIndexEvaluationRecord)
    {
        List<EvaRecordAndFile> list = bIndexEvaluationRecordService.selectBIndexEvaluationRecords(bIndexEvaluationRecord);
        return AjaxResult.success(list);
    }


    /**
     * 导出协同平台---指标管理--指标任务接收单位上报记录列表
     */
    //@PreAuthorize("@ss.hasPermi('index:record:export')")
    @Log(title = "协同平台---指标管理--指标任务接收单位上报记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BIndexEvaluationRecord bIndexEvaluationRecord)
    {
        List<BIndexEvaluationRecord> list = bIndexEvaluationRecordService.selectBIndexEvaluationRecordList(bIndexEvaluationRecord);
        ExcelUtil<BIndexEvaluationRecord> util = new ExcelUtil<BIndexEvaluationRecord>(BIndexEvaluationRecord.class);
        util.exportExcel(response, list, "协同平台---指标管理--指标任务接收单位上报记录数据");
    }

    /**
     * 获取协同平台---指标管理--指标任务接收单位上报记录详细信息
     */
    //@PreAuthorize("@ss.hasPermi('index:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(bIndexEvaluationRecordService.selectBIndexEvaluationRecordByRecordId(recordId));
    }

    /**
     * 获取协同平台---指标管理--查询最新的上报记录
     */
    //@PreAuthorize("@ss.hasPermi('index:record:query')")
    @GetMapping(value = "/receiveId")
    public AjaxResult getRecordDetail(Long receiveId)
    {
        EvaRecordAndFile recordAndFile = bIndexEvaluationRecordService.selectBIndexEvaluationRecordByReceiveId(receiveId);
        if (recordAndFile == null){
            recordAndFile = new EvaRecordAndFile();
            recordAndFile.setFileList(new ArrayList<>());
        }
        return AjaxResult.success(recordAndFile);
    }

    /**
     * 新增协同平台---指标管理--指标任务接收单位上报记录
     */
    //@PreAuthorize("@ss.hasPermi('index:record:add')")
    @Log(title = "协同平台---指标管理--指标任务接收单位上报记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EvaRecordAndFile bIndexEvaluationRecord)
    {
        return toAjax(bIndexEvaluationRecordService.insertBIndexEvaluationRecord(bIndexEvaluationRecord));
    }

    /**
     * 修改协同平台---指标管理--指标任务接收单位上报记录
     */
    //@PreAuthorize("@ss.hasPermi('index:record:edit')")
    @Log(title = "协同平台---指标管理--指标任务接收单位上报记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BIndexEvaluationRecord bIndexEvaluationRecord)
    {
        return toAjax(bIndexEvaluationRecordService.updateBIndexEvaluationRecord(bIndexEvaluationRecord));
    }

    /**
     * 删除协同平台---指标管理--指标任务接收单位上报记录
     */
    //@PreAuthorize("@ss.hasPermi('index:record:remove')")
    @Log(title = "协同平台---指标管理--指标任务接收单位上报记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(bIndexEvaluationRecordService.deleteBIndexEvaluationRecordByRecordIds(recordIds));
    }
}
