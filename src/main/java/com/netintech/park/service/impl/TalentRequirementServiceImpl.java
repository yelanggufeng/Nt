package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.enterprise.domain.Enterprise;
import com.netintech.enterprise.mapper.EnterpriseMapper;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.TalentRequirement;
import com.netintech.park.domain.dto.TalentRequirementDto;
import com.netintech.park.mapper.SmallParkMapper;
import com.netintech.park.mapper.TalentRequirementMapper;
import com.netintech.park.service.ITalentRequirementService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人才需求信息Service业务层处理
 *
 * @author admin
 * @date 2020-07-17
 */
@Service
public class TalentRequirementServiceImpl implements ITalentRequirementService
{
    @Autowired
    private TalentRequirementMapper talentRequirementMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmallParkMapper smallParkMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    /**
     * 查询列表
     * @param talentRequirement
     * @return
     */
    public  List<TalentRequirementDto> findAll(TalentRequirement talentRequirement){
        List<TalentRequirementDto> talentRequirements = talentRequirementMapper.findAll(talentRequirement);
        talentRequirements.forEach(talent ->{
            User user = userMapper.selectUserById(Long.valueOf(talent.getCreateBy()));
            if (null !=user){
                talent.setUser(user);
            }
            SmallPark smallPark = smallParkMapper.selectSmallParkById(talent.getParkId());
            if (null !=smallPark){
                talent.setSmallPark(smallPark);
            }
            Enterprise enterprise = enterpriseMapper.selectEnterpriseById(talent.getEnterpriseId());
            if (null !=enterprise){
                talent.setEnterprise(enterprise);
            }
        });
        return talentRequirements;
    }

    /**
     * 查询详情
     * @param id
     * @return
     */
    public  TalentRequirementDto findById(Long id){
       return talentRequirementMapper.findById(id);
    }


    /**
     * 查询人才需求信息
     *
     * @param id 人才需求信息ID
     * @return 人才需求信息
     */
    @Override
    public TalentRequirement selectTalentRequirementById(Long id)
    {
        return talentRequirementMapper.selectTalentRequirementById(id);
    }

    /**
     * 查询人才需求信息列表
     *
     * @param talentRequirement 人才需求信息
     * @return 人才需求信息
     */
    @Override
    public List<TalentRequirement> selectTalentRequirementList(TalentRequirement talentRequirement)
    {
        return talentRequirementMapper.selectTalentRequirementList(talentRequirement);
    }

    /**
     * 新增人才需求信息
     *
     * @param talentRequirement 人才需求信息
     * @return 结果
     */
    @Override
    public int insertTalentRequirement(TalentRequirement talentRequirement)
    {
        talentRequirement.setCreateBy(ShiroUtils.getUserStringId());
        talentRequirement.setCreateTime(DateUtils.getNowDate());
        return talentRequirementMapper.insertTalentRequirement(talentRequirement);
    }

    /**
     * 修改人才需求信息
     *
     * @param talentRequirement 人才需求信息
     * @return 结果
     */
    @Override
    public int updateTalentRequirement(TalentRequirement talentRequirement)
    {
        talentRequirement.setUpdateBy(ShiroUtils.getUserStringId());
        talentRequirement.setUpdateTime(DateUtils.getNowDate());
        return talentRequirementMapper.updateTalentRequirement(talentRequirement);
    }

    /**
     * 删除人才需求信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTalentRequirementByIds(String ids)
    {
        return talentRequirementMapper.deleteTalentRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人才需求信息信息
     *
     * @param id 人才需求信息ID
     * @return 结果
     */
    public int deleteTalentRequirementById(Long id)
    {
        return talentRequirementMapper.deleteTalentRequirementById(id);
    }
}