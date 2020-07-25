package com.netintech.property.service.impl;


import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.property.domain.AttachmentIntellectualProperty;
import com.netintech.property.mapper.AttachmentIntellectualPropertyMapper;
import com.netintech.property.service.IAttachmentIntellectualPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 知识产权信息附件Service业务层处理
 *
 * @author admin
 * @date 2020-06-22
 */
@Service
public class AttachmentIntellectualPropertyServiceImpl implements IAttachmentIntellectualPropertyService {
    @Autowired
    private AttachmentIntellectualPropertyMapper attachmentIntellectualPropertyMapper;

    /**
     * 查询知识产权信息附件
     *
     * @param id 知识产权信息附件ID
     * @return 知识产权信息附件
     */
    @Override
    public AttachmentIntellectualProperty selectAttachmentIntellectualPropertyById(Long id) {
        return attachmentIntellectualPropertyMapper.selectAttachmentIntellectualPropertyById(id);
    }

    /**
     * 查询知识产权信息附件列表
     *
     * @param attachmentIntellectualProperty 知识产权信息附件
     * @return 知识产权信息附件
     */
    @Override
    public List<AttachmentIntellectualProperty> selectAttachmentIntellectualPropertyList(AttachmentIntellectualProperty attachmentIntellectualProperty) {
        return attachmentIntellectualPropertyMapper.selectAttachmentIntellectualPropertyList(attachmentIntellectualProperty);
    }

    /**
     * 新增知识产权信息附件
     *
     * @param attachmentIntellectualProperty 知识产权信息附件
     * @return 结果
     */
    @Override
    public int insertAttachmentIntellectualProperty(AttachmentIntellectualProperty attachmentIntellectualProperty) {
        attachmentIntellectualProperty.setCreateBy(ShiroUtils.getUserStringId());
        attachmentIntellectualProperty.setCreateTime(DateUtils.getNowDate());
        return attachmentIntellectualPropertyMapper.insertAttachmentIntellectualProperty(attachmentIntellectualProperty);
    }

    /**
     * 修改知识产权信息附件
     *
     * @param attachmentIntellectualProperty 知识产权信息附件
     * @return 结果
     */
    @Override
    public int updateAttachmentIntellectualProperty(AttachmentIntellectualProperty attachmentIntellectualProperty) {
        attachmentIntellectualProperty.setUpdateBy(ShiroUtils.getUserStringId());
        attachmentIntellectualProperty.setUpdateTime(DateUtils.getNowDate());
        return attachmentIntellectualPropertyMapper.updateAttachmentIntellectualProperty(attachmentIntellectualProperty);
    }

    /**
     * 删除知识产权信息附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAttachmentIntellectualPropertyByIds(String ids) {
        return attachmentIntellectualPropertyMapper.deleteAttachmentIntellectualPropertyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除知识产权信息附件信息
     *
     * @param id 知识产权信息附件ID
     * @return 结果
     */
    public int deleteAttachmentIntellectualPropertyById(Long id) {
        return attachmentIntellectualPropertyMapper.deleteAttachmentIntellectualPropertyById(id);
    }

    @Override
    public int updateFileRelatedKey(Long propertyId, String fileUuid) {
        return attachmentIntellectualPropertyMapper.updateFileRelatedKey(propertyId, fileUuid);
    }
}
