package com.bhh.java.lang;

/**
 * @Project: jdk-test
 * @author : haihuab
 * @date Date : 2020/5/27 10:35
 * @Description: TODO
 */

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

    public static void main(String... args) {
        try {
            test();
        } catch (Exception e) {
            System.err.println("catch by main");
            e.printStackTrace();
        }
    }
}
