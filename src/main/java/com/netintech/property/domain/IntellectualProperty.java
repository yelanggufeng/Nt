package com.netintech.property.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 知识产权信息对象 sys_intellectual_property
 *
 * @author admin
 * @date 2020-06-22
 */
public class IntellectualProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 知识产权ID */
    private Long id;

    /** 附件uuid */
    @Excel(name = "附件uuid")
    private String fileUuid;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 服务分类ID */
    @Excel(name = "服务分类ID")
    private Long fieldId;

    /** 概述 */
    @Excel(name = "概述")
    private String summary;

    /** 详情描述 */
    @Excel(name = "详情描述")
    private String detail;

    /** 合作方式ID */
    @Excel(name = "合作方式ID")
    private Long cooperationMethodId;

    /** 是否面议（0否 1是） */
    @Excel(name = "是否面议", readConverterExp = "0=否,1=是")
    private String isFace;

    /** 价格 */
    @Excel(name = "价格")
    private Double price;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPeople;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactTel;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String contactEmail;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String contactAddress;

    /** 所属小微园ID */
    @Excel(name = "所属小微园ID")
    private Long parkId;

    /** 所属企业ID */
    @Excel(name = "所属企业ID")
    private Long enterpriseId;

    /** 状态 0待审核 1已发布 2审核驳回 3已失效 */
    @Excel(name = "状态 0待审核 1已发布 2审核驳回 3已失效")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
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
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setFieldId(Long fieldId)
    {
        this.fieldId = fieldId;
    }

    public Long getFieldId()
    {
        return fieldId;
    }
    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }
    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getDetail()
    {
        return detail;
    }
    public void setCooperationMethodId(Long cooperationMethodId)
    {
        this.cooperationMethodId = cooperationMethodId;
    }

    public Long getCooperationMethodId()
    {
        return cooperationMethodId;
    }
    public void setIsFace(String isFace)
    {
        this.isFace = isFace;
    }

    public String getIsFace()
    {
        return isFace;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setContactPeople(String contactPeople)
    {
        this.contactPeople = contactPeople;
    }

    public String getContactPeople()
    {
        return contactPeople;
    }
    public void setContactTel(String contactTel)
    {
        this.contactTel = contactTel;
    }

    public String getContactTel()
    {
        return contactTel;
    }
    public void setContactEmail(String contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail()
    {
        return contactEmail;
    }
    public void setContactAddress(String contactAddress)
    {
        this.contactAddress = contactAddress;
    }

    public String getContactAddress()
    {
        return contactAddress;
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
            .append("title", getTitle())
            .append("fieldId", getFieldId())
            .append("summary", getSummary())
            .append("detail", getDetail())
            .append("cooperationMethodId", getCooperationMethodId())
            .append("isFace", getIsFace())
            .append("price", getPrice())
            .append("contactPeople", getContactPeople())
            .append("contactTel", getContactTel())
            .append("contactEmail", getContactEmail())
            .append("contactAddress", getContactAddress())
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
