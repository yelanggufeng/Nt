package com.netintech.park.service;

import com.netintech.park.domain.SmallParkInvest;

import java.util.List;

/**
 * 小微园投资额信息Service接口
 *
 * @author admin
 * @date 2020-06-18
 */
public interface ISmallParkInvestService
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
     * 批量删除小微园投资额信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSmallParkInvestByIds(String ids);

    /**
     * 删除小微园投资额信息信息
     *
     * @param id 小微园投资额信息ID
     * @return 结果
     */
    int deleteSmallParkInvestById(Long id);

    boolean checkExit(SmallParkInvest smallParkInvest);
}
