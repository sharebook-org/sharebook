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

    List<User> findUsers(List<Long> ids);
}
