package com.netintech.project.test.mapper;

import com.netintech.project.test.domain.TestGen;
import java.util.List;

/**
 * 测试Mapper接口
 * 
 * @author admin
 * @date 2020-03-26
 */
public interface TestGenMapper 
{
    /**
     * 查询测试
     * 
     * @param id 测试ID
     * @return 测试
     */
    TestGen selectTestGenById(Integer id);

    /**
     * 查询测试列表
     * 
     * @param testGen 测试
     * @return 测试集合
     */
    List<TestGen> selectTestGenList(TestGen testGen);

    /**
     * 新增测试
     * 
     * @param testGen 测试
     * @return 结果
     */
    int insertTestGen(TestGen testGen);

    /**
     * 修改测试
     * 
     * @param testGen 测试
     * @return 结果
     */
    int updateTestGen(TestGen testGen);

    /**
     * 删除测试
     * 
     * @param id 测试ID
     * @return 结果
     */
    int deleteTestGenById(Integer id);

    /**
     * 批量删除测试
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTestGenByIds(String[] ids);
}
