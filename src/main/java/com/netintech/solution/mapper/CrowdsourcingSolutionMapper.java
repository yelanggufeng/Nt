package com.netintech.solution.mapper;

import com.netintech.solution.domain.CrowdsourcingSolution;

import java.util.List;

/**
 * 创新众包解决方案信息Mapper接口
 *
 * @author admin
 * @date 2020-06-22
 */
public interface CrowdsourcingSolutionMapper
{
    /**
     * 查询创新众包解决方案信息
     *
     * @param id 创新众包解决方案信息ID
     * @return 创新众包解决方案信息
     */
    CrowdsourcingSolution selectCrowdsourcingSolutionById(Long id);

    /**
     * 查询创新众包解决方案信息列表
     *
     * @param crowdsourcingSolution 创新众包解决方案信息
     * @return 创新众包解决方案信息集合
     */
    List<CrowdsourcingSolution> selectCrowdsourcingSolutionList(CrowdsourcingSolution crowdsourcingSolution);

    /**
     * 新增创新众包解决方案信息
     *
     * @param crowdsourcingSolution 创新众包解决方案信息
     * @return 结果
     */
    int insertCrowdsourcingSolution(CrowdsourcingSolution crowdsourcingSolution);

    /**
     * 修改创新众包解决方案信息
     *
     * @param crowdsourcingSolution 创新众包解决方案信息
     * @return 结果
     */
    int updateCrowdsourcingSolution(CrowdsourcingSolution crowdsourcingSolution);

    /**
     * 删除创新众包解决方案信息
     *
     * @param id 创新众包解决方案信息ID
     * @return 结果
     */
    int deleteCrowdsourcingSolutionById(Long id);

    /**
     * 批量删除创新众包解决方案信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteCrowdsourcingSolutionByIds(String[] ids);
}
