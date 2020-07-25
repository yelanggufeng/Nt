package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.park.domain.AttachmentTalent;
import com.netintech.park.mapper.AttachmentTalentMapper;
import com.netintech.park.service.IAttachmentTalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人才信息图片附件Service业务层处理
 *
 * @author admin
 * @date 2020-07-17
 */
@Service
public class AttachmentTalentServiceImpl implements IAttachmentTalentService
{
    @Autowired
    private AttachmentTalentMapper attachmentTalentMapper;

    /**
     * 查询人才信息图片附件
     *
     * @param id 人才信息图片附件ID
     * @return 人才信息图片附件
     */
    @Override
    public AttachmentTalent selectAttachmentTalentById(Long id)
    {
        return attachmentTalentMapper.selectAttachmentTalentById(id);
    }

    /**
     * 查询人才信息图片附件列表
     *
     * @param attachmentTalent 人才信息图片附件
     * @return 人才信息图片附件
     */
    @Override
    public List<AttachmentTalent> selectAttachmentTalentList(AttachmentTalent attachmentTalent)
    {
        return attachmentTalentMapper.selectAttachmentTalentList(attachmentTalent);
    }

    /**
     * 新增人才信息图片附件
     *
     * @param attachmentTalent 人才信息图片附件
     * @return 结果
     */
    @Override
    public int insertAttachmentTalent(AttachmentTalent attachmentTalent)
    {
        attachmentTalent.setCreateBy(ShiroUtils.getUserStringId());
        attachmentTalent.setCreateTime(DateUtils.getNowDate());
        return attachmentTalentMapper.insertAttachmentTalent(attachmentTalent);
    }

    /**
     * 修改人才信息图片附件
     *
     * @param attachmentTalent 人才信息图片附件
     * @return 结果
     */
    @Override
    public int updateAttachmentTalent(AttachmentTalent attachmentTalent)
    {
        attachmentTalent.setUpdateBy(ShiroUtils.getUserStringId());
        attachmentTalent.setUpdateTime(DateUtils.getNowDate());
        return attachmentTalentMapper.updateAttachmentTalent(attachmentTalent);
    }

    /**
     * 删除人才信息图片附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentTalentByIds(String ids)
    {
        return attachmentTalentMapper.deleteAttachmentTalentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人才信息图片附件信息
     *
     * @param id 人才信息图片附件ID
     * @return 结果
     */
    public int deleteAttachmentTalentById(Long id)
    {
        return attachmentTalentMapper.deleteAttachmentTalentById(id);
    }
}