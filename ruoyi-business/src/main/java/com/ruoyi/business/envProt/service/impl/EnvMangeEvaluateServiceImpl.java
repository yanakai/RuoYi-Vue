package com.ruoyi.business.envProt.service.impl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.base.domain.TBasPollutantCode;
import com.ruoyi.business.base.mapper.TBasPollutantCodeMapper;
import com.ruoyi.business.enums.AnnexTypeEnum;
import com.ruoyi.business.envProt.domain.EnvMangeEvaluate;
import com.ruoyi.business.envProt.mapper.EnvMangeEvaluateMapper;
import com.ruoyi.business.envProt.service.EnvMangeEvaluateService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 企业环评环保管理-环评Service业务层处理
 */
@Service
public class EnvMangeEvaluateServiceImpl implements EnvMangeEvaluateService {

    private EnvMangeEvaluateMapper envMangeEvaluateMapper;
    @Autowired
    public void setEnvMangeEvaluateMapper(EnvMangeEvaluateMapper envMangeEvaluateMapper) {
        this.envMangeEvaluateMapper = envMangeEvaluateMapper;
    }

    private TBasPollutantCodeMapper tBasPollutantCodeMapper;
    @Autowired
    public void setTBasPollutantCodeMapper(TBasPollutantCodeMapper tBasPollutantCodeMapper) {
        this.tBasPollutantCodeMapper = tBasPollutantCodeMapper;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    @Override
    public AjaxResult selectMangeEvaluateList(String mProjectId) {
        if (StringUtils.isEmpty(mProjectId)) {
            return AjaxResult.error("未知的请求参数");
        }
        // 分页查询
        PageUtils.startPage();
        List<EnvMangeEvaluate> list = envMangeEvaluateMapper.selectMangeEvaluateList(mProjectId);
        // 设置污染物信息
        setPollutantCodeDesc(list);
        return PageUtils.getAjaxResult(list, true);
    }

    @Override
    public List<EnvMangeEvaluate> selectMangeEvaluateByProjectId(String mProjectId) {
        if (StringUtils.isEmpty(mProjectId)) {
            return null;
        }
        List<EnvMangeEvaluate> list = envMangeEvaluateMapper.selectMangeEvaluateList(mProjectId);
        // 设置污染物信息
        setPollutantCodeDesc(list);
        return list;
    }

    /**
     * 设置污染物信息
     */
    private void setPollutantCodeDesc(List<EnvMangeEvaluate> list) {
        if (null == list || list.size() < 1) {
            return;
        }
        // 设置污染物名称
        List<TBasPollutantCode> codeList = tBasPollutantCodeMapper.selectTBasPollutantCodeList(null);
        Map<String, String> codeMap = codeList.stream()
                .collect(Collectors.toMap(
                        TBasPollutantCode::getPollutantCode,  // Key 映射器
                        TBasPollutantCode::getPollutantNameCn,  // Value 映射器
                        (existing, replacement) -> existing // 解决键冲突的策略
                ));
        list.forEach( e -> {
            e.setPollutantCodeDesc(null);
            if (StringUtils.isNotEmpty(e.getPollutantCode())) {
                for (String s : e.getPollutantCode().split(",")) {
                    if (null == e.getPollutantCodeDesc()) {
                        e.setPollutantCodeDesc(codeMap.get(s));
                    } else {
                        e.setPollutantCodeDesc(e.getPollutantCodeDesc() + "," + codeMap.get(s));
                    }
                }
            }
        });
    }

    @Override
    @Log(title = "企业环评", businessType = BusinessType.INSERT)
    public AjaxResult insertMangeEvaluate(EnvMangeEvaluate info) {
        info.setMEvaluateId(UlidCreator.getMonotonicUlid().toString());
        int count = envMangeEvaluateMapper.insertMangeEvaluate(info);
        if (count > 0 && null != info.getAnnexIds() && info.getAnnexIds().size() > 0) {
            annexService.updateAnnex(info.getMEvaluateId(), AnnexTypeEnum.entEnvMangeEvaluate.name(), info.getAnnexIds());
        }
        return AjaxResult.success(info);
    }

    @Override
    @Log(title = "企业环评", businessType = BusinessType.UPDATE)
    public AjaxResult updateMangeEvaluate(EnvMangeEvaluate info) {
        int count = envMangeEvaluateMapper.updateMangeEvaluate(info);
        if (count > 0 ) {
            annexService.updateAnnex(info.getMEvaluateId(), AnnexTypeEnum.entEnvMangeEvaluate.name(), info.getAnnexIds());
        }
        return AjaxResult.success();
    }

    @Override
    @Log(title = "企业环评", businessType = BusinessType.DELETE)
    public AjaxResult deleteMangeEvaluateById(String id) {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("请求信息为空");
        }
        int count = envMangeEvaluateMapper.deleteMangeEvaluateById(id);
        if (count > 0) {
            // 删除附件
            annexService.updateAnnex(id, AnnexTypeEnum.entEnvMangeEvaluate.name(), null);
        }
        return AjaxResult.success(count);
    }

    @Override
    public void deleteMangeEvaluateByProjectId(String mProjectId) {
        if (StringUtils.isEmpty(mProjectId)) {
            return;
        }
        List<String> ids = envMangeEvaluateMapper.getMangeEvaluateIdByProjectId(mProjectId);
        if (null == ids || ids.size() < 1) {
            return;
        }
        int count = envMangeEvaluateMapper.deleteMangeEvaluateByProjectId(mProjectId);
        if (count > 0) {
            // 删除附件
            ids.forEach( e -> annexService.updateAnnex(e, AnnexTypeEnum.entEnvMangeEvaluate.name(), null));
        }
    }
}
