package com.netintech.park.controller;

import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.web.controller.BaseController;
import com.netintech.park.domain.OverviewBean;
import com.netintech.park.domain.StatisticsBean;
import com.netintech.park.service.IOverviewService;
import com.netintech.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author summer
 * @date 2020/5/13 14:57
 */

@Controller
@RequestMapping("/statistics/dimension")
public class DimensionController extends BaseController {
    private String dimensionprefix = "statistics/dimension";

    @Autowired
    private IOverviewService overviewService;

    @RequiresPermissions("statistics:dimension:view")
    @GetMapping()
    public String pandect(ModelMap mmap) {
        OverviewBean overviewBean = new OverviewBean();
        Map map = overviewService.getParkInfo();
        overviewBean.setParkId(Integer.parseInt(map.get("id").toString()));
        mmap.put("bean", map);
        return "statistics/parkview/index";
    }

    @GetMapping("/dimension")
    public String dimension(ModelMap mmap) {

        OverviewBean overviewBean = new OverviewBean();
        Map map = overviewService.getParkInfo();
        overviewBean.setParkId(Integer.parseInt(map.get("id").toString()));
        mmap.put("bean", map);
        mmap.put("overviewBean", leftSummaryByPark(overviewBean));
        mmap.put("id", map.get("id"));
        return dimensionprefix + "/parks";
    }


    /**
     * 小微园总览统计 -综合汇总
     */
    @PostMapping("/left/park/summary")
    @ResponseBody
    public OverviewBean leftSummaryByPark(OverviewBean bean) {
        return overviewService.leftSummaryByPark(bean);
    }

    /**
     * 小微园 -企业收入排行
     */
    @GetMapping("/income/rank/{parkId}")
    @ResponseBody
    public List<StatisticsBean> incomeRank(@PathVariable("parkId") Long parkId) {
        List<StatisticsBean> list = overviewService.incomeRank(parkId);
        return list;
    }

    /**
     * 小微园 -企业税收排行
     */
    @GetMapping("/tax/rank/{parkId}")
    @ResponseBody
    public List<StatisticsBean> taxRank(@PathVariable("parkId") Long parkId) {
        List<StatisticsBean> list = overviewService.taxRank(parkId);
        return list;
    }


    //园区改版新接口
    @GetMapping("/yqzl")
    public String yqzl(ModelMap mmap) {
        OverviewBean overviewBean = new OverviewBean();
        Map map = overviewService.getParkInfo();
        overviewBean.setParkId(Integer.parseInt(map.get("id").toString()));
        mmap.put("bean", map);
        mmap.put("overviewBean", leftSummaryByPark(overviewBean));
        mmap.put("id", map.get("id"));
        mmap.put("train",  overviewService.priseTrain());

        return "statistics/parkview/yqzl";
    }

    @GetMapping("/jjyx")
    public String jjyx(ModelMap mmap) {
        User user = ShiroUtils.getSysUser();
        Long dept = user.getDeptId();
        OverviewBean overviewBean = new OverviewBean();
        overviewBean.setParkId(Math.toIntExact(dept));
        //园区亩均税收和产值
        mmap.put("overviewBean", leftSummaryByPark(overviewBean));
        mmap.put("id", dept);
        mmap.put("part", overviewService.getPart());
        return "statistics/parkview/jjyx";
    }

    /**
     * 园区收入、税收趋势
     */
    @GetMapping("/income/tax/{type}")
    @ResponseBody
    public List<Map> incomeTax(@PathVariable("type") Integer type) {
       return overviewService.incomeTax(type);
    }

    /**
     * 园区 --企业类型
     */
    @GetMapping("/enterprise/type")
    @ResponseBody
    public List<Map> enterpriseType() {
        return overviewService.enterpriseType();
    }

}
