package com.netintech.record.mapper;


import com.netintech.record.domain.AuditRecord;

import java.util.List;

/**
 * 技术成果审核记录信息Mapper接口
 *
 * @author admin
 * @date 2020-06-17
 */
public interface AuditRecordMapper
{
    /**
     * 查询技术成果审核记录信息
     *
     * @param id 技术成果审核记录信息ID
     * @return 技术成果审核记录信息
     */
    AuditRecord selectAuditRecordById(Long id);

    /**
     * 查询技术成果审核记录信息列表
     *
     * @param auditRecord 技术成果审核记录信息
     * @return 技术成果审核记录信息集合
     */
    List<AuditRecord> selectAuditRecordList(AuditRecord auditRecord);

    /**
     * 新增技术成果审核记录信息
     *
     * @param auditRecord 技术成果审核记录信息
     * @return 结果
     */
    int insertAuditRecord(AuditRecord auditRecord);

    /**
     * 修改技术成果审核记录信息
     *
     * @param auditRecord 技术成果审核记录信息
     * @return 结果
     */
    int updateAuditRecord(AuditRecord auditRecord);

    /**
     * 删除技术成果审核记录信息
     *
     * @param id 技术成果审核记录信息ID
     * @return 结果
     */
    int deleteAuditRecordById(Long id);

    /**
     * 批量删除技术成果审核记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteAuditRecordByIds(String[] ids);
}
