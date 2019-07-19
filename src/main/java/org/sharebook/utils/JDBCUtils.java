package org.sharebook.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * 使用P3C0连接池和DBUtils简化数据库操作
 */
public class JDBCUtils {

    private static final DataSource dataSource = new ComboPooledDataSource();

    public static QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }
}
