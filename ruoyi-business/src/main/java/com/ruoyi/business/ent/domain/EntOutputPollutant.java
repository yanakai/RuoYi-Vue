package com.ruoyi.business.ent.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.business.base.domain.MonFactorInfo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 企业排口污染物信息对象 t_ent_output_pollutant
 */
@Data
public class EntOutputPollutant {

    /** 排口污染物主键id */
    private String outPutPollId;

    /** 关联排口主键id */
    private String outPutId;

    /** 排口关联污染物code */
    private String pollutantCode;
    private String pollutantNameCn;
    private String pollutantNameEn;

    /** 排序码 */
    private Integer pollutantSort;

    /** 超标报警类型：0：无报警；1：区间值报警；2：上限报警；3：下限报警； */
    private Integer alarmType;

    /** 是否零值报警 0：否；1：是 */
    private Integer isZeroAlarm;

    /** 是否连续值报警：0：否；1：是 */
    private Integer isContinuityAlarm;

    /** 标准值--预留字段 */
    private Integer standardVal;

    /** 年段污染物排放限值 */
    private Float annualLimitValue;

    /** 月段污染物排放限值 */
    private String monthlyLimitValue;

    /** 报警上限 */
    private Float earlyWarnMaxvalue;

    /** 报警下限 */
    private Float earlyWarnMinvalue;

    /** 超标上限--当alarmType=1时区间上限；当为3时上线报警的最大值 */
    private Float overMaxvalue;

    /** 超标下限--当alarmType=1时区间下限；当为4时上限报警的最小值 */
    private Float overMinvalue;

    /** 异常上限 */
    private Float exceptionMaxvalue;

    /** 异常下限 */
    private Float exceptionMinvalue;
    /** 创建人 */
    private String createUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /** 更新人 */
    private String updateUser;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 监测因子项
     */
    @JsonIgnore
    private String monFactorStr;
    private List<MonFactorInfo> monFactor;
}