package com.bhh.java.lang.abstractclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/9/21 14:13
 * @Description:
 */

@Slf4j
public class Son extends Father{

    @Override
    void go() {
        log.info("go by son");
//        run();
        super.go();
    }

    @Override
    void run() {
        log.info("i'm son");
    }
}
