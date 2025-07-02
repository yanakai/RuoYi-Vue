package com.ruoyi.business.envProt.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.github.f4b6a3.ulid.UlidCreator;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.base.domain.IndustryCategory;
import com.ruoyi.business.base.service.IndustryCategoryService;
import com.ruoyi.business.enums.AnnexTypeEnum;
import com.ruoyi.business.enums.EnvManageGradeTypeEnum;
import com.ruoyi.business.envProt.domain.EnvMangeCheck;
import com.ruoyi.business.envProt.domain.EnvMangeEvaluate;
import com.ruoyi.business.envProt.domain.EnvMangeProject;
import com.ruoyi.business.envProt.domain.EnvMangeReq;
import com.ruoyi.business.envProt.mapper.EnvMangeProjectMapper;
import com.ruoyi.business.envProt.service.EnvMangeCheckService;
import com.ruoyi.business.envProt.service.EnvMangeEvaluateService;
import com.ruoyi.business.envProt.service.EnvMangeProjectService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.CellUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * 企业环评环保管理-项目Service业务层处理
 */
@Slf4j
@Service
public class EnvMangeProjectServiceImpl implements EnvMangeProjectService {

    private EnvMangeProjectMapper envMangeProjectMapper;
    @Autowired
    public void setEnvMangeProjectMapper(EnvMangeProjectMapper envMangeProjectMapper) {
        this.envMangeProjectMapper = envMangeProjectMapper;
    }

    private EnvMangeEvaluateService envMangeEvaluateService;
    @Autowired
    public void setEnvMangeEvaluateService(EnvMangeEvaluateService envMangeEvaluateService) {
        this.envMangeEvaluateService = envMangeEvaluateService;
    }

    private EnvMangeCheckService envMangeCheckService;
    @Autowired
    public void setEnvMangeCheckService(EnvMangeCheckService envMangeCheckService) {
        this.envMangeCheckService = envMangeCheckService;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    private IndustryCategoryService industryCategoryService;
    @Autowired
    public void setIndustryCategoryService(IndustryCategoryService industryCategoryService) {
        this.industryCategoryService = industryCategoryService;
    }

    @Override
    public AjaxResult selectMangeProjectList(EnvMangeReq req) {
        if (null == req) {
            req = new EnvMangeReq();
        }
        // 添加权限
        if (SecurityUtils.isNotAdmin()) {
            req.setPermEntCode(SecurityUtils.getEntCode());
        }
        // 分页查询
        PageUtils.startPage();
        List<EnvMangeProject> list = envMangeProjectMapper.selectMangeProjectList(req);
        // 国民经济行业类别设置
        fillInfo(list);
        return PageUtils.getAjaxResult(list, true);
    }

    @Override
    @Log(title = "企业环评环保管理-项目", businessType = BusinessType.EXPORT)
    public void exportMangeProject(EnvMangeReq req, HttpServletResponse response) {
        if (null == req) {
            req = new EnvMangeReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/环评环保管理.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            // 添加权限
            if (SecurityUtils.isNotAdmin()) {
                req.setPermEntCode(SecurityUtils.getEntCode());
            }
            List<EnvMangeProject> list = envMangeProjectMapper.selectMangeProjectList(req);
            // 国民经济行业类别设置
            fillInfo(list);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex = 3;// 首行
            Row templateRow = sheet.getRow(rowIndex);
            CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
            CellStyle style = workbook.createCellStyle();
            // 复制单元格样式
            CellUtils.copyCellStyle(templateStyle, style);
            if (null != list && list.size() > 0) {
                int index = 0;
                Row row;
                for (EnvMangeProject project : list) {
                    index++;
                    sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                    row = sheet.createRow(rowIndex);
                    rowIndex++;
                    // 设置内容
                    setEnvMangeProjectCellValue(row, index, style, project);
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业环评环保管理.xlsx", "UTF-8"));
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e){
            log.error("按模板导出文件失败", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("outputStream close", e);
                }
            }
        }
    }

    @Override
    @Log(title = "企业环评环保管理-项目详情", businessType = BusinessType.EXPORT)
    public void exportMangeProjectById(String id, HttpServletResponse response) {
        OutputStream outputStream = null;
        try {
            String templatePath = "template/环评环保管理-详情.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            EnvMangeProject project = envMangeProjectMapper.selectMangeProjectById(id);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex = 3;// 首行
            Row templateRow = sheet.getRow(rowIndex);
            CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
            CellStyle style = workbook.createCellStyle();
            // 复制单元格样式
            CellUtils.copyCellStyle(templateStyle, style);
            if (null != project) {
                // 国民经济行业类别设置
                fillInfo(Collections.singletonList(project));
                sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                // 设置内容
                setEnvMangeProjectCellValue(sheet.createRow(rowIndex), 1, style, project);
                // 设置环评信息
                setEnvMangeEvaluateValue(workbook.getSheetAt(1), workbook.createCellStyle(), id);
                // 设置环保验收信息
                setEnvMangeCheckValue(workbook.getSheetAt(2), workbook.createCellStyle(), id);
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业环评环保管理-详情.xlsx", "UTF-8"));
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e){
            log.error("按模板导出文件失败", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("outputStream close", e);
                }
            }
        }
    }

    private void fillInfo(List<EnvMangeProject> list) {
        if (null == list || list.size() < 1) {
            return;
        }
        // 国民经济行业类别设置
        Map<String, IndustryCategory> inMap = industryCategoryService.selectIndustryCategoryMap();
        list.forEach( e -> {
            /* 类别示例
            "industryCategory": "94,610",
            "industryCategoryList": ["铜矿采选", "汽柴油车整车制造"],
            "industryCodeList": ["C1234","A12344"],
            "industryList": [[12,79,92,94],[12,79,92,610]],
            */
            if (StringUtils.isNotEmpty(e.getIndustryCategory())) {
                e.setIndustryCategoryList(new ArrayList<>());
                e.setIndustryCodeList(new ArrayList<>());
                e.setIndustryList(new ArrayList<>());
                for (String id : e.getIndustryCategory().split(",")) {
                    List<String> ids = new ArrayList<>();
                    try {
                        if (inMap.containsKey(id)) {
                            IndustryCategory in = inMap.get(id);
                            String cCode = industryCodes(inMap, ids, id);
                            e.getIndustryCodeList().add(cCode + in.getCode());
                            // 反转列表
                            Collections.reverse(ids);
                            e.getIndustryList().add(ids);
                            e.getIndustryCategoryList().add(in.getName());
                        }
                    } catch (Exception ex) {
                        log.error("", ex);
                    }
                }
            }
        });
    }

    private String industryCodes(Map<String, IndustryCategory> inMap, List<String> ids, String id){
        if (null == id || !inMap.containsKey(id)) {
            return "";
        }
        IndustryCategory in = inMap.get(id);
        ids.add(in.getId());
        if ("-1".equals(in.getPid())) {
            return in.getCode();
        }
        return industryCodes(inMap, ids, in.getPid());
    }

    /**
     * 设置导出文件的项目内容
     */
    private void setEnvMangeProjectCellValue(Row row, int index, CellStyle style, EnvMangeProject project) {
        int cellIndex = 0;
        // 序号
        Cell cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(index);
        // 企业名称
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getEntName());
        // 项目名称
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getProjectName());
        // 项目代码
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getProjectCode());
        // 项目性质
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getProjectNature());
        // 主要建设内容
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getMainContent());
        // 产品
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getProduct());
        // 产能
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getPCapacity());
        // 生产班制
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getProductShiftSys());
        // 建设地点
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getConstructSide());
        // 国民经济行业类别
        cell = CellUtils.getCell(row, cellIndex++, style);
        if (null != project.getIndustryCategoryList() && project.getIndustryCategoryList().size() > 0) {
            cell.setCellValue(String.join(", ", project.getIndustryCategoryList()));
        } else {
            cell.setCellValue(project.getConstructSide());
        }
        // 行业代码
        cell = CellUtils.getCell(row, cellIndex++, style);
        if (null != project.getIndustryCodeList() && project.getIndustryCodeList().size() > 0) {
            cell.setCellValue(String.join(", ", project.getIndustryCodeList()));
        } else {
            cell.setCellValue(project.getConstructSide());
        }
        // 环评等级
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(EnvManageGradeTypeEnum.getNameByCode(project.getGrade()));
        // 判断依据
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getJudgmentReason());
        // 用地面积(平米)
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(null == project.getLandArea() ? "" : Float.toString(project.getLandArea()));
        // 对外立项时间
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(null == project.getExtApprTime() ? "" : project.getExtApprTime().toString());
        // 开工时间
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(null == project.getCommenceTime() ? "" : project.getCommenceTime().toString());
        // 投产时间
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(null == project.getProductTime() ? "" : project.getProductTime().toString());
        // 主要环保设施
        cell = CellUtils.getCell(row, cellIndex++, style);
        cell.setCellValue(project.getMainEnvFacilities());
        // 备注
        cell = CellUtils.getCell(row, cellIndex, style);
        cell.setCellValue(project.getRemark());
    }

    private void setEnvMangeEvaluateValue(Sheet sheet, CellStyle style, String mProjectId) {
        List<EnvMangeEvaluate> list = envMangeEvaluateService.selectMangeEvaluateByProjectId(mProjectId);
        if (null == list || list.size() < 1) {
            return; 
        }
        int rowIndex = 3;// 首行
        Row templateRow = sheet.getRow(rowIndex);
        CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
        // 复制单元格样式
        CellUtils.copyCellStyle(templateStyle, style);
        int index = 0;
        Row row;
        Cell cell;
        for (EnvMangeEvaluate evaluate : list) {
            index++;
            sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
            row = sheet.createRow(rowIndex);
            rowIndex++;

            int cellIndex = 0;
            // 序号
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(index);
            // 环评层级
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(evaluate.getEiaLevel());
            // 审批部门
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(evaluate.getApprovalDepart());
            // 批复文号
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(evaluate.getReplyNo());
            // 评价机构
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(evaluate.getRatingAgency());
            // 主笔人员
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(evaluate.getLeadAuthor());
            // 评价费用(元)
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == evaluate.getRatingCost() ? "" : Float.toString(evaluate.getRatingCost()));
            // 主要污染物
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(evaluate.getPollutantCodeDesc());
            // 污染物总量(kg)
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == evaluate.getPollutantTotal() ? "" : Float.toString(evaluate.getPollutantTotal()));
            // 合同签订时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == evaluate.getContractTime() ? "" : evaluate.getContractTime().toString());
            // 报告提交时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == evaluate.getReportSubTime() ? "" : evaluate.getReportSubTime().toString());
            // 对外公示时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == evaluate.getPublicityTime() ? "" : evaluate.getPublicityTime().toString());
            // 批复时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == evaluate.getApprovalTime() ? "" : evaluate.getApprovalTime().toString());
            // 备注
            cell = CellUtils.getCell(row, cellIndex, style);
            cell.setCellValue(evaluate.getRemark());
        }
    }
    
    private void setEnvMangeCheckValue(Sheet sheet, CellStyle style, String mProjectId) {
        List<EnvMangeCheck> list = envMangeCheckService.selectMangeCheckByProjectId(mProjectId);
        if (null == list || list.size() < 1) {
            return;
        }
        int rowIndex = 3;// 首行
        Row templateRow = sheet.getRow(rowIndex);
        CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
        // 复制单元格样式
        CellUtils.copyCellStyle(templateStyle, style);
        int index = 0;
        Row row;
        Cell cell;
        for (EnvMangeCheck check : list) {
            index++;
            sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
            row = sheet.createRow(rowIndex);
            rowIndex++;

            int cellIndex = 0;
            // 序号
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(index);
            // 是否需验收批复，0否，1是
            cell = CellUtils.getCell(row, cellIndex++, style);
            if (null == check.getCheckReply() || check.getCheckReply() != 1) {
                cell.setCellValue("否");
                continue;
            }
            cell.setCellValue("是");
            // 审批部门
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(check.getApprovalDepart());
            // 批复文号
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(check.getReplyNo());
            // 验收监测机构
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(check.getCheckAgency());
            // 验收监测-开始时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == check.getCheckBeginTime() ? "" : check.getCheckBeginTime().toString());
            // 验收监测-结束时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == check.getCheckEndTime() ? "" : check.getCheckEndTime().toString());
            // 验收报告专家评审时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == check.getReviewTime() ? "" : check.getReviewTime().toString());
            // 验收报告专家评审主要问题
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(check.getReviewIssue());
            // 验收报告公式地址
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(check.getRecordAddress());
            // 验收报告公式-开始时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == check.getCheckRecordBeginTime() ? "" : check.getCheckRecordBeginTime().toString());
            // 验收报告公式-结束时间
            cell = CellUtils.getCell(row, cellIndex++, style);
            cell.setCellValue(null == check.getCheckRecordEndTime() ? "" : check.getCheckRecordEndTime().toString());
            // 备注
            cell = CellUtils.getCell(row, cellIndex, style);
            cell.setCellValue(check.getRemark());
        }
    }
    
    @Override
    @Log(title = "企业环评环保管理-项目", businessType = BusinessType.INSERT)
    public AjaxResult insertMangeProject(EnvMangeProject info) {
        if (StringUtils.isEmpty(info.getEntCode())) {
            info.setEntCode(SecurityUtils.getEntCode());
        }
        info.setMProjectId(UlidCreator.getMonotonicUlid().toString());
        int count = envMangeProjectMapper.insertMangeProject(info);
        if (count > 0 && null != info.getAnnexIds() && info.getAnnexIds().size() > 0) {
            annexService.updateAnnex(info.getMProjectId(), AnnexTypeEnum.entEnvMangeProject.name(), info.getAnnexIds());
        }
        return AjaxResult.success(info);
    }

    @Override
    @Log(title = "企业环评环保管理-项目", businessType = BusinessType.UPDATE)
    public AjaxResult updateMangeProject(EnvMangeProject info) {
        int count = envMangeProjectMapper.updateMangeProject(info);
        if (count > 0 ) {
            annexService.updateAnnex(info.getMProjectId(), AnnexTypeEnum.entEnvMangeProject.name(), info.getAnnexIds());
        }
        return AjaxResult.success();
    }

    @Override
    @Log(title = "企业环评环保管理-项目", businessType = BusinessType.DELETE)
    public AjaxResult deleteMangeProjectById(String id) {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("请求信息为空");
        }
        int count = envMangeProjectMapper.deleteMangeProjectById(id);
        if (count > 0) {
            // 删除企业环评环保管理-环评信息
            envMangeEvaluateService.deleteMangeEvaluateByProjectId(id);
            // 删除企业环评环保管理-环保验收信息
            envMangeCheckService.deleteMangeCheckByProjectId(id);
            // 删除项目附件
            annexService.updateAnnex(id, AnnexTypeEnum.entEnvMangeProject.name(), null);
        }
        return AjaxResult.success(count);
    }
}
