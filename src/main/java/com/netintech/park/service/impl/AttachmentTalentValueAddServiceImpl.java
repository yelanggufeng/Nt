package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.park.domain.AttachmentTalentValueAdd;
import com.netintech.park.mapper.AttachmentTalentValueAddMapper;
import com.netintech.park.service.IAttachmentTalentValueAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人才增值服务信息图片附件Service业务层处理
 *
 * @author admin
 * @date 2020-07-17
 */
@Service
public class AttachmentTalentValueAddServiceImpl implements IAttachmentTalentValueAddService
{
    @Autowired
    private AttachmentTalentValueAddMapper attachmentTalentValueAddMapper;

    /**
     * 查询人才增值服务信息图片附件
     *
     * @param id 人才增值服务信息图片附件ID
     * @return 人才增值服务信息图片附件
     */
    @Override
    public AttachmentTalentValueAdd selectAttachmentTalentValueAddById(Long id)
    {
        return attachmentTalentValueAddMapper.selectAttachmentTalentValueAddById(id);
    }

    /**
     * 查询人才增值服务信息图片附件列表
     *
     * @param attachmentTalentValueAdd 人才增值服务信息图片附件
     * @return 人才增值服务信息图片附件
     */
    @Override
    public List<AttachmentTalentValueAdd> selectAttachmentTalentValueAddList(AttachmentTalentValueAdd attachmentTalentValueAdd)
    {
        return attachmentTalentValueAddMapper.selectAttachmentTalentValueAddList(attachmentTalentValueAdd);
    }

    /**
     * 新增人才增值服务信息图片附件
     *
     * @param attachmentTalentValueAdd 人才增值服务信息图片附件
     * @return 结果
     */
    @Override
    public int insertAttachmentTalentValueAdd(AttachmentTalentValueAdd attachmentTalentValueAdd)
    {
        attachmentTalentValueAdd.setCreateBy(ShiroUtils.getUserStringId());
        attachmentTalentValueAdd.setCreateTime(DateUtils.getNowDate());
        return attachmentTalentValueAddMapper.insertAttachmentTalentValueAdd(attachmentTalentValueAdd);
    }

    /**
     * 修改人才增值服务信息图片附件
     *
     * @param attachmentTalentValueAdd 人才增值服务信息图片附件
     * @return 结果
     */
    @Override
    public int updateAttachmentTalentValueAdd(AttachmentTalentValueAdd attachmentTalentValueAdd)
    {
        attachmentTalentValueAdd.setUpdateBy(ShiroUtils.getUserStringId());
        attachmentTalentValueAdd.setUpdateTime(DateUtils.getNowDate());
        return attachmentTalentValueAddMapper.updateAttachmentTalentValueAdd(attachmentTalentValueAdd);
    }

    /**
     * 删除人才增值服务信息图片附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentTalentValueAddByIds(String ids)
    {
        return attachmentTalentValueAddMapper.deleteAttachmentTalentValueAddByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人才增值服务信息图片附件信息
     *
     * @param id 人才增值服务信息图片附件ID
     * @return 结果
     */
    public int deleteAttachmentTalentValueAddById(Long id)
    {
        return attachmentTalentValueAddMapper.deleteAttachmentTalentValueAddById(id);
    }
}