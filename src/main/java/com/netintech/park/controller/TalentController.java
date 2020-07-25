package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.Talent;
import com.netintech.park.domain.dto.AttachmentTalentDto;
import com.netintech.park.service.ITalentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人才信息Controller
 *
 * @author admin
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/netintech/talent")
public class TalentController extends BaseController
{
    private String prefix = "netintech/talent";

    @Autowired
    private ITalentService talentService;

    @RequiresPermissions("netintech:talent:view")
    @GetMapping()
    public String talent()
    {
        return prefix + "/talent";
    }
    /**
     * 查询人才信息列表
     */
    //@RequiresPermissions("netintech:talent:list")
    @PostMapping("/findAll")
    @ResponseBody
    public TableDataInfo findAll(Talent talent)
    {
        startPage();
        List<AttachmentTalentDto> all = talentService.findAll(talent);
        return getDataTable(all);
    }

    /**
     * 查询人才信息列表
     */
    @RequiresPermissions("netintech:talent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Talent talent)
    {
        startPage();
        List<Talent> list = talentService.selectTalentList(talent);
        return getDataTable(list);
    }

    /**
     * 导出人才信息列表
     */
    @RequiresPermissions("netintech:talent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Talent talent)
    {
        List<Talent> list = talentService.selectTalentList(talent);
        ExcelUtil<Talent> util = new ExcelUtil<Talent>(Talent.class);
        return util.exportExcel(list, "talent");
    }

    /**
     * 新增人才信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人才信息
     */
    @RequiresPermissions("netintech:talent:add")
    @Log(title = "人才信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Talent talent)
    {
        return toAjax(talentService.insertTalent(talent));
    }

    /**
     * 修改人才信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Talent talent = talentService.selectTalentById(id);
        mmap.put("talent", talent);
        return prefix + "/edit";
    }

    /**
     * 修改保存人才信息
     */
    @RequiresPermissions("netintech:talent:edit")
    @Log(title = "人才信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Talent talent)
    {
        return toAjax(talentService.updateTalent(talent));
    }

    /**
     * 查看人才信息
     */
    //@RequiresPermissions("netintech:talent:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
         AttachmentTalentDto talent = talentService.ListTalentById(id);
     // Talent talent = talentService.selectTalentById(id);
        mmap.put("talent", talent);
        return prefix + "/view";
    }
    /**
     * 删除人才信息
     */
    @RequiresPermissions("netintech:talent:remove")
    @Log(title = "人才信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(talentService.deleteTalentByIds(ids));
    }
}