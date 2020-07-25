package com.netintech.park.service;

import com.netintech.park.domain.LoanRequirement;
import com.netintech.park.domain.dto.LoanRequirementDto;

import java.util.List;

/**
 * 贷款需求信息Service接口
 *
 * @author admin
 * @date 2020-07-15
 */
public interface ILoanRequirementService
{
    List<LoanRequirementDto> findAll(LoanRequirement loanRequirement);
    /**
     * 查询贷款需求信息
     *
     * @param id 贷款需求信息ID
     * @return 贷款需求信息
     */
    LoanRequirement selectLoanRequirementById(Long id);

    /**
     * 查询贷款需求信息列表
     *
     * @param loanRequirement 贷款需求信息
     * @return 贷款需求信息集合
     */
    List<LoanRequirement> selectLoanRequirementList(LoanRequirement loanRequirement);

    /**
     * 新增贷款需求信息
     *
     * @param loanRequirement 贷款需求信息
     * @return 结果
     */
    int insertLoanRequirement(LoanRequirement loanRequirement);

    /**
     * 修改贷款需求信息
     *
     * @param loanRequirement 贷款需求信息
     * @return 结果
     */
    int updateLoanRequirement(LoanRequirement loanRequirement);

    /**
     * 批量删除贷款需求信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLoanRequirementByIds(String ids);

    /**
     * 删除贷款需求信息信息
     *
     * @param id 贷款需求信息ID
     * @return 结果
     */
    int deleteLoanRequirementById(Long id);
}