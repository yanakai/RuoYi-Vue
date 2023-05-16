package com.ruoyi.coordination.clue.domain;

//预警规则
public class WarnRule {

    private String pollutionFactor;
    private String contrastType;
    private Long fixedValue;
    private Long upperLimit;
    private Long lowerLimit;
    private String contrastStation;
    private String warningMultiple;

    private String quarter;

    public String getPollutionFactor() {
        return pollutionFactor;
    }

    public void setPollutionFactor(String pollutionFactor) {
        this.pollutionFactor = pollutionFactor;
    }

    public String getContrastType() {
        return contrastType;
    }

    public void setContrastType(String contrastType) {
        this.contrastType = contrastType;
    }

    public Long getFixedValue() {
        return fixedValue;
    }

    public void setFixedValue(Long fixedValue) {
        this.fixedValue = fixedValue;
    }

    public Long getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Long upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Long getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Long lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public String getContrastStation() {
        return contrastStation;
    }

    public void setContrastStation(String contrastStation) {
        this.contrastStation = contrastStation;
    }

    public String getWarningMultiple() {
        return warningMultiple;
    }

    public void setWarningMultiple(String warningMultiple) {
        this.warningMultiple = warningMultiple;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    @Override
    public String toString() {
        return "WarnRule{" +
                ", pollutionFactor='" + pollutionFactor + '\'' +
                ", contrastType='" + contrastType + '\'' +
                ", fixedValue=" + fixedValue +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                ", contrastStation='" + contrastStation + '\'' +
                ", warningMultiple='" + warningMultiple + '\'' +
                ", quarter='" + quarter + '\'' +
                '}';
    }
}
