package com.ruoyi.business.envProt.service.impl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.business.annex.service.AnnexService;
import com.ruoyi.business.base.domain.TBasPollutantCode;
import com.ruoyi.business.base.mapper.TBasPollutantCodeMapper;
import com.ruoyi.business.envProt.domain.*;
import com.ruoyi.business.envProt.mapper.EntOutPollutantPermitMapper;
import com.ruoyi.business.envProt.service.EntOutPollutantPermitService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.CellUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.service.ISysDictDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 企业排污许可基础Service业务层处理
 */
@Slf4j
@Service
public class EntOutPollutantPermitServiceImpl implements EntOutPollutantPermitService {

    private EntOutPollutantPermitMapper entOutPollutantPermitMapper;
    @Autowired
    public void setEntOutPollutantPermitMapper(EntOutPollutantPermitMapper entOutPollutantPermitMapper) {
        this.entOutPollutantPermitMapper = entOutPollutantPermitMapper;
    }

    private AnnexService annexService;
    @Autowired
    public void setAnnexService(AnnexService annexService) {
        this.annexService = annexService;
    }

    private TBasPollutantCodeMapper tBasPollutantCodeMapper;
    @Autowired
    public void setTBasPollutantCodeMapper(TBasPollutantCodeMapper tBasPollutantCodeMapper) {
        this.tBasPollutantCodeMapper = tBasPollutantCodeMapper;
    }

    private ISysDictDataService dictDataService;
    @Autowired
    public void setISysDictDataService(ISysDictDataService dictDataService) {
        this.dictDataService = dictDataService;
    }

    @Override
    public AjaxResult selectEntOutPollutantPermitList(EntOutPollutantPermitReq req) {
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new EntOutPollutantPermitReq();
        }
        if (null == req.getCurrent() || req.getCurrent() < 1) {
            req.setCurrent(1);
        }
        if (null == req.getSize() || req.getSize() < 1) {
            req.setSize(10);
        }
        // 添加权限
        if (SecurityUtils.isNotAdmin()) {
            req.setEntCodes(SecurityUtils.getEntCodes());
        }
        PageHelper.startPage(req.getCurrent(), req.getSize());
        List<EntOutPollutantPermit> list = entOutPollutantPermitMapper.selectEntOutPollutantPermitList(req);
        // 设置污染物信息
        fillPoll(list);
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    private void fillPoll(List<EntOutPollutantPermit> list) {
        if (null == list || list.size() < 1) {
            return;
        }
        // 获取所有污染物code和name的对应关系
        List<TBasPollutantCode> codeList = tBasPollutantCodeMapper.selectTBasPollutantCodeList(null);
        Map<String, String> codeMap = codeList.stream().collect(Collectors.toMap(TBasPollutantCode::getPollutantCode, TBasPollutantCode::getPollutantNameCn));
        StringBuilder bu;
        for (EntOutPollutantPermit p : list) {
            if (null != p.getGasPollType()) {
                bu = new StringBuilder();
                for (String code : p.getGasPollType().split(",")) {
                    bu.append(codeMap.get(code)).append(",");
                }
                p.setGasPollDesc(bu.substring(0, bu.length() - 1));
            }
            if (null != p.getWaterPollType()) {
                bu = new StringBuilder();
                for (String code : p.getWaterPollType().split(",")) {
                    bu.append(codeMap.get(code)).append(",");
                }
                p.setWaterPollDesc(bu.substring(0, bu.length() - 1));
            }
        }
        /*
        获取信息
         ent_product: 企业产品
         poll_permit_cate: 排污许可管理类别
         emission_rule_gas: 废气排放规律
         emission_rule_water: 废水排放规律
         */
        List<String> dictTypes = Arrays.asList("ent_product", "poll_permit_cate", "emission_rule_gas", "emission_rule_water");
        List<SysDictData> dictList = dictDataService.getDictDataListByTypes(dictTypes);
        if (null != dictList && dictList.size() > 0) {
            /* dictLabel: "工程车辆"; dictType: "ent_product"; dictValue: "gccl" */
            Map<String, String> proMap = new HashMap<>();
            Map<String, String> perMap = new HashMap<>();
            Map<String, String> gasMap = new HashMap<>();
            Map<String, String> waterMap = new HashMap<>();
            dictList.forEach( e -> {
                String dictType = e.getDictType();
                if ("ent_product".equals(dictType)) {
                    proMap.put(e.getDictValue(), e.getDictLabel());
                } else if ("poll_permit_cate".equals(dictType)) {
                    perMap.put(e.getDictValue(), e.getDictLabel());
                } else if ("emission_rule_gas".equals(dictType)) {
                    gasMap.put(e.getDictValue(), e.getDictLabel());
                } else if ("emission_rule_water".equals(dictType)) {
                    waterMap.put(e.getDictValue(), e.getDictLabel());
                }
            });
            for (EntOutPollutantPermit p : list) {
                if (null != p.getProductIds()) {
                    bu = new StringBuilder();
                    for (String id : p.getProductIds().split(",")) {
                        bu.append(proMap.get(id)).append(",");
                    }
                    p.setProductDesc(bu.substring(0, bu.length() - 1));
                }
                p.setPermitLevelDesc(perMap.get(p.getPermitLevel()));
                p.setGasEmissionRuleDesc(gasMap.get(p.getGasEmissionRule()));
                p.setWaterEmissionRuleDesc(waterMap.get(p.getWaterEmissionRule()));
            }
        }
    }

    @Override
    @Log(title = "企业排污许可基础", businessType = BusinessType.EXPORT)
    public void exportEntOutPollutantPermit(EntOutPollutantPermitReq req, HttpServletResponse response) {
        if (null == req) {
            req = new EntOutPollutantPermitReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/排污许可列表模版.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            // 添加权限
            if (SecurityUtils.isNotAdmin()) {
                req.setEntCodes(SecurityUtils.getEntCodes());
            }
            List<EntOutPollutantPermit> list = entOutPollutantPermitMapper.selectEntOutPollutantPermitList(req);
            // 设置污染物信息
            fillPoll(list);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex= 4;// 从第5行开始插入

            rowIndex = 3;// 首行
            Row templateRow = sheet.getRow(rowIndex);
            CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
            CellStyle style = workbook.createCellStyle();
            // 复制单元格样式
            CellUtils.copyCellStyle(templateStyle, style);
            if (null != list && list.size() > 0) {
                int index = 0;
                Row row;
                Cell cell;
                for (EntOutPollutantPermit permit : list) {
                    index++;
                    sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                    row = sheet.createRow(rowIndex);
                    rowIndex++;

                    int cellIndex = 0;
                    // 序号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(index);
                    // 企业名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getEntName());
                    // 持证单位名称
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getCertUnitName());
                    // 社会信用代码
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getCertUnitCode());
                    // 排污许可管理类别
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getPermitLevelDesc());
                    // 许可证编号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getPermitNum());
                    // 有效期
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getBeginDate() + "至" + permit.getEndDate());
                    // 发证机关
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getIssueOffice());
                    // 发证日期
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getIssueDate());
                    // 执行报告报送要求
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getReportRequire());
                    // 主要产品
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getProductDesc());
                    // 产量
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(null == permit.getProductOutput() ? "" : String.valueOf(permit.getProductOutput()));
                    // 平台账号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getAccount());
                    // 密码
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getPassword());
                    // 废气污染物种类(pollutantCodes)
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getGasPollDesc());
                    // 废气排放规律
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getGasEmissionRuleDesc());
                    // 废气执行标准
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getGasExecuteStandard());
                    // 废水污染物种类(pollutantCodes)
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getWaterPollDesc());
                    // 废水排放规律
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getWaterEmissionRuleDesc());
                    // 废水执行标准
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(permit.getWaterExecuteStandard());
                    // 备注
                    cell = CellUtils.getCell(row, cellIndex, style);
                    cell.setCellValue(permit.getRemark());
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业排序许可列表.xlsx", "UTF-8"));
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e){
            log.error("按模板导出文件失败", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    @Log(title = "企业排污许可基础", businessType = BusinessType.INSERT)
    public AjaxResult insertEntOutPollutantPermit(EntOutPollutantPermit permit) {
        permit.setPollPermitId(UlidCreator.getMonotonicUlid().toString());
        permit.setCreateUser(SecurityUtils.getUserName());
        permit.setCreateTime(LocalDateTime.now());
        permit.setUpdateUser(permit.getCreateUser());
        permit.setUpdateTime(permit.getCreateTime());
        int count = entOutPollutantPermitMapper.insertEntOutPollutantPermit(permit);
        if (count > 0 && null != permit.getAnnexIds() && permit.getAnnexIds().size() > 0) {
            annexService.updateAnnex(permit.getPollPermitId(), Constants.ANNEX_EntOutPollutantPermit, permit.getAnnexIds());
        }
        return AjaxResult.success(count);
    }

    @Override
    @Log(title = "企业排污许可基础", businessType = BusinessType.UPDATE)
    public AjaxResult updateEntOutPollutantPermit(EntOutPollutantPermit permit) {
        permit.setUpdateUser(SecurityUtils.getUserName());
        permit.setUpdateTime(LocalDateTime.now());
        return AjaxResult.success(entOutPollutantPermitMapper.updateEntOutPollutantPermit(permit));
    }

    @Override
    @Log(title = "企业排污许可基础", businessType = BusinessType.DELETE)
    public AjaxResult deleteEntOutPollutantPermitByPollPermitIds(List<String> pollPermitIds) {
        if (null == pollPermitIds || pollPermitIds.size() < 1) {
            return AjaxResult.error("请求信息为空");
        }
        int count = entOutPollutantPermitMapper.deleteEntOutPollutantPermitByPollPermitIds(pollPermitIds);
        if (count > 0) {
            // 删除对应的排污许可总量
            entOutPollutantPermitMapper.deleteEntOutPollutantPermitCountByPollPermitIds(pollPermitIds);
            // 删除附件
            pollPermitIds.forEach( e -> annexService.updateAnnex(e, Constants.ANNEX_EntOutPollutantPermit, null));
        }
        return AjaxResult.success(count);
    }

    @Override
    public AjaxResult selectEntOutPollutantPermitCountList(EntOutPollutantPermitCountReq req) {
        AjaxResult result = AjaxResult.success();
        if (null == req) {
            req = new EntOutPollutantPermitCountReq();
        }
        if (null == req.getCurrent() || req.getCurrent() < 1) {
            req.setCurrent(1);
        }
        if (null == req.getSize() || req.getSize() < 1) {
            req.setSize(10);
        }
        PageHelper.startPage(req.getCurrent(), req.getSize());
        List<EntOutPollutantPermitCount> list = entOutPollutantPermitMapper.selectEntOutPollutantPermitCountList(req);
        result.put("data", list);
        result.put("total", new PageInfo<>(list).getTotal());
        PageUtils.clearPage();
        return result;
    }

    @Override
    @Log(title = "企业排污许可总量基础", businessType = BusinessType.EXPORT)
    public void exportEntOutPollutantPermitCount(EntOutPollutantPermitCountReq req, HttpServletResponse response) {
        if (null == req) {
            req = new EntOutPollutantPermitCountReq();
        }
        OutputStream outputStream = null;
        try {
            String templatePath = "template/排污许可列表许可总量模版.xlsx";
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath);
            if (fis == null) {
                log.error("无法从路径加载资源: " + templatePath);
                return;
            }
            List<EntOutPollutantPermitCount> list = entOutPollutantPermitMapper.selectEntOutPollutantPermitCountList(req);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex= 4;// 从第5行开始插入

            rowIndex = 1;// 首行
            Row templateRow = sheet.getRow(rowIndex);
            CellStyle templateStyle = templateRow.getCell(0).getCellStyle(); // 假设获取第一列的样式
            CellStyle style = workbook.createCellStyle();
            // 复制单元格样式
            CellUtils.copyCellStyle(templateStyle, style);
            if (null != list && list.size() > 0) {
                int index = 0;
                Row row;
                Cell cell;
                for (EntOutPollutantPermitCount count : list) {
                    index++;
                    sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                    row = sheet.createRow(rowIndex);
                    rowIndex++;

                    int cellIndex = 0;
                    // 序号
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(index);
                    // 年份
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(count.getPermitYear());
                    // 污染因子类型
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    if (null == count.getPollType()) {
                        cell.setCellValue("");
                    } else if (1 == count.getPollType()) {
                        cell.setCellValue("废水");
                    } else if (2 == count.getPollType()) {
                        cell.setCellValue("废气");
                    } else if (3 == count.getPollType()) {
                        cell.setCellValue("无组织");
                    }
                    // 污染因子
                    cell = CellUtils.getCell(row, cellIndex++, style);
                    cell.setCellValue(count.getPollutantNameCn());
                    // 许可总量（t/a）
                    cell = CellUtils.getCell(row, cellIndex, style);
                    cell.setCellValue(null == count.getPermitCount() ? "" : Double.toString(count.getPermitCount()));
                }
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("企业排污许可总量列表.xlsx", "UTF-8"));
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e){
            log.error("按模板导出文件失败", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    @Log(title = "企业排污许可总量基础", businessType = BusinessType.INSERT)
    public AjaxResult insertEntOutPollutantPermitCount(EntOutPollutantPermitCount count) {
        count.setPollPermitCountId(UlidCreator.getMonotonicUlid().toString());
        count.setCreateTime(LocalDateTime.now());
        count.setCreateUser(SecurityUtils.getUserName());
        count.setUpdateUser(count.getCreateUser());
        count.setUpdateTime(count.getCreateTime());
        return AjaxResult.success(entOutPollutantPermitMapper.insertEntOutPollutantPermitCount(count));
    }

    @Override
    @Log(title = "企业排污许可总量基础", businessType = BusinessType.UPDATE)
    public AjaxResult updateEntOutPollutantPermitCount(EntOutPollutantPermitCount count) {
        count.setUpdateUser(count.getCreateUser());
        count.setUpdateTime(count.getCreateTime());
        return AjaxResult.success(entOutPollutantPermitMapper.updateEntOutPollutantPermitCount(count));
    }

    @Override
    @Log(title = "企业排污许可总量基础", businessType = BusinessType.DELETE)
    public AjaxResult deleteEntOutPollutantPermitCountByPollPermitIds(List<String> pollPermitIds) {
        if (null == pollPermitIds || pollPermitIds.size() < 1) {
            return AjaxResult.error("请求信息为空");
        }
        return AjaxResult.success(entOutPollutantPermitMapper.deleteEntOutPollutantPermitCountByPollPermitCountIds(pollPermitIds));
    }
}
