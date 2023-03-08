package com.bhh.java.lang;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/2/22 14:43
 * @Description:
 */

@Slf4j
public class SpecialCharTester {
    public static void main(String[] args){
        String a = "dd\nab" ;
        String b = "eef\\nggd";
        log.info("{},{}",a,b);
    }
}
