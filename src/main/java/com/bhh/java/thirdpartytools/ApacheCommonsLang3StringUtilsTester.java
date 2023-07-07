package com.bhh.java.thirdpartytools;

import org.apache.commons.lang3.StringUtils;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/4/12 15:09
 * @Description: TODO
 */

public class ApacheCommonsLang3StringUtilsTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ApacheCommonsLang3StringUtilsTester.class);

    public static void main(String[] args) {
        String a = "abc.efg.efg.ggg";
        logger.info("{}", StringUtils.substringAfterLast(a, "."));
        logger.info("{}", StringUtils.substringBeforeLast(a, "."));
        String b = "asdfe\r\nfe";
        String c = "\n\r";
        logger.info("{}",b);
        logger.info("{}",StringUtils.containsAny(b,c));
        logger.info("{}",StringUtils.contains(b,c));
        logger.info("{}",StringUtils.containsAny(b,'\r','\n'));

    }
}
