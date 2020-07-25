package com.netintech.record.service.impl;

import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.record.domain.AuditRecord;
import com.netintech.record.mapper.AuditRecordMapper;
import com.netintech.record.service.IAuditRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 技术成果审核记录信息Service业务层处理
 *
 * @author admin
 * @date 2020-06-17
 */
@Service
public class AuditRecordServiceImpl implements IAuditRecordService {
    @Autowired
    private AuditRecordMapper auditRecordMapper;

    /**
     * 查询技术成果审核记录信息
     *
     * @param id 技术成果审核记录信息ID
     * @return 技术成果审核记录信息
     */
    @Override
    public AuditRecord selectAuditRecordById(Long id) {
        return auditRecordMapper.selectAuditRecordById(id);
    }

    /**
     * 查询技术成果审核记录信息列表
     *
     * @param auditRecord 技术成果审核记录信息
     * @return 技术成果审核记录信息
     */
    @Override
    public List<AuditRecord> selectAuditRecordList(AuditRecord auditRecord) {
        return auditRecordMapper.selectAuditRecordList(auditRecord);
    }

    /**
     * 新增技术成果审核记录信息
     *
     * @param auditRecord 技术成果审核记录信息
     * @return 结果
     */
    @Override
    public int insertAuditRecord(AuditRecord auditRecord) {
        auditRecord.setAuditTime(DateUtils.getNowDate());
        auditRecord.setCreateBy(ShiroUtils.getUserStringId());
        auditRecord.setCreateTime(DateUtils.getNowDate());
        return auditRecordMapper.insertAuditRecord(auditRecord);
    }

    /**
     * 修改技术成果审核记录信息
     *
     * @param auditRecord 技术成果审核记录信息
     * @return 结果
     */
    @Override
    public int updateAuditRecord(AuditRecord auditRecord) {
        auditRecord.setUpdateBy(ShiroUtils.getUserStringId());
        auditRecord.setUpdateTime(DateUtils.getNowDate());
        return auditRecordMapper.updateAuditRecord(auditRecord);
    }

    /**
     * 删除技术成果审核记录信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAuditRecordByIds(String ids) {
        return auditRecordMapper.deleteAuditRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术成果审核记录信息信息
     *
     * @param id 技术成果审核记录信息ID
     * @return 结果
     */
    public int deleteAuditRecordById(Long id) {
        return auditRecordMapper.deleteAuditRecordById(id);
    }
}
