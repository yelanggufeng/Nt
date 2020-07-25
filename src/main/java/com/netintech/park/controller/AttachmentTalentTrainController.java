package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.AttachmentTalentTrain;
import com.netintech.park.service.IAttachmentTalentTrainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人才培训信息图片附件Controller
 *
 * @author admin
 * @date 2020-07-19
 */
@Controller
@RequestMapping("/netintech/attachmentTalentTrain")
public class AttachmentTalentTrainController extends BaseController
{
    private String prefix = "netintech/train";

    @Autowired
    private IAttachmentTalentTrainService attachmentTalentTrainService;

    @RequiresPermissions("netintech:train:view")
    @GetMapping()
    public String train()
    {
        return prefix + "/train";
    }

    /**
     * 查询人才培训信息图片附件列表
     */
    @RequiresPermissions("netintech:train:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AttachmentTalentTrain attachmentTalentTrain)
    {
        startPage();
        List<AttachmentTalentTrain> list = attachmentTalentTrainService.selectAttachmentTalentTrainList(attachmentTalentTrain);
        return getDataTable(list);
    }

    /**
     * 导出人才培训信息图片附件列表
     */
    @RequiresPermissions("netintech:train:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AttachmentTalentTrain attachmentTalentTrain)
    {
        List<AttachmentTalentTrain> list = attachmentTalentTrainService.selectAttachmentTalentTrainList(attachmentTalentTrain);
        ExcelUtil<AttachmentTalentTrain> util = new ExcelUtil<AttachmentTalentTrain>(AttachmentTalentTrain.class);
        return util.exportExcel(list, "train");
    }

    /**
     * 新增人才培训信息图片附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人才培训信息图片附件
     */
    @RequiresPermissions("netintech:train:add")
    @Log(title = "人才培训信息图片附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AttachmentTalentTrain attachmentTalentTrain)
    {
        return toAjax(attachmentTalentTrainService.insertAttachmentTalentTrain(attachmentTalentTrain));
    }

    /**
     * 修改人才培训信息图片附件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentTalentTrain attachmentTalentTrain = attachmentTalentTrainService.selectAttachmentTalentTrainById(id);
        mmap.put("attachmentTalentTrain", attachmentTalentTrain);
        return prefix + "/edit";
    }

    /**
     * 修改保存人才培训信息图片附件
     */
    @RequiresPermissions("netintech:train:edit")
    @Log(title = "人才培训信息图片附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AttachmentTalentTrain attachmentTalentTrain)
    {
        return toAjax(attachmentTalentTrainService.updateAttachmentTalentTrain(attachmentTalentTrain));
    }

    /**
     * 查看人才培训信息图片附件
     */
    @RequiresPermissions("netintech:train:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        AttachmentTalentTrain attachmentTalentTrain = attachmentTalentTrainService.selectAttachmentTalentTrainById(id);
        mmap.put("attachmentTalentTrain", attachmentTalentTrain);
        return prefix + "/view";
    }
    /**
     * 删除人才培训信息图片附件
     */
    @RequiresPermissions("netintech:train:remove")
    @Log(title = "人才培训信息图片附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(attachmentTalentTrainService.deleteAttachmentTalentTrainByIds(ids));
    }
}