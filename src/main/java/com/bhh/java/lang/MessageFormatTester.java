package com.bhh.java.lang;

import java.text.MessageFormat;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/2/27 16:10
 * @Description:
 */

@Slf4j
public class MessageFormatTester {
    public static void main(String[] args){
        log.info("{}", MessageFormat.format("This is {0} test {1} case", "asdf","efff"));

    }
}
