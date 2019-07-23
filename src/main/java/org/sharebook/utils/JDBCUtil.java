package org.sharebook.utils;

import java.sql.*;
import java.util.*;

public class JDBCUtil {
    public static ResourceBundle bundle;

    static {
        //默认获取src资源文件，xxx.properties
        //根据文件名获取
        bundle = ResourceBundle.getBundle("jdbc");
    }

    public static Connection getConn() {
        String driver = bundle.getString("driver");
        Connection conn = null;
        try {
            Class.forName(bundle.getString("driver"));
            conn = DriverManager.getConnection(
                    bundle.getString("url"),
                    bundle.getString("username"),
                    bundle.getString("password")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 把 insert、update、delete三个方法封装
     *
     * @param conn
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Connection conn, Object... params) {
        int result = 0;
        try {
            //sql insert into userinfo values(?,?,?,?,?)
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject((i + 1), params[i]);
            }
            result = ps.executeUpdate();//执行sql语句

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 封装查询方法
     */
    public static List<Map<String, Object>> executeQuery(String sql, Connection conn, Object... params) {
        //登录 select * from user where name=? and pwd=?
        //list所有的记录
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject((i + 1), params[i]);
            }
            ResultSet rs = ps.executeQuery();
            //得到结果集的元数据
            ResultSetMetaData rm = rs.getMetaData();
            //得到列的数目
            int count = rm.getColumnCount();
            while (rs.next()) {
                //map保存的单条记录
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= count; i++) {
                    //不同的字段值,rs.getxxx(i) i是从1开始
                    map.put(rm.getColumnName(i), rs.getObject(i));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
