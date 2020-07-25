package com.netintech.park.controller;

import java.util.Date;
import java.util.List;

import com.netintech.common.constant.UserConstants;
import com.netintech.common.utils.bean.BeanUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.park.domain.SmallParkAttach;
import com.netintech.project.system.dept.domain.Dept;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.netintech.core.aspectj.lang.annotation.Log;
import com.netintech.core.aspectj.lang.enums.BusinessType;

import com.netintech.park.domain.SmallPark;
import com.netintech.park.service.ISmallParkService;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.domain.AjaxResult;
import com.netintech.common.utils.poi.ExcelUtil;
import com.netintech.core.web.page.TableDataInfo;

/**
 * 数字小微园信息Controller
 *
 * @author admin
 * @date 2020-04-17
 */
@Controller
@RequestMapping("/smallpark/park")
public class SmallParkController extends BaseController
{
    private String prefix = "smallpark/park";

    @Value("${deptid}")
    private String configdeptId ;
    private Long[] rolelist = {102L};

    @Autowired
    private ISmallParkService smallParkService;

    @Autowired
    private IDeptService deptService;
    @Autowired
    private IUserService userService;

    @RequiresPermissions("smallpark:park:view")
    @GetMapping()
    public String park()
    {
        return prefix + "/park";
    }

    /**
     * 查询数字小微园信息列表
     */
    @RequiresPermissions("smallpark:park:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SmallPark smallPark)
    {
        startPage();
        User user = ShiroUtils.getSysUser();
        if(user.getUserLevel().equals("2")){
            smallPark.setId(smallParkService.getParkId(user.getDeptId()));
        }
        List<SmallPark> list = smallParkService.selectParkList(smallPark);
        return getDataTable(list);
    }

    /**
     * 导出数字小微园信息列表
     */
    @RequiresPermissions("smallpark:park:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SmallPark smallPark)
    {
        User user = ShiroUtils.getSysUser();
        if(user.getUserLevel().equals("2")){
            smallPark.setId(user.getDeptId());
        }
        List<SmallPark> list = smallParkService.selectSmallParkList(smallPark);
        ExcelUtil<SmallPark> util = new ExcelUtil<SmallPark>(SmallPark.class);
        return util.exportExcel(list, "park");
    }

    /**
     * 新增数字小微园信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        String uuid = BeanUtils.getUUID();
        mmap.put("uuid",uuid);
        return prefix + "/add";
    }

    /**
     * 新增保存数字小微园信息
     */
    @RequiresPermissions("smallpark:park:add")
    @Log(title = "数字小微园信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SmallPark smallPark)
    {
        //插入部门
        if(UserConstants.PARK_NAME_UNIQUE.equals(smallParkService.checkParkNameUnique(smallPark.getParkName()))){
            Dept dept = new Dept();
            dept.setParentId(Long.valueOf(configdeptId));
            dept.setCreateTime(new Date());
            dept.setDeptName(smallPark.getParkName());
            dept.setDeptType("2");
            if (UserConstants.DEPT_NAME_NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept)))
            {
                return error("新增部门'" + dept.getDeptName() + "'失败，部门名称已存在");
            }
            deptService.insertDept(dept);
            int id = dept.getDeptId().intValue();
            smallPark.setId(Long.valueOf(id));
            //插入小微园
            smallParkService.insertSmallPark(smallPark);
            smallParkService.updateattachlist(smallPark);
            if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(smallPark.getParkName())))
            {
                return error("新增用户'" + smallPark.getParkName() + "'失败，登录账号已存在");
            }
            //插入用户
            User user = new User();
            user.setUserLevel("2");
            user.setPassword("123456");
            user.setDeptId(Long.valueOf(id));
            user.setUserName(smallPark.getParkName());
            user.setLoginName(smallPark.getParkName());
            user.setRoleIds(rolelist);
            userService.insertUser(user);
            AjaxResult ar = toAjax(id);
            return ar;
        }else
            return error("新增小微园'" + smallPark.getParkName() + "'失败，小微园名称已存在");

    }

    /**
     * 修改数字小微园信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SmallPark smallPark = smallParkService.selectSmallParkById(id);
        mmap.put("smallPark", smallPark);
        return prefix + "/edit";
    }

    /**
     * 修改保存数字小微园信息
     */
    @RequiresPermissions("smallpark:park:edit")
    @Log(title = "数字小微园信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SmallPark smallPark)
    {
        AjaxResult aj = new AjaxResult();
        aj = toAjax(smallParkService.updateSmallPark(smallPark));
        deptService.updateDeptNameByID(smallPark);
        smallParkService.updateattachlist(smallPark);
        return aj;
    }

    /**
     * 查看数字小微园信息
     */
    @RequiresPermissions("smallpark:park:detail")
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, ModelMap mmap)
    {
        SmallPark smallPark = smallParkService.selectSmallParkById(id);
        mmap.put("smallPark", smallPark);
        return prefix + "/view";
    }
    /**
     * 删除数字小微园信息
     */
    @RequiresPermissions("smallpark:park:remove")
    @Log(title = "数字小微园信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        AjaxResult aj = new AjaxResult();
        for (String str:ids.split(",")) {
            if(smallParkService.selectUserById(Long.valueOf(str))>0){
                return  error("所选园区下存在用户，删除失败");
            }else if(smallParkService.selectEnterpriseByPid(Long.valueOf(str))>0){
                return  error("所选园区下存在企业，删除失败");
            }
        }

        return toAjax(smallParkService.deleteSmallParkByIds(ids));
    }


    @PostMapping("/uploadfile")
    @ResponseBody
    public int uploadfile(@RequestParam("file_name") String file_name,
                          @RequestParam("file_alias") String file_alias, @RequestParam("file_path") String file_path,@RequestParam("fileUuid") String fileUuid) {
        return smallParkService.uploadfile( file_name, file_alias, file_path,fileUuid);
    }


    @PostMapping("/delfile")
    @ResponseBody
    public AjaxResult delfile(@RequestParam("id") Integer id)
    {
        return toAjax(smallParkService.delfile(id));
    }

    @PostMapping("/query/file")
    @ResponseBody
    public TableDataInfo queryFile(SmallParkAttach attach) {
        //根据uuid查询下面的附件
        return getDataTable(smallParkService.queryFileByUuid(attach.getFileUuid()));
    }

    /**
     * 根据区域id，查询下面的小微园信息及附件信息
     *
     */

    @PostMapping("/info")
    @ResponseBody
    public List<SmallPark> getParkInfo(SmallPark smallPark) {
        //根据区域id查询信息
        return smallParkService.getParkInfoByAreaId(smallPark, null);
    }

}
