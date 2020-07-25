package com.netintech.park.mapper;

import com.netintech.park.domain.AttachmentFinanceRequirement;

import java.util.List;

/**
 * 融资需求信息表图片附件Mapper接口
 *
 * @author admin
 * @date 2020-07-16
 */
public interface AttachmentFinanceRequirementMapper
{
    /**
     * 查询技术成果需求信息图片附件
     *
     * @param id 技术成果需求信息图片附件ID
     * @return 技术成果需求信息图片附件
     */
    AttachmentFinanceRequirement selectAttachmentFinanceRequirementById(Long id);

    /**
     * 查询技术成果需求信息图片附件列表
     *
     * @param attachmentFinanceRequirement 技术成果需求信息图片附件
     * @return 技术成果需求信息图片附件集合
     */
    List<AttachmentFinanceRequirement> selectAttachmentFinanceRequirementList(AttachmentFinanceRequirement attachmentFinanceRequirement);

    /**
     * 新增技术成果需求信息图片附件
     *
     * @param attachmentFinanceRequirement 技术成果需求信息图片附件
     * @return 结果
     */
    int insertAttachmentFinanceRequirement(AttachmentFinanceRequirement attachmentFinanceRequirement);

    /**
     * 修改技术成果需求信息图片附件
     *
     * @param attachmentFinanceRequirement 技术成果需求信息图片附件
     * @return 结果
     */
    int updateAttachmentFinanceRequirement(AttachmentFinanceRequirement attachmentFinanceRequirement);

    /**
     * 删除技术成果需求信息图片附件
     *
     * @param id 技术成果需求信息图片附件ID
     * @return 结果
     */
    int deleteAttachmentFinanceRequirementById(Long id);

    /**
     * 批量删除技术成果需求信息图片附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentFinanceRequirementByIds(String[] ids);
}