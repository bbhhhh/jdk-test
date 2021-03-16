package com.bhh.java.concurrentutil.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/31 9:55
 * @Description: TODO
 */

public class Horse implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Horse.class);
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b) {
        barrier = b;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                strides += rand.nextInt(3); // 0, 1, 2
                logger.info("strides={}", strides);
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            } catch (BrokenBarrierException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }
}
