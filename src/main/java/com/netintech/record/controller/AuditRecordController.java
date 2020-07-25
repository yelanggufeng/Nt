package com.netintech.record.controller;


import com.netintech.achievement.service.ITechnologyAchievementService;
import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.property.service.IIntellectualPropertyService;
import com.netintech.record.domain.AuditRecord;
import com.netintech.record.service.IAuditRecordService;
import com.netintech.requirement.service.ICrowdsourcingRequirementService;
import com.netintech.requirement.service.ITechnologyRequirementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 技术成果审核记录信息Controller
 *
 * @author admin
 * @date 2020-06-17
 */
@Controller
@RequestMapping("/audit/record")
public class AuditRecordController extends BaseController
{
    private String prefix = "audit/record";

    @Autowired
    private IAuditRecordService auditRecordService;
    @Autowired
    private ITechnologyAchievementService technologyAchievementService;
    @Autowired
    private ITechnologyRequirementService technologyRequirementService;
    @Autowired
    private ICrowdsourcingRequirementService crowdsourcingRequirementService;
    @Autowired
    private IIntellectualPropertyService intellectualPropertyService;

    @RequiresPermissions("audit:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询技术成果审核记录信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AuditRecord auditRecord)
    {
        startPage();
        List<AuditRecord> list = auditRecordService.selectAuditRecordList(auditRecord);
        return getDataTable(list);
    }

    /**
     * 导出技术成果审核记录信息列表
     */
    @RequiresPermissions("audit:record:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuditRecord auditRecord)
    {
        List<AuditRecord> list = auditRecordService.selectAuditRecordList(auditRecord);
        ExcelUtil<AuditRecord> util = new ExcelUtil<AuditRecord>(AuditRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增技术成果审核记录信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存技术成果审核记录信息
     */
    @Log(title = "技术成果审核记录信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AuditRecord auditRecord)
    {
        Long infoId = auditRecord.getInfoId();
        String auditResult = auditRecord.getAuditResult();
        Integer typeId = auditRecord.getTypeId();
        if(typeId==1){//修改技术成果审核状态
            technologyAchievementService.updateTechnologyAchievementStatus(infoId,auditResult);
        }
        if(typeId==2){//修改技术需求状态
            technologyRequirementService.updateTechnologyRequirementStatus(infoId,auditResult);
        }
        if(typeId==3){//修改创新众包状态
            crowdsourcingRequirementService.updateCrowdsourcingRequirementStatus(infoId,auditResult);
        }
        if(typeId==4){//修改专利知识状态
            intellectualPropertyService.updateIntellectualPropertyStatus(infoId,auditResult);
        }
        return toAjax(auditRecordService.insertAuditRecord(auditRecord));
    }

    /**
     * 修改技术成果审核记录信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AuditRecord auditRecord = auditRecordService.selectAuditRecordById(id);
        mmap.put("auditRecord", auditRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存技术成果审核记录信息
     */
    @RequiresPermissions("audit:record:edit")
    @Log(title = "技术成果审核记录信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AuditRecord auditRecord)
    {
        return toAjax(auditRecordService.updateAuditRecord(auditRecord));
    }

    /**
     * 查看技术成果审核记录信息
     */
    @RequiresPermissions("audit:record:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        AuditRecord auditRecord = auditRecordService.selectAuditRecordById(id);
        mmap.put("auditRecord", auditRecord);
        return prefix + "/view";
    }
    /**
     * 删除技术成果审核记录信息
     */
    @RequiresPermissions("audit:record:remove")
    @Log(title = "技术成果审核记录信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(auditRecordService.deleteAuditRecordByIds(ids));
    }
}
