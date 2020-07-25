package com.netintech.park.mapper;

import com.netintech.enterprise.domain.Enterprise;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.SmallParkAttach;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
 * 数字小微园信息Mapper接口
 *
 * @author admin
 * @date 2020-04-17
 */
public interface SmallParkMapper
{
    /**
     * 查询数字小微园信息
     *
     * @param id 数字小微园信息ID
     * @return 数字小微园信息
     */
    SmallPark selectSmallParkById(Long id);

    /**
     * 查询数字小微园信息列表
     *
     * @param smallPark 数字小微园信息
     * @return 数字小微园信息集合
     */
    List<SmallPark> selectSmallParkList(SmallPark smallPark);

    /**
     * 新增数字小微园信息
     *
     * @param smallPark 数字小微园信息
     * @return 结果
     */
    int insertSmallPark(SmallPark smallPark);

    /**
     * 修改数字小微园信息
     *
     * @param smallPark 数字小微园信息
     * @return 结果
     */
    int updateSmallPark(SmallPark smallPark);

    /**
     * 删除数字小微园信息
     *
     * @param id 数字小微园信息ID
     * @return 结果
     */
    int deleteSmallParkById(Long id);

    /**
     * 批量删除数字小微园信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSmallParkByIds(String[] ids);

    List<SmallPark> selectParkList(SmallPark smallPark);

    int  checkParkNameUnique(String name);

    int selectUserById(Long id);

    int selectEnterpriseByPid(Long id);

    int countPark(Long deptId);

    int insertAttach(SmallParkAttach bean);

    int delfile(Integer id);

    List<SmallParkAttach> queryFileByUuid(String fileUuid);

    void updateattachlist(SmallPark smallPark);

    List<SmallParkAttach> queryFileByParkId(Long id);

    List<SmallPark> selectParkByLimit();

}
