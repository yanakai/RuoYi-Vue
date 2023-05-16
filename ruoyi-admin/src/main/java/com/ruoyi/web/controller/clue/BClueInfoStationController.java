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
import com.ruoyi.coordination.clue.domain.BClueInfoStation;
import com.ruoyi.coordination.clue.service.IBClueInfoStationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--污染线索处置--空气站点预警状态Controller
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/clue/station")
public class BClueInfoStationController extends BaseController
{
    @Autowired
    private IBClueInfoStationService bClueInfoStationService;

    /**
     * 查询协同平台--污染线索处置--空气站点预警状态列表
     */
    // @PreAuthorize("@ss.hasPermi('clue:station:list')")
    @GetMapping("/list")
    public TableDataInfo list(BClueInfoStation bClueInfoStation)
    {
        startPage();
        List<BClueInfoStation> list = bClueInfoStationService.selectBClueInfoStationList(bClueInfoStation);
        return getDataTable(list);
    }

    /**
     * 导出协同平台--污染线索处置--空气站点预警状态列表
     */
    // @PreAuthorize("@ss.hasPermi('clue:station:export')")
    @Log(title = "协同平台--污染线索处置--空气站点预警状态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoStation bClueInfoStation)
    {
        List<BClueInfoStation> list = bClueInfoStationService.selectBClueInfoStationList(bClueInfoStation);
        ExcelUtil<BClueInfoStation> util = new ExcelUtil<BClueInfoStation>(BClueInfoStation.class);
        util.exportExcel(response, list, "协同平台--污染线索处置--空气站点预警状态数据");
    }

    /**
     * 获取协同平台--污染线索处置--空气站点预警状态详细信息
     */
    // @PreAuthorize("@ss.hasPermi('clue:station:query')")
    @GetMapping(value = "/{earlyId}")
    public AjaxResult getInfo(@PathVariable("earlyId") Long earlyId)
    {
        return success(bClueInfoStationService.selectBClueInfoStationByEarlyId(earlyId));
    }

    /**
     * 新增协同平台--污染线索处置--空气站点预警状态
     */
    // @PreAuthorize("@ss.hasPermi('clue:station:add')")
    @Log(title = "协同平台--污染线索处置--空气站点预警状态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BClueInfoStation bClueInfoStation)
    {
        return toAjax(bClueInfoStationService.insertBClueInfoStation(bClueInfoStation));
    }

    /**
     * 修改协同平台--污染线索处置--空气站点预警状态
     */
    // @PreAuthorize("@ss.hasPermi('clue:station:edit')")
    @Log(title = "协同平台--污染线索处置--空气站点预警状态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BClueInfoStation bClueInfoStation)
    {
        return toAjax(bClueInfoStationService.updateBClueInfoStation(bClueInfoStation));
    }

    /**
     * 删除协同平台--污染线索处置--空气站点预警状态
     */
    // @PreAuthorize("@ss.hasPermi('clue:station:remove')")
    @Log(title = "协同平台--污染线索处置--空气站点预警状态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{earlyIds}")
    public AjaxResult remove(@PathVariable Long[] earlyIds)
    {
        return toAjax(bClueInfoStationService.deleteBClueInfoStationByEarlyIds(earlyIds));
    }
}
