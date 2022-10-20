package com.bhh.java.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/7/1 15:39
 * @Description:
 */

@Slf4j
public class SqlTester {
    public static final String URL = "jdbc:oracle:thin:@135.251.218.80:1521:hdmdb";
    public static final String USER = "hdmapp7";
    public static final String PASSWORD = "hdmapp7";

    public static void main(String[] args) {
        System.out.println("Data base connection test:");
        //1.加载驱动程序
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        //2. 获得数据库连接
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // insert
            PreparedStatement ps = conn.prepareStatement("select '' from dual");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String v = rs.getString(1);
                log.info("rs.wasNull()={}",rs.wasNull());
                log.info("v == null is {}",v==null);
                log.info("v={}",v);
            }
            rs.close();
            ps.close();


            if (!conn.isClosed()) conn.close();

            Integer a = null;
            int b = a;

        } catch (Exception e) {
            //log.error(throwables.getMessage(), throwables);
        }
    }
}
