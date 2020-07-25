package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 数字小微园信息对象 sys_small_park
 *
 * @author admin
 * @date 2020-04-17
 */
public class SmallPark extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数字小微园ID */
    private Long id;

    /** 数字小微园名称 */
    @Excel(name = "数字小微园名称")
    private String parkName;

    /** 数字小微园建设状态 */
    private Long constructionState;

    /** 所属区域ID */
    private Long areaId;

    /** 数字小微园地址 */
    @Excel(name = "数字小微园地址")
    private String detailedAddress;

    /** 开工时间 */
    @Excel(name = "开工时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 竣工时间 */
    @Excel(name = "竣工时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionTime;

    /** 投运时间 */
    @Excel(name = "投运时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commissioningTime;

    /** 主导产业id */
    private Long leadingIndustryId;

    /** 入驻企业数量 */
    @Excel(name = "入驻企业数量")
    private Long enterpriseQuantity;

    /** 规划建筑面积 */
    @Excel(name = "规划建筑面积")
    private Double planBuildingSpace;

    /** 占地面积 */
    @Excel(name = "占地面积")
    private Double landSpace;

    /** 已建建筑面积 */
    @Excel(name = "已建建筑面积")
    private Double usedBuildingSpace;

    /** 宿舍面积 */
    @Excel(name = "宿舍面积")
    private Double dormitorySpace;

    /** 进度情况 */
    @Excel(name = "进度情况")
    private String progress;

    /** 建设（改造）模式 */
    @Excel(name = "建设", readConverterExp = "改造")
    private String buildMode;

    /** 租金情况 */
    @Excel(name = "租金情况")
    private Double rentSituation;

    /** 计划投资总额 */
    @Excel(name = "计划投资总额")
    private Long planInvestmentTotal;

    /** 国有投资 */
    @Excel(name = "国有投资")
    private Long stateOwnedInvestment;

    /** 集体投资 */
    @Excel(name = "集体投资")
    private Long collectiveInvestment;

    /** 民营投资 */
    @Excel(name = "民营投资")
    private Long privateInvestment;

    /** 其他投资 */
    @Excel(name = "其他投资")
    private Long otherInvestment;

    /** 实际投资总额 */
    @Excel(name = "实际投资总额")
    private Long actualInvestmentTotal;

    /** 建设单位名称 */
    @Excel(name = "建设单位名称")
    private String buildUnitName;

    /** 联系人 */
    @Excel(name = "建设单位联系人")
    private String buildContactName;

    /** 联系方式 */
    @Excel(name = "建设单位联系方式")
    private String buildContactTel;

    /** 联系邮箱 */
    @Excel(name = "建设单位联系邮箱")
    private String buildContactMail;

    /** 运营单位名称 */
    @Excel(name = "运营单位名称")
    private String operationUnitName;

    /** 联系人 */
    @Excel(name = "运营单位联系人")
    private String operationContactName;

    /** 联系方式 */
    @Excel(name = "运营单位联系方式")
    private String operationContactTel;

    /** 联系邮箱 */
    @Excel(name = "运营单位联系邮箱")
    private String operationContactMail;

    private String estimatedSalesRevenue;

    private String estimatedProfitTax;

    private String developmentConstructionMode;

    private String newWay;

    private String liveView;

    private List<SmallParkAttach>attaches;

    public String getLiveView() {
        return liveView;
    }

    public void setLiveView(String liveView) {
        this.liveView = liveView;
    }

    public List<SmallParkAttach> getAttaches() {
        return attaches;
    }

    public void setAttaches(List<SmallParkAttach> attaches) {
        this.attaches = attaches;
    }

    public String getEstimatedSalesRevenue() {
        return estimatedSalesRevenue;
    }

    public void setEstimatedSalesRevenue(String estimatedSalesRevenue) {
        this.estimatedSalesRevenue = estimatedSalesRevenue;
    }

    public String getEstimatedProfitTax() {
        return estimatedProfitTax;
    }

    public void setEstimatedProfitTax(String estimatedProfitTax) {
        this.estimatedProfitTax = estimatedProfitTax;
    }

    public String getDevelopmentConstructionMode() {
        return developmentConstructionMode;
    }

    public void setDevelopmentConstructionMode(String developmentConstructionMode) {
        this.developmentConstructionMode = developmentConstructionMode;
    }

    public String getNewWay() {
        return newWay;
    }

    public void setNewWay(String newWay) {
        this.newWay = newWay;
    }

    private String lon;

    private String lat;

    private String parkLevel;

    private String parkDesc;

    private String fileUuid;

    private String filePath;

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid;
    }

    public String getParkDesc() {
        return parkDesc;
    }

    public void setParkDesc(String parkDesc) {
        this.parkDesc = parkDesc;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getParkLevel() {
        return parkLevel;
    }

    public void setParkLevel(String parkLevel) {
        this.parkLevel = parkLevel;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setParkName(String parkName)
    {
        this.parkName = parkName;
    }

    public String getParkName()
    {
        return parkName;
    }
    public void setConstructionState(Long constructionState)
    {
        this.constructionState = constructionState;
    }

    public Long getConstructionState()
    {
        return constructionState;
    }
    public void setAreaId(Long areaId)
    {
        this.areaId = areaId;
    }

    public Long getAreaId()
    {
        return areaId;
    }
    public void setDetailedAddress(String detailedAddress)
    {
        this.detailedAddress = detailedAddress;
    }

    public String getDetailedAddress()
    {
        return detailedAddress;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setCompletionTime(Date completionTime)
    {
        this.completionTime = completionTime;
    }

    public Date getCompletionTime()
    {
        return completionTime;
    }
    public void setCommissioningTime(Date commissioningTime)
    {
        this.commissioningTime = commissioningTime;
    }

    public Date getCommissioningTime()
    {
        return commissioningTime;
    }
    public void setLeadingIndustryId(Long leadingIndustryId)
    {
        this.leadingIndustryId = leadingIndustryId;
    }

    public Long getLeadingIndustryId()
    {
        return leadingIndustryId;
    }
    public void setEnterpriseQuantity(Long enterpriseQuantity)
    {
        this.enterpriseQuantity = enterpriseQuantity;
    }

    public Long getEnterpriseQuantity()
    {
        return enterpriseQuantity;
    }
    public void setPlanBuildingSpace(Double planBuildingSpace)
    {
        this.planBuildingSpace = planBuildingSpace;
    }

    public Double getPlanBuildingSpace()
    {
        return planBuildingSpace;
    }
    public void setLandSpace(Double landSpace)
    {
        this.landSpace = landSpace;
    }

    public Double getLandSpace()
    {
        return landSpace;
    }
    public void setUsedBuildingSpace(Double usedBuildingSpace)
    {
        this.usedBuildingSpace = usedBuildingSpace;
    }

    public Double getUsedBuildingSpace()
    {
        return usedBuildingSpace;
    }
    public void setDormitorySpace(Double dormitorySpace)
    {
        this.dormitorySpace = dormitorySpace;
    }

    public Double getDormitorySpace()
    {
        return dormitorySpace;
    }
    public void setProgress(String progress)
    {
        this.progress = progress;
    }

    public String getProgress()
    {
        return progress;
    }
    public void setBuildMode(String buildMode)
    {
        this.buildMode = buildMode;
    }

    public String getBuildMode()
    {
        return buildMode;
    }

    public Double getRentSituation() {
        return rentSituation;
    }

    public void setRentSituation(Double rentSituation) {
        this.rentSituation = rentSituation;
    }

    public void setPlanInvestmentTotal(Long planInvestmentTotal)
    {
        this.planInvestmentTotal = planInvestmentTotal;
    }

    public Long getPlanInvestmentTotal()
    {
        return planInvestmentTotal;
    }
    public void setStateOwnedInvestment(Long stateOwnedInvestment)
    {
        this.stateOwnedInvestment = stateOwnedInvestment;
    }

    public Long getStateOwnedInvestment()
    {
        return stateOwnedInvestment;
    }
    public void setCollectiveInvestment(Long collectiveInvestment)
    {
        this.collectiveInvestment = collectiveInvestment;
    }

    public Long getCollectiveInvestment()
    {
        return collectiveInvestment;
    }
    public void setPrivateInvestment(Long privateInvestment)
    {
        this.privateInvestment = privateInvestment;
    }

    public Long getPrivateInvestment()
    {
        return privateInvestment;
    }
    public void setOtherInvestment(Long otherInvestment)
    {
        this.otherInvestment = otherInvestment;
    }

    public Long getOtherInvestment()
    {
        return otherInvestment;
    }
    public void setActualInvestmentTotal(Long actualInvestmentTotal)
    {
        this.actualInvestmentTotal = actualInvestmentTotal;
    }

    public Long getActualInvestmentTotal()
    {
        return actualInvestmentTotal;
    }
    public void setBuildUnitName(String buildUnitName)
    {
        this.buildUnitName = buildUnitName;
    }

    public String getBuildUnitName()
    {
        return buildUnitName;
    }
    public void setBuildContactName(String buildContactName)
    {
        this.buildContactName = buildContactName;
    }

    public String getBuildContactName()
    {
        return buildContactName;
    }
    public void setBuildContactTel(String buildContactTel)
    {
        this.buildContactTel = buildContactTel;
    }

    public String getBuildContactTel()
    {
        return buildContactTel;
    }
    public void setBuildContactMail(String buildContactMail)
    {
        this.buildContactMail = buildContactMail;
    }

    public String getBuildContactMail()
    {
        return buildContactMail;
    }
    public void setOperationUnitName(String operationUnitName)
    {
        this.operationUnitName = operationUnitName;
    }

    public String getOperationUnitName()
    {
        return operationUnitName;
    }
    public void setOperationContactName(String operationContactName)
    {
        this.operationContactName = operationContactName;
    }

    public String getOperationContactName()
    {
        return operationContactName;
    }
    public void setOperationContactTel(String operationContactTel)
    {
        this.operationContactTel = operationContactTel;
    }

    public String getOperationContactTel()
    {
        return operationContactTel;
    }
    public void setOperationContactMail(String operationContactMail)
    {
        this.operationContactMail = operationContactMail;
    }

    public String getOperationContactMail()
    {
        return operationContactMail;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parkName", getParkName())
            .append("constructionState", getConstructionState())
            .append("areaId", getAreaId())
            .append("detailedAddress", getDetailedAddress())
            .append("startTime", getStartTime())
            .append("completionTime", getCompletionTime())
            .append("commissioningTime", getCommissioningTime())
            .append("leadingIndustryId", getLeadingIndustryId())
            .append("enterpriseQuantity", getEnterpriseQuantity())
            .append("planBuildingSpace", getPlanBuildingSpace())
            .append("landSpace", getLandSpace())
            .append("usedBuildingSpace", getUsedBuildingSpace())
            .append("dormitorySpace", getDormitorySpace())
            .append("progress", getProgress())
            .append("buildMode", getBuildMode())
            .append("rentSituation", getRentSituation())
            .append("planInvestmentTotal", getPlanInvestmentTotal())
            .append("stateOwnedInvestment", getStateOwnedInvestment())
            .append("collectiveInvestment", getCollectiveInvestment())
            .append("privateInvestment", getPrivateInvestment())
            .append("otherInvestment", getOtherInvestment())
            .append("actualInvestmentTotal", getActualInvestmentTotal())
            .append("buildUnitName", getBuildUnitName())
            .append("buildContactName", getBuildContactName())
            .append("buildContactTel", getBuildContactTel())
            .append("buildContactMail", getBuildContactMail())
            .append("operationUnitName", getOperationUnitName())
            .append("operationContactName", getOperationContactName())
            .append("operationContactTel", getOperationContactTel())
            .append("operationContactMail", getOperationContactMail())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
