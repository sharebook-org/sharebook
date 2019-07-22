package org.sharebook.repository;

import org.sharebook.model.User;

/**
 * 数据访问层接口
 */
public interface UserRepository extends CurdRepository<User, Long> {
    User findByUsername(String username);
}
