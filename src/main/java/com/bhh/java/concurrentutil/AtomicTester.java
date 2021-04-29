package com.bhh.java.concurrentutil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project: process
 * @Author : haihuab
 * @Date : 2021/4/28 11:26
 * @Description: TODO
 */

public class AtomicTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AtomicTester.class);

    private static final AtomicInteger ai = new AtomicInteger(Integer.MAX_VALUE);
    public static void main(String[] args){
        logger.info("{}",Math.abs(ai.getAndIncrement())%4);
        logger.info("{}",Math.abs(ai.getAndIncrement())%4);
        logger.info("{}",Math.abs(ai.getAndIncrement())%4);
        logger.info("{}",Math.abs(ai.getAndIncrement())%4);
        logger.info("{}",Math.abs(ai.getAndIncrement())%4);
        logger.info("{}",Math.abs(ai.getAndIncrement())%4);
        logger.info("{}",Math.abs(ai.getAndIncrement())%4);
        logger.info("{}",Math.abs(ai.getAndIncrement())%4);

        String b=null ;
        setV(b);
        logger.info("{}",b);

    }


    public static void setV(String a){
        a = "set by setV";
    }

}
