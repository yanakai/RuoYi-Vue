package com.ruoyi.business.base.domain;

import lombok.Data;

@Data
public class AutoHeadInfo {
    /** 监测因子 */
    private String name;
    /** 中文描述 */
    private String desc;
    /** 是否选中，1选中，非1未选中 */
    private Integer value;
    /** 对应的数据字段 */
    private String field;
}
