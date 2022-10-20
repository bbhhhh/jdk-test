package com.bhh.java.lang.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/9/23 9:52
 * @Description:
 */

@Data
@Slf4j
public abstract class Policy {
    private String name ;

    public static void main(String[] args){
        String json = "{\"name\":\"abc\"}" ;
        ObjectMapper om = new ObjectMapper();
        try {
            PolicyImpl p = om.readValue(json,PolicyImpl.class);
            log.info("{}",p.getName());
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

    }
}


