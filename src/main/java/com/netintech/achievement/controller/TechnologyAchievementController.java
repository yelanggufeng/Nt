package com.netintech.achievement.controller;


import com.netintech.achievement.domain.AttachmentTechnologyAchievement;
import com.netintech.achievement.domain.TechnologyAchievement;
import com.netintech.achievement.service.IAttachmentTechnologyAchievementService;
import com.netintech.achievement.service.ITechnologyAchievementService;
import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.project.system.dept.service.IDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 技术成果信息Controller
 *
 * @author admin
 * @date 2020-06-17
 */
@Controller
@RequestMapping("/technology/achievement")
public class TechnologyAchievementController extends BaseController {
    private String prefix = "technology/achievement";

    @Autowired
    private ITechnologyAchievementService technologyAchievementService;
    @Autowired
    private IAttachmentTechnologyAchievementService attachmentTechnologyAchievementService;
    @Autowired
    private IDeptService deptService;


    @RequiresPermissions("technology:achievement:view")
    @GetMapping()
    public String achievement() {
        return prefix + "/achievement";
    }

    /**
     * 查询技术成果信息列表(园区端)
     */
    @RequiresPermissions("technology:achievement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TechnologyAchievement technologyAchievement) {
        Long deptId = ShiroUtils.getSysUser().getDeptId();//园区端账号
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        technologyAchievement.setParkId(priseId);
        startPage();
        List<TechnologyAchievement> list = technologyAchievementService.selectTechnologyAchievementList(technologyAchievement);
        return getDataTable(list);
    }

    /**
     * 查询技术成果信息列表(企业端)
     */
    @RequiresPermissions("technology:achievement:elist")
    @PostMapping("/elist")
    @ResponseBody
    public TableDataInfo enterpriseList(TechnologyAchievement technologyAchievement) {
        Long deptId = ShiroUtils.getSysUser().getDeptId();
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        technologyAchievement.setEnterpriseId(priseId);
        startPage();
        List<TechnologyAchievement> list = technologyAchievementService.selectTechnologyAchievementList(technologyAchievement);
        return getDataTable(list);
    }
    /**
     * 导出技术成果信息列表
     */
    @RequiresPermissions("technology:achievement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TechnologyAchievement technologyAchievement) {
        List<TechnologyAchievement> list = technologyAchievementService.selectTechnologyAchievementList(technologyAchievement);
        ExcelUtil<TechnologyAchievement> util = new ExcelUtil<TechnologyAchievement>(TechnologyAchievement.class);
        return util.exportExcel(list, "achievement");
    }

    /**
     * 新增技术成果信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        String uuid = String.valueOf(UUID.randomUUID());
        mmap.put("fileUuid", uuid);
        return prefix + "/add";
    }

    /**
     * 新增保存技术成果信息
     */
    @RequiresPermissions("technology:achievement:add")
    @Log(title = "技术成果信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TechnologyAchievement technologyAchievement) {
        return toAjax(technologyAchievementService.insertTechnologyAchievement(technologyAchievement));
    }

    /**
     * 修改技术成果信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TechnologyAchievement technologyAchievement = technologyAchievementService.selectTechnologyAchievementById(id);
        mmap.put("technologyAchievement", technologyAchievement);
        return prefix + "/edit";
    }

    /**
     * 修改保存技术成果信息
     */
    @RequiresPermissions("technology:achievement:edit")
    @Log(title = "技术成果信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TechnologyAchievement technologyAchievement) {
        if(technologyAchievement.getIsFace()==null){
            technologyAchievement.setIsFace("0");
        }
        technologyAchievement.setStatus("0");//修改后状态变更为待审核
        return toAjax(technologyAchievementService.updateTechnologyAchievement(technologyAchievement));
    }

    /**
     * 查看技术成果信息
     */
    @RequiresPermissions("technology:achievement:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap) {
        TechnologyAchievement technologyAchievement = technologyAchievementService.selectTechnologyAchievementById(id);
        mmap.put("technologyAchievement", technologyAchievement);
        return prefix + "/view";
    }

    /**
     * 删除技术成果信息
     */
    @RequiresPermissions("technology:achievement:remove")
    @Log(title = "技术成果信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(technologyAchievementService.deleteTechnologyAchievementByIds(ids));
    }

    /**
     * 附件上传
     */
    @PostMapping("/uploadfile")
    @ResponseBody
    public AjaxResult uploadfile(AttachmentTechnologyAchievement attachmentTechnologyAchievement) {
        return toAjax(attachmentTechnologyAchievementService.insertAttachmentTechnologyAchievement(attachmentTechnologyAchievement));
    }

    /**
     * 附件列表
     **/
    @PostMapping("/filelistByUuid/{fileUuid}")
    @ResponseBody
    public TableDataInfo filelistByUuid(@PathVariable("fileUuid") String fileUuid) {
        AttachmentTechnologyAchievement attachmentTechnologyAchievement = new AttachmentTechnologyAchievement();
        attachmentTechnologyAchievement.setFileUuid(fileUuid);
        startPage();
        List<AttachmentTechnologyAchievement> list = attachmentTechnologyAchievementService.selectAttachmentTechnologyAchievementList(attachmentTechnologyAchievement);
        return getDataTable(list);
    }

    /**
     * 附件删除
     **/
    @PostMapping("/removefile")
    @ResponseBody
    public AjaxResult removetemp(Long ids) {
        return toAjax(attachmentTechnologyAchievementService.deleteAttachmentTechnologyAchievementByIds(String.valueOf(ids)));
    }

    /**
     * 生效or失效
     */
    @RequiresPermissions("technology:achievement:switch")
    @Log(title = "技术成果信息", businessType = BusinessType.UPDATE)
    @PostMapping("/switchSave")
    @ResponseBody
    public AjaxResult switchSave(Long id,String status) {
        return toAjax(technologyAchievementService.updateTechnologyAchievementStatus(id, status));
    }

    /**
     * 审核页面
     * */
    @RequiresPermissions("technology:achievement:audit")
    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Long id, ModelMap mmap) {
        TechnologyAchievement technologyAchievement = technologyAchievementService.selectTechnologyAchievementById(id);
        mmap.put("technologyAchievement", technologyAchievement);
        return prefix + "/audit";
    }

    /**
     * 审核记录
     * */
    @RequiresPermissions("technology:achievement:auditlist")
    @GetMapping("/auditList/{id}")
    public String auditList(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("infoId",id);
        mmap.put("typeId",1);
        return prefix + "/auditList";
    }
}
