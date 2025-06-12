package com.ruoyi.business.statisticsAlarm.service;

import com.ruoyi.business.statisticsAlarm.domain.EntAnnualOutputInfoReq;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletResponse;

/**
 * 企业年排量信息记录Service接口
 * 
 * @author ruoyi
 * @date 2025-06-12
 */
public interface EntAnnualOutputInfoService {

    /**
     * 查询企业年排量信息报警记录列表
     */
    AjaxResult selectEntAnnualOutputInfoList(EntAnnualOutputInfoReq req);

    /**
     * 导出企业年排量信息报警记录列表
     * 按模版导出
     */
    void exportEntAnnualOutputInfo(EntAnnualOutputInfoReq req, HttpServletResponse response);
}
