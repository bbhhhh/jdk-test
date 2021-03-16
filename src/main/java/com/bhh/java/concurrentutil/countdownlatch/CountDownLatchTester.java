package com.bhh.java.concurrentutil.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/31 14:01
 * @Description: TODO
 */

public class CountDownLatchTester implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(CountDownLatchTester.class);
    private final CountDownLatch latch;

    static Random rand = new Random(47);

    public CountDownLatchTester(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            logger.info("before latch await...");
            latch.await(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("CountDownLatch barrier passed waiting task");
    }

    public static void main(String[] args) {
        int num = 10;
        CountDownLatch latch = new CountDownLatch(num);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new CountDownLatchTester(latch));
        for (int i = 0; i < num; i++) {
            exec.execute(new WorkingTask(latch));
        }
        logger.info("all working task launched");
        exec.shutdown();
    }

    static class WorkingTask implements Runnable {
        private final CountDownLatch latch;

        public WorkingTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(5000));
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
            logger.info("{} workingTask completed.", Thread.currentThread().getName());
            latch.countDown();
        }
    }
}
