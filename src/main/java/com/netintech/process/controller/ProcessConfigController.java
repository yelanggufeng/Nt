package com.netintech.process.controller;


import com.netintech.core.web.domain.AjaxResult;
import org.activiti.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 流程配置用户列表
 */
@RestController
@RequestMapping("/modeler/process/config")
public class ProcessConfigController {

    @Autowired
    private IdentityService identityService;



    /**
     * 查询流程用户列表
     * @return
     */
    @GetMapping("/user")
    @ResponseBody
    public AjaxResult user(String userName) {
        try {
            return AjaxResult.success(identityService.createUserQuery().userFirstNameLike("%" + userName + "%").list());
        }
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 查询流程用户组列表
     * @return
     */
    @GetMapping("/group")
    @ResponseBody
    public AjaxResult group(String groupName) {
        try {
            return AjaxResult.success(identityService.createGroupQuery().groupNameLike("%"+groupName+"%").list());
        }
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
