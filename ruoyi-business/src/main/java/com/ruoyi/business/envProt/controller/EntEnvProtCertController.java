package com.ruoyi.business.envProt.controller;

import com.ruoyi.business.envProt.domain.EntEnvProtCert;
import com.ruoyi.business.envProt.domain.EntEnvProtCertReq;
import com.ruoyi.business.envProt.service.EntEnvProtCertService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业环保证书基础Controller
 */
@RestController
@RequestMapping("/platform/envProt/entEnvProtCert")
public class EntEnvProtCertController {

    private EntEnvProtCertService entEnvProtCertService;
    @Autowired
    public void setEntEnvProtCertService(EntEnvProtCertService entEnvProtCertService) {
        this.entEnvProtCertService = entEnvProtCertService;
    }

    /**
     * 查询企业环保证书基础列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) EntEnvProtCertReq req) {
        return entEnvProtCertService.selectEntEnvProtCertList(req);
    }

    /**
     * 导出企业环保证书基础列表
     */
    @PostMapping("/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) EntEnvProtCertReq req, HttpServletResponse response) {
        entEnvProtCertService.exportEntEnvProtCert(req, response);
    }

    /**
     * 新增企业环保证书基础
     */
    @PostMapping
    public AjaxResult add(@RequestBody EntEnvProtCert cert) {
        return entEnvProtCertService.insertEntEnvProtCert(cert);
    }

    /**
     * 修改企业环保证书基础
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EntEnvProtCert cert) {
        return entEnvProtCertService.updateEntEnvProtCert(cert);
    }

    /**
     * 删除企业环保证书基础
     */
	@DeleteMapping("/{protCertIds}")
    public AjaxResult remove(@PathVariable List<String> protCertIds) {
        return entEnvProtCertService.deleteEntEnvProtCertByProtCertIds(protCertIds);
    }
}
