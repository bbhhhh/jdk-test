package com.bhh.java.lang;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xml.internal.serializer.ToTextSAXHandler;


/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/23 16:43
 * @Description: TODO
 */

public class StringTester {
    private static final Logger logger = LoggerFactory.getLogger(StringTester.class);

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

        StringBuilder sb = new StringBuilder("adsfadf");
        sb.deleteCharAt(1);
        System.out.println(sb.toString());
        String sss = "   ";
        System.out.println(sss.split(" ").length);

        String toReplace = "ads|sa|df^as\"dkjk\nef^a\r\nsdf\"ggggg" ;
        logger.info("toR={}",toReplace);
       // toReplace = toReplace.replaceAll("\"","");
//        logger.info("toR={}",toReplace);

        toReplace = toReplace.replaceAll("(\\r\\n|\\n|\\^|\\||\")","");
        logger.info("toR={}", toReplace);
    }
}
