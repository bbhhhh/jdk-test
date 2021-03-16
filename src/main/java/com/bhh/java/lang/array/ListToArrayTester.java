package com.bhh.java.lang.array;

import java.util.LinkedList;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/3/4 14:48
 * @Description: TODO
 */

public class ListToArrayTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ListToArrayTester.class);

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < 10; i++)
            list.add(i);

        Integer[] arr = (Integer[]) list.toArray();


    }
}
