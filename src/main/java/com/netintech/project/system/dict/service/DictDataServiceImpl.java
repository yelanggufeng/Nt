package com.netintech.project.system.dict.service;

import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.common.utils.text.Convert;
import com.netintech.core.web.domain.ParamEntity;
import com.netintech.project.system.dict.domain.DictData;
import com.netintech.project.system.dict.mapper.DictDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 字典 业务层处理
 *
 * @author admin
 */
@Service
public class DictDataServiceImpl implements IDictDataService
{
    @Autowired
    private DictDataMapper dictDataMapper;

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public List<DictData> selectDictDataList(DictData dictData)
    {
        return dictDataMapper.selectDictDataList(dictData);
    }

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<DictData> selectDictDataByType(String dictType)
    {
        return dictDataMapper.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue)
    {
        return dictDataMapper.selectDictLabel(dictType, dictValue);
    }

    /**
     * 根据字典数据ID查询信息
     *
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    @Override
    public DictData selectDictDataById(Long dictCode)
    {
        return dictDataMapper.selectDictDataById(dictCode);
    }

    /**
     * 通过字典ID删除字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 结果
     */
    @Override
    public int deleteDictDataById(Long dictCode)
    {
        return dictDataMapper.deleteDictDataById(dictCode);
    }

    /**
     * 批量删除字典数据
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteDictDataByIds(String ids)
    {
        return dictDataMapper.deleteDictDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public int insertDictData(DictData dictData)
    {
        dictData.setCreateBy(ShiroUtils.getUserStringId());
        return dictDataMapper.insertDictData(dictData);
    }

    /**
     * 修改保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public int updateDictData(DictData dictData)
    {
        dictData.setUpdateBy(ShiroUtils.getUserStringId());
        return dictDataMapper.updateDictData(dictData);
    }

    @Override
    public  List<ParamEntity>getParkList(Long deptid){
        return  dictDataMapper.getParkList(deptid);
    }

    @Override
    public List<ParamEntity>getCatagoryList(){
        return dictDataMapper.getCatagoryList();
    }

    @Override
    public List<ParamEntity> getTypeList() {
        return dictDataMapper.getTypeList();
    }

    @Override
    public List<ParamEntity> getCompanyList(String deptId) {
        return dictDataMapper.getCompanyList(deptId);
    }

    @Override
    public List<ParamEntity> getDeptList() {
        return dictDataMapper.getDeptList();
    }

    @Override
    public List<ParamEntity> getDeptListByParentId(Map map) {
        return dictDataMapper.getDeptListByParentId(map);
    }

    @Override
    public List<ParamEntity> getAreaList() {
        return dictDataMapper.getAreaList();
    }

    @Override
    public List<ParamEntity> getCompanyListByCreateBy() {
        return dictDataMapper.getCompanyListByCreateBy();
    }

    @Override
    public List<DictData> getNoticeType(String type) {
        return dictDataMapper.getNoticeType(type);
    }

    @Override
    public List<ParamEntity> getSmartDeviceType() {
        return dictDataMapper.getSmartDeviceType();
    }
}
