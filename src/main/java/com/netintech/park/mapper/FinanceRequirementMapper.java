package com.netintech.park.mapper;

import com.netintech.park.domain.FinanceRequirement;
import com.netintech.park.domain.dto.FinanceRequirementDto;

import java.util.List;

/**
 * 融资需求信息Mapper接口
 *
 * @author ltc
 * @date 2020-07-15
 */
public interface FinanceRequirementMapper {

    List<FinanceRequirementDto> selectListFinanceRequirement(FinanceRequirement financeRequirement);
    /**
     * 查询融资需求信息
     *
     * @param id 融资需求信息ID
     * @return 融资需求信息
     */
    FinanceRequirement selectFinanceRequirementById(Long id);

    /**
     * 查询融资需求信息列表
     *
     * @param financeRequirement 融资需求信息
     * @return 融资需求信息集合
     */
    List<FinanceRequirement> selectFinanceRequirementList(FinanceRequirement financeRequirement);

    /**
     * 新增融资需求信息
     *
     * @param financeRequirement 融资需求信息
     * @return 结果
     */
    int insertFinanceRequirement(FinanceRequirement financeRequirement);

    /**
     * 修改融资需求信息
     *
     * @param financeRequirement 融资需求信息
     * @return 结果
     */
    int updateFinanceRequirement(FinanceRequirement financeRequirement);

    /**
     * 删除融资需求信息
     *
     * @param id 融资需求信息ID
     * @return 结果
     */
    int deleteFinanceRequirementById(Long id);

    /**
     * 批量删除融资需求信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteFinanceRequirementByIds(String[] ids);
}
