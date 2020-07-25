package com.netintech.process.user.service.impl;


import com.netintech.common.utils.text.Convert;
import com.netintech.process.group.domain.ActIdGroup;
import com.netintech.process.user.domain.ActIdUser;
import com.netintech.process.user.mapper.ActIdUserMapper;
import com.netintech.process.user.service.IActIdUserService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.mapper.UserMapper;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程用户Service业务层处理
 *
 * @author admin
 */
@Service
public class ActIdUserServiceImpl implements IActIdUserService
{
    @Autowired
    private ActIdUserMapper actIdUserMapper;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询流程用户
     *
     * @param id 流程用户ID
     * @return 流程用户
     */
    @Override
    public ActIdUser selectActIdUserById(String id)
    {
        return actIdUserMapper.selectActIdUserById(id);
    }

    /**
     * 查询流程用户列表
     *
     * @param actIdUser 流程用户
     * @return 流程用户
     */
    @Override
    public List<ActIdUser> selectActIdUserList(ActIdUser actIdUser)
    {
        return actIdUserMapper.selectActIdUserList(actIdUser);
    }

    /**
     * 新增流程用户
     *
     * @param actIdUser 流程用户
     * @return 结果
     */
    @Transactional
    @Override
    public int insertActIdUser(ActIdUser actIdUser)
    {
        return actIdUserMapper.insertActIdUser(actIdUser);
    }

    /**
     * 修改流程用户
     *
     * @param actIdUser 流程用户
     * @return 结果
     */
    @Transactional
    @Override
    public int updateActIdUser(ActIdUser actIdUser)
    {
        return actIdUserMapper.updateActIdUser(actIdUser);
    }

    /**
     * 删除流程用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteActIdUserByIds(String ids)
    {
        return actIdUserMapper.deleteActIdUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除流程用户信息
     *
     * @param id 流程用户ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteActIdUserById(String id) {
        return actIdUserMapper.deleteActIdUserById(id);
    }

    @Override
    public List<ActIdGroup> selectGroupByUserId(String userId) {
        List<Group> groupList = identityService.createGroupQuery().list();
        List<ActIdGroup> idGroupList = new ArrayList<>();
        groupList.forEach(group -> {
            ActIdGroup idGroup = new ActIdGroup();
            idGroup.setId(group.getId());
            idGroup.setName(group.getName());
            idGroupList.add(idGroup);
        });
        List<Group> userGroupList = identityService.createGroupQuery().groupMember(userId).list();
        idGroupList.forEach(idGroup -> {
            userGroupList.forEach(userGroup -> {
                if (idGroup.getId().equals(userGroup.getId())) {
                    idGroup.setFlag(true);
                }
            });
        });
        return idGroupList;
    }

    /**
     * 查询未关联流程用户的系统用户集合
     * @param sysUser
     * @return
     */
    @Override
    public List<User> selectUnAssociatedSystemUserList(User sysUser) {
        List<User> userList = userMapper.selectUserList(sysUser);            // 系统用户
        List<ActIdUser> idUserList = actIdUserMapper.selectActIdUserList(null); // 所有流程用户
        List<User> userList2 = new ArrayList<>();                            // 已分配流程用户的系统用户
        List<User> returnList = new ArrayList<>();
        Map<Long, User> sysUserMap = new HashMap<>();
        userList.forEach(user -> {
            if (User.isAdmin(user.getUserId())) return;    // 流程用户不允许关联管理员
            sysUserMap.put(user.getUserId(), user);
        });
        idUserList.forEach(idUser -> {
            User tempUser = userMapper.selectUserByLoginName(idUser.getId());
            if (tempUser != null) {
                userList2.add(tempUser);
            }
        });
        userList2.forEach(user -> {
            if (sysUserMap.containsKey(user.getUserId())) {
                sysUserMap.remove(user.getUserId());
            }
        });

        for (Map.Entry<Long, User> entry : sysUserMap.entrySet()) {
            returnList.add(entry.getValue());
        }
        return returnList;
    }
}
