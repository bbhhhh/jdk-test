package com.bhh.java.json;

import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.MysqlParameterMetadata;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/4/7 16:16
 * @Description:
 */

@Slf4j
public class JsonTester {
    public static void main(String[] args) {
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("name","kitty") ;



    }
}

@Slf4j
class A{
    String name ;
    Integer age ;

}
