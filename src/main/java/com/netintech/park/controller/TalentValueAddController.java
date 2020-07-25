package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.TalentValueAdd;
import com.netintech.park.domain.dto.TalentValueAddDto;
import com.netintech.park.service.ITalentValueAddService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人才增值服务信息Controller
 *
 * @author admin
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/netintech/talentAdd")
public class TalentValueAddController extends BaseController
{
    private String prefix = "netintech/add";

    @Autowired
    private ITalentValueAddService talentValueAddService;

    @RequiresPermissions("netintech:add:view")
    @GetMapping()
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 查询人才增值服务信息列表
     */
   // @RequiresPermissions("netintech:add:list")
    @PostMapping("/findAll")
    @ResponseBody
    public TableDataInfo findAll(TalentValueAdd talentValueAdd)
    {
        startPage();
        List<TalentValueAddDto> list = talentValueAddService.findAll(talentValueAdd);
        return getDataTable(list);
    }

    /**
     * 查询人才增值服务信息列表
     */
    @RequiresPermissions("netintech:add:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TalentValueAdd talentValueAdd)
    {
        startPage();
        List<TalentValueAdd> list = talentValueAddService.selectTalentValueAddList(talentValueAdd);
        return getDataTable(list);
    }

    /**
     * 导出人才增值服务信息列表
     */
    @RequiresPermissions("netintech:add:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TalentValueAdd talentValueAdd)
    {
        List<TalentValueAdd> list = talentValueAddService.selectTalentValueAddList(talentValueAdd);
        ExcelUtil<TalentValueAdd> util = new ExcelUtil<TalentValueAdd>(TalentValueAdd.class);
        return util.exportExcel(list, "add");
    }

    /**
     * 新增人才增值服务信息
     */
    @GetMapping("/talentAdd")
    public String talentAdd()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人才增值服务信息
     */
    @RequiresPermissions("netintech:add:add")
    @Log(title = "人才增值服务信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TalentValueAdd talentValueAdd)
    {
        return toAjax(talentValueAddService.insertTalentValueAdd(talentValueAdd));
    }

    /**
     * 修改人才增值服务信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TalentValueAdd talentValueAdd = talentValueAddService.selectTalentValueAddById(id);
        mmap.put("talentValueAdd", talentValueAdd);
        return prefix + "/edit";
    }

    /**
     * 修改保存人才增值服务信息
     */
    @RequiresPermissions("netintech:add:edit")
    @Log(title = "人才增值服务信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TalentValueAdd talentValueAdd)
    {
        return toAjax(talentValueAddService.updateTalentValueAdd(talentValueAdd));
    }

    /**
     * 查看人才增值服务信息
     */
    @RequiresPermissions("netintech:add:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        TalentValueAddDto talentValueAdd = talentValueAddService.findById(id);
        mmap.put("talentValueAdd", talentValueAdd);
        return prefix + "/view";
    }
    /**
     * 删除人才增值服务信息
     */
    @RequiresPermissions("netintech:add:remove")
    @Log(title = "人才增值服务信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(talentValueAddService.deleteTalentValueAddByIds(ids));
    }
}