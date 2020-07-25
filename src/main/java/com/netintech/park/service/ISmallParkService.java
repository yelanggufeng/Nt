package com.netintech.park.service;

import com.netintech.enterprise.domain.Enterprise;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.domain.SmallParkAttach;
import com.netintech.project.system.user.domain.User;

import java.util.List;

/**
 * 数字小微园信息Service接口
 *
 * @author admin
 * @date 2020-04-17
 */
public interface ISmallParkService
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
     *      *
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
     * 批量删除数字小微园信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSmallParkByIds(String ids);

    /**
     * 删除数字小微园信息信息
     *
     * @param id 数字小微园信息ID
     * @return 结果
     */
    int deleteSmallParkById(Long id);

    List<SmallPark> selectParkList(SmallPark smallPark);

    String checkParkNameUnique(String parkName);


    int selectUserById(Long valueOf);

    int selectEnterpriseByPid(Long valueOf);

    Long getParkId(Long deptId);

    int uploadfile(String file_name, String file_alias, String file_path, String fileUuid);

    int delfile(Integer id);

    List<SmallParkAttach> queryFileByUuid(String fileUuid);

    void updateattachlist(SmallPark smallPark);


    List<SmallPark> getParkInfoByAreaId(SmallPark smallPark, Integer type);
}
