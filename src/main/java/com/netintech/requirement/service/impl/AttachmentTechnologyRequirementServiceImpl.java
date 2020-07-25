package com.netintech.requirement.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.requirement.domain.AttachmentTechnologyRequirement;
import com.netintech.requirement.mapper.AttachmentTechnologyRequirementMapper;
import com.netintech.requirement.service.IAttachmentTechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 技术成果需求信息图片附件Service业务层处理
 *
 * @author admin
 * @date 2020-06-19
 */
@Service
public class AttachmentTechnologyRequirementServiceImpl implements IAttachmentTechnologyRequirementService
{
    @Autowired
    private AttachmentTechnologyRequirementMapper attachmentTechnologyRequirementMapper;

    /**
     * 查询技术成果需求信息图片附件
     *
     * @param id 技术成果需求信息图片附件ID
     * @return 技术成果需求信息图片附件
     */
    @Override
    public AttachmentTechnologyRequirement selectAttachmentTechnologyRequirementById(Long id)
    {
        return attachmentTechnologyRequirementMapper.selectAttachmentTechnologyRequirementById(id);
    }

    /**
     * 查询技术成果需求信息图片附件列表
     *
     * @param attachmentTechnologyRequirement 技术成果需求信息图片附件
     * @return 技术成果需求信息图片附件
     */
    @Override
    public List<AttachmentTechnologyRequirement> selectAttachmentTechnologyRequirementList(AttachmentTechnologyRequirement attachmentTechnologyRequirement)
    {
        return attachmentTechnologyRequirementMapper.selectAttachmentTechnologyRequirementList(attachmentTechnologyRequirement);
    }

    /**
     * 新增技术成果需求信息图片附件
     *
     * @param attachmentTechnologyRequirement 技术成果需求信息图片附件
     * @return 结果
     */
    @Override
    public int insertAttachmentTechnologyRequirement(AttachmentTechnologyRequirement attachmentTechnologyRequirement)
    {
                                            attachmentTechnologyRequirement.setCreateBy(ShiroUtils.getUserStringId());
                attachmentTechnologyRequirement.setCreateTime(DateUtils.getNowDate());
        return attachmentTechnologyRequirementMapper.insertAttachmentTechnologyRequirement(attachmentTechnologyRequirement);
    }

    /**
     * 修改技术成果需求信息图片附件
     *
     * @param attachmentTechnologyRequirement 技术成果需求信息图片附件
     * @return 结果
     */
    @Override
    public int updateAttachmentTechnologyRequirement(AttachmentTechnologyRequirement attachmentTechnologyRequirement)
    {
                                            attachmentTechnologyRequirement.setUpdateBy(ShiroUtils.getUserStringId());
                attachmentTechnologyRequirement.setUpdateTime(DateUtils.getNowDate());
        return attachmentTechnologyRequirementMapper.updateAttachmentTechnologyRequirement(attachmentTechnologyRequirement);
    }

    /**
     * 删除技术成果需求信息图片附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentTechnologyRequirementByIds(String ids)
    {
        return attachmentTechnologyRequirementMapper.deleteAttachmentTechnologyRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术成果需求信息图片附件信息
     *
     * @param id 技术成果需求信息图片附件ID
     * @return 结果
     */
    public int deleteAttachmentTechnologyRequirementById(Long id)
    {
        return attachmentTechnologyRequirementMapper.deleteAttachmentTechnologyRequirementById(id);
    }

    @Override
    public int updateFileRelatedKey(Long achievementId, String fileUuid) {
        return attachmentTechnologyRequirementMapper.updateFileRelatedKey(achievementId, fileUuid);
    }
}
