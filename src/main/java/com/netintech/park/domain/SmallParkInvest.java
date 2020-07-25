package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 小微园投资额信息对象 sys_small_park_invest
 *
 * @author admin
 * @date 2020-06-18
 */
public class SmallParkInvest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小微园投资额id */
    private Long id;

    /** 小微园id */
    @Excel(name = "小微园id")
    private Long smallId;

    /**
     * 园区名称
     */
    @Excel(name = "园区名称")
    private String name;

    /** 年份 */
    @Excel(name = "年份")
    private Integer year;

    /** 月份 */
    @Excel(name = "月份")
    private Integer month;

    /** 投资额（万元） */
    @Excel(name = "投资额", readConverterExp = "万=元")
    private Double investment;

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
    public void setSmallId(Long smallId)
    {
        this.smallId = smallId;
    }

    public Long getSmallId()
    {
        return smallId;
    }
    public void setYear(Integer year)
    {
        this.year = year;
    }

    public Integer getYear()
    {
        return year;
    }
    public void setMonth(Integer month)
    {
        this.month = month;
    }

    public Integer getMonth()
    {
        return month;
    }
    public void setInvestment(Double investment)
    {
        this.investment = investment;
    }

    public Double getInvestment()
    {
        return investment;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("smallId", getSmallId())
            .append("year", getYear())
            .append("month", getMonth())
            .append("investment", getInvestment())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
