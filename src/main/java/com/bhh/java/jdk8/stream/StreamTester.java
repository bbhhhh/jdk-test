package com.bhh.java.jdk8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/26 15:36
 * @Description: TODO
 */

public class StreamTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StreamTester.class);

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[][] b = {{1, 2}, {3, 4, 5}};
        Class[] c = {String.class, Integer.class};

        IntStream s1 = Arrays.stream(a);
        long c1 = s1.flatMap(x -> Arrays.stream(new int[x])).count();
        logger.info("s1 class name={}", s1.getClass().getName());
        logger.info("c1={}", c1);
        Stream s2 = Arrays.stream(b);
        s2.flatMapToInt(x -> Arrays.stream((int[]) x)).forEach(x -> logger.info("{}", x));
        s2 = Arrays.stream(b);
        s2.flatMapToInt(x -> Arrays.stream((int[]) x)).mapToObj(String::valueOf).forEach(logger::info);
        s2 = Arrays.stream(b);
        long c2 = s2.flatMapToInt(x -> Arrays.stream((int[]) x)).count();
        logger.info("s2 class name={}", s2.getClass().getName());
        logger.info("c2={}", c2);

        Stream s3 = Arrays.stream(c);
        String s3ArrayStr = Arrays.toString(s3.map(x -> ((Class) x).getSimpleName()).toArray());
        logger.info("s3 class name={}", s3.getClass().getName());
        logger.info("s3ArrayStr={}", s3ArrayStr);


    }
}
