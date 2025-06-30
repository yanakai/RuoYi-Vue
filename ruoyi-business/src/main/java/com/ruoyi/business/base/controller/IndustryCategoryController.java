package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.service.IndustryCategoryService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 国民经济行业分类Controller
 */
@RestController
@RequestMapping("/platform/base/industryCategory")
public class IndustryCategoryController {

    private IndustryCategoryService industryCategoryService;
    @Autowired
    public void setIndustryCategoryService(IndustryCategoryService industryCategoryService) {
        this.industryCategoryService = industryCategoryService;
    }

    /**
     * 查询国民经济行业分类树结构
     */
    @GetMapping("/tree")
    public AjaxResult tree() {
        return industryCategoryService.selectIndustryCategoryTree();
    }
}
