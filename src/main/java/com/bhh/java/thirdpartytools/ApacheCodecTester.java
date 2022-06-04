package com.bhh.java.thirdpartytools;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/5/30 16:09
 * @Description:
 */

@Slf4j
public class ApacheCodecTester {
    public static void main(String[] args){
        String a = "abc";
        String b = "";
        log.info("md5({})={}",a, DigestUtils.md5Hex(a));
        log.info("md5('abc')={}", DigestUtils.md5Hex("abc"));
        log.info("md5({})={}",b, DigestUtils.md5Hex(b));
        log.info("md5('')={}", DigestUtils.md5Hex(""));

    }
}
