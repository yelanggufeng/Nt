package com.netintech.project.system.user.controller;

import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.SmallParkAttach;
import com.netintech.park.mapper.SmallParkMapper;
import com.netintech.park.service.ISmallParkService;
import com.netintech.project.system.dict.service.IDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author summer
 * @date 2020/5/27 8:32
 */
@Controller
public class JumpUrlController {

//    @Autowired
//    private INewsInfoService newsService;
//    @Autowired
//    private INoticeService noticeService;
//    @Autowired
//    private IPolicyTypeService policyTypeService;
//    @Autowired
//    private IPartyTrendService trendService;
//    @Autowired
//    private IAttachmentPartyTrendService attachmentPartyTrendService;
//
//    @Autowired
//    private IPartyActivityService activityService;
//    @Autowired
//    private IAttachmentPartyActivityService attachmentService;
    @Autowired
    private ISmallParkService smallParkService;
    @Autowired
    private SmallParkMapper smallParkMapper;
    @Autowired
    private IDictDataService dictDataService;

    /**
     * 新闻资讯
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/xwzx_conntent/{id}")
    public String newsInfoDetail(@PathVariable Long id, ModelMap mmap) {
      //根据id查询新增资讯详情
        //mmap.put("newsBean", newsService.selectNewsInfoById(id));
        return "index/xwzx_conntent";
    }

    /**
     * 通知公告
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/tzgg_conntent/{id}")
    public String noticeDetail(@PathVariable Long id, ModelMap mmap) {
        //根据id查询新增资讯详情
        //mmap.put("noticeBean", noticeService.gwNoticeById(id));
        return "index/tzgg_conntent";
    }

    /**
     * 政策服务
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/zcfw_conntent/{id}")
    public String PolicyDetail(@PathVariable Long id, ModelMap mmap) {
        //根据id查询新增资讯详情
        //mmap.put("policyBean", policyTypeService.selectPolicyTypeById(id));
        return "index/zcfw_conntent";
    }

    /**
     * 党建动态
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/trend_conntent/{id}")
    public String trendDetail(@PathVariable Long id, ModelMap mmap) {
        //根据id查询新增资讯详情
//        mmap.put("trendBean", trendService.selectPartyTrendById(id));
//        AttachmentPartyTrend attachmentPartyTrend = new AttachmentPartyTrend();
//        attachmentPartyTrend.setTrendId(id);
//        List<AttachmentPartyTrend> list = attachmentPartyTrendService.selectAttachmentPartyTrendList(attachmentPartyTrend);
//        mmap.put("list",list);
        return "index/trend_conntent";
    }

    /**
     * 党建活动
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/activity_conntent/{id}")
    public String activeDetail(@PathVariable Long id, ModelMap mmap) {
        //根据id查询新增资讯详情和附件h
//        PartyActivity activity = activityService.selectPartyActivityById(id);
//        mmap.put("activeBean", activity);
//        AttachmentPartyActivity attachmentPartyActivity = new AttachmentPartyActivity();
//        attachmentPartyActivity.setActId(activity.getId());
//        List<AttachmentPartyActivity> list =  attachmentService.selectAttachmentPartyActivityList(attachmentPartyActivity);
//        mmap.put("fileList", list);
        return "index/activity_conntent";
    }

    /**
     * yuanqu
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/xwyq_conntent/{id}")
    public String xwyqDetail(@PathVariable Long id, ModelMap mmap) {
        SmallPark smallPark = smallParkService.selectSmallParkById(id);
        mmap.put("smallPark", smallPark);
        mmap.put("dictLabel", dictDataService.selectDictLabel("leading_industry",String.valueOf(smallPark.getLeadingIndustryId())));
        List<SmallParkAttach> attaches = smallParkMapper.queryFileByParkId(id);
        if (attaches.size() > 0) {
            mmap.put("img",attaches.get(0).getFilePath());
        } else {
            mmap.put("img","/xwyjs/images/28/W128_zwtp.png");
        }

        return "index/xwyq_conntent";
    }



}
