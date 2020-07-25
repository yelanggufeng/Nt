package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.park.domain.AttachmentLoanRequirement;
import com.netintech.park.mapper.AttachmentLoanRequirementMapper;
import com.netintech.park.service.IAttachmentLoanRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 贷款需求信息附件Service业务层处理
 *
 * @author ltc
 * @date 2020-07-15
 */
@Service
public class AttachmentLoanRequirementServiceImpl implements IAttachmentLoanRequirementService
{
    @Autowired
    private AttachmentLoanRequirementMapper attachmentLoanRequirementMapper;

    /**
     * 查询贷款需求信息附件
     *
     * @param id 贷款需求信息附件ID
     * @return 贷款需求信息附件
     */
    @Override
    public AttachmentLoanRequirement selectAttachmentLoanRequirementById(Long id)
    {
        return attachmentLoanRequirementMapper.selectAttachmentLoanRequirementById(id);
    }

    /**
     * 查询贷款需求信息附件列表
     *
     * @param attachmentLoanRequirement 贷款需求信息附件
     * @return 贷款需求信息附件
     */
    @Override
    public List<AttachmentLoanRequirement> selectAttachmentLoanRequirementList(AttachmentLoanRequirement attachmentLoanRequirement)
    {
        return attachmentLoanRequirementMapper.selectAttachmentLoanRequirementList(attachmentLoanRequirement);
    }

    /**
     * 新增贷款需求信息附件
     *
     * @param attachmentLoanRequirement 贷款需求信息附件
     * @return 结果
     */
    @Override
    public int insertAttachmentLoanRequirement(AttachmentLoanRequirement attachmentLoanRequirement)
    {
        attachmentLoanRequirement.setCreateBy(ShiroUtils.getUserStringId());
        attachmentLoanRequirement.setCreateTime(DateUtils.getNowDate());
        return attachmentLoanRequirementMapper.insertAttachmentLoanRequirement(attachmentLoanRequirement);
    }

    /**
     * 修改贷款需求信息附件
     *
     * @param attachmentLoanRequirement 贷款需求信息附件
     * @return 结果
     */
    @Override
    public int updateAttachmentLoanRequirement(AttachmentLoanRequirement attachmentLoanRequirement)
    {
        attachmentLoanRequirement.setUpdateBy(ShiroUtils.getUserStringId());
        attachmentLoanRequirement.setUpdateTime(DateUtils.getNowDate());
        return attachmentLoanRequirementMapper.updateAttachmentLoanRequirement(attachmentLoanRequirement);
    }

    /**
     * 删除贷款需求信息附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentLoanRequirementByIds(String ids)
    {
        return attachmentLoanRequirementMapper.deleteAttachmentLoanRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除贷款需求信息附件信息
     *
     * @param id 贷款需求信息附件ID
     * @return 结果
     */
    public int deleteAttachmentLoanRequirementById(Long id)
    {
        return attachmentLoanRequirementMapper.deleteAttachmentLoanRequirementById(id);
    }
}