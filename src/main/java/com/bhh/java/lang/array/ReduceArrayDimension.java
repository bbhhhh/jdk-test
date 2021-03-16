package com.bhh.java.lang.array;

import java.util.Arrays;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/26 14:13
 * @Description: TODO
 */

public class ReduceArrayDimension {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ReduceArrayDimension.class);

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};

        logger.info("{}", Arrays.toString(a));

        int[] oneDim = Arrays.stream(a).flatMapToInt(x -> Arrays.stream(x)).toArray();

        logger.info("{}", Arrays.toString(oneDim));
    }
}
