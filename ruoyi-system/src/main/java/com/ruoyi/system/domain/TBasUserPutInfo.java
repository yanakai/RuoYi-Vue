package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户收藏关注排口信息对象 t_bas_user_put_info
 * 
 * @author liux
 * @date 2025-01-04
 */
public class TBasUserPutInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户登录名 */
    @Excel(name = "用户登录名")
    private String loginName;

    /** 监控类型：1 废水  2 废弃 */
    @Excel(name = "监控类型：1 废水  2 废气")
    private String monitorPointType;

    /** 企业编码/社会信用代码 */
    @Excel(name = "企业编码/社会信用代码")
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

    private int outPutId;

    public int getOutPutId() {
		return outPutId;
	}

    public void setOutPutId(int outPutId) {
        this.outPutId = outPutId;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setMonitorPointType(String monitorPointType) 
    {
        this.monitorPointType = monitorPointType;
    }

    public String getMonitorPointType() 
    {
        return monitorPointType;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("loginName", getLoginName())
            .append("monitorPointType", getMonitorPointType())
            .append("entCode", getEntCode())
            .append("entName", getEntName())
            .append("outPutCode", getOutPutCode())
            .append("outPutName", getOutPutName())
            .append("createTime", getCreateTime())
            .toString();
    }
}
