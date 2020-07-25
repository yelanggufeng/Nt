package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.AttachmentTalentValueAdd;
import com.netintech.park.service.IAttachmentTalentValueAddService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人才增值服务信息图片附件Controller
 *
 * @author admin
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/netintech/attachmentTalentValue")
public class AttachmentTalentValueAddController extends BaseController
{
    private String prefix = "netintech/add";

    @Autowired
    private IAttachmentTalentValueAddService attachmentTalentValueAddService;

    @RequiresPermissions("netintech:add:view")
    @GetMapping()
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 查询人才增值服务信息图片附件列表
     */
    @RequiresPermissions("netintech:add:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AttachmentTalentValueAdd attachmentTalentValueAdd)
    {
        startPage();
        List<AttachmentTalentValueAdd> list = attachmentTalentValueAddService.selectAttachmentTalentValueAddList(attachmentTalentValueAdd);
        return getDataTable(list);
    }

    /**
     * 导出人才增值服务信息图片附件列表
     */
    @RequiresPermissions("netintech:add:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AttachmentTalentValueAdd attachmentTalentValueAdd)
    {
        List<AttachmentTalentValueAdd> list = attachmentTalentValueAddService.selectAttachmentTalentValueAddList(attachmentTalentValueAdd);
        ExcelUtil<AttachmentTalentValueAdd> util = new ExcelUtil<AttachmentTalentValueAdd>(AttachmentTalentValueAdd.class);
        return util.exportExcel(list, "add");
    }

    /**
     * 新增人才增值服务信息图片附件
     */
    @GetMapping("/add")
    public String attachmentTalentValueAdd()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人才增值服务信息图片附件
     */
    @RequiresPermissions("netintech:add:add")
    @Log(title = "人才增值服务信息图片附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AttachmentTalentValueAdd attachmentTalentValueAdd)
    {
        return toAjax(attachmentTalentValueAddService.insertAttachmentTalentValueAdd(attachmentTalentValueAdd));
    }

    /**
     * 修改人才增值服务信息图片附件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentTalentValueAdd attachmentTalentValueAdd = attachmentTalentValueAddService.selectAttachmentTalentValueAddById(id);
        mmap.put("attachmentTalentValueAdd", attachmentTalentValueAdd);
        return prefix + "/edit";
    }

    /**
     * 修改保存人才增值服务信息图片附件
     */
    @RequiresPermissions("netintech:add:edit")
    @Log(title = "人才增值服务信息图片附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AttachmentTalentValueAdd attachmentTalentValueAdd)
    {
        return toAjax(attachmentTalentValueAddService.updateAttachmentTalentValueAdd(attachmentTalentValueAdd));
    }

    /**
     * 查看人才增值服务信息图片附件
     */
    @RequiresPermissions("netintech:add:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentTalentValueAdd attachmentTalentValueAdd = attachmentTalentValueAddService.selectAttachmentTalentValueAddById(id);
        mmap.put("attachmentTalentValueAdd", attachmentTalentValueAdd);
        return prefix + "/view";
    }
    /**
     * 删除人才增值服务信息图片附件
     */
    @RequiresPermissions("netintech:add:remove")
    @Log(title = "人才增值服务信息图片附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(attachmentTalentValueAddService.deleteAttachmentTalentValueAddByIds(ids));
    }
}