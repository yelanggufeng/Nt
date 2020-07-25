package com.netintech.park.service;

import com.netintech.park.domain.OverviewBean;
import com.netintech.park.domain.StatisticsBean;

import java.util.List;
import java.util.Map;

/**
 * @author summer
 * @date 2020/5/9 14:03
 */
public interface IOverviewService {

    OverviewBean leftSummary(OverviewBean bean);

    OverviewBean leftSummaryByPark(OverviewBean bean);

    List<OverviewBean> leftTrend();

    List<Map> parkLevel();

    List<StatisticsBean> incomeRank(Long parkId);

    List<StatisticsBean> taxRank(Long parkId);

    Map priseTrain();

    List<Map> parkIncome();

    List<Map> obtainEmployment();

    Map taxAverage(Integer type);

    Map getPart();

    List<Map> getParkRank();

    List<Map> getLatLongi();

    Map getParkInfo();

    List<Map> getParkInfoByParkId(Long parkId);

    List<Map> selectIndustry();

    List<Map> investment();

    List<Map> developmentMode();

    List<Map> newWay();

    List<Map> buildProgess();

    List<Map> incomeTax(Integer type);

    List<Map> enterpriseType();

}
