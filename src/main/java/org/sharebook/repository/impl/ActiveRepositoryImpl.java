package org.sharebook.repository.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.sharebook.model.Active;
import org.sharebook.repository.ActiveRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;

public class ActiveRepositoryImpl implements ActiveRepository {

    private final QueryRunner queryRunner;

    public ActiveRepositoryImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }

    @Override
    public Active findById(Long id) {
        Active active = null;
        String sql = "SELECT * FROM `active_status` WHERE `id` = ?";
        try {
            active = queryRunner.query(
                    sql,
                    new BeanHandler<>(
                            Active.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    id
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return active;
    }

    @Override
    public int save(Active active) {
        int count = 0;
        String sql = "INSERT INTO `active_status`(`user_id`,`code`," +
                "`status`,`create_time`,`update_time`) VALUES (?,?,?,?,?)";
        try {
            count = queryRunner.execute(
                    sql,
                    active.getUserId(),
                    active.getCode(),
                    active.getStatus(),
                    active.getCreateTime(),
                    active.getUpdateTime()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(Active active) {
        int count = 0;
        String sql = "UPDATE `active_status` SET `code` = ?, " +
                "`status` = ?, `update_time` = ? WHERE `id` = ?";
        try {
            count = queryRunner.update(
                    sql,
                    active.getCode(),
                    active.getStatus(),
                    active.getUpdateTime(),
                    active.getId()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = 0;
        String sql = "DELETE FROM `active_status` WHERE `id` = ?";
        try {
            count = queryRunner.execute(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
