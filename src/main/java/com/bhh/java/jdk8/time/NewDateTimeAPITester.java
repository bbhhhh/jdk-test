/**
 *
 */
package com.bhh.java.jdk8.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        logger.info(formatter2.format(ldt));
        String tt = "2020-06-24 11:38:33.331127";
        String tt2 = "2020-06-24 11:39:03.331127";
        LocalDateTime ldt1 = LocalDateTime.parse(tt, formatter2);
        LocalDateTime ldt2 = LocalDateTime.parse(tt2, formatter2);
        logger.info("seconds between ldt1 and ldt2 ={}",
                ldt2.toEpochSecond(ZoneOffset.ofHours(8)) - ldt1.toEpochSecond(ZoneOffset.ofHours(8)));
        //LocalDateTime.parse("2019-12-17T11:30:38.000000", formatter2);
        String tt3 = "2020-06-24T11:38:33.331127";
        String tt4 = "2020-06-24T11:39:03.331127";
        LocalDateTime dt3 = LocalDateTime.parse(tt3, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime dt4 = LocalDateTime.parse(tt4, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        logger.info("seconds between dt3 and dt4 ={}",
                dt4.toEpochSecond(ZoneOffset.ofHours(8)) - dt3.toEpochSecond(ZoneOffset.ofHours(8)));

    }
}
