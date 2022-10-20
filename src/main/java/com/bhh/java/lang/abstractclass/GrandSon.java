package com.bhh.java.lang.abstractclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/9/21 14:16
 * @Description:
 */

@Slf4j
public class GrandSon extends Son {
    @Override
    void go() {
        log.info("go by grandson");
//        run();
        super.go();
    }

    @Override
    void run() {
        log.info("i'm grandson");
    }
}
