package com.ruoyi.business.statisticsAlarm.controller;

import com.ruoyi.business.statisticsAlarm.domain.EntAnnualOutputInfoReq;
import com.ruoyi.business.statisticsAlarm.service.EntAnnualOutputInfoService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 企业年排量信息记录Controller
 */
@RestController
@RequestMapping("/business/annulOutput")
public class EntAnnualOutputInfoController {

    private EntAnnualOutputInfoService entAnnualOutputInfoService;
    @Autowired
    public void setEntAnnualOutputInfoService(EntAnnualOutputInfoService entAnnualOutputInfoService) {
        this.entAnnualOutputInfoService = entAnnualOutputInfoService;
    }

    /**
     * 查询企业年排量信息报警记录列表
     */
    @PostMapping("/alarm/list")
    public AjaxResult list(@RequestBody(required = false) EntAnnualOutputInfoReq req) {
        return entAnnualOutputInfoService.selectEntAnnualOutputInfoList(req);
    }

    /**
     * 导出企业年排量信息报警记录列表
     * 按模版导出
     */
    @PostMapping("/alarm/exportTemplate")
    public void exportTemplate(@RequestBody(required = false) EntAnnualOutputInfoReq req, HttpServletResponse response) {
        entAnnualOutputInfoService.exportEntAnnualOutputInfo(req, response);
    }
}
