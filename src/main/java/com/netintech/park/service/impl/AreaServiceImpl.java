package com.netintech.park.service.impl;

import com.netintech.common.utils.text.Convert;
import com.netintech.park.domain.Area;
import com.netintech.park.mapper.AreaMapper;
import com.netintech.park.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 区域信息Service业务层处理
 *
 * @author ltc
 * @date 2020-07-16
 */
@Service
public class AreaServiceImpl implements IAreaService
{
    @Autowired
    private AreaMapper areaMapper;

    /**
     * 查询区域信息
     *
     * @param id 区域信息ID
     * @return 区域信息
     */
    @Override
    public Area selectAreaById(Long id)
    {
        return areaMapper.selectAreaById(id);
    }

    /**
     * 查询区域信息列表
     *
     * @param area 区域信息
     * @return 区域信息
     */
    @Override
    public List<Area> selectAreaList(Area area)
    {
        return areaMapper.selectAreaList(area);
    }

    /**
     * 新增区域信息
     *
     * @param area 区域信息
     * @return 结果
     */
    @Override
    public int insertArea(Area area)
    {
        return areaMapper.insertArea(area);
    }

    /**
     * 修改区域信息
     *
     * @param area 区域信息
     * @return 结果
     */
    @Override
    public int updateArea(Area area)
    {
        return areaMapper.updateArea(area);
    }

    /**
     * 删除区域信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAreaByIds(String ids)
    {
        return areaMapper.deleteAreaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除区域信息信息
     *
     * @param id 区域信息ID
     * @return 结果
     */
    public int deleteAreaById(Long id)
    {
        return areaMapper.deleteAreaById(id);
    }
}