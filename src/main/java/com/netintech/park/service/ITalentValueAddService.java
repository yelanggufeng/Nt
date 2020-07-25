package com.netintech.park.service;

import com.netintech.park.domain.TalentValueAdd;
import com.netintech.park.domain.dto.TalentValueAddDto;

import java.util.List;

/**
 * 人才增值服务信息Service接口
 *
 * @author admin
 * @date 2020-07-17
 */
public interface ITalentValueAddService
{


    /**
     * 查询人才增值服务信息
     *
     * @param id 人才增值服务信息ID
     * @return 人才增值服务信息
     */
    TalentValueAddDto findById(Long id);

    /**
     * 查询人才增值服务信息列表
     *
     * @param talentValueAdd 人才增值服务信息
     * @return 人才增值服务信息集合
     */
    List<TalentValueAddDto> findAll(TalentValueAdd talentValueAdd);

    /**
     * 查询人才增值服务信息
     *
     * @param id 人才增值服务信息ID
     * @return 人才增值服务信息
     */
    TalentValueAdd selectTalentValueAddById(Long id);

    /**
     * 查询人才增值服务信息列表
     *
     * @param talentValueAdd 人才增值服务信息
     * @return 人才增值服务信息集合
     */
    List<TalentValueAdd> selectTalentValueAddList(TalentValueAdd talentValueAdd);

    /**
     * 新增人才增值服务信息
     *
     * @param talentValueAdd 人才增值服务信息
     * @return 结果
     */
    int insertTalentValueAdd(TalentValueAdd talentValueAdd);

    /**
     * 修改人才增值服务信息
     *
     * @param talentValueAdd 人才增值服务信息
     * @return 结果
     */
    int updateTalentValueAdd(TalentValueAdd talentValueAdd);

    /**
     * 批量删除人才增值服务信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTalentValueAddByIds(String ids);

    /**
     * 删除人才增值服务信息信息
     *
     * @param id 人才增值服务信息ID
     * @return 结果
     */
    int deleteTalentValueAddById(Long id);
}