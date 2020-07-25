package com.netintech.achievement.service.impl;

import com.netintech.achievement.domain.AttachmentTechnologyAchievement;
import com.netintech.achievement.mapper.AttachmentTechnologyAchievementMapper;
import com.netintech.achievement.service.IAttachmentTechnologyAchievementService;
import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 技术成果信息图片附件Service业务层处理
 *
 * @author admin
 * @date 2020-06-17
 */
@Service
public class AttachmentTechnologyAchievementServiceImpl implements IAttachmentTechnologyAchievementService
{
    @Autowired
    private AttachmentTechnologyAchievementMapper attachmentTechnologyAchievementMapper;

    /**
     * 查询技术成果信息图片附件
     *
     * @param id 技术成果信息图片附件ID
     * @return 技术成果信息图片附件
     */
    @Override
    public AttachmentTechnologyAchievement selectAttachmentTechnologyAchievementById(Long id)
    {
        return attachmentTechnologyAchievementMapper.selectAttachmentTechnologyAchievementById(id);
    }

    /**
     * 查询技术成果信息图片附件列表
     *
     * @param attachmentTechnologyAchievement 技术成果信息图片附件
     * @return 技术成果信息图片附件
     */
    @Override
    public List<AttachmentTechnologyAchievement> selectAttachmentTechnologyAchievementList(AttachmentTechnologyAchievement attachmentTechnologyAchievement)
    {
        return attachmentTechnologyAchievementMapper.selectAttachmentTechnologyAchievementList(attachmentTechnologyAchievement);
    }

    /**
     * 新增技术成果信息图片附件
     *
     * @param attachmentTechnologyAchievement 技术成果信息图片附件
     * @return 结果
     */
    @Override
    public int insertAttachmentTechnologyAchievement(AttachmentTechnologyAchievement attachmentTechnologyAchievement)
    {
                                        attachmentTechnologyAchievement.setCreateBy(ShiroUtils.getUserStringId());
                attachmentTechnologyAchievement.setCreateTime(DateUtils.getNowDate());
        return attachmentTechnologyAchievementMapper.insertAttachmentTechnologyAchievement(attachmentTechnologyAchievement);
    }

    /**
     * 修改技术成果信息图片附件
     *
     * @param attachmentTechnologyAchievement 技术成果信息图片附件
     * @return 结果
     */
    @Override
    public int updateAttachmentTechnologyAchievement(AttachmentTechnologyAchievement attachmentTechnologyAchievement)
    {
                                        attachmentTechnologyAchievement.setUpdateBy(ShiroUtils.getUserStringId());
                attachmentTechnologyAchievement.setUpdateTime(DateUtils.getNowDate());
        return attachmentTechnologyAchievementMapper.updateAttachmentTechnologyAchievement(attachmentTechnologyAchievement);
    }

    /**
     * 删除技术成果信息图片附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentTechnologyAchievementByIds(String ids)
    {
        return attachmentTechnologyAchievementMapper.deleteAttachmentTechnologyAchievementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术成果信息图片附件信息
     *
     * @param id 技术成果信息图片附件ID
     * @return 结果
     */
    public int deleteAttachmentTechnologyAchievementById(Long id)
    {
        return attachmentTechnologyAchievementMapper.deleteAttachmentTechnologyAchievementById(id);
    }

    @Override
    public int updateFileRelatedKey(Long achievementId, String fileUuid) {
        return attachmentTechnologyAchievementMapper.updateFileRelatedKey(achievementId,fileUuid);
    }
}
