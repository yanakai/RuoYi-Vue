package com.ruoyi.air.monitorDataAna.autoMonitorDataAna.vo;

public class AqiW {

    private Integer goodDays; //优良天数
    private Integer heavyPollutionDays; //重污染天数
    private Integer pollutionLevel; //有效天数
    private Integer pollutionLevelOneDays; //优天数
    private Integer pollutionLevelTwoDays; //良天数
    private Integer pollutionLevelThreeDays; //轻度污染天数
    private Integer pollutionLevelFourDays; //中度污染天数
    private Integer pollutionLevelFiveDays; //重度污染天数
    private Integer pollutionLevelSixDays; //严重污染天数
    private Integer days; //总天数
    private Double excellenceRate; //优率
    private Double goodRate; //良率
    private Double excellentRate; //优良率







    public AqiW() {
    }


    public Integer getGoodDays() {
        return goodDays;
    }

    public void setGoodDays(Integer goodDays) {
        this.goodDays = goodDays;
    }

    public Integer getHeavyPollutionDays() {
        return heavyPollutionDays;
    }

    public void setHeavyPollutionDays(Integer heavyPollutionDays) {
        this.heavyPollutionDays = heavyPollutionDays;
    }

    public Integer getPollutionLevel() {
        return pollutionLevel;
    }

    public void setPollutionLevel(Integer pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }

    public Integer getPollutionLevelOneDays() {
        return pollutionLevelOneDays;
    }

    public void setPollutionLevelOneDays(Integer pollutionLevelOneDays) {
        this.pollutionLevelOneDays = pollutionLevelOneDays;
    }

    public Integer getPollutionLevelTwoDays() {
        return pollutionLevelTwoDays;
    }

    public void setPollutionLevelTwoDays(Integer pollutionLevelTwoDays) {
        this.pollutionLevelTwoDays = pollutionLevelTwoDays;
    }

    public Integer getPollutionLevelThreeDays() {
        return pollutionLevelThreeDays;
    }

    public void setPollutionLevelThreeDays(Integer pollutionLevelThreeDays) {
        this.pollutionLevelThreeDays = pollutionLevelThreeDays;
    }

    public Integer getPollutionLevelFourDays() {
        return pollutionLevelFourDays;
    }

    public void setPollutionLevelFourDays(Integer pollutionLevelFourDays) {
        this.pollutionLevelFourDays = pollutionLevelFourDays;
    }

    public Integer getPollutionLevelFiveDays() {
        return pollutionLevelFiveDays;
    }

    public void setPollutionLevelFiveDays(Integer pollutionLevelFiveDays) {
        this.pollutionLevelFiveDays = pollutionLevelFiveDays;
    }

    public Integer getPollutionLevelSixDays() {
        return pollutionLevelSixDays;
    }

    public void setPollutionLevelSixDays(Integer pollutionLevelSixDays) {
        this.pollutionLevelSixDays = pollutionLevelSixDays;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getExcellenceRate() {
        return excellenceRate;
    }

    public void setExcellenceRate(Double excellenceRate) {
        this.excellenceRate = excellenceRate;
    }

    public Double getGoodRate() {
        return goodRate;
    }

    public void setGoodRate(Double goodRate) {
        this.goodRate = goodRate;
    }

    public Double getExcellentRate() {
        return excellentRate;
    }

    public void setExcellentRate(Double excellentRate) {
        this.excellentRate = excellentRate;
    }

    @Override
    public String toString() {
        return "AqiW{" +
                "goodDays=" + goodDays +
                ", heavyPollutionDays=" + heavyPollutionDays +
                ", pollutionLevel=" + pollutionLevel +
                ", pollutionLevelOneDays=" + pollutionLevelOneDays +
                ", pollutionLevelTwoDays=" + pollutionLevelTwoDays +
                ", pollutionLevelThreeDays=" + pollutionLevelThreeDays +
                ", pollutionLevelFourDays=" + pollutionLevelFourDays +
                ", pollutionLevelFiveDays=" + pollutionLevelFiveDays +
                ", pollutionLevelSixDays=" + pollutionLevelSixDays +
                '}';
    }
}
