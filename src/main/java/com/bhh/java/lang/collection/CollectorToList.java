package com.bhh.java.lang.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/3/20 14:29
 * @Description:
 */

@Slf4j
public class CollectorToList {
    public static void main(String[] args){
        Map<String, A> aMap = new HashMap<>();
        aMap.put("1",new A("a"));
        aMap.put("2",new A("b"));

        List<?> aList = new ArrayList<>(aMap.values());

        aList.forEach(i->log.info("{}",i));

    }

    static class A{
        String a;
        public A(String a){
            this.a = a ;
        }

        @Override
        public String toString() {
            return a ;
        }
    }
}
