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
     * 查询附件
     */
    List<AnnexInfo> selectAnnexList(String sourceId, String sourceType);

    /**
     * 添加附件
     */
    AjaxResult insertAnnex(MultipartFile file, String sourceType);

    /**
     * 修改附件信息
     */
    AjaxResult updateAnnex(JSONObject annexInfo);

    /**
     * 修改附件信息
     * 更新时的id包含在旧的内无需更新；旧的不包含在新的列表内时删除记录及文件
     * annexId为空时表示直接删除
     */
    void updateAnnex(String sourceId, String sourceType, List<String> annexIds);
}
