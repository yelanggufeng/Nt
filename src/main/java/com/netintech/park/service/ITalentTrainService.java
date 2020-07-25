package com.netintech.park.service;

import com.netintech.park.domain.TalentTrain;
import com.netintech.park.domain.dto.TalentTrainDto;

import java.util.List;

/**
 * 人才培训信息Service接口
 *
 * @author admin
 * @date 2020-07-17
 */
public interface ITalentTrainService
{
    List<TalentTrainDto> findAll(TalentTrain talentTrain);
    /**
     * 查询人才培训信息
     *
     * @param id 人才培训信息ID
     * @return 人才培训信息
     */
    TalentTrain selectTalentTrainById(Long id);

    /**
     * 查询人才培训信息列表
     *
     * @param talentTrain 人才培训信息
     * @return 人才培训信息集合
     */
    List<TalentTrain> selectTalentTrainList(TalentTrain talentTrain);

    /**
     * 新增人才培训信息
     *
     * @param talentTrain 人才培训信息
     * @return 结果
     */
    int insertTalentTrain(TalentTrain talentTrain);

    /**
     * 修改人才培训信息
     *
     * @param talentTrain 人才培训信息
     * @return 结果
     */
    int updateTalentTrain(TalentTrain talentTrain);

    /**
     * 批量删除人才培训信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTalentTrainByIds(String ids);

    /**
     * 删除人才培训信息信息
     *
     * @param id 人才培训信息ID
     * @return 结果
     */
    int deleteTalentTrainById(Long id);
}