package com.ruoyi.air.monitorDataAna.autoMonitorDataAna.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
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
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
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
        params.put("provinceCode","8ebea7a3eec24b0ba1692380f8f74ce2");
        params.put("districtCodes","");
        params.put("districtQuery","0");
        params.put("townCodes","");
        String startTime = "2023-01";
        LocalDate startDate = LocalDate.parse(startTime + "-01");
//        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfYear());
        LocalDate endDate = LocalDate.now();
        params.put("startTime",startDate.format(fmt));
        params.put("endTime",endDate.format(fmt));
        AjaxResult cityResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
        List<ExceGoodDay> nowCityList = JSONObject.parse(cityResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
        params.put("districtCodes","全部");
        params.put("districtQuery","1");
        AjaxResult distResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
        List<ExceGoodDay> nowDistList = JSONObject.parse(distResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
        for (int i = 0; i < nowCityList.size(); i++) {
            ExceGoodDay exceGoodDay = nowCityList.get(i);
            List<ExceGoodDay> dists = nowDistList.stream().filter(d -> {
                return exceGoodDay.getCityName().contains(d.getCityName());
            }).collect(Collectors.toList());
            exceGoodDay.setDists(dists);

        }
        params.put("startTime",startDate.format(fmt));
        params.put("endTime",endDate.format(fmt));
        params.put("districtCodes","");
        params.put("districtQuery","0");
        AjaxResult pastCityResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
        List<ExceGoodDay> pastCityList = JSONObject.parse(pastCityResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
        params.put("districtCodes","全部");
        params.put("districtQuery","1");
        AjaxResult pastDistResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
        List<ExceGoodDay> pastDistList = JSONObject.parse(pastDistResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
        for (int i = 0; i < pastCityList.size(); i++) {
            ExceGoodDay exceGoodDay = pastCityList.get(i);
            List<ExceGoodDay> dists = pastDistList.stream().filter(d -> {
                return exceGoodDay.getCityName().contains(d.getCityName());
            }).collect(Collectors.toList());
            exceGoodDay.setDists(dists);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("now",nowCityList);
        map.put("past",pastCityList);
    }

    //城市优良率统计分析
     @Override
    public AjaxResult getCityExcellenceRateData(HttpServletRequest request,Map<String, Object> params) {
         DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String type = request.getParameter("timeType");
         String startTime = request.getParameter("startTime");
         if ("month".equals(type)){
             LocalDate startDate = LocalDate.parse(startTime + "-01");
             LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
             params.put("startTime",startDate.format(fmt));
             params.put("endTime",endDate.format(fmt));
             AjaxResult cityResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<ExceGoodDay> nowCityList = JSONObject.parse(cityResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
             params.put("districtCodes","全部");
             params.put("districtQuery","1");
             AjaxResult distResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<ExceGoodDay> nowDistList = JSONObject.parse(distResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
             for (int i = 0; i < nowCityList.size(); i++) {
                 ExceGoodDay exceGoodDay = nowCityList.get(i);
                 List<ExceGoodDay> dists = nowDistList.stream().filter(d -> {
                     return exceGoodDay.getCityName().contains(d.getCityName());
                 }).collect(Collectors.toList());
                 exceGoodDay.setDists(dists);
             }
             params.put("startTime",startDate.format(fmt));
             params.put("endTime",endDate.format(fmt));
             params.put("districtCodes","");
             params.put("districtQuery","0");
             AjaxResult pastCityResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<ExceGoodDay> pastCityList = JSONObject.parse(pastCityResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
             params.put("districtCodes","全部");
             params.put("districtQuery","1");
             AjaxResult pastDistResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<ExceGoodDay> pastDistList = JSONObject.parse(pastDistResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
             for (int i = 0; i < pastCityList.size(); i++) {
                 ExceGoodDay exceGoodDay = pastCityList.get(i);
                 List<ExceGoodDay> dists = pastDistList.stream().filter(d -> {
                     return exceGoodDay.getCityName().contains(d.getCityName());
                 }).collect(Collectors.toList());
                 exceGoodDay.setDists(dists);
             }
             Map<String,Object> map = new HashMap<>();
             map.put("now",nowCityList);
             map.put("past",pastCityList);
             return AjaxResult.success(map);
         } else if ("year".equals(type)) {
             LocalDate startDate = LocalDate.parse(startTime + "-01-01");
             LocalDate endDate;
             if (LocalDate.now().getYear() == startDate.getYear()){
                 endDate = LocalDate.now();
             }else {
                 endDate = startDate.with(TemporalAdjusters.lastDayOfYear());
             }
             params.put("startTime",startDate.format(fmt));
             params.put("endTime",endDate.format(fmt));
             AjaxResult cityResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<ExceGoodDay> nowCityList = JSONObject.parse(cityResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
             params.put("districtCodes","全部");
             params.put("districtQuery","1");
             AjaxResult distResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<ExceGoodDay> nowDistList = JSONObject.parse(distResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
             for (int i = 0; i < nowCityList.size(); i++) {
                 ExceGoodDay exceGoodDay = nowCityList.get(i);
                 List<ExceGoodDay> dists = nowDistList.stream().filter(d -> {
                     return exceGoodDay.getCityName().contains(d.getCityName());
                 }).collect(Collectors.toList());
                 exceGoodDay.setDists(dists);
             }
             params.put("startTime",startDate.format(fmt));
             params.put("endTime",endDate.format(fmt));
             params.put("districtCodes","");
             params.put("districtQuery","0");
             AjaxResult pastCityResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<ExceGoodDay> pastCityList = JSONObject.parse(pastCityResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
             params.put("districtCodes","全部");
             params.put("districtQuery","1");
             AjaxResult pastDistResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<ExceGoodDay> pastDistList = JSONObject.parse(pastDistResult.get("msg").toString()).getJSONArray("data").toJavaList(ExceGoodDay.class);
             for (int i = 0; i < pastCityList.size(); i++) {
                 ExceGoodDay exceGoodDay = pastCityList.get(i);
                 List<ExceGoodDay> dists = pastDistList.stream().filter(d -> {
                     return exceGoodDay.getCityName().contains(d.getCityName());
                 }).collect(Collectors.toList());
                 exceGoodDay.setDists(dists);
             }
             Map<String,Object> map = new HashMap<>();
             map.put("now",nowCityList);
             map.put("past",pastCityList);
             return AjaxResult.success(map);
         }else {
             LocalDate startDate = LocalDate.parse(startTime);
             LocalDate endDate = LocalDate.parse(request.getParameter("endTime"));
             params.put("startTime",startDate.format(fmt));
             params.put("endTime",endDate.format(fmt));
             AjaxResult cityResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<JSONObject> cityList = JSONObject.parse(cityResult.get("msg").toString()).getJSONArray("data").toJavaList(JSONObject.class);
             params.put("districtCodes","全部");
             params.put("districtQuery","1");
             AjaxResult distResult = HttpUtils.sendProductPost(CITY_EXCELLENCERATE, params, USERNAME, PASSWORD);
             List<JSONObject> distList = JSONObject.parse(distResult.get("msg").toString()).getJSONArray("data").toJavaList(JSONObject.class);
             for (int i = 0; i < cityList.size(); i++) {
                 JSONObject object = cityList.get(i);
                 List<JSONObject> dists = distList.stream().filter(d -> {
                     return object.get("cityName").toString().contains(d.get("cityName").toString());
                 }).collect(Collectors.toList());
                 object.put("dists",dists);
             }
             return AjaxResult.success(cityList);
         }

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
}
