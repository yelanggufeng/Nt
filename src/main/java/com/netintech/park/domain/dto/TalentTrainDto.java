package com.netintech.park.domain.dto;

import com.netintech.enterprise.domain.Enterprise;
import com.netintech.park.domain.AttachmentTalentTrain;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.TalentTrain;
import com.netintech.project.system.user.domain.User;

import java.util.List;

/**
 * 人才培训实体类
 * @author ltc
 * @version 1.0
 * @date 2020/7/19 11:20
 */
public class TalentTrainDto extends TalentTrain {
    private List<AttachmentTalentTrain> attachmentTalentTrainList;
    //小微园信息
    private SmallPark smallPark;

    //用户实体
    private User user;

    //企业实体
    private Enterprise enterprise;

    public List<AttachmentTalentTrain> getAttachmentTalentTrainList() {
        return attachmentTalentTrainList;
    }

    public void setAttachmentTalentTrainList(List<AttachmentTalentTrain> attachmentTalentTrainList) {
        this.attachmentTalentTrainList = attachmentTalentTrainList;
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
