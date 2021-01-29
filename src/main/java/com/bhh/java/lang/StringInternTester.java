package com.bhh.java.lang;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/22 15:36
 * @Description: TODO
 */

public class StringInternTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StringInternTester.class);

    public static void main(String[] args) {
        String a = "a";
        System.out.println(a.intern() == a);

        String b = new String("b");
        System.out.println(b.intern() == b);
        String e = new String("b");
        System.out.println(e.intern() == b.intern());

        String c = new StringBuilder("sb").toString();
        System.out.println(c.intern() == c);

        String d = new StringBuilder("sb").toString();
        System.out.println(d.intern() == d);
        System.out.println(d.intern() == c.intern());
        String f = "sb";
        System.out.println(d.intern() == f);


    }
}
