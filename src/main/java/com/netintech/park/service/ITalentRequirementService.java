package com.netintech.park.service;

import com.netintech.park.domain.TalentRequirement;
import com.netintech.park.domain.dto.TalentRequirementDto;

import java.util.List;

/**
 * 人才需求信息Service接口
 *
 * @author admin
 * @date 2020-07-17
 */
public interface ITalentRequirementService
{

     List<TalentRequirementDto> findAll(TalentRequirement talentRequirement);
     TalentRequirementDto findById(Long id);
    /**
     * 查询人才需求信息
     *
     * @param id 人才需求信息ID
     * @return 人才需求信息
     */
    TalentRequirement selectTalentRequirementById(Long id);

    /**
     * 查询人才需求信息列表
     *
     * @param talentRequirement 人才需求信息
     * @return 人才需求信息集合
     */
    List<TalentRequirement> selectTalentRequirementList(TalentRequirement talentRequirement);

    /**
     * 新增人才需求信息
     *
     * @param talentRequirement 人才需求信息
     * @return 结果
     */
    int insertTalentRequirement(TalentRequirement talentRequirement);

    /**
     * 修改人才需求信息
     *
     * @param talentRequirement 人才需求信息
     * @return 结果
     */
    int updateTalentRequirement(TalentRequirement talentRequirement);

    /**
     * 批量删除人才需求信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTalentRequirementByIds(String ids);

    /**
     * 删除人才需求信息信息
     *
     * @param id 人才需求信息ID
     * @return 结果
     */
    int deleteTalentRequirementById(Long id);
}