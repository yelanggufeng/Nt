package com.netintech.record.domain;


import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 技术成果审核记录信息对象 sys_audit_record
 *
 * @author admin
 * @date 2020-06-17
 */
public class AuditRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审核ID */
    private Long id;

    /** 信息ID */
    @Excel(name = "信息ID")
    private Long infoId;

    /** 信息类型（1技术成果信息） */
    @Excel(name = "信息类型", readConverterExp = "1=技术成果信息 2=技术需求信息")
    private Integer typeId;

    /** 审核结果 (1已通过 2审核驳回 3已失效) */
    @Excel(name = "审核结果 (1已通过 2审核驳回 3已失效)")
    private String auditResult;

    /** 审核时间 */
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String auditOpinion;

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
    public void setInfoId(Long infoId)
    {
        this.infoId = infoId;
    }

    public Long getInfoId()
    {
        return infoId;
    }
    public void setTypeId(Integer typeId)
    {
        this.typeId = typeId;
    }

    public Integer getTypeId()
    {
        return typeId;
    }
    public void setAuditResult(String auditResult)
    {
        this.auditResult = auditResult;
    }

    public String getAuditResult()
    {
        return auditResult;
    }
    public void setAuditTime(Date auditTime)
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime()
    {
        return auditTime;
    }
    public void setAuditOpinion(String auditOpinion)
    {
        this.auditOpinion = auditOpinion;
    }

    public String getAuditOpinion()
    {
        return auditOpinion;
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
            .append("infoId", getInfoId())
            .append("typeId", getTypeId())
            .append("auditResult", getAuditResult())
            .append("auditTime", getAuditTime())
            .append("auditOpinion", getAuditOpinion())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
