package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/28 17:02
 * @Description: TODO
 */

public class InnerPrivateClassTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(InnerPrivateClassTester.class);

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
            o = Inner.Private.class.getConstructor().newInstance();
            Method md = Inner.Private.class.getMethod("powerof2", int.class);
            
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not power of 2";
            }
        }
    }
}
