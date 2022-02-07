package com.bhh.java.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/1/19 9:49
 * @Description: TODO
 */

public class RegExpTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(RegExpTester.class);

    public static void main(String[] args){
        Pattern p = Pattern.compile("[A-Z]+");
        Matcher m = p.matcher("");
        logger.info(String.valueOf(m.matches()));
        m = p.matcher("a");
        logger.info(String.valueOf(m.matches()));
        m = p.matcher("A");
        logger.info(String.valueOf(m.matches()));
        m = p.matcher("AA9");
        logger.info(String.valueOf(m.matches()));
        m = p.matcher("AA.");
        logger.info(String.valueOf(m.matches()));
        m = p.matcher("AAZ");
        logger.info(String.valueOf(m.matches()));

        char[] ca ="AAA".toCharArray();
        int i = 0;
        for (int j=0;j<ca.length;j++){
           i += (int)((ca[j]-64) * Math.pow(26,ca.length-j-1)) ;
        }
        logger.info("i={}",i);
    }
}
