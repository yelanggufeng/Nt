package com.netintech.park.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.park.domain.LoanFinanceData;
import com.netintech.park.mapper.LoanFinanceDataMapper;
import com.netintech.park.service.ILoanFinanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 贷款需求财务信息Service业务层处理
 *
 * @author ltc
 * @date 2020-07-15
 */
@Service
public class LoanFinanceDataServiceImpl implements ILoanFinanceDataService
{
    @Autowired
    private LoanFinanceDataMapper loanFinanceDataMapper;

    /**
     * 查询贷款需求财务信息
     *
     * @param id 贷款需求财务信息ID
     * @return 贷款需求财务信息
     */
    @Override
    public LoanFinanceData selectLoanFinanceDataById(Long id)
    {
        return loanFinanceDataMapper.selectLoanFinanceDataById(id);
    }

    /**
     * 查询贷款需求财务信息列表
     *
     * @param loanFinanceData 贷款需求财务信息
     * @return 贷款需求财务信息
     */
    @Override
    public List<LoanFinanceData> selectLoanFinanceDataList(LoanFinanceData loanFinanceData)
    {
        return loanFinanceDataMapper.selectLoanFinanceDataList(loanFinanceData);
    }

    /**
     * 新增贷款需求财务信息
     *
     * @param loanFinanceData 贷款需求财务信息
     * @return 结果
     */
    @Override
    public int insertLoanFinanceData(LoanFinanceData loanFinanceData)
    {
        loanFinanceData.setCreateBy(ShiroUtils.getUserStringId());
        loanFinanceData.setCreateTime(DateUtils.getNowDate());
        return loanFinanceDataMapper.insertLoanFinanceData(loanFinanceData);
    }

    /**
     * 修改贷款需求财务信息
     *
     * @param loanFinanceData 贷款需求财务信息
     * @return 结果
     */
    @Override
    public int updateLoanFinanceData(LoanFinanceData loanFinanceData)
    {
        loanFinanceData.setUpdateBy(ShiroUtils.getUserStringId());
        loanFinanceData.setUpdateTime(DateUtils.getNowDate());
        return loanFinanceDataMapper.updateLoanFinanceData(loanFinanceData);
    }

    /**
     * 删除贷款需求财务信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLoanFinanceDataByIds(String ids)
    {
        return loanFinanceDataMapper.deleteLoanFinanceDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除贷款需求财务信息信息
     *
     * @param id 贷款需求财务信息ID
     * @return 结果
     */
    public int deleteLoanFinanceDataById(Long id)
    {
        return loanFinanceDataMapper.deleteLoanFinanceDataById(id);
    }
}