package com.netintech.process.general.service;


import com.netintech.core.web.page.PageDomain;
import com.netintech.process.general.domain.HistoricActivity;

import java.util.List;

public interface IProcessService {

    /**
     * 查询审批历史列表
     * @param processInstanceId
     * @param historicActivity
     * @return
     */
    List<HistoricActivity> selectHistoryList(String processInstanceId, HistoricActivity historicActivity);

}
