package com.netintech.enterprise.service.impl;

import java.util.List;

import com.netintech.common.constant.UserConstants;
import com.netintech.common.utils.DateUtils;
import com.netintech.park.mapper.SmallParkMapper;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netintech.enterprise.mapper.EnterpriseMapper;
import com.netintech.enterprise.domain.Enterprise;
import com.netintech.enterprise.service.IEnterpriseService;
import com.netintech.common.utils.text.Convert;

/**
 * 企业信息Service业务层处理
 * 
 * @author admin
 * @date 2020-04-17
 */
@Service
public class EnterpriseServiceImpl implements IEnterpriseService 
{
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private SmallParkMapper smallParkMapper;

    @Autowired
    private UserMapper userMapper;
    /**
     * 查询企业信息
     * 
     * @param id 企业信息ID
     * @return 企业信息
     */
    @Override
    public Enterprise selectEnterpriseById(Long id)
    {
        return enterpriseMapper.selectEnterpriseById(id);
    }

    /**
     * 查询企业信息列表
     * 
     * @param enterprise 企业信息
     * @return 企业信息
     */
    @Override
    public List<Enterprise> selectEnterpriseList(Enterprise enterprise)
    {
        return enterpriseMapper.selectEnterpriseList(enterprise);
    }

    /**
     * 新增企业信息
     * 
     * @param enterprise 企业信息
     * @return 结果
     */
    @Override
    public int insertEnterprise(Enterprise enterprise)
    {
        enterprise.setCreateTime(DateUtils.getNowDate());
        return enterpriseMapper.insertEnterprise(enterprise);
    }

    /**
     * 修改企业信息
     * 
     * @param enterprise 企业信息
     * @return 结果
     */
    @Override
    public int updateEnterprise(Enterprise enterprise)
    {
        enterprise.setUpdateTime(DateUtils.getNowDate());
        return enterpriseMapper.updateEnterprise(enterprise);
    }

    /**
     * 删除企业信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEnterpriseByIds(String ids)
    {
        return enterpriseMapper.deleteEnterpriseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业信息信息
     * 
     * @param id 企业信息ID
     * @return 结果
     */
    public int deleteEnterpriseById(Long id)
    {

        return enterpriseMapper.deleteEnterpriseById(id);
    }

    @Override
    public String checkEnterpriseNameUnique(Enterprise enterprise) {
        int i =  enterpriseMapper.checkEnterpriseNameUnique(enterprise);
        if (i>0){
            return UserConstants.ENTERPRISE_NAME_NOT_UNIQUE;
        }else return  UserConstants.ENTERPRISE_NAME_UNIQUE;
    }

    @Override
    public void updateDeptNamebyName(Enterprise enterprise){
        enterpriseMapper.updateDeptNamebyName(enterprise);
    }

    @Override
    public  int selectUserById(Long id){
        return  enterpriseMapper.selectUserById(id);
    }

    @Override
    public String getSmallNameById(Long smallId) {
        return enterpriseMapper.getSmallNameById(smallId);
    }

    @Override
    public Long getEnterpriseId(Long deptId) {
        String ancestors = userMapper.getUserDeptId(deptId);
        String[] list = ancestors.split(",");
        if(list.length>4){
            return  Long.valueOf(list[4]);
        }else if(list.length==4){
            return  deptId;
        }else {
            return null;
        }
    }


}
