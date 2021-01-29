package com.bhh.java.lang;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/25 14:07
 * @Description: TODO
 */

public class SetAndDequeTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SetAndDequeTester.class);

    public static void main(String[] args) {
        Deque de = new ArrayDeque<>();
        Set set;
        de.add(1);
        de.add(2);
        de.add(1);

        set = new HashSet<>(de);
        System.out.println(set.size());

    }
}
