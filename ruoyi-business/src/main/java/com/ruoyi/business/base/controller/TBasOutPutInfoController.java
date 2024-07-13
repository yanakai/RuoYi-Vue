package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.business.base.service.IVOutPutInfoService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 基础信息--企业--废气排口Controller
 *
 * @author lx
 * @date 2024-06-27
 */
@Api(value = "业务模块-污染排口", tags = "企业档案-污染排放口信息")
@RestController
@RequestMapping("/business/base/outPutInfo")
public class TBasOutPutInfoController extends BaseController {
    @Resource
    private IVOutPutInfoService vOutPutInfoService;

    /**
     * 查询基础信息--企业--废气排口列表
     */
    @ApiOperation("获取污染排放口信息列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(VOutPutInfo vOutPutInfo) {
        startPage();
        List<VOutPutInfo> list = vOutPutInfoService.selectVOutPutInfoList(vOutPutInfo);
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废气排口列表
     */
    @ApiOperation("导出污染排放口信息列表")
    @PreAuthorize("@ss.hasPermi('business:gasoutPutInfo:export')")
    @Log(title = "企业档案--污染排放口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VOutPutInfo vOutPutInfo) {
        List<VOutPutInfo> list = vOutPutInfoService.selectVOutPutInfoList(vOutPutInfo);
        ExcelUtil<VOutPutInfo> util = new ExcelUtil<>(VOutPutInfo.class);
        util.exportExcel(response, list, "企业档案--污染排放口信息");
    }

}
