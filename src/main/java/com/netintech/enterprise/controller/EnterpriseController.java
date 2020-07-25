package com.netintech.enterprise.controller;

import java.util.Date;
import java.util.List;

import com.netintech.common.constant.UserConstants;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.service.ISmallParkService;
import com.netintech.project.system.dept.domain.Dept;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;

import com.netintech.enterprise.domain.Enterprise;
import com.netintech.enterprise.service.IEnterpriseService;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.web.page.TableDataInfo;

/**
 * 企业信息Controller
 *
 * @author admin
 * @date 2020-04-17
 */
@Controller
@RequestMapping("/enterprise/enterprise")
public class EnterpriseController extends BaseController {
    private String prefix = "enterprise/enterprise";
    private Long[] rolelist = {103L};
    @Autowired
    private IEnterpriseService enterpriseService;

    @Autowired
    private ISmallParkService smallParkService;

    @Autowired
    private IDeptService deptService;
    @Autowired
    private IUserService userService;



    @RequiresPermissions("enterprise:enterprise:view")
    @GetMapping()
    public String enterprise() {
        return prefix + "/enterprise";
    }

    /**
     * 查询企业信息列表
     */
    @RequiresPermissions("enterprise:enterprise:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Enterprise enterprise) {
        startPage();
        User user = ShiroUtils.getSysUser();
        if(user.getUserLevel().equals("2")){
            enterprise.setSmallId(smallParkService.getParkId(user.getDeptId()));
        }else if (user.getUserLevel().equals("3")){
            enterprise.setId(enterpriseService.getEnterpriseId(user.getDeptId()));
        }
        List<Enterprise> list = enterpriseService.selectEnterpriseList(enterprise);
        return getDataTable(list);
    }

    /**
     * 导出企业信息列表
     */
    @RequiresPermissions("enterprise:enterprise:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Enterprise enterprise) {
        User user = ShiroUtils.getSysUser();
        if(user.getUserLevel().equals("2")){
            enterprise.setSmallId(smallParkService.getParkId(user.getDeptId()));
        }else if (user.getUserLevel().equals("3")){
            enterprise.setId(enterpriseService.getEnterpriseId(user.getDeptId()));
        }
        List<Enterprise> list = enterpriseService.selectEnterpriseList(enterprise);
        ExcelUtil<Enterprise> util = new ExcelUtil<Enterprise>(Enterprise.class);
        return util.exportExcel(list, "enterprise");
    }

    /**
     * 新增企业信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        User user = ShiroUtils.getSysUser();
        Long deptId = smallParkService.getParkId(user.getDeptId());
        SmallPark sp =smallParkService.selectSmallParkById(deptId);
        mmap.put("user", user);
        mmap.put("park", sp);
        return prefix + "/add";
    }

    /**
     * 新增保存企业信息
     */
    @RequiresPermissions("enterprise:enterprise:add")
    @Log(title = "企业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Enterprise enterprise) {
        //插入部门
        if (UserConstants.ENTERPRISE_NAME_UNIQUE.equals(enterpriseService.checkEnterpriseNameUnique(enterprise))) {
            Dept dept = new Dept();
            dept.setParentId(enterprise.getSmallId());
            dept.setCreateTime(new Date());
            dept.setDeptName(enterprise.getEnterpriseName());
            dept.setDeptType("3");
            if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept))) {
                return error("新增部门'" + dept.getDeptName() + "'失败，部门名称已存在");
            }
            deptService.insertDept(dept);
            int id = dept.getDeptId().intValue();
            enterprise.setId(Long.valueOf(id));
            //插入企业
            enterpriseService.insertEnterprise(enterprise);
            if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(enterprise.getEnterpriseName()))) {
                return error("新增用户'" + enterprise.getEnterpriseName() + "'失败，登录账号已存在");
            }
            //插入用户
            User user = new User();
            user.setPassword("123456");
            user.setDeptId(Long.valueOf(id));
            user.setUserName(enterprise.getEnterpriseName());
            user.setLoginName(enterprise.getEnterpriseName());
            user.setRoleIds(rolelist);
            user.setUserLevel("3");
            userService.insertUser(user);
            AjaxResult ar = toAjax(id);
            return ar;
        } else
            return error("新增小微园'" + enterprise.getEnterpriseName() + "'失败，小微园名称已存在");
    }

    /**
     * 修改企业信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Enterprise enterprise = enterpriseService.selectEnterpriseById(id);
        User user = ShiroUtils.getSysUser();
        SmallPark sp =smallParkService.selectSmallParkById(enterprise.getSmallId());
        mmap.put("user", user);
        mmap.put("park", sp);
        mmap.put("enterprise", enterprise);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业信息
     */
    @RequiresPermissions("enterprise:enterprise:edit")
    @Log(title = "企业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Enterprise enterprise) {
        AjaxResult aj = toAjax(enterpriseService.updateEnterprise(enterprise));
        enterpriseService.updateDeptNamebyName(enterprise);
        return aj;
    }

    /**
     * 查看企业信息
     */
    @RequiresPermissions("enterprise:enterprise:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap) {
        Enterprise enterprise = enterpriseService.selectEnterpriseById(id);
        mmap.put("enterprise", enterprise);
        return prefix + "/view";
    }

    /**
     * 删除企业信息
     */
    @RequiresPermissions("enterprise:enterprise:remove")
    @Log(title = "企业信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        AjaxResult aj = new AjaxResult();
        for (String str : ids.split(",")) {
            if (enterpriseService.selectUserById(Long.valueOf(str)) > 0) {
                return error("所选企业下存在用户，删除失败");
            }
        }
        return toAjax(enterpriseService.deleteEnterpriseByIds(ids));
    }
}
