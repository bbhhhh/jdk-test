package com.bhh.java.concurrentutil;

import java.util.concurrent.TimeUnit;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/25 15:58
 * @Description: TODO
 */

public class StartOneThreadTwiceTester implements Runnable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StartOneThreadTwiceTester.class);

    @Override
    public void run() {
        logger.info("now={}", System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("now={}", System.currentTimeMillis());
    }

    public static void main(String[] args) {
        Thread t = new Thread(new StartOneThreadTwiceTester());
        t.start();
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
