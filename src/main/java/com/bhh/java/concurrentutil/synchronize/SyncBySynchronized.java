package com.bhh.java.concurrentutil.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/6 14:40
 * @Description: TODO
 */

public class SyncBySynchronized implements Runnable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SyncBySynchronized.class);
    private static int a;
    private static boolean flag = false;
    private static Object locker = new Object();

    @Override
    public void run() {
        if ("writer".equalsIgnoreCase(Thread.currentThread().getName())) {
            write();
        } else {
            read();
        }
    }

    public void write() {
        logger.info("writer start");
        synchronized (locker) {
            a++;
            flag = true;
            locker.notifyAll();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
        }
        logger.info("write completed.");
    }

    public void read() {
        logger.info("reader start");
        synchronized (locker) {
            if (!flag) {
                try {
                    locker.wait();
                    logger.info("wake up from waiting");
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            if (flag) {
                logger.info("a^2={}", a * a);
            }
        }
        logger.info("read completed");

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SyncBySynchronized(), "writer");
        Thread t2 = new Thread(new SyncBySynchronized(), "reader");
        t2.start();
        t1.start();
    }

}
