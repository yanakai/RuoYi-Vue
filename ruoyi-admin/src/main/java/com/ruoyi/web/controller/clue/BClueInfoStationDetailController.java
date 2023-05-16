package com.ruoyi.web.controller.clue;

import java.util.List;
import java.util.Map;
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
import com.ruoyi.coordination.clue.domain.BClueInfoStationDetail;
import com.ruoyi.coordination.clue.service.IBClueInfoStationDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 协同平台--污染线索处置--空气站点详情Controller
 * 
 * @author ruoyi
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/clue/stationDetail")
public class BClueInfoStationDetailController extends BaseController
{
    @Autowired
    private IBClueInfoStationDetailService bClueInfoStationDetailService;

    /**
     * 查询协同平台--污染线索处置--空气站点  所属区划字典
     */
    // @PreAuthorize("@ss.hasPermi('clue:stationDetail:list')")
    @GetMapping("/regionList")
    public AjaxResult regionList()
    {
        List<Map<String,Object>> list = bClueInfoStationDetailService.selectRegionDict();
        return success(list);
    }

    /**
     * 查询协同平台--污染线索处置--空气站点  责任单位字典
     */
    // @PreAuthorize("@ss.hasPermi('clue:stationDetail:list')")
    @GetMapping("/unitList")
    public AjaxResult unitList()
    {
        List<Map<String,Object>> list = bClueInfoStationDetailService.selectUnitDict();
        return success(list);
    }

    /**
     * 导出协同平台--污染线索处置--空气站点详情列表
     */
    // @PreAuthorize("@ss.hasPermi('clue:stationDetail:export')")
    @Log(title = "协同平台--污染线索处置--空气站点详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoStationDetail bClueInfoStationDetail)
    {
        List<BClueInfoStationDetail> list = bClueInfoStationDetailService.selectBClueInfoStationDetailList(bClueInfoStationDetail);
        ExcelUtil<BClueInfoStationDetail> util = new ExcelUtil<BClueInfoStationDetail>(BClueInfoStationDetail.class);
        util.exportExcel(response, list, "协同平台--污染线索处置--空气站点详情数据");
    }

    /**
     * 获取协同平台--污染线索处置--空气站点详情详细信息
     */
    // @PreAuthorize("@ss.hasPermi('clue:stationDetail:query')")
    @GetMapping(value = "/{stationId}")
    public AjaxResult getInfo(@PathVariable("stationId") Long stationId)
    {
        return success(bClueInfoStationDetailService.selectBClueInfoStationDetailByStationId(stationId));
    }

    /**
     * 新增协同平台--污染线索处置--空气站点详情
     */
    // @PreAuthorize("@ss.hasPermi('clue:stationDetail:add')")
    @Log(title = "协同平台--污染线索处置--空气站点详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BClueInfoStationDetail bClueInfoStationDetail)
    {
        return toAjax(bClueInfoStationDetailService.insertBClueInfoStationDetail(bClueInfoStationDetail));
    }

    /**
     * 修改协同平台--污染线索处置--空气站点详情
     */
    // @PreAuthorize("@ss.hasPermi('clue:stationDetail:edit')")
    @Log(title = "协同平台--污染线索处置--空气站点详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BClueInfoStationDetail bClueInfoStationDetail)
    {
        return toAjax(bClueInfoStationDetailService.updateBClueInfoStationDetail(bClueInfoStationDetail));
    }

    /**
     * 删除协同平台--污染线索处置--空气站点详情
     */
    // @PreAuthorize("@ss.hasPermi('clue:stationDetail:remove')")
    @Log(title = "协同平台--污染线索处置--空气站点详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stationIds}")
    public AjaxResult remove(@PathVariable Long[] stationIds)
    {
        return toAjax(bClueInfoStationDetailService.deleteBClueInfoStationDetailByStationIds(stationIds));
    }
}
