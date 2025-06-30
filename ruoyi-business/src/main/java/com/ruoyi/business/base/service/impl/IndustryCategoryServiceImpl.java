package com.ruoyi.business.base.service.impl;

import com.ruoyi.business.base.domain.IndustryCategory;
import com.ruoyi.business.base.mapper.IndustryCategoryMapper;
import com.ruoyi.business.base.service.IndustryCategoryService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 国民经济行业分类Service业务层处理
 */
@Service
public class IndustryCategoryServiceImpl implements IndustryCategoryService {

    private IndustryCategoryMapper industryCategoryMapper;
    @Autowired
    public void setIndustryCategoryMapper(IndustryCategoryMapper industryCategoryMapper) {
        this.industryCategoryMapper = industryCategoryMapper;
    }

    @Override
    public AjaxResult selectIndustryCategoryTree() {
        List<IndustryCategory> list = industryCategoryMapper.selectIndustryCategoryList();
        if (null == list || list.size() < 1) {
            return AjaxResult.success();
        }
        Map<Long, List<IndustryCategory>> map = new HashMap<>();
        list.forEach( e -> {
            List<IndustryCategory> sub;
            if (map.containsKey(e.getPid())) {
                sub = map.get(e.getPid());
            } else {
                sub = new ArrayList<>();
                map.put(e.getPid(), sub);
            }
            sub.add(e);
        });
        // 获取父级列表
        List<IndustryCategory> parent = map.get(-1L);
        fill(map, parent);
        // o1.compare o2
        parent.sort(Comparator.comparing(IndustryCategory::getCode));
        return AjaxResult.success(parent);
    }

    private void fill(Map<Long, List<IndustryCategory>> map, List<IndustryCategory> list) {
        if (null == list || list.size() < 1) {
            return;
        }
        for (IndustryCategory in : list) {
            if (map.containsKey(in.getId())) {
                List<IndustryCategory> sub = map.get(in.getId());
                fill(map, sub);
                sub.sort(Comparator.comparing(IndustryCategory::getCode));
                in.setSub(sub);
            }
        }
    }

    @Override
    public Map<Long, IndustryCategory> selectIndustryCategoryMap() {
        List<IndustryCategory> list = industryCategoryMapper.selectIndustryCategoryList();
        if (null == list || list.size() < 1) {
            return new HashMap<>();
        }
        return list.stream().collect(Collectors.toMap(
                IndustryCategory::getId,  // Key 映射器
                Function.identity(),      // Value 就是对象本身
                (k1, k2) -> k1 // 键冲突时的合并策略
        ));
    }
}
