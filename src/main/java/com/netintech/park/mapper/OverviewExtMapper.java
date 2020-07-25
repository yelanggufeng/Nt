package com.netintech.park.mapper;

import com.netintech.park.domain.OverviewBean;
import com.netintech.park.domain.StatisticsBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author summer
 * @date 2020/5/9 14:07
 */
public interface OverviewExtMapper {

    @Select("select IFNULL( sum( used_building_space ), 0 ) bulidArea," +
            "IFNULL( sum( land_space ), 0 ) coverdArea, " +
            "IFNULL( sum( plan_building_space ), 0 ) planBuildingSpace, " +
            "IFNULL( sum( enterprise_quantity ), 0 ) enterPark, " +
            "IFNULL( sum( construction_state = 1 ), 0 ) proposed, " +
            "IFNULL( sum( construction_state = 2 ), 0 ) start, " +
            "IFNULL( sum( construction_state = 3 ), 0 ) operate, " +
            "IFNULL( sum( construction_state = 4 ), 0 ) listing, " +
            "IFNULL( sum( park_level = 1 ), 0 ) levelOne, " +
            "IFNULL( sum( park_level = 2 ), 0 ) levelTwo, " +
            "IFNULL( sum( park_level = 3 ), 0 ) levelThree, " +
            "IFNULL( sum( park_level = 4 ), 0 ) levelFour, " +
            "IFNULL( sum( park_level = 5 ), 0 ) levelFive, " +
            "IFNULL( sum( plan_investment_total), 0 ) planInvestmentTotal, " +
            "IFNULL( sum( actual_investment_total), 0 ) actualInvestmentTotal, " +
            "IFNULL( sum( estimated_sales_revenue), 0 ) estimatedSalesRevenue, " +
            "IFNULL( sum( estimated_profit_tax), 0 ) estimatedProfitTax, " +
            "IFNULL( count(*),0) sumCount from sys_small_park where del_flag = '0' ")
    OverviewBean selectParkInfo();


    @Select("select IFNULL( sum( enterprise_quantity ), 0 ) enterPark from sys_small_park where id=#{parkId}")
    Integer getEnterPark(@Param("parkId") Integer parkId);



    OverviewBean selectPriseInfo(OverviewBean bean);

    @Select("select count(1) as count, YEAR(into_time) year from sys_enterprise where del_flag = '0' group by YEAR(into_time)")
    List<OverviewBean> selectTread();

    //园区收入和园区税收
    List<Map> incomeAndTax(OverviewBean bean);

    @Select("select id,park_name name, IFNULL(park_level,0) level from sys_small_park where del_flag = '0' group by id order by park_level desc ")
    List<Map> getParkLevel();


    @Select("SELECT b.enterprise_name name, IFNULL( sum(a.income), 0 ) amount FROM " +
            "sys_enterprise_benefit a LEFT JOIN sys_enterprise b ON a.enterprise_id = b.id WHERE a.del_flag = '0' " +
            "AND b.del_flag = '0' and b.small_id = #{parkId} and a.year=YEAR(now()) GROUP BY b.id order by amount desc limit 5")
    List<StatisticsBean> incomeRank(@Param("parkId") Long parkId);

    @Select("SELECT b.enterprise_name name, IFNULL( sum( a.tax), 0 ) amount FROM " +
            "sys_enterprise_benefit a LEFT JOIN sys_enterprise b ON a.enterprise_id = b.id WHERE a.del_flag = '0' " +
            "AND b.del_flag = '0' and b.small_id = #{parkId} and a.year=YEAR(now()) GROUP BY b.id order by amount desc limit 5")
    List<StatisticsBean> taxRank(@Param("parkId") Long parkId);



    List<Map> priseTrain(@Param("deptId") Long deptId);

    @Select("select IFNULL(round(sum(income),2), 0 )income, year from sys_enterprise_benefit where del_flag = '0' group by year order by year desc limit 10 ")
    List<Map> parkIncome();


    List<Map> obtainEmployment(@Param("deptId") Long deptId);

    List<Map> taxAverage(@Param("type") Integer type, @Param("quarter") Integer quarter, @Param("year") String year);

//    @Select("")
//    List<Map> getPart();

    @Select("SELECT x.id, x.park_name NAME, IFNULL( round( c.income / 10000, 2 ), 0 ) income \n" +
            "FROM sys_small_park x LEFT JOIN (SELECT DISTINCT a.small_id,sum(b.income) income\n" +
            "FROM sys_enterprise a right JOIN ( SELECT enterprise_id, sum( income ) income FROM sys_enterprise_benefit WHERE del_flag = '0' \n" +
            "and year = YEAR(now()) GROUP BY enterprise_id ) b ON a.id = b.enterprise_id \n" +
            "WHERE a.del_flag = '0' group by a.small_id) c ON x.id = c.small_id \n" +
            "WHERE x.del_flag = '0' ORDER BY income desc limit 10")
    List<Map> getParkRank();


    List<Map> getSumCount(@Param("deptId") Long deptId);

    @Select("SELECT id,park_name NAME,lon,lat,\n" +
            "CASE construction_state WHEN 1 THEN '#FFB90F' WHEN 2 THEN '#3CB371' WHEN 3 THEN '#ff522a' ELSE '#BA55D3' END color \n" +
            "FROM sys_small_park WHERE del_flag = '0' and lon is not null and lat is not null")
    List<Map> getLatLongi();

    List<Map> getParkInfo(@Param("deptId") Long deptId);

//    @Select("select id areaId, area_name areaName from sys_area where parent_id !='0' order by id asc ")
//    List<SysArea> selectArea();

    @Select("select IFNULL(count(a.leading_industry_id),0) value, b.dict_label name from sys_small_park a " +
            "left join sys_dict_data b on a.leading_industry_id = b.dict_value and b.dict_type='leading_industry' " +
            "where a.del_flag = '0'  GROUP BY b.dict_label")
    List<Map> selectIndustry();

    @Select("select d.dict_label name, (select count(*) from sys_small_park a where a.development_construction_mode = d.dict_value and a.del_flag = '0') value " +
            "from sys_dict_data d  WHERE d.dict_type = 'development_mode'")
    List<Map> developmentMode();

    @Select("select d.dict_label name, (select count(*) from sys_small_park a where a.new_way = d.dict_value and a.del_flag = '0') value " +
            "from sys_dict_data d  WHERE d.dict_type = 'sys_new_way'")
    List<Map> newWay();


    @Select("select park_name name, IFNULL(progress,0) progess from sys_small_park where del_flag = '0' and progress != '100' order by progress desc")
    List<Map> buildProgess();

    @Select("select IFNULL(round(sum(a.investment/100 ),2), 0 ) invest,a.year year from sys_small_park_invest a left join sys_small_park b " +
            "on a.small_id = b.id where b.del_flag = '0' group by a.year")
    List<Map> investment();

    List<Map> incomeTax(@Param("type") Integer type, @Param("deptId") Long deptId);

    List<Map> enterpriseType(@Param("deptId") Long deptId);
}
