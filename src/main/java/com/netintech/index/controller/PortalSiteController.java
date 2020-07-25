package com.netintech.index.controller;

import com.github.pagehelper.PageHelper;
import com.netintech.common.utils.ServletUtils;
import com.netintech.common.utils.StringUtils;
import com.netintech.core.web.controller.BaseController;
import com.netintech.core.web.page.TableDataInfo;
import com.netintech.park.domain.OverviewBean;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.StatisticsBean;
import com.netintech.park.mapper.OverviewExtMapper;
import com.netintech.park.service.IOverviewService;
import com.netintech.park.service.ISmallParkService;
import com.netintech.project.system.dept.domain.Dept;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 门户页面路径
 */

@Controller
@RequestMapping("/index")
public class PortalSiteController extends BaseController {

//    @Autowired
//    private INewsInfoService newsInfoService;
//    @Autowired
//    private IUpgradeService upgradeService;
//    @Autowired
//    private IPolicyTypeService policyTypeService;
//    @Autowired
//    private PolicyTypeMapper policyTypeMapper;
//    @Autowired
//    private IAttachmentOrgSettingService settingService;
//    @Autowired
//    private IPolicyTypeService typeService;
//    @Autowired
//    private INoticeService noticeService;
    @Autowired
    private OverviewExtMapper overviewExtMapper;

    @Autowired
    private IOverviewService overviewService;
    @Autowired
    private ISmallParkService smallParkService;
    @Autowired
    private IDeptService  deptService;
    /**
     * 首页跳转
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/home")
    public String index(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
// 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        //热门政策
//        List<PolicyType> policyTypes = typeService.policyTypeListLimit();
//        List<PolicyTypeBean> beanList = new ArrayList<>();
//        Integer index1 = null;
//        Integer index2 = null;
//        if (policyTypes.size() > 0) {
//            PolicyTypeBean bean1 = new PolicyTypeBean();
//            if (policyTypes.size()<3 || policyTypes.size()>0) {
//                index1 = 0;
//                if (policyTypes.size() >= 2) index2= 1; else index2= null;
//                bean1 = getBean(policyTypes, bean1,index1,index2);
//                beanList.add(bean1);
//            }
//            if ((policyTypes.size() >2 && policyTypes.size() <5) || (policyTypes.size() >2 && policyTypes.size() <=6)) {
//                PolicyTypeBean bean2 = new PolicyTypeBean();
//                index1 = 2;
//                if (policyTypes.size() >= 4) index2 = 3; else index2= null;
//                bean2 = getBean(policyTypes, bean2,index1,index2);
//                beanList.add(bean2);
//            }
//            if (policyTypes.size() >4 && policyTypes.size() ==6) {
//                PolicyTypeBean bean3 = new PolicyTypeBean();
//                index1 = 4;
//                if (policyTypes.size() ==6) index2= 5; else index2= null;
//                bean3 =  getBean(policyTypes, bean3,index1,index2);
//                beanList.add(bean3);
//            }
//        }
//        mmap.put("policyList", beanList);

//        int listSize=list.size();
//        int toIndex=2;
//        Map map = new HashMap();     //用map存起来新的分组后数据
//        int keyToken = 0;
//        for(int i = 0;i<list.size();i+=2){
//            if(i+2>listSize){        //作用为toIndex最后没有100条数据则剩余几条newList中就装几条
//                toIndex=listSize-i;
//            }
//            List newList = list.subList(i,i+toIndex);
//            map.put("keyName"+keyToken, newList);
//            keyToken++;
//        }
//        mmap.put("map", map);
        //新闻资讯
//        List<NewsInfo> newsInfoList = newsInfoService.selectNewsInfoListByLimit("0");
//        mmap.put("detalByNews", newsInfoList.size() > 0 ? newsInfoList.get(0) : new NewsInfo());
//        if (newsInfoList.size() > 0) {
//            newsInfoList.remove(0);
//        }
//        mmap.put("newsList", newsInfoList);


        //公开通知公告
//        List<Notice> noticeList = noticeService.selectPublishByLimit();
//        mmap.put("detalByNotice", noticeList.size() > 0 ? noticeList.get(0) : new Notice());
//        if (noticeList.size() > 0) {
//            noticeList.remove(0);
//        }
//        mmap.put("noticeList", noticeList);

        //信息公开
//        List<NewsInfo> infoList = newsInfoService.selectNewsInfoListByLimit("1");
//        mmap.put("detalByInfo", infoList.size() > 0 ? infoList.get(0) : new NewsInfo());
//        if (infoList.size() > 0) {
//            infoList.remove(0);
//        }
//        mmap.put("publicList", infoList);

        //数字小微园
        List<SmallPark> parkList = smallParkService.getParkInfoByAreaId(null,1);
        mmap.put("parkList", parkList);
        return "index/index";
    }

//    public PolicyTypeBean getBean(List<PolicyType> policyTypes,PolicyTypeBean bean,Integer index1,Integer idex2) {
//        if (index1 != null) {
//            bean.setId1(policyTypes.get(index1).getId());
//            bean.setTitle1(policyTypes.get(index1).getTypeName());
//            bean.setCreateTime1(policyTypes.get(index1).getCreateTime());
//            bean.setMainContent1(policyTypes.get(index1).getProfile());
//            bean.setDeptName1(policyTypes.get(index1).getDeptName());
//        }
//
//        if (idex2 != null) {
//            bean.setId2(policyTypes.get(idex2).getId());
//            bean.setTitle2(policyTypes.get(idex2).getTypeName());
//            bean.setMainContent2(policyTypes.get(idex2).getProfile());
//            bean.setCreateTime2(policyTypes.get(idex2).getCreateTime());
//            bean.setDeptName2(policyTypes.get(idex2).getDeptName());
//        }
//        return bean;
//    }

    /**
     * 新闻咨讯
     *
     * @param request
     * @param response
     * @return
     */
//    @GetMapping("/newInfo/{type}")
//    public String newInfo(@PathVariable String type, HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
//// 如果是Ajax请求，返回Json字符串。
//        if (ServletUtils.isAjaxRequest(request)) {
//            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
//        }
//
//        //新闻资讯
//        NewsInfo newsInfo = new NewsInfo();
//        if (!"3".equals(type)) {
//            newsInfo.setNewsType(type);
//        }
//        List<NewsInfo> newsInfoList = newsInfoService.selectNewsInfoList(newsInfo);
//        mmap.put("newsList", newsInfoList);
//        mmap.put("type", type);
//        return "index/newsInfo";
//    }

    /**
     * 通知公告
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/noticeInfo")
    public String notice(HttpServletRequest request,HttpServletResponse response) {
// 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "index/noticeInfo";
    }


    /**
     * 通知公告
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/policyService")
    public String policyService(HttpServletRequest request,HttpServletResponse response) {
// 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "index/policyService";
    }


    /**
     * 党建服务
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/parkService")
    public String parkService(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
// 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        //查询组织机构、领导班子、机构职能
//        List<AttachmentOrgSetting> list = settingService.selectAttachmentOrgSettingList(null);
//        for (AttachmentOrgSetting setting : list) {
//            if (setting.getType() == 1) {
//                mmap.put("org", setting.getFilePath());
//            }
//            if (setting.getType() == 2) {
//                mmap.put("ldbz", setting.getFilePath());
//            }
//            if (setting.getType() == 3) {
//                mmap.put("jgzn", setting.getFilePath());
//            }
//        }
        return "index/parkService";
    }

    /**
     * 小微园区
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/parks")
    public String parks(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
// 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        // 查询所有区域
        //mmap.put("areaList", overviewExtMapper.selectArea());
        return "index/parks";
    }


    /**
     * 小微园区平台
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/platform")
    public String platform(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
// 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        Dept dept = new Dept();
        User user = getSysUser();
        if(user!=null){
            if(user.getUserLevel().equals("2")){
                Long depeId = smallParkService.getParkId(user.getDeptId());
                 dept = deptService.selectDeptById(depeId);
            }
        }
        mmap.put("dept",dept);
        return "platform";
    }

    /**
     * APP政策列表
     * @param policyType
     * @return
     */
//    @PostMapping("/categorylist")
//    @CrossOrigin
//    @ResponseBody
//    public AjaxResult categorylist(@RequestBody Map bean)
//    {
//        PolicyType policyType = new PolicyType();
//        BeanUtils.copyProperties(bean,policyType);
//        Map map = new HashMap();
//        appstartPage(bean);
//        List<PolicyTypeEx> list = policyTypeService.selectPolicyStatisticsList2(policyType);
//        int total = policyTypeService.getCount(policyType);
//        int publiced = policyTypeMapper.getPublicType();
//        int applyenterprise = policyTypeMapper.getApplyEnterprise();
//        map.put("list",getappDataTable(list,total));
//        map.put("publiccount", publiced);
//        map.put("enterprisecount", applyenterprise);
//        return AjaxResult.success("",map);
//    }

    /**
     * APP政策详情
     * @param id
     * @return
     */
//    @PostMapping("/categorydetial/{id}")
//    @CrossOrigin
//    @ResponseBody
//    public AjaxResult categorydetial(@PathVariable("id") Long id)
//    {
//        PolicyType policyType = policyTypeService.selectPolicyTypeById(id);
//        PolicyTypeEx ex = new PolicyTypeEx();
//        BeanUtils.copyProperties(policyType,ex);
//        ex.setFiletypelist( policyTypeService.getTypeListByTypeId(ex.getId().intValue()));
//        return AjaxResult.success( "",ex);
//    }


    /**
     * APP政策已读/未读列表
     * @param po
     * @return
     */
//    @PostMapping("/readlist")
//    @CrossOrigin
//    @ResponseBody
//    public AjaxResult readlist(@RequestBody Map bean)
//    {
//        PolicyTypeEx po = new PolicyTypeEx();
//        BeanUtils.copyProperties(bean,po);
//        appstartPage(bean);
//        List<Enterprise>list = new ArrayList<Enterprise>();
//        int total=0;
//        if(po.getIsread()==1) {
//             list = policyTypeService.selectReadEnterprise(po.getCategoryId());
//             total = policyTypeService.countReadEnterprise(po.getCategoryId());
//        }
//        else {
//             list = policyTypeService.selectUnreadEnterprise(po.getCategoryId());
//            total = policyTypeService.countUnReadEnterprise(po.getCategoryId());
//        }
//        return AjaxResult.success( "",getappDataTable(list,total));
//    }

    /**
     * APP通知公告列表
     * @param bean
     * @return
     */
//    @PostMapping("/noticelist")
//    @CrossOrigin
//    @ResponseBody
//    public AjaxResult noticelist(@RequestBody Map bean)
//    {
//        Notice notice = new Notice();
//        BeanUtils.copyProperties(bean,notice);
//        Map map = new HashMap();
//        appstartPage(bean);
//        List<Notice> list =  noticeService.selectNoticeStaticList(notice);
//        int total = noticeService.countNotice(notice);
//        map.put("list",getappDataTable(list,total));
//        return AjaxResult.success("",map);
//    }

    /**
     * APP通知公告 详情
     * @param id
     * @return
     */
//    @PostMapping("/noticedetial/{id}")
//    @CrossOrigin
//    @ResponseBody
//    public AjaxResult noticedetial(@PathVariable("id") Long id)
//    {
//        Notice bean = noticeService.gwNoticeById(id);
//         bean.setTemplist(noticeService.getTypeListByTypeId(id));
//        return AjaxResult.success( "",bean);
//    }

    /**
     * APP政策已读/未读列表
     * @param po
     * @return
     */
//    @PostMapping("/noticereadlist")
//    @CrossOrigin
//    @ResponseBody
//    public AjaxResult noticereadlist(@RequestBody Map bean)
//    {
//        Notice notice = new Notice();
//        BeanUtils.copyProperties(bean,notice);
//        appstartPage(bean);
//        List<Enterprise>list =  noticeService.getAPPNoticeReadList(notice);
//        int total = noticeService.countNoticeReadList(notice);
//        return AjaxResult.success( "",getappDataTable(list,total));
//    }

    /**
     * 大屏
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/government/overview")
    public String largeScreen(HttpServletRequest request,HttpServletResponse response) {
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "screen/largeScreen";
    }

    /**
     * 小微园总览
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/park/overview")
    public String parkOverview(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        OverviewBean bean = overviewService.leftSummary(null);
//        List<Map> list = overviewService.parkLevel();
//
//        int listSize=list.size();
//        int toIndex=6;
//        Map map = new HashMap();     //用map存起来新的分组后数据
//        int keyToken = 0;
//        for(int i = 0;i<list.size();i+=6){
//            if(i+6>listSize){        //作用为toIndex最后没有100条数据则剩余几条newList中就装几条
//                toIndex=listSize-i;
//            }
//            List newList = list.subList(i,i+toIndex);
//            map.put("keyName"+keyToken, newList);
//            keyToken++;
//        }
        mmap.put("bean", bean);
//        mmap.put("list",list);
//        mmap.put("map",map);
        return "screen/parkOverview";
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
     * 园区下的经纬度
     */
    @GetMapping("/latitude/longitude")
    @ResponseBody
    public List<Map> getLatLongi() {
        return overviewService.getLatLongi();
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
     * 经济运行
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/economic")
    public String economic(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        Map averMap = taxAverage();
        //企业培育情况
        mmap.put("bean", priseTrain());
        //高端要素
        mmap.put("part", overviewService.getPart());
        mmap.put("average", averMap);
        //就业贡献率
        List<Map> map = overviewService.obtainEmployment();
        mmap.put("employment", map);
        mmap.put("employSize", map.size());
        return "screen/economic";
    }



    /**
     * 园区亩均税收  1-季；2-年
     */
    @GetMapping("/average/tax")
    @ResponseBody
    public Map taxAverage() {
        return overviewService.taxAverage(2);
    }
    /**
     * 园区排行
     */
    @GetMapping("/park/rank")
    @ResponseBody
    public List<Map> getParkRank() {
        return overviewService.getParkRank();
    }

    @GetMapping("/flv")
    public String flv(HttpServletRequest request,HttpServletResponse response) {

        return "flv";
    }

    /**
     * 企业培育情况
     * @return
     */
    @GetMapping("/enterprise/train")
    @ResponseBody
    public Map priseTrain() {
        return overviewService.priseTrain();
    }

    /**
     * 园区收入根据年份
     * @return
     */
    @PostMapping("/park/income")
    @ResponseBody
    public List<Map> parkIncome() {
        return overviewService.parkIncome();
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

    /**
     * 地图跳转到二览页面
     */
    @GetMapping("/parks/parks/{parkId}")
    public String parks(@PathVariable("parkId") Integer parkId, ModelMap mmap ) {
        OverviewBean overviewBean = new OverviewBean();
        overviewBean.setParkId(parkId);
        mmap.put("overviewBean", overviewService.leftSummaryByPark(overviewBean));
        mmap.put("parkId", parkId);
        return "screen/parks";
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
     * 经济运行
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/project/promotion")
    public String projectPromotion(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        OverviewBean bean = overviewService.leftSummary(null);
        List<Map> mapList = overviewService.buildProgess();
        mmap.put("list", mapList);
        BigDecimal sum = BigDecimal.ZERO;
        for (Map map : mapList) {
            sum = sum.add(new BigDecimal(map.get("progess").toString()));
        }
        mmap.put("avageProgess", sum.divide(new BigDecimal(mapList.size()),2,BigDecimal.ROUND_HALF_UP));
        mmap.put("bean", bean);
        return "screen/projectPromotion";
    }

    /**
     * 主导产业
     */
    @PostMapping("/industry")
    @ResponseBody
    public List<Map> industry() {
        List<Map> list = overviewService.selectIndustry();
        return list;
    }

    /**
     * 历年投资
     */
    @PostMapping("/investment")
    @ResponseBody
    public List<Map> investment() {
        List<Map> list = overviewService.investment();
        return list;
    }

    /**
     * 开发建设模式
     */
    @PostMapping("/developmentMode")
    @ResponseBody
    public List<Map> developmentMode() {
        List<Map> list = overviewService.developmentMode();
        return list;
    }

    /**
     * 新增方式
     */
    @PostMapping("/newway")
    @ResponseBody
    public List<Map> newWay() {
        List<Map> list = overviewService.newWay();
        return list;
    }

    /**
     * 实时监控
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/alarm")
    public String alarm(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        User user = getSysUser();
        if (user == null) {
            user = new User();
        }
        mmap.put("user", user);
        return "screen/alarm";
    }

    /**
     * 选中园区跳转
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/monitor/detail/{id}")
    public String monitorDetail(@PathVariable("id") Long id,HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        mmap.put("id", id);
        mmap.put("name", smallParkService.selectSmallParkById(id).getParkName());
        User user = getSysUser();
        if (user == null) {
            user = new User();
        }
        mmap.put("user", user);
        return "screen/monitorDetail";
    }



    /**
     * 运营服务
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/service")
    public String service(HttpServletRequest request,HttpServletResponse response, ModelMap mmap) {
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response,"{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "screen/service";
    }

    /**
     * 主导产业
     */
    @GetMapping("/search/{type}/{keyword}")
    public String search(@PathVariable("type") Integer type,@PathVariable("keyword") String keyword, ModelMap mmap) {
        if (!"0".equals(keyword)) {
            mmap.put("keyword", keyword);
        }

        if (type == 1) {
            return "index/policyService";
        }
        if (type == 2) {
            mmap.put("type", 3);
            return "index/newsInfo" ;
        }
        if (type == 3) {
            return "index/noticeInfo";
        }
        return null;
    }


    /**
     * 隐私声明
     */
    @GetMapping("/yssm")
    public String yssm(HttpServletRequest request,HttpServletResponse response) {
        return "index/yssm";
    }

    /**
     * 关于我么
     */
    @GetMapping("/gywm")
    public String gywm(HttpServletRequest request,HttpServletResponse response) {
        return "index/gywm";
    }

    protected void appstartPage(Map bean)
    {

        Integer pageNum =bean.get("pageNum")==null?1:(Integer)bean.get("pageNum") ;
        Integer pageSize =bean.get("pageSize")==null?10:(Integer) bean.get("pageSize");
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = StringUtils.EMPTY;
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getappDataTable(List<?> list,int total)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(total);
        return rspData;
    }
}
