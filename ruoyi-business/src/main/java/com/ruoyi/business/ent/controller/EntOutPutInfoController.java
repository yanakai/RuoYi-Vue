package com.ruoyi.business.ent.controller;

import com.ruoyi.business.ent.domain.EntOutPutInfo;
import com.ruoyi.business.ent.domain.EntOutPutReq;
import com.ruoyi.business.ent.service.EntOutPutInfoService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业排口信息Controller
 */
@RestController
@RequestMapping("/platform/ent/outPutInfo")
public class EntOutPutInfoController {

    private EntOutPutInfoService entOutPutInfoService;
    @Autowired
    public void setEntOutPutInfoService(EntOutPutInfoService entOutPutInfoService) {
        this.entOutPutInfoService = entOutPutInfoService;
    }

    /**
     * 查询企业排口详细信息
     */
    @GetMapping("/{outPutId}")
    public AjaxResult list(@PathVariable("outPutId") String outPutId) {
        return entOutPutInfoService.selectOutPutById(outPutId);
    }

    /**
     * 查询企业排口列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) EntOutPutReq req) {
        return entOutPutInfoService.selectOutPutList(req);
    }

    /**
     * 导出企业排口列表
     * 按模版导出
     */
    @PostMapping("/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) EntOutPutReq req, HttpServletResponse response) {
        entOutPutInfoService.exportOutPut(req, response);
    }

    /**
     * 新增企业排口
     */
    @PostMapping
    public AjaxResult add(@RequestBody EntOutPutInfo info) {
        return entOutPutInfoService.insertOutPut(info);
    }

    /**
     * 修改企业排口
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EntOutPutInfo info) {
        return entOutPutInfoService.updateOutPut(info);
    }

    /**
     * 删除企业排口
     */
    @DeleteMapping("/{outPutIds}")
    public AjaxResult remove(@PathVariable List<String> outPutIds) {
        return entOutPutInfoService.deleteOutPutByIds(outPutIds);
    }
}
