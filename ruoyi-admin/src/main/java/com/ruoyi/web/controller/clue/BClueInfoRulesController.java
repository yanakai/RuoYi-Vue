package com.ruoyi.web.controller.clue;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.coordination.clue.domain.WarnRule;
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
import com.ruoyi.coordination.clue.domain.BClueInfoRules;
import com.ruoyi.coordination.clue.service.IBClueInfoRulesService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 协同平台--污染线索处置--站点预警规则Controller
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/clue/rules")
public class BClueInfoRulesController extends BaseController
{
    @Autowired
    private IBClueInfoRulesService bClueInfoRulesService;

    /**
     * 查询协同平台--污染线索处置--站点预警规则列表

    // @PreAuthorize("@ss.hasPermi('clue:rules:list')")
    @GetMapping("/list")
    public TableDataInfo list(BClueInfoRules bClueInfoRules)
    {
        startPage();
        List<BClueInfoRules> list = bClueInfoRulesService.selectBClueInfoRulesList(bClueInfoRules);
        return getDataTable(list);
    }
     */
    /**
     * 查询协同平台--污染线索处置--站点预警规则列表
     */
     // @PreAuthorize("@ss.hasPermi('clue:rules:list')")
     @GetMapping("/list")
     public AjaxResult list(BClueInfoRules bClueInfoRules){

         List<BClueInfoRules> rules = bClueInfoRulesService.selectWarnRules(bClueInfoRules);

         return success(rules);
     }
    /**
     * 导出协同平台--污染线索处置--站点预警规则列表
     */
    // @PreAuthorize("@ss.hasPermi('clue:rules:export')")
    @Log(title = "协同平台--污染线索处置--站点预警规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BClueInfoRules bClueInfoRules)
    {
        List<BClueInfoRules> list = bClueInfoRulesService.selectBClueInfoRulesList(bClueInfoRules);
        ExcelUtil<BClueInfoRules> util = new ExcelUtil<BClueInfoRules>(BClueInfoRules.class);
        util.exportExcel(response, list, "协同平台--污染线索处置--站点预警规则数据");
    }

    /**
     * 获取协同平台--污染线索处置--站点预警规则详细信息
     */
    // @PreAuthorize("@ss.hasPermi('clue:rules:query')")
    @GetMapping(value = "/{rulesId}")
    public AjaxResult getInfo(@PathVariable("rulesId") Long rulesId)
    {
        return success(bClueInfoRulesService.selectBClueInfoRulesByRulesId(rulesId));
    }

    /**
     * 新增协同平台--污染线索处置--站点预警规则
     */
    // @PreAuthorize("@ss.hasPermi('clue:rules:add')")
    @Log(title = "协同平台--污染线索处置--站点预警规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BClueInfoRules bClueInfoRules)
    {
        return toAjax(bClueInfoRulesService.insertBClueInfoRules(bClueInfoRules));
    }

    /**
     * 批量新增协同平台--污染线索处置--站点预警规则
     */
    // @PreAuthorize("@ss.hasPermi('clue:rules:add')")
    @Log(title = "协同平台--污染线索处置--站点预警规则", businessType = BusinessType.INSERT)
    @PostMapping("/addList")
    public AjaxResult addList(@RequestBody List<WarnRule> bClueInfoRules)
    {
        return toAjax(bClueInfoRulesService.inserWarnRuleList(bClueInfoRules));
    }

    /**
     * 修改协同平台--污染线索处置--站点预警规则
     */
    // @PreAuthorize("@ss.hasPermi('clue:rules:edit')")
    @Log(title = "协同平台--污染线索处置--站点预警规则", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BClueInfoRules bClueInfoRules)
    {
        return toAjax(bClueInfoRulesService.updateBClueInfoRules(bClueInfoRules));
    }

    /**
     * 删除协同平台--污染线索处置--站点预警规则
     */
    // @PreAuthorize("@ss.hasPermi('clue:rules:remove')")
    @Log(title = "协同平台--污染线索处置--站点预警规则", businessType = BusinessType.DELETE)
	@DeleteMapping("/{rulesIds}")
    public AjaxResult remove(@PathVariable Long[] rulesIds)
    {
        return toAjax(bClueInfoRulesService.deleteBClueInfoRulesByRulesIds(rulesIds));
    }
}
