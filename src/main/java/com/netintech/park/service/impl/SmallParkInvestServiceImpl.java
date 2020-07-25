package com.netintech.park.service.impl;

import java.util.List;
import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.park.domain.SmallParkInvest;
import com.netintech.park.mapper.SmallParkInvestMapper;
import com.netintech.park.service.ISmallParkInvestService;
import com.netintech.park.service.ISmallParkService;
import com.netintech.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netintech.common.utils.text.Convert;

/**
 * 小微园投资额信息Service业务层处理
 *
 * @author admin
 * @date 2020-06-18
 */
@Service
public class SmallParkInvestServiceImpl implements ISmallParkInvestService
{
    @Autowired
    private SmallParkInvestMapper smallParkInvestMapper;

    @Autowired
    private ISmallParkService smallParkService;

    /**
     * 查询小微园投资额信息
     *
     * @param id 小微园投资额信息ID
     * @return 小微园投资额信息
     */
    @Override
    public SmallParkInvest selectSmallParkInvestById(Long id)
    {
        return smallParkInvestMapper.selectSmallParkInvestById(id);
    }

    /**
     * 查询小微园投资额信息列表
     *
     * @param smallParkInvest 小微园投资额信息
     * @return 小微园投资额信息
     */
    @Override
    public List<SmallParkInvest> selectSmallParkInvestList(SmallParkInvest smallParkInvest)
    {
        User user = ShiroUtils.getSysUser();
        smallParkInvest.setSmallId(smallParkService.getParkId(user.getDeptId()));
        return smallParkInvestMapper.selectSmallParkInvestList(smallParkInvest);
    }

    /**
     * 新增小微园投资额信息
     *
     * @param smallParkInvest 小微园投资额信息
     * @return 结果
     */
    @Override
    public int insertSmallParkInvest(SmallParkInvest smallParkInvest)
    {
        User user = ShiroUtils.getSysUser();
        smallParkInvest.setCreateBy(String.valueOf(user.getUserId()));
        smallParkInvest.setCreateTime(DateUtils.getNowDate());
        smallParkInvest.setSmallId(smallParkService.getParkId(user.getDeptId()));
        return smallParkInvestMapper.insertSmallParkInvest(smallParkInvest);
    }

    /**
     * 修改小微园投资额信息
     *
     * @param smallParkInvest 小微园投资额信息
     * @return 结果
     */
    @Override
    public int updateSmallParkInvest(SmallParkInvest smallParkInvest)
    {
        smallParkInvest.setUpdateTime(DateUtils.getNowDate());
        return smallParkInvestMapper.updateSmallParkInvest(smallParkInvest);
    }

    /**
     * 删除小微园投资额信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSmallParkInvestByIds(String ids)
    {
        return smallParkInvestMapper.deleteSmallParkInvestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小微园投资额信息信息
     *
     * @param id 小微园投资额信息ID
     * @return 结果
     */
    @Override
    public int deleteSmallParkInvestById(Long id)
    {
        return smallParkInvestMapper.deleteSmallParkInvestById(id);
    }


    @Override
    public boolean checkExit(SmallParkInvest smallParkInvest) {
        if (smallParkInvestMapper.checkExit(smallParkInvest)>0) {
            return true;
        }
        return false;
    }
}
