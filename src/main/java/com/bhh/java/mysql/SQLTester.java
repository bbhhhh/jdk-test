package com.bhh.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/4/1 9:08
 * @Description: TODO
 */

public class SQLTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SQLTester.class);
    public static final String URL = "jdbc:mariadb://192.168.56.105:3306/hx_db?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        System.out.println("Data base connection test:");
        //1.加载驱动程序
        Class.forName("org.mariadb.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        // insert
        PreparedStatement insertPrepareStatement = conn.prepareStatement("INSERT  INTO nc_opening_period VALUES (?,?)");
        long now = System.currentTimeMillis();
        logger.info("now={}",now);
        insertPrepareStatement.setTimestamp(1, new Timestamp(now));
        insertPrepareStatement.setTimestamp(2, new Timestamp(now));

        if (insertPrepareStatement.executeUpdate() > 0) {
            logger.info("Insert into success");
        }
        insertPrepareStatement.close();


        if (!conn.isClosed()) conn.close();
    }
}
