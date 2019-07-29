package org.sharebook.repository;

import org.sharebook.model.User;

import java.util.List;

/**
 * 数据访问层接口
 */
public interface UserRepository extends CurdRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAll(int page, int size);

    long getUsersCount();

    int modifyPassword(User user);

    /**
     * 根据邮箱查找用户
     *
     * @param email 邮箱
     * @return 用户存在时返回用户实体，否则返回null。
     */
    User findByEmail(String email);

    /**
     * 根据手机号查找用户
     *
     * @param phone 手机号
     * @return 用户存在时返回用户实体，否则返回null。
     */
    User findByPhone(String phone);
}
