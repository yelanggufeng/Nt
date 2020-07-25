package com.netintech.requirement.mapper;

import com.netintech.requirement.domain.AttachmentCrowdsourcingRequirement;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 创新众包需求信息图片附件Mapper接口
 *
 * @author admin
 * @date 2020-06-19
 */
public interface AttachmentCrowdsourcingRequirementMapper
{
    /**
     * 查询创新众包需求信息图片附件
     *
     * @param id 创新众包需求信息图片附件ID
     * @return 创新众包需求信息图片附件
     */
    AttachmentCrowdsourcingRequirement selectAttachmentCrowdsourcingRequirementById(Long id);

    /**
     * 查询创新众包需求信息图片附件列表
     *
     * @param attachmentCrowdsourcingRequirement 创新众包需求信息图片附件
     * @return 创新众包需求信息图片附件集合
     */
    List<AttachmentCrowdsourcingRequirement> selectAttachmentCrowdsourcingRequirementList(AttachmentCrowdsourcingRequirement attachmentCrowdsourcingRequirement);

    /**
     * 新增创新众包需求信息图片附件
     *
     * @param attachmentCrowdsourcingRequirement 创新众包需求信息图片附件
     * @return 结果
     */
    int insertAttachmentCrowdsourcingRequirement(AttachmentCrowdsourcingRequirement attachmentCrowdsourcingRequirement);

    /**
     * 修改创新众包需求信息图片附件
     *
     * @param attachmentCrowdsourcingRequirement 创新众包需求信息图片附件
     * @return 结果
     */
    int updateAttachmentCrowdsourcingRequirement(AttachmentCrowdsourcingRequirement attachmentCrowdsourcingRequirement);

    /**
     * 删除创新众包需求信息图片附件
     *
     * @param id 创新众包需求信息图片附件ID
     * @return 结果
     */
    int deleteAttachmentCrowdsourcingRequirementById(Long id);

    /**
     * 批量删除创新众包需求信息图片附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentCrowdsourcingRequirementByIds(String[] ids);

    @Update("update attachment_crowdsourcing_requirement set requirement_id = #{requirementId} where file_uuid = #{fileUuid}")
    int updateFileRelatedKey(Long requirementId, String fileUuid);
}
