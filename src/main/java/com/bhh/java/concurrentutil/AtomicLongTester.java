/**   
 *
 */
package com.bhh.java.concurrentutil;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年2月11日 下午4:09:10
 */
public class AtomicLongTester {
    private static final Logger logger = LoggerFactory.getLogger(AtomicLongTester.class);

    /** 
    * @author haihuab 
    * @param args
    * @throws
    */
    public static void main(String[] args) {
        AtomicInteger al = new AtomicInteger(Integer.MIN_VALUE);
        for (int i = 0; i < 100; i++) {
            logger.info("{}", al.incrementAndGet() % 9);
        }
    }
}
