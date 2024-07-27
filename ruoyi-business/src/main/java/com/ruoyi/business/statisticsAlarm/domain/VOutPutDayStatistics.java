package com.ruoyi.business.statisticsAlarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * VIEW对象 v_out_put_day_statistics
 * 
 * @author lx
 * @date 2024-07-27
 */
@Data
public class VOutPutDayStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String entName;

    /** $column.columnComment */
    private String entCode;

    /** $column.columnComment */
    private String outPutCode;

    /** $column.columnComment */
    private String outPutName;

    /** $column.columnComment */
    private Date monitorTime;

    /** $column.columnComment */
    private String outPutType;

    /** $column.columnComment */
    private String monitoringPointType;

    /** $column.columnComment */
    private String pollutantNameCn;

    /** $column.columnComment */
    private String emissions;

    /** $column.columnComment */
    private String alarm;

}
