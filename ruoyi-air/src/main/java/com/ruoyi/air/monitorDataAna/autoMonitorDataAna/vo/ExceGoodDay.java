package com.ruoyi.air.monitorDataAna.autoMonitorDataAna.vo;

import java.util.List;

public class ExceGoodDay {

    private String cityCode;
    private String cityName;
    private String districtName;
    private String districtCode;
    private Integer monthKey;
    private Integer yearKey;
    private Integer dayKey;
    private AqiW aqiW;

    private List<ExceGoodDay> dists;

    public ExceGoodDay() {
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Integer getMonthKey() {
        return monthKey;
    }

    public void setMonthKey(Integer monthKey) {
        this.monthKey = monthKey;
    }

    public Integer getYearKey() {
        return yearKey;
    }

    public void setYearKey(Integer yearKey) {
        this.yearKey = yearKey;
    }

    public Integer getDayKey() {
        return dayKey;
    }

    public void setDayKey(Integer dayKey) {
        this.dayKey = dayKey;
    }

    public AqiW getAqiW() {
        return aqiW;
    }

    public void setAqiW(AqiW aqiW) {
        this.aqiW = aqiW;
    }

    public List<ExceGoodDay> getDists() {
        return dists;
    }

    public void setDists(List<ExceGoodDay> dists) {
        this.dists = dists;
    }

    @Override
    public String toString() {
        return "ExceGoodDay{" +
                "cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", monthKey=" + monthKey +
                ", yearKey=" + yearKey +
                ", dayKey=" + dayKey +
                ", aqiW=" + aqiW +
                '}';
    }
}
