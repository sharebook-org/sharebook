package org.sharebook.dao;

import org.sharebook.model.User;
import org.sharebook.utils.JDBCUtil;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserDao implements CurdRepository<User, Long> {

    private final Connection conn;

    /**
     * 通过构造函数初始化Connection对象
     */
    public UserDao() {
        this.conn = JDBCUtil.getConn();
    }

    @Override
    public User findById(Long id) {
        String sql = "select * from `user` where `id` = ?";
        List<Map<String, Object>> list = JDBCUtil.executeQuery(sql, conn, id);
        //查询结果为空
        if (list.size() == 0) {
            return null;
        }
        //通过主键只会获取一个对象
        Map<String, Object> userMap = list.get(0);
        //构造User对象
        User user = new User(
                (Long) userMap.get("id"),
                (String) userMap.get("username"),
                (String) userMap.get("password"),
                (String) userMap.get("salt"),
                (String) userMap.get("introduction"),
                (Integer) userMap.get("sex"),
                (Date) userMap.get("birth"),
                (String) userMap.get("location"),
                (Integer) userMap.get("status"),
                (Integer) userMap.get("role"),
                (String) userMap.get("avatar"),
                (Date) userMap.get("create_time"),
                (Date) userMap.get("update_time")
        );
        return user;
    }

    @Override
    public List<User> findAllById(Long id) {
        return null;
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }
}
