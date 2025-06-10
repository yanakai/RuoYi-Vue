package com.ruoyi.business.envProt.controller;


import com.ruoyi.business.envProt.domain.EntCleanProduce;
import com.ruoyi.business.envProt.domain.EntCleanProduceReq;
import com.ruoyi.business.envProt.service.EntCleanProduceService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业清洁生产基础Controller
 */
@RestController
@RequestMapping("/platform/envProt/entCleanProduce")
public class EntCleanProduceController {

    private EntCleanProduceService entCleanProduceService;
    @Autowired
    public void setEntCleanProduceService(EntCleanProduceService entCleanProduceService) {
        this.entCleanProduceService = entCleanProduceService;
    }

    /**
     * 查询企业清洁生产基础列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) EntCleanProduceReq req) {
        return entCleanProduceService.selectEntCleanProduceList(req);
    }

    /**
     * 导出企业清洁生产基础列表
     * 按模版导出
     */
    @PostMapping("/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) EntCleanProduceReq req, HttpServletResponse response) {
        entCleanProduceService.exportEntCleanProduce(req, response);
    }

    /**
     * 新增企业清洁生产基础
     */
    @PostMapping
    public AjaxResult add(@RequestBody EntCleanProduce clean) {
        return entCleanProduceService.insertEntCleanProduce(clean);
    }

    /**
     * 修改企业清洁生产基础
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EntCleanProduce clean) {
        return entCleanProduceService.updateEntCleanProduce(clean);
    }

    /**
     * 修改企业清洁生产基础
     */
    @PutMapping("/audit")
    public AjaxResult editAudit(@RequestBody EntCleanProduce clean) {
        return entCleanProduceService.entCleanProduceAudit(clean);
    }

    /**
     * 删除企业清洁生产基础
     */
	@DeleteMapping("/{cleanProduceIds}")
    public AjaxResult remove(@PathVariable List<String> cleanProduceIds) {
        return entCleanProduceService.deleteEntCleanProduceByCleanProduceIds(cleanProduceIds);
    }
}
