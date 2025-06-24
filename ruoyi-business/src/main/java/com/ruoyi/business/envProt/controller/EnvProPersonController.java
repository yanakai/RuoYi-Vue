package com.ruoyi.business.envProt.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.envProt.domain.EnvProPerson;
import com.ruoyi.business.envProt.domain.EnvProPersonReq;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.business.envProt.service.EnvProPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 企业环保人员Controller
 */
@RestController
@RequestMapping("/platform/env/person")
public class EnvProPersonController {

    private EnvProPersonService envProPersonService;
    @Autowired
    public void setEnvProPersonService(EnvProPersonService envProPersonService) {
        this.envProPersonService = envProPersonService;
    }

    /**
     * 获取企业环保人员详细信息
     */
    @GetMapping(value = "/{envProPersonId}")
    public AjaxResult getInfo(@PathVariable("envProPersonId") String proPersonId) {
        return envProPersonService.selectProPersonById(proPersonId);
    }

    /**
     * 查询企业环保人员列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) EnvProPersonReq req) {
        return envProPersonService.selectProPersonList(req);
    }

    /**
     * 导出企业环保人员列表
     */
    @PostMapping("/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) EnvProPersonReq req, HttpServletResponse response) {
        envProPersonService.exportProPerson(req, response);
    }

    /**
     * 下载企业环保人员模板
     */
    @GetMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        envProPersonService.downloadTemplate(response);
    }

    /**
     * 导入企业环保人员模板
     */
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate(MultipartFile file) {
        return envProPersonService.importTemplate(file);
    }

    /**
     * 新增企业环保人员
     */
    @PostMapping
    public AjaxResult add(@RequestBody EnvProPerson info) {
        return envProPersonService.insertProPerson(info);
    }

    /**
     * 修改企业环保人员
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EnvProPerson info) {
        return envProPersonService.updateProPerson(info);
    }

    /**
     * 删除企业环保人员
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List<String> ids) {
        return envProPersonService.deleteProPersonByIds(ids);
    }
}
