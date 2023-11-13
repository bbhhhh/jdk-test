package com.bhh.java.lang;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : haihuab
 * @Date : 2023/8/2 14:08
 * @Description:
 */

@Slf4j
public class CastTester {
    public static void main(String[] args){
        Map<String,Object> map = new HashMap<>();
        map.put("a","3");
        map.put("b",4);
        map.put("c","ee");
        int i = Integer.valueOf(map.get("a").toString()) ;
        log.info("i={}",i);

        i = Integer.valueOf(map.get("b").toString()) ;
        log.info("i={}",i);

        i = Integer.valueOf(map.get("c").toString()) ;
        log.info("i={}",i);
    }
}
