package com.ruoyi.business.statisticsAlarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小时数据缺失---废水、废气对象 t_data_monitor_fault_hour
 * 
 * @author lx
 * @date 2024-10-26
 */
public class TDataMonitorFaultHour extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id-自增 */
    private Long alarmId;

    /** 企业编码 */
    @Excel(name = "企业编码")
    private String entCode;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String entName;

    /** 排口编码 */
    @Excel(name = "排口编码")
    private String outPutCode;

    /** 排口名称 */
    @Excel(name = "排口名称")
    private String outPutName;

    /** 污染物编码：当报警类型为2时此字段有值 */
    @Excel(name = "污染物编码：当报警类型为2时此字段有值")
    private String pollutantCode;

    /** 污染物名称：当报警类型为2时此字段有值 */
    @Excel(name = "污染物名称：当报警类型为2时此字段有值")
    private String pollutantName;

    /** 数据类型；1：废气；2：废水 */
    @Excel(name = "数据类型；1：废气；2：废水")
    private String dataType;

    /** 报警时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报警时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date alarmTime;

    /** 数据缺失时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "数据缺失时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date faultTime;

    /** 报警类型：1：小时数据整体缺失；2：小时数据单个污染因子缺失 */
    @Excel(name = "报警类型：1：小时数据整体缺失；2：小时数据单个污染因子缺失")
    private String alarmType;

    public void setAlarmId(Long alarmId) 
    {
        this.alarmId = alarmId;
    }

    public Long getAlarmId() 
    {
        return alarmId;
    }
    public void setEntCode(String entCode) 
    {
        this.entCode = entCode;
    }

    public String getEntCode() 
    {
        return entCode;
    }
    public void setEntName(String entName) 
    {
        this.entName = entName;
    }

    public String getEntName() 
    {
        return entName;
    }
    public void setOutPutCode(String outPutCode) 
    {
        this.outPutCode = outPutCode;
    }

    public String getOutPutCode() 
    {
        return outPutCode;
    }
    public void setOutPutName(String outPutName) 
    {
        this.outPutName = outPutName;
    }

    public String getOutPutName() 
    {
        return outPutName;
    }
    public void setPollutantCode(String pollutantCode) 
    {
        this.pollutantCode = pollutantCode;
    }

    public String getPollutantCode() 
    {
        return pollutantCode;
    }
    public void setPollutantName(String pollutantName) 
    {
        this.pollutantName = pollutantName;
    }

    public String getPollutantName() 
    {
        return pollutantName;
    }
    public void setDataType(String dataType) 
    {
        this.dataType = dataType;
    }

    public String getDataType() 
    {
        return dataType;
    }
    public void setAlarmTime(Date alarmTime) 
    {
        this.alarmTime = alarmTime;
    }

    public Date getAlarmTime() 
    {
        return alarmTime;
    }
    public void setFaultTime(Date faultTime) 
    {
        this.faultTime = faultTime;
    }

    public Date getFaultTime() 
    {
        return faultTime;
    }
    public void setAlarmType(String alarmType) 
    {
        this.alarmType = alarmType;
    }

    public String getAlarmType() 
    {
        return alarmType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("alarmId", getAlarmId())
            .append("entCode", getEntCode())
            .append("entName", getEntName())
            .append("outPutCode", getOutPutCode())
            .append("outPutName", getOutPutName())
            .append("pollutantCode", getPollutantCode())
            .append("pollutantName", getPollutantName())
            .append("dataType", getDataType())
            .append("alarmTime", getAlarmTime())
            .append("faultTime", getFaultTime())
            .append("alarmType", getAlarmType())
            .toString();
    }
}
