package com.bhh.java.lang;

import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @author : haihuab
 * @date Date : 2020/5/27 10:35
 * @Description: TODO
 */

@Slf4j
public class ExceptionTryCatchFinallyTester {

    public static void test() throws Exception {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.err.println("catch by test");
            throw e;
        } finally {
            System.out.println("test final print");
        }
    }

    static void tt2() throws SQLException{
        Integer a = null;
        try {
            int b = a;
            System.out.println(b);
        }catch(Exception e){
            throw e;
        }
    }

    public static void main(String... args) {
//        try {
//            test();
//        } catch (Exception e) {
//            System.err.println("catch by main");
//            e.printStackTrace();
//        }

        try{
            tt2();
            int a = Integer.parseInt("a1");
        }catch(Exception e){
            //e.printStackTrace();
            log.error(e.getMessage());
            log.error(e.getLocalizedMessage());
            log.error(e.toString());
        }
    }
}
