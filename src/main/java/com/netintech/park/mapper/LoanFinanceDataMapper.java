package com.netintech.park.mapper;

import com.netintech.park.domain.LoanFinanceData;

import java.util.List;

/**
 * 贷款需求财务信息Mapper接口
 *
 * @author ltc
 * @date 2020-07-15
 */
public interface LoanFinanceDataMapper
{
    /**
     * 查询贷款需求财务信息
     *
     * @param id 贷款需求财务信息ID
     * @return 贷款需求财务信息
     */
    LoanFinanceData selectLoanFinanceDataById(Long id);

    /**
     * 查询贷款需求财务信息列表
     *
     * @param loanFinanceData 贷款需求财务信息
     * @return 贷款需求财务信息集合
     */
    List<LoanFinanceData> selectLoanFinanceDataList(LoanFinanceData loanFinanceData);

    /**
     * 新增贷款需求财务信息
     *
     * @param loanFinanceData 贷款需求财务信息
     * @return 结果
     */
    int insertLoanFinanceData(LoanFinanceData loanFinanceData);

    /**
     * 修改贷款需求财务信息
     *
     * @param loanFinanceData 贷款需求财务信息
     * @return 结果
     */
    int updateLoanFinanceData(LoanFinanceData loanFinanceData);

    /**
     * 删除贷款需求财务信息
     *
     * @param id 贷款需求财务信息ID
     * @return 结果
     */
    int deleteLoanFinanceDataById(Long id);

    /**
     * 批量删除贷款需求财务信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLoanFinanceDataByIds(String[] ids);
}