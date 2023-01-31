package com.bhh.java.lang.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/12/16 14:33
 * @Description:
 */

@Slf4j
public class URLTester {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "ab|sd^we|2^3" ;
        log.info("{}", URLEncoder.encode(a,"utf-8")) ;
    }
}
