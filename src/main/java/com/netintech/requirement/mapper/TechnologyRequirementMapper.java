package com.netintech.requirement.mapper;

import com.netintech.requirement.domain.TechnologyRequirement;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 技术需求信息Mapper接口
 *
 * @author admin
 * @date 2020-06-19
 */
public interface TechnologyRequirementMapper
{
    /**
     * 查询技术需求信息
     *
     * @param id 技术需求信息ID
     * @return 技术需求信息
     */
    TechnologyRequirement selectTechnologyRequirementById(Long id);

    /**
     * 查询技术需求信息列表
     *
     * @param technologyRequirement 技术需求信息
     * @return 技术需求信息集合
     */
    List<TechnologyRequirement> selectTechnologyRequirementList(TechnologyRequirement technologyRequirement);

    /**
     * 新增技术需求信息
     *
     * @param technologyRequirement 技术需求信息
     * @return 结果
     */
    int insertTechnologyRequirement(TechnologyRequirement technologyRequirement);

    /**
     * 修改技术需求信息
     *
     * @param technologyRequirement 技术需求信息
     * @return 结果
     */
    int updateTechnologyRequirement(TechnologyRequirement technologyRequirement);

    /**
     * 删除技术需求信息
     *
     * @param id 技术需求信息ID
     * @return 结果
     */
    int deleteTechnologyRequirementById(Long id);

    /**
     * 批量删除技术需求信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTechnologyRequirementByIds(String[] ids);

    /**
     * 修改状态
     * **/
    @Update("update sys_technology_requirement set status = #{status} where id=#{id}")
    int updateTechnologyRequirementStatus(Long id,String status);
}
