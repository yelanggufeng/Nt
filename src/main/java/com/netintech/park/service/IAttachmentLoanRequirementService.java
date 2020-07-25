package com.netintech.park.service;

import com.netintech.park.domain.AttachmentLoanRequirement;

import java.util.List;

/**
 * 贷款需求信息附件Service接口
 *
 * @author admin
 * @date 2020-07-15
 */
public interface IAttachmentLoanRequirementService
{
    /**
     * 查询贷款需求信息附件
     *
     * @param id 贷款需求信息附件ID
     * @return 贷款需求信息附件
     */
    AttachmentLoanRequirement selectAttachmentLoanRequirementById(Long id);

    /**
     * 查询贷款需求信息附件列表
     *
     * @param attachmentLoanRequirement 贷款需求信息附件
     * @return 贷款需求信息附件集合
     */
    List<AttachmentLoanRequirement> selectAttachmentLoanRequirementList(AttachmentLoanRequirement attachmentLoanRequirement);

    /**
     * 新增贷款需求信息附件
     *
     * @param attachmentLoanRequirement 贷款需求信息附件
     * @return 结果
     */
    int insertAttachmentLoanRequirement(AttachmentLoanRequirement attachmentLoanRequirement);

    /**
     * 修改贷款需求信息附件
     *
     * @param attachmentLoanRequirement 贷款需求信息附件
     * @return 结果
     */
    int updateAttachmentLoanRequirement(AttachmentLoanRequirement attachmentLoanRequirement);

    /**
     * 批量删除贷款需求信息附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentLoanRequirementByIds(String ids);

    /**
     * 删除贷款需求信息附件信息
     *
     * @param id 贷款需求信息附件ID
     * @return 结果
     */
    int deleteAttachmentLoanRequirementById(Long id);
}