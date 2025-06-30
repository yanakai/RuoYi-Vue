package com.ruoyi.business.envProt.service.impl;

import java.util.List;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.enums.AnnexTypeEnum;
import com.ruoyi.business.envProt.domain.EnvMangeCheck;
import com.ruoyi.business.envProt.domain.EnvMangeReq;
import com.ruoyi.business.envProt.mapper.EnvMangeCheckMapper;
import com.ruoyi.business.envProt.service.EnvMangeCheckService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 企业环评环保管理-环保验收Service业务层处理
 */
@Service
public class EnvMangeCheckServiceImpl implements EnvMangeCheckService {

    private EnvMangeCheckMapper envMangeCheckMapper;
    @Autowired
    public void setEnvMangeCheckMapper(EnvMangeCheckMapper envMangeCheckMapper) {
        this.envMangeCheckMapper = envMangeCheckMapper;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    @Override
    public AjaxResult selectMangeCheckList(EnvMangeReq req) {
        if (null == req || StringUtils.isEmpty(req.getKey())) {
            return AjaxResult.error("未知的请求参数");
        }
        AjaxResult result = AjaxResult.success();
        // 分页参数设置
        PageHelper.startPage(null == req.getCurrent() || req.getCurrent() < 1 ? 1 : req.getCurrent(),
                null == req.getSize() || req.getSize() < 1 ? 10 : req.getSize());
        List<EnvMangeCheck> list = envMangeCheckMapper.selectMangeCheckList(req.getKey());
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    @Override
    public List<EnvMangeCheck> selectMangeCheckByProjectId(String mProjectId) {
        if (StringUtils.isEmpty(mProjectId)) {
            return null;
        }
        return envMangeCheckMapper.selectMangeCheckList(mProjectId);
    }

    @Override
    public AjaxResult insertMangeCheck(EnvMangeCheck info) {
        info.setMCheckId(UlidCreator.getMonotonicUlid().toString());
        int count = envMangeCheckMapper.insertMangeCheck(info);
        if (count > 0 && null != info.getAnnexIds() && info.getAnnexIds().size() > 0) {
            annexService.updateAnnex(info.getMCheckId(), AnnexTypeEnum.entEnvMangeCheck.name(), info.getAnnexIds());
        }
        return AjaxResult.success(info);
    }

    @Override
    public AjaxResult updateMangeCheck(EnvMangeCheck info) {
        int count = envMangeCheckMapper.updateMangeCheck(info);
        if (count > 0 ) {
            annexService.updateAnnex(info.getMCheckId(), AnnexTypeEnum.entEnvMangeCheck.name(), info.getAnnexIds());
        }
        return AjaxResult.success();
    }

    @Override
    public AjaxResult deleteMangeCheckById(String id) {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("请求信息为空");
        }
        int count = envMangeCheckMapper.deleteMangeCheckById(id);
        if (count > 0) {
            // 删除附件
            annexService.updateAnnex(id, AnnexTypeEnum.entEnvMangeCheck.name(), null);
        }
        return AjaxResult.success(count);
    }

    @Override
    public void deleteMangeCheckByProjectId(String mProjectId) {
        if (StringUtils.isEmpty(mProjectId)) {
            return;
        }
        List<String> ids = envMangeCheckMapper.getMangeCheckIdByProjectId(mProjectId);
        if (null == ids || ids.size() < 1) {
            return;
        }
        int count = envMangeCheckMapper.deleteMangeCheckByProjectId(mProjectId);
        if (count > 0) {
            // 删除附件
            ids.forEach( e -> annexService.updateAnnex(e, AnnexTypeEnum.entEnvMangeCheck.name(), null));
        }
    }
}
