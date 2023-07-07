package com.bhh.java.lang.array;


import java.util.Arrays;

import com.bhh.java.lang.json.JsonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/4/27 10:36
 * @Description:
 */

@Slf4j
public class ArrayToStringTester {
    public static void main(String[] args){
        String[] sa = {"a","b"} ;
        log.info("{}", Arrays.toString(sa));

    }
}
