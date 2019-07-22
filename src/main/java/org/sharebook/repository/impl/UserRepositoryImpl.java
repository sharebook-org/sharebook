package org.sharebook.repository.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.sharebook.constant.UserStatus;
import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.Date;

public class UserRepositoryImpl implements UserRepository {

    private final QueryRunner queryRunner;

    public UserRepositoryImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM `user` WHERE `id` = ?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int save(User user) {
        //TODO 写SQL太复杂
        String sql = "INSERT INTO `user`(`username`,`password`," +
                "`salt`,`sex`,`status`,`role`,`avatar`," +
                "`create_time`,`update_time`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            return queryRunner.execute(
                    sql,
                    user.getUsername(),
                    user.getPassword(),
                    user.getSalt(),
                    user.getSex(),
                    user.getStatus(),
                    user.getRole(),
                    user.getAvatar(),
                    user.getCreateTime(),
                    user.getUpdateTime()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE `user` SET `username` = ?, `introduction` = ?," +
                " `sex` = ?, `birth` = ?, `location` = ?, `status` = ?," +
                " `role` = ?, `avatar` = ?, `update_time` = ? WHERE `id` = ?";
        try {
            return queryRunner.update(
                    sql,
                    user.getUsername(),
                    user.getIntroduction(),
                    user.getSex(),
                    user.getBirth(),
                    user.getLocation(),
                    user.getStatus(),
                    user.getRole(),
                    user.getAvatar(),
                    new Date(),
                    user.getId()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //非真实删除
    @Override
    public int delete(Long id) {
        String sql = "UPDATE `user` SET `status` = ? WHERE `id` = ?";
        try {
            return queryRunner.update(sql, UserStatus.DELETED, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM `user` WHERE `username` = ?";
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
