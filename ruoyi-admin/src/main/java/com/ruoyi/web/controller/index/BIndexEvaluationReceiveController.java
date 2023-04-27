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
import com.ruoyi.coordination.index.domain.BIndexEvaluationReceive;
import com.ruoyi.coordination.index.service.IBIndexEvaluationReceiveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---指标管理--指标任务接收单位Controller
 * 
 * @author ruoyi
 * @date 2023-04-27
 */
@RestController
@RequestMapping("/index/receive")
public class BIndexEvaluationReceiveController extends BaseController
{
    @Autowired
    private IBIndexEvaluationReceiveService bIndexEvaluationReceiveService;

    /**
     * 查询协同平台---指标管理--指标任务接收单位列表
     */
    //@PreAuthorize("@ss.hasPermi('index:receive:list')")
    @GetMapping("/list")
    public TableDataInfo list(BIndexEvaluationReceive bIndexEvaluationReceive)
    {
        startPage();
        List<BIndexEvaluationReceive> list = bIndexEvaluationReceiveService.selectBIndexEvaluationReceiveList(bIndexEvaluationReceive);
        return getDataTable(list);
    }

    /**
     * 导出协同平台---指标管理--指标任务接收单位列表
     */
    @PreAuthorize("@ss.hasPermi('index:receive:export')")
    @Log(title = "协同平台---指标管理--指标任务接收单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BIndexEvaluationReceive bIndexEvaluationReceive)
    {
        List<BIndexEvaluationReceive> list = bIndexEvaluationReceiveService.selectBIndexEvaluationReceiveList(bIndexEvaluationReceive);
        ExcelUtil<BIndexEvaluationReceive> util = new ExcelUtil<BIndexEvaluationReceive>(BIndexEvaluationReceive.class);
        util.exportExcel(response, list, "协同平台---指标管理--指标任务接收单位数据");
    }

    /**
     * 获取协同平台---指标管理--指标任务接收单位详细信息
     */
    @PreAuthorize("@ss.hasPermi('index:receive:query')")
    @GetMapping(value = "/{receiveId}")
    public AjaxResult getInfo(@PathVariable("receiveId") Long receiveId)
    {
        return success(bIndexEvaluationReceiveService.selectBIndexEvaluationReceiveByReceiveId(receiveId));
    }

    /**
     * 新增协同平台---指标管理--指标任务接收单位
     */
    @PreAuthorize("@ss.hasPermi('index:receive:add')")
    @Log(title = "协同平台---指标管理--指标任务接收单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BIndexEvaluationReceive bIndexEvaluationReceive)
    {
        return toAjax(bIndexEvaluationReceiveService.insertBIndexEvaluationReceive(bIndexEvaluationReceive));
    }

    /**
     * 修改协同平台---指标管理--指标任务接收单位
     */
    @PreAuthorize("@ss.hasPermi('index:receive:edit')")
    @Log(title = "协同平台---指标管理--指标任务接收单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BIndexEvaluationReceive bIndexEvaluationReceive)
    {
        return toAjax(bIndexEvaluationReceiveService.updateBIndexEvaluationReceive(bIndexEvaluationReceive));
    }

    /**
     * 删除协同平台---指标管理--指标任务接收单位
     */
    @PreAuthorize("@ss.hasPermi('index:receive:remove')")
    @Log(title = "协同平台---指标管理--指标任务接收单位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{receiveIds}")
    public AjaxResult remove(@PathVariable Long[] receiveIds)
    {
        return toAjax(bIndexEvaluationReceiveService.deleteBIndexEvaluationReceiveByReceiveIds(receiveIds));
    }
}
