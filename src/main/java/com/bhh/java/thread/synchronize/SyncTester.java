package com.bhh.java.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/27 11:13
 * @Description: TODO
 */

public class SyncTester implements Runnable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SyncTester.class);

    public static void main(String[] args) {
        Thread t1 = new Thread(new SyncTester());
        Thread t2 = new Thread(new SyncTester());
        t1.start();
        t2.start();
    }

    public static void m1() {
        synchronized (StaticInnerC.class) {
            StaticInnerC.s1();
        }
        synchronized (StaticInnerC.class) {
            new StaticInnerC().s2();
        }

    }

    @Override
    public void run() {
        m1();
    }

    static class StaticInnerC {
        void s2() {
            for (int i = 0; i < 5; i++) {
                logger.info("s={}", i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }

        static void s1() {
            for (int i = 0; i < 5; i++) {
                logger.info("i={}", i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }
}

