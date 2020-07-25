package com.netintech.enterprise.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 企业信息对象 sys_enterprise
 * 
 * @author admin
 * @date 2020-04-17
 */
public class Enterprise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 企业ID */
    private Long id;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String enterpriseName;

    /** 所属数字小微园ID */
    @Excel(name = "所属数字小微园ID")
    private Long smallId;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String creditCode;

    /** 所属区域ID */
    @Excel(name = "所属区域ID")
    private Long areaId;

    /** 所属区域ID子级 */
    @Excel(name = "所属区域ID子级")
    private Long areaChildId;

    /** 行业代码 */
    @Excel(name = "行业代码")
    private String industryCode;

    /** 纳税人识别号 */
    @Excel(name = "纳税人识别号")
    private String taxpayerCode;

    /** 负责人 */
    @Excel(name = "负责人")
    private String chargePerson;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactTel;

    /** 所在楼栋 */
    @Excel(name = "所在楼栋")
    private String buildingNo;

    /** 所在楼层 */
    @Excel(name = "所在楼层")
    private String floorNo;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detailedAddress;

    /** 主导产品 */
    @Excel(name = "主导产品")
    private String leadingProducts;

    /** 入驻形式 */
    @Excel(name = "入驻形式")
    private Long intoForm;

    /** 入驻时间 */
    @Excel(name = "入驻时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date intoTime;

    /** 占地面积 */
    @Excel(name = "占地面积")
    private Double landSpace;

    /** 建筑面积 */
    @Excel(name = "建筑面积")
    private Double buildingSpace;

    /** 是否规上企业 */
    @Excel(name = "是否规上企业")
    private Long isRegulated;

    /** 是否科技型企业 */
    @Excel(name = "是否科技型企业")
    private Long isTechnology;

    /** 是否高新企业 */
    @Excel(name = "是否高新企业")
    private Long isHighTech;

    /** 经度 */
    @Excel(name = "经度")
    private String lon;

    /** 纬度 */
    @Excel(name = "纬度")
    private String lat;

    @Excel(name = "上年产值")
    private Long lastYearOutput;

    /** 员工数量 */
    @Excel(name = "员工数量")
    private Long employeeNumber;

    /** 专利个数 */
    @Excel(name = "专利个数")
    private Long patentNumber;

    /** 品牌拥有数 */
    @Excel(name = "品牌拥有数")
    private Long brandOwnership;

    /** 是否外资企业 */
    @Excel(name = "是否外资企业")
    private Long isForeign;

    /** 是否专精特新企业 */
    @Excel(name = "是否专精特新企业")
    private Long isSpecial;

    @Excel(name = "人才数量")
    private Long talentsNumber;

    private Long enterpriseType;

    public Long getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(Long enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Long getTalentsNumber() {
        return talentsNumber;
    }

    public void setTalentsNumber(Long talentsNumber) {
        this.talentsNumber = talentsNumber;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Long getPatentNumber() {
        return patentNumber;
    }

    public void setPatentNumber(Long patentNumber) {
        this.patentNumber = patentNumber;
    }

    public Long getBrandOwnership() {
        return brandOwnership;
    }

    public void setBrandOwnership(Long brandOwnership) {
        this.brandOwnership = brandOwnership;
    }

    public Long getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(Long isForeign) {
        this.isForeign = isForeign;
    }

    public Long getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Long isSpecial) {
        this.isSpecial = isSpecial;
    }

    public Long getLastYearOutput() {
        return lastYearOutput;
    }

    public void setLastYearOutput(Long lastYearOutput) {
        this.lastYearOutput = lastYearOutput;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEnterpriseName(String enterpriseName) 
    {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseName() 
    {
        return enterpriseName;
    }
    public void setSmallId(Long smallId) 
    {
        this.smallId = smallId;
    }

    public Long getSmallId() 
    {
        return smallId;
    }
    public void setCreditCode(String creditCode) 
    {
        this.creditCode = creditCode;
    }

    public String getCreditCode() 
    {
        return creditCode;
    }
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setAreaChildId(Long areaChildId) 
    {
        this.areaChildId = areaChildId;
    }

    public Long getAreaChildId() 
    {
        return areaChildId;
    }
    public void setIndustryCode(String industryCode) 
    {
        this.industryCode = industryCode;
    }

    public String getIndustryCode() 
    {
        return industryCode;
    }
    public void setTaxpayerCode(String taxpayerCode) 
    {
        this.taxpayerCode = taxpayerCode;
    }

    public String getTaxpayerCode() 
    {
        return taxpayerCode;
    }
    public void setChargePerson(String chargePerson) 
    {
        this.chargePerson = chargePerson;
    }

    public String getChargePerson() 
    {
        return chargePerson;
    }
    public void setContactTel(String contactTel) 
    {
        this.contactTel = contactTel;
    }

    public String getContactTel() 
    {
        return contactTel;
    }
    public void setBuildingNo(String buildingNo) 
    {
        this.buildingNo = buildingNo;
    }

    public String getBuildingNo() 
    {
        return buildingNo;
    }
    public void setFloorNo(String floorNo) 
    {
        this.floorNo = floorNo;
    }

    public String getFloorNo() 
    {
        return floorNo;
    }
    public void setDetailedAddress(String detailedAddress) 
    {
        this.detailedAddress = detailedAddress;
    }

    public String getDetailedAddress() 
    {
        return detailedAddress;
    }
    public void setLeadingProducts(String leadingProducts) 
    {
        this.leadingProducts = leadingProducts;
    }

    public String getLeadingProducts() 
    {
        return leadingProducts;
    }
    public void setIntoForm(Long intoForm) 
    {
        this.intoForm = intoForm;
    }

    public Long getIntoForm() 
    {
        return intoForm;
    }
    public void setIntoTime(Date intoTime) 
    {
        this.intoTime = intoTime;
    }

    public Date getIntoTime() 
    {
        return intoTime;
    }
    public void setLandSpace(Double landSpace) 
    {
        this.landSpace = landSpace;
    }

    public Double getLandSpace() 
    {
        return landSpace;
    }
    public void setBuildingSpace(Double buildingSpace) 
    {
        this.buildingSpace = buildingSpace;
    }

    public Double getBuildingSpace() 
    {
        return buildingSpace;
    }
    public void setIsRegulated(Long isRegulated) 
    {
        this.isRegulated = isRegulated;
    }

    public Long getIsRegulated() 
    {
        return isRegulated;
    }
    public void setIsTechnology(Long isTechnology) 
    {
        this.isTechnology = isTechnology;
    }

    public Long getIsTechnology() 
    {
        return isTechnology;
    }
    public void setIsHighTech(Long isHighTech) 
    {
        this.isHighTech = isHighTech;
    }

    public Long getIsHighTech() 
    {
        return isHighTech;
    }
    public void setLon(String lon) 
    {
        this.lon = lon;
    }

    public String getLon() 
    {
        return lon;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("enterpriseName", getEnterpriseName())
            .append("smallId", getSmallId())
            .append("creditCode", getCreditCode())
            .append("areaId", getAreaId())
            .append("areaChildId", getAreaChildId())
            .append("industryCode", getIndustryCode())
            .append("taxpayerCode", getTaxpayerCode())
            .append("chargePerson", getChargePerson())
            .append("contactTel", getContactTel())
            .append("buildingNo", getBuildingNo())
            .append("floorNo", getFloorNo())
            .append("detailedAddress", getDetailedAddress())
            .append("leadingProducts", getLeadingProducts())
            .append("intoForm", getIntoForm())
            .append("intoTime", getIntoTime())
            .append("landSpace", getLandSpace())
            .append("buildingSpace", getBuildingSpace())
            .append("isRegulated", getIsRegulated())
            .append("isTechnology", getIsTechnology())
            .append("isHighTech", getIsHighTech())
            .append("lon", getLon())
            .append("lat", getLat())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("lastYearOutput",getLastYearOutput())
            .toString();
    }
}
