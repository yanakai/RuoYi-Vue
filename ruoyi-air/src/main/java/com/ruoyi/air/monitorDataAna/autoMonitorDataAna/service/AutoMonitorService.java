package com.ruoyi.air.monitorDataAna.autoMonitorDataAna.service;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface AutoMonitorService {

    //站点优良率统计分析
    AjaxResult getCityExcellenceRateData(HttpServletRequest request,Map<String, Object> params);

    AjaxResult getCalendar(Map<String, String> params);

    AjaxResult getStationExcellenceRateData(Map<String, String> params);

    AjaxResult getAnalysisOfPollutant(Map<String, String> params);

    AjaxResult getPrimaryPollutant(Map<String, String> params);
}
