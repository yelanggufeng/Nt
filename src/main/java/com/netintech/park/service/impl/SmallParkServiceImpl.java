package com.netintech.park.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.netintech.common.constant.UserConstants;
import com.netintech.common.utils.DateUtils;
import com.netintech.common.utils.StringUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.enterprise.domain.Enterprise;
import com.netintech.park.domain.SmallParkAttach;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netintech.park.mapper.SmallParkMapper;
import com.netintech.park.domain.SmallPark;
import com.netintech.park.service.ISmallParkService;
import com.netintech.common.utils.text.Convert;

/**
 * 数字小微园信息Service业务层处理
 *
 * @author admin
 * @date 2020-04-17
 */
@Service
public class SmallParkServiceImpl implements ISmallParkService
{
    @Autowired
    private SmallParkMapper smallParkMapper;

    @Autowired
    private UserMapper usermapper;
    /**
     * 查询数字小微园信息
     *
     * @param id 数字小微园信息ID
     * @return 数字小微园信息
     */
    @Override
    public SmallPark selectSmallParkById(Long id)
    {
        SmallPark park = smallParkMapper.selectSmallParkById(id);
        park.setAttaches(smallParkMapper.queryFileByUuid(park.getFileUuid()));
        return park;
    }

    /**
     * 查询数字小微园信息列表
     *
     * @param smallPark 数字小微园信息
     * @return 数字小微园信息
     */
    @Override
    public List<SmallPark> selectSmallParkList(SmallPark smallPark)
    {
        return smallParkMapper.selectSmallParkList(smallPark);
    }

    /**
     * 新增数字小微园信息
     *
     * @param smallPark 数字小微园信息
     * @return 结果
     */
    @Override
    public int insertSmallPark(SmallPark smallPark)
    {
        smallPark.setCreateTime(DateUtils.getNowDate());
        return smallParkMapper.insertSmallPark(smallPark);
    }

    /**
     * 修改数字小微园信息
     *
     * @param smallPark 数字小微园信息
     * @return 结果
     */
    @Override
    public int updateSmallPark(SmallPark smallPark)
    {
        smallPark.setUpdateTime(DateUtils.getNowDate());
        return smallParkMapper.updateSmallPark(smallPark);
    }

    /**
     * 删除数字小微园信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSmallParkByIds(String ids)
    {
        return smallParkMapper.deleteSmallParkByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数字小微园信息信息
     *
     * @param id 数字小微园信息ID
     * @return 结果
     */
    public int deleteSmallParkById(Long id)
    {
        return smallParkMapper.deleteSmallParkById(id);
    }


    @Override
    public List<SmallPark> selectParkList(SmallPark smallPark)
    {
        return smallParkMapper.selectParkList(smallPark);
    }

    @Override
    public String checkParkNameUnique(String name){
        int i =  smallParkMapper.checkParkNameUnique(name);
        if (i>0){
            return UserConstants.PARK_NAME_NOT_UNIQUE;
        }else return  UserConstants.PARK_NAME_UNIQUE;
    }

    @Override
    public int selectUserById(Long id){
        return  smallParkMapper.selectUserById(id);
    }

    @Override
    public int selectEnterpriseByPid(Long id){
        return  smallParkMapper.selectEnterpriseByPid(id);
    }

    @Override
    public Long getParkId(Long deptId) {
        String ancestors = usermapper.getUserDeptId(deptId);
        String[] list = ancestors.split(",");
        if(list.length>3){
            return Long.valueOf(list[3]);
        }else if(list.length==3){
            return deptId;
        }else{
            return null;
        }
    }

    @Override
    public int uploadfile(String file_name, String file_alias, String file_path, String fileUuid) {
        SmallParkAttach bean = new SmallParkAttach(0L, fileUuid, file_name, file_alias, file_path, "0");
        User user = ShiroUtils.getSysUser();
        bean.setCreateBy(user.getUserId().toString());
        bean.setCreateTime(DateUtils.getNowDate());
        return smallParkMapper.insertAttach(bean);
    }

    @Override
    public int delfile(Integer id) {
        return smallParkMapper.delfile(id);
    }

    @Override
    public List<SmallParkAttach> queryFileByUuid(String fileUuid) {
        if(StringUtils.isEmpty(fileUuid)) return new ArrayList<>();
        return smallParkMapper.queryFileByUuid(fileUuid);
    }

    @Override
    public void updateattachlist(SmallPark smallPark) {
        smallParkMapper.updateattachlist(smallPark);
    }

    @Override
    public List<SmallPark> getParkInfoByAreaId(SmallPark smallPark, Integer type) {
        List<SmallPark> parkList = new ArrayList<>();
        if (type == null) {
            parkList = smallParkMapper.selectParkList(smallPark);
        } else {
            parkList = smallParkMapper.selectParkByLimit();
        }
        parkList.stream().forEach(item->{
            List<SmallParkAttach> attaches = smallParkMapper.queryFileByParkId(item.getId());
            if (attaches.size() > 0) {
                item.setFilePath(attaches.get(0).getFilePath());
            }
        });
        return parkList;
    }
}
