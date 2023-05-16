package com.ruoyi.coordination.clue.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.coordination.clue.domain.WarnRule;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coordination.clue.mapper.BClueInfoRulesMapper;
import com.ruoyi.coordination.clue.domain.BClueInfoRules;
import com.ruoyi.coordination.clue.service.IBClueInfoRulesService;

/**
 * 协同平台--污染线索处置--站点预警规则Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
@Service
public class BClueInfoRulesServiceImpl implements IBClueInfoRulesService 
{
    @Autowired
    private BClueInfoRulesMapper bClueInfoRulesMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询协同平台--污染线索处置--站点预警规则
     * 
     * @param rulesId 协同平台--污染线索处置--站点预警规则主键
     * @return 协同平台--污染线索处置--站点预警规则
     */
    @Override
    public BClueInfoRules selectBClueInfoRulesByRulesId(Long rulesId)
    {
        return bClueInfoRulesMapper.selectBClueInfoRulesByRulesId(rulesId);
    }

    /**
     * 查询协同平台--污染线索处置--站点预警规则列表
     * 
     * @param bClueInfoRules 协同平台--污染线索处置--站点预警规则
     * @return 协同平台--污染线索处置--站点预警规则
     */
    @Override
    public List<BClueInfoRules> selectBClueInfoRulesList(BClueInfoRules bClueInfoRules)
    {
        return bClueInfoRulesMapper.selectBClueInfoRulesList(bClueInfoRules);
    }

    /**
     * 新增协同平台--污染线索处置--站点预警规则
     * 
     * @param bClueInfoRules 协同平台--污染线索处置--站点预警规则
     * @return 结果
     */
    @Override
    public int insertBClueInfoRules(BClueInfoRules bClueInfoRules)
    {
        bClueInfoRules.setCreateTime(DateUtils.getNowDate());
        return bClueInfoRulesMapper.insertBClueInfoRules(bClueInfoRules);
    }

    /**
     * 修改协同平台--污染线索处置--站点预警规则
     * 
     * @param bClueInfoRules 协同平台--污染线索处置--站点预警规则
     * @return 结果
     */
    @Override
    public int updateBClueInfoRules(BClueInfoRules bClueInfoRules)
    {
        bClueInfoRules.setUpdateTime(DateUtils.getNowDate());
        bClueInfoRules.setUpdateDeptId(SecurityUtils.getDeptId());
        bClueInfoRules.setUpdateDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        bClueInfoRules.setUpdateUserId(SecurityUtils.getUserId());
        bClueInfoRules.setUpdateUserName(SecurityUtils.getUsername());
        return bClueInfoRulesMapper.updateBClueInfoRules(bClueInfoRules);
    }

    /**
     * 批量删除协同平台--污染线索处置--站点预警规则
     * 
     * @param rulesIds 需要删除的协同平台--污染线索处置--站点预警规则主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoRulesByRulesIds(Long[] rulesIds)
    {
        return bClueInfoRulesMapper.deleteBClueInfoRulesByRulesIds(rulesIds);
    }

    /**
     * 删除协同平台--污染线索处置--站点预警规则信息
     * 
     * @param rulesId 协同平台--污染线索处置--站点预警规则主键
     * @return 结果
     */
    @Override
    public int deleteBClueInfoRulesByRulesId(Long rulesId)
    {
        return bClueInfoRulesMapper.deleteBClueInfoRulesByRulesId(rulesId);
    }

    @Override
    public int inserWarnRuleList(List<WarnRule> bClueInfoRules) {
        BClueInfoRules rules = new BClueInfoRules();
        rules.setRulesData(bClueInfoRules);
        rules.setCreateDeptId(SecurityUtils.getDeptId());
        rules.setCreateDeptName(sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getDeptName());
        rules.setCreateUserId(SecurityUtils.getUserId());
        rules.setCreateUserName(SecurityUtils.getUsername());
        return bClueInfoRulesMapper.insertBClueInfoRules(rules);
    }

    @Override
    public List<BClueInfoRules> selectWarnRules(BClueInfoRules bClueInfoRules) {
        List<BClueInfoRules> rulesList = bClueInfoRulesMapper.selectBClueInfoRulesList(bClueInfoRules);
        return rulesList;
    }
}
