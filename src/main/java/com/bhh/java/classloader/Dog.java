package com.bhh.java.classloader;

import java.util.concurrent.TimeUnit;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/11 11:06
 * @Description: TODO
 */

public class Dog implements Runnable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Dog.class);

    @Override
    public void run() {
        int count = 1;
        while (true) {
            //logger.info("xxxxxxx-{}", count);
            logger.info("yyyyyyy-{}", count);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
            count++;
            if (count > 2) {
                break;
            }
        }

    }
}
