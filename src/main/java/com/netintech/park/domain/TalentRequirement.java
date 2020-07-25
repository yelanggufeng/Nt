package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 人才需求信息对象 sys_talent_requirement
 *
 * @author admin
 * @date 2020-07-17
 */
public class TalentRequirement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人才需求ID */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 需求类型ID */
    @Excel(name = "需求类型ID")
    private Long  requireTypeId;

    /** 项目估价（元） */
    @Excel(name = "项目估价", readConverterExp = "元=")
    private Double projectValuation;

    /** 产业分类ID */
    @Excel(name = "产业分类ID")
    private Long industryId;

    /** 学历要求ID */
    @Excel(name = "学历要求ID")
    private Long degreeId;

    /** 经验要求ID */
    @Excel(name = "经验要求ID")
    private Long experienceId;

    /** 需求描述 */
    @Excel(name = "需求描述")
    private String description;

    /** 所属小微园ID */
    @Excel(name = "所属小微园ID")
    private Long parkId;

    /** 所属企业ID */
    @Excel(name = "所属企业ID")
    private Long enterpriseId;

    /** 状态 0待审核 1已发布 2审核驳回 */
    @Excel(name = "状态 0待审核 1已发布 2审核驳回")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRequireTypeId() {
        return requireTypeId;
    }

    public void setRequireTypeId(Long requireTypeId) {
        this.requireTypeId = requireTypeId;
    }

    public Double getProjectValuation() {
        return projectValuation;
    }

    public void setProjectValuation(Double projectValuation) {
        this.projectValuation = projectValuation;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public Long getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Long degreeId) {
        this.degreeId = degreeId;
    }

    public Long getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Long experienceId) {
        this.experienceId = experienceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("requireTypeId", getRequireTypeId())
                .append("projectValuation", getProjectValuation())
                .append("industryId", getIndustryId())
                .append("degreeId", getDegreeId())
                .append("experienceId", getExperienceId())
                .append("description", getDescription())
                .append("parkId", getParkId())
                .append("enterpriseId", getEnterpriseId())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}