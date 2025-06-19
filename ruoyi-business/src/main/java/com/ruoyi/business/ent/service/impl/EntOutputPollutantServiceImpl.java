package com.ruoyi.business.ent.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.business.base.domain.MonFactorInfo;
import com.ruoyi.business.ent.domain.EntOutputPollutant;
import com.ruoyi.business.ent.mapper.EntOutputPollutantMapper;
import com.ruoyi.business.ent.service.EntOutputPollutantService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 企业排口污染物信息Service业务层处理
 */
@Service
public class EntOutputPollutantServiceImpl implements EntOutputPollutantService {

    private EntOutputPollutantMapper entOutputPollutantMapper;
    @Autowired
    public void setEntOutputPollutantMapper(EntOutputPollutantMapper entOutputPollutantMapper) {
        this.entOutputPollutantMapper = entOutputPollutantMapper;
    }

    /**
     * 通过企业排口id查询对应的污染物信息
     */
    @Override
    public List<EntOutputPollutant> selectOutputPollutantByOutPutId(String outPutId) {
        List<EntOutputPollutant> list = entOutputPollutantMapper.selectOutputPollutantByOutPutId(outPutId);
        list.forEach( e -> e.setMonFactor(JSONArray.parseArray(e.getMonFactorStr(), MonFactorInfo.class)));
        return list;
    }

    @Override
    @Log(title = "新增企业排口污染物信息", businessType = BusinessType.INSERT)
    public AjaxResult insertOutputPollutant(EntOutputPollutant poll) {
        poll.setOutPutPollId(IdUtils.fastSimpleUUID());
        poll.setCreateUser(SecurityUtils.getUserName());
        poll.setCreateTime(LocalDateTime.now());
        poll.setUpdateUser(poll.getCreateUser());
        poll.setUpdateTime(poll.getCreateTime());
        if (null != poll.getMonFactor()) {
            poll.getMonFactor().forEach( e -> {
                e.setField(null);
                e.setDesc(null);
            });
            poll.setMonFactorStr(JSONArray.toJSONString(poll.getMonFactor()));
        } else {
            poll.setMonFactorStr("[]");
        }
        int result = entOutputPollutantMapper.insertOutputPollutant(poll);
        if (result > 0) {
            // 修改排口信息中的污染物列表
            entOutputPollutantMapper.updateOutPutPollCodeById(poll.getOutPutId());
        }
        return AjaxResult.success(poll);
    }

    @Override
    @Log(title = "修改企业排口污染物信息", businessType = BusinessType.UPDATE)
    public AjaxResult updateOutputPollutant(EntOutputPollutant poll) {
        poll.setUpdateUser(SecurityUtils.getUserName());
        poll.setUpdateTime(LocalDateTime.now());
        if (null != poll.getMonFactor()) {
            poll.getMonFactor().forEach( e -> {
                e.setField(null);
                e.setDesc(null);
            });
            poll.setMonFactorStr(JSONArray.toJSONString(poll.getMonFactor()));
        } else {
            poll.setMonFactorStr("[]");
        }
        int result = entOutputPollutantMapper.updateOutputPollutant(poll);
        if (result > 0) {
            // 修改排口信息中的污染物列表
            entOutputPollutantMapper.updateOutPutPollCodeById(poll.getOutPutId());
        }
        return AjaxResult.success(poll);
    }

    @Override
    @Log(title = "删除企业排口污染物信息", businessType = BusinessType.DELETE)
    public AjaxResult deleteOutputPollutantById(String outPutPollId) {
        EntOutputPollutant poll = entOutputPollutantMapper.selectOutputPollutantById(outPutPollId);
        if (null != poll) {
            int result = entOutputPollutantMapper.deleteOutputPollutantById(outPutPollId);
            if (result > 0) {
                // 修改排口信息中的污染物列表
                entOutputPollutantMapper.updateOutPutPollCodeById(poll.getOutPutId());
            }
        }
        return AjaxResult.success();
    }
}
