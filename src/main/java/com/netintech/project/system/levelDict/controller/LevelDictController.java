package com.netintech.project.system.levelDict.controller;

import com.netintech.common.constant.UserConstants;
import com.netintech.common.utils.StringUtils;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.domain.Ztree;
import com.netintech.project.system.levelDict.domain.LevelDict;
import com.netintech.project.system.levelDict.service.ILevelDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 级联字典表控制类
 * 
 * @author admin
 */
@Controller
@RequestMapping("/system/levelDict")
public class LevelDictController extends BaseController
{
    private String prefix = "system/levelDict";

    @Autowired
    private ILevelDictService dictService;

    @RequiresPermissions("system:dict:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/dict";
    }

    @RequiresPermissions("system:dict:list")
    @PostMapping("/list")
    @ResponseBody
    public List<LevelDict> list(LevelDict dict)
    {
        List<LevelDict> dictList = dictService.selectLevelDictList(dict);
        return dictList;
    }

    /**
     * 新增字典
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        LevelDict dict = dictService.selectDictById(parentId);
        if(dict == null){
            dict = new LevelDict();
            dict.setDictId(0L);
            dict.setParentLabel("无");
        }
        mmap.put("dict", dict);
        return prefix + "/add";
    }

    /**
     * 新增保存字典
     */
    @Log(title = "字典管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:dept:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated LevelDict dict)
    {
        if (UserConstants.LEVEL_DICT_NAME_NOT_UNIQUE.equals(dictService.checkDictLabelUnique(dict)))
        {
            return error("新增字典'" + dict.getDictLabel() + "'失败，字典名称已存在");
        }
        return toAjax(dictService.insertDict(dict));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{dictId}")
    public String edit(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        LevelDict dict = dictService.selectDictById(dictId);
        if (StringUtils.isNotNull(dict) && 0L == dictId)
        {
            dict.setParentLabel("无");
        }
        mmap.put("dict", dict);
        return prefix + "/edit";
    }

    /**
     * 保存
     */
    @Log(title = "字典管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:dict:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated LevelDict dict)
    {
        if (UserConstants.LEVEL_DICT_NAME_NOT_UNIQUE.equals(dictService.checkDictLabelUnique(dict)))
        {
            return error("修改字典'" + dict.getDictLabel() + "'失败，字典名称已存在");
        }
        else if(dict.getParentId().equals(dict.getDictId()))
        {
            return error("修改字典'" + dict.getDictLabel() + "'失败，上级字典不能是自己");
        }
        return toAjax(dictService.updateDict(dict));
    }

    /**
     * 删除
     */
    @Log(title = "字典管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:dict:remove")
    @GetMapping("/remove/{dictId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("dictId") Long dictId)
    {
        if (dictService.selectDictCount(dictId) > 0)
        {
            return AjaxResult.warn("存在下级字典,不允许删除");
        }
        return toAjax(dictService.deleteDictById(dictId));
    }

    /**
     * 校验字典名称
     */
    @PostMapping("/checkDictLabelUnique")
    @ResponseBody
    public String checkDictLabelUnique(LevelDict dict)
    {
        return dictService.checkDictLabelUnique(dict);
    }

    /**
     * 选择字典树
     */
    @GetMapping("/selectDictTree/{dictId}")
    public String selectDictTree(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        mmap.put("dict", dictService.selectDictById(dictId));
        return prefix + "/tree";
    }

    /**
     * 加载字典列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = dictService.selectDictTree(new LevelDict());
        return ztrees;
    }

}
