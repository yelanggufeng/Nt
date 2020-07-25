package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.AttachmentLoanRequirement;
import com.netintech.park.service.IAttachmentLoanRequirementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 贷款需求信息附件Controller
 *
 * @author ltc
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/netintech/attachment")
public class AttachmentLoanRequirementController extends BaseController
{
    private String prefix = "netintech/requirement";

    @Autowired
    private IAttachmentLoanRequirementService attachmentLoanRequirementService;

    @RequiresPermissions("netintech:requirement:view")
    @GetMapping()
    public String requirement()
    {
        return prefix + "/requirement";
    }

    /**
     * 查询贷款需求信息附件列表
     */
    @RequiresPermissions("netintech:requirement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AttachmentLoanRequirement attachmentLoanRequirement)
    {
        startPage();
        List<AttachmentLoanRequirement> list = attachmentLoanRequirementService.selectAttachmentLoanRequirementList(attachmentLoanRequirement);
        return getDataTable(list);
    }

    /**
     * 导出贷款需求信息附件列表
     */
    @RequiresPermissions("netintech:requirement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AttachmentLoanRequirement attachmentLoanRequirement)
    {
        List<AttachmentLoanRequirement> list = attachmentLoanRequirementService.selectAttachmentLoanRequirementList(attachmentLoanRequirement);
        ExcelUtil<AttachmentLoanRequirement> util = new ExcelUtil<AttachmentLoanRequirement>(AttachmentLoanRequirement.class);
        return util.exportExcel(list, "requirement");
    }

    /**
     * 新增贷款需求信息附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存贷款需求信息附件
     */
    @RequiresPermissions("netintech:requirement:add")
    @Log(title = "贷款需求信息附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AttachmentLoanRequirement attachmentLoanRequirement)
    {
        return toAjax(attachmentLoanRequirementService.insertAttachmentLoanRequirement(attachmentLoanRequirement));
    }

    /**
     * 修改贷款需求信息附件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentLoanRequirement attachmentLoanRequirement = attachmentLoanRequirementService.selectAttachmentLoanRequirementById(id);
        mmap.put("attachmentLoanRequirement", attachmentLoanRequirement);
        return prefix + "/edit";
    }

    /**
     * 修改保存贷款需求信息附件
     */
    @RequiresPermissions("netintech:requirement:edit")
    @Log(title = "贷款需求信息附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AttachmentLoanRequirement attachmentLoanRequirement)
    {
        return toAjax(attachmentLoanRequirementService.updateAttachmentLoanRequirement(attachmentLoanRequirement));
    }

    /**
     * 查看贷款需求信息附件
     */
    @RequiresPermissions("netintech:requirement:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentLoanRequirement attachmentLoanRequirement = attachmentLoanRequirementService.selectAttachmentLoanRequirementById(id);
        mmap.put("attachmentLoanRequirement", attachmentLoanRequirement);
        return prefix + "/view";
    }
    /**
     * 删除贷款需求信息附件
     */
    @RequiresPermissions("netintech:requirement:remove")
    @Log(title = "贷款需求信息附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(attachmentLoanRequirementService.deleteAttachmentLoanRequirementByIds(ids));
    }
}