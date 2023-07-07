package com.bhh.java.lang.reflect;

import java.lang.reflect.Field;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2023/4/20 9:16
 * @Description:
 */

@Slf4j
public class GrandFather {
    String grandFaterField1 ;
    private String gfPrivateField ;

    public static void main(String[] args){
        GrandFather gf = new GrandFather();
        GrandFather father = new Father();
        GrandFather son = new Son();

        log.info("class={}",son.getClass());



        for (Field field : gf.getClass().getFields()) {
            log.info("fields={}:{}",field.getType(),field.getName());
        }
        for (Field field : gf.getClass().getDeclaredFields()) {
            log.info("dcfields={}:{}",field.getType(),field.getName());
        }

        for (Field field : father.getClass().getFields()) {
            log.info("fields={}:{}",field.getType(),field.getName());
        }
        for (Field field : father.getClass().getDeclaredFields()) {
            log.info("dcfields={}:{}",field.getType(),field.getName());
        }

        for (Field field : son.getClass().getFields()) {
            log.info("fields={}:{}",field.getType(),field.getName());
        }
        printAllFields(son.getClass());

    }

    public static void printAllFields(Class clazz){
        while(clazz !=null){
            for (Field field : clazz.getDeclaredFields()) {
                log.info("{}:{}",field.getType(),field.getName());
            }
            clazz = clazz.getSuperclass();
        }
    }
}
