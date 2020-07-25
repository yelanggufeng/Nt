package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.StringUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.enterprise.domain.Enterprise;
import com.netintech.enterprise.mapper.EnterpriseMapper;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.TalentTrain;
import com.netintech.park.domain.dto.TalentTrainDto;
import com.netintech.park.domain.dto.TalentValueAddDto;
import com.netintech.park.mapper.SmallParkMapper;
import com.netintech.park.mapper.TalentTrainMapper;
import com.netintech.park.service.ITalentTrainService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人才培训信息Service业务层处理
 *
 * @author admin
 * @date 2020-07-17
 */
@Service
public class TalentTrainServiceImpl implements ITalentTrainService
{
    @Autowired
    private TalentTrainMapper talentTrainMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmallParkMapper smallParkMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    /**
     * 查询人才培训列表
     * @param talentTrain
     * @return
     */
    @Override
    public List<TalentTrainDto> findAll(TalentTrain talentTrain) {
        List<TalentTrainDto> all = talentTrainMapper.findAll(talentTrain);

        all.forEach(talent ->{
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
        return all;
    }

    /**
     * 查询人才培训信息
     *
     * @param id 人才培训信息ID
     * @return 人才培训信息
     */
    @Override
    public TalentTrain selectTalentTrainById(Long id)
    {
        return talentTrainMapper.selectTalentTrainById(id);
    }

    /**
     * 查询人才培训信息列表
     *
     * @param talentTrain 人才培训信息
     * @return 人才培训信息
     */
    @Override
    public List<TalentTrain> selectTalentTrainList(TalentTrain talentTrain)
    {
        return talentTrainMapper.selectTalentTrainList(talentTrain);
    }

    /**
     * 新增人才培训信息
     *
     * @param talentTrain 人才培训信息
     * @return 结果
     */
    @Override
    public int insertTalentTrain(TalentTrain talentTrain)
    {
        talentTrain.setCreateBy(ShiroUtils.getUserStringId());
        talentTrain.setCreateTime(DateUtils.getNowDate());
        return talentTrainMapper.insertTalentTrain(talentTrain);
    }

    /**
     * 修改人才培训信息
     *
     * @param talentTrain 人才培训信息
     * @return 结果
     */
    @Override
    public int updateTalentTrain(TalentTrain talentTrain)
    {
        talentTrain.setUpdateBy(ShiroUtils.getUserStringId());
        talentTrain.setUpdateTime(DateUtils.getNowDate());
        return talentTrainMapper.updateTalentTrain(talentTrain);
    }

    /**
     * 删除人才培训信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTalentTrainByIds(String ids)
    {
        return talentTrainMapper.deleteTalentTrainByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人才培训信息信息
     *
     * @param id 人才培训信息ID
     * @return 结果
     */
    public int deleteTalentTrainById(Long id)
    {
        return talentTrainMapper.deleteTalentTrainById(id);
    }
}