package com.netintech.process.user.service;



import com.netintech.process.group.domain.ActIdGroup;
import com.netintech.process.user.domain.ActIdUser;
import com.netintech.project.system.user.domain.User;

import java.util.List;

/**
 * 流程用户Service接口
 *
 * @author admin
 * @date 2019-10-02
 */
public interface IActIdUserService
{
    /**
     * 查询流程用户
     *
     * @param id 流程用户ID
     * @return 流程用户
     */
    public ActIdUser selectActIdUserById(String id);

    /**
     * 查询流程用户列表
     *
     * @param actIdUser 流程用户
     * @return 流程用户集合
     */
    public List<ActIdUser> selectActIdUserList(ActIdUser actIdUser);

    /**
     * 新增流程用户
     *
     * @param actIdUser 流程用户
     * @return 结果
     */
    public int insertActIdUser(ActIdUser actIdUser);

    /**
     * 修改流程用户
     *
     * @param actIdUser 流程用户
     * @return 结果
     */
    public int updateActIdUser(ActIdUser actIdUser);

    /**
     * 批量删除流程用户
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActIdUserByIds(String ids);

    /**
     * 删除流程用户信息
     *
     * @param id 流程用户ID
     * @return 结果
     */
    public int deleteActIdUserById(String id);

    /**
     * 根据用户ID查询所在用户组
     * @param userId 流程用户ID
     * @return 所在用户组集合
     */
    List<ActIdGroup> selectGroupByUserId(String userId);

    List<User> selectUnAssociatedSystemUserList(User sysUser);
}
