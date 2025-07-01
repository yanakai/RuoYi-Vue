package com.ruoyi.business.base.service;

import com.ruoyi.business.base.domain.IndustryCategory;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.Map;

/**
 * 国民经济行业分类Service接口
 */
public interface IndustryCategoryService {

    /**
     * 查询国民经济行业分类列表
     */
    AjaxResult selectIndustryCategoryTree();

    Map<String, IndustryCategory> selectIndustryCategoryMap();
}
