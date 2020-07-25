package com.netintech.park.domain.dto;

import com.netintech.enterprise.domain.Enterprise;
import com.netintech.park.domain.Area;
import com.netintech.park.domain.AttachmentFinanceRequirement;
import com.netintech.park.domain.FinanceRequirement;
import com.netintech.park.domain.SmallPark;
import com.netintech.project.system.user.domain.User;

import java.util.List;

public class FinanceRequirementDto extends FinanceRequirement {
    private List<AttachmentFinanceRequirement> attachmentFinanceRequirementList;
    private Area area;

    //小微园信息
    private SmallPark smallPark;

    //用户实体
    private User user;

    //企业实体
    private Enterprise enterprise;

    public List<AttachmentFinanceRequirement> getAttachmentFinanceRequirementList() {
        return attachmentFinanceRequirementList;
    }

    public void setAttachmentFinanceRequirementList(List<AttachmentFinanceRequirement> attachmentFinanceRequirementList) {
        this.attachmentFinanceRequirementList = attachmentFinanceRequirementList;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public SmallPark getSmallPark() {
        return smallPark;
    }

    public void setSmallPark(SmallPark smallPark) {
        this.smallPark = smallPark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
