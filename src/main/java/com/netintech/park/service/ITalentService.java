package com.netintech.park.service;

import com.netintech.park.domain.Talent;
import com.netintech.park.domain.dto.AttachmentTalentDto;

import java.util.List;

/**
 * 人才信息Service接口
 *
 * @author admin
 * @date 2020-07-17
 */
public interface ITalentService
{
    /**
     * 查询所有人才信息
     * @param talent
     * @return
     */
    List<AttachmentTalentDto> findAll(Talent talent);

    AttachmentTalentDto ListTalentById(Long id);
    /**
     * 查询人才信息
     *
     * @param id 人才信息ID
     * @return 人才信息
     */
    Talent selectTalentById(Long id);

    /**
     * 查询人才信息列表
     *
     * @param talent 人才信息
     * @return 人才信息集合
     */
    List<Talent> selectTalentList(Talent talent);

    /**
     * 新增人才信息
     *
     * @param talent 人才信息
     * @return 结果
     */
    int insertTalent(Talent talent);

    /**
     * 修改人才信息
     *
     * @param talent 人才信息
     * @return 结果
     */
    int updateTalent(Talent talent);

    /**
     * 批量删除人才信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTalentByIds(String ids);

    /**
     * 删除人才信息信息
     *
     * @param id 人才信息ID
     * @return 结果
     */
    int deleteTalentById(Long id);
}