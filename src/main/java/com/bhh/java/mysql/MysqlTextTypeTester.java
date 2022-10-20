package com.bhh.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/4/1 9:08
 * @Description: TODO
 */

@Slf4j
public class MysqlTextTypeTester {
    public static final String URL = "jdbc:mysql://135.251.218.80:3306/jkzh";
    public static final String USER = "jkzh";
    public static final String PASSWORD = "jkzh";

    public static void main(String[] args) throws Exception {
        log.info("Data base connection test:");
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[65536] ;
        for (int a:arr){
            sb.append("t");
        }
        String largeStr = sb.toString();
        log.info("largeStr len={}",largeStr.length());

        // insert
        PreparedStatement ps = conn.prepareStatement("INSERT  INTO hgu_data_text VALUES (?,?)");
        ps.setString(1,String.valueOf(System.currentTimeMillis()));
        ps.setString(2, largeStr);

        if (ps.executeUpdate() > 0) {
            log.info("Insert into success");
        }
        ps.close();

        largeStr = "";
        ps = conn.prepareStatement("select data from hgu_data_text");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            largeStr = rs.getString(1);
        }

        log.info("largeStr len={}",largeStr.length());

        rs.close();
        ps.close();
        if (!conn.isClosed()) conn.close();
    }
}
