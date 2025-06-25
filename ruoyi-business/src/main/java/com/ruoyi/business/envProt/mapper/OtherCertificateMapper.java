package com.ruoyi.business.envProt.mapper;

import com.ruoyi.business.envProt.domain.OtherCertificate;
import com.ruoyi.business.envProt.domain.OtherCertificateReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 其他证书Mapper接口
 */
public interface OtherCertificateMapper {

    /**
     * 查询其他证书
     */
    OtherCertificate selectOtherCertificateById(String otherId);

    /**
     * 查询其他证书列表
     */
    List<OtherCertificate> selectOtherCertificateList(OtherCertificateReq req);

    /**
     * 新增其他证书
     */
    int insertOtherCertificate(OtherCertificate req);

    /**
     * 修改其他证书
     */
    int updateOtherCertificate(OtherCertificate info);

    /**
     * 批量删除其他证书
     */
    int deleteOtherCertificateByIds(@Param("ids") List<String> ids);
}
