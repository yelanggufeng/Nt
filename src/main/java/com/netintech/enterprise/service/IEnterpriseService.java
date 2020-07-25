package com.netintech.enterprise.service;

import com.netintech.enterprise.domain.Enterprise;
import com.netintech.project.system.user.domain.User;

import java.util.List;

/**
 * 企业信息Service接口
 * 
 * @author admin
 * @date 2020-04-17
 */
public interface IEnterpriseService 
{
    /**
     * 查询企业信息
     * 
     * @param id 企业信息ID
     * @return 企业信息
     */
    Enterprise selectEnterpriseById(Long id);

    /**
     * 查询企业信息列表
     * 
     * @param enterprise 企业信息
     * @return 企业信息集合
     */
    List<Enterprise> selectEnterpriseList(Enterprise enterprise);

    /**
     * 新增企业信息
     * 
     * @param enterprise 企业信息
     * @return 结果
     */
    int insertEnterprise(Enterprise enterprise);

    /**
     * 修改企业信息
     * 
     * @param enterprise 企业信息
     * @return 结果
     */
    int updateEnterprise(Enterprise enterprise);

    /**
     * 批量删除企业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteEnterpriseByIds(String ids);

    /**
     * 删除企业信息信息
     * 
     * @param id 企业信息ID
     * @return 结果
     */
    int deleteEnterpriseById(Long id);

    String checkEnterpriseNameUnique(Enterprise enterprise);

    void updateDeptNamebyName(Enterprise enterprise);

    int selectUserById(Long valueOf);

    String getSmallNameById(Long smallId);

    Long getEnterpriseId(Long deptId);
}
