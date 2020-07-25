package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.TalentRequirement;
import com.netintech.park.domain.dto.TalentRequirementDto;
import com.netintech.park.service.ITalentRequirementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人才需求信息Controller
 *
 * @author admin
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/netintech/talentRequirement")
public class TalentRequirementController extends BaseController
{
    private String prefix = "netintech/requirement";

    @Autowired
    private ITalentRequirementService talentRequirementService;

    @RequiresPermissions("netintech:requirement:view")
    @GetMapping()
    public String requirement()
    {
        return prefix + "/requirement";
    }

    /**
     * 查询人才需求信息列表
     */
   // @RequiresPermissions("netintech:requirement:list")
    @PostMapping("/findAll")
    @ResponseBody
    public TableDataInfo findAll(TalentRequirement talentRequirement)
    {
        startPage();
        List<TalentRequirementDto> list = talentRequirementService.findAll(talentRequirement);
        return getDataTable(list);
    }


    /**
     * 查询人才需求信息列表
     */
    @RequiresPermissions("netintech:requirement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TalentRequirement talentRequirement)
    {
        startPage();
        List<TalentRequirement> list = talentRequirementService.selectTalentRequirementList(talentRequirement);
        return getDataTable(list);
    }

    /**
     * 导出人才需求信息列表
     */
    @RequiresPermissions("netintech:requirement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TalentRequirement talentRequirement)
    {
        List<TalentRequirement> list = talentRequirementService.selectTalentRequirementList(talentRequirement);
        ExcelUtil<TalentRequirement> util = new ExcelUtil<TalentRequirement>(TalentRequirement.class);
        return util.exportExcel(list, "requirement");
    }

    /**
     * 新增人才需求信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人才需求信息
     */
    @RequiresPermissions("netintech:requirement:add")
    @Log(title = "人才需求信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TalentRequirement talentRequirement)
    {
        return toAjax(talentRequirementService.insertTalentRequirement(talentRequirement));
    }

    /**
     * 修改人才需求信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TalentRequirement talentRequirement = talentRequirementService.selectTalentRequirementById(id);
        mmap.put("talentRequirement", talentRequirement);
        return prefix + "/edit";
    }

    /**
     * 修改保存人才需求信息
     */
    @RequiresPermissions("netintech:requirement:edit")
    @Log(title = "人才需求信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TalentRequirement talentRequirement)
    {
        return toAjax(talentRequirementService.updateTalentRequirement(talentRequirement));
    }

    /**
     * 查看人才需求信息
     */
    @RequiresPermissions("netintech:requirement:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        TalentRequirementDto talentRequirement = talentRequirementService.findById(id);
        mmap.put("talentRequirement", talentRequirement);
        return prefix + "/view";
    }
    /**
     * 删除人才需求信息
     */
    @RequiresPermissions("netintech:requirement:remove")
    @Log(title = "人才需求信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(talentRequirementService.deleteTalentRequirementByIds(ids));
    }
}