package com.netintech.park.service.impl;


import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.StringUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.enterprise.domain.Enterprise;
import com.netintech.enterprise.mapper.EnterpriseMapper;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.TalentValueAdd;
import com.netintech.park.domain.dto.TalentValueAddDto;
import com.netintech.park.mapper.SmallParkMapper;
import com.netintech.park.mapper.TalentValueAddMapper;
import com.netintech.park.service.ITalentValueAddService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人才增值服务信息Service业务层处理
 *
 * @author admin
 * @date 2020-07-17
 */
@Service
public class TalentValueAddServiceImpl implements ITalentValueAddService
{
    @Autowired
    private TalentValueAddMapper talentValueAddMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmallParkMapper smallParkMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public TalentValueAddDto findById(Long id) {
        return talentValueAddMapper.findById(id);
    }

    @Override
    public List<TalentValueAddDto> findAll(TalentValueAdd talentValueAdd) {


        List<TalentValueAddDto> talentRequirements = talentValueAddMapper.findAll(talentValueAdd);

        talentRequirements.forEach(talent ->{
            if (StringUtils.isNotEmpty(talent.getCreateBy())){
                User user = userMapper.selectUserById(Long.valueOf(talent.getCreateBy()));
                if (null !=user){
                    talent.setUser(user);
                }
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
     * 查询人才增值服务信息
     *
     * @param id 人才增值服务信息ID
     * @return 人才增值服务信息
     */
    @Override
    public TalentValueAdd selectTalentValueAddById(Long id)
    {
        return talentValueAddMapper.selectTalentValueAddById(id);
    }

    /**
     * 查询人才增值服务信息列表
     *
     * @param talentValueAdd 人才增值服务信息
     * @return 人才增值服务信息
     */
    @Override
    public List<TalentValueAdd> selectTalentValueAddList(TalentValueAdd talentValueAdd)
    {
        return talentValueAddMapper.selectTalentValueAddList(talentValueAdd);
    }

    /**
     * 新增人才增值服务信息
     *
     * @param talentValueAdd 人才增值服务信息
     * @return 结果
     */
    @Override
    public int insertTalentValueAdd(TalentValueAdd talentValueAdd)
    {
        talentValueAdd.setCreateBy(ShiroUtils.getUserStringId());
        talentValueAdd.setCreateTime(DateUtils.getNowDate());
        return talentValueAddMapper.insertTalentValueAdd(talentValueAdd);
    }

    /**
     * 修改人才增值服务信息
     *
     * @param talentValueAdd 人才增值服务信息
     * @return 结果
     */
    @Override
    public int updateTalentValueAdd(TalentValueAdd talentValueAdd)
    {
        talentValueAdd.setUpdateBy(ShiroUtils.getUserStringId());
        talentValueAdd.setUpdateTime(DateUtils.getNowDate());
        return talentValueAddMapper.updateTalentValueAdd(talentValueAdd);
    }

    /**
     * 删除人才增值服务信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTalentValueAddByIds(String ids)
    {
        return talentValueAddMapper.deleteTalentValueAddByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人才增值服务信息信息
     *
     * @param id 人才增值服务信息ID
     * @return 结果
     */
    public int deleteTalentValueAddById(Long id)
    {
        return talentValueAddMapper.deleteTalentValueAddById(id);
    }
}