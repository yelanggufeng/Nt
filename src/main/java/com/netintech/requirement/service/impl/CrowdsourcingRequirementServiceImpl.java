package com.netintech.requirement.service.impl;


import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.project.system.dept.domain.Dept;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.requirement.domain.CrowdsourcingRequirement;
import com.netintech.requirement.mapper.CrowdsourcingRequirementMapper;
import com.netintech.requirement.service.IAttachmentCrowdsourcingRequirementService;
import com.netintech.requirement.service.ICrowdsourcingRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创新众包需求信息Service业务层处理
 *
 * @author admin
 * @date 2020-06-19
 */
@Service
public class CrowdsourcingRequirementServiceImpl implements ICrowdsourcingRequirementService {
    @Autowired
    private CrowdsourcingRequirementMapper crowdsourcingRequirementMapper;
    @Autowired
    private IAttachmentCrowdsourcingRequirementService attachmentCrowdsourcingRequirementService;
    @Autowired
    private IDeptService deptService;
    /**
     * 查询创新众包需求信息
     *
     * @param id 创新众包需求信息ID
     * @return 创新众包需求信息
     */
    @Override
    public CrowdsourcingRequirement selectCrowdsourcingRequirementById(Long id) {
        return crowdsourcingRequirementMapper.selectCrowdsourcingRequirementById(id);
    }

    /**
     * 查询创新众包需求信息列表
     *
     * @param crowdsourcingRequirement 创新众包需求信息
     * @return 创新众包需求信息
     */
    @Override
    public List<CrowdsourcingRequirement> selectCrowdsourcingRequirementList(CrowdsourcingRequirement crowdsourcingRequirement) {
        return crowdsourcingRequirementMapper.selectCrowdsourcingRequirementList(crowdsourcingRequirement);
    }

    /**
     * 新增创新众包需求信息
     *
     * @param crowdsourcingRequirement 创新众包需求信息
     * @return 结果
     */
    @Override
    public int insertCrowdsourcingRequirement(CrowdsourcingRequirement crowdsourcingRequirement) {
        Long deptId = ShiroUtils.getSysUser().getDeptId();
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        Dept dept = deptService.selectDeptById(priseId);
        Long parentId = dept.getParentId();
        crowdsourcingRequirement.setEnterpriseId(priseId);
        crowdsourcingRequirement.setParkId(parentId);
        crowdsourcingRequirement.setCreateBy(ShiroUtils.getUserStringId());
        crowdsourcingRequirement.setCreateTime(DateUtils.getNowDate());
        int i = crowdsourcingRequirementMapper.insertCrowdsourcingRequirement(crowdsourcingRequirement);

        Long requirementId = crowdsourcingRequirement.getId();
        String fileUuid = crowdsourcingRequirement.getFileUuid();
        attachmentCrowdsourcingRequirementService.updateFileRelatedKey(requirementId,fileUuid);

        return i;
    }

    /**
     * 修改创新众包需求信息
     *
     * @param crowdsourcingRequirement 创新众包需求信息
     * @return 结果
     */
    @Override
    public int updateCrowdsourcingRequirement(CrowdsourcingRequirement crowdsourcingRequirement) {
        crowdsourcingRequirement.setUpdateBy(ShiroUtils.getUserStringId());
        crowdsourcingRequirement.setUpdateTime(DateUtils.getNowDate());
        crowdsourcingRequirement.setStatus("0");
        int i = crowdsourcingRequirementMapper.updateCrowdsourcingRequirement(crowdsourcingRequirement);

        Long requirementId = crowdsourcingRequirement.getId();
        String fileUuid = crowdsourcingRequirement.getFileUuid();
        attachmentCrowdsourcingRequirementService.updateFileRelatedKey(requirementId,fileUuid);

        return i;
    }

    /**
     * 删除创新众包需求信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCrowdsourcingRequirementByIds(String ids) {
        return crowdsourcingRequirementMapper.deleteCrowdsourcingRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除创新众包需求信息信息
     *
     * @param id 创新众包需求信息ID
     * @return 结果
     */
    public int deleteCrowdsourcingRequirementById(Long id) {
        return crowdsourcingRequirementMapper.deleteCrowdsourcingRequirementById(id);
    }

    @Override
    public int updateCrowdsourcingRequirementStatus(Long id, String status) {
        return crowdsourcingRequirementMapper.updateCrowdsourcingRequirementStatus(id, status);
    }

    @Override
    public int updateCrowdsourcingRequirementResult(Long id, String result) {
        return crowdsourcingRequirementMapper.updateCrowdsourcingRequirementResult(id,result);
    }

    @Override
    public List<CrowdsourcingRequirement> selectMyParticipateList(CrowdsourcingRequirement crowdsourcingRequirement) {
        return crowdsourcingRequirementMapper.selectMyParticipateList(crowdsourcingRequirement);
    }
}
