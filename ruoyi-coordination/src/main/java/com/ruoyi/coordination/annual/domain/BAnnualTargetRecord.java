package com.ruoyi.coordination.annual.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台---年度任务目标--任务接收单位上报记录对象 b_annual_target_record
 *
 * @author yanakai@126.com
 * @date 2023-04-20
 */
public class BAnnualTargetRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long recordId;

    /** 任务接收单位表主键id */
    @Excel(name = "任务接收单位表主键id")
    private Long receiveId;

    /** 主任务表id */
    @Excel(name = "主任务表id")
    private Long taskId;

    /** 上报内容 */
    @Excel(name = "上报内容")
    private String recordContent;

    /** 应上报时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date answerTime;

    /** 是否延迟上报；0：否；1：是；关联字典表 */
    @Excel(name = "是否延迟上报；0：否；1：是；关联字典表")
    private String isDelay;

    /** 创建单位id */
    @Excel(name = "创建单位id")
    private Long createDeptId;

    /** 创建单位名称 */
    @Excel(name = "创建单位名称")
    private String createDeptName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

    /** 创建人名称 */
    @Excel(name = "创建人名称")
    private String createUserName;

    public void setRecordId(Long recordId)
    {
        this.recordId = recordId;
    }

    public Long getRecordId()
    {
        return recordId;
    }
    public void setReceiveId(Long receiveId)
    {
        this.receiveId = receiveId;
    }

    public Long getReceiveId()
    {
        return receiveId;
    }
    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }

    public Long getTaskId()
    {
        return taskId;
    }
    public void setRecordContent(String recordContent)
    {
        this.recordContent = recordContent;
    }

    public String getRecordContent()
    {
        return recordContent;
    }
    public void setAnswerTime(Date answerTime)
    {
        this.answerTime = answerTime;
    }

    public Date getAnswerTime()
    {
        return answerTime;
    }
    public void setIsDelay(String isDelay)
    {
        this.isDelay = isDelay;
    }

    public String getIsDelay()
    {
        return isDelay;
    }
    public void setCreateDeptId(Long createDeptId)
    {
        this.createDeptId = createDeptId;
    }

    public Long getCreateDeptId()
    {
        return createDeptId;
    }
    public void setCreateDeptName(String createDeptName)
    {
        this.createDeptName = createDeptName;
    }

    public String getCreateDeptName()
    {
        return createDeptName;
    }
    public void setCreateUserId(Long createUserId)
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId()
    {
        return createUserId;
    }
    public void setCreateUserName(String createUserName)
    {
        this.createUserName = createUserName;
    }

    public String getCreateUserName()
    {
        return createUserName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("recordId", getRecordId())
                .append("receiveId", getReceiveId())
                .append("taskId", getTaskId())
                .append("recordContent", getRecordContent())
                .append("answerTime", getAnswerTime())
                .append("createTime", getCreateTime())
                .append("isDelay", getIsDelay())
                .append("createDeptId", getCreateDeptId())
                .append("createDeptName", getCreateDeptName())
                .append("createUserId", getCreateUserId())
                .append("createUserName", getCreateUserName())
                .append("remark", getRemark())
                .toString();
    }
}
