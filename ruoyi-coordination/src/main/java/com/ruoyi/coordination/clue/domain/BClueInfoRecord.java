package com.ruoyi.coordination.clue.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台--污染线索处置--接收单位上报记录
对象 b_clue_info_record
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public class BClueInfoRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long recordId;

    /** 任务接收单位表主键id */
    @Excel(name = "任务接收单位表主键id")
    private Long receiveId;

    /** 线索主任务表id */
    @Excel(name = "线索主任务表id")
    private Long taskId;

    /** 任务办理记录序号 */
    @Excel(name = "任务办理记录序号")
    private Long recordNum;

    /** 上报状态：0：未签收；1：已签收未上报；2：已上报未审核；3：已审核；4：已审核，未通过 */
    @Excel(name = "上报状态：0：未签收；1：已签收未上报；2：已上报未审核；3：已审核；4：已审核，未通过")
    private String recordState;

    /** 上报内容 */
    @Excel(name = "上报内容")
    private String recordContent;

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

    /** 完成时时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completeTime;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String auditIdea;

    /** 审核单位id */
    @Excel(name = "审核单位id")
    private Long auditDeptId;

    /** 审核单位名称 */
    @Excel(name = "审核单位名称")
    private String auditDeptName;

    /** 审核人id */
    @Excel(name = "审核人id")
    private Long auditUserId;

    /** 审核人名称 */
    @Excel(name = "审核人名称")
    private String auditUserName;

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
    public void setRecordNum(Long recordNum) 
    {
        this.recordNum = recordNum;
    }

    public Long getRecordNum() 
    {
        return recordNum;
    }
    public void setRecordState(String recordState) 
    {
        this.recordState = recordState;
    }

    public String getRecordState() 
    {
        return recordState;
    }
    public void setRecordContent(String recordContent) 
    {
        this.recordContent = recordContent;
    }

    public String getRecordContent() 
    {
        return recordContent;
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
    public void setCompleteTime(Date completeTime) 
    {
        this.completeTime = completeTime;
    }

    public Date getCompleteTime() 
    {
        return completeTime;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }
    public void setAuditIdea(String auditIdea) 
    {
        this.auditIdea = auditIdea;
    }

    public String getAuditIdea() 
    {
        return auditIdea;
    }
    public void setAuditDeptId(Long auditDeptId) 
    {
        this.auditDeptId = auditDeptId;
    }

    public Long getAuditDeptId() 
    {
        return auditDeptId;
    }
    public void setAuditDeptName(String auditDeptName) 
    {
        this.auditDeptName = auditDeptName;
    }

    public String getAuditDeptName() 
    {
        return auditDeptName;
    }
    public void setAuditUserId(Long auditUserId) 
    {
        this.auditUserId = auditUserId;
    }

    public Long getAuditUserId() 
    {
        return auditUserId;
    }
    public void setAuditUserName(String auditUserName) 
    {
        this.auditUserName = auditUserName;
    }

    public String getAuditUserName() 
    {
        return auditUserName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("receiveId", getReceiveId())
            .append("taskId", getTaskId())
            .append("recordNum", getRecordNum())
            .append("recordState", getRecordState())
            .append("recordContent", getRecordContent())
            .append("createTime", getCreateTime())
            .append("createDeptId", getCreateDeptId())
            .append("createDeptName", getCreateDeptName())
            .append("createUserId", getCreateUserId())
            .append("createUserName", getCreateUserName())
            .append("completeTime", getCompleteTime())
            .append("auditTime", getAuditTime())
            .append("auditIdea", getAuditIdea())
            .append("auditDeptId", getAuditDeptId())
            .append("auditDeptName", getAuditDeptName())
            .append("auditUserId", getAuditUserId())
            .append("auditUserName", getAuditUserName())
            .append("remark", getRemark())
            .toString();
    }
}
