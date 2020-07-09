package com.bhh.java.concurrentutil;

import java.util.concurrent.TimeUnit;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/3 11:19
 * @Description: TODO
 */

public class TimeUnitTester {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("starting...");
        TimeUnit.SECONDS.sleep(-1000000000);
        System.out.println("stop");
    }
}
