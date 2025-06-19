package com.ruoyi.business.ent.controller;

import com.ruoyi.business.ent.domain.EntOutputPollutant;
import com.ruoyi.business.ent.service.EntOutputPollutantService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 企业排口污染物信息Controller
 */
@RestController
@RequestMapping("/platform/ent/outPutPollutant")
public class EntOutputPollutantController {

    private EntOutputPollutantService entOutputPollutantService;
    @Autowired
    public void setEntOutputPollutantService(EntOutputPollutantService entOutputPollutantService) {
        this.entOutputPollutantService = entOutputPollutantService;
    }

    /**
     * 通过企业排口id查询对应的污染物信息
     */
    @GetMapping("/{outPutId}")
    public AjaxResult getOutputPollutant(@PathVariable("outPutId") String outPutId) {
        return AjaxResult.success(entOutputPollutantService.selectOutputPollutantByOutPutId(outPutId));
    }

    /**
     * 新增企业排口污染物信息
     */
    @PostMapping
    public AjaxResult add(@RequestBody EntOutputPollutant poll) {
        return entOutputPollutantService.insertOutputPollutant(poll);
    }

    /**
     * 修改企业排口污染物信息
     */
    @PutMapping
    public AjaxResult edit(@RequestBody EntOutputPollutant poll) {
        return entOutputPollutantService.updateOutputPollutant(poll);
    }

    /**
     * 删除企业排口污染物信息
     */
	@DeleteMapping("/{outPutPollId}")
    public AjaxResult remove(@PathVariable String outPutPollId) {
        return entOutputPollutantService.deleteOutputPollutantById(outPutPollId);
    }
}