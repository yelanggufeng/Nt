package com.netintech.requirement.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.requirement.domain.AttachmentTechnologyRequirement;
import com.netintech.requirement.domain.TechnologyRequirement;
import com.netintech.requirement.service.IAttachmentTechnologyRequirementService;
import com.netintech.requirement.service.ITechnologyRequirementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 技术需求信息Controller
 *
 * @author admin
 * @date 2020-06-19
 */
@Controller
@RequestMapping("/technology/requirement")
public class TechnologyRequirementController extends BaseController {
    private String prefix = "technology/requirement";

    @Autowired
    private ITechnologyRequirementService technologyRequirementService;
    @Autowired
    private IAttachmentTechnologyRequirementService attachmentTechnologyRequirementService;
    @Autowired
    private IDeptService deptService;

    @RequiresPermissions("technology:requirement:view")
    @GetMapping()
    public String requirement() {
        return prefix + "/requirement";
    }

    /**
     * 查询技术需求信息列表(园区端)
     */
    @RequiresPermissions("technology:requirement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TechnologyRequirement technologyRequirement) {
        Long deptId = ShiroUtils.getSysUser().getDeptId();//园区端账号
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        technologyRequirement.setParkId(priseId);
        startPage();
        List<TechnologyRequirement> list = technologyRequirementService.selectTechnologyRequirementList(technologyRequirement);
        return getDataTable(list);
    }

    /**
     * 查询技术需求信息列表(企业端)
     */
    @RequiresPermissions("technology:requirement:elist")
    @PostMapping("/elist")
    @ResponseBody
    public TableDataInfo enterpriseList(TechnologyRequirement technologyRequirement) {
        Long deptId = ShiroUtils.getSysUser().getDeptId();
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        technologyRequirement.setEnterpriseId(priseId);
        startPage();
        List<TechnologyRequirement> list = technologyRequirementService.selectTechnologyRequirementList(technologyRequirement);
        return getDataTable(list);
    }

    /**
     * 导出技术需求信息列表
     */
    @RequiresPermissions("technology:requirement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TechnologyRequirement technologyRequirement) {
        List<TechnologyRequirement> list = technologyRequirementService.selectTechnologyRequirementList(technologyRequirement);
        ExcelUtil<TechnologyRequirement> util = new ExcelUtil<TechnologyRequirement>(TechnologyRequirement.class);
        return util.exportExcel(list, "requirement");
    }

    /**
     * 新增技术需求信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        String uuid = String.valueOf(UUID.randomUUID());
        mmap.put("fileUuid", uuid);
        return prefix + "/add";
    }

    /**
     * 新增保存技术需求信息
     */
    @RequiresPermissions("technology:requirement:add")
    @Log(title = "技术需求信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TechnologyRequirement technologyRequirement) {
        if (technologyRequirement.getIsFace() == null) {
            technologyRequirement.setIsFace("0");
        }
        technologyRequirement.setStatus("0");
        return toAjax(technologyRequirementService.insertTechnologyRequirement(technologyRequirement));
    }

    /**
     * 修改技术需求信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TechnologyRequirement technologyRequirement = technologyRequirementService.selectTechnologyRequirementById(id);
        mmap.put("technologyRequirement", technologyRequirement);
        return prefix + "/edit";
    }

    /**
     * 修改保存技术需求信息
     */
    @RequiresPermissions("technology:requirement:edit")
    @Log(title = "技术需求信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TechnologyRequirement technologyRequirement) {
        if (technologyRequirement.getIsFace() == null) {
            technologyRequirement.setIsFace("0");
        }
        technologyRequirement.setStatus("0");
        return toAjax(technologyRequirementService.updateTechnologyRequirement(technologyRequirement));
    }

    /**
     * 查看技术需求信息
     */
    @RequiresPermissions("technology:requirement:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap) {
        TechnologyRequirement technologyRequirement = technologyRequirementService.selectTechnologyRequirementById(id);
        mmap.put("technologyRequirement", technologyRequirement);
        return prefix + "/view";
    }

    /**
     * 删除技术需求信息
     */
    @RequiresPermissions("technology:requirement:remove")
    @Log(title = "技术需求信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(technologyRequirementService.deleteTechnologyRequirementByIds(ids));
    }


    /**
     * 附件上传
     */
    @PostMapping("/uploadfile")
    @ResponseBody
    public AjaxResult uploadfile(AttachmentTechnologyRequirement attachmentTechnologyRequirement) {
        return toAjax(attachmentTechnologyRequirementService.insertAttachmentTechnologyRequirement(attachmentTechnologyRequirement));
    }

    /**
     * 附件列表
     **/
    @PostMapping("/filelistByUuid/{fileUuid}")
    @ResponseBody
    public TableDataInfo filelistByUuid(@PathVariable("fileUuid") String fileUuid) {
        AttachmentTechnologyRequirement attachmentTechnologyRequirement = new AttachmentTechnologyRequirement();
        attachmentTechnologyRequirement.setFileUuid(fileUuid);
        startPage();
        List<AttachmentTechnologyRequirement> list = attachmentTechnologyRequirementService.selectAttachmentTechnologyRequirementList(attachmentTechnologyRequirement);
        return getDataTable(list);
    }

    /**
     * 附件删除
     **/
    @PostMapping("/removefile")
    @ResponseBody
    public AjaxResult removetemp(Long ids) {
        return toAjax(attachmentTechnologyRequirementService.deleteAttachmentTechnologyRequirementByIds(String.valueOf(ids)));
    }

    /**
     * 生效or失效
     */
    @RequiresPermissions("technology:requirement:switch")
    @PostMapping("/switchSave")
    @ResponseBody
    public AjaxResult switchSave(Long id, String status) {
        return toAjax(technologyRequirementService.updateTechnologyRequirementStatus(id, status));
    }

    /**
     * 审核页面
     */
    @RequiresPermissions("technology:requirement:audit")
    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Long id, ModelMap mmap) {
        TechnologyRequirement technologyRequirement = technologyRequirementService.selectTechnologyRequirementById(id);
        mmap.put("technologyRequirement", technologyRequirement);
        return prefix + "/audit";
    }

    /**
     * 审核记录
     */
    @RequiresPermissions("technology:requirement:auditlist")
    @GetMapping("/auditList/{id}")
    public String auditList(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("infoId", id);
        mmap.put("typeId", 2);
        return prefix + "/auditList";
    }
}
