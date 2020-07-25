package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 贷款需求信息对象 sys_loan_requirement
 *
 * @author ltc
 * @date 2020-07-15
 */
public class LoanRequirement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 贷款需求id */
    private Long id;

    /** 附件id */
    @Excel(name = "附件id")
    private String fileUuid;

    /** 需求名称 */
    @Excel(name = "需求名称")
    private String requirementName;

    /** 贷款额度 */
    @Excel(name = "贷款额度")
    private Double loanLimit;

    /** 贷款期限 */
    @Excel(name = "贷款期限")
    private Integer loanTerm;

    /** 总资产 */
    @Excel(name = "总资产")
    private Double totalAsset;

    /** 总负债 */
    @Excel(name = "总负债")
    private Double totalDebt;

    /** 贷款用途 */
    @Excel(name = "贷款用途")
    private String purpose;

    /** 担保方式ID */
    @Excel(name = "担保方式ID")
    private Integer guaranteeMethodId;

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
    public void setRequirementName(String requirementName)
    {
        this.requirementName = requirementName;
    }

    public String getRequirementName()
    {
        return requirementName;
    }
    public void setLoanLimit(Double loanLimit)
    {
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit()
    {
        return loanLimit;
    }
    public void setLoanTerm(Integer loanTerm)
    {
        this.loanTerm = loanTerm;
    }

    public Integer getLoanTerm()
    {
        return loanTerm;
    }
    public void setTotalAsset(Double totalAsset)
    {
        this.totalAsset = totalAsset;
    }

    public Double getTotalAsset()
    {
        return totalAsset;
    }
    public void setTotalDebt(Double totalDebt)
    {
        this.totalDebt = totalDebt;
    }

    public Double getTotalDebt()
    {
        return totalDebt;
    }
    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

    public String getPurpose()
    {
        return purpose;
    }
    public void setGuaranteeMethodId(Integer guaranteeMethodId)
    {
        this.guaranteeMethodId = guaranteeMethodId;
    }

    public Integer getGuaranteeMethodId()
    {
        return guaranteeMethodId;
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
                .append("requirementName", getRequirementName())
                .append("loanLimit", getLoanLimit())
                .append("loanTerm", getLoanTerm())
                .append("totalAsset", getTotalAsset())
                .append("totalDebt", getTotalDebt())
                .append("purpose", getPurpose())
                .append("guaranteeMethodId", getGuaranteeMethodId())
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
