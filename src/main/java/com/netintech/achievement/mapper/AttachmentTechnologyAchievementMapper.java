package com.netintech.achievement.mapper;


import com.netintech.achievement.domain.AttachmentTechnologyAchievement;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 技术成果信息图片附件Mapper接口
 *
 * @author admin
 * @date 2020-06-17
 */
public interface AttachmentTechnologyAchievementMapper
{
    /**
     * 查询技术成果信息图片附件
     *
     * @param id 技术成果信息图片附件ID
     * @return 技术成果信息图片附件
     */
    AttachmentTechnologyAchievement selectAttachmentTechnologyAchievementById(Long id);

    /**
     * 查询技术成果信息图片附件列表
     *
     * @param attachmentTechnologyAchievement 技术成果信息图片附件
     * @return 技术成果信息图片附件集合
     */
    List<AttachmentTechnologyAchievement> selectAttachmentTechnologyAchievementList(AttachmentTechnologyAchievement attachmentTechnologyAchievement);

    /**
     * 新增技术成果信息图片附件
     *
     * @param attachmentTechnologyAchievement 技术成果信息图片附件
     * @return 结果
     */
    int insertAttachmentTechnologyAchievement(AttachmentTechnologyAchievement attachmentTechnologyAchievement);

    /**
     * 修改技术成果信息图片附件
     *
     * @param attachmentTechnologyAchievement 技术成果信息图片附件
     * @return 结果
     */
    int updateAttachmentTechnologyAchievement(AttachmentTechnologyAchievement attachmentTechnologyAchievement);

    /**
     * 删除技术成果信息图片附件
     *
     * @param id 技术成果信息图片附件ID
     * @return 结果
     */
    int deleteAttachmentTechnologyAchievementById(Long id);

    /**
     * 批量删除技术成果信息图片附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentTechnologyAchievementByIds(String[] ids);

    @Update("update attachment_technology_achievement set achievement_id = #{achievementId} where file_uuid = #{fileUuid}")
    int updateFileRelatedKey(Long achievementId, String fileUuid);
}
