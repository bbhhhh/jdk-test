package com.hackerrank.warmup;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/26 10:35
 * @Description: TODO
 */

public class InnerTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(InnerTester.class);

    static final Integer i1 = 1;
    final Integer i2 = 2;
    Integer i3 = 3;

    public static void main(String[] args) {
        final Integer i4 = 4;
        Integer i5 = 5;
        synchronized (in2.class) {

        }

        class Inner {
            final Integer i6 = 6;

            Integer i7 = 7;

            Inner() {
                System.out.println(i6 + i7);
            }
        }
    }


    static class in2 {
        synchronized void test() {

        }
    }

}
