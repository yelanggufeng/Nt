package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 技术成果需求信息图片附件对象 attachment_finance_requirement
 *
 * @author admin
 * @date 2020-07-16
 */
public class AttachmentFinanceRequirement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 金融需求附件图片ID */
    private Long id;

    /** 金融需求ID */
    @Excel(name = "金融需求ID")
    private Long requirementId;

    /** 附件类型 （0图片 1附件） */
    @Excel(name = "附件类型 ", readConverterExp = "0=图片,1=附件")
    private Integer fileType;

    /** 附件uuid */
    @Excel(name = "附件uuid")
    private String fileUuid;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件别名（实际存储文件名） */
    @Excel(name = "文件别名", readConverterExp = "实=际存储文件名")
    private String fileAlias;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

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
    public void setFileType(Integer fileType)
    {
        this.fileType = fileType;
    }

    public Integer getFileType()
    {
        return fileType;
    }
    public void setFileUuid(String fileUuid)
    {
        this.fileUuid = fileUuid;
    }

    public String getFileUuid()
    {
        return fileUuid;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return fileName;
    }
    public void setFileAlias(String fileAlias)
    {
        this.fileAlias = fileAlias;
    }

    public String getFileAlias()
    {
        return fileAlias;
    }
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getFilePath()
    {
        return filePath;
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
                .append("fileType", getFileType())
                .append("fileUuid", getFileUuid())
                .append("fileName", getFileName())
                .append("fileAlias", getFileAlias())
                .append("filePath", getFilePath())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .toString();
    }
}