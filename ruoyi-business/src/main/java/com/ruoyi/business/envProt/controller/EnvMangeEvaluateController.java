package com.ruoyi.business.envProt.controller;

import com.ruoyi.business.envProt.domain.EnvMangeEvaluate;
import com.ruoyi.business.envProt.service.EnvMangeEvaluateService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 企业环评环保管理-环评Controller
 */
@RestController
@RequestMapping("/platform/manager/evaluate")
public class EnvMangeEvaluateController {

    private EnvMangeEvaluateService envMangeEvaluateService;
    @Autowired
    public void setEnvMangeEvaluateService(EnvMangeEvaluateService envMangeEvaluateService) {
        this.envMangeEvaluateService = envMangeEvaluateService;
    }

    /**
     * 查询企业环评环保管理-环评列表
     */
    @GetMapping("/list/{mProjectId}")
    public AjaxResult list(@PathVariable("mProjectId") String mProjectId) {
        return envMangeEvaluateService.selectMangeEvaluateList(mProjectId);
    }

    /**
     * 新增企业环评环保管理-环评
     */
    @PostMapping
    public AjaxResult add(@RequestBody EnvMangeEvaluate info) {
        return envMangeEvaluateService.insertMangeEvaluate(info);
    }

    /**
     * 修改企业环评环保管理-环评
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EnvMangeEvaluate info) {
        return envMangeEvaluateService.updateMangeEvaluate(info);
    }

    /**
     * 删除企业环评环保管理-环评
     */
	@DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable("id") String id) {
        return envMangeEvaluateService.deleteMangeEvaluateById(id);
    }
}
