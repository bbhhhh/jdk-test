package com.bhh.java.lang.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/26 13:33
 * @Description: TODO
 */

public class ConvertArrayToListTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ConvertArrayToListTester.class);

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "b", "c");
        // wrong code
        //java.lang.UnsupportedOperationException
        //stringList.add("sdf");
        logger.info("the class name={}", stringList.getClass().getSimpleName());

        Integer[] a = {1, 2, 3};
        List<Integer> testList = Arrays.asList(a);
        // wrong code
        // java.lang.UnsupportedOperationException
        //testList.add(345);
        logger.info("the class name={}", testList.getClass().getSimpleName());

        List<String> stringList2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        stringList2.add("asdf");

        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, a);
        integerList.add(356);
        logger.info("list size={}", integerList.size());

        int[] input = {5, 3, 1, 6, 4, 7, 8, 9};
        Arrays.sort(input);
        ArrayList<Integer> list2 = new ArrayList<>();
        //wrong code,
        //Collections.addAll(list2, Arrays.copyOfRange(input, 0, 3));

    }
}
