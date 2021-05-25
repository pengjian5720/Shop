package com.briup.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource dataSource;
    static {
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties pro = new Properties();
            pro.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public void close(Connection conn, Statement stat) {
        close(null, conn, stat);
    }
    public void close(ResultSet rt, Connection conn, Statement stat) {
        try {
            if(rt != null)rt.close();
            if(stat != null)stat.close();
            if(conn != null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
