/**   
 *
 */
package com.bhh.java.jdk8.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年4月8日 下午2:32:09
 */
public class NewDateTimeAPITester {
    private static final Logger logger = LoggerFactory.getLogger(NewDateTimeAPITester.class);

    /** 
    * @author haihuab 
    * @param args
    * @throws
    */
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant ins = Instant.ofEpochMilli(System.currentTimeMillis());

        logger.info(DateTimeFormatter.ISO_INSTANT.format(ins));

        LocalDateTime ldt = LocalDateTime.ofInstant(ins, ZoneId.systemDefault());
        logger.info(formatter.format(ldt));
        logger.info(DateTimeFormatter.ISO_DATE_TIME.format(ldt));
    }
}
