package com.netintech.property.service;


import com.netintech.property.domain.IntellectualProperty;

import java.util.List;

/**
 * 知识产权信息Service接口
 *
 * @author admin
 * @date 2020-06-22
 */
public interface IIntellectualPropertyService
{
    /**
     * 查询知识产权信息
     *
     * @param id 知识产权信息ID
     * @return 知识产权信息
     */
    IntellectualProperty selectIntellectualPropertyById(Long id);

    /**
     * 查询知识产权信息列表
     *
     * @param intellectualProperty 知识产权信息
     * @return 知识产权信息集合
     */
    List<IntellectualProperty> selectIntellectualPropertyList(IntellectualProperty intellectualProperty);

    /**
     * 新增知识产权信息
     *
     * @param intellectualProperty 知识产权信息
     * @return 结果
     */
    int insertIntellectualProperty(IntellectualProperty intellectualProperty);

    /**
     * 修改知识产权信息
     *
     * @param intellectualProperty 知识产权信息
     * @return 结果
     */
    int updateIntellectualProperty(IntellectualProperty intellectualProperty);

    /**
     * 批量删除知识产权信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteIntellectualPropertyByIds(String ids);

    /**
     * 删除知识产权信息信息
     *
     * @param id 知识产权信息ID
     * @return 结果
     */
    int deleteIntellectualPropertyById(Long id);

    int updateIntellectualPropertyStatus(Long id,String status);
}
