package com.netintech.park.controller;

import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.web.controller.BaseController;
import com.netintech.park.domain.OverviewBean;
import com.netintech.park.domain.StatisticsBean;
import com.netintech.park.service.IOverviewService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.jar.JarOutputStream;

/**
 * @author summer
 * @date 2020/5/13 19:25
 */

@Controller
@RequestMapping("/statistics/eachpark")
public class EachparkController extends BaseController {
    private String eachparkprefix = "statistics/eachpark";

    @Autowired
    private IOverviewService overviewService;

    @RequiresPermissions("statistics:eachpark:view")
    @GetMapping()
    public String park(ModelMap mmap) {

        //用户信息返给前端
        mmap.put("bean", ShiroUtils.getSysUser());
        return eachparkprefix + "/pandect";
    }

    @GetMapping("/dimension/{parkId}")
    public String viewpark(@PathVariable Long parkId, ModelMap mmap) {

        List<Map> map = overviewService.getParkInfoByParkId(parkId);
        OverviewBean overviewBean = new OverviewBean();
        if (map.size() > 0) {
            overviewBean.setParkId( Integer.parseInt(map.get(0).get("id").toString()));
        } else {
            overviewBean.setParkId(Math.toIntExact(parkId));
        }
        mmap.put("overviewBean", leftSummaryByPark(overviewBean));
        mmap.put("bean", map);
        mmap.put("id", map.get(0).get("id"));
        return eachparkprefix + "/dimension";
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


    @GetMapping("/ndimension/{parkId}")
    public String nviewpark(@PathVariable Long parkId, ModelMap mmap) {
        System.out.println("zouzhel2 ======"+parkId);
        List<Map> map = overviewService.getParkInfoByParkId(parkId);
        OverviewBean overviewBean = new OverviewBean();
        if (map.size() > 0) {
            overviewBean.setParkId( Integer.parseInt(map.get(0).get("id").toString()));
        } else {
            overviewBean.setParkId(Math.toIntExact(parkId));
        }
        mmap.put("overviewBean", leftSummaryByPark(overviewBean));
        mmap.put("bean", map);
        mmap.put("id", map.get(0).get("id"));
        System.out.println("zouzhel3 ======"+parkId);
        return eachparkprefix + "/ndimension";
    }
}
