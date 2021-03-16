package com.bhh.java.lang.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/27 13:26
 * @Description: TODO
 */

public class CollectionArrayTester {
    public static void main(String[] args) {
        List<String>[] listArray = new ArrayList[3];
        String[] sa = new String[3];
        String b = listArray[0].get(0);
    }

    static void dangerous(List<String>... stringLists) {
        Integer[] intList = new Integer[3];
        Object[] obs = stringLists;
        obs[0] = intList;
        String s = stringLists[0].get(0);
    }
}
