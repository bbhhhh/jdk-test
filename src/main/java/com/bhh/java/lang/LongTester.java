/**   
 *
 */
package com.bhh.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年1月19日 下午2:33:59
 */
public class LongTester {
    private static final Logger logger = LoggerFactory.getLogger(LongTester.class);

    /** 
    * @author haihuab 
    * @param args
    * @throws
    */
    public static void main(String[] args) {
        Long a = 100000000000L;
        Long b = 100000000000L;
        long c = 100000000000L;

        logger.info("a==b is {}", (a == b));
        logger.info("a!=b is {}", (a != b));
        logger.info("a.equals(b) is {}", (a.equals(b)));

        logger.info("a==c is {}", (a == c));
        logger.info("a!=c is {}", (a != c));
        logger.info("a.equals(c) is {}", (a.equals(c)));

    }
}
