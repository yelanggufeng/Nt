package com.netintech.property.controller;


import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.property.domain.AttachmentIntellectualProperty;
import com.netintech.property.domain.IntellectualProperty;
import com.netintech.property.service.IAttachmentIntellectualPropertyService;
import com.netintech.property.service.IIntellectualPropertyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 知识产权信息Controller
 *
 * @author admin
 * @date 2020-06-22
 */
@Controller
@RequestMapping("/intellectual/property")
public class IntellectualPropertyController extends BaseController
{
    private String prefix = "intellectual/property";

    @Autowired
    private IIntellectualPropertyService intellectualPropertyService;
    @Autowired
    private IAttachmentIntellectualPropertyService attachmentIntellectualPropertyService;
    @Autowired
    private IDeptService deptService;

    @RequiresPermissions("intellectual:property:view")
    @GetMapping()
    public String property()
    {
        return prefix + "/property";
    }

    /**
     * 查询知识产权信息列表
     */
    @RequiresPermissions("intellectual:property:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(IntellectualProperty intellectualProperty)
    {
        Long deptId = ShiroUtils.getSysUser().getDeptId();//园区端账号
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        intellectualProperty.setParkId(priseId);
        startPage();
        List<IntellectualProperty> list = intellectualPropertyService.selectIntellectualPropertyList(intellectualProperty);
        return getDataTable(list);
    }

    /**
     * 查询知识产权信息列表
     */
    @RequiresPermissions("intellectual:property:elist")
    @PostMapping("/elist")
    @ResponseBody
    public TableDataInfo enterpriseList(IntellectualProperty intellectualProperty)
    {
        Long deptId = ShiroUtils.getSysUser().getDeptId();//企业端账号
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        intellectualProperty.setEnterpriseId(priseId);
        startPage();
        List<IntellectualProperty> list = intellectualPropertyService.selectIntellectualPropertyList(intellectualProperty);
        return getDataTable(list);
    }

    /**
     * 导出知识产权信息列表
     */
    @RequiresPermissions("intellectual:property:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(IntellectualProperty intellectualProperty)
    {
        List<IntellectualProperty> list = intellectualPropertyService.selectIntellectualPropertyList(intellectualProperty);
        ExcelUtil<IntellectualProperty> util = new ExcelUtil<IntellectualProperty>(IntellectualProperty.class);
        return util.exportExcel(list, "property");
    }

    /**
     * 新增知识产权信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        String uuid = String.valueOf(UUID.randomUUID());
        mmap.put("fileUuid", uuid);
        return prefix + "/add";
    }

    /**
     * 新增保存知识产权信息
     */
    @RequiresPermissions("intellectual:property:add")
    @Log(title = "知识产权信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(IntellectualProperty intellectualProperty)
    {
        intellectualProperty.setStatus("0");
        return toAjax(intellectualPropertyService.insertIntellectualProperty(intellectualProperty));
    }

    /**
     * 修改知识产权信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        IntellectualProperty intellectualProperty = intellectualPropertyService.selectIntellectualPropertyById(id);
        mmap.put("intellectualProperty", intellectualProperty);
        return prefix + "/edit";
    }

    /**
     * 修改保存知识产权信息
     */
    @RequiresPermissions("intellectual:property:edit")
    @Log(title = "知识产权信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(IntellectualProperty intellectualProperty)
    {
        intellectualProperty.setStatus("0");
        return toAjax(intellectualPropertyService.updateIntellectualProperty(intellectualProperty));
    }

    /**
     * 查看知识产权信息
     */
    @RequiresPermissions("intellectual:property:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        IntellectualProperty intellectualProperty = intellectualPropertyService.selectIntellectualPropertyById(id);
        mmap.put("intellectualProperty", intellectualProperty);
        return prefix + "/view";
    }
    /**
     * 删除知识产权信息
     */
    @RequiresPermissions("intellectual:property:remove")
    @Log(title = "知识产权信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(intellectualPropertyService.deleteIntellectualPropertyByIds(ids));
    }

    /**
     * 附件上传
     */
    @PostMapping("/uploadfile")
    @ResponseBody
    public AjaxResult uploadfile(AttachmentIntellectualProperty attachmentIntellectualProperty) {
        return toAjax(attachmentIntellectualPropertyService.insertAttachmentIntellectualProperty(attachmentIntellectualProperty));
    }

    /**
     * 附件列表
     **/
    @PostMapping("/filelistByUuid/{fileUuid}")
    @ResponseBody
    public TableDataInfo filelistByUuid(@PathVariable("fileUuid") String fileUuid) {
        AttachmentIntellectualProperty attachmentIntellectualProperty = new AttachmentIntellectualProperty();
        attachmentIntellectualProperty.setFileUuid(fileUuid);
        startPage();
        List<AttachmentIntellectualProperty> list = attachmentIntellectualPropertyService.selectAttachmentIntellectualPropertyList(attachmentIntellectualProperty);
        return getDataTable(list);
    }

    /**
     * 附件删除
     **/
    @PostMapping("/removefile")
    @ResponseBody
    public AjaxResult removetemp(Long ids) {
        return toAjax(attachmentIntellectualPropertyService.deleteAttachmentIntellectualPropertyByIds(String.valueOf(ids)));
    }

    /**
     * 生效or失效
     */
    @RequiresPermissions("intellectual:property:switch")
    @PostMapping("/switchSave")
    @ResponseBody
    public AjaxResult switchSave(Long id,String status) {
        return toAjax(intellectualPropertyService.updateIntellectualPropertyStatus(id, status));
    }

    /**
     * 审核页面
     * */
    @RequiresPermissions("intellectual:property:audit")
    @GetMapping("/audit/{id}")
    public String audit(@PathVariable("id") Long id, ModelMap mmap) {
        IntellectualProperty intellectualProperty = intellectualPropertyService.selectIntellectualPropertyById(id);
        mmap.put("intellectualProperty",intellectualProperty);
        return prefix + "/audit";
    }

    /**
     * 审核记录
     * */
    @RequiresPermissions("intellectual:property:auditlist")
    @GetMapping("/auditList/{id}")
    public String auditList(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("infoId",id);
        mmap.put("typeId",1);
        return prefix + "/auditList";
    }
}
