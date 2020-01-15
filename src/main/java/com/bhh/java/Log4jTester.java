/**   
 *
 */
package com.bhh.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年1月15日 下午4:09:59
 */
public class Log4jTester {
    private static final Logger logger = LoggerFactory.getLogger(Log4jTester.class);

    /** 
    * @author haihuab 
    * @param args
    * @throws
    */
    public static void main(String[] args) {
        String a = null;
        try {
            a.length();
        } catch (Exception e) {
            logger.error("a={}", a, e);
        }
    }
}
