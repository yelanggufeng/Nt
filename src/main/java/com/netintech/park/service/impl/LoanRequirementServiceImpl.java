package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.enterprise.domain.Enterprise;
import com.netintech.enterprise.mapper.EnterpriseMapper;
import com.netintech.park.domain.AttachmentLoanRequirement;
import com.netintech.park.domain.LoanFinanceData;
import com.netintech.park.domain.LoanRequirement;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.dto.LoanRequirementDto;
import com.netintech.park.mapper.*;
import com.netintech.park.service.ILoanRequirementService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 贷款需求信息Service业务层处理
 *
 * @author admin
 * @date 2020-07-15
 */
@Service
public class LoanRequirementServiceImpl implements ILoanRequirementService
{
    @Autowired
    private LoanRequirementMapper loanRequirementMapper;
    @Autowired
    private AttachmentLoanRequirementMapper attachmentLoanRequirementMapper;

    @Autowired
    private LoanFinanceDataMapper loanFinanceDataMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmallParkMapper smallParkMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;


    /**
     * 查询所有贷款信息所有，包含了附件和贷款明细等
     * @param loanRequirement
     * @return
     */
    public List<LoanRequirementDto> findAll(LoanRequirement loanRequirement){

        List<LoanRequirementDto> loanRequirements = loanRequirementMapper.findByLoanRequirement(loanRequirement);
        loanRequirements.forEach(requirement ->{
            User user = userMapper.selectUserById(Long.valueOf(requirement.getCreateBy()));
            if (null !=user){
                requirement.setUser(user);
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

        return loanRequirements;
    }


    /**
     * 查询贷款需求信息
     *
     * @param id 贷款需求信息ID
     * @return 贷款需求信息
     */
    @Override
    public LoanRequirement selectLoanRequirementById(Long id)
    {
        return loanRequirementMapper.selectLoanRequirementById(id);
    }

    /**
     * 查询贷款需求信息列表
     *
     * @param loanRequirement 贷款需求信息
     * @return 贷款需求信息
     */
    @Override
    public List<LoanRequirement> selectLoanRequirementList(LoanRequirement loanRequirement)
    {
        return loanRequirementMapper.selectLoanRequirementList(loanRequirement);
    }

    /**
     * 新增贷款需求信息
     *
     * @param loanRequirement 贷款需求信息
     * @return 结果
     */
    @Override
    public int insertLoanRequirement(LoanRequirement loanRequirement)
    {
        loanRequirement.setCreateBy(ShiroUtils.getUserStringId());
        loanRequirement.setCreateTime(DateUtils.getNowDate());
        return loanRequirementMapper.insertLoanRequirement(loanRequirement);
    }

    /**
     * 修改贷款需求信息
     *
     * @param loanRequirement 贷款需求信息
     * @return 结果
     */
    @Override
    public int updateLoanRequirement(LoanRequirement loanRequirement)
    {
        loanRequirement.setUpdateBy(ShiroUtils.getUserStringId());
        loanRequirement.setUpdateTime(DateUtils.getNowDate());
        return loanRequirementMapper.updateLoanRequirement(loanRequirement);
    }

    /**
     * 删除贷款需求信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLoanRequirementByIds(String ids)
    {
        return loanRequirementMapper.deleteLoanRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除贷款需求信息信息
     *
     * @param id 贷款需求信息ID
     * @return 结果
     */
    public int deleteLoanRequirementById(Long id)
    {
        return loanRequirementMapper.deleteLoanRequirementById(id);
    }
}