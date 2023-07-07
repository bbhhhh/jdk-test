package com.bhh.java.lang.collection;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/3/27 16:18
 * @Description:
 */

@Slf4j
public class SetTester {
    public static void main(String[] args){
        Set<String> myset = new HashSet<>();
        Set<String> myset2 = new HashSet<>();

        myset.add("a");
//        myset2.add(null);

        log.info("{}",myset.contains(""));
        log.info("{}",myset.contains(null));
        log.info("{}",myset2.contains(null));

    }
}
