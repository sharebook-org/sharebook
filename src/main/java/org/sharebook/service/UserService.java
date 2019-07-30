package org.sharebook.service;

import org.sharebook.model.Active;
import org.sharebook.model.User;

import java.util.List;

public interface UserService {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    boolean login(User user);

    /**
     * 账号登录
     *
     * @param account  邮箱或手机号
     * @param password 密码
     * @return
     */
    User login(String account, String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 修改信息
     *
     * @param user
     * @return
     */
    boolean modify(User user);

    /**
     * 判断用户是否存在
     *
     * @param username
     * @return
     */
    boolean isExistUser(String username);

    /**
     * 根据ID查看个人信息
     *
     * @param id
     * @return
     */
    User findUserById(Long id);

    List<User> findUsers(List<Long> ids);

    /**
     * 根据名字查看个人信息
     *
     * @param name
     * @return
     */
    User findUserByName(String name);

    Long getCount();

    boolean modifyPassword(User user);

    boolean checkCode(String email, String code);

    boolean getCode(String email);

    Active findByAccount(String account);
}
