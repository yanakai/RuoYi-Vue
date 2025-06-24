package com.ruoyi.business.envProt.service;

import java.util.List;
import com.ruoyi.business.envProt.domain.EnvProPerson;
import com.ruoyi.business.envProt.domain.EnvProPersonReq;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 企业环保人员Service接口
 */
public interface EnvProPersonService {

    /**
     * 获取企业环保人员详细信息
     */
    AjaxResult selectProPersonById(String proPersonId);

    /**
     * 查询企业环保人员列表
     */
    AjaxResult selectProPersonList(EnvProPersonReq req);

    /**
     * 导出企业环保人员列表
     */
    void exportProPerson(EnvProPersonReq req, HttpServletResponse response);

    /**
     * 下载企业环保人员模板
     */
    void downloadTemplate(HttpServletResponse response);

    /**
     * 导入企业环保人员模板
     */
    AjaxResult importTemplate(MultipartFile file);

    /**
     * 新增企业环保人员
     */
    AjaxResult insertProPerson(EnvProPerson info);

    /**
     * 修改企业环保人员
     */
    AjaxResult updateProPerson(EnvProPerson info);

    /**
     * 删除企业环保人员
     */
    AjaxResult deleteProPersonByIds(List<String> ids);
}
