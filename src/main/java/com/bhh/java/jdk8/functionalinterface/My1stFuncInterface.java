package com.bhh.java.jdk8.functionalinterface;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/23 16:47
 * @Description: TODO
 */
@FunctionalInterface
public interface My1stFuncInterface<T> {

    void apply(T t);


    default void doSomething(T t) {
        System.out.println("I'm default implementation of doSomething()");
    }

    default void doAnything(T t) {
        System.out.println("I'm default implementation of doAnything()");
    }

}
