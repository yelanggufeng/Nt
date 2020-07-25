package com.netintech.project.system.dict.mapper;

import com.netintech.core.web.domain.ParamEntity;
import com.netintech.project.system.dict.domain.DictData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 字典表 数据层
 *
 * @author admin
 */
public interface DictDataMapper
{
    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    public List<DictData> selectDictDataList(DictData dictData);

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    public List<DictData> selectDictDataByType(String dictType);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

    /**
     * 根据字典数据ID查询信息
     *
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    public DictData selectDictDataById(Long dictCode);

    /**
     * 查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据
     */
    public int countDictDataByType(String dictType);

    /**
     * 通过字典ID删除字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 结果
     */
    public int deleteDictDataById(Long dictCode);

    /**
     * 批量删除字典数据
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteDictDataByIds(String[] ids);

    /**
     * 新增字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    public int insertDictData(DictData dictData);

    /**
     * 修改字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    public int updateDictData(DictData dictData);

    /**
     * 同步修改字典类型
     *
     * @param oldDictType 旧字典类型
     * @param newDictType 新旧字典类型
     * @return 结果
     */
    public int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);

    List<ParamEntity> getParkList(@Param("deptId") Long deptId);

    List<ParamEntity> getCatagoryList();

    List<ParamEntity> getTypeList();

    @Select("SELECT a.user_id as `value`,b.dept_name as `key` FROM  sys_user a left join sys_dept b on b.dept_id=a.dept_id where a.del_flag=0")
    List<ParamEntity> getCompanyListByCreateBy();

    @Select("select dept_id as `value`,dept_name as `key` from sys_dept where del_flag=0")
    List<ParamEntity> getDeptList();

    List<ParamEntity> getCompanyList(String deptId);

    List<ParamEntity> getDeptListByParentId( Map map);

    List<ParamEntity> getAreaList();

    List<DictData> getNoticeType(@Param("type") String type);

    @Select("select id as `value`,type_name as `key` from sys_smart_device_type where del_flag=0")
    List<ParamEntity> getSmartDeviceType();
}
