/**
 *
 */
package com.bhh.java.jdk8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

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
        long now = System.currentTimeMillis();
        Instant ins = Instant.ofEpochMilli(now);

        logger.info(DateTimeFormatter.ISO_INSTANT.format(ins));

        LocalDateTime ldtt = LocalDateTime.ofEpochSecond(now / 1000, 0, ZoneOffset.ofHours(8));
        logger.info(formatter.format(ldtt));
        logger.info(LocalDateTime.now().toString());
        logger.info(ins.toString());
        logger.info("----------");

        LocalDateTime ldt = LocalDateTime.ofInstant(ins, ZoneId.systemDefault());
        logger.info("ldt={}", ldt.toString());
        logger.info(formatter.format(ldt));
        logger.info(DateTimeFormatter.ISO_DATE_TIME.format(ldt));
        String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd['T'][' ']HH:mm:ss";
        DateTimeFormatter formatter2 = new DateTimeFormatterBuilder()
                .appendPattern(DATE_TIME_FORMAT_PATTERN)
                // optional decimal point followed by 1 to 6 digits
                .optionalStart()
                .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, true)
                .optionalEnd()
                .toFormatter();
        logger.info(formatter2.format(ldt));
        String tt = "2020-06-24 11:38:33.331127";
        String tt2 = "2020-06-24T11:39:03.331127";
        String tt3 = "2020-06-24 11:40:03.33118";
        String tt4 = "2020-06-24T11:40:13.3311";
        String tt5 = "2020-06-24 11:40:23.331";
        String tt6 = "2020-06-24T11:30:33";
        LocalDateTime ldt1 = LocalDateTime.parse(tt, formatter2);
        LocalDateTime ldt2 = LocalDateTime.parse(tt2, formatter2);
        LocalDateTime ldt3 = LocalDateTime.parse(tt3, formatter2);
        LocalDateTime ldt4 = LocalDateTime.parse(tt4, formatter2);
        LocalDateTime ldt5 = LocalDateTime.parse(tt5, formatter2);
        LocalDateTime ldt6 = LocalDateTime.parse(tt6, formatter2);
        logger.info("local zone id={}", ZoneOffset.systemDefault());

        logger.info("seconds between ldt1 and ldt2 ={}",
                ldt2.toEpochSecond(ZoneOffset.ofHours(8)) - ldt1.toEpochSecond(ZoneOffset.ofHours(8)));
        //LocalDateTime.parse("2019-12-17T11:30:38.000000", formatter2);

        DateTimeFormatter dtf3 = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd")
                .toFormatter();
        LocalDate ldt7 = LocalDate.parse("2022-08-09",dtf3);

        logger.info(ldt7.atStartOfDay().toString());

    }
}
