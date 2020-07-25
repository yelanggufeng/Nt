package com.netintech.park.service;

import com.netintech.park.domain.AttachmentTalentTrain;

import java.util.List;

/**
 * 人才培训信息图片附件Service接口
 *
 * @author admin
 * @date 2020-07-19
 */
public interface IAttachmentTalentTrainService
{
    /**
     * 查询人才培训信息图片附件
     *
     * @param id 人才培训信息图片附件ID
     * @return 人才培训信息图片附件
     */
    AttachmentTalentTrain selectAttachmentTalentTrainById(Long id);

    /**
     * 查询人才培训信息图片附件列表
     *
     * @param attachmentTalentTrain 人才培训信息图片附件
     * @return 人才培训信息图片附件集合
     */
    List<AttachmentTalentTrain> selectAttachmentTalentTrainList(AttachmentTalentTrain attachmentTalentTrain);

    /**
     * 新增人才培训信息图片附件
     *
     * @param attachmentTalentTrain 人才培训信息图片附件
     * @return 结果
     */
    int insertAttachmentTalentTrain(AttachmentTalentTrain attachmentTalentTrain);

    /**
     * 修改人才培训信息图片附件
     *
     * @param attachmentTalentTrain 人才培训信息图片附件
     * @return 结果
     */
    int updateAttachmentTalentTrain(AttachmentTalentTrain attachmentTalentTrain);

    /**
     * 批量删除人才培训信息图片附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentTalentTrainByIds(String ids);

    /**
     * 删除人才培训信息图片附件信息
     *
     * @param id 人才培训信息图片附件ID
     * @return 结果
     */
    int deleteAttachmentTalentTrainById(Long id);
}