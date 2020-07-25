package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 人才培训信息对象 sys_talent_train
 *
 * @author admin
 * @date 2020-07-17
 */
public class TalentTrain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人才培训ID */
    private Long id;

    /** 附件uuid */
    @Excel(name = "附件uuid")
    private String fileUuid;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 课程务类型ID */
    @Excel(name = "课程务类型ID")
    private Long classTypeId;

    /** 行业类型ID */
    @Excel(name = "行业类型ID")
    private Long industryId;

    /** 价格（元） */
    @Excel(name = "价格", readConverterExp = "元=")
    private Double price;

    /** 报名开始时间 */
    @Excel(name = "报名开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signupStartTime;

    /** 报名结束时间 */
    @Excel(name = "报名结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signupEndTime;

    /** 培训开始时间 */
    @Excel(name = "培训开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date trainStartTime;

    /** 培训结束时间 */
    @Excel(name = "培训结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date trainEndTime;

    /** 培训地址 */
    @Excel(name = "培训地址")
    private String address;

    /** 适用对象 */
    @Excel(name = "适用对象")
    private String applyObject;

    /** 课程概述 */
    @Excel(name = "课程概述")
    private String summary;

    /** 报名方式 */
    @Excel(name = "报名方式")
    private String signupMethod;

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
    public void setClassTypeId(Long classTypeId)
    {
        this.classTypeId = classTypeId;
    }

    public Long getClassTypeId()
    {
        return classTypeId;
    }
    public void setIndustryId(Long industryId)
    {
        this.industryId = industryId;
    }

    public Long getIndustryId()
    {
        return industryId;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setSignupStartTime(Date signupStartTime)
    {
        this.signupStartTime = signupStartTime;
    }

    public Date getSignupStartTime()
    {
        return signupStartTime;
    }
    public void setSignupEndTime(Date signupEndTime)
    {
        this.signupEndTime = signupEndTime;
    }

    public Date getSignupEndTime()
    {
        return signupEndTime;
    }
    public void setTrainStartTime(Date trainStartTime)
    {
        this.trainStartTime = trainStartTime;
    }

    public Date getTrainStartTime()
    {
        return trainStartTime;
    }
    public void setTrainEndTime(Date trainEndTime)
    {
        this.trainEndTime = trainEndTime;
    }

    public Date getTrainEndTime()
    {
        return trainEndTime;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setApplyObject(String applyObject)
    {
        this.applyObject = applyObject;
    }

    public String getApplyObject()
    {
        return applyObject;
    }
    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }
    public void setSignupMethod(String signupMethod)
    {
        this.signupMethod = signupMethod;
    }

    public String getSignupMethod()
    {
        return signupMethod;
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
                .append("classTypeId", getClassTypeId())
                .append("industryId", getIndustryId())
                .append("price", getPrice())
                .append("signupStartTime", getSignupStartTime())
                .append("signupEndTime", getSignupEndTime())
                .append("trainStartTime", getTrainStartTime())
                .append("trainEndTime", getTrainEndTime())
                .append("address", getAddress())
                .append("applyObject", getApplyObject())
                .append("summary", getSummary())
                .append("signupMethod", getSignupMethod())
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