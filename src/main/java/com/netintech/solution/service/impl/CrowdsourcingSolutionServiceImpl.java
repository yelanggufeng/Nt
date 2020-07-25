package com.netintech.solution.service.impl;


import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.solution.domain.CrowdsourcingSolution;
import com.netintech.solution.mapper.CrowdsourcingSolutionMapper;
import com.netintech.solution.service.ICrowdsourcingSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创新众包解决方案信息Service业务层处理
 *
 * @author admin
 * @date 2020-06-22
 */
@Service
public class CrowdsourcingSolutionServiceImpl implements ICrowdsourcingSolutionService
{
    @Autowired
    private CrowdsourcingSolutionMapper crowdsourcingSolutionMapper;

    /**
     * 查询创新众包解决方案信息
     *
     * @param id 创新众包解决方案信息ID
     * @return 创新众包解决方案信息
     */
    @Override
    public CrowdsourcingSolution selectCrowdsourcingSolutionById(Long id)
    {
        return crowdsourcingSolutionMapper.selectCrowdsourcingSolutionById(id);
    }

    /**
     * 查询创新众包解决方案信息列表
     *
     * @param crowdsourcingSolution 创新众包解决方案信息
     * @return 创新众包解决方案信息
     */
    @Override
    public List<CrowdsourcingSolution> selectCrowdsourcingSolutionList(CrowdsourcingSolution crowdsourcingSolution)
    {
        return crowdsourcingSolutionMapper.selectCrowdsourcingSolutionList(crowdsourcingSolution);
    }

    /**
     * 新增创新众包解决方案信息
     *
     * @param crowdsourcingSolution 创新众包解决方案信息
     * @return 结果
     */
    @Override
    public int insertCrowdsourcingSolution(CrowdsourcingSolution crowdsourcingSolution)
    {
                                                crowdsourcingSolution.setCreateBy(ShiroUtils.getUserStringId());
                crowdsourcingSolution.setCreateTime(DateUtils.getNowDate());
                return crowdsourcingSolutionMapper.insertCrowdsourcingSolution(crowdsourcingSolution);
    }

    /**
     * 修改创新众包解决方案信息
     *
     * @param crowdsourcingSolution 创新众包解决方案信息
     * @return 结果
     */
    @Override
    public int updateCrowdsourcingSolution(CrowdsourcingSolution crowdsourcingSolution)
    {
                                                crowdsourcingSolution.setUpdateBy(ShiroUtils.getUserStringId());
                crowdsourcingSolution.setUpdateTime(DateUtils.getNowDate());
                return crowdsourcingSolutionMapper.updateCrowdsourcingSolution(crowdsourcingSolution);
    }

    /**
     * 删除创新众包解决方案信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrowdsourcingSolutionByIds(String ids)
    {
        return crowdsourcingSolutionMapper.deleteCrowdsourcingSolutionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除创新众包解决方案信息信息
     *
     * @param id 创新众包解决方案信息ID
     * @return 结果
     */
    public int deleteCrowdsourcingSolutionById(Long id)
    {
        return crowdsourcingSolutionMapper.deleteCrowdsourcingSolutionById(id);
    }
}
