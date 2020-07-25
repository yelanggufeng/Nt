package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.LoanFinanceData;
import com.netintech.park.service.ILoanFinanceDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 贷款需求财务信息Controller
 *
 * @author ltc
 * @date 2020-07-15
 */
@Controller
@RequestMapping("/netintech/data")
public class LoanFinanceDataController extends BaseController
{
    private String prefix = "netintech/data";

    @Autowired
    private ILoanFinanceDataService loanFinanceDataService;

    @RequiresPermissions("netintech:data:view")
    @GetMapping()
    public String data()
    {
        return prefix + "/data";
    }

    /**
     * 查询贷款需求财务信息列表
     */
    @RequiresPermissions("netintech:data:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LoanFinanceData loanFinanceData)
    {
        startPage();
        List<LoanFinanceData> list = loanFinanceDataService.selectLoanFinanceDataList(loanFinanceData);
        return getDataTable(list);
    }

    /**
     * 导出贷款需求财务信息列表
     */
    @RequiresPermissions("netintech:data:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LoanFinanceData loanFinanceData)
    {
        List<LoanFinanceData> list = loanFinanceDataService.selectLoanFinanceDataList(loanFinanceData);
        ExcelUtil<LoanFinanceData> util = new ExcelUtil<LoanFinanceData>(LoanFinanceData.class);
        return util.exportExcel(list, "data");
    }

    /**
     * 新增贷款需求财务信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存贷款需求财务信息
     */
    @RequiresPermissions("netintech:data:add")
    @Log(title = "贷款需求财务信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LoanFinanceData loanFinanceData)
    {
        return toAjax(loanFinanceDataService.insertLoanFinanceData(loanFinanceData));
    }

    /**
     * 修改贷款需求财务信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LoanFinanceData loanFinanceData = loanFinanceDataService.selectLoanFinanceDataById(id);
        mmap.put("loanFinanceData", loanFinanceData);
        return prefix + "/edit";
    }

    /**
     * 修改保存贷款需求财务信息
     */
    @RequiresPermissions("netintech:data:edit")
    @Log(title = "贷款需求财务信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LoanFinanceData loanFinanceData)
    {
        return toAjax(loanFinanceDataService.updateLoanFinanceData(loanFinanceData));
    }

    /**
     * 查看贷款需求财务信息
     */
    @RequiresPermissions("netintech:data:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        LoanFinanceData loanFinanceData = loanFinanceDataService.selectLoanFinanceDataById(id);
        mmap.put("loanFinanceData", loanFinanceData);
        return prefix + "/view";
    }
    /**
     * 删除贷款需求财务信息
     */
    @RequiresPermissions("netintech:data:remove")
    @Log(title = "贷款需求财务信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(loanFinanceDataService.deleteLoanFinanceDataByIds(ids));
    }
}