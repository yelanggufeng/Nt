package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 融资需求信息对象 sys_finance_requirement
 *
 * @author ltc
 * @date 2020-07-15
 */
public class FinanceRequirement extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 融资需求id */
    @ApiModelProperty(value = "融资需求id")
    private Long id;

    /** 附件id */
    @ApiModelProperty(value = "附件id")
    @Excel(name = "附件id")
    private String fileUuid;

    /** 项目名称 */
    @ApiModelProperty(value = "项目名称")
    @Excel(name = "项目名称")
    private String projectName;

    /** 一句话概述 */
    @ApiModelProperty(value = "一句话概述")
    @Excel(name = "一句话概述")
    private String overview;

    /** 项目领域 */
    @ApiModelProperty(value = "项目领域")
    @Excel(name = "项目领域")
    private String fieldId;

    /** 区域id */
    @ApiModelProperty(value = "")
    @Excel(name = "区域id")
    private Long areaId;

    /** 详细地址 */
    @ApiModelProperty(value = "详细地址")
    @Excel(name = "详细地址")
    private String address;

    /** 所属阶段（1:天使轮 2:A轮 3:B轮 4:C轮 5:PE） */
    @ApiModelProperty(value = "所属阶段（1:天使轮 2:A轮 3:B轮 4:C轮 5:PE）")
    @Excel(name = "所属阶段", readConverterExp = "1=:天使轮,2=:A轮,3=:B轮,4=:C轮,5=:PE")
    private Integer stage;

    /** 项目简介 */
    @ApiModelProperty(value = "项目简介")
    @Excel(name = "项目简介")
    private String profile;

    /** 融资金额 */
    @ApiModelProperty(value = "融资金额")
    @Excel(name = "融资金额")
    private Double amount;

    /** 融资用途 */
    @ApiModelProperty(value = "融资用途")
    @Excel(name = "融资用途")
    private String purpose;

    /** 股权出让比例 */
    @ApiModelProperty(value = "股权出让比例")
    @Excel(name = "股权出让比例")
    private Double shareSellProp;

    /** 所属小微园ID */
    @ApiModelProperty(value = "所属小微园ID")
    @Excel(name = "所属小微园ID")
    private Long parkId;

    /** 所属企业ID */
    @ApiModelProperty(value = "所属企业ID")
    @Excel(name = "所属企业ID")
    private Long enterpriseId;

    /** 状态 0待审核 1已发布 2审核驳回 3已失效 */
    @ApiModelProperty(value = "状态 0待审核 1已发布 2审核驳回 3已失效")
    @Excel(name = "状态 0待审核 1已发布 2审核驳回 3已失效")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFileUuid(String fileUuid)
    {
        this.fileUuid = fileUuid;
    }

    public String getFileUuid()
    {
        return fileUuid;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setOverview(String overview)
    {
        this.overview = overview;
    }

    public String getOverview()
    {
        return overview;
    }
    public void setFieldId(String fieldId)
    {
        this.fieldId = fieldId;
    }

    public String getFieldId()
    {
        return fieldId;
    }
    public void setAreaId(Long areaId)
    {
        this.areaId = areaId;
    }

    public Long getAreaId()
    {
        return areaId;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setStage(Integer stage)
    {
        this.stage = stage;
    }

    public Integer getStage()
    {
        return stage;
    }
    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public String getProfile()
    {
        return profile;
    }
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public Double getAmount()
    {
        return amount;
    }
    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

    public String getPurpose()
    {
        return purpose;
    }
    public void setShareSellProp(Double shareSellProp)
    {
        this.shareSellProp = shareSellProp;
    }

    public Double getShareSellProp()
    {
        return shareSellProp;
    }
    public void setParkId(Long parkId)
    {
        this.parkId = parkId;
    }

    public Long getParkId()
    {
        return parkId;
    }
    public void setEnterpriseId(Long enterpriseId)
    {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseId()
    {
        return enterpriseId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("fileUuid", getFileUuid())
                .append("projectName", getProjectName())
                .append("overview", getOverview())
                .append("fieldId", getFieldId())
                .append("areaId", getAreaId())
                .append("address", getAddress())
                .append("stage", getStage())
                .append("profile", getProfile())
                .append("amount", getAmount())
                .append("purpose", getPurpose())
                .append("shareSellProp", getShareSellProp())
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
