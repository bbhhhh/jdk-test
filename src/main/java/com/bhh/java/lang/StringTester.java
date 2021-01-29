package com.bhh.java.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/23 16:43
 * @Description: TODO
 */

public class StringTester {
    public static void main(String[] args) {
        String a = "1c:39:47:11:96:5e";
        System.out.println(a.replace(":", "").toUpperCase());
        String b = "";
        System.out.println(b.replace(":", "").toUpperCase());

        System.out.println(StringUtils.containsIgnoreCase("IP_Routed", "route"));
        System.out.println(StringUtils.containsIgnoreCase("IP_Bridge", "bridge"));
        System.out.println(StringUtils.containsIgnoreCase("", "bridge"));
        System.out.println(StringUtils.containsIgnoreCase(null, "bridge"));
        //"abcd".replace("abc", null);

        String aaa = "Shafaet";
        String bbb = "Simiha";
        bbb.hashCode();
        aaa.equals(bbb);
        System.out.println(aaa.compareTo(bbb));
    }
}
