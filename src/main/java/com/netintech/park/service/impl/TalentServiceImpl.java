package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.park.domain.Talent;
import com.netintech.park.domain.dto.AttachmentTalentDto;
import com.netintech.park.mapper.TalentMapper;
import com.netintech.park.service.ITalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人才信息Service业务层处理
 *
 * @author admin
 * @date 2020-07-17
 */
@Service
public class TalentServiceImpl implements ITalentService
{
    @Autowired
    private TalentMapper talentMapper;

    /**
     * 查询所有人才信息
     * @param talent
     * @return
     */
    @Override
    public List<AttachmentTalentDto> findAll(Talent talent) {
        List<AttachmentTalentDto> list=talentMapper.ListTalent(talent);
        return list;
    }

    @Override
    public AttachmentTalentDto ListTalentById(Long id) {
        return talentMapper.ListTalentById(id);
    }


    /**
     * 查询人才信息
     *
     * @param id 人才信息ID
     * @return 人才信息
     */
    @Override
    public Talent selectTalentById(Long id)
    {
        return talentMapper.selectTalentById(id);
    }

    /**
     * 查询人才信息列表
     *
     * @param talent 人才信息
     * @return 人才信息
     */
    @Override
    public List<Talent> selectTalentList(Talent talent)
    {
        return talentMapper.selectTalentList(talent);
    }

    /**
     * 新增人才信息
     *
     * @param talent 人才信息
     * @return 结果
     */
    @Override
    public int insertTalent(Talent talent)
    {
        talent.setCreateBy(ShiroUtils.getUserStringId());
        talent.setCreateTime(DateUtils.getNowDate());
        return talentMapper.insertTalent(talent);
    }

    /**
     * 修改人才信息
     *
     * @param talent 人才信息
     * @return 结果
     */
    @Override
    public int updateTalent(Talent talent)
    {
        talent.setUpdateBy(ShiroUtils.getUserStringId());
        talent.setUpdateTime(DateUtils.getNowDate());
        return talentMapper.updateTalent(talent);
    }

    /**
     * 删除人才信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTalentByIds(String ids)
    {
        return talentMapper.deleteTalentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人才信息信息
     *
     * @param id 人才信息ID
     * @return 结果
     */
    public int deleteTalentById(Long id)
    {
        return talentMapper.deleteTalentById(id);
    }
}