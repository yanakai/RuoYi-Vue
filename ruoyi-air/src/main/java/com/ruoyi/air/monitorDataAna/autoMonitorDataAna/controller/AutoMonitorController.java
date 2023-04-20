package com.ruoyi.air.monitorDataAna.autoMonitorDataAna.controller;


import com.ruoyi.air.monitorDataAna.autoMonitorDataAna.service.AutoMonitorService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auto")
public class AutoMonitorController {

    @Autowired
    private AutoMonitorService autoMonitorService;

    private static Map<String,Object> params;

    static {
        params = new HashMap<>();
        params.put("provinceCode","8ebea7a3eec24b0ba1692380f8f74ce2");
        params.put("districtCodes","");
        params.put("districtQuery","0");
        params.put("townCodes","");
    }

    //城市优良率统计
    @RequestMapping("/excellenceRate")
    public AjaxResult getExcellenceRateData(HttpServletRequest request){
            if ("city".equals(request.getParameter("type"))){

            }else {

            }
            return autoMonitorService.getCityExcellenceRateData(request,params);
    }

    //空气质量日历
    @RequestMapping("/calendar")
    public AjaxResult getCalendar(HttpServletRequest request, HttpServletResponse response,Map<String, String> params){
        /*{
                "provinceCode": "8ebea7a3eec24b0ba1692380f8f74ce2",
                "cityCodes": "3ce09c117a5b4cf7a8eb91eac12aa9d9",
                "districtCodes": "",
                "townCodes": "",
                "time": 2023,
                "index": "PM2.5",
                "districtQuery": 0
        }*/
        return autoMonitorService.getCalendar(params);
    }

    //污染物浓度变化分析
    @RequestMapping("/analysisOfPollutant")
    public AjaxResult getAnalysisOfPollutant(HttpServletRequest request, HttpServletResponse response,Map<String, String> params) {
        /*{
            "provinceCode": "8ebea7a3eec24b0ba1692380f8f74ce2", 省份
                "cityCodes": "286ff5d8ee274250b06c5ea01f391b45,b1428c0277b3480587477e3131cad2c0,3ce09c117a5b4cf7a8eb91eac12aa9d9", 城市
                "districtCodes": "全部",  区县
                "townCodes": "", 乡镇
                "index": "PM2.5", 污染因子
                "type": "hour", 小时
                "time": "",
                "startTime": "2023-04-01",
                "endTime": "2023-04-13",
                "districtQuery": 0
        }*/
        return autoMonitorService.getAnalysisOfPollutant(params);
    }

    //首要污染物统计分析
    @RequestMapping("/primaryPollutant")
    public AjaxResult getPrimaryPollutant(HttpServletRequest request, HttpServletResponse response) {
        /*{
            "provinceCode": "8ebea7a3eec24b0ba1692380f8f74ce2",
                "cityCodes": "3ce09c117a5b4cf7a8eb91eac12aa9d9",
                "districtCodes": "",
                "townCodes": "",
                "districtQuery": 0,
                "type": "daily",
                "dataType": 1,
                "startTime": "2023-04-01",
                "endTime": "2023-04-13"
        }*/
        Map<String, String[]> map = request.getParameterMap();
        Map<String, String> params = new HashMap<>();
        for (String s : map.keySet()) {
            params.put(s,String.join(",", map.get(s)));
        }
        return autoMonitorService.getPrimaryPollutant(params);
    }
}
