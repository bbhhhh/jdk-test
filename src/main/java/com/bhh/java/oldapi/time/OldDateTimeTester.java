package com.bhh.java.oldapi.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/29 10:46
 * @Description: TODO
 */

public class OldDateTimeTester {
    public static void main(String[] args) throws ParseException {
        System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date d = sdf.parse("20230215");
        System.out.println(d);
    }
}
