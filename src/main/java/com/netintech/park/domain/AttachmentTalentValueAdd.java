package com.netintech.park.domain;


import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 人才增值服务信息图片附件对象 attachment_talent_value_add
 *
 * @author admin
 * @date 2020-07-17
 */
public class AttachmentTalentValueAdd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 增值服务附件图片ID */
    private Long id;

    /** 增值服务信息ID */
    @Excel(name = "增值服务信息ID")
    private Long addId;

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
    public void setAddId(Long addId)
    {
        this.addId = addId;
    }

    public Long getAddId()
    {
        return addId;
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
                .append("addId", getAddId())
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