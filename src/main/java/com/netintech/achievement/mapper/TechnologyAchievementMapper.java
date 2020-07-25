package com.netintech.achievement.mapper;

import com.netintech.achievement.domain.TechnologyAchievement;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 技术成果信息Mapper接口
 *
 * @author admin
 * @date 2020-06-17
 */
public interface TechnologyAchievementMapper
{
    /**
     * 查询技术成果信息
     *
     * @param id 技术成果信息ID
     * @return 技术成果信息
     */
    TechnologyAchievement selectTechnologyAchievementById(Long id);

    /**
     * 查询技术成果信息列表
     *
     * @param technologyAchievement 技术成果信息
     * @return 技术成果信息集合
     */
    List<TechnologyAchievement> selectTechnologyAchievementList(TechnologyAchievement technologyAchievement);

    /**
     * 新增技术成果信息
     *
     * @param technologyAchievement 技术成果信息
     * @return 结果
     */
    int insertTechnologyAchievement(TechnologyAchievement technologyAchievement);

    /**
     * 修改技术成果信息
     *
     * @param technologyAchievement 技术成果信息
     * @return 结果
     */
    int updateTechnologyAchievement(TechnologyAchievement technologyAchievement);

    /**
     * 删除技术成果信息
     *
     * @param id 技术成果信息ID
     * @return 结果
     */
    int deleteTechnologyAchievementById(Long id);

    /**
     * 批量删除技术成果信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTechnologyAchievementByIds(String[] ids);

    /**
     * 修改状态
     * **/
    @Update("update sys_technology_achievement set status = #{status} where id=#{id}")
    int updateTechnologyAchievementStatus(Long id,String status);
}
