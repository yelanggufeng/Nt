package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.StringUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.enterprise.domain.Enterprise;
import com.netintech.enterprise.mapper.EnterpriseMapper;
import com.netintech.park.domain.FinanceRequirement;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.dto.FinanceRequirementDto;
import com.netintech.park.mapper.AttachmentFinanceRequirementMapper;
import com.netintech.park.mapper.FinanceRequirementMapper;
import com.netintech.park.mapper.SmallParkMapper;
import com.netintech.park.service.IFinanceRequirementService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 融资需求信息Service业务层处理
 *
 * @author ltc
 * @date 2020-07-15
 */
@Service
public class FinanceRequirementServiceImpl implements IFinanceRequirementService {
    @Autowired
    private FinanceRequirementMapper financeRequirementMapper;

    @Autowired
    private AttachmentFinanceRequirementMapper attachmentFinanceRequirementMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmallParkMapper smallParkMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;


    public List<FinanceRequirementDto> findAll(FinanceRequirement financeRequirement){
        List<FinanceRequirementDto> listFinanceRequirement = financeRequirementMapper.selectListFinanceRequirement(financeRequirement);
        listFinanceRequirement.forEach(requirement ->{
            if (StringUtils.isNotEmpty(requirement.getCreateBy())){
                User user = userMapper.selectUserById(Long.valueOf(requirement.getCreateBy()));
                if (null !=user){
                    requirement.setUser(user);
                }
            }

            SmallPark smallPark = smallParkMapper.selectSmallParkById(requirement.getParkId());
            if (null !=smallPark){
                requirement.setSmallPark(smallPark);
            }
            Enterprise enterprise = enterpriseMapper.selectEnterpriseById(requirement.getEnterpriseId());
            if (null !=enterprise){
                requirement.setEnterprise(enterprise);
            }
        });

        return listFinanceRequirement;
    }


    /**
     * 查询融资需求信息
     *
     * @param id 融资需求信息ID
     * @return 融资需求信息
     */
    @Override
    public FinanceRequirement selectFinanceRequirementById(Long id)
    {
        return financeRequirementMapper.selectFinanceRequirementById(id);
    }

    /**
     * 查询融资需求信息列表
     *
     * @param financeRequirement 融资需求信息
     * @return 融资需求信息
     */
    @Override
    public List<FinanceRequirement> selectFinanceRequirementList(FinanceRequirement financeRequirement)
    {
        return financeRequirementMapper.selectFinanceRequirementList(financeRequirement);
    }

    /**
     * 新增融资需求信息
     *
     * @param financeRequirement 融资需求信息
     * @return 结果
     */
    @Override
    public int insertFinanceRequirement(FinanceRequirement financeRequirement)
    {
        financeRequirement.setCreateBy(ShiroUtils.getUserStringId());
        financeRequirement.setCreateTime(DateUtils.getNowDate());
        return financeRequirementMapper.insertFinanceRequirement(financeRequirement);
    }

    /**
     * 修改融资需求信息
     *
     * @param financeRequirement 融资需求信息
     * @return 结果
     */
    @Override
    public int updateFinanceRequirement(FinanceRequirement financeRequirement)
    {
        financeRequirement.setUpdateBy(ShiroUtils.getUserStringId());
        financeRequirement.setUpdateTime(DateUtils.getNowDate());
        return financeRequirementMapper.updateFinanceRequirement(financeRequirement);
    }

    /**
     * 删除融资需求信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFinanceRequirementByIds(String ids)
    {
        return financeRequirementMapper.deleteFinanceRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除融资需求信息信息
     *
     * @param id 融资需求信息ID
     * @return 结果
     */
    public int deleteFinanceRequirementById(Long id)
    {
        return financeRequirementMapper.deleteFinanceRequirementById(id);
    }
}
