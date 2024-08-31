package com.ruoyi.business.base.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class TBasUploadFiles extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 业务类型：out_put 排口 */
    @Excel(name = "业务类型：out_put 排口")
    private String businessModuleType;

    /** 业务ID */
    @Excel(name = "业务ID")
    private String businessModuleId;

    /** 文件类型:如jpg、txt等 */
    @Excel(name = "文件类型:如jpg、txt等")
    private String fileType;

    /** 文件的名称，包括扩展名 */
    @Excel(name = "文件的名称，包括扩展名")
    private String fileName;

    /** 文件上传路径 */
    @Excel(name = "文件上传路径")
    private String fileStoragePath;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long fileSize;

    /** 对文件的描述，可选 */
    @Excel(name = "对文件的描述，可选")
    private String fileDescription;

    /** 上传人 */
    @Excel(name = "上传人")
    private String createName;

}
