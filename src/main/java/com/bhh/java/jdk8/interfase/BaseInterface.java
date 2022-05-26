package com.bhh.java.jdk8.interfase;

import java.util.Collection;
import java.util.Iterator;

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

    public static void main(String[] args){
        BaseInterface bi = new BaseInterface() {    };
        bi.printHello();

    }
}
