package com.bhh.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Description //TODO
 * @Author haihuab
 * @Date 2020/5/18 13:06
 **/
public class DoubleTester {
    private static final Logger Logger = LoggerFactory.getLogger(DoubleTester.class);


    /**
     * @Description //TODO
     * @Author haihuab
     * @Date 2020/5/18 13:11
     * @Param args
     * @Return void
     **/
    public static void main(String... args) {
        int a = 0;
        String aa = "";

        Boolean b1 = Boolean.valueOf("true");

        long aaa = 1000;
        int bbb = 2000;
        double ccc = 0.8;

        Logger.info("{}",(double)aaa/bbb);
        Logger.info("{}",ccc<=((double)aaa/bbb));

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Logger.error(e.getMessage(), e);
        }

    }


    /**
     * @Description //TODO
     * @Author haihuab
     * @Date 2020/5/18 13:10
     * @Param a
     * @Param o
     * @Return java.lang.String[]
     **/
    public String[] getStrs(int a, Object o) {
        return new String[a];
    }
}
