package com.bhh.java.memleak;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/14 14:53
 * @Description: TODO
 */

public class MemLeakTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MemLeakTester.class);

    public static void main(String[] args) {
        Object[] oa = new Object[10];

        for (int i = 0; i < 10; i++) {
            oa[i] = new Object();

        }

        Object o = pop(oa);
        logger.info("poped object={}", o);
        logger.info("last object={}", oa[oa.length - 1]);
    }

    public static Object pop(Object[] oarray) {
        Object o = null;
        if (oarray != null && oarray.length > 0) {
            o = oarray[oarray.length - 1];
            oarray[oarray.length - 1] = null;
        }

        return o;
    }
}
