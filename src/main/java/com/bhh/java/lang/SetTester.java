package com.bhh.java.lang;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/9/27 16:21
 * @Description:
 */

@Slf4j
public class SetTester {
    public static void main(String[] args){
        Set<String> aS = new HashSet<>();
        aS.add("a");
        aS.add("b");

        Iterator it = null;
        for (int i=0;i<100;i++){
            if (it == null || !it.hasNext()){
                it = aS.iterator();
            }
            log.info("{}:{}",i, it.next());
        }
    }
}
