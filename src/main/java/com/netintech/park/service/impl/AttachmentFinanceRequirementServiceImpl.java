package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.park.domain.AttachmentFinanceRequirement;
import com.netintech.park.mapper.AttachmentFinanceRequirementMapper;
import com.netintech.park.service.IAttachmentFinanceRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 融资需求信息表图片附件Service业务层处理
 *
 * @author admin
 * @date 2020-07-16
 */
@Service
public class AttachmentFinanceRequirementServiceImpl implements IAttachmentFinanceRequirementService
{
    @Autowired
    private AttachmentFinanceRequirementMapper attachmentFinanceRequirementMapper;

    /**
     * 查询技术成果需求信息图片附件
     *
     * @param id 技术成果需求信息图片附件ID
     * @return 技术成果需求信息图片附件
     */
    @Override
    public AttachmentFinanceRequirement selectAttachmentFinanceRequirementById(Long id)
    {
        return attachmentFinanceRequirementMapper.selectAttachmentFinanceRequirementById(id);
    }

    /**
     * 查询技术成果需求信息图片附件列表
     *
     * @param attachmentFinanceRequirement 技术成果需求信息图片附件
     * @return 技术成果需求信息图片附件
     */
    @Override
    public List<AttachmentFinanceRequirement> selectAttachmentFinanceRequirementList(AttachmentFinanceRequirement attachmentFinanceRequirement)
    {
        return attachmentFinanceRequirementMapper.selectAttachmentFinanceRequirementList(attachmentFinanceRequirement);
    }

    /**
     * 新增技术成果需求信息图片附件
     *
     * @param attachmentFinanceRequirement 技术成果需求信息图片附件
     * @return 结果
     */
    @Override
    public int insertAttachmentFinanceRequirement(AttachmentFinanceRequirement attachmentFinanceRequirement)
    {
        attachmentFinanceRequirement.setCreateBy(ShiroUtils.getUserStringId());
        attachmentFinanceRequirement.setCreateTime(DateUtils.getNowDate());
        return attachmentFinanceRequirementMapper.insertAttachmentFinanceRequirement(attachmentFinanceRequirement);
    }

    /**
     * 修改技术成果需求信息图片附件
     *
     * @param attachmentFinanceRequirement 技术成果需求信息图片附件
     * @return 结果
     */
    @Override
    public int updateAttachmentFinanceRequirement(AttachmentFinanceRequirement attachmentFinanceRequirement)
    {
        attachmentFinanceRequirement.setUpdateBy(ShiroUtils.getUserStringId());
        attachmentFinanceRequirement.setUpdateTime(DateUtils.getNowDate());
        return attachmentFinanceRequirementMapper.updateAttachmentFinanceRequirement(attachmentFinanceRequirement);
    }

    /**
     * 删除技术成果需求信息图片附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentFinanceRequirementByIds(String ids)
    {
        return attachmentFinanceRequirementMapper.deleteAttachmentFinanceRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术成果需求信息图片附件信息
     *
     * @param id 技术成果需求信息图片附件ID
     * @return 结果
     */
    public int deleteAttachmentFinanceRequirementById(Long id)
    {
        return attachmentFinanceRequirementMapper.deleteAttachmentFinanceRequirementById(id);
    }
}