package com.netintech.park.mapper;

import com.netintech.park.domain.SmallParkInvest;

import java.util.List;

/**
 * 小微园投资额信息Mapper接口
 *
 * @author admin
 * @date 2020-06-18
 */
public interface SmallParkInvestMapper
{
    /**
     * 查询小微园投资额信息
     *
     * @param id 小微园投资额信息ID
     * @return 小微园投资额信息
     */
    SmallParkInvest selectSmallParkInvestById(Long id);

    /**
     * 查询小微园投资额信息列表
     *
     * @param smallParkInvest 小微园投资额信息
     * @return 小微园投资额信息集合
     */
    List<SmallParkInvest> selectSmallParkInvestList(SmallParkInvest smallParkInvest);

    /**
     * 新增小微园投资额信息
     *
     * @param smallParkInvest 小微园投资额信息
     * @return 结果
     */
    int insertSmallParkInvest(SmallParkInvest smallParkInvest);

    /**
     * 修改小微园投资额信息
     *
     * @param smallParkInvest 小微园投资额信息
     * @return 结果
     */
    int updateSmallParkInvest(SmallParkInvest smallParkInvest);

    /**
     * 删除小微园投资额信息
     *
     * @param id 小微园投资额信息ID
     * @return 结果
     */
    int deleteSmallParkInvestById(Long id);

    /**
     * 批量删除小微园投资额信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSmallParkInvestByIds(String[] ids);

    int checkExit(SmallParkInvest smallParkInvest);
}
