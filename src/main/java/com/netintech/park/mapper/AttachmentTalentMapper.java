package com.netintech.park.mapper;

import com.netintech.park.domain.AttachmentTalent;

import java.util.List;

/**
 * 人才信息图片附件Mapper接口
 *
 * @author admin
 * @date 2020-07-17
 */
public interface AttachmentTalentMapper
{
    /**
     * 查询人才信息图片附件
     *
     * @param id 人才信息图片附件ID
     * @return 人才信息图片附件
     */
    AttachmentTalent selectAttachmentTalentById(Long id);

    /**
     * 查询人才信息图片附件列表
     *
     * @param attachmentTalent 人才信息图片附件
     * @return 人才信息图片附件集合
     */
    List<AttachmentTalent> selectAttachmentTalentList(AttachmentTalent attachmentTalent);

    /**
     * 新增人才信息图片附件
     *
     * @param attachmentTalent 人才信息图片附件
     * @return 结果
     */
    int insertAttachmentTalent(AttachmentTalent attachmentTalent);

    /**
     * 修改人才信息图片附件
     *
     * @param attachmentTalent 人才信息图片附件
     * @return 结果
     */
    int updateAttachmentTalent(AttachmentTalent attachmentTalent);

    /**
     * 删除人才信息图片附件
     *
     * @param id 人才信息图片附件ID
     * @return 结果
     */
    int deleteAttachmentTalentById(Long id);

    /**
     * 批量删除人才信息图片附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentTalentByIds(String[] ids);
}