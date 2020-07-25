package com.netintech.process.general.service.impl;

import com.github.pagehelper.Page;
import com.netintech.common.utils.StringUtils;
import com.netintech.core.web.page.PageDomain;
import com.netintech.core.web.page.TableSupport;
import com.netintech.process.general.domain.HistoricActivity;
import com.netintech.process.general.mapper.ProcessMapper;
import com.netintech.process.general.service.IProcessService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.task.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProcessServiceImpl implements IProcessService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProcessMapper processMapper;

    @Override
    public List<HistoricActivity> selectHistoryList(String processInstanceId, HistoricActivity historicActivity) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        List<HistoricActivityInstance> historicActivityList;
        Page<HistoricActivity> activityList = new Page<>();
        HistoricActivityInstanceQuery query = historyService.createHistoricActivityInstanceQuery();
        if (StringUtils.isNotBlank(historicActivity.getAssignee())) {
            query.taskAssignee(historicActivity.getAssignee());
        }
        if (StringUtils.isNotBlank(historicActivity.getActivityName())) {
            query.activityName(historicActivity.getActivityName());
        }
        if (pageNum != null && pageSize != null) {
            historicActivityList = query.processInstanceId(processInstanceId)
                    .activityType("userTask")
                    .finished()
                    .orderByHistoricActivityInstanceStartTime()
                    .desc()
                    .listPage((pageNum - 1) * pageSize, pageSize);
            activityList.setTotal(query.count());
            activityList.setPageNum(pageNum);
            activityList.setPageSize(pageSize);
        } else {
            historicActivityList = query.list();
        }
        historicActivityList.forEach(instance -> {
            HistoricActivity activity = new HistoricActivity();
            BeanUtils.copyProperties(instance, activity);
            String taskId = instance.getTaskId();
            List<Comment> comment = taskService.getTaskComments(taskId, "comment");
            if (!CollectionUtils.isEmpty(comment)) {
                activity.setComment(comment.get(0).getFullMessage());
            }
            User sysUser = userMapper.selectUserById(StringUtils.isEmpty(instance.getAssignee())?null:Long.valueOf(instance.getAssignee()));
            if (sysUser != null) {
                activity.setAssigneeName(sysUser.getUserName());
            }
            activityList.add(activity);
        });
        return activityList;
    }

}
