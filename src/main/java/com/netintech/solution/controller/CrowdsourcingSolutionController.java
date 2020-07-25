package com.netintech.solution.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.solution.domain.CrowdsourcingSolution;
import com.netintech.solution.service.ICrowdsourcingSolutionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 创新众包解决方案信息Controller
 *
 * @author admin
 * @date 2020-06-22
 */
@Controller
@RequestMapping("/crowdsourcing/solution")
public class CrowdsourcingSolutionController extends BaseController
{
    private String prefix = "crowdsourcing/solution";

    @Autowired
    private ICrowdsourcingSolutionService crowdsourcingSolutionService;

    @RequiresPermissions("crowdsourcing:solution:view")
    @GetMapping()
    public String solution()
    {
        return prefix + "/solution";
    }

    /**
     * 查询创新众包解决方案信息列表
     */
    //@RequiresPermissions("crowdsourcing:solution:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrowdsourcingSolution crowdsourcingSolution)
    {
        Integer questionNo = crowdsourcingSolution.getQuestionNo();
        if(questionNo==null){
            crowdsourcingSolution.setQuestionNo(1);//默认显示问题一的回答
        }
        startPage();
        List<CrowdsourcingSolution> list = crowdsourcingSolutionService.selectCrowdsourcingSolutionList(crowdsourcingSolution);
        return getDataTable(list);
    }

    /**
     * 导出创新众包解决方案信息列表
     */
    @RequiresPermissions("crowdsourcing:solution:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrowdsourcingSolution crowdsourcingSolution)
    {
        List<CrowdsourcingSolution> list = crowdsourcingSolutionService.selectCrowdsourcingSolutionList(crowdsourcingSolution);
        ExcelUtil<CrowdsourcingSolution> util = new ExcelUtil<CrowdsourcingSolution>(CrowdsourcingSolution.class);
        return util.exportExcel(list, "solution");
    }

    /**
     * 新增创新众包解决方案信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存创新众包解决方案信息
     */
    @RequiresPermissions("crowdsourcing:solution:add")
    @Log(title = "创新众包解决方案信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrowdsourcingSolution crowdsourcingSolution)
    {
        return toAjax(crowdsourcingSolutionService.insertCrowdsourcingSolution(crowdsourcingSolution));
    }

    /**
     * 修改创新众包解决方案信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrowdsourcingSolution crowdsourcingSolution = crowdsourcingSolutionService.selectCrowdsourcingSolutionById(id);
        mmap.put("crowdsourcingSolution", crowdsourcingSolution);
        return prefix + "/edit";
    }

    /**
     * 修改保存创新众包解决方案信息
     */
    @RequiresPermissions("crowdsourcing:solution:edit")
    @Log(title = "创新众包解决方案信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrowdsourcingSolution crowdsourcingSolution)
    {
        return toAjax(crowdsourcingSolutionService.updateCrowdsourcingSolution(crowdsourcingSolution));
    }

    /**
     * 查看创新众包解决方案信息
     */
    @RequiresPermissions("crowdsourcing:solution:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrowdsourcingSolution crowdsourcingSolution = crowdsourcingSolutionService.selectCrowdsourcingSolutionById(id);
        mmap.put("crowdsourcingSolution", crowdsourcingSolution);
        return prefix + "/view";
    }
    /**
     * 删除创新众包解决方案信息
     */
    @RequiresPermissions("crowdsourcing:solution:remove")
    @Log(title = "创新众包解决方案信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crowdsourcingSolutionService.deleteCrowdsourcingSolutionByIds(ids));
    }
}
