package com.bhh.java.lang;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/16 10:46
 * @Description: TODO
 */

public class CharacterTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CharacterTester.class);

    public static void main(String[] args) {
        char c = '3';
        System.out.println(Character.getNumericValue(c));
        System.out.println((int) c);
        System.out.println(Integer.toHexString(c));
        c = '重';
        System.out.println((int) c);
        System.out.println(Integer.toHexString(c));
        char d = '\u91cd';
        System.out.println(d);

    }

}
