package com.ruoyi.business.sys.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 地区对象 t_districts
 *
 * @author lx
 * @date 2024-07-01
 */
public class TDistricts extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 上级编号
     */
    private Long pid;

    /**
     * 层级
     */
    private Integer deep;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 拼音
     */
    @Excel(name = "拼音")
    private String pinyin;

    /**
     * 拼音缩写
     */
    @Excel(name = "拼音缩写")
    private String pinyinShor;

    /**
     * 扩展名
     */
    @Excel(name = "扩展名")
    private String extName;

    /**
     * 操作人
     */
    private String operator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyinShor() {
        return pinyinShor;
    }

    public void setPinyinShor(String pinyinShor) {
        this.pinyinShor = pinyinShor;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("pid", getPid())
                .append("deep", getDeep())
                .append("name", getName())
                .append("pinyin", getPinyin())
                .append("pinyinShor", getPinyinShor())
                .append("extName", getExtName())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("operator", getOperator())
                .toString();
    }
}
