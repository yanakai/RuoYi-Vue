package com.ruoyi.business.base.mapper;

import com.ruoyi.business.base.domain.IndustryCategory;

import java.util.List;

/**
 * 国民经济行业分类Mapper接口
 */
public interface IndustryCategoryMapper {

    /**
     * 查询国民经济行业分类列表
     */
    List<IndustryCategory> selectIndustryCategoryList();
}
