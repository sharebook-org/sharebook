package org.sharebook.service;

import org.sharebook.model.User;

import java.util.List;

public interface AdminService {

    /**
     *
     * @param page
     * @param size
     * @return
     */
    List<User> getAllUsers(int page,int size);

    /**
     *
     * @param id
     * @param role
     * @return
     */
    int updateRole(long id,int role);

    /**
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(long id,int status);

    /**
     *
     * @param id
     * @return
     */
    int deleteUser(long id);
}