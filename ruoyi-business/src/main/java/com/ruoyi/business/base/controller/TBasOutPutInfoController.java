package com.ruoyi.business.base.controller;

import com.ruoyi.business.base.domain.TBasUploadFiles;
import com.ruoyi.business.base.domain.VOutPutInfo;
import com.ruoyi.business.base.service.ITBasUploadFilesService;
import com.ruoyi.business.base.service.IVOutPutInfoService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.file.InvalidExtensionException;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;

/**
 * 基础信息--企业--废气排口Controller
 *
 * @author lx
 * @date 2024-06-27
 */
@Api(value = "业务模块-污染排口", tags = "企业档案-污染排放口信息")
@RestController
@RequestMapping("/business/base/outPutInfo")
public class TBasOutPutInfoController extends BaseController {
    @Resource
    private IVOutPutInfoService vOutPutInfoService;

    @Resource
    private ITBasUploadFilesService uploadFilesService;

    /**
     * 查询基础信息--企业--废气排口列表
     */
    @ApiOperation("获取污染排放口信息列表")
//    @PreAuthorize("@ss.hasPermi('business:outPutInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(VOutPutInfo vOutPutInfo) {
        startPage();
        List<VOutPutInfo> list = vOutPutInfoService.selectVOutPutInfoList(vOutPutInfo, getLoginUser());
        return getDataTable(list);
    }

    /**
     * 导出基础信息--企业--废气排口列表
     */
    @ApiOperation("导出污染排放口信息列表")
//    @PreAuthorize("@ss.hasPermi('business:outPutInfo:export')")
    @Log(title = "企业档案--污染排放口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VOutPutInfo vOutPutInfo) {
        List<VOutPutInfo> list = vOutPutInfoService.selectVOutPutInfoList(vOutPutInfo,getLoginUser());
        ExcelUtil<VOutPutInfo> util = new ExcelUtil<>(VOutPutInfo.class);
        util.exportExcel(response, list, "企业档案--污染排放口信息");
    }

    //上传图片 , consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    @ApiOperation("上传图片")
    @Log(title = "企业档案--污染排放口信息", businessType = BusinessType.UPLOAD)
    @PostMapping(name = "/img/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) throws IOException, InvalidExtensionException {
        if (!file.isEmpty()) {
            LoginUser loginUser = getLoginUser();
            //上传文件
            String imageUrl = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file, MimeTypeUtils.IMAGE_EXTENSION);

            TBasUploadFiles uploadFiles = new TBasUploadFiles();
            uploadFiles.setFileName(file.getOriginalFilename());
            uploadFiles.setBusinessModuleType("out_put");
            uploadFiles.setFileType(FileUploadUtils.getExtension(file));
            uploadFiles.setFileStoragePath(imageUrl);
            uploadFiles.setFileSize(file.getSize());
            uploadFiles.setCreateName(loginUser.getUsername());
            //uploadFiles.setBusinessModuleId(businessModuleId);
            uploadFilesService.insertBasUploadFiles(uploadFiles);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("uploadFiles", uploadFiles);
            return ajax;
        }
        return error("上传图片异常，请联系管理员");
    }

    //删除图片
    @ApiOperation("删除图片")
    @Log(title = "企业档案--污染排放口信息", businessType = BusinessType.DELETE)
    @PostMapping("/img/delete/{ids}")
    public AjaxResult delete(@PathVariable Long[] ids) {
        return toAjax(uploadFilesService.deleteBasUploadFilesByIds(ids));
    }

}
