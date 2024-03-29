package org.sharebook.repository.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sharebook.model.Follow;
import org.sharebook.repository.FollowRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class FollowRepositoryImpl implements FollowRepository {

    private final QueryRunner queryRunner;

    public FollowRepositoryImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }

    @Override
    public Follow findById(Long userId) {
        String sql = "SELECT * FROM `follow` WHERE `user_id` = ?";
        Follow follow = null;
        try {
            follow = queryRunner.query(
                    sql,
                    new BeanHandler<>(
                            Follow.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    userId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return follow;
    }

    @Override
    public int save(Follow follow) {
        String sql = "INSERT INTO `follow`(`id`,`user_id`,`follow_user_id`," +
                "`create_time`,`update_time`) VALUES (?,?,?,?,?)";
        int count = 0;
        try {
            count = queryRunner.execute(
                    sql,
                    follow.getId(),
                    follow.getUserId(),
                    follow.getFollowUserId(),
                    follow.getCreateTime(),
                    follow.getUpdateTime()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(Follow follow) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<Follow> findFollowByUserId(Long userId) {
        String sql = "SELECT * FROM `follow` WHERE `user_id` = ?";
        List<Follow> follows = null;
        try {
            follows = queryRunner.query(
                    sql,
                    new BeanListHandler<>(
                            Follow.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    userId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return follows;
    }

    @Override
    public List<Follow> findUserByFollow(Long followUserId) {
        String sql = "SELECT * FROM `follow` WHERE `follow_user_id` = ?";
        List<Follow> follows = null;
        try {
            follows = queryRunner.query(
                    sql,
                    new BeanListHandler<>(
                            Follow.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    followUserId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return follows;
    }

    @Override
    public Follow find(Long userId, Long followUserId) {
        String sql = "SELECT * FROM `follow` WHERE `user_id` = ? AND `follow_user_id` = ?";
        Follow follow = null;
        try {
            follow = queryRunner.query(
                    sql,
                    new BeanHandler<>(
                            Follow.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    userId,
                    followUserId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return follow;
    }

    @Override
    public Long findNumByUserId(Long userId) {
        String sql = "SELECT COUNT(*) AS count FROM `follow` WHERE `user_id` = ?";
        Long count = 0L;
        try {
            count = queryRunner.query(
                    sql,
                    new ScalarHandler<>(),
                    userId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Long findNumByFollowUserId(Long followUserId) {
        String sql = "SELECT COUNT(*) AS count FROM `follow` WHERE `follow_user_id` = ?";
        Long count = 0L;
        try {
            count = queryRunner.query(
                    sql,
                    new ScalarHandler<>(),
                    followUserId
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Follow> findAll() {
        List<Follow> follows = null;
        String sql = "SELECT * FROM `follow`";
        try {
            follows = queryRunner.query(
                    sql,
                    new BeanListHandler<>(
                            Follow.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return follows;
    }

    @Override
    public int delete(Long userId, Long followUserId) {
        String sql = "DELETE  FROM `follow` WHERE `user_id`=? AND `follow_user_id` = ?";
        int count = 0;
        try {
            count = queryRunner.execute(sql, userId, followUserId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Long> findAll(Long id) {
        String sql = "SELECT `follow_user_id` FROM `follow` WHERE `user_id` = ?";
        List<Long> ids = null;
        try {
            ids = queryRunner.query(
                    sql,
                    new ColumnListHandler<>("follow_user_id"),
                    id
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
