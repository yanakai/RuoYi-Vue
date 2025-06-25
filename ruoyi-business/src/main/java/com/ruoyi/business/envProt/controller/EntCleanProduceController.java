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
     * 查询企业清洁生产详情
     */
    @GetMapping(value = "/{cleanProduceId}")
    public AjaxResult getInfo(@PathVariable("cleanProduceId") String cleanProduceId) {
        return entCleanProduceService.selectCleanProduceById(cleanProduceId);
    }

    /**
     * 查询企业清洁生产基础列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) EntCleanProduceReq req) {
        return entCleanProduceService.selectCleanProduceList(req);
    }

    /**
     * 导出企业清洁生产基础列表
     */
    @PostMapping("/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) EntCleanProduceReq req, HttpServletResponse response) {
        entCleanProduceService.exportCleanProduce(req, response);
    }

    /**
     * 新增企业清洁生产基础
     */
    @PostMapping
    public AjaxResult add(@RequestBody EntCleanProduce clean) {
        return entCleanProduceService.insertCleanProduce(clean);
    }

    /**
     * 修改企业清洁生产基础
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EntCleanProduce clean) {
        return entCleanProduceService.updateCleanProduce(clean);
    }

    /**
     * 删除企业清洁生产基础
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List<String> ids) {
        return entCleanProduceService.deleteCleanProduceByIds(ids);
    }
}
