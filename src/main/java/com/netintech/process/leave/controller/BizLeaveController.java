package com.netintech.process.leave.controller;


import com.netintech.common.utils.StringUtils;
import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.process.leave.domain.BizLeaveVo;
import com.netintech.process.leave.service.IBizLeaveService;
import com.netintech.project.system.user.domain.User;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请假业务Controller
 *
 * @author admin
 */
@Controller
@RequestMapping("/process/leave")
public class BizLeaveController extends BaseController {
    private String prefix = "process/leave";

    @Autowired
    private IBizLeaveService bizLeaveService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

//    @Autowired
//    private IPolicyProjectService policyProjectService;

    @RequiresPermissions("process:leave:view")
    @GetMapping()
    public String leave(ModelMap mmap) {
        mmap.put("currentUser", ShiroUtils.getSysUser());
        return prefix + "/leave";
    }

    /**
     * 查询请假业务列表
     */
    @RequiresPermissions("process:leave:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizLeaveVo bizLeave) {
        if (!User.isAdmin(ShiroUtils.getUserId())) {
            bizLeave.setCreateBy(ShiroUtils.getUserStringId());
        }
        startPage();
        List<BizLeaveVo> list = bizLeaveService.selectBizLeaveList(bizLeave);
        return getDataTable(list);
    }

    /**
     * 导出请假业务列表
     */
    @RequiresPermissions("process:leave:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BizLeaveVo bizLeave) {
        List<BizLeaveVo> list = bizLeaveService.selectBizLeaveList(bizLeave);
        ExcelUtil<BizLeaveVo> util = new ExcelUtil<BizLeaveVo>(BizLeaveVo.class);
        return util.exportExcel(list, "leave");
    }

    /**
     * 新增请假业务
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存请假业务
     */
    @RequiresPermissions("process:leave:add")
    @Log(title = "请假业务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizLeaveVo bizLeave) {
        Long userId = ShiroUtils.getUserId();
        if (User.isAdmin(userId)) {
            return error("提交申请失败：不允许管理员提交申请！");
        }
        return toAjax(bizLeaveService.insertBizLeave(bizLeave));
    }

    /**
     * 修改请假业务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        BizLeaveVo bizLeave = bizLeaveService.selectBizLeaveById(id);
        mmap.put("bizLeave", bizLeave);
        return prefix + "/edit";
    }

    /**
     * 修改保存请假业务
     */
    @RequiresPermissions("process:leave:edit")
    @Log(title = "请假业务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizLeaveVo bizLeave) {
        return toAjax(bizLeaveService.updateBizLeave(bizLeave));
    }

    /**
     * 删除请假业务
     */
    @RequiresPermissions("process:leave:remove")
    @Log(title = "请假业务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(bizLeaveService.deleteBizLeaveByIds(ids));
    }

    /**
     * 提交申请
     */
    @Log(title = "请假业务", businessType = BusinessType.UPDATE)
    @PostMapping( "/submitApply")
    @ResponseBody
    public AjaxResult submitApply(Long id) {
        BizLeaveVo leave = bizLeaveService.selectBizLeaveById(id);
        String applyUserId = ShiroUtils.getUserStringId();
        bizLeaveService.submitApply(leave, applyUserId);
        return success();
    }

    @RequiresPermissions("process:leave:todoView")
    @GetMapping("/leaveTodo")
    public String todoView() {
        return prefix + "/leaveTodo";
    }

    /**
     * 我的待办列表
     * @param bizLeave
     * @return
     */
    @RequiresPermissions("process:leave:taskList")
    @PostMapping("/taskList")
    @ResponseBody
    public TableDataInfo taskList(BizLeaveVo bizLeave) {
        startPage();
        List<BizLeaveVo> list = bizLeaveService.findTodoTasks(bizLeave, ShiroUtils.getUserStringId());
        return getDataTable(list);
    }

    /**
     * 加载审批弹窗
     * @param taskId
     * @param mmap
     * @return
     */
    @GetMapping("/showVerifyDialog/{taskId}")
    public String showVerifyDialog(@PathVariable("taskId") String taskId, ModelMap mmap) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        BizLeaveVo bizLeave = bizLeaveService.selectBizLeaveById(new Long(processInstance.getBusinessKey()));
        mmap.put("bizLeave", bizLeave);
        mmap.put("taskId", taskId);
        mmap.put("user",ShiroUtils.getSysUser());
        String verifyName = task.getTaskDefinitionKey().substring(0, 1).toUpperCase() + task.getTaskDefinitionKey().substring(1);
        return prefix + "/task" + verifyName;
    }

    /**
     * 完成任务
     *
     * @return
     */
    @RequestMapping(value = "/complete/{taskId}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public AjaxResult complete(@PathVariable("taskId") String taskId, @RequestParam(value = "saveEntity", required = false) String saveEntity,
                               @ModelAttribute("preloadLeave") BizLeaveVo leave, HttpServletRequest request) {
        boolean saveEntityBoolean = BooleanUtils.toBoolean(saveEntity);
        Map<String, Object> variables = new HashMap<String, Object>();
        Enumeration<String> parameterNames = request.getParameterNames();
        String comment = null;          // 批注
        try {
            while (parameterNames.hasMoreElements()) {
                String parameterName = (String) parameterNames.nextElement();
                if (parameterName.startsWith("p_")) {
                    // 参数结构：p_B_name，p为参数的前缀，B为类型，name为属性名称
                    String[] parameter = parameterName.split("_");
                    if (parameter.length == 3) {
                        String paramValue = request.getParameter(parameterName);
                        Object value = paramValue;
                        if (parameter[1].equals("B")) {
                            value = BooleanUtils.toBoolean(paramValue);
                        } else if (parameter[1].equals("DT")) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            value = sdf.parse(paramValue);
                        } else if (parameter[1].equals("COM")) {
                            comment = paramValue;
                        }
                        variables.put(parameter[2], value);
                    } else {
                        throw new RuntimeException("invalid parameter for activiti variable: " + parameterName);
                    }
                }
            }
            if (StringUtils.isNotEmpty(comment)) {
                identityService.setAuthenticatedUserId(ShiroUtils.getUserStringId());
                taskService.addComment(taskId, leave.getInstanceId(), comment);
            }
            bizLeaveService.complete(leave, saveEntityBoolean, taskId, variables);

            return success("任务已完成");
        } catch (Exception e) {
            logger.error("error on complete task {}, variables={}", new Object[]{taskId, variables, e});
            return error("完成任务失败");
        }
    }


    /**
     * 自动绑定页面字段
     */
    @ModelAttribute("preloadLeave")
    public BizLeaveVo getLeave(@RequestParam(value = "id", required = false) Long id, HttpSession session) {
        if (id != null) {
            return bizLeaveService.selectBizLeaveById(id);
        }
        return new BizLeaveVo();
    }



    @RequiresPermissions("process:leave:doneView")
    @GetMapping("/leaveDone")
    public String doneView() {
        return prefix + "/leaveDone";
    }

    /**
     * 我的已办列表
     * @param bizLeave
     * @return
     */
    @RequiresPermissions("process:leave:taskDoneList")
    @PostMapping("/taskDoneList")
    @ResponseBody
    public TableDataInfo taskDoneList(BizLeaveVo bizLeave) {
        startPage();
        List<BizLeaveVo> list = bizLeaveService.findDoneTasks(bizLeave, ShiroUtils.getUserStringId());
        return getDataTable(list);
    }

}