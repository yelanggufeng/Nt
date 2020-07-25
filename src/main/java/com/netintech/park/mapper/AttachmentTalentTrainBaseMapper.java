package com.netintech.park.mapper;

import com.netintech.park.domain.AttachmentTalentTrainBase;

import java.util.List;

/**
 * 人才实训基地信息图片附件Mapper接口
 *
 * @author admin
 * @date 2020-07-17
 */
public interface AttachmentTalentTrainBaseMapper
{
    /**
     * 查询人才实训基地信息图片附件
     *
     * @param id 人才实训基地信息图片附件ID
     * @return 人才实训基地信息图片附件
     */
    AttachmentTalentTrainBase selectAttachmentTalentTrainBaseById(Long id);

    /**
     * 查询人才实训基地信息图片附件列表
     *
     * @param attachmentTalentTrainBase 人才实训基地信息图片附件
     * @return 人才实训基地信息图片附件集合
     */
    List<AttachmentTalentTrainBase> selectAttachmentTalentTrainBaseList(AttachmentTalentTrainBase attachmentTalentTrainBase);

    /**
     * 新增人才实训基地信息图片附件
     *
     * @param attachmentTalentTrainBase 人才实训基地信息图片附件
     * @return 结果
     */
    int insertAttachmentTalentTrainBase(AttachmentTalentTrainBase attachmentTalentTrainBase);

    /**
     * 修改人才实训基地信息图片附件
     *
     * @param attachmentTalentTrainBase 人才实训基地信息图片附件
     * @return 结果
     */
    int updateAttachmentTalentTrainBase(AttachmentTalentTrainBase attachmentTalentTrainBase);

    /**
     * 删除人才实训基地信息图片附件
     *
     * @param id 人才实训基地信息图片附件ID
     * @return 结果
     */
    int deleteAttachmentTalentTrainBaseById(Long id);

    /**
     * 批量删除人才实训基地信息图片附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentTalentTrainBaseByIds(String[] ids);
}