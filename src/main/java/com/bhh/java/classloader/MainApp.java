package com.bhh.java.classloader;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/11 11:06
 * @Description: TODO
 */

public class MainApp {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            new Thread(new Dog()).start();
        }


    }
}
