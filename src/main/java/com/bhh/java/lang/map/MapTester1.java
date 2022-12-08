package com.bhh.java.lang.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/6/10 16:30
 * @Description:
 */

@Slf4j
public class MapTester1 {
    public static void main(String[] args){
        Map<Long,Integer> myMap = new Hashtable<>();
        Long key = System.currentTimeMillis();
        Integer val = 10000;
        myMap.put(key,val);
        Integer val2 = myMap.get(key);
        val2++;
        log.info("{}",myMap.get(key));

        log.info("{}",(Integer)myMap.get(key+1)) ;

        log.info("val2={}",val2);
        Integer val3 = val2;
        val3++;
        log.info("val2={},val3={}",val2,val3);

        Map<Long, String[]> map2 = new Hashtable<>();
        map2.put(key,new String[1]);
        String[] s = map2.get(key);
        s[0] = "aa";
        log.info("{}",map2.get(key)[0]);

        Map<String,String> map3 = new ConcurrentHashMap<>();
        map3.containsKey(null);


    }
}
