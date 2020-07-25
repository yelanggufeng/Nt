package com.netintech.enterprise.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 企业效益信息对象 sys_enterprise_benefit
 *
 * @author admin
 * @date 2020-05-09
 */
public class EnterpriseBenefit extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 企业效益ID
     */
    private Long id;

    /**
     * 企业名称
     */
    @Excel(name = "企业名称")
    private String name;

    /**
     * 企业ID
     */
    private Long enterpriseId;

    /**
     * 年份
     */
    @Excel(name = "年份")
    private Integer year;

    /**
     * 月份
     */
    @Excel(name = "月份")
    private Integer month;

    /**
     * 收入（万元）
     */
    @Excel(name = "收入", readConverterExp = "万=元")
    private Double income;

    /**
     * 税收（万元）
     */
    @Excel(name = "税收", readConverterExp = "万=元")
    private Double tax;

    @Excel(name = "产值", readConverterExp = "万=元")
    private Double output;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getMonth() {
        return month;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getIncome() {
        return income;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOutput() {
        return output;
    }

    public void setOutput(Double output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id",getId())
                .append("enterpriseId",getEnterpriseId())
                .append("name",getName())
                .append("year",getYear())
                .append("month",getMonth())
                .append("income",getIncome())
                .append("tax",getTax())
                .append("output",getOutput())
                .append("delFlag",getDelFlag())
                .append("createBy",getCreateBy())
                .append("createTime",getCreateTime())
                .append("updateBy",getUpdateBy())
                .append("updateTime",getUpdateTime())
                .toString();
    }
}
