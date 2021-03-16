package com.bhh.java.concurrentutil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.bhh.java.jdk8.functionalinterface.My1stFuncInterface;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/25 11:15
 * @Description: TODO
 */

public class ExecuteServiceTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ExecuteServiceTester.class);

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
//        es.submit(() -> logger.info("lambdas running called by ExecutorService.submit()."));
//        es.submit(new ExecuteServiceTester().new NotRunable()::test);
//        es.execute(() -> logger.info("lambdas running called by ExecutorService.execute()."));

        es.shutdown();

        new ExecuteServiceTester().doFuncInterface((x) -> logger.info("{}, lambdas of doFuncInterface", x));
        new ExecuteServiceTester().callRunnable(() -> logger.info("lambdas called by callRunnable"));
        new ExecuteServiceTester().doFuncInterface(new ExecuteServiceTester().new NotRunable()::print);

        List<String> sList = Arrays.asList("a", "b", "c");
        sList.forEach(x -> logger.info("{}", x));
    }

    public void callRunnable(Runnable runnable) {
        runnable.run();
    }

    public void doFuncInterface(My1stFuncInterface funcInterface) {
        logger.info("before call functionalInterface");
        funcInterface.apply("hello func interface");
        logger.info("after call functionalInterface");
    }

    class NotRunable<T> {
        public void test() {
            logger.info("method test() be called...");
        }

        public void print(T s) {
            logger.info("method print be called, s={}", s);
        }

    }
}
