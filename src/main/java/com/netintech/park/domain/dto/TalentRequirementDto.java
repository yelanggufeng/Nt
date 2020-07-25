package com.netintech.park.domain.dto;

import com.netintech.enterprise.domain.Enterprise;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.TalentRequirement;
import com.netintech.project.system.user.domain.User;

/**
 * 人才需求信息实体列表
 */
public class TalentRequirementDto extends TalentRequirement {

    //小微园信息
    private SmallPark smallPark;

    //用户实体
    private User user;

    //企业实体
    private Enterprise enterprise;

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
