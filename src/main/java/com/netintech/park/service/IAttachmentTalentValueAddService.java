package com.netintech.park.service;

import com.netintech.park.domain.AttachmentTalentValueAdd;

import java.util.List;

/**
 * 人才增值服务信息图片附件Service接口
 *
 * @author admin
 * @date 2020-07-17
 */
public interface IAttachmentTalentValueAddService
{
    /**
     * 查询人才增值服务信息图片附件
     *
     * @param id 人才增值服务信息图片附件ID
     * @return 人才增值服务信息图片附件
     */
    AttachmentTalentValueAdd selectAttachmentTalentValueAddById(Long id);

    /**
     * 查询人才增值服务信息图片附件列表
     *
     * @param attachmentTalentValueAdd 人才增值服务信息图片附件
     * @return 人才增值服务信息图片附件集合
     */
    List<AttachmentTalentValueAdd> selectAttachmentTalentValueAddList(AttachmentTalentValueAdd attachmentTalentValueAdd);

    /**
     * 新增人才增值服务信息图片附件
     *
     * @param attachmentTalentValueAdd 人才增值服务信息图片附件
     * @return 结果
     */
    int insertAttachmentTalentValueAdd(AttachmentTalentValueAdd attachmentTalentValueAdd);

    /**
     * 修改人才增值服务信息图片附件
     *
     * @param attachmentTalentValueAdd 人才增值服务信息图片附件
     * @return 结果
     */
    int updateAttachmentTalentValueAdd(AttachmentTalentValueAdd attachmentTalentValueAdd);

    /**
     * 批量删除人才增值服务信息图片附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentTalentValueAddByIds(String ids);

    /**
     * 删除人才增值服务信息图片附件信息
     *
     * @param id 人才增值服务信息图片附件ID
     * @return 结果
     */
    int deleteAttachmentTalentValueAddById(Long id);
}