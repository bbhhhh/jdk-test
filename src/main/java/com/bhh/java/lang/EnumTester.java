package com.bhh.java.lang;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/9/15 15:23
 * @Description:
 */

@Slf4j
public class EnumTester {
    public static void main(String[] args){
        log.info("{}",Color.GREEN.equals(Color.valueOf("GREEN")));
    }
}

enum Color{
    RED, GREEN
}
