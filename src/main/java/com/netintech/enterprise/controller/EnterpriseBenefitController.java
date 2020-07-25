package com.netintech.enterprise.controller;


import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.enterprise.domain.EnterpriseBenefit;
import com.netintech.enterprise.service.IEnterpriseBenefitService;
import com.netintech.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;

import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;

import java.util.List;

/**
 * 企业效益信息Controller
 *
 * @author admin
 * @date 2020-05-09
 */
@Controller
@RequestMapping("/enterprise/benefit")
public class EnterpriseBenefitController extends BaseController
{
    private String prefix = "enterprise/benefit";

    @Autowired
    private IEnterpriseBenefitService enterpriseBenefitService;

    @RequiresPermissions("enterprise:benefit:view")
    @GetMapping()
    public String benefit()
    {
        return prefix + "/benefit";
    }

    /**
     * 查询企业效益信息列表
     */
    @RequiresPermissions("enterprise:benefit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EnterpriseBenefit enterpriseBenefit)
    {
        startPage();
        List<EnterpriseBenefit> list = enterpriseBenefitService.selectEnterpriseBenefitList(enterpriseBenefit);
        return getDataTable(list);
    }

    /**
     * 导出企业效益信息列表
     */
    @RequiresPermissions("enterprise:benefit:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EnterpriseBenefit enterpriseBenefit)
    {
        List<EnterpriseBenefit> list = enterpriseBenefitService.selectEnterpriseBenefitList(enterpriseBenefit);
        ExcelUtil<EnterpriseBenefit> util = new ExcelUtil<EnterpriseBenefit>(EnterpriseBenefit.class);
        return util.exportExcel(list, "benefit");
    }

    /**
     * 新增企业效益信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业效益信息
     */
    @RequiresPermissions("enterprise:benefit:add")
    @Log(title = "企业效益信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EnterpriseBenefit enterpriseBenefit)
    {
        if (enterpriseBenefitService.checkExit(enterpriseBenefit)) {
            return error("当前企业'" +  enterpriseBenefit.getYear() + "'年" + enterpriseBenefit.getMonth() + "'月" + "'，效益已经添加过");
        }
        return toAjax(enterpriseBenefitService.insertEnterpriseBenefit(enterpriseBenefit));
    }

    /**
     * 修改企业效益信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {

        EnterpriseBenefit enterpriseBenefit = enterpriseBenefitService.selectEnterpriseBenefitById(id);
        mmap.put("enterpriseBenefit", enterpriseBenefit);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业效益信息
     */
    @RequiresPermissions("enterprise:benefit:edit")
    @Log(title = "企业效益信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EnterpriseBenefit enterpriseBenefit)
    {
        if (enterpriseBenefitService.checkExit(enterpriseBenefit)) {
            return error("当前企业'" +  enterpriseBenefit.getYear() + "'年" + enterpriseBenefit.getMonth() + "'月" + "'，效益已经添加过");
        }
        return toAjax(enterpriseBenefitService.updateEnterpriseBenefit(enterpriseBenefit));
    }

    /**
     * 查看企业效益信息
     */
    @RequiresPermissions("enterprise:benefit:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        EnterpriseBenefit enterpriseBenefit = enterpriseBenefitService.selectEnterpriseBenefitById(id);
        mmap.put("enterpriseBenefit", enterpriseBenefit);
        return prefix + "/view";
    }
    /**
     * 删除企业效益信息
     */
    @RequiresPermissions("enterprise:benefit:remove")
    @Log(title = "企业效益信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(enterpriseBenefitService.deleteEnterpriseBenefitByIds(ids));
    }
}
