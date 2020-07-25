package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.park.domain.AttachmentTalentTrain;
import com.netintech.park.mapper.AttachmentTalentTrainMapper;
import com.netintech.park.service.IAttachmentTalentTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人才培训信息图片附件Service业务层处理
 *
 * @author admin
 * @date 2020-07-19
 */
@Service
public class AttachmentTalentTrainServiceImpl implements IAttachmentTalentTrainService
{
    @Autowired
    private AttachmentTalentTrainMapper attachmentTalentTrainMapper;

    /**
     * 查询人才培训信息图片附件
     *
     * @param id 人才培训信息图片附件ID
     * @return 人才培训信息图片附件
     */
    @Override
    public AttachmentTalentTrain selectAttachmentTalentTrainById(Long id)
    {
        return attachmentTalentTrainMapper.selectAttachmentTalentTrainById(id);
    }

    /**
     * 查询人才培训信息图片附件列表
     *
     * @param attachmentTalentTrain 人才培训信息图片附件
     * @return 人才培训信息图片附件
     */
    @Override
    public List<AttachmentTalentTrain> selectAttachmentTalentTrainList(AttachmentTalentTrain attachmentTalentTrain)
    {
        return attachmentTalentTrainMapper.selectAttachmentTalentTrainList(attachmentTalentTrain);
    }

    /**
     * 新增人才培训信息图片附件
     *
     * @param attachmentTalentTrain 人才培训信息图片附件
     * @return 结果
     */
    @Override
    public int insertAttachmentTalentTrain(AttachmentTalentTrain attachmentTalentTrain)
    {
        attachmentTalentTrain.setCreateBy(ShiroUtils.getUserStringId());
        attachmentTalentTrain.setCreateTime(DateUtils.getNowDate());
        return attachmentTalentTrainMapper.insertAttachmentTalentTrain(attachmentTalentTrain);
    }

    /**
     * 修改人才培训信息图片附件
     *
     * @param attachmentTalentTrain 人才培训信息图片附件
     * @return 结果
     */
    @Override
    public int updateAttachmentTalentTrain(AttachmentTalentTrain attachmentTalentTrain)
    {
        attachmentTalentTrain.setUpdateBy(ShiroUtils.getUserStringId());
        attachmentTalentTrain.setUpdateTime(DateUtils.getNowDate());
        return attachmentTalentTrainMapper.updateAttachmentTalentTrain(attachmentTalentTrain);
    }

    /**
     * 删除人才培训信息图片附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentTalentTrainByIds(String ids)
    {
        return attachmentTalentTrainMapper.deleteAttachmentTalentTrainByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人才培训信息图片附件信息
     *
     * @param id 人才培训信息图片附件ID
     * @return 结果
     */
    public int deleteAttachmentTalentTrainById(Long id)
    {
        return attachmentTalentTrainMapper.deleteAttachmentTalentTrainById(id);
    }
}