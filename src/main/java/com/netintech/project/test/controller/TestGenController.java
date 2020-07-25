package com.netintech.project.test.controller;

import java.util.List;

import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;

import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.netintech.project.test.domain.TestGen;
import com.netintech.project.test.service.ITestGenService;
import com.netintech.common.utils.poi.ExcelUtil;

/**
 * 测试Controller
 * 
 * @author admin
 * @date 2020-03-26
 */
@Controller
@RequestMapping("/netintech/test")
public class TestGenController extends BaseController
{
    private String prefix = "test";

    @Autowired
    private ITestGenService testGenService;

    @RequiresPermissions("netintech:test:view")
    @GetMapping()
    public String test()
    {
        return prefix + "/test";
    }

    /**
     * 查询测试列表
     */
    @RequiresPermissions("netintech:test:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestGen testGen)
    {
        startPage();
        List<TestGen> list = testGenService.selectTestGenList(testGen);
        return getDataTable(list);
    }

    /**
     * 导出测试列表
     */
    @RequiresPermissions("netintech:test:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestGen testGen)
    {
        List<TestGen> list = testGenService.selectTestGenList(testGen);
        ExcelUtil<TestGen> util = new ExcelUtil<TestGen>(TestGen.class);
        return util.exportExcel(list, "test");
    }

    /**
     * 新增测试
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存测试
     */
    @RequiresPermissions("netintech:test:add")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestGen testGen)
    {
        return toAjax(testGenService.insertTestGen(testGen));
    }

    /**
     * 修改测试
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        TestGen testGen = testGenService.selectTestGenById(id);
        mmap.put("testGen", testGen);
        return prefix + "/edit";
    }

    /**
     * 修改保存测试
     */
    @RequiresPermissions("netintech:test:edit")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestGen testGen)
    {
        return toAjax(testGenService.updateTestGen(testGen));
    }

    /**
     * 删除测试
     */
    @RequiresPermissions("netintech:test:remove")
    @Log(title = "测试", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testGenService.deleteTestGenByIds(ids));
    }

    /**
     * 查看【请填写功能名称】
     */
    @GetMapping("/detail/{id}")
    public String view(@PathVariable("id") Integer id, ModelMap mmap)
    {
        TestGen testGen = testGenService.selectTestGenById(id);
        mmap.put("testGen", testGen);
        return prefix + "/view";
    }
}
