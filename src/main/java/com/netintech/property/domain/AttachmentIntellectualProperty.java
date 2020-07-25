package com.netintech.property.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 知识产权信息附件对象 attachment_intellectual_property
 *
 * @author admin
 * @date 2020-06-22
 */
public class AttachmentIntellectualProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 知识产权附件ID */
    private Long id;

    /** 知识产权ID */
    @Excel(name = "知识产权ID")
    private Long propertyId;

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
    public void setPropertyId(Long propertyId)
    {
        this.propertyId = propertyId;
    }

    public Long getPropertyId()
    {
        return propertyId;
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
            .append("propertyId", getPropertyId())
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
