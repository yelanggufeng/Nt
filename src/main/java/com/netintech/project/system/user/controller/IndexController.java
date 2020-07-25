package com.netintech.project.system.user.controller;


import com.netintech.common.utils.ServletUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.config.NtConfig;
import com.netintech.core.web.controller.BaseController;
import com.netintech.park.service.IOverviewService;
import com.netintech.park.service.ISmallParkService;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.project.system.menu.domain.Menu;
import com.netintech.project.system.menu.service.IMenuService;
import com.netintech.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 首页 业务处理
 *
 * @author admin
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private NtConfig ntConfig;

    @Autowired
    private IOverviewService overviewService;

//    @Autowired
//    private INoticeService noticeService;

//    @Autowired
//    private IGuideService guideService;

//    @Autowired
//    private IPartyTrendService partyTrendService;
//
//    @Autowired
//    private IPartyActivityService activityService;

//    @Autowired
//    private IPolicyTypeService typeService;
    @Autowired
    private ISmallParkService smallParkService;
    @Autowired
    private IDeptService deptService;

    @GetMapping("/gateway")
    public String gateway(HttpServletRequest request,HttpServletResponse response,ModelMap mmap) {
// 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        User user = ShiroUtils.getSysUser();
        mmap.put("user",user);
        return "gateway";
    }


    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        User user = getSysUser();
        if(user==null){
            return "redirect:/gateway";
        }
        String show = "政府监管";
        if(user.getUserLevel().equals("3")){
            show = "企业端";
        }else if(user.getUserLevel().equals("2")){
            show = "园区端";
        }
        mmap.put("show",show);
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus",menus);
        mmap.put("user",user);
        mmap.put("copyrightYear",ntConfig.getCopyrightYear());
        mmap.put("demoEnabled",ntConfig.isDemoEnabled());

        return "index";
    }


    // 系统首页
    @GetMapping("/indexgov")
    public String indexgov(ModelMap mmap) {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus",menus);
        mmap.put("user",user);
        mmap.put("copyrightYear",ntConfig.getCopyrightYear());
        mmap.put("demoEnabled",ntConfig.isDemoEnabled());
        return "indexgov";
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap) {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
//        User user = ShiroUtils.getSysUser();
//        //如果登录人是园区管理员，首页展示园区总览
//        if ("3".equals(user.getUserLevel())) {
//            //处理业务
//            ReadBean bean = new ReadBean();
//            bean.setDeptId(user.getDeptId());
//            mmap.put("noticeList",noticeService.getNoticeReadList(bean));
//            Guide guide = new Guide();
//            Long deptId = ShiroUtils.getSysUser().getDeptId();//当前登录账号所属部门
//            Long priseId = deptService.getPriseIdByDeptId(deptId);
//            Dept parkDept = deptService.selectDeptById(priseId);
//            Long parentId = parkDept.getParentId();
//            guide.setParkId(parentId);
//            guide.setStatus("0");
//            mmap.put("guideList",guideService.selectGuideList(guide));
//            PolicyType type = new PolicyType();
//            type.setStatus("0");
//            type.setDelFlag("0");
//            mmap.put("policyList",typeService.selectPolicyTypeList(type));
//            PartyTrend partyTrend = new PartyTrend();
//            partyTrend.setParkId(parentId);
//            partyTrend.setDelFlag("0");
//            mmap.put("trendList",partyTrendService.selectPartyTrendList(partyTrend));
//            PartyActivity partyActivity = new PartyActivity();
//            partyActivity.setParkId(parentId);
//            partyActivity.setDelFlag("0");
//            mmap.put("activityList",activityService.selectPartyActivityByApply(partyActivity));
//            return "enterprise/index/qiyeIndex";
//        }
//        if ("2".equals(user.getUserLevel())) {
//            OverviewBean overviewBean = new OverviewBean();
//            Map map = overviewService.getParkInfo();
//            overviewBean.setParkId(Integer.parseInt(map.get("id").toString()));
//            mmap.put("user",user);
//            mmap.put("bean",map);
//            mmap.put("overviewBean",overviewService.leftSummaryByPark(overviewBean));
//            mmap.put("id",map.get("id"));
//            Dept dept = new Dept();
//            if(user!=null){
//                if(user.getUserLevel().equals("2")){
//                    Long depeId = smallParkService.getParkId(user.getDeptId());
//                    dept = deptService.selectDeptById(depeId);
//                }
//            }
//            mmap.put("dept",dept);
////            return "statistics/dimension/dimension";
//            return "platform";
//        }
//
//        if ("1".equals(user.getUserLevel()) || user.isAdmin()) {
//            OverviewBean bean = overviewService.leftSummary(null);
//            List<Map> list = overviewService.parkLevel();
//            mmap.put("bean",bean);
//            mmap.put("list",list);
//            return "statistics/overview/yqzl";
//
//            return "screen/largeScreen";
//        }
        return "main";
    }
}
