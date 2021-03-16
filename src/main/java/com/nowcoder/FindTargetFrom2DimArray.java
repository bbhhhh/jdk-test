package com.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/26 11:27
 * @Description: TODO
 */

public class FindTargetFrom2DimArray {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(FindTargetFrom2DimArray.class);

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        logger.info("a.length={}", a.length);
        logger.info("find result={}", Find(9, a));
    }

    public static boolean Find(int target, int[][] array) {

        int[] oneDim = Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x)).toArray();

        Arrays.sort(oneDim);
        int pos = Arrays.binarySearch(oneDim, target);

        return (pos >= 0) ? true : false;
    }
}
