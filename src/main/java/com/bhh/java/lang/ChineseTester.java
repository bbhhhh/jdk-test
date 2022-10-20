package com.bhh.java.lang;

import java.nio.charset.Charset;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/7/22 9:34
 * @Description:
 */

@Slf4j
public class ChineseTester {
    public static void main(String[] args){
        String a = "中华的司法";
        log.info("len of {} = {}",a,a.length());
        log.info("bytes len of {}={}",a,a.getBytes(Charset.forName("UTF-8")).length);
    }
}

