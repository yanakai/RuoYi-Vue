package com.ruoyi.business.annex.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.github.f4b6a3.ulid.UlidCreator;
import com.ruoyi.business.annex.domain.AnnexInfo;
import com.ruoyi.business.annex.domain.AnnexReq;
import com.ruoyi.business.annex.mapper.AnnexMapper;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public List<AnnexInfo> selectAnnexList(String sourceId, String sourceType) {
        return annexMapper.selectAnnexListBySource(sourceId, sourceType);
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
        annexInfo.setAnnexId(UlidCreator.getMonotonicUlid().toString());
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
        // 更新附件
        updateAnnex(sourceId, sourceType, annexIds);
        return AjaxResult.success();
    }

    @Override
    public void updateAnnex(String sourceId, String sourceType, List<String> annexIds) {
        if (StringUtils.isEmpty(sourceId)) {
            return;
        }
        // 先获取旧的配置
        List<AnnexInfo> oldList = annexMapper.selectAnnexListBySource(sourceId, sourceType);
        List<String> deletePath = new ArrayList<>();
        List<String> deleteAnnexId = new ArrayList<>();
        if (null != oldList && oldList.size() > 0) {
            for (AnnexInfo old : oldList) {
                // 更新时的id包含在旧的内无需更新；旧的不包含在新的列表内删除
                if (null != annexIds && annexIds.contains(old.getAnnexId())) {
                    annexIds.remove(old.getAnnexId());
                } else {
                    if (null != old.getFilePath()) {
                        deletePath.add(old.getFilePath().replace(Constants.RESOURCE_PREFIX, ""));
                    }
                    deleteAnnexId.add(old.getAnnexId());
                }
            }
        }
        // 删除不包含在新的内的配置
        if (deleteAnnexId.size() > 0) {
            annexMapper.deleteAnnexByIds(deleteAnnexId);
        }
        // 更新数据
        if (null != annexIds && annexIds.size() > 0) {
            annexMapper.updateAnnex(sourceId, sourceType, annexIds);
        }
        // 删除本地保存的数据
        if (deletePath.size() > 0) {
            deletePath.forEach(FileUploadUtils::deleteFile);
        }
    }
}
