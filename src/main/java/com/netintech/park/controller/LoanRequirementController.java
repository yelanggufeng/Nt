package com.netintech.park.controller;


import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.LoanRequirement;
import com.netintech.park.domain.dto.LoanRequirementDto;
import com.netintech.park.service.ILoanRequirementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 贷款需求信息Controller
 *
 * @author ltc
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/netintech/requirement")
public class LoanRequirementController extends BaseController
{
    private String prefix = "netintech/requirement";

    @Autowired
    private ILoanRequirementService loanRequirementService;

    @RequiresPermissions("netintech:requirement:view")
    @GetMapping()
    public String requirement()
    {
        return prefix + "/requirement";
    }

    /**
     * 查询贷款需求信息列表
     */
    //@RequiresPermissions("netintech:requirement:list")
    @PostMapping("/findAll")
    @ResponseBody
    public TableDataInfo listLoanRequirement(LoanRequirement loanRequirement)
    {
        startPage();
        List<LoanRequirementDto> list = loanRequirementService.findAll(loanRequirement);
        return getDataTable(list);
    }

    /**
     * 查询贷款需求信息列表
     */
    @RequiresPermissions("netintech:requirement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LoanRequirement loanRequirement)
    {
        startPage();
        List<LoanRequirement> list = loanRequirementService.selectLoanRequirementList(loanRequirement);
        return getDataTable(list);
    }

    /**
     * 导出贷款需求信息列表
     */
    @RequiresPermissions("netintech:requirement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LoanRequirement loanRequirement)
    {
        List<LoanRequirement> list = loanRequirementService.selectLoanRequirementList(loanRequirement);
        ExcelUtil<LoanRequirement> util = new ExcelUtil<LoanRequirement>(LoanRequirement.class);
        return util.exportExcel(list, "requirement");
    }

    /**
     * 新增贷款需求信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存贷款需求信息
     */
    @RequiresPermissions("netintech:requirement:add")
    @Log(title = "贷款需求信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LoanRequirement loanRequirement)
    {
        return toAjax(loanRequirementService.insertLoanRequirement(loanRequirement));
    }

    /**
     * 修改贷款需求信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LoanRequirement loanRequirement = loanRequirementService.selectLoanRequirementById(id);
        mmap.put("loanRequirement", loanRequirement);
        return prefix + "/edit";
    }

    /**
     * 修改保存贷款需求信息
     */
    @RequiresPermissions("netintech:requirement:edit")
    @Log(title = "贷款需求信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LoanRequirement loanRequirement)
    {
        return toAjax(loanRequirementService.updateLoanRequirement(loanRequirement));
    }

    /**
     * 查看贷款需求信息
     */
    @RequiresPermissions("netintech:requirement:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        LoanRequirement loanRequirement = loanRequirementService.selectLoanRequirementById(id);
        mmap.put("loanRequirement", loanRequirement);
        return prefix + "/view";
    }
    /**
     * 删除贷款需求信息
     */
    @RequiresPermissions("netintech:requirement:remove")
    @Log(title = "贷款需求信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(loanRequirementService.deleteLoanRequirementByIds(ids));
    }
}