package com.netintech.requirement.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 创新众包需求信息对象 sys_crowdsourcing_requirement
 *
 * @author admin
 * @date 2020-06-19
 */
public class CrowdsourcingRequirement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 创新众包需求ID */
    private Long id;

    /** 附件uuid */
    @Excel(name = "附件uuid")
    private String fileUuid;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 技术领域ID */
    @Excel(name = "技术领域ID")
    private Long fieldId;

    /** 截止日期 */
    @Excel(name = "截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date closingDate;

    /** 悬赏金额 */
    @Excel(name = "悬赏金额")
    private Double rewardAmount;

    /** 详情 */
    @Excel(name = "详情")
    private String detail;

    /** 问题1 */
    @Excel(name = "问题1")
    private String question1;

    /** 问题2 */
    @Excel(name = "问题2")
    private String question2;

    /** 问题3 */
    @Excel(name = "问题3")
    private String question3;

    /** 所属小微园ID */
    @Excel(name = "所属小微园ID")
    private Long parkId;

    /** 所属企业ID */
    @Excel(name = "所属企业ID")
    private Long enterpriseId;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long pageviews;

    /** 是否解决 0否 1是 */
    @Excel(name = "是否解决 0否 1是")
    private String result;

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
    public void setClosingDate(Date closingDate)
    {
        this.closingDate = closingDate;
    }

    public Date getClosingDate()
    {
        return closingDate;
    }
    public void setRewardAmount(Double rewardAmount)
    {
        this.rewardAmount = rewardAmount;
    }

    public Double getRewardAmount()
    {
        return rewardAmount;
    }
    public void setQuestion1(String question1)
    {
        this.question1 = question1;
    }

    public String getQuestion1()
    {
        return question1;
    }
    public void setQuestion2(String question2)
    {
        this.question2 = question2;
    }

    public String getQuestion2()
    {
        return question2;
    }
    public void setQuestion3(String question3)
    {
        this.question3 = question3;
    }

    public String getQuestion3()
    {
        return question3;
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
    public void setPageviews(Long pageviews)
    {
        this.pageviews = pageviews;
    }

    public Long getPageviews()
    {
        return pageviews;
    }
    public void setResult(String result)
    {
        this.result = result;
    }

    public String getResult()
    {
        return result;
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
            .append("closingDate", getClosingDate())
            .append("rewardAmount", getRewardAmount())
            .append("question1", getQuestion1())
            .append("question2", getQuestion2())
            .append("question3", getQuestion3())
            .append("parkId", getParkId())
            .append("enterpriseId", getEnterpriseId())
            .append("pageviews", getPageviews())
            .append("result", getResult())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
