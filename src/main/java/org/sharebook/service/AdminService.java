package org.sharebook.service;

import org.sharebook.model.User;

import java.util.List;

public interface AdminService {

    /**
     *分页查询
     *
     * @param page,size
     * @return
     */
    List<User> getAllUsers(int page,int size);
}
