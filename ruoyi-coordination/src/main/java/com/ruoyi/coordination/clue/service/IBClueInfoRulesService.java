package com.ruoyi.coordination.clue.service;

import java.util.List;
import com.ruoyi.coordination.clue.domain.BClueInfoRules;
import com.ruoyi.coordination.clue.domain.WarnRule;

/**
 * 协同平台--污染线索处置--站点预警规则Service接口
 * 
 * @author ruoyi
 * @date 2023-05-09
 */
public interface IBClueInfoRulesService 
{
    /**
     * 查询协同平台--污染线索处置--站点预警规则
     * 
     * @param rulesId 协同平台--污染线索处置--站点预警规则主键
     * @return 协同平台--污染线索处置--站点预警规则
     */
    public BClueInfoRules selectBClueInfoRulesByRulesId(Long rulesId);

    /**
     * 查询协同平台--污染线索处置--站点预警规则列表
     * 
     * @param bClueInfoRules 协同平台--污染线索处置--站点预警规则
     * @return 协同平台--污染线索处置--站点预警规则集合
     */
    public List<BClueInfoRules> selectBClueInfoRulesList(BClueInfoRules bClueInfoRules);

    /**
     * 新增协同平台--污染线索处置--站点预警规则
     * 
     * @param bClueInfoRules 协同平台--污染线索处置--站点预警规则
     * @return 结果
     */
    public int insertBClueInfoRules(BClueInfoRules bClueInfoRules);

    /**
     * 修改协同平台--污染线索处置--站点预警规则
     * 
     * @param bClueInfoRules 协同平台--污染线索处置--站点预警规则
     * @return 结果
     */
    public int updateBClueInfoRules(BClueInfoRules bClueInfoRules);

    /**
     * 批量删除协同平台--污染线索处置--站点预警规则
     * 
     * @param rulesIds 需要删除的协同平台--污染线索处置--站点预警规则主键集合
     * @return 结果
     */
    public int deleteBClueInfoRulesByRulesIds(Long[] rulesIds);

    /**
     * 删除协同平台--污染线索处置--站点预警规则信息
     * 
     * @param rulesId 协同平台--污染线索处置--站点预警规则主键
     * @return 结果
     */
    public int deleteBClueInfoRulesByRulesId(Long rulesId);

    int inserWarnRuleList(List<WarnRule> bClueInfoRules);

    List<BClueInfoRules> selectWarnRules(BClueInfoRules bClueInfoRules);
}
