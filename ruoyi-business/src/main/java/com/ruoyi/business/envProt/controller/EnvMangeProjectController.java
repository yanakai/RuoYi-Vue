package com.ruoyi.business.envProt.controller;

import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.envProt.domain.EnvMangeProject;
import com.ruoyi.business.envProt.domain.EnvMangeReq;
import com.ruoyi.business.envProt.service.EnvMangeProjectService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 企业环评环保管理-项目Controller
 */
@RestController
@RequestMapping("/platform/manager/project")
public class EnvMangeProjectController {

    private EnvMangeProjectService envMangeProjectService;
    @Autowired
    public void setEnvMangeProjectService(EnvMangeProjectService envMangeProjectService) {
        this.envMangeProjectService = envMangeProjectService;
    }

    /**
     * 查询企业环评环保管理-项目列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) EnvMangeReq req) {
        return envMangeProjectService.selectMangeProjectList(req);
    }

    /**
     * 导出企业环评环保管理-项目列表
     */
    @PostMapping("/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) EnvMangeReq req, HttpServletResponse response) {
        envMangeProjectService.exportMangeProject(req, response);
    }

    /**
     * 导出企业环评环保管理-项目详情
     * 单个导出时会同步导出对应的环评及环保验收信息
     */
    @GetMapping("/exportSingle/{id}")
    public void exportTemplateSingle(@PathVariable("id") String id, HttpServletResponse response) {
        envMangeProjectService.exportMangeProjectById(id, response);
    }

    /**
     * 新增企业环评环保管理-项目
     */
    @PostMapping
    public AjaxResult add(@RequestBody EnvMangeProject info) {
        return envMangeProjectService.insertMangeProject(info);
    }

    /**
     * 修改企业环评环保管理-项目
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EnvMangeProject info) {
        return envMangeProjectService.updateMangeProject(info);
    }

    /**
     * 删除企业环评环保管理-项目
     */
	@DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable("id") String id) {
        return envMangeProjectService.deleteMangeProjectById(id);
    }
}
