package com.netintech.park.domain;

import java.math.BigDecimal;

/**
 * @author summer
 * @date 2020/5/9 14:13
 */
public class OverviewBean {
    private Integer townCount; //镇，街道
    private Integer villCount; //行政村
    private BigDecimal bulidArea; //已建筑建筑面积
    private BigDecimal planBuildingSpace; //规范建筑面积
    private BigDecimal coverdArea;//占地面积
    private Integer enterPark; // 入园企业
    private BigDecimal enterPerson; //入园人员
    private BigDecimal income; //园区收入
    private BigDecimal taxRevenue; //园区税收
    private BigDecimal output; //园区产值
    private Integer sumCount; //总数
    private Integer proposed; //拟建
    private Integer start;  //开工
    private Integer operate;   //运营
    private Integer listing;  //挂牌中

    private String buildUnitName; //建设方
    private String buildContactName;
    private String buildContactTel;
    private String buildContactMail;

    private String operationUnitName; //运营方
    private String operationContactName;
    private String operationContactTel;
    private String operationContactMail;

    private String parkName;  // 小微园名称
    private String address;  //地址
    private String parkDesc; //园区概况

    private Integer levelOne;
    private Integer levelTwo;
    private Integer levelThree;
    private Integer levelFour;
    private Integer levelFive;

    private BigDecimal planInvestmentTotal; //计划投资总额
    private BigDecimal actualInvestmentTotal; //实际投资总额

    private BigDecimal estimatedSalesRevenue; // 预计销售总额
    private BigDecimal estimatedProfitTax;  // 预计形成总利税


    private BigDecimal acreIncome;
    private BigDecimal acreTax;
    private BigDecimal acreOutput;

    private BigDecimal landSpace; //备用字段

    private Integer enterParkRemark; ///备用字段

    private BigDecimal area;

    private String liveView;

    //趋势
    private Integer count;
    private Integer year;

    //
    private Integer parkId;

    public Integer getTownCount() {
        return townCount;
    }

    public void setTownCount(Integer townCount) {
        this.townCount = townCount;
    }

    public Integer getVillCount() {
        return villCount;
    }

    public void setVillCount(Integer villCount) {
        this.villCount = villCount;
    }

    public BigDecimal getBulidArea() {
        return bulidArea;
    }

    public void setBulidArea(BigDecimal bulidArea) {
        this.bulidArea = bulidArea;
    }

    public BigDecimal getCoverdArea() {
        return coverdArea;
    }

    public void setCoverdArea(BigDecimal coverdArea) {
        this.coverdArea = coverdArea;
    }

    public Integer getEnterPark() {
        return enterPark;
    }

    public void setEnterPark(Integer enterPark) {
        this.enterPark = enterPark;
    }

    public BigDecimal getEnterPerson() {
        return enterPerson;
    }

    public void setEnterPerson(BigDecimal enterPerson) {
        this.enterPerson = enterPerson;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getTaxRevenue() {
        return taxRevenue;
    }

    public void setTaxRevenue(BigDecimal taxRevenue) {
        this.taxRevenue = taxRevenue;
    }

    public Integer getSumCount() {
        return sumCount;
    }

    public void setSumCount(Integer sumCount) {
        this.sumCount = sumCount;
    }

    public Integer getProposed() {
        return proposed;
    }

    public void setProposed(Integer proposed) {
        this.proposed = proposed;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getOperate() {
        return operate;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }

    public Integer getListing() {
        return listing;
    }

    public void setListing(Integer listing) {
        this.listing = listing;
    }

    public BigDecimal getAcreIncome() {
        return acreIncome;
    }

    public void setAcreIncome(BigDecimal acreIncome) {
        this.acreIncome = acreIncome;
    }

    public BigDecimal getAcreTax() {
        return acreTax;
    }

    public void setAcreTax(BigDecimal acreTax) {
        this.acreTax = acreTax;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }


    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public String getBuildContactName() {
        return buildContactName;
    }

    public void setBuildContactName(String buildContactName) {
        this.buildContactName = buildContactName;
    }

    public String getBuildContactTel() {
        return buildContactTel;
    }

    public void setBuildContactTel(String buildContactTel) {
        this.buildContactTel = buildContactTel;
    }

    public String getBuildContactMail() {
        return buildContactMail;
    }

    public void setBuildContactMail(String buildContactMail) {
        this.buildContactMail = buildContactMail;
    }

    public String getOperationUnitName() {
        return operationUnitName;
    }

    public void setOperationUnitName(String operationUnitName) {
        this.operationUnitName = operationUnitName;
    }

    public String getOperationContactName() {
        return operationContactName;
    }

    public void setOperationContactName(String operationContactName) {
        this.operationContactName = operationContactName;
    }

    public String getOperationContactTel() {
        return operationContactTel;
    }

    public void setOperationContactTel(String operationContactTel) {
        this.operationContactTel = operationContactTel;
    }

    public String getOperationContactMail() {
        return operationContactMail;
    }

    public void setOperationContactMail(String operationContactMail) {
        this.operationContactMail = operationContactMail;
    }

    public BigDecimal getLandSpace() {
        return landSpace;
    }

    public void setLandSpace(BigDecimal landSpace) {
        this.landSpace = landSpace;
    }

    public Integer getEnterParkRemark() {
        return enterParkRemark;
    }

    public void setEnterParkRemark(Integer enterParkRemark) {
        this.enterParkRemark = enterParkRemark;
    }

    public String getParkDesc() {
        return parkDesc;
    }

    public void setParkDesc(String parkDesc) {
        this.parkDesc = parkDesc;
    }

    public BigDecimal getPlanBuildingSpace() {
        return planBuildingSpace;
    }

    public void setPlanBuildingSpace(BigDecimal planBuildingSpace) {
        this.planBuildingSpace = planBuildingSpace;
    }


    public Integer getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(Integer levelOne) {
        this.levelOne = levelOne;
    }

    public Integer getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(Integer levelTwo) {
        this.levelTwo = levelTwo;
    }

    public Integer getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(Integer levelThree) {
        this.levelThree = levelThree;
    }

    public Integer getLevelFour() {
        return levelFour;
    }

    public void setLevelFour(Integer levelFour) {
        this.levelFour = levelFour;
    }

    public Integer getLevelFive() {
        return levelFive;
    }

    public void setLevelFive(Integer levelFive) {
        this.levelFive = levelFive;
    }

    public BigDecimal getPlanInvestmentTotal() {
        return planInvestmentTotal;
    }

    public void setPlanInvestmentTotal(BigDecimal planInvestmentTotal) {
        this.planInvestmentTotal = planInvestmentTotal;
    }

    public BigDecimal getActualInvestmentTotal() {
        return actualInvestmentTotal;
    }

    public void setActualInvestmentTotal(BigDecimal actualInvestmentTotal) {
        this.actualInvestmentTotal = actualInvestmentTotal;
    }

    public BigDecimal getEstimatedSalesRevenue() {
        return estimatedSalesRevenue;
    }

    public void setEstimatedSalesRevenue(BigDecimal estimatedSalesRevenue) {
        this.estimatedSalesRevenue = estimatedSalesRevenue;
    }

    public BigDecimal getEstimatedProfitTax() {
        return estimatedProfitTax;
    }

    public void setEstimatedProfitTax(BigDecimal estimatedProfitTax) {
        this.estimatedProfitTax = estimatedProfitTax;
    }

    public String getLiveView() {
        return liveView;
    }

    public void setLiveView(String liveView) {
        this.liveView = liveView;
    }

    public BigDecimal getOutput() {
        return output;
    }

    public void setOutput(BigDecimal output) {
        this.output = output;
    }

    public BigDecimal getAcreOutput() {
        return acreOutput;
    }

    public void setAcreOutput(BigDecimal acreOutput) {
        this.acreOutput = acreOutput;
    }
}
