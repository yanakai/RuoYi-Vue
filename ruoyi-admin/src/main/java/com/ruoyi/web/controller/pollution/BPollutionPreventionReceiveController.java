package com.ruoyi.web.controller.pollution;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.coordination.pollution.domain.dto.BPPReceive;
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
import com.ruoyi.coordination.pollution.domain.BPollutionPreventionReceive;
import com.ruoyi.coordination.pollution.service.IBPollutionPreventionReceiveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---污染防治目标--任务接收单位Controller
 * 
 * @author ruoyi
 * @date 2023-05-04
 */
@RestController
@RequestMapping("/pollution/receive")
public class BPollutionPreventionReceiveController extends BaseController
{
    @Autowired
    private IBPollutionPreventionReceiveService bPollutionPreventionReceiveService;

    /**
     * 查询协同平台---污染防治目标--任务接收单位列表
     */
    // @PreAuthorize("@ss.hasPermi('pollution:receive:list')")
    @GetMapping("/list")
    public AjaxResult list(BPollutionPreventionReceive bPollutionPreventionReceive)
    {
//        startPage();
        List<BPollutionPreventionReceive> list = bPollutionPreventionReceiveService.selectBPollutionPreventionReceiveList(bPollutionPreventionReceive);
        return success(list);
    }

    /**
     * 导出协同平台---污染防治目标--任务接收单位列表
     */
    // @PreAuthorize("@ss.hasPermi('pollution:receive:export')")
    @Log(title = "协同平台---污染防治目标--任务接收单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BPollutionPreventionReceive bPollutionPreventionReceive)
    {
        List<BPollutionPreventionReceive> list = bPollutionPreventionReceiveService.selectBPollutionPreventionReceiveList(bPollutionPreventionReceive);
        ExcelUtil<BPollutionPreventionReceive> util = new ExcelUtil<BPollutionPreventionReceive>(BPollutionPreventionReceive.class);
        util.exportExcel(response, list, "协同平台---污染防治目标--任务接收单位数据");
    }

    /**
     * 获取协同平台---污染防治目标--任务接收单位详细信息
     */
    // @PreAuthorize("@ss.hasPermi('pollution:receive:query')")
    @GetMapping(value = "/{receiveId}")
    public AjaxResult getInfo(@PathVariable("receiveId") Long receiveId)
    {
        return success(bPollutionPreventionReceiveService.selectBPollutionPreventionReceiveByReceiveId(receiveId));
    }

    /**
     * 新增协同平台---污染防治目标--任务接收单位
     */
    // @PreAuthorize("@ss.hasPermi('pollution:receive:add')")
    @Log(title = "协同平台---污染防治目标--任务接收单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BPPReceive bPollutionPreventionReceive)
    {
        return toAjax(bPollutionPreventionReceiveService.insertBPollutionPreventionReceive(bPollutionPreventionReceive));
    }

    /**
     * 修改协同平台---污染防治目标--任务接收单位
     */
    // @PreAuthorize("@ss.hasPermi('pollution:receive:edit')")
    @Log(title = "协同平台---污染防治目标--任务接收单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BPollutionPreventionReceive bPollutionPreventionReceive)
    {
        return toAjax(bPollutionPreventionReceiveService.updateBPollutionPreventionReceive(bPollutionPreventionReceive));
    }

    /**
     * 删除协同平台---污染防治目标--任务接收单位
     */
    // @PreAuthorize("@ss.hasPermi('pollution:receive:remove')")
    @Log(title = "协同平台---污染防治目标--任务接收单位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{receiveIds}")
    public AjaxResult remove(@PathVariable Long[] receiveIds)
    {
        return toAjax(bPollutionPreventionReceiveService.deleteBPollutionPreventionReceiveByReceiveIds(receiveIds));
    }
}
