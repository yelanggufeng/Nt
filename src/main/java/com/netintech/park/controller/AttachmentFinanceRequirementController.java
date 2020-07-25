package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.AttachmentFinanceRequirement;
import com.netintech.park.service.IAttachmentFinanceRequirementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 融资需求信息表图片附件Controller
 *
 * @author admin
 * @date 2020-07-16
 */
@Controller
@RequestMapping("/netintech/attachmentFinance")
public class AttachmentFinanceRequirementController extends BaseController
{
    private String prefix = "netintech/attachmentFinance";

    @Autowired
    private IAttachmentFinanceRequirementService attachmentFinanceRequirementService;

    @RequiresPermissions("netintech:requirement:view")
    @GetMapping()
    public String requirement()
    {
        return prefix + "/requirement";
    }

    /**
     * 查询技术成果需求信息图片附件列表
     */
    @RequiresPermissions("netintech:requirement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AttachmentFinanceRequirement attachmentFinanceRequirement)
    {
        startPage();
        List<AttachmentFinanceRequirement> list = attachmentFinanceRequirementService.selectAttachmentFinanceRequirementList(attachmentFinanceRequirement);
        return getDataTable(list);
    }

    /**
     * 导出技术成果需求信息图片附件列表
     */
    @RequiresPermissions("netintech:requirement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AttachmentFinanceRequirement attachmentFinanceRequirement)
    {
        List<AttachmentFinanceRequirement> list = attachmentFinanceRequirementService.selectAttachmentFinanceRequirementList(attachmentFinanceRequirement);
        ExcelUtil<AttachmentFinanceRequirement> util = new ExcelUtil<AttachmentFinanceRequirement>(AttachmentFinanceRequirement.class);
        return util.exportExcel(list, "requirement");
    }

    /**
     * 新增技术成果需求信息图片附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存技术成果需求信息图片附件
     */
    @RequiresPermissions("netintech:requirement:add")
    @Log(title = "技术成果需求信息图片附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AttachmentFinanceRequirement attachmentFinanceRequirement)
    {
        return toAjax(attachmentFinanceRequirementService.insertAttachmentFinanceRequirement(attachmentFinanceRequirement));
    }

    /**
     * 修改技术成果需求信息图片附件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentFinanceRequirement attachmentFinanceRequirement = attachmentFinanceRequirementService.selectAttachmentFinanceRequirementById(id);
        mmap.put("attachmentFinanceRequirement", attachmentFinanceRequirement);
        return prefix + "/edit";
    }

    /**
     * 修改保存技术成果需求信息图片附件
     */
    @RequiresPermissions("netintech:requirement:edit")
    @Log(title = "技术成果需求信息图片附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AttachmentFinanceRequirement attachmentFinanceRequirement)
    {
        return toAjax(attachmentFinanceRequirementService.updateAttachmentFinanceRequirement(attachmentFinanceRequirement));
    }

    /**
     * 查看技术成果需求信息图片附件
     */
    @RequiresPermissions("netintech:requirement:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentFinanceRequirement attachmentFinanceRequirement = attachmentFinanceRequirementService.selectAttachmentFinanceRequirementById(id);
        mmap.put("attachmentFinanceRequirement", attachmentFinanceRequirement);
        return prefix + "/view";
    }
    /**
     * 删除技术成果需求信息图片附件
     */
    @RequiresPermissions("netintech:requirement:remove")
    @Log(title = "技术成果需求信息图片附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(attachmentFinanceRequirementService.deleteAttachmentFinanceRequirementByIds(ids));
    }
}