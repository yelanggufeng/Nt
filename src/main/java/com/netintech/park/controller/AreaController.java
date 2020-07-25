package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.Area;
import com.netintech.park.service.IAreaService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 区域信息Controller
 *
 * @author ltc
 * @date 2020-07-16
 */
@Controller
@RequestMapping("/netintech/area")
public class AreaController extends BaseController
{
    private String prefix = "netintech/area";

    @Autowired
    private IAreaService areaService;

    @RequiresPermissions("netintech:area:view")
    @GetMapping()
    public String area()
    {
        return prefix + "/area";
    }

    /**
     * 查询区域信息列表
     */
    @RequiresPermissions("netintech:area:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Area area)
    {
        startPage();
        List<Area> list = areaService.selectAreaList(area);
        return getDataTable(list);
    }

    /**
     * 导出区域信息列表
     */
    @RequiresPermissions("netintech:area:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Area area)
    {
        List<Area> list = areaService.selectAreaList(area);
        ExcelUtil<Area> util = new ExcelUtil<Area>(Area.class);
        return util.exportExcel(list, "area");
    }

    /**
     * 新增区域信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存区域信息
     */
    @RequiresPermissions("netintech:area:add")
    @Log(title = "区域信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Area area)
    {
        return toAjax(areaService.insertArea(area));
    }

    /**
     * 修改区域信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Area area = areaService.selectAreaById(id);
        mmap.put("area", area);
        return prefix + "/edit";
    }

    /**
     * 修改保存区域信息
     */
    @RequiresPermissions("netintech:area:edit")
    @Log(title = "区域信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Area area)
    {
        return toAjax(areaService.updateArea(area));
    }

    /**
     * 查看区域信息
     */
    @RequiresPermissions("netintech:area:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        Area area = areaService.selectAreaById(id);
        mmap.put("area", area);
        return prefix + "/view";
    }
    /**
     * 删除区域信息
     */
    @RequiresPermissions("netintech:area:remove")
    @Log(title = "区域信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(areaService.deleteAreaByIds(ids));
    }
}