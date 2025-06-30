package com.ruoyi.business.envProt.controller;

import com.ruoyi.business.envProt.domain.EnvMangeCheck;
import com.ruoyi.business.envProt.domain.EnvMangeReq;
import com.ruoyi.business.envProt.service.EnvMangeCheckService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 企业环评环保管理-环保验收Controller
 */
@RestController
@RequestMapping("/platform/manager/check")
public class EnvMangeCheckController {

    private EnvMangeCheckService envMangeCheckService;
    @Autowired
    public void setEnvMangeCheckService(EnvMangeCheckService envMangeCheckService) {
        this.envMangeCheckService = envMangeCheckService;
    }

    /**
     * 查询企业环评环保管理-环保验收列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) EnvMangeReq req) {
        return envMangeCheckService.selectMangeCheckList(req);
    }

    /**
     * 新增企业环评环保管理-环保验收
     */
    @PostMapping
    public AjaxResult add(@RequestBody EnvMangeCheck info) {
        return envMangeCheckService.insertMangeCheck(info);
    }

    /**
     * 修改企业环评环保管理-环保验收
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EnvMangeCheck info) {
        return envMangeCheckService.updateMangeCheck(info);
    }

    /**
     * 删除企业环评环保管理-环保验收
     */
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable("id") String id) {
        return envMangeCheckService.deleteMangeCheckById(id);
    }
}
