package com.bhh.java.lang;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/3/3 11:19
 * @Description:
 */

@Slf4j
public class MathTester {
    public static void main(String[] args){
        long a=10,b=21;
        log.info("{},{},{}",a/b, Math.ceil(a/(double)b),Math.round(Math.ceil(a/(double)b)));
    }
}
