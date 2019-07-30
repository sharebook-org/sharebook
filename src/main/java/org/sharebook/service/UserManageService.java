package org.sharebook.service;

import org.sharebook.model.User;

import java.util.List;

public interface UserManageService {

    /**
     * 分页查询用户
     *
     * @param page
     * @param size
     * @return
     */
    List<User> getAllUsers(int page, int size);

    /**
     * 更新用户角色
     *
     * @param id
     * @param role
     * @return
     */
    int updateRole(long id, int role);

    /**
     * 更新用户状态
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(long id, int status);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(long id);
}