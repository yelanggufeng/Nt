package com.netintech.solution.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 创新众包解决方案信息对象 sys_crowdsourcing_solution
 *
 * @author admin
 * @date 2020-06-22
 */
public class CrowdsourcingSolution extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 创新众包解决方案ID */
    private Long id;

    /** 众包需求需求ID */
    @Excel(name = "众包需求需求ID")
    private Long requirementId;

    /** 问题序号（1 2 3） */
    @Excel(name = "问题序号", readConverterExp = "1=,2=,3=")
    private Integer questionNo;

    /** 回答企业ID */
    @Excel(name = "回答企业ID")
    private Long answerEnterpriseId;

    /** 回答内容 */
    @Excel(name = "回答内容")
    private String answerContent;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contractTel;

    /** 回答时间 */
    @Excel(name = "回答时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date answerTime;

    /** 状态（0未通过 1通过） */
    @Excel(name = "状态", readConverterExp = "0=未通过,1=通过")
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
    public void setRequirementId(Long requirementId)
    {
        this.requirementId = requirementId;
    }

    public Long getRequirementId()
    {
        return requirementId;
    }
    public void setQuestionNo(Integer questionNo)
    {
        this.questionNo = questionNo;
    }

    public Integer getQuestionNo()
    {
        return questionNo;
    }
    public void setAnswerEnterpriseId(Long answerEnterpriseId)
    {
        this.answerEnterpriseId = answerEnterpriseId;
    }

    public Long getAnswerEnterpriseId()
    {
        return answerEnterpriseId;
    }
    public void setAnswerContent(String answerContent)
    {
        this.answerContent = answerContent;
    }

    public String getAnswerContent()
    {
        return answerContent;
    }
    public void setContractTel(String contractTel)
    {
        this.contractTel = contractTel;
    }

    public String getContractTel()
    {
        return contractTel;
    }
    public void setAnswerTime(Date answerTime)
    {
        this.answerTime = answerTime;
    }

    public Date getAnswerTime()
    {
        return answerTime;
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
            .append("requirementId", getRequirementId())
            .append("questionNo", getQuestionNo())
            .append("answerEnterpriseId", getAnswerEnterpriseId())
            .append("answerContent", getAnswerContent())
            .append("contractTel", getContractTel())
            .append("answerTime", getAnswerTime())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
