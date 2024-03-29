package org.sharebook.repository.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sharebook.constant.status.UserStatus;
import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;
import org.sharebook.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final QueryRunner queryRunner;

    public UserRepositoryImpl() {
        this.queryRunner = JDBCUtils.getQueryRunner();
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM `user` WHERE `id` = ?";
        User user = null;
        try {
            user = queryRunner.query(
                    sql,
                    new BeanHandler<>(
                            User.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    id
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int save(User user) {
        int count = 0;
        //TODO 写SQL太复杂
        String sql = "INSERT INTO `user`(`username`, `email`, `phone`, `password`," +
                " `salt`, `introduction`, `sex`, `birth`, `location`, `status`, `role`," +
                " `avatar`, `create_time`, `update_time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            count = queryRunner.execute(
                    sql,
                    user.getUsername(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getPassword(),
                    user.getSalt(),
                    user.getIntroduction(),
                    user.getSex(),
                    user.getBirth(),
                    user.getLocation(),
                    user.getStatus(),
                    user.getRole(),
                    user.getAvatar(),
                    user.getCreateTime(),
                    user.getUpdateTime()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(User user) {
        int count = 0;
        String sql = "UPDATE `user` SET `username` = ?, `introduction` = ?, " +
                "`email` = ?, `phone` = ?, `sex` = ?, `birth` = ?, `location` = ?," +
                " `status` = ?, `role` = ?, `avatar` = ?, `update_time` = ? WHERE `id` = ?";
        try {
            count = queryRunner.update(
                    sql,
                    user.getUsername(),
                    user.getIntroduction(),
                    user.getEmail(),
                    user.getPhone(),
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
        }
        return count;
    }

    //非真实删除，封禁用户
    @Override
    public int delete(Long id) {
        String sql = "UPDATE `user` SET `status` = ? WHERE `id` = ?";
        int count = 0;
        try {
            count = queryRunner.update(sql, UserStatus.BANNED, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM `user` WHERE `username` = ?";
        User user = null;
        try {
            user = queryRunner.query(
                    sql,
                    new BeanHandler<>(
                            User.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    username
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll(int page, int size) {
        int offset = (page - 1) * size;
        String sql = "SELECT * FROM `user` LIMIT ?, ?";
        List<User> users = null;
        try {
            users = queryRunner.query(
                    sql,
                    new BeanListHandler<>(
                            User.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    offset,
                    size
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public long getUsersCount() {
        String sql = "SELECT COUNT(*) FROM `user`";
        long count = 0;
        try {
            count = queryRunner.query(sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int modifyPassword(User user) {
        String sql="update user set password=?, salt=? where username=?";
        int result=0;
        try {
            result= queryRunner.execute(sql,user.getPassword(),user.getSalt(),user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM `user` WHERE `email` = ?";
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(
                            User.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())),
                    email
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByPhone(String phone) {
        String sql = "SELECT * FROM `user` WHERE `phone` = ?";
        User user = null;
        try {
            user = queryRunner.query(
                    sql,
                    new BeanHandler<>(
                            User.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    ),
                    phone
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findUsers(List<Long> ids) {
        List<User> users=null;
        StringBuffer sql=new StringBuffer("select * from `user` where `id` in(");
        for (int i = 0; i < ids.size(); i++) {
            if (i == ids.size() - 1) {
                sql.append(ids.get(i));
            } else {
                sql.append(ids.get(i));
                sql.append(",");
            }
        }
        sql.append(")");
        try {
            users = queryRunner.query(
                    sql.toString(),
                    new BeanListHandler<>(
                            User.class,
                            new BasicRowProcessor(new GenerousBeanProcessor())
                    )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
