package com.netintech.park.domain.dto;


import com.netintech.park.domain.AttachmentTalent;
import com.netintech.park.domain.Talent;


import java.util.List;

/**
 * 人才信息实体类
 * author ltc
 */
public class AttachmentTalentDto extends Talent {
    private List<AttachmentTalent> attachmentTalentList;

    public List<AttachmentTalent> getAttachmentTalentList() {

            return attachmentTalentList;
    }

    public void setAttachmentTalentList(List<AttachmentTalent> attachmentTalentList) {
        this.attachmentTalentList = attachmentTalentList;
    }
}
