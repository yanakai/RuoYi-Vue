package com.ruoyi.business.annex.service;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.business.annex.domain.AnnexInfo;
import com.ruoyi.business.annex.domain.AnnexReq;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnnexService {

    /**
     * 查询附件
     */
    List<AnnexInfo> selectAnnexList(AnnexReq req);

    /**
     * 添加附件
     */
    AjaxResult insertAnnex(MultipartFile file, String sourceType);

    /**
     * 修改附件信息
     */
    AjaxResult updateAnnex(JSONObject annexInfo);

    /**
     * 批量删除附件
     */
    AjaxResult deleteAnnexByIds(String[] annexIds);
}
