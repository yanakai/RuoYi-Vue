package com.ruoyi.business.envProt.controller;

import com.ruoyi.business.envProt.domain.EntOutPollutantPermit;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitCount;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitCountReq;
import com.ruoyi.business.envProt.domain.EntOutPollutantPermitReq;
import com.ruoyi.business.envProt.service.EntOutPollutantPermitService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 企业排污许可基础Controller
 */
@RestController
@RequestMapping("/platform/envProt/entOutPollutantPermit")
public class EntOutPollutantPermitController {

    private EntOutPollutantPermitService entOutPollutantPermitService;
    @Autowired
    public void setEntOutPollutantPermitService(EntOutPollutantPermitService entOutPollutantPermitService) {
        this.entOutPollutantPermitService = entOutPollutantPermitService;
    }

    /**
     * 查询企业排污许可基础列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) EntOutPollutantPermitReq req) {
        return entOutPollutantPermitService.selectEntOutPollutantPermitList(req);
    }

    /**
     * 导出企业排污许可基础列表
     */
    @PostMapping("/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) EntOutPollutantPermitReq req, HttpServletResponse response) {
        entOutPollutantPermitService.exportEntOutPollutantPermit(req, response);
    }

    /**
     * 新增企业排污许可基础
     */
    @PostMapping
    public AjaxResult add(@RequestBody EntOutPollutantPermit permit) {
        return entOutPollutantPermitService.insertEntOutPollutantPermit(permit);
    }

    /**
     * 修改企业排污许可基础
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EntOutPollutantPermit permit) {
        return entOutPollutantPermitService.updateEntOutPollutantPermit(permit);
    }

    /**
     * 删除企业排污许可基础
     */
	@DeleteMapping("/{pollPermitIds}")
    public AjaxResult remove(@PathVariable List<String> pollPermitIds) {
        return entOutPollutantPermitService.deleteEntOutPollutantPermitByPollPermitIds(pollPermitIds);
    }

    /**
     * 查询企业排污许可总量数据
     */
    @PostMapping("/count/list")
    public AjaxResult countList(@RequestBody(required = false) EntOutPollutantPermitCountReq req) {
        return entOutPollutantPermitService.selectEntOutPollutantPermitCountList(req);
    }

    /**
     * 导出企业排污许可总量数据
     */
    @PostMapping("/count/exportTemplate")
    public void countExportTemplate(@RequestBody(required = false) EntOutPollutantPermitCountReq req, HttpServletResponse response) {
        entOutPollutantPermitService.exportEntOutPollutantPermitCount(req, response);
    }

    /**
     * 新增企业排污许可总量数据
     */
    @PostMapping("/count")
    public AjaxResult countAdd(@RequestBody EntOutPollutantPermitCount count) {
        return entOutPollutantPermitService.insertEntOutPollutantPermitCount(count);
    }

    /**
     * 修改企业排污许可总量数据
     */
    @PutMapping("/count")
    public AjaxResult countEdit(@RequestBody EntOutPollutantPermitCount count) {
        return entOutPollutantPermitService.updateEntOutPollutantPermitCount(count);
    }

    /**
     * 删除企业排污许可总量数据
     */
    @DeleteMapping("/count/{pollPermitTotalIds}")
    public AjaxResult countRemove(@PathVariable List<String> pollPermitTotalIds) {
        return entOutPollutantPermitService.deleteEntOutPollutantPermitCountByPollPermitIds(pollPermitTotalIds);
    }
}
