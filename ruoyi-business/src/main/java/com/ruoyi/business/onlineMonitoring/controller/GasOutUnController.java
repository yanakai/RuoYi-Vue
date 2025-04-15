package com.ruoyi.business.onlineMonitoring.controller;

import com.ruoyi.business.onlineMonitoring.dto.GasOutUnDTO;
import com.ruoyi.business.statistics.service.IGasOutUnService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 废气无组织排口在线监测 Controller
 */
@Slf4j
@Api(value = "业务模块-废气无组织排口在线监测", tags = "废气无组织排口在线监测")
@RestController
@RequestMapping("/business/online/monitoring/gasOutPutUnorganized")
public class GasOutUnController extends BaseController {

    private IGasOutUnService gasOutUnService;
    @Autowired
    public void setGasOutUnService(IGasOutUnService gasOutUnService) {
        this.gasOutUnService = gasOutUnService;
    }

    /**
     * 扬尘排口在线监测
     */
    @ApiOperation("废气无组织排口在线监测")
    @GetMapping("/list")
    public TableDataInfo list(GasOutUnDTO gasOutUnDTO) {
         try {
             return gasOutUnService.selectDataList(gasOutUnDTO);
         } catch (Exception e){
             log.error("排口查询错误",e);
             TableDataInfo tableDataInfo = new TableDataInfo();
             tableDataInfo.setCode(HttpStatus.NO_CONTENT);
             tableDataInfo.setMsg("操作已经执行成功，但是没有返回数据");
             return tableDataInfo;
         }
    }

    /**
     * 废气无组织排口在线监测导出
     */
    @ApiOperation("废气无组织排口在线监测导出")
    @Log(title = "废气无组织排口在线监测导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody GasOutUnDTO gasOutUnDTO) {
        try {
            gasOutUnService.export(response, gasOutUnDTO);
        } catch (Exception e){
            log.error("排口导出错误",e);
        }
    }
}
