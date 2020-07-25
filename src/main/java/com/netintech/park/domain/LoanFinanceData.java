package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 贷款需求财务信息对象 sys_loan_finance_data
 *
 * @author ltc
 * @date 2020-07-15
 */
public class LoanFinanceData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 贷款需求财务信息id */
    private Long id;

    /** 贷款需求ID */
    @Excel(name = "贷款需求ID")
    private Long requirementId;

    /** 年份 */
    @Excel(name = "年份")
    private Integer year;

    /** 营业收入（万元） */
    @Excel(name = "营业收入", readConverterExp = "万=元")
    private Double businessIncome;

    /** 净利润（万元） */
    @Excel(name = "净利润", readConverterExp = "万=元")
    private Double netProfit;

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
    public void setYear(Integer year)
    {
        this.year = year;
    }

    public Integer getYear()
    {
        return year;
    }
    public void setBusinessIncome(Double businessIncome)
    {
        this.businessIncome = businessIncome;
    }

    public Double getBusinessIncome()
    {
        return businessIncome;
    }
    public void setNetProfit(Double netProfit)
    {
        this.netProfit = netProfit;
    }

    public Double getNetProfit()
    {
        return netProfit;
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
                .append("year", getYear())
                .append("businessIncome", getBusinessIncome())
                .append("netProfit", getNetProfit())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .toString();
    }
}