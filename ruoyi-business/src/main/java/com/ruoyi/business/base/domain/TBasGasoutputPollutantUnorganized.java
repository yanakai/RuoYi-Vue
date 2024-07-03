package com.ruoyi.business.base.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 基础信息--企业--废气无组织排口污染物信息对象 t_bas_gasoutput_pollutant_unorganized
 *
 * @author lx
 * @date 2024-07-04
 */
public class TBasGasoutputPollutantUnorganized extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 废气污染物编码（hj-2017协议）
     */
    @Excel(name = "废气污染物编码", readConverterExp = "h=j-2017协议")
    private String pollutantCode;

    /**
     * 废气污染物名称中文
     */
    @Excel(name = "废气污染物名称中文")
    private String pollutantNameCn;

    /**
     * 废气污染物名称英文
     */
    @Excel(name = "废气污染物名称英文")
    private String pollutantNameEn;

    /**
     * mn号
     */
    @Excel(name = "mn号")
    private String mnNum;

    /**
     * 废气排放口编码
     */
    @Excel(name = "废气排放口编码")
    private String outPutCode;

    /**
     * 废气排放口名称
     */
    @Excel(name = "废气排放口名称")
    private String outPutName;

    /**
     * 企业编码
     */
    @Excel(name = "企业编码")
    private String entCode;

    /**
     * 企业名称
     */
    @Excel(name = "企业名称")
    private String entName;

    /**
     * 数据来源
     */
    @Excel(name = "数据来源")
    private String dataSource;

    /**
     * 污染物单位--中文
     */
    @Excel(name = "污染物单位--中文")
    private String pollutantUnitCn;

    /**
     * 污染物单位--英文
     */
    @Excel(name = "污染物单位--英文")
    private String pollutantUnitEn;

    /**
     * 排序码
     */
    @Excel(name = "排序码")
    private Long pollutantSort;

    /**
     * 报警类型：1：区间值报警；2：上限报警；3：下限报警；
     */
    @Excel(name = "报警类型：1：区间值报警；2：上限报警；3：下限报警；")
    private Long alarmType;

    /**
     * 是否零值报警 0：否；1：是
     */
    @Excel(name = "是否零值报警 0：否；1：是")
    private Long isZeroAlarm;

    /**
     * 是否连续值报警：0：否；1：是
     */
    @Excel(name = "是否连续值报警：0：否；1：是")
    private Long isContinuityAlarm;

    /**
     * 标准值--预留字段
     */
    @Excel(name = "标准值--预留字段")
    private BigDecimal standardVal;

    /**
     * 报警上限--预留字段
     */
    @Excel(name = "报警上限--预留字段")
    private BigDecimal earlyWarnMaxvalue;

    /**
     * 报警下限--预留字段
     */
    @Excel(name = "报警下限--预留字段")
    private BigDecimal earlyWarnMinvalue;

    /**
     * 超标上限--当alarmType=1时区间上限；当为3时上线报警的最大值
     */
    @Excel(name = "超标上限--当alarmType=1时区间上限；当为3时上线报警的最大值")
    private BigDecimal overMaxvalue;

    /**
     * 超标下限--当alarmType=1时区间下限；当为4时上限报警的最小值
     */
    @Excel(name = "超标下限--当alarmType=1时区间下限；当为4时上限报警的最小值")
    private BigDecimal overMinvalue;

    /**
     * 异常上限--预留字段
     */
    @Excel(name = "异常上限--预留字段")
    private BigDecimal exceptionMaxvalue;

    /**
     * 异常下限--预留字段
     */
    @Excel(name = "异常下限--预留字段")
    private BigDecimal exceptionMinvalue;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String createName;

    /**
     * 修改人
     */
    @Excel(name = "修改人")
    private String updateName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPollutantCode() {
        return pollutantCode;
    }

    public void setPollutantCode(String pollutantCode) {
        this.pollutantCode = pollutantCode;
    }

    public String getPollutantNameCn() {
        return pollutantNameCn;
    }

    public void setPollutantNameCn(String pollutantNameCn) {
        this.pollutantNameCn = pollutantNameCn;
    }

    public String getPollutantNameEn() {
        return pollutantNameEn;
    }

    public void setPollutantNameEn(String pollutantNameEn) {
        this.pollutantNameEn = pollutantNameEn;
    }

    public String getMnNum() {
        return mnNum;
    }

    public void setMnNum(String mnNum) {
        this.mnNum = mnNum;
    }

    public String getOutPutCode() {
        return outPutCode;
    }

    public void setOutPutCode(String outPutCode) {
        this.outPutCode = outPutCode;
    }

    public String getOutPutName() {
        return outPutName;
    }

    public void setOutPutName(String outPutName) {
        this.outPutName = outPutName;
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getPollutantUnitCn() {
        return pollutantUnitCn;
    }

    public void setPollutantUnitCn(String pollutantUnitCn) {
        this.pollutantUnitCn = pollutantUnitCn;
    }

    public String getPollutantUnitEn() {
        return pollutantUnitEn;
    }

    public void setPollutantUnitEn(String pollutantUnitEn) {
        this.pollutantUnitEn = pollutantUnitEn;
    }

    public Long getPollutantSort() {
        return pollutantSort;
    }

    public void setPollutantSort(Long pollutantSort) {
        this.pollutantSort = pollutantSort;
    }

    public Long getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Long alarmType) {
        this.alarmType = alarmType;
    }

    public Long getIsZeroAlarm() {
        return isZeroAlarm;
    }

    public void setIsZeroAlarm(Long isZeroAlarm) {
        this.isZeroAlarm = isZeroAlarm;
    }

    public Long getIsContinuityAlarm() {
        return isContinuityAlarm;
    }

    public void setIsContinuityAlarm(Long isContinuityAlarm) {
        this.isContinuityAlarm = isContinuityAlarm;
    }

    public BigDecimal getStandardVal() {
        return standardVal;
    }

    public void setStandardVal(BigDecimal standardVal) {
        this.standardVal = standardVal;
    }

    public BigDecimal getEarlyWarnMaxvalue() {
        return earlyWarnMaxvalue;
    }

    public void setEarlyWarnMaxvalue(BigDecimal earlyWarnMaxvalue) {
        this.earlyWarnMaxvalue = earlyWarnMaxvalue;
    }

    public BigDecimal getEarlyWarnMinvalue() {
        return earlyWarnMinvalue;
    }

    public void setEarlyWarnMinvalue(BigDecimal earlyWarnMinvalue) {
        this.earlyWarnMinvalue = earlyWarnMinvalue;
    }

    public BigDecimal getOverMaxvalue() {
        return overMaxvalue;
    }

    public void setOverMaxvalue(BigDecimal overMaxvalue) {
        this.overMaxvalue = overMaxvalue;
    }

    public BigDecimal getOverMinvalue() {
        return overMinvalue;
    }

    public void setOverMinvalue(BigDecimal overMinvalue) {
        this.overMinvalue = overMinvalue;
    }

    public BigDecimal getExceptionMaxvalue() {
        return exceptionMaxvalue;
    }

    public void setExceptionMaxvalue(BigDecimal exceptionMaxvalue) {
        this.exceptionMaxvalue = exceptionMaxvalue;
    }

    public BigDecimal getExceptionMinvalue() {
        return exceptionMinvalue;
    }

    public void setExceptionMinvalue(BigDecimal exceptionMinvalue) {
        this.exceptionMinvalue = exceptionMinvalue;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("pollutantCode", getPollutantCode())
                .append("pollutantNameCn", getPollutantNameCn())
                .append("pollutantNameEn", getPollutantNameEn())
                .append("mnNum", getMnNum())
                .append("outPutCode", getOutPutCode())
                .append("outPutName", getOutPutName())
                .append("entCode", getEntCode())
                .append("entName", getEntName())
                .append("dataSource", getDataSource())
                .append("pollutantUnitCn", getPollutantUnitCn())
                .append("pollutantUnitEn", getPollutantUnitEn())
                .append("pollutantSort", getPollutantSort())
                .append("alarmType", getAlarmType())
                .append("isZeroAlarm", getIsZeroAlarm())
                .append("isContinuityAlarm", getIsContinuityAlarm())
                .append("standardVal", getStandardVal())
                .append("earlyWarnMaxvalue", getEarlyWarnMaxvalue())
                .append("earlyWarnMinvalue", getEarlyWarnMinvalue())
                .append("overMaxvalue", getOverMaxvalue())
                .append("overMinvalue", getOverMinvalue())
                .append("exceptionMaxvalue", getExceptionMaxvalue())
                .append("exceptionMinvalue", getExceptionMinvalue())
                .append("createTime", getCreateTime())
                .append("createName", getCreateName())
                .append("updateTime", getUpdateTime())
                .append("updateName", getUpdateName())
                .append("remark", getRemark())
                .toString();
    }
}
