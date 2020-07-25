package com.netintech.requirement.controller;

import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.requirement.domain.AttachmentCrowdsourcingRequirement;
import com.netintech.requirement.domain.CrowdsourcingRequirement;
import com.netintech.requirement.service.IAttachmentCrowdsourcingRequirementService;
import com.netintech.requirement.service.ICrowdsourcingRequirementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 创新众包需求信息Controller
 *
 * @author admin
 * @date 2020-06-19
 */
@Controller
@RequestMapping("/crowdsourcing/requirement")
public class CrowdsourcingRequirementController extends BaseController
{
    private String prefix = "crowdsourcing/requirement";

    @Autowired
    private ICrowdsourcingRequirementService crowdsourcingRequirementService;
    @Autowired
    private IAttachmentCrowdsourcingRequirementService attachmentCrowdsourcingRequirementService;
    @Autowired
    private IDeptService deptService;

    @RequiresPermissions("crowdsourcing:requirement:view")
    @GetMapping()
    public String requirement()
    {
        return prefix + "/requirement";
    }

    /**
     * 查询创新众包需求信息列表
     */
    @RequiresPermissions("crowdsourcing:requirement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CrowdsourcingRequirement crowdsourcingRequirement)
    {
        Long deptId = ShiroUtils.getSysUser().getDeptId();//园区端账号
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        crowdsourcingRequirement.setParkId(priseId);
        startPage();
        List<CrowdsourcingRequirement> list = crowdsourcingRequirementService.selectCrowdsourcingRequirementList(crowdsourcingRequirement);
        return getDataTable(list);
    }

    /**
     * 查询创新众包需求信息列表(企业端)
     */
    @RequiresPermissions("crowdsourcing:requirement:elist")
    @PostMapping("/elist")
    @ResponseBody
    public TableDataInfo enterpriseList(CrowdsourcingRequirement crowdsourcingRequirement)
    {
        Long deptId = ShiroUtils.getSysUser().getDeptId();//企业端账号
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        crowdsourcingRequirement.setEnterpriseId(priseId);
        startPage();
        List<CrowdsourcingRequirement> list = crowdsourcingRequirementService.selectCrowdsourcingRequirementList(crowdsourcingRequirement);
        return getDataTable(list);
    }

    /**
     * 导出创新众包需求信息列表
     */
    @RequiresPermissions("crowdsourcing:requirement:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrowdsourcingRequirement crowdsourcingRequirement)
    {
        List<CrowdsourcingRequirement> list = crowdsourcingRequirementService.selectCrowdsourcingRequirementList(crowdsourcingRequirement);
        ExcelUtil<CrowdsourcingRequirement> util = new ExcelUtil<CrowdsourcingRequirement>(CrowdsourcingRequirement.class);
        return util.exportExcel(list, "requirement");
    }

    /**
     * 新增创新众包需求信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        String uuid = String.valueOf(UUID.randomUUID());
        mmap.put("fileUuid", uuid);
        return prefix + "/add";
    }

    /**
     * 新增保存创新众包需求信息
     */
    @RequiresPermissions("crowdsourcing:requirement:add")
    @Log(title = "创新众包需求信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CrowdsourcingRequirement crowdsourcingRequirement)
    {
        return toAjax(crowdsourcingRequirementService.insertCrowdsourcingRequirement(crowdsourcingRequirement));
    }

    /**
     * 修改创新众包需求信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrowdsourcingRequirement crowdsourcingRequirement = crowdsourcingRequirementService.selectCrowdsourcingRequirementById(id);
        mmap.put("crowdsourcingRequirement", crowdsourcingRequirement);
        return prefix + "/edit";
    }

    /**
     * 修改保存创新众包需求信息
     */
    @RequiresPermissions("crowdsourcing:requirement:edit")
    @Log(title = "创新众包需求信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CrowdsourcingRequirement crowdsourcingRequirement)
    {
        return toAjax(crowdsourcingRequirementService.updateCrowdsourcingRequirement(crowdsourcingRequirement));
    }

    /**
     * 查看创新众包需求信息
     */
    @RequiresPermissions("crowdsourcing:requirement:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        CrowdsourcingRequirement crowdsourcingRequirement = crowdsourcingRequirementService.selectCrowdsourcingRequirementById(id);
        mmap.put("crowdsourcingRequirement", crowdsourcingRequirement);
        return prefix + "/view";
    }
    /**
     * 删除创新众包需求信息
     */
    @RequiresPermissions("crowdsourcing:requirement:remove")
    @Log(title = "创新众包需求信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(crowdsourcingRequirementService.deleteCrowdsourcingRequirementByIds(ids));
    }

    /**
     * 附件上传
     */
    @PostMapping("/uploadfile")
    @ResponseBody
    public AjaxResult uploadfile(AttachmentCrowdsourcingRequirement attachmentCrowdsourcingRequirement) {
        return toAjax(attachmentCrowdsourcingRequirementService.insertAttachmentCrowdsourcingRequirement(attachmentCrowdsourcingRequirement));
    }

    /**
     * 附件列表
     **/
    @PostMapping("/filelistByUuid/{fileUuid}")
    @ResponseBody
    public TableDataInfo filelistByUuid(@PathVariable("fileUuid") String fileUuid) {
        AttachmentCrowdsourcingRequirement attachmentCrowdsourcingRequirement = new AttachmentCrowdsourcingRequirement();
        attachmentCrowdsourcingRequirement.setFileUuid(fileUuid);
        startPage();
        List<AttachmentCrowdsourcingRequirement> list = attachmentCrowdsourcingRequirementService.selectAttachmentCrowdsourcingRequirementList(attachmentCrowdsourcingRequirement);
        return getDataTable(list);
    }

    /**
     * 附件删除
     **/
    @PostMapping("/removefile")
    @ResponseBody
    public AjaxResult removetemp(Long ids) {
        return toAjax(attachmentCrowdsourcingRequirementService.deleteAttachmentCrowdsourcingRequirementByIds(String.valueOf(ids)));
    }

    /**
     * 生效or失效
     */
    @RequiresPermissions("technology:requirement:switch")
    @PostMapping("/switchSave")
    @ResponseBody
    public AjaxResult switchSave(Long id, String status) {
        return toAjax(crowdsourcingRequirementService.updateCrowdsourcingRequirementStatus(id, status));
    }

    /**
     * 已解决
     */
    @PostMapping("/resultSave")
    @ResponseBody
    public AjaxResult resultSave(CrowdsourcingRequirement crowdsourcingRequirement) {
        Long id = crowdsourcingRequirement.getId();
        String result = crowdsourcingRequirement.getResult();
        return toAjax(crowdsourcingRequirementService.updateCrowdsourcingRequirementResult(id, result));
    }

    /**
     * 审核页面
     */
    @RequiresPermissions("technology:requirement:audit")
    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Long id, ModelMap mmap) {
        CrowdsourcingRequirement crowdsourcingRequirement = crowdsourcingRequirementService.selectCrowdsourcingRequirementById(id);
        mmap.put("crowdsourcingRequirement", crowdsourcingRequirement);
        return prefix + "/audit";
    }

    /**
     * 审核记录
     */
    @RequiresPermissions("technology:requirement:auditlist")
    @GetMapping("/auditList/{id}")
    public String auditList(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("infoId", id);
        mmap.put("typeId", 3);
        return prefix + "/auditList";
    }

    /**
     * 解决方案
     */
    @GetMapping("/solutionList/{id}")
    public String solutionList(@PathVariable("id") Long id, ModelMap mmap) {
        CrowdsourcingRequirement crowdsourcingRequirement = crowdsourcingRequirementService.selectCrowdsourcingRequirementById(id);
        mmap.put("crowdsourcingRequirement", crowdsourcingRequirement);
        return prefix + "/solutionList";
    }

    @RequiresPermissions("crowdsourcing:requirement:myview")
    @GetMapping("/myview")
    public String myparticipate()
    {
        return prefix + "/myparticipate";
    }

    /**
     * 查询我参与的需求信息列表
     */
    @RequiresPermissions("crowdsourcing:requirement:mylist")
    @PostMapping("/myList")
    @ResponseBody
    public TableDataInfo myList(CrowdsourcingRequirement crowdsourcingRequirement)
    {
        Long deptId = ShiroUtils.getSysUser().getDeptId();//园区端账号
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        crowdsourcingRequirement.setCreateBy(String.valueOf(priseId));
        startPage();
        List<CrowdsourcingRequirement> list = crowdsourcingRequirementService.selectMyParticipateList(crowdsourcingRequirement);
        return getDataTable(list);
    }
}
