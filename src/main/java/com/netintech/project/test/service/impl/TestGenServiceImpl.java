package com.netintech.project.test.service.impl;

import java.util.List;

import com.netintech.common.utils.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netintech.project.test.mapper.TestGenMapper;
import com.netintech.project.test.domain.TestGen;
import com.netintech.project.test.service.ITestGenService;

/**
 * 测试Service业务层处理
 * 
 * @author admin
 * @date 2020-03-26
 */
@Service
public class TestGenServiceImpl implements ITestGenService 
{
    @Autowired
    private TestGenMapper testGenMapper;

    /**
     * 查询测试
     * 
     * @param id 测试ID
     * @return 测试
     */
    @Override
    public TestGen selectTestGenById(Integer id)
    {
        return testGenMapper.selectTestGenById(id);
    }

    /**
     * 查询测试列表
     * 
     * @param testGen 测试
     * @return 测试
     */
    @Override
    public List<TestGen> selectTestGenList(TestGen testGen)
    {
        return testGenMapper.selectTestGenList(testGen);
    }

    /**
     * 新增测试
     * 
     * @param testGen 测试
     * @return 结果
     */
    @Override
    public int insertTestGen(TestGen testGen)
    {
        return testGenMapper.insertTestGen(testGen);
    }

    /**
     * 修改测试
     * 
     * @param testGen 测试
     * @return 结果
     */
    @Override
    public int updateTestGen(TestGen testGen)
    {
        return testGenMapper.updateTestGen(testGen);
    }

    /**
     * 删除测试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTestGenByIds(String ids)
    {
        return testGenMapper.deleteTestGenByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试信息
     * 
     * @param id 测试ID
     * @return 结果
     */
    public int deleteTestGenById(Integer id)
    {
        return testGenMapper.deleteTestGenById(id);
    }
}
