package com.ruoyi.coordination.pollution.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台---污染防治目标--任务审核记录对象 b_pollution_prevention_examine
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public class BPollutionPreventionExamine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long exId;

    /** 任务接收单位表主键id */
    @Excel(name = "任务接收单位表主键id")
    private Long receiveId;

    /** 主任务表id */
    @Excel(name = "主任务表id")
    private Long taskId;

    /** 任务办理记录表id */
    @Excel(name = "任务办理记录表id")
    private Long recordId;

    /** 审核状态：0：未签收；1：已签收未上报；2：已上报未审核；3：已审核；4：已审核，未通过 */
    @Excel(name = "审核状态：0：未签收；1：已签收未上报；2：已上报未审核；3：已审核；4：已审核，未通过")
    private String exState;

    /** 审核内容 */
    @Excel(name = "审核内容")
    private String exContent;

    /** 审核单位id */
    @Excel(name = "审核单位id")
    private Long createDeptId;

    /** 审核单位名称 */
    @Excel(name = "审核单位名称")
    private String createDeptName;

    /** 审核人id */
    @Excel(name = "审核人id")
    private Long createUserId;

    /** 审核人名称 */
    @Excel(name = "审核人名称")
    private String createUserName;

    public void setExId(Long exId) 
    {
        this.exId = exId;
    }

    public Long getExId() 
    {
        return exId;
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
    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setExState(String exState) 
    {
        this.exState = exState;
    }

    public String getExState() 
    {
        return exState;
    }
    public void setExContent(String exContent) 
    {
        this.exContent = exContent;
    }

    public String getExContent() 
    {
        return exContent;
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
            .append("exId", getExId())
            .append("receiveId", getReceiveId())
            .append("taskId", getTaskId())
            .append("recordId", getRecordId())
            .append("exState", getExState())
            .append("exContent", getExContent())
            .append("createTime", getCreateTime())
            .append("createDeptId", getCreateDeptId())
            .append("createDeptName", getCreateDeptName())
            .append("createUserId", getCreateUserId())
            .append("createUserName", getCreateUserName())
            .append("remark", getRemark())
            .toString();
    }
}
