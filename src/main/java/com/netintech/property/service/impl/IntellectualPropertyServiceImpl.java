package com.netintech.property.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.project.system.dept.domain.Dept;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.property.domain.IntellectualProperty;
import com.netintech.property.mapper.IntellectualPropertyMapper;
import com.netintech.property.service.IAttachmentIntellectualPropertyService;
import com.netintech.property.service.IIntellectualPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 知识产权信息Service业务层处理
 *
 * @author admin
 * @date 2020-06-22
 */
@Service
public class IntellectualPropertyServiceImpl implements IIntellectualPropertyService {
    @Autowired
    private IntellectualPropertyMapper intellectualPropertyMapper;
    @Autowired
    private IAttachmentIntellectualPropertyService attachmentIntellectualPropertyService;
    @Autowired
    private IDeptService deptService;

    /**
     * 查询知识产权信息
     *
     * @param id 知识产权信息ID
     * @return 知识产权信息
     */
    @Override
    public IntellectualProperty selectIntellectualPropertyById(Long id) {
        return intellectualPropertyMapper.selectIntellectualPropertyById(id);
    }

    /**
     * 查询知识产权信息列表
     *
     * @param intellectualProperty 知识产权信息
     * @return 知识产权信息
     */
    @Override
    public List<IntellectualProperty> selectIntellectualPropertyList(IntellectualProperty intellectualProperty) {
        return intellectualPropertyMapper.selectIntellectualPropertyList(intellectualProperty);
    }

    /**
     * 新增知识产权信息
     *
     * @param intellectualProperty 知识产权信息
     * @return 结果
     */
    @Override
    public int insertIntellectualProperty(IntellectualProperty intellectualProperty) {

        Long deptId = ShiroUtils.getSysUser().getDeptId();
        Long priseId = deptService.getPriseIdByDeptId(deptId);
        Dept dept = deptService.selectDeptById(priseId);
        Long parentId = dept.getParentId();

        intellectualProperty.setEnterpriseId(priseId);
        intellectualProperty.setParkId(parentId);
        intellectualProperty.setCreateBy(ShiroUtils.getUserStringId());
        intellectualProperty.setCreateTime(DateUtils.getNowDate());
        int i = intellectualPropertyMapper.insertIntellectualProperty(intellectualProperty);

        Long id = intellectualProperty.getId();
        String fileUuid = intellectualProperty.getFileUuid();
        attachmentIntellectualPropertyService.updateFileRelatedKey(id,fileUuid);
        return i;
    }

    /**
     * 修改知识产权信息
     *
     * @param intellectualProperty 知识产权信息
     * @return 结果
     */
    @Override
    public int updateIntellectualProperty(IntellectualProperty intellectualProperty) {
        intellectualProperty.setUpdateBy(ShiroUtils.getUserStringId());
        intellectualProperty.setUpdateTime(DateUtils.getNowDate());
        int i = intellectualPropertyMapper.updateIntellectualProperty(intellectualProperty);

        Long id = intellectualProperty.getId();
        String fileUuid = intellectualProperty.getFileUuid();
        attachmentIntellectualPropertyService.updateFileRelatedKey(id,fileUuid);
        return i;
    }

    /**
     * 删除知识产权信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteIntellectualPropertyByIds(String ids) {
        return intellectualPropertyMapper.deleteIntellectualPropertyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除知识产权信息信息
     *
     * @param id 知识产权信息ID
     * @return 结果
     */
    public int deleteIntellectualPropertyById(Long id) {
        return intellectualPropertyMapper.deleteIntellectualPropertyById(id);
    }

    @Override
    public int updateIntellectualPropertyStatus(Long id, String status) {
        return intellectualPropertyMapper.updateIntellectualPropertyStatus(id, status);
    }
}
