package com.netintech.park.domain;

import com.netintech.core.aspectj.lang.annotation.Excel;
import com.netintech.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 人才信息对象 sys_talent
 *
 * @author admin
 * @date 2020-07-17
 */
public class Talent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人才信息ID */
    private Long id;

    /** 附件uuid */
    @Excel(name = "附件uuid")
    private String fileUuid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别（0男 1女 2未知） */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 出生日期 */
    @Excel(name = "出生日期")
    private String birthday;

    /** 手机号 */
    @Excel(name = "手机号")
    private String mobile;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 所在地 */
    @Excel(name = "所在地")
    private String location;

    /** 学历ID */
    @Excel(name = "学历ID")
    private Integer degreeId;

    /** 工作年限 */
    @Excel(name = "工作年限")
    private Integer workYear;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String unitName;

    /** 职务 */
    @Excel(name = "职务")
    private String position;

    /** 职称 */
    @Excel(name = "职称")
    private String title;

    /** 技术领域 */
    @Excel(name = "技术领域")
    private String technicalField;

    /** 教育背景 */
    @Excel(name = "教育背景")
    private String educationBackground;

    /** 工作经历 */
    @Excel(name = "工作经历")
    private String workExperience;

    /** 科技成果 */
    @Excel(name = "科技成果")
    private String technologyAchievement;

    /** 项目经验 */
    @Excel(name = "项目经验")
    private String projectExperience;

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
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getBirthday()
    {
        return birthday;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }
    public void setDegreeId(Integer degreeId)
    {
        this.degreeId = degreeId;
    }

    public Integer getDegreeId()
    {
        return degreeId;
    }
    public void setWorkYear(Integer workYear)
    {
        this.workYear = workYear;
    }

    public Integer getWorkYear()
    {
        return workYear;
    }
    public void setUnitName(String unitName)
    {
        this.unitName = unitName;
    }

    public String getUnitName()
    {
        return unitName;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTechnicalField(String technicalField)
    {
        this.technicalField = technicalField;
    }

    public String getTechnicalField()
    {
        return technicalField;
    }
    public void setEducationBackground(String educationBackground)
    {
        this.educationBackground = educationBackground;
    }

    public String getEducationBackground()
    {
        return educationBackground;
    }
    public void setWorkExperience(String workExperience)
    {
        this.workExperience = workExperience;
    }

    public String getWorkExperience()
    {
        return workExperience;
    }
    public void setTechnologyAchievement(String technologyAchievement)
    {
        this.technologyAchievement = technologyAchievement;
    }

    public String getTechnologyAchievement()
    {
        return technologyAchievement;
    }
    public void setProjectExperience(String projectExperience)
    {
        this.projectExperience = projectExperience;
    }

    public String getProjectExperience()
    {
        return projectExperience;
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
                .append("name", getName())
                .append("sex", getSex())
                .append("birthday", getBirthday())
                .append("mobile", getMobile())
                .append("email", getEmail())
                .append("location", getLocation())
                .append("degreeId", getDegreeId())
                .append("workYear", getWorkYear())
                .append("unitName", getUnitName())
                .append("position", getPosition())
                .append("title", getTitle())
                .append("technicalField", getTechnicalField())
                .append("educationBackground", getEducationBackground())
                .append("workExperience", getWorkExperience())
                .append("technologyAchievement", getTechnologyAchievement())
                .append("projectExperience", getProjectExperience())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}