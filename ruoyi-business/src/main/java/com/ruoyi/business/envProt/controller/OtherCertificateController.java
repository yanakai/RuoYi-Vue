package com.ruoyi.business.envProt.controller;

import com.zkhf.epmis.core.domain.AjaxResult;
import com.zkhf.epmis.platform.envProt.domain.OtherCertificate;
import com.zkhf.epmis.platform.envProt.domain.OtherCertificateReq;
import com.zkhf.epmis.platform.envProt.service.OtherCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 其他证书Controller
 */
@RestController
@RequestMapping("/platform/other/cert")
public class OtherCertificateController {

    private OtherCertificateService otherCertificateService;
    @Autowired
    public void setOtherCertificateService(OtherCertificateService otherCertificateService) {
        this.otherCertificateService = otherCertificateService;
    }

    /**
     * 查询其他证书详情
     */
    @GetMapping(value = "/{otherId}")
    public AjaxResult getInfo(@PathVariable("otherId") String otherId) {
        return otherCertificateService.selectOtherCertificateById(otherId);
    }

    /**
     * 查询其他证书列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) OtherCertificateReq req) {
        return otherCertificateService.selectOtherCertificateList(req);
    }

    /**
     * 导出其他证书列表
     */
    @PostMapping("/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) OtherCertificateReq req, HttpServletResponse response) {
        otherCertificateService.exportOtherCertificate(req, response);
    }

    /**
     * 新增其他证书
     */
    @PostMapping
    public AjaxResult add(@RequestBody OtherCertificate info) {
        return otherCertificateService.insertOtherCertificate(info);
    }

    /**
     * 修改其他证书
     */
    @PutMapping
    public AjaxResult edit(@RequestBody OtherCertificate info) {
        return otherCertificateService.updateOtherCertificate(info);
    }

    /**
     * 批量删除其他证书
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List<String> ids) {
        return otherCertificateService.deleteOtherCertificateByIds(ids);
    }
}
