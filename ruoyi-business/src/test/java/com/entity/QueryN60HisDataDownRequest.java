package com.entity;

import lombok.Data;

/**
 *
 * @author Administrator
 */
@Data
public class QueryN60HisDataDownRequest {

    /**
     * 车架号
     */
    private String vin;

    /**
     * 终端号
     */
    private Integer terminalCode;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * dbc文件MD5
     */
    private String dbcMd5;

    /**
     * 限制条数
     */
    private Integer num = 1000;

    private Integer pageSize;

    private Integer pageNum;
}
