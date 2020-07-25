package com.netintech.park.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.TalentTrain;
import com.netintech.park.domain.dto.TalentTrainDto;
import com.netintech.park.service.ITalentTrainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人才培训信息Controller
 *
 * @author admin
 * @date 2020-07-17
 */
@Controller
@RequestMapping("/netintech/train")
public class TalentTrainController extends BaseController
{
    private String prefix = "netintech/train";

    @Autowired
    private ITalentTrainService talentTrainService;

    @RequiresPermissions("netintech:train:view")
    @GetMapping()
    public String train()
    {
        return prefix + "/train";
    }


    /**
     * 查询人才培训信息列表
     */
    //@RequiresPermissions("netintech:train:list")
    @PostMapping("/findAll")
    @ResponseBody
    public TableDataInfo findAll(TalentTrain talentTrain)
    {
        startPage();
        List<TalentTrainDto> all = talentTrainService.findAll(talentTrain);
        return getDataTable(all);
    }

    /**
     * 查询人才培训信息列表
     */
    @RequiresPermissions("netintech:train:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TalentTrain talentTrain)
    {
        startPage();
        List<TalentTrain> list = talentTrainService.selectTalentTrainList(talentTrain);
        return getDataTable(list);
    }

    /**
     * 导出人才培训信息列表
     */
    @RequiresPermissions("netintech:train:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TalentTrain talentTrain)
    {
        List<TalentTrain> list = talentTrainService.selectTalentTrainList(talentTrain);
        ExcelUtil<TalentTrain> util = new ExcelUtil<TalentTrain>(TalentTrain.class);
        return util.exportExcel(list, "train");
    }

    /**
     * 新增人才培训信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人才培训信息
     */
    @RequiresPermissions("netintech:train:add")
    @Log(title = "人才培训信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TalentTrain talentTrain)
    {
        return toAjax(talentTrainService.insertTalentTrain(talentTrain));
    }

    /**
     * 修改人才培训信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TalentTrain talentTrain = talentTrainService.selectTalentTrainById(id);
        mmap.put("talentTrain", talentTrain);
        return prefix + "/edit";
    }

    /**
     * 修改保存人才培训信息
     */
    @RequiresPermissions("netintech:train:edit")
    @Log(title = "人才培训信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TalentTrain talentTrain)
    {
        return toAjax(talentTrainService.updateTalentTrain(talentTrain));
    }

    /**
     * 查看人才培训信息
     */
    @RequiresPermissions("netintech:train:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        TalentTrain talentTrain = talentTrainService.selectTalentTrainById(id);
        mmap.put("talentTrain", talentTrain);
        return prefix + "/view";
    }
    /**
     * 删除人才培训信息
     */
    @RequiresPermissions("netintech:train:remove")
    @Log(title = "人才培训信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(talentTrainService.deleteTalentTrainByIds(ids));
    }
}