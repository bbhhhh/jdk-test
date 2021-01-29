package com.bhh.java.thread.synchronize;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/6 14:00
 * @Description: TODO
 */

public class NoSynchronize implements Runnable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(NoSynchronize.class);

    private int a;
    private boolean flag = false;

    @Override
    public void run() {
        if ("writer".equalsIgnoreCase(Thread.currentThread().getName())) {
            write();
        } else {
            read();
        }
    }

    public void write() {

        a = 1;
        flag = true;
        logger.info("write completed.");
    }

    public void read() {
        if (flag) {
            logger.info("a^2={}", a * a);
        }
        logger.info("read completed.");
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new NoSynchronize());
        Thread t2 = new Thread(new NoSynchronize());
        t1.setName("writer");
        t2.setName("reader");

        t1.start();
        t2.start();
    }
}
