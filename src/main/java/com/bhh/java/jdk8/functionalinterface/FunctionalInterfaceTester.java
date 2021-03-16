package com.bhh.java.jdk8.functionalinterface;

import java.util.function.IntFunction;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/23 15:12
 * @Description: TODO
 */

public class FunctionalInterfaceTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(FunctionalInterfaceTester.class);

    public static void main(String[] args) {

        String result = new FunctionalInterfaceTester().applyIntFunction(i -> {
            String s = String.valueOf(i);
            logger.info("String of int {} = {}", i, s);
            return s;
        }, 10);

        logger.info("result={}", result);
    }

    public <R> R applyIntFunction(IntFunction<R> intFunction, int value) {
        return intFunction.apply(value);
    }
}
