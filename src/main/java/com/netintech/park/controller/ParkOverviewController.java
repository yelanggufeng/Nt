package com.netintech.park.controller;

import com.netintech.core.web.controller.BaseController;
import com.netintech.park.domain.OverviewBean;
import com.netintech.park.domain.StatisticsBean;
import com.netintech.park.service.IOverviewService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 园区总览
 *
 * @author summer
 * @date 2020/5/9 13:35
 */

@Controller
@RequestMapping("/statistics/overview")
public class ParkOverviewController extends BaseController {

    private String prefix = "statistics/overview";

    @Autowired
    private IOverviewService overviewService;

    @RequiresPermissions("statistics:overview:view")
    @GetMapping()
    public String yqzl() {
        return prefix + "/yqzl";
    }

//    @GetMapping("/platform")
//    public String platform() {
//        return prefix + "/platform";
//    }

    @GetMapping("/yqzl_zl")
    public String yqzl_zl(ModelMap mmap) {
        OverviewBean bean = overviewService.leftSummary(null);
        List<Map> list = overviewService.parkLevel();
        int listSize=list.size();
        int toIndex=6;
        Map map = new HashMap();     //用map存起来新的分组后数据
        int keyToken = 0;
        for(int i = 0;i<list.size();i+=6){
            if(i+6>listSize){        //作用为toIndex最后没有100条数据则剩余几条newList中就装几条
                toIndex=listSize-i;
            }
            List newList = list.subList(i,i+toIndex);
            map.put("keyName"+keyToken, newList);
            keyToken++;
        }
        mmap.put("bean", bean);
        mmap.put("list",list);
        mmap.put("map",map);
        return prefix + "/yqzl_zl";
    }

    @GetMapping("/yqzl_jjyx")
    public String yqzl_jjyx(ModelMap mmap) {
        Map map = priseTrain();
        Map partMap = getPart();
        Map averMap = taxAverage(1);
        mmap.put("bean", map);
        mmap.put("part", partMap);
        mmap.put("average", averMap);
        return prefix + "/yqzl_jjyx";
    }

    @GetMapping("/realTime")
    public String realTime(ModelMap mmap) {
        return prefix + "/realTime";
    }

    @RequiresPermissions("statistics:overview:dimension")
    @GetMapping("/dimension")
    public String dimension() {
        return prefix + "/dimension";
    }


    /**
     * 小微园总览统计 -综合汇总
     */
    @PostMapping("/left/summary")
    @ResponseBody
    public OverviewBean leftSummary(OverviewBean bean) {
        return overviewService.leftSummary(bean);
    }

    /**
     * 小微园总览统计 -入园企业趋势
     */
    @PostMapping("/left/trend")
    @ResponseBody
    public List<OverviewBean> leftTrend() {
        List<OverviewBean> list = overviewService.leftTrend();
        return list;
    }

    /**
     * 小微园总览统计 -园区等级
     */
    @PostMapping("/under/level")
    @ResponseBody
    public List<Map> parkLevel() {
        List<Map> list = overviewService.parkLevel();
        return list;
    }



    /**
     * 企业培训情况
     */

    @GetMapping("/enterprise/train")
    @ResponseBody
    public Map priseTrain() {
        return overviewService.priseTrain();
    }

    /**
     * 园区就业贡献率
     */
    @GetMapping("/obtain/employment")
    @ResponseBody
    public List<Map> obtainEmployment() {
        List<Map> list = overviewService.obtainEmployment();
        return list;
    }

    /**
     * 园区亩均税收  1-季；2-年
     */
    @GetMapping("/average/tax/{type}")
    @ResponseBody
    public Map taxAverage(@PathVariable("type") Integer type) {
        return overviewService.taxAverage(type);
    }

    /**
     * 高端要素聚集
     */
    @GetMapping("/below/part")
    @ResponseBody
    public Map getPart() {
        return overviewService.getPart();
    }


    /**
     * 园区排行
     */
    @GetMapping("/right/park/rank")
    @ResponseBody
    public List<Map> getParkRank() {
        return overviewService.getParkRank();
    }


    /**
     * 园区下的经纬度
     */
    @GetMapping("/latitude/longitude")
    @ResponseBody
    public List<Map> getLatLongi() {
        return overviewService.getLatLongi();
    }
}
