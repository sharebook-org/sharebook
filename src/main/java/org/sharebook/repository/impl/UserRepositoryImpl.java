package org.sharebook.repository.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;

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
            throw new RuntimeException(e);
        }
    }

    @Override
    public int save(User user) {
        //TODO 写SQL太复杂
//        String updateSql = "UPDATE `user` ";
//        String insertSql = "INSERT INTO `user`(" +
//                "`username`,`password`,`salt`,`introduction`," +
//                "`sex`,`birth`,`location`,`status`,`role`,`avatar`," +
//                "`create_time`,`update_time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        return 0;
    }

    @Override
    public void delete(Long id) {

    }
}
