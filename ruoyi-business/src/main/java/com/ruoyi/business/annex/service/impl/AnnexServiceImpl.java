package com.ruoyi.business.annex.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.business.annex.domain.AnnexInfo;
import com.ruoyi.business.annex.domain.AnnexReq;
import com.ruoyi.business.annex.mapper.AnnexMapper;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class AnnexServiceImpl implements AnnexService {

    private AnnexMapper annexMapper;
    @Autowired
    public void setAnnexMapper(AnnexMapper annexMapper) {
        this.annexMapper = annexMapper;
    }

    @Override
    public List<AnnexInfo> selectAnnexList(AnnexReq req) {
        return annexMapper.selectAnnexList(req);
    }

    @Override
    public AjaxResult insertAnnex(MultipartFile file, String sourceType) {
        if (file.isEmpty()) {
            return AjaxResult.error("上传附件为空，请检查确认");
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        // 上传附件
        String imageUrl;
        try {
            imageUrl = FileUploadUtils.upload(RuoYiConfig.getAnnexPath(sourceType), file, null);
        } catch (Exception e) {
            log.error("文件转存失败", e);
            return AjaxResult.error("文件转存失败，请检查");
        }
        AnnexInfo annexInfo = new AnnexInfo();
        annexInfo.setAnnexId(IdUtils.fastSimpleUUID());
        annexInfo.setSourceType(sourceType);
        annexInfo.setFileName(file.getOriginalFilename());
        annexInfo.setFileType(FileUploadUtils.getExtension(file));
        annexInfo.setFilePath(imageUrl);
        annexInfo.setFileSize(file.getSize());
        annexInfo.setCreateUser(loginUser.getUser().getUserName());
        annexInfo.setCreateTime(LocalDateTime.now());
        annexMapper.insertAnnex(annexInfo);
        return AjaxResult.success(annexInfo);
    }

    @Override
    public AjaxResult updateAnnex(JSONObject annexInfo) {
        if (null == annexInfo) {
            return AjaxResult.error("更新数据为空");
        }
        String sourceId = annexInfo.getString("sourceId");
        if (StringUtils.isEmpty(sourceId)) {
            return AjaxResult.error("未知的目标id");
        }
        String sourceType = annexInfo.getString("sourceType");
        List<String> annexIds = annexInfo.getList("annexIds", String.class);
        // 删除旧附件-不在annexIds列表里的，指定sourceType、sourceId
        annexMapper.deleteAnnexBySourceExclude(sourceType, sourceId, annexIds);
        if (null == annexIds || annexIds.size() < 1) {
            return AjaxResult.error("未知的更新数据");
        }
        // 更新附件
        return AjaxResult.success(annexMapper.updateAnnex(sourceType, sourceId, annexIds));
    }

    @Override
    public AjaxResult deleteAnnexByIds(String[] annexIds) {
        return AjaxResult.success(annexMapper.deleteAnnexByIds(annexIds));
    }
}
