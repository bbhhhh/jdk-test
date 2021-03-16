package com.bhh.java.lang.array;

import java.util.Arrays;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/23 10:11
 * @Description: TODO
 */

public class CharArrayTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CharArrayTester.class);

    public static void main(String[] args) {
        String a = "sdfwerf";
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
    }
}
