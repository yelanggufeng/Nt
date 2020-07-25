package com.netintech.park.domain.dto;

import com.netintech.enterprise.domain.Enterprise;
import com.netintech.park.domain.*;
import com.netintech.project.system.user.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 贷款需求信息实体
 */
public class LoanRequirementDto extends LoanRequirement {



    //小微园信息
     private SmallPark smallPark;

     //用户实体
     private User user;

     //企业实体
     private Enterprise enterprise;


    //附件实体
    private List<AttachmentLoanRequirement> attachmentLoanRequirementList;

    //贷款需求财务信息
    private List<LoanFinanceData> loanFinanceDataList;



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


    public List<AttachmentLoanRequirement> getAttachmentLoanRequirementList() {
        return attachmentLoanRequirementList;
    }

    public void setAttachmentLoanRequirementList(List<AttachmentLoanRequirement> attachmentLoanRequirementList) {
        this.attachmentLoanRequirementList = attachmentLoanRequirementList;
    }

    public List<LoanFinanceData> getLoanFinanceDataList() {
        return loanFinanceDataList;
    }

    public void setLoanFinanceDataList(List<LoanFinanceData> loanFinanceDataList) {
        this.loanFinanceDataList = loanFinanceDataList;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
