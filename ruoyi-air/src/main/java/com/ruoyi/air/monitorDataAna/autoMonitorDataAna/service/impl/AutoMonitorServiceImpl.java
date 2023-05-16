package com.ruoyi.air.monitorDataAna.autoMonitorDataAna.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.air.monitorDataAna.autoMonitorDataAna.service.AutoMonitorService;
import com.ruoyi.air.monitorDataAna.autoMonitorDataAna.vo.ExceGoodDay;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;


@Service
@PropertySource("classpath:urls/url.properties")
public class AutoMonitorServiceImpl implements AutoMonitorService {

    @Value("${city_excellencerate}")
    private static String CITY_EXCELLENCERATE = "http://air.mapuni.cn/datacenter/api/v1/data/air/city/general/weather/Month/Year/level";

    private static String STATION_EXCELLENCERATE = "http://air.mapuni.cn/datacenter/api/v1/data/air/station/general/weather/Month/Year/level";

    private static String CALENDAR = "http://air.mapuni.com/datacenter/api2/air/statistics/city/calendar/year";

    private static String LINE = "http://air.mapuni.com/datacenter/api2/air/statistics/city/index/cities/line";

    private static String PRIMARYPOLLUTANT = "http://air.mapuni.com/datacenter/api2/air/statistics/city/primaryPollutant/proportionAnaly";
    @Value("${username}")
    private static String USERNAME = "tempo";
    @Value("${password}")
    private static String PASSWORD = "33bbbb74145b1ad17281a7267cc4999e";

    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Map<String,Object> params = new HashMap<>();
//        params.put("provinceCode","8ebea7a3eec24b0ba1692380f8f74ce2");
        params.put("cityCodes","3ce09c117a5b4cf7a8eb91eac12aa9d9");//合肥市
//        params.put("districtCodes","");
//        params.put("districtQuery","0");
        params.put("startTime","2023-01-01");
        params.put("endTime","2023-01-31");
        AjaxResult cityResult = HttpUtils.sendProductPost("http://air.mapuni.cn/datacenter/api/v1/data/air/city/general/Month/Year/level", params, USERNAME, PASSWORD);
//        List<ExceGoodDay> nowCityList = JSONObject.parse(cityResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
        List<String> strings = JSONObject.parse(cityResult.get("msg").toString()).getJSONArray("data").toJavaList(String.class);


    }

    //城市优良率统计分析
     @Override
    public AjaxResult getCityExcellenceRateData(HttpServletRequest request,Map<String, Object> params) {
        Map<String,Object> map = new HashMap<>();
         DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String type = request.getParameter("timeType");
         String startTime = request.getParameter("startTime");
         if ("month".equals(type)){
             LocalDate startDate = LocalDate.parse(startTime + "-01");
             LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
             params.put("startTime",startDate.format(fmt));
             params.put("endTime",endDate.format(fmt));
             //本期数据
             List<ExceGoodDay> now = getCityGoodExce(params);
             map.put("benqi",now);
             //同期数据
             LocalDate pastStart = startDate.minusYears(1L);
             LocalDate pastEnd = endDate.minusYears(1L);
             params.put("startTime",pastStart);
             params.put("endTime",pastEnd);
             List<ExceGoodDay> past = getCityGoodExce(params);
             map.put("tongqi",past);
         } else if ("year".equals(type)) {
             LocalDate startDate = LocalDate.parse(startTime + "-01-01");
             LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfYear());
             params.put("startTime",startDate.format(fmt));
             params.put("endTime",endDate.format(fmt));
             //本期数据
             List<ExceGoodDay> now = getCityGoodExce(params);
             map.put("benqi",now);
             //同期数据
             LocalDate pastStart = startDate.minusYears(1L);
             LocalDate pastEnd = endDate.minusYears(1L);
             params.put("startTime",pastStart);
             params.put("endTime",pastEnd);
             List<ExceGoodDay> past = getCityGoodExce(params);
             map.put("tongqi",past);
         }else {
             //TODO 累计
             List<ExceGoodDay> now = getCityGoodExce(params);
             map.put("leiji",now);
         }
         return AjaxResult.success(map);
    }
    private List<ExceGoodDay> getCityGoodExce(Map<String, Object> params){
        //区县查询
        AjaxResult ajaxResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
        List<ExceGoodDay> list = JSONObject.parse(ajaxResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);

        if (String.valueOf(params.get("districtCodes")) != null && "".equals(String.valueOf(params.get("districtCodes")))){
            //说明上次查询为区县数据，这里查询合肥市数据
            params.put("districtCodes","");
            params.put("districtQuery","0");
            AjaxResult cityResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
            List<ExceGoodDay> cityList = JSONObject.parse(cityResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
            list.add(cityList.get(0));
        }
        return list;
    }

    //站点优良率统计分析
    public AjaxResult getStationExcellenceRateData(HttpServletRequest request,Map<String, Object> params) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String type = request.getParameter("timeType");
        String startTime = request.getParameter("startTime");

        return AjaxResult.success();
    }


    //空气质量日历
    @Override
    public AjaxResult getCalendar(Map<String, String> params) {
        String token = HttpUtils.getProductToken(USERNAME, PASSWORD);
        return AjaxResult.success(HttpUtils.sendProductPost(CALENDAR, params, token));
    }

    @Override
    public AjaxResult getStationExcellenceRateData(Map<String, String> params) {

        return null;
    }

    @Override
    public AjaxResult getAnalysisOfPollutant(Map<String, String> params) {
        String token = HttpUtils.getProductToken(USERNAME, PASSWORD);

        return AjaxResult.success(HttpUtils.sendProductPost(LINE,params,token));
    }

    @Override
    public AjaxResult getPrimaryPollutant(Map<String, String> params) {
        String token = HttpUtils.getProductToken(USERNAME, PASSWORD);
        HttpUtils.sendProductPost(PRIMARYPOLLUTANT,params,token);
        return AjaxResult.success();
    }

    //全国空气质量排名分析
    @Override
    public AjaxResult getOrder(Map<String, Object> params) {
        String token = HttpUtils.getProductToken(USERNAME, PASSWORD);
        return AjaxResult.success(HttpUtils.sendProductPost("http://air.mapuni.com/datacenter/api2/air/statistics/city/national/order", params, token));
    }
}
