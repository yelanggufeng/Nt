package com.netintech.park.controller;

/**
 * 融资需求信息Controller
 *
 * @author admin
 * @date 2020-07-15
 */

import com.github.pagehelper.PageInfo;
import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.FinanceRequirement;
import com.netintech.park.domain.LoanRequirement;
import com.netintech.park.domain.dto.FinanceRequirementDto;
import com.netintech.park.domain.dto.LoanRequirementDto;
import com.netintech.park.service.IFinanceRequirementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 融资需求信息Controller
 *
 * @author ltc
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/netintech/finance")
@Api(tags = "FinanceRequirementController", description = " 融资需求信息")
public class FinanceRequirementController extends BaseController {
    private String prefix = "netintech/requirement";

    @Autowired
    private IFinanceRequirementService financeRequirementService;

    @RequiresPermissions("netintech:requirement:view")
    @GetMapping()
    public String requirement()
    {
        return prefix + "/requirement";
    }

    /**
     * 查询融资需求信息列表
     */
    //@RequiresPermissions("netintech:requirement:list")
    @PostMapping("/findAll")
    @ResponseBody
    public TableDataInfo findAll(FinanceRequirement financeRequirement)
    {
        startPage();
        List<FinanceRequirementDto> list = financeRequirementService.findAll(financeRequirement);
        return getDataTable(list);
    }

    /**
     * 查询融资需求信息列表
     */
    @ApiOperation(value = "查询融资需求信息列表")
  /*  @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "token", required = true, value = "authorization", dataType =
                    "String"),
    })*/
   // @RequiresPermissions("netintech:requirement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FinanceRequirement financeRequirement)
    {
        startPage();
        List<FinanceRequirement> list = financeRequirementService.selectFinanceRequirementList(financeRequirement);
        return getDataTable(list);
    }

    /**
     * 导出融资需求信息列表
     */
    @RequiresPermissions("netintech:requirement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FinanceRequirement financeRequirement)
    {
        List<FinanceRequirement> list = financeRequirementService.selectFinanceRequirementList(financeRequirement);
        ExcelUtil<FinanceRequirement> util = new ExcelUtil<FinanceRequirement>(FinanceRequirement.class);
        return util.exportExcel(list, "requirement");
    }

    /**
     * 新增融资需求信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存融资需求信息
     */
    @RequiresPermissions("netintech:requirement:add")
    @Log(title = "融资需求信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FinanceRequirement financeRequirement)
    {
        return toAjax(financeRequirementService.insertFinanceRequirement(financeRequirement));
    }

    /**
     * 修改融资需求信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FinanceRequirement financeRequirement = financeRequirementService.selectFinanceRequirementById(id);
        mmap.put("financeRequirement", financeRequirement);
        return prefix + "/edit";
    }

    /**
     * 修改保存融资需求信息
     */
    @RequiresPermissions("netintech:requirement:edit")
    @Log(title = "融资需求信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FinanceRequirement financeRequirement)
    {
        return toAjax(financeRequirementService.updateFinanceRequirement(financeRequirement));
    }

    /**
     * 查看融资需求信息
     */
    @RequiresPermissions("netintech:requirement:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        FinanceRequirement financeRequirement = financeRequirementService.selectFinanceRequirementById(id);
        mmap.put("financeRequirement", financeRequirement);
        return prefix + "/view";
    }
    /**
     * 删除融资需求信息
     */
    @RequiresPermissions("netintech:requirement:remove")
    @Log(title = "融资需求信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(financeRequirementService.deleteFinanceRequirementByIds(ids));
    }
}
