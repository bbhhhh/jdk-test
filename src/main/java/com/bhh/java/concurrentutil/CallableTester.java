package com.bhh.java.concurrentutil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/23 16:53
 * @Description: TODO
 */

public class CallableTester implements Callable<String> {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CallableTester.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> fut = es.submit(new CallableTester());
        es.shutdownNow();
        while (!fut.isDone()) {
            TimeUnit.MILLISECONDS.sleep(5);
        }
        logger.info("future={}", fut.get());

    }


    @Override
    public String call() throws Exception {
        long now = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {

        }
        return "Take " + (System.currentTimeMillis() - now) + " million secs";
    }
}
