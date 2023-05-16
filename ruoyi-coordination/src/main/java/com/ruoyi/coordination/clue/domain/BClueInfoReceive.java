package com.ruoyi.coordination.clue.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 协同平台--污染线索处置----线索主任务接收单位对象 b_clue_info_receive
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public class BClueInfoReceive extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long receiveId;

    /** 父id */
    private Long receivePid;

    /** 主任务id */
    @Excel(name = "主任务id")
    private Long taskId;

    @Excel(name = "派发意见")
    private String disseminateComments;

    /** 接收状态：0:未接收；1：已接收；2：已完成 */
    @Excel(name = "接收状态：0:未接收；1：已接收；2：已完成")
    private String receiveState;

    /** 催办状态：0：未催办；1：已催办 */
    @Excel(name = "催办状态：0：未催办；1：已催办")
    private String urgingState;

    /** 接收人id */
    @Excel(name = "接收人id")
    private Long receiveUserId;

    /** 接收人 */
    @Excel(name = "接收人")
    private Long receiveUserName;

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

    public Long getReceivePid() {
        return receivePid;
    }

    public void setReceivePid(Long receivePid) {
        this.receivePid = receivePid;
    }

    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setReceiveState(String receiveState) 
    {
        this.receiveState = receiveState;
    }

    public String getDisseminateComments() {
        return disseminateComments;
    }

    public void setDisseminateComments(String disseminateComments) {
        this.disseminateComments = disseminateComments;
    }

    public String getReceiveState()
    {
        return receiveState;
    }
    public void setUrgingState(String urgingState) 
    {
        this.urgingState = urgingState;
    }

    public String getUrgingState() 
    {
        return urgingState;
    }

    public Long getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Long getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(Long receiveUserName) {
        this.receiveUserName = receiveUserName;
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
            .append("receiveState", getReceiveState())
            .append("urgingState", getUrgingState())
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
