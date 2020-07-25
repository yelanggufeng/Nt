package com.netintech.requirement.mapper;

import com.netintech.requirement.domain.CrowdsourcingRequirement;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 创新众包需求信息Mapper接口
 *
 * @author admin
 * @date 2020-06-19
 */
public interface CrowdsourcingRequirementMapper
{
    /**
     * 查询创新众包需求信息
     *
     * @param id 创新众包需求信息ID
     * @return 创新众包需求信息
     */
    CrowdsourcingRequirement selectCrowdsourcingRequirementById(Long id);

    /**
     * 查询创新众包需求信息列表
     *
     * @param crowdsourcingRequirement 创新众包需求信息
     * @return 创新众包需求信息集合
     */
    List<CrowdsourcingRequirement> selectCrowdsourcingRequirementList(CrowdsourcingRequirement crowdsourcingRequirement);

    /**
     * 新增创新众包需求信息
     *
     * @param crowdsourcingRequirement 创新众包需求信息
     * @return 结果
     */
    int insertCrowdsourcingRequirement(CrowdsourcingRequirement crowdsourcingRequirement);

    /**
     * 修改创新众包需求信息
     *
     * @param crowdsourcingRequirement 创新众包需求信息
     * @return 结果
     */
    int updateCrowdsourcingRequirement(CrowdsourcingRequirement crowdsourcingRequirement);

    /**
     * 删除创新众包需求信息
     *
     * @param id 创新众包需求信息ID
     * @return 结果
     */
    int deleteCrowdsourcingRequirementById(Long id);

    /**
     * 批量删除创新众包需求信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCrowdsourcingRequirementByIds(String[] ids);

    /**
     * 修改状态
     * **/
    @Update("update sys_crowdsourcing_requirement set status = #{status} where id=#{id}")
    int updateCrowdsourcingRequirementStatus(Long id,String status);

    @Update("update sys_crowdsourcing_requirement set result = #{result} where id=#{id}")
    int updateCrowdsourcingRequirementResult(Long id,String result);

    List<CrowdsourcingRequirement> selectMyParticipateList(CrowdsourcingRequirement crowdsourcingRequirement);

}
