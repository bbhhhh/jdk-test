package com.bhh.java.lang;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/19 14:53
 * @Description: TODO
 */

public class CloneAbleTester implements Cloneable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CloneAbleTester.class);

    private int[] elements;

    public CloneAbleTester(int size) {
        elements = new int[size];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = -1;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        CloneAbleTester v = (CloneAbleTester) super.clone();
        v.elements = Arrays.copyOf(elements, elements.length);

        return v;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneAbleTester cat = new CloneAbleTester(5);
        for (int e1 : cat.elements) {
            logger.info("{}", e1);
        }
        CloneAbleTester c2 = (CloneAbleTester) cat.clone();
        for (int e2 : c2.elements) {
            logger.info("{}", e2);
        }
    }
}
