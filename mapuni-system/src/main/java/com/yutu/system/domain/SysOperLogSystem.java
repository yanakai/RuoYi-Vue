package com.yutu.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yutu.common.annotation.Excel;
import com.yutu.common.core.domain.BaseEntity;

/**
 * 访问日志对象 sys_oper_log_system
 *
 * @author yutu
 * @date 2024-03-01
 */
public class SysOperLogSystem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志主键 */
    private Long operId;

    /** 子系统id */
    @Excel(name = "子系统id")
    private Long systemId;

    /** 子系统唯一key */
    @Excel(name = "子系统唯一key")
    private String systemKey;

    /** 子系统名称 */
    @Excel(name = "子系统名称")
    private String systemName;

    /** 模块id */
    @Excel(name = "模块id")
    private Long titleId;

    /** 模块标题 */
    @Excel(name = "模块标题")
    private String title;

    /** 业务类型（0其它 1新增 2修改 3删除） */
    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,10=查询")
    private Long businessType;

    /** 方法名称 */
    @Excel(name = "方法名称")
    private String method;

    /** 请求方式 */
    @Excel(name = "请求方式")
    private String requestMethod;

    /** 操作类别（0其它 1 PC端用户 2手机端用户） */
    @Excel(name = "操作类别", readConverterExp = "0=其它,1=,P=C端用户,2=手机端用户")
    private Long operatorType;

    /** 操作人员id */
    @Excel(name = "操作人员id")
    private Long operNameId;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String operName;

    /** 操作人所属部门id */
    @Excel(name = "操作人所属部门id")
    private Long deptId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 请求URL */
    @Excel(name = "请求URL")
    private String operUrl;

    /** 主机地址 */
    @Excel(name = "主机地址")
    private String operIp;

    /** 操作地点 */
    @Excel(name = "操作地点")
    private String operLocation;

    /** 请求参数 */
    @Excel(name = "请求参数")
    private String operParam;

    /** 返回参数 */
    @Excel(name = "返回参数")
    private String jsonResult;

    /** 操作状态（0正常 1异常） */
    @Excel(name = "操作状态", readConverterExp = "0=正常,1=异常")
    private Long status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    private String errorMsg;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "操作时间", width = 40, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date operTime;

    /** 消耗时间 */
    @Excel(name = "消耗时间")
    private Long costTime;

    public void setOperId(Long operId)
    {
        this.operId = operId;
    }

    public Long getOperId()
    {
        return operId;
    }
    public void setSystemId(Long systemId)
    {
        this.systemId = systemId;
    }

    public Long getSystemId()
    {
        return systemId;
    }
    public void setSystemKey(String systemKey)
    {
        this.systemKey = systemKey;
    }

    public String getSystemKey()
    {
        return systemKey;
    }
    public void setSystemName(String systemName)
    {
        this.systemName = systemName;
    }

    public String getSystemName()
    {
        return systemName;
    }
    public void setTitleId(Long titleId)
    {
        this.titleId = titleId;
    }

    public Long getTitleId()
    {
        return titleId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setBusinessType(Long businessType)
    {
        this.businessType = businessType;
    }

    public Long getBusinessType()
    {
        return businessType;
    }
    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getMethod()
    {
        return method;
    }
    public void setRequestMethod(String requestMethod)
    {
        this.requestMethod = requestMethod;
    }

    public String getRequestMethod()
    {
        return requestMethod;
    }
    public void setOperatorType(Long operatorType)
    {
        this.operatorType = operatorType;
    }

    public Long getOperatorType()
    {
        return operatorType;
    }
    public void setOperNameId(Long operNameId)
    {
        this.operNameId = operNameId;
    }

    public Long getOperNameId()
    {
        return operNameId;
    }
    public void setOperName(String operName)
    {
        this.operName = operName;
    }

    public String getOperName()
    {
        return operName;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }
    public void setOperUrl(String operUrl)
    {
        this.operUrl = operUrl;
    }

    public String getOperUrl()
    {
        return operUrl;
    }
    public void setOperIp(String operIp)
    {
        this.operIp = operIp;
    }

    public String getOperIp()
    {
        return operIp;
    }
    public void setOperLocation(String operLocation)
    {
        this.operLocation = operLocation;
    }

    public String getOperLocation()
    {
        return operLocation;
    }
    public void setOperParam(String operParam)
    {
        this.operParam = operParam;
    }

    public String getOperParam()
    {
        return operParam;
    }
    public void setJsonResult(String jsonResult)
    {
        this.jsonResult = jsonResult;
    }

    public String getJsonResult()
    {
        return jsonResult;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }
    public void setOperTime(Date operTime)
    {
        this.operTime = operTime;
    }

    public Date getOperTime()
    {
        return operTime;
    }
    public void setCostTime(Long costTime)
    {
        this.costTime = costTime;
    }

    public Long getCostTime()
    {
        return costTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("operId", getOperId())
                .append("systemId", getSystemId())
                .append("systemKey", getSystemKey())
                .append("systemName", getSystemName())
                .append("titleId", getTitleId())
                .append("title", getTitle())
                .append("businessType", getBusinessType())
                .append("method", getMethod())
                .append("requestMethod", getRequestMethod())
                .append("operatorType", getOperatorType())
                .append("operNameId", getOperNameId())
                .append("operName", getOperName())
                .append("deptId", getDeptId())
                .append("deptName", getDeptName())
                .append("operUrl", getOperUrl())
                .append("operIp", getOperIp())
                .append("operLocation", getOperLocation())
                .append("operParam", getOperParam())
                .append("jsonResult", getJsonResult())
                .append("status", getStatus())
                .append("errorMsg", getErrorMsg())
                .append("operTime", getOperTime())
                .append("costTime", getCostTime())
                .toString();
    }
}
