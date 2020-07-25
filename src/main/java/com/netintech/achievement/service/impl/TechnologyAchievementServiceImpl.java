package com.netintech.achievement.service.impl;


import com.netintech.achievement.domain.TechnologyAchievement;
import com.netintech.achievement.mapper.TechnologyAchievementMapper;
import com.netintech.achievement.service.IAttachmentTechnologyAchievementService;
import com.netintech.achievement.service.ITechnologyAchievementService;
import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.project.system.dept.domain.Dept;
import com.netintech.project.system.dept.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 技术成果信息Service业务层处理
 *
 * @author admin
 * @date 2020-06-17
 */
@Service
public class TechnologyAchievementServiceImpl implements ITechnologyAchievementService {
    @Autowired
    private TechnologyAchievementMapper technologyAchievementMapper;
    @Autowired
    private IAttachmentTechnologyAchievementService attachmentTechnologyAchievementService;
    @Autowired
    private IDeptService deptService;
    /**
     * 查询技术成果信息
     *
     * @param id 技术成果信息ID
     * @return 技术成果信息
     */
    @Override
    public TechnologyAchievement selectTechnologyAchievementById(Long id) {
        return technologyAchievementMapper.selectTechnologyAchievementById(id);
    }

    /**
     * 查询技术成果信息列表
     *
     * @param technologyAchievement 技术成果信息
     * @return 技术成果信息
     */
    @Override
    public List<TechnologyAchievement> selectTechnologyAchievementList(TechnologyAchievement technologyAchievement) {
        return technologyAchievementMapper.selectTechnologyAchievementList(technologyAchievement);
    }

    /**
     * 新增技术成果信息
     *
     * @param technologyAchievement 技术成果信息
     * @return 结果
     */
    @Override
    public int insertTechnologyAchievement(TechnologyAchievement technologyAchievement) {
        technologyAchievement.setStatus("0");
        Long deptId = ShiroUtils.getSysUser().getDeptId();
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        Dept dept = deptService.selectDeptById(priseId);
        Long parentId = dept.getParentId();
        technologyAchievement.setEnterpriseId(priseId);
        technologyAchievement.setParkId(parentId);
        technologyAchievement.setCreateBy(ShiroUtils.getUserStringId());
        technologyAchievement.setCreateTime(DateUtils.getNowDate());
        int i = technologyAchievementMapper.insertTechnologyAchievement(technologyAchievement);

        Long achievementId = technologyAchievement.getId();
        String fileUuid = technologyAchievement.getFileUuid();
        attachmentTechnologyAchievementService.updateFileRelatedKey(achievementId,fileUuid);
        return i;
    }

    /**
     * 修改技术成果信息
     *
     * @param technologyAchievement 技术成果信息
     * @return 结果
     */
    @Override
    public int updateTechnologyAchievement(TechnologyAchievement technologyAchievement) {
        technologyAchievement.setUpdateBy(ShiroUtils.getUserStringId());
        technologyAchievement.setUpdateTime(DateUtils.getNowDate());
        int i = technologyAchievementMapper.updateTechnologyAchievement(technologyAchievement);
        Long achievementId = technologyAchievement.getId();
        String fileUuid = technologyAchievement.getFileUuid();
        attachmentTechnologyAchievementService.updateFileRelatedKey(achievementId,fileUuid);
        return i;
    }

    /**
     * 删除技术成果信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTechnologyAchievementByIds(String ids) {
        return technologyAchievementMapper.deleteTechnologyAchievementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术成果信息信息
     *
     * @param id 技术成果信息ID
     * @return 结果
     */
    public int deleteTechnologyAchievementById(Long id) {
        return technologyAchievementMapper.deleteTechnologyAchievementById(id);
    }

    @Override
    public int updateTechnologyAchievementStatus(Long id, String status) {
        return technologyAchievementMapper.updateTechnologyAchievementStatus(id, status);
    }
}
