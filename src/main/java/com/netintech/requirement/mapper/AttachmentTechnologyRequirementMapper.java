package com.netintech.requirement.mapper;

import com.netintech.requirement.domain.AttachmentTechnologyRequirement;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 技术成果需求信息图片附件Mapper接口
 *
 * @author admin
 * @date 2020-06-19
 */
public interface AttachmentTechnologyRequirementMapper
{
    /**
     * 查询技术成果需求信息图片附件
     *
     * @param id 技术成果需求信息图片附件ID
     * @return 技术成果需求信息图片附件
     */
    AttachmentTechnologyRequirement selectAttachmentTechnologyRequirementById(Long id);

    /**
     * 查询技术成果需求信息图片附件列表
     *
     * @param attachmentTechnologyRequirement 技术成果需求信息图片附件
     * @return 技术成果需求信息图片附件集合
     */
    List<AttachmentTechnologyRequirement> selectAttachmentTechnologyRequirementList(AttachmentTechnologyRequirement attachmentTechnologyRequirement);

    /**
     * 新增技术成果需求信息图片附件
     *
     * @param attachmentTechnologyRequirement 技术成果需求信息图片附件
     * @return 结果
     */
    int insertAttachmentTechnologyRequirement(AttachmentTechnologyRequirement attachmentTechnologyRequirement);

    /**
     * 修改技术成果需求信息图片附件
     *
     * @param attachmentTechnologyRequirement 技术成果需求信息图片附件
     * @return 结果
     */
    int updateAttachmentTechnologyRequirement(AttachmentTechnologyRequirement attachmentTechnologyRequirement);

    /**
     * 删除技术成果需求信息图片附件
     *
     * @param id 技术成果需求信息图片附件ID
     * @return 结果
     */
    int deleteAttachmentTechnologyRequirementById(Long id);

    /**
     * 批量删除技术成果需求信息图片附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentTechnologyRequirementByIds(String[] ids);

    @Update("update attachment_technology_requirement set requirement_id = #{requirementId} where file_uuid = #{fileUuid}")
    int updateFileRelatedKey(Long requirementId, String fileUuid);
}
