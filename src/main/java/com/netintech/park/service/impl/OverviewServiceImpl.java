package com.netintech.park.service.impl;

import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.park.domain.OverviewBean;
import com.netintech.park.domain.StatisticsBean;
import com.netintech.park.mapper.OverviewExtMapper;
import com.netintech.park.service.IOverviewService;
import com.netintech.park.service.ISmallParkService;
import com.netintech.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author summer
 * @date 2020/5/9 14:06
 */
@Service
public class OverviewServiceImpl implements IOverviewService {

    @Autowired
    private OverviewExtMapper overviewExtMapper;

    @Autowired
    private ISmallParkService smallParkService;

    /**
     * 小微园总览统计 -综合汇总
     *
     * @return
     */
    @Override
    public OverviewBean leftSummary(OverviewBean bean) {
        //园区
        OverviewBean info = overviewExtMapper.selectParkInfo();
        //企业
        OverviewBean priseInfo = overviewExtMapper.selectPriseInfo(bean);
        info.setEnterPark(priseInfo.getEnterPark());
        info.setEnterPerson(priseInfo.getEnterPerson());
        Map incomeAndTax = overviewExtMapper.incomeAndTax(bean).get(0);
        info.setIncome(((BigDecimal) incomeAndTax.get("income")).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
        info.setTaxRevenue(((BigDecimal) incomeAndTax.get("taxRevenue")).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
        return info;
    }

    /**
     * 园区总览二维
     *
     * @return
     */
    @Override
    public OverviewBean leftSummaryByPark(OverviewBean bean) {
        //企业
        OverviewBean priseInfo = overviewExtMapper.selectPriseInfo(bean);
        priseInfo.setEnterPark(priseInfo.getEnterPark());
        priseInfo.setEnterPerson(priseInfo.getEnterPerson());
        Map incomeAndTax = overviewExtMapper.incomeAndTax(bean).get(0);

        BigDecimal income = (BigDecimal) incomeAndTax.get("income");
        BigDecimal tax = (BigDecimal) incomeAndTax.get("taxRevenue");
        BigDecimal outPut =  (BigDecimal) incomeAndTax.get("output");

        priseInfo.setIncome(income.divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
        priseInfo.setTaxRevenue(tax.divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
        priseInfo.setOutput(outPut.divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
        priseInfo.setAcreIncome((priseInfo.getArea().intValue() == 0) ? BigDecimal.ZERO : income.divide(priseInfo.getArea(),0,BigDecimal.ROUND_HALF_UP));
        priseInfo.setAcreTax((priseInfo.getArea().intValue() == 0) ? BigDecimal.ZERO : tax.divide(priseInfo.getArea(),0,BigDecimal.ROUND_HALF_UP));
        priseInfo.setAcreOutput((priseInfo.getArea().intValue() == 0) ? BigDecimal.ZERO : outPut.divide(priseInfo.getArea(),0,BigDecimal.ROUND_HALF_UP));
        return priseInfo;
    }

    /**
     * 入园收入趋势
     *
     * @return
     */
    @Override
    public List<OverviewBean> leftTrend() {
        List<OverviewBean> list = overviewExtMapper.selectTread();
        return list;
    }

    /**
     * 园区等级
     *
     * @return
     */

    @Override
    public List<Map> parkLevel() {
        List<Map> list = overviewExtMapper.getParkLevel();
        return list;
    }

    /**
     * 企业收入排行
     *
     * @param parkId
     * @return
     */

    @Override
    public List<StatisticsBean> incomeRank(Long parkId) {
        List<StatisticsBean> list = overviewExtMapper.incomeRank(parkId);
        return list;
    }

    /**
     * 企业税收排行
     *
     * @param parkId
     * @return
     */

    @Override
    public List<StatisticsBean> taxRank(Long parkId) {
        List<StatisticsBean> list = overviewExtMapper.taxRank(parkId);
        return list;
    }

    /**
     * 企业培育情况
     *
     * @return
     */
    @Override
    public Map priseTrain() {
        User user = ShiroUtils.getSysUser();
        Long dept = null;
        if (user != null){
            if ("2".equals(user.getUserLevel())) {
                dept = smallParkService.getParkId(user.getDeptId());
            }
        }
        Map map = overviewExtMapper.priseTrain(dept).get(0);
        return map;
    }

    /**
     * 园区收入
     */
    @Override
    public List<Map> parkIncome() {
        return overviewExtMapper.parkIncome();
    }


    /**
     * 园区就业贡献率
     */
    @Override
    public List<Map> obtainEmployment() {

        User user = ShiroUtils.getSysUser();
        Long dept = null;
        if (user != null){
            if ("2".equals(user.getUserLevel())) {
                dept = smallParkService.getParkId(user.getDeptId());
            }
        }
        List<Map> mapList = overviewExtMapper.obtainEmployment(dept);
        BigDecimal sum = (BigDecimal) overviewExtMapper.getSumCount(null).get(0).get("employeeCount"); //园区总人数
        for (Map map : mapList) {
            if (!sum.equals(BigDecimal.ZERO)) {
                BigDecimal result = new BigDecimal(map.get("count").toString()).divide(sum,2,BigDecimal.ROUND_HALF_UP);
                map.put("obtainRate", result.multiply(BigDecimal.valueOf(100)));
            } else {
                map.put("obtainRate", BigDecimal.ZERO);
            }
        }
        return mapList;
    }

    /**
     * 园区亩均税收和产值
     */
    @Override
    public Map taxAverage(Integer type) {
        Calendar cal = Calendar.getInstance();
        String year = String.valueOf(cal.get(Calendar.YEAR));
        int m = cal.get(Calendar.MONTH) + 1;
        Integer quarter = 0;
        if (m >= 1 && m <= 3) {
            quarter = 1;
        }
        if (m >= 4 && m <= 6) {
            quarter = 2;
        }
        if (m >= 7 && m <= 9) {
            quarter = 3;
        }
        if (m >= 10 && m <= 12) {
            quarter = 4;
        }
        Map map= overviewExtMapper.taxAverage(type,quarter, year).get(0);
        BigDecimal sum = overviewExtMapper.selectParkInfo().getCoverdArea(); //园区总站地亩数

        map.put("taxRate", sum.compareTo(BigDecimal.ZERO) == 0 ? 0 : new BigDecimal(map.get("tax").toString()).divide(sum,2,BigDecimal.ROUND_HALF_UP));
        map.put("outputRate", sum.compareTo(BigDecimal.ZERO)== 0 ?  0 : new BigDecimal(map.get("output").toString()).divide(sum,2,BigDecimal.ROUND_HALF_UP));
        return map;
    }

    @Override
    public Map getPart() {
        User user = ShiroUtils.getSysUser();
        Long dept = null;
        if (user != null){
            if ("2".equals(user.getUserLevel())) {
                dept = smallParkService.getParkId(user.getDeptId());
            }
        }
        Map map = new HashMap();
        Map newMap = overviewExtMapper.getSumCount(dept).get(0);
//        map.put("patentCount", newMap.get("patentCount"));
        map.put("ownership", newMap.get("ownership"));
        map.put("foreignCount", newMap.get("foreignCount"));
        // 人才密度 所有企业人才数量求和 除 员工数量
        BigDecimal talentCount = new BigDecimal(newMap.get("talentsCount").toString());
        BigDecimal employeeCount = new BigDecimal(newMap.get("employeeCount").toString());
        map.put("rcmd", employeeCount.compareTo(BigDecimal.ZERO) == 0 ? 0 : (talentCount.divide(employeeCount, 2, BigDecimal.ROUND_HALF_UP)).multiply(BigDecimal.valueOf(100)));
        BigDecimal count = new BigDecimal(newMap.get("count").toString());
        map.put("patentAverage", count.compareTo(BigDecimal.ZERO) == 0 ? 0 : new BigDecimal(newMap.get("patentCount").toString()).divide(count,2,BigDecimal.ROUND_HALF_UP));
        return map;
    }


    /**
     * 园区排行
     * @return
     */
    @Override
    public List<Map> getParkRank() {
        return overviewExtMapper.getParkRank();
    }

    /**
     * 经纬度
     * @return
     */
    @Override
    public List<Map> getLatLongi() {
        return overviewExtMapper.getLatLongi();
    }
    @Override
    public Map getParkInfo() {
        User user = ShiroUtils.getSysUser();
        Long dept = user.getDeptId();
        if ("2".equals(user.getUserLevel())) {
            dept =   smallParkService.getParkId(user.getDeptId());
        }
        return overviewExtMapper.getParkInfo(dept).get(0);
    }

    @Override
    public List<Map> getParkInfoByParkId(Long parkId) {
        //判断parkId是否是政府端，如果是查询所有
        List<Map> map = new ArrayList<>();
        User user = ShiroUtils.getSysUser();
        if ("2".equals(user.getUserLevel()) ) {
            map = overviewExtMapper.getParkInfo(parkId);
        }
        if ("1".equals(user.getUserLevel()) || user.isAdmin()) {
            if (parkId != null && parkId != 0) {
                map = overviewExtMapper.getParkInfo(parkId);
            }  else {
                map = overviewExtMapper.getParkInfo(null);
            }
        }
        return map;
    }

    /**
     * 主导产业
     * @return
     */
    @Override
    public List<Map> selectIndustry() {
        List<Map> mapList = overviewExtMapper.selectIndustry();
       return mapList;
    }


    /**
     * 理念投资
     * @return
     */
    @Override
    public List<Map> investment() {
        List<Map> mapList = overviewExtMapper.investment();
        return mapList;
    }

    /**
     * 开发建设模式
     * @return
     */
    @Override
    public List<Map> developmentMode() {
        List<Map> mapList = overviewExtMapper.developmentMode();
        return mapList;
    }

    /**
     * 新增方式
     * @return
     */
    @Override
    public List<Map> newWay() {
        List<Map> mapList = overviewExtMapper.newWay();
        return mapList;
    }

    /**
     * 园区建设进去
     * @return
     */
    @Override
    public List<Map> buildProgess() {
        List<Map> mapList = overviewExtMapper.buildProgess();
        return mapList;
    }


    /**
     * 园区收入、税收趋势
     * @return
     */
    @Override
    public List<Map> incomeTax(Integer type) {
        List<Map> map = new ArrayList<>();
        User user = ShiroUtils.getSysUser();
        map = overviewExtMapper.incomeTax(type,smallParkService.getParkId(user.getDeptId()));
        return map;
    }

    /**
     * 企业类型
     * @return
     */
    @Override
    public List<Map> enterpriseType() {
        List<Map> map = new ArrayList<>();
        User user = ShiroUtils.getSysUser();
        map = overviewExtMapper.enterpriseType(smallParkService.getParkId(user.getDeptId()));
        return map;
    }



}
