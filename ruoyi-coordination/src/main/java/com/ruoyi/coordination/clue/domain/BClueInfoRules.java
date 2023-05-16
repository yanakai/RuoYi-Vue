package com.ruoyi.coordination.clue.domain;

import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 协同平台--污染线索处置--站点预警规则对象 b_clue_info_rules
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public class BClueInfoRules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预警规则主键id */
    private Long rulesId;

    /** 预警规则内容json格式存储 */
    @Excel(name = "预警规则内容json格式存储")
    private List<WarnRule> rulesData;

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

    /** 修改单位id */
    @Excel(name = "修改单位id")
    private Long updateDeptId;

    /** 修改单位名称 */
    @Excel(name = "修改单位名称")
    private String updateDeptName;

    /** 修改人id */
    @Excel(name = "修改人id")
    private Long updateUserId;

    /** 修改人名称 */
    @Excel(name = "修改人名称")
    private String updateUserName;

    public void setRulesId(Long rulesId) 
    {
        this.rulesId = rulesId;
    }

    public Long getRulesId() 
    {
        return rulesId;
    }

    public List<WarnRule> getRulesData() {
        return rulesData;
    }

    public void setRulesData(List<WarnRule> rulesData) {
        this.rulesData = rulesData;
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
    public void setUpdateDeptId(Long updateDeptId) 
    {
        this.updateDeptId = updateDeptId;
    }

    public Long getUpdateDeptId() 
    {
        return updateDeptId;
    }
    public void setUpdateDeptName(String updateDeptName) 
    {
        this.updateDeptName = updateDeptName;
    }

    public String getUpdateDeptName() 
    {
        return updateDeptName;
    }
    public void setUpdateUserId(Long updateUserId) 
    {
        this.updateUserId = updateUserId;
    }

    public Long getUpdateUserId() 
    {
        return updateUserId;
    }
    public void setUpdateUserName(String updateUserName) 
    {
        this.updateUserName = updateUserName;
    }

    public String getUpdateUserName() 
    {
        return updateUserName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rulesId", getRulesId())
            .append("rulesData", getRulesData())
            .append("createTime", getCreateTime())
            .append("createDeptId", getCreateDeptId())
            .append("createDeptName", getCreateDeptName())
            .append("createUserId", getCreateUserId())
            .append("createUserName", getCreateUserName())
            .append("updateTime", getUpdateTime())
            .append("updateDeptId", getUpdateDeptId())
            .append("updateDeptName", getUpdateDeptName())
            .append("updateUserId", getUpdateUserId())
            .append("updateUserName", getUpdateUserName())
            .toString();
    }
}
