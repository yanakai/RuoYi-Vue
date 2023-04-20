package com.ruoyi.coordination.annual.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台---年度任务目标--任务接收单位对象 b_annual_target_receive
 *
 * @author yanakai@126.com
 * @date 2023-04-20
 */
public class BAnnualTargetReceive extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long receiveId;

    /** 主任务id */
    @Excel(name = "主任务id")
    private Long taskId;

    /** 应完成任务数（数据来源主任务） */
    @Excel(name = "应完成任务数", readConverterExp = "数=据来源主任务")
    private Long answerTaskNum;

    /** 实完成任务数 */
    @Excel(name = "实完成任务数")
    private Long realityTaskNum;

    /** 接收状态：0:未接收；1：已接收 */
    @Excel(name = "接收状态：0:未接收；1：已接收")
    private String receiveState;

    /** 接收单位id */
    @Excel(name = "接收单位id")
    private Long receiveDeptId;

    /** 接收单位名称 */
    @Excel(name = "接收单位名称")
    private String receiveDeptName;

    /** 接收时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接收时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiveTime;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completeTime;

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
    public void setAnswerTaskNum(Long answerTaskNum)
    {
        this.answerTaskNum = answerTaskNum;
    }

    public Long getAnswerTaskNum()
    {
        return answerTaskNum;
    }
    public void setRealityTaskNum(Long realityTaskNum)
    {
        this.realityTaskNum = realityTaskNum;
    }

    public Long getRealityTaskNum()
    {
        return realityTaskNum;
    }
    public void setReceiveState(String receiveState)
    {
        this.receiveState = receiveState;
    }

    public String getReceiveState()
    {
        return receiveState;
    }
    public void setReceiveDeptId(Long receiveDeptId)
    {
        this.receiveDeptId = receiveDeptId;
    }

    public Long getReceiveDeptId()
    {
        return receiveDeptId;
    }
    public void setReceiveDeptName(String receiveDeptName)
    {
        this.receiveDeptName = receiveDeptName;
    }

    public String getReceiveDeptName()
    {
        return receiveDeptName;
    }
    public void setReceiveTime(Date receiveTime)
    {
        this.receiveTime = receiveTime;
    }

    public Date getReceiveTime()
    {
        return receiveTime;
    }
    public void setCompleteTime(Date completeTime)
    {
        this.completeTime = completeTime;
    }

    public Date getCompleteTime()
    {
        return completeTime;
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
                .append("receiveId", getReceiveId())
                .append("taskId", getTaskId())
                .append("answerTaskNum", getAnswerTaskNum())
                .append("realityTaskNum", getRealityTaskNum())
                .append("receiveState", getReceiveState())
                .append("receiveDeptId", getReceiveDeptId())
                .append("receiveDeptName", getReceiveDeptName())
                .append("receiveTime", getReceiveTime())
                .append("completeTime", getCompleteTime())
                .append("createDeptId", getCreateDeptId())
                .append("createDeptName", getCreateDeptName())
                .append("createUserId", getCreateUserId())
                .append("createUserName", getCreateUserName())
                .append("createTime", getCreateTime())
                .append("remark", getRemark())
                .toString();
    }
}
