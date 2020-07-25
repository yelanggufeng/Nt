package com.netintech.park.controller;

import java.util.List;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.park.domain.SmallParkInvest;
import com.netintech.park.service.ISmallParkInvestService;
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

/**
 * 小微园投资额信息Controller
 *
 * @author admin
 * @date 2020-06-18
 */
@Controller
@RequestMapping("/smallpark/invest")
public class SmallParkInvestController extends BaseController
{
    private String prefix = "smallpark/invest";

    @Autowired
    private ISmallParkInvestService smallParkInvestService;

    @RequiresPermissions("smallpark:invest:view")
    @GetMapping()
    public String invest()
    {
        return prefix + "/invest";
    }

    /**
     * 查询小微园投资额信息列表
     */
    @RequiresPermissions("smallpark:invest:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SmallParkInvest smallParkInvest)
    {
        startPage();
        List<SmallParkInvest> list = smallParkInvestService.selectSmallParkInvestList(smallParkInvest);
        return getDataTable(list);
    }

    /**
     * 导出小微园投资额信息列表
     */
    @RequiresPermissions("smallpark:invest:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmallParkInvest smallParkInvest)
    {
        List<SmallParkInvest> list = smallParkInvestService.selectSmallParkInvestList(smallParkInvest);
        ExcelUtil<SmallParkInvest> util = new ExcelUtil<SmallParkInvest>(SmallParkInvest.class);
        return util.exportExcel(list, "invest");
    }

    /**
     * 新增小微园投资额信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小微园投资额信息
     */
    @RequiresPermissions("smallpark:invest:add")
    @Log(title = "小微园投资额信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SmallParkInvest smallParkInvest)
    {
        if (smallParkInvestService.checkExit(smallParkInvest)) {
            return error("当前园区'" +  smallParkInvest.getYear() + "'年" + smallParkInvest.getMonth() + "'月" + "'，投资金额已经添加过");
        }
        return toAjax(smallParkInvestService.insertSmallParkInvest(smallParkInvest));
    }

    /**
     * 修改小微园投资额信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SmallParkInvest smallParkInvest = smallParkInvestService.selectSmallParkInvestById(id);
        mmap.put("smallParkInvest", smallParkInvest);
        return prefix + "/edit";
    }

    /**
     * 修改保存小微园投资额信息
     */
    @RequiresPermissions("smallpark:invest:edit")
    @Log(title = "小微园投资额信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SmallParkInvest smallParkInvest)
    {
        if (smallParkInvestService.checkExit(smallParkInvest)) {
            return error("当前园区'" +  smallParkInvest.getYear() + "'年" + smallParkInvest.getMonth() + "'月" + "'，投资金额已经添加过");
        }
        return toAjax(smallParkInvestService.updateSmallParkInvest(smallParkInvest));
    }

    /**
     * 查看小微园投资额信息
     */
    @RequiresPermissions("smallpark:invest:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        SmallParkInvest smallParkInvest = smallParkInvestService.selectSmallParkInvestById(id);
        mmap.put("smallParkInvest", smallParkInvest);
        return prefix + "/view";
    }
    /**
     * 删除小微园投资额信息
     */
    @RequiresPermissions("smallpark:invest:remove")
    @Log(title = "小微园投资额信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(smallParkInvestService.deleteSmallParkInvestByIds(ids));
    }
}
