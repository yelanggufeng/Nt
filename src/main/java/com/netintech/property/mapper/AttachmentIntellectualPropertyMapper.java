package com.netintech.property.mapper;

import com.netintech.property.domain.AttachmentIntellectualProperty;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 知识产权信息附件Mapper接口
 *
 * @author admin
 * @date 2020-06-22
 */
public interface AttachmentIntellectualPropertyMapper
{
    /**
     * 查询知识产权信息附件
     *
     * @param id 知识产权信息附件ID
     * @return 知识产权信息附件
     */
    AttachmentIntellectualProperty selectAttachmentIntellectualPropertyById(Long id);

    /**
     * 查询知识产权信息附件列表
     *
     * @param attachmentIntellectualProperty 知识产权信息附件
     * @return 知识产权信息附件集合
     */
    List<AttachmentIntellectualProperty> selectAttachmentIntellectualPropertyList(AttachmentIntellectualProperty attachmentIntellectualProperty);

    /**
     * 新增知识产权信息附件
     *
     * @param attachmentIntellectualProperty 知识产权信息附件
     * @return 结果
     */
    int insertAttachmentIntellectualProperty(AttachmentIntellectualProperty attachmentIntellectualProperty);

    /**
     * 修改知识产权信息附件
     *
     * @param attachmentIntellectualProperty 知识产权信息附件
     * @return 结果
     */
    int updateAttachmentIntellectualProperty(AttachmentIntellectualProperty attachmentIntellectualProperty);

    /**
     * 删除知识产权信息附件
     *
     * @param id 知识产权信息附件ID
     * @return 结果
     */
    int deleteAttachmentIntellectualPropertyById(Long id);

    /**
     * 批量删除知识产权信息附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAttachmentIntellectualPropertyByIds(String[] ids);

    @Update("update attachment_intellectual_property set property_id = #{propertyId} where file_uuid = #{fileUuid}")
    int updateFileRelatedKey(Long propertyId, String fileUuid);
}
