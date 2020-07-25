package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 人才增值服务信息对象 sys_talent_value_add
 */
public class TalentValueAdd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 增值服务ID */
    private Long id;

    /** 附件uuid */
    @Excel(name = "附件uuid")
    private String fileUuid;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 服务类型ID */
    @Excel(name = "服务类型ID")
    private Long serviceTypeId;

    /** 服务对象 */
    @Excel(name = "服务对象")
    private String serviceObject;

    /** 服务内容 */
    @Excel(name = "服务内容")
    private String serviceContent;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactTel;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String contactEmail;

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
    public void setServiceTypeId(Long serviceTypeId)
    {
        this.serviceTypeId = serviceTypeId;
    }

    public Long getServiceTypeId()
    {
        return serviceTypeId;
    }
    public void setServiceObject(String serviceObject)
    {
        this.serviceObject = serviceObject;
    }

    public String getServiceObject()
    {
        return serviceObject;
    }
    public void setServiceContent(String serviceContent)
    {
        this.serviceContent = serviceContent;
    }

    public String getServiceContent()
    {
        return serviceContent;
    }
    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    public String getContactName()
    {
        return contactName;
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("fileUuid", getFileUuid())
                .append("title", getTitle())
                .append("serviceTypeId", getServiceTypeId())
                .append("serviceObject", getServiceObject())
                .append("serviceContent", getServiceContent())
                .append("contactName", getContactName())
                .append("contactTel", getContactTel())
                .append("contactEmail", getContactEmail())
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