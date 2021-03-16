package com.bhh.java.jdk8.functionalinterface;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/26 10:46
 * @Description: TODO
 */
public class SecondFunInterfaceTester {
    private static final Logger logger = LoggerFactory.getLogger(SecondFunInterfaceTester.class);

    static Function produceFunc() {
        return s -> String.valueOf(s);
    }


    public static void main(String[] args) {
        Function convertF = produceFunc();
        logger.info("convert {} to String ={}", 12.2f, convertF.apply(12.2f));
    }
}
