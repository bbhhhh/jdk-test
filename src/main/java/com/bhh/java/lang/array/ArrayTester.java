package com.bhh.java.lang.array;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/17 13:34
 * @Description: TODO
 */

public class ArrayTester {
    private static final Logger logger = LoggerFactory.getLogger(ArrayTester.class);

    public static void main(String[] args) {
        String[] aaa = new String[]{};
        logger.info("{}", Arrays.toString(aaa));
        Object[] oa = new Object[3];
        oa[0] = new Object();
        Object o = oa[0];
        logger.info("oa[0]={}", oa[0]);
        logger.info("o={}", o);
        logger.info("oa[0] == null is {}", (oa[0] == null));
        logger.info("o == null is {}", (o == null));
        oa[0] = null;
        logger.info("oa[0]={}", oa[0]);
        logger.info("o={}", o);
        logger.info("oa[0] == null is {}", (oa[0] == null));
        logger.info("o == null is {}", (o == null));
        Object c = o;
        logger.info("o={}", o);
        logger.info("c={}", c);
        o = null;
        logger.info("o={}", o);
        logger.info("c={}", c);

        Object[] ob = oa;
        logger.info("ob.length={}", ob.length);
        int[] ia = new int[3];
        logger.info("ia.len={}, ia[2]={}", ia == null ? 0 : ia.length, ia[2]);
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        logger.info("a.length={}", a.length);
    }
}
