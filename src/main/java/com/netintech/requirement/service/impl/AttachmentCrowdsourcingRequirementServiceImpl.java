package com.netintech.requirement.service.impl;


import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.requirement.domain.AttachmentCrowdsourcingRequirement;
import com.netintech.requirement.mapper.AttachmentCrowdsourcingRequirementMapper;
import com.netintech.requirement.service.IAttachmentCrowdsourcingRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创新众包需求信息图片附件Service业务层处理
 *
 * @author admin
 * @date 2020-06-19
 */
@Service
public class AttachmentCrowdsourcingRequirementServiceImpl implements IAttachmentCrowdsourcingRequirementService
{
    @Autowired
    private AttachmentCrowdsourcingRequirementMapper attachmentCrowdsourcingRequirementMapper;

    /**
     * 查询创新众包需求信息图片附件
     *
     * @param id 创新众包需求信息图片附件ID
     * @return 创新众包需求信息图片附件
     */
    @Override
    public AttachmentCrowdsourcingRequirement selectAttachmentCrowdsourcingRequirementById(Long id)
    {
        return attachmentCrowdsourcingRequirementMapper.selectAttachmentCrowdsourcingRequirementById(id);
    }

    /**
     * 查询创新众包需求信息图片附件列表
     *
     * @param attachmentCrowdsourcingRequirement 创新众包需求信息图片附件
     * @return 创新众包需求信息图片附件
     */
    @Override
    public List<AttachmentCrowdsourcingRequirement> selectAttachmentCrowdsourcingRequirementList(AttachmentCrowdsourcingRequirement attachmentCrowdsourcingRequirement)
    {
        return attachmentCrowdsourcingRequirementMapper.selectAttachmentCrowdsourcingRequirementList(attachmentCrowdsourcingRequirement);
    }

    /**
     * 新增创新众包需求信息图片附件
     *
     * @param attachmentCrowdsourcingRequirement 创新众包需求信息图片附件
     * @return 结果
     */
    @Override
    public int insertAttachmentCrowdsourcingRequirement(AttachmentCrowdsourcingRequirement attachmentCrowdsourcingRequirement)
    {
                                        attachmentCrowdsourcingRequirement.setCreateBy(ShiroUtils.getUserStringId());
                attachmentCrowdsourcingRequirement.setCreateTime(DateUtils.getNowDate());
        return attachmentCrowdsourcingRequirementMapper.insertAttachmentCrowdsourcingRequirement(attachmentCrowdsourcingRequirement);
    }

    /**
     * 修改创新众包需求信息图片附件
     *
     * @param attachmentCrowdsourcingRequirement 创新众包需求信息图片附件
     * @return 结果
     */
    @Override
    public int updateAttachmentCrowdsourcingRequirement(AttachmentCrowdsourcingRequirement attachmentCrowdsourcingRequirement)
    {
                                        attachmentCrowdsourcingRequirement.setUpdateBy(ShiroUtils.getUserStringId());
                attachmentCrowdsourcingRequirement.setUpdateTime(DateUtils.getNowDate());
        return attachmentCrowdsourcingRequirementMapper.updateAttachmentCrowdsourcingRequirement(attachmentCrowdsourcingRequirement);
    }

    /**
     * 删除创新众包需求信息图片附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentCrowdsourcingRequirementByIds(String ids)
    {
        return attachmentCrowdsourcingRequirementMapper.deleteAttachmentCrowdsourcingRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除创新众包需求信息图片附件信息
     *
     * @param id 创新众包需求信息图片附件ID
     * @return 结果
     */
    public int deleteAttachmentCrowdsourcingRequirementById(Long id)
    {
        return attachmentCrowdsourcingRequirementMapper.deleteAttachmentCrowdsourcingRequirementById(id);
    }

    @Override
    public int updateFileRelatedKey(Long requirementId, String fileUuid) {
        return attachmentCrowdsourcingRequirementMapper.updateFileRelatedKey(requirementId, fileUuid);
    }
}
