package com.ruoyi.business.onlineMonitoring.controller;

import cn.hutool.poi.excel.ExcelUtil;
import com.ruoyi.business.onlineMonitoring.dto.GasoutDTO;
import com.ruoyi.business.statistics.domain.TDataGasoutDayStatistics;
import com.ruoyi.business.statistics.service.IGasoutService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 废气排口在线监测 Controller
 *
 * @author lx
 * @date 2024-07-04
 */
@Slf4j
@Api(value = "业务模块-废气排口在线监测", tags = "废气排口在线监测")
@RestController
@RequestMapping("/business/onlinemonitoring/gasout")
public class GasoutController extends BaseController {
    @Autowired
    private IGasoutService gasoutService;

    /**
     * 废气排口在线监测
     */
    @ApiOperation("废气排口在线监测")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(GasoutDTO gasoutDTO) {
         try {
             return gasoutService.selectDataList(gasoutDTO);
         }catch (Exception e){
             log.error("排口查询错误",e);
             TableDataInfo tableDataInfo = new TableDataInfo();
             tableDataInfo.setCode(HttpStatus.ERROR);
             tableDataInfo.setMsg("系统错误");
             return  tableDataInfo;
         }

    }

    /**
     * 废气排口在线监测导出
     */
    @ApiOperation("废气排口在线监测导出")
//    @PreAuthorize("@ss.hasPermi('business:dataGasoutDayStatistics:export')")
    @Log(title = "废气排口在线监测导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GasoutDTO gasoutDTO) {
        try {
            gasoutService.export(response,gasoutDTO);
        }catch (Exception e){
            log.error("排口导出错误",e);
        }
    }


}
