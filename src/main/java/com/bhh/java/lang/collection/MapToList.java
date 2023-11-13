package com.bhh.java.lang.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : haihuab
 * @Date : 2023/7/24 16:18
 * @Description:
 */

@Slf4j
public class MapToList {
    public static void main(String[] args) {
        Map m = new HashMap<>();
        m.put("a", "asdf");
        m.put("b", 23423);
        m.put("c",null);
        log.info("{}",String.valueOf(m.get("c"))==null);
//        Integer c = Integer.valueOf((String)m.get("c"));
//        log.info("c={}",c);
        List l = Arrays.asList(m);
        log.info("{}", l);
        l =null;
        for (Object o : l) {
            log.info("{}",o);
        }
    }
}
