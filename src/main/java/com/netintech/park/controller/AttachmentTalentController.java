package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.AttachmentTalent;
import com.netintech.park.service.IAttachmentTalentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人才信息图片附件Controller
 *
 * @author admin
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/netintech/attachmentTalent")
public class AttachmentTalentController extends BaseController
{
    private String prefix = "netintech/talent";

    @Autowired
    private IAttachmentTalentService attachmentTalentService;

    @RequiresPermissions("netintech:talent:view")
    @GetMapping()
    public String talent()
    {
        return prefix + "/talent";
    }

    /**
     * 查询人才信息图片附件列表
     */
    @RequiresPermissions("netintech:talent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AttachmentTalent attachmentTalent)
    {
        startPage();
        List<AttachmentTalent> list = attachmentTalentService.selectAttachmentTalentList(attachmentTalent);
        return getDataTable(list);
    }

    /**
     * 导出人才信息图片附件列表
     */
    @RequiresPermissions("netintech:talent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AttachmentTalent attachmentTalent)
    {
        List<AttachmentTalent> list = attachmentTalentService.selectAttachmentTalentList(attachmentTalent);
        ExcelUtil<AttachmentTalent> util = new ExcelUtil<AttachmentTalent>(AttachmentTalent.class);
        return util.exportExcel(list, "talent");
    }

    /**
     * 新增人才信息图片附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人才信息图片附件
     */
    @RequiresPermissions("netintech:talent:add")
    @Log(title = "人才信息图片附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AttachmentTalent attachmentTalent)
    {
        return toAjax(attachmentTalentService.insertAttachmentTalent(attachmentTalent));
    }

    /**
     * 修改人才信息图片附件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentTalent attachmentTalent = attachmentTalentService.selectAttachmentTalentById(id);
        mmap.put("attachmentTalent", attachmentTalent);
        return prefix + "/edit";
    }

    /**
     * 修改保存人才信息图片附件
     */
    @RequiresPermissions("netintech:talent:edit")
    @Log(title = "人才信息图片附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AttachmentTalent attachmentTalent)
    {
        return toAjax(attachmentTalentService.updateAttachmentTalent(attachmentTalent));
    }

    /**
     * 查看人才信息图片附件
     */
    @RequiresPermissions("netintech:talent:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentTalent attachmentTalent = attachmentTalentService.selectAttachmentTalentById(id);
        mmap.put("attachmentTalent", attachmentTalent);
        return prefix + "/view";
    }
    /**
     * 删除人才信息图片附件
     */
    @RequiresPermissions("netintech:talent:remove")
    @Log(title = "人才信息图片附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(attachmentTalentService.deleteAttachmentTalentByIds(ids));
    }
}