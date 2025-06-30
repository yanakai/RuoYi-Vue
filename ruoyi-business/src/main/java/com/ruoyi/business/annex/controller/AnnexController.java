package com.ruoyi.business.annex.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.business.annex.domain.AnnexInfo;
import com.ruoyi.business.annex.domain.AnnexReq;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 附件处理
 */
@RestController
@RequestMapping("/platform/annex")
public class AnnexController {

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    /**
     * 获取附件列表
     */
    @PostMapping("/feignList")
    public List<AnnexInfo> feignList(@RequestBody(required = false) AnnexReq req) {
        return annexService.selectAnnexList(req);
    }

    /**
     * 获取附件列表
     */
    @PostMapping("/list")
    public AjaxResult list(@RequestBody(required = false) AnnexReq req) {
        return AjaxResult.success(annexService.selectAnnexList(req));
    }

    /**
     * 上传附件
     * 添加文件时便指定文件归属 sourceType
     */
    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file, @RequestParam("sourceType") String sourceType) {
        return annexService.insertAnnex(file, sourceType);
    }

    /**
     * 更新附件
     */
    @PostMapping("/update")
    public AjaxResult update(@RequestBody(required = false) JSONObject annexInfo) {
        return annexService.updateAnnex(annexInfo);
    }
}
