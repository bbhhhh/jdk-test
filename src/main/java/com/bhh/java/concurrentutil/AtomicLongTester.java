/**   
 *
 */
package com.bhh.java.concurrentutil;

import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年2月11日 下午4:09:10
 */
public class AtomicLongTester implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(AtomicLongTester.class);

    private static AtomicLong atomL = new AtomicLong(0);

    /** 
    * @author haihuab 
    * @param args
    * @throws
    */
    public static void main(String[] args) {
        //        AtomicInteger al = new AtomicInteger(Integer.MIN_VALUE);
        //        for (int i = 0; i < 100; i++) {
        //            logger.info("{}", al.incrementAndGet() % 9);
        //        }

        for (int i = 0; i < 10; i++) {
            new Thread(new AtomicLongTester()).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        logger.info("{}", Thread.activeCount());
        for (Entry<Thread, StackTraceElement[]> en : Thread.getAllStackTraces().entrySet()) {
            logger.info("{} isalive={}, isdaemon={},", en.getKey().getName(), en.getKey().isAlive(), en.getKey().isDaemon());
        }
        logger.info("{}", atomL.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            atomL.getAndIncrement();
        }
    }
}
