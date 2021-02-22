package com.bhh.java.jdk8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/19 15:30
 * @Description: TODO
 */

public class ForEachTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ForEachTester.class);

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            intList.add(i);
        }
        long x = 0;
        int y = 1000000;
        long now = System.currentTimeMillis();
        for (int k = 0; k < y; k++) {
            x = 0;
            for (Integer I : intList) {
                x += I;
            }
        }
        logger.info("for each cost={}", System.currentTimeMillis() - now);

        now = System.currentTimeMillis();
        for (int k = 0; k < y; k++) {
            x = 0;
            for (int j = 0; j < intList.size(); j++) {
                x += intList.get(j);
            }
        }
        logger.info("old for cost={}", System.currentTimeMillis() - now);

    }
}
