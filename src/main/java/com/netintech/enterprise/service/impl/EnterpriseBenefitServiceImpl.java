package com.netintech.enterprise.service.impl;

import java.util.List;

import com.netintech.common.constant.UserConstants;
import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.enterprise.domain.EnterpriseBenefit;
import com.netintech.enterprise.mapper.EnterpriseBenefitMapper;
import com.netintech.enterprise.service.IEnterpriseBenefitService;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netintech.common.utils.text.Convert;

import static org.apache.xalan.xsltc.compiler.sym.error;

/**
 * 企业效益信息Service业务层处理
 *
 * @author admin
 * @date 2020-05-09
 */
@Service
public class EnterpriseBenefitServiceImpl implements IEnterpriseBenefitService {
    @Autowired
    private EnterpriseBenefitMapper enterpriseBenefitMapper;

    @Autowired
    private IDeptService deptService;

    /**
     * 查询企业效益信息
     *
     * @param id 企业效益信息ID
     * @return 企业效益信息
     */
    @Override
    public EnterpriseBenefit selectEnterpriseBenefitById(Long id) {
        return enterpriseBenefitMapper.selectEnterpriseBenefitById(id);
    }

    /**
     * 查询企业效益信息列表
     *
     * @param enterpriseBenefit 企业效益信息
     * @return 企业效益信息
     */
    @Override
    public List<EnterpriseBenefit> selectEnterpriseBenefitList(EnterpriseBenefit enterpriseBenefit) {
        User user = ShiroUtils.getSysUser();
        if (!user.isAdmin()) {
            enterpriseBenefit.setEnterpriseId(deptService.getPriseIdByDeptId(user.getDeptId()));
        }
        return enterpriseBenefitMapper.selectEnterpriseBenefitList(enterpriseBenefit);
    }

    /**
     * 新增企业效益信息
     *
     * @param enterpriseBenefit 企业效益信息
     * @return 结果
     */
    @Override
    public int insertEnterpriseBenefit(EnterpriseBenefit enterpriseBenefit) {
        User user = ShiroUtils.getSysUser();
        enterpriseBenefit.setCreateTime(DateUtils.getNowDate());
        enterpriseBenefit.setCreateBy(String.valueOf(user.getUserId()));
        enterpriseBenefit.setEnterpriseId(deptService.getPriseIdByDeptId(user.getDeptId()));
        return enterpriseBenefitMapper.insertEnterpriseBenefit(enterpriseBenefit);
    }

    @Override
    public boolean checkExit(EnterpriseBenefit enterpriseBenefit) {
        if (enterpriseBenefitMapper.checkExit(enterpriseBenefit)>0) {
            return true;
        }
        return false;
    }




    /**
     * 修改企业效益信息
     *
     * @param enterpriseBenefit 企业效益信息
     * @return 结果
     */
    @Override
    public int updateEnterpriseBenefit(EnterpriseBenefit enterpriseBenefit) {
        enterpriseBenefit.setUpdateTime(DateUtils.getNowDate());
        enterpriseBenefit.setCreateBy(String.valueOf(ShiroUtils.getUserId()));
        return enterpriseBenefitMapper.updateEnterpriseBenefit(enterpriseBenefit);
    }

    /**
     * 删除企业效益信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEnterpriseBenefitByIds(String ids) {
        return enterpriseBenefitMapper.deleteEnterpriseBenefitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业效益信息信息
     *
     * @param id 企业效益信息ID
     * @return 结果
     */
    @Override
    public int deleteEnterpriseBenefitById(Long id) {
        return enterpriseBenefitMapper.deleteEnterpriseBenefitById(id);
    }


}
