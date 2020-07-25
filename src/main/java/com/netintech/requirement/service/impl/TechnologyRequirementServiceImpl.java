package com.netintech.requirement.service.impl;


import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.project.system.dept.domain.Dept;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.requirement.domain.TechnologyRequirement;
import com.netintech.requirement.mapper.TechnologyRequirementMapper;
import com.netintech.requirement.service.IAttachmentTechnologyRequirementService;
import com.netintech.requirement.service.ITechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 技术需求信息Service业务层处理
 *
 * @author admin
 * @date 2020-06-19
 */
@Service
public class TechnologyRequirementServiceImpl implements ITechnologyRequirementService {
    @Autowired
    private TechnologyRequirementMapper technologyRequirementMapper;
    @Autowired
    private IAttachmentTechnologyRequirementService attachmentTechnologyRequirementService;
    @Autowired
    private IDeptService deptService;
    /**
     * 查询技术需求信息
     *
     * @param id 技术需求信息ID
     * @return 技术需求信息
     */
    @Override
    public TechnologyRequirement selectTechnologyRequirementById(Long id) {
        return technologyRequirementMapper.selectTechnologyRequirementById(id);
    }

    /**
     * 查询技术需求信息列表
     *
     * @param technologyRequirement 技术需求信息
     * @return 技术需求信息
     */
    @Override
    public List<TechnologyRequirement> selectTechnologyRequirementList(TechnologyRequirement technologyRequirement) {
        return technologyRequirementMapper.selectTechnologyRequirementList(technologyRequirement);
    }

    /**
     * 新增技术需求信息
     *
     * @param technologyRequirement 技术需求信息
     * @return 结果
     */
    @Override
    public int insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        Long deptId = ShiroUtils.getSysUser().getDeptId();
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        Dept dept = deptService.selectDeptById(priseId);
        Long parentId = dept.getParentId();

        technologyRequirement.setEnterpriseId(priseId);
        technologyRequirement.setParkId(parentId);
        technologyRequirement.setCreateBy(ShiroUtils.getUserStringId());
        technologyRequirement.setCreateTime(DateUtils.getNowDate());
        int i = technologyRequirementMapper.insertTechnologyRequirement(technologyRequirement);

        Long technologyRequirementId = technologyRequirement.getId();
        String fileUuid = technologyRequirement.getFileUuid();
        attachmentTechnologyRequirementService.updateFileRelatedKey(technologyRequirementId,fileUuid);
        return i;
    }

    /**
     * 修改技术需求信息
     *
     * @param technologyRequirement 技术需求信息
     * @return 结果
     */
    @Override
    public int updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        technologyRequirement.setUpdateBy(ShiroUtils.getUserStringId());
        technologyRequirement.setUpdateTime(DateUtils.getNowDate());
        int i = technologyRequirementMapper.updateTechnologyRequirement(technologyRequirement);

        Long technologyRequirementId = technologyRequirement.getId();
        String fileUuid = technologyRequirement.getFileUuid();
        attachmentTechnologyRequirementService.updateFileRelatedKey(technologyRequirementId,fileUuid);
        return i;
    }

    /**
     * 删除技术需求信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTechnologyRequirementByIds(String ids) {
        return technologyRequirementMapper.deleteTechnologyRequirementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术需求信息信息
     *
     * @param id 技术需求信息ID
     * @return 结果
     */
    public int deleteTechnologyRequirementById(Long id) {
        return technologyRequirementMapper.deleteTechnologyRequirementById(id);
    }

    @Override
    public int updateTechnologyRequirementStatus(Long id, String status) {
        return technologyRequirementMapper.updateTechnologyRequirementStatus(id, status);
    }
}
