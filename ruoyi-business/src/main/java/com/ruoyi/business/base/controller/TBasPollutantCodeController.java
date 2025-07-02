package com.ruoyi.business.base.controller;

import java.util.List;

import com.ruoyi.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.business.base.domain.TBasPollutantCode;
import com.ruoyi.business.base.service.ITBasPollutantCodeService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数采报文对应的污染因子关系 2017版本和2003版Controller
 */
@RestController
@RequestMapping("/business/base/pollutantCode")
public class TBasPollutantCodeController {

    private ITBasPollutantCodeService tBasPollutantCodeService;
    @Autowired
    public void settBasPollutantCodeService(ITBasPollutantCodeService tBasPollutantCodeService) {
        this.tBasPollutantCodeService = tBasPollutantCodeService;
    }

    /**
     * 查询数采报文对应的污染因子关系 2017版本和2003版列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TBasPollutantCode tBasPollutantCode){
        boolean page = PageUtils.startPageCheckExists();
        List<TBasPollutantCode> list = tBasPollutantCodeService.selectTBasPollutantCodeList(tBasPollutantCode);
        return PageUtils.getDataTable(list, page);
    }
}
