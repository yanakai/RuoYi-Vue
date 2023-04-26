package com.ruoyi.web.controller.annual;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.ruoyi.coordination.annual.domain.BAnnualTargetReceive;
import com.ruoyi.coordination.annual.service.IBAnnualTargetReceiveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台---年度任务目标--任务接收单位Controller
 *
 * @author yanakai@126.com
 * @date 2023-04-20
 */
@Api("任务接收")
@RestController
@RequestMapping("/annual/receive")
public class BAnnualTargetReceiveController extends BaseController
{
    @Autowired
    private IBAnnualTargetReceiveService bAnnualTargetReceiveService;

    /**
     * 查询协同平台---年度任务目标--任务接收单位列表
     */
//    @PreAuthorize("@ss.hasPermi('annual:receive:list')")
    @GetMapping("/list")
    public TableDataInfo list(BAnnualTargetReceive bAnnualTargetReceive)
    {
        startPage();
        List<BAnnualTargetReceive> list = bAnnualTargetReceiveService.selectBAnnualTargetReceiveList(bAnnualTargetReceive);
        return getDataTable(list);
    }

    @GetMapping("/getReceiveDept")
    public AjaxResult getReceiveDept(BAnnualTargetReceive bAnnualTargetReceive)
    {
        List<String> list = bAnnualTargetReceiveService.getReceiveDept(bAnnualTargetReceive);
        return success(list.get(0));
    }

    /**
     * 导出协同平台---年度任务目标--任务接收单位列表
     */
    @PreAuthorize("@ss.hasPermi('annual:receive:export')")
    @Log(title = "协同平台---年度任务目标--任务接收单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BAnnualTargetReceive bAnnualTargetReceive)
    {
        List<BAnnualTargetReceive> list = bAnnualTargetReceiveService.selectBAnnualTargetReceiveList(bAnnualTargetReceive);
        ExcelUtil<BAnnualTargetReceive> util = new ExcelUtil<BAnnualTargetReceive>(BAnnualTargetReceive.class);
        util.exportExcel(response, list, "协同平台---年度任务目标--任务接收单位数据");
    }

    /**
     * 获取协同平台---年度任务目标--任务接收单位详细信息
     */
//    @PreAuthorize("@ss.hasPermi('annual:receive:query')")
    @GetMapping(value = "/{receiveId}")
    public AjaxResult getInfo(@PathVariable("receiveId") Long receiveId)
    {
        return success(bAnnualTargetReceiveService.selectBAnnualTargetReceiveByReceiveId(receiveId));
    }

    @GetMapping(value = "/andRecord/{receiveId}")
    public AjaxResult getReceiveInfo(@PathVariable("receiveId") Long receiveId){
        return success(bAnnualTargetReceiveService.selectBAnnualTargetReceiveAndRecord(receiveId));
    }

    /**
     * 新增协同平台---年度任务目标--任务接收单位
     */
    @PreAuthorize("@ss.hasPermi('annual:receive:add')")
    @Log(title = "协同平台---年度任务目标--任务接收单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BAnnualTargetReceive bAnnualTargetReceive)
    {
        return toAjax(bAnnualTargetReceiveService.insertBAnnualTargetReceive(bAnnualTargetReceive));
    }

    /**
     * 修改协同平台---年度任务目标--任务接收单位
     */
    @PreAuthorize("@ss.hasPermi('annual:receive:edit')")
    @Log(title = "协同平台---年度任务目标--任务接收单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BAnnualTargetReceive bAnnualTargetReceive)
    {
        return toAjax(bAnnualTargetReceiveService.updateBAnnualTargetReceive(bAnnualTargetReceive));
    }

    /**
     * 删除协同平台---年度任务目标--任务接收单位
     */
    @PreAuthorize("@ss.hasPermi('annual:receive:remove')")
    @Log(title = "协同平台---年度任务目标--任务接收单位", businessType = BusinessType.DELETE)
    @DeleteMapping("/{receiveIds}")
    public AjaxResult remove(@PathVariable Long[] receiveIds)
    {
        return toAjax(bAnnualTargetReceiveService.deleteBAnnualTargetReceiveByReceiveIds(receiveIds));
    }
}
