package com.netintech.enterprise.mapper;

import com.netintech.enterprise.domain.EnterpriseBenefit;

import java.util.List;

/**
 * 企业效益信息Mapper接口
 *
 * @author admin
 * @date 2020-05-09
 */
public interface EnterpriseBenefitMapper {
    /**
     * 查询企业效益信息
     *
     * @param id 企业效益信息ID
     * @return 企业效益信息
     */
    EnterpriseBenefit selectEnterpriseBenefitById(Long id);

    /**
     * 查询企业效益信息列表
     *
     * @param enterpriseBenefit 企业效益信息
     * @return 企业效益信息集合
     */
    List<EnterpriseBenefit> selectEnterpriseBenefitList(EnterpriseBenefit enterpriseBenefit);

    /**
     * 新增企业效益信息
     *
     * @param enterpriseBenefit 企业效益信息
     * @return 结果
     */
    int insertEnterpriseBenefit(EnterpriseBenefit enterpriseBenefit);

    /**
     * 修改企业效益信息
     *
     * @param enterpriseBenefit 企业效益信息
     * @return 结果
     */
    int updateEnterpriseBenefit(EnterpriseBenefit enterpriseBenefit);

    /**
     * 删除企业效益信息
     *
     * @param id 企业效益信息ID
     * @return 结果
     */
    int deleteEnterpriseBenefitById(Long id);

    /**
     * 批量删除企业效益信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteEnterpriseBenefitByIds(String[] ids);

    int checkExit(EnterpriseBenefit benefit);
}
