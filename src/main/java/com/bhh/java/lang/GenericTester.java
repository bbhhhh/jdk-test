package com.bhh.java.lang;

import javax.management.relation.RoleList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/20 14:44
 * @Description: TODO
 */

public class GenericTester {
    public static void main(String[] args) {
        List l = new ArrayList<>();
        l.add(new RoleList());
        l.add(new ArrayList());
        l.add("");

        List<?> l1 = new ArrayList<Object>();

        // compile error
        //l1.add(new RoleList());
        //l1.add(new ArrayList());
        //l1.add("");

        List<? extends ArrayList> l2 = new ArrayList<ArrayList>();
        // compile error
        //l2.add(new RoleList());
        //l2.add(new ArrayList());
        //l2.add("");

        List<? super ArrayList> l3 = new ArrayList<>();
        l3.add(new RoleList());
        l3.add(new ArrayList());

        printType2(Object.class, Integer.TYPE);
        printType2(Class.class, Integer.TYPE);
    }

    public static <T> void printType(T x) {
        System.out.println(x.getClass().getSimpleName());
    }

    public static <T> void printType2(Class<T> type, T instance) {
        System.out.println(type.getSimpleName() + "," + instance.getClass().getSimpleName());
    }

    //public static void printType3(Class type,)
}
