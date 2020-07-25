package com.netintech.park.service;

import com.netintech.park.domain.Area;

import java.util.List;

/**
 * 区域信息Service接口
 *
 * @author ltc
 * @date 2020-07-16
 */
public interface IAreaService
{
    /**
     * 查询区域信息
     *
     * @param id 区域信息ID
     * @return 区域信息
     */
    Area selectAreaById(Long id);

    /**
     * 查询区域信息列表
     *
     * @param area 区域信息
     * @return 区域信息集合
     */
    List<Area> selectAreaList(Area area);

    /**
     * 新增区域信息
     *
     * @param area 区域信息
     * @return 结果
     */
    int insertArea(Area area);

    /**
     * 修改区域信息
     *
     * @param area 区域信息
     * @return 结果
     */
    int updateArea(Area area);

    /**
     * 批量删除区域信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAreaByIds(String ids);

    /**
     * 删除区域信息信息
     *
     * @param id 区域信息ID
     * @return 结果
     */
    int deleteAreaById(Long id);
}