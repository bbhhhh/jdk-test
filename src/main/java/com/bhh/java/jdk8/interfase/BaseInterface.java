package com.bhh.java.jdk8.interfase;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/17 17:05
 * @Description: TODO
 */
public interface BaseInterface {
    default void printHello() {
        System.out.println("hello");
    }
}
