package com.bhh.java.lang.abstractclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/9/21 14:10
 * @Description:
 */
@Slf4j
public abstract class Father {
    public Father(){

    }

    void go(){
        log.info("go by father");
        run();
    }

    abstract void run();

    public static void main(String[] args){
        Father fa = new GrandSon();
        fa.go();
    }
}

