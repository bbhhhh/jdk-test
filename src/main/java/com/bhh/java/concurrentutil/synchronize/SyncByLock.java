package com.bhh.java.concurrentutil.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/6 14:16
 * @Description: TODO
 */

public class SyncByLock implements Runnable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SyncByLock.class);

    private static int a;
    private static boolean flag = false;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

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
        lock.lock();
        try {
            a++;
            flag = true;
            condition.signalAll();
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            lock.unlock();
        }
        logger.info("write completed.");
    }

    public void read() {
        logger.info("reader start");
        lock.lock();
        try {
            if (!flag) {
                try {
                    logger.info("writing not done, waiting...");
                    condition.await();
                    logger.info("wake up from waiting.");
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            if (flag) {
                logger.info("writing done");
                logger.info("a^2={}", a * a);
            }
        } finally {
            lock.unlock();
        }
        logger.info("read completed");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SyncByLock(), "writer");
        Thread t2 = new Thread(new SyncByLock(), "reader");
        t2.start();
//        try {
//            TimeUnit.MILLISECONDS.sleep(50);
//        } catch (InterruptedException e) {
//            logger.error(e.getMessage(), e);
//        }
        t1.start();
        Thread.yield();
    }
}
