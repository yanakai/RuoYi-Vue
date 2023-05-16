package com.ruoyi.web.controller.clue;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.coordination.clue.domain.dto.BCIReceive;
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
import com.ruoyi.coordination.clue.domain.BClueInfoReceive;
import com.ruoyi.coordination.clue.service.IBClueInfoReceiveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--污染线索处置----线索主任务接收单位Controller
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/clue/receive")
public class BClueInfoReceiveController extends BaseController
{
    @Autowired
    private IBClueInfoReceiveService bClueInfoReceiveService;

    /**
     * 查询协同平台--污染线索处置----线索主任务接收单位列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:clue:list')")
    @GetMapping("/list")
    public TableDataInfo list(BClueInfoReceive bClueInfoReceive)
    {
        startPage();
        List<BClueInfoReceive> list = bClueInfoReceiveService.selectBClueInfoReceiveList(bClueInfoReceive);
        return getDataTable(list);
    }

    /**
     * 导出协同平台--污染线索处置----线索主任务接收单位列表
     */
    //@PreAuthorize("@ss.hasPermi('clue:clue:export')")
    @Log(title = "协同平台--污染线索处置----线索主任务接收单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoReceive bClueInfoReceive)
    {
        List<BClueInfoReceive> list = bClueInfoReceiveService.selectBClueInfoReceiveList(bClueInfoReceive);
        ExcelUtil<BClueInfoReceive> util = new ExcelUtil<BClueInfoReceive>(BClueInfoReceive.class);
        util.exportExcel(response, list, "协同平台--污染线索处置----线索主任务接收单位数据");
    }

    /**
     * 获取协同平台--污染线索处置----线索主任务接收单位详细信息
     */
    //@PreAuthorize("@ss.hasPermi('clue:clue:query')")
    @GetMapping(value = "/{receiveId}")
    public AjaxResult getInfo(@PathVariable("receiveId") Long receiveId)
    {
        return success(bClueInfoReceiveService.selectBClueInfoReceiveByReceiveId(receiveId));
    }

    /**
     * 新增协同平台--污染线索处置----线索主任务接收单位
     */
    //@PreAuthorize("@ss.hasPermi('clue:clue:add')")
    @Log(title = "协同平台--污染线索处置----线索主任务接收单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BCIReceive bClueInfoReceive)
    {
        return toAjax(bClueInfoReceiveService.insertBClueInfoReceive(bClueInfoReceive));
    }

    /**
     * 修改协同平台--污染线索处置----线索主任务接收单位
     */
    //@PreAuthorize("@ss.hasPermi('clue:clue:edit')")
    @Log(title = "协同平台--污染线索处置----线索主任务接收单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BClueInfoReceive bClueInfoReceive)
    {
        return toAjax(bClueInfoReceiveService.updateBClueInfoReceive(bClueInfoReceive));
    }

    /**
     * 删除协同平台--污染线索处置----线索主任务接收单位
     */
    //@PreAuthorize("@ss.hasPermi('clue:clue:remove')")
    @Log(title = "协同平台--污染线索处置----线索主任务接收单位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{receiveIds}")
    public AjaxResult remove(@PathVariable Long[] receiveIds)
    {
        return toAjax(bClueInfoReceiveService.deleteBClueInfoReceiveByReceiveIds(receiveIds));
    }
}
