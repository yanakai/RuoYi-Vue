package com.yutu.web.controller.monitor;

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
import com.yutu.common.annotation.Log;
import com.yutu.common.core.controller.BaseController;
import com.yutu.common.core.domain.AjaxResult;
import com.yutu.common.enums.BusinessType;
import com.yutu.system.domain.SysOperLogSystem;
import com.yutu.system.service.ISysOperLogSystemService;
import com.yutu.common.utils.poi.ExcelUtil;
import com.yutu.common.core.page.TableDataInfo;

/**
 * 访问日志Controller
 *
 * @author yutu
 * @date 2024-03-01
 */
@RestController
@RequestMapping("/system/operlogSystem")
public class SysOperLogSystemController extends BaseController
{
    @Autowired
    private ISysOperLogSystemService sysOperLogSystemService;

    /**
     * 查询访问日志列表
     */
    @PreAuthorize("@ss.hasPermi('system:operlogSystem:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysOperLogSystem sysOperLogSystem)
    {
        startPage();
        List<SysOperLogSystem> list = sysOperLogSystemService.selectSysOperLogSystemList(sysOperLogSystem);
        return getDataTable(list);
    }

    /**
     * 导出访问日志列表
     */
    @PreAuthorize("@ss.hasPermi('system:operlogSystem:export')")
    @Log(title = "访问日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOperLogSystem sysOperLogSystem)
    {
        List<SysOperLogSystem> list = sysOperLogSystemService.selectSysOperLogSystemList(sysOperLogSystem);
        ExcelUtil<SysOperLogSystem> util = new ExcelUtil<SysOperLogSystem>(SysOperLogSystem.class);
        util.exportExcel(response, list, "访问日志数据");
    }

    /**
     * 获取访问日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:operlogSystem:query')")
    @GetMapping(value = "/{operId}")
    public AjaxResult getInfo(@PathVariable("operId") Long operId)
    {
        return success(sysOperLogSystemService.selectSysOperLogSystemByOperId(operId));
    }

    /**
     * 新增访问日志
     */
    @PostMapping("/saveSysOperLogSystemInfo")
    public AjaxResult saveSysOperLogSystem(@RequestBody SysOperLogSystem sysOperLogSystem) {
        return toAjax(sysOperLogSystemService.insertSysOperLogSystem(sysOperLogSystem));
    }

    /**
     * 修改访问日志
     */
    @PreAuthorize("@ss.hasPermi('system:operlogSystem:edit')")
    @Log(title = "访问日志", businessType = BusinessType.UPDATE)
    @PostMapping("/editSysOperLogSystemInfo")
    public AjaxResult edit(@RequestBody SysOperLogSystem sysOperLogSystem)
    {
        return toAjax(sysOperLogSystemService.updateSysOperLogSystem(sysOperLogSystem));
    }

    /**
     * 删除访问日志
     */
    @PreAuthorize("@ss.hasPermi('system:operlogSystem:remove')")
    @Log(title = "访问日志", businessType = BusinessType.DELETE)
    @PostMapping("/{operIds}")
    public AjaxResult remove(@PathVariable Long[] operIds)
    {
        return toAjax(sysOperLogSystemService.deleteSysOperLogSystemByOperIds(operIds));
    }
}
