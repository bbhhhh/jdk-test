package com.bhh.java.lang;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/7/18 11:24
 * @Description:
 */

@Slf4j
public class BitOperationTester {
    public static void main(String[] args){
        int a=3, b = 1;
        log.info("a={},b={}",a,b);
        int c = a & b ;
        log.info("c={}",c);
        int d = a << b ;
        log.info("d={}",d);
    }
}
