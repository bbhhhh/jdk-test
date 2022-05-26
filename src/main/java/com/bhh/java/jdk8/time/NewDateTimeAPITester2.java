/**
 *
 */
package com.bhh.java.jdk8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.lettuce.core.BitFieldArgs;

/**
 * @author haihuab
 * @date 2020年4月8日 下午2:32:09
 */
public class NewDateTimeAPITester2 {
    private static final Logger logger = LoggerFactory.getLogger(NewDateTimeAPITester2.class);

    /**
     * @author haihuab
     * @param args
     * @throws
     */
    public static void main(String[] args) {


//        LocalDateTime ldt = LocalDateTime.ofInstant(ins, ZoneId.systemDefault());
//        logger.info("ldt={}", ldt.toString());
//        logger.info(formatter.format(ldt));
//        logger.info(DateTimeFormatter.ISO_DATE_TIME.format(ldt));
        String baseDtfPattern1 = "yyyy-MM-dd['T']HH:mm:ss";
        String baseDtfPattern2 = "yyyy-MM-dd[' ']HH:mm:ss";
        DateTimeFormatter baseDtf1 = DateTimeFormatter.ofPattern(baseDtfPattern1);
        DateTimeFormatter baseDtf2 = DateTimeFormatter.ofPattern(baseDtfPattern2);

        DateTimeFormatter formatter2 = new DateTimeFormatterBuilder()
                .appendOptional(baseDtf1)
                .appendOptional(baseDtf2)
//                .optionalStart().appendLiteral('T').optionalEnd()
//                .optionalStart().appendLiteral(' ').optionalEnd()
//                .appendPattern("HH:mm:ss")
                // optional decimal point followed by 1 to 6 digits
//                .optionalStart()
                .appendFraction(ChronoField.MICRO_OF_SECOND, 0,9, true)
                .optionalStart()
                .appendOffsetId()
                .optionalEnd()
//                .optionalEnd()
                .toFormatter();
//        logger.info(formatter2.format(ldt));
        logger.info("formatter2={}",formatter2.toString());
        String tt = "2020-06-24 11:38:33.331127";
        String tt2 = "2020-06-24T11:39:03.331127";
        String tt3 = "2020-06-24 11:40:03.33118";
        String tt4 = "2020-06-24T11:40:13.3311";
        String tt5 = "2020-06-24 11:40:23.5Z";
        String tt6 = "2020-06-24T11:30:33Z";

        LocalDateTime ldt1 = LocalDateTime.parse(tt,formatter2);
        ZonedDateTime zdt = ldt1.atZone(ZoneId.of("GMT"));
//        ldt1.
        logger.info("ldt1={}",ldt1);

        logger.info("zdt={}",zdt);



        LocalDateTime ldt2 = LocalDateTime.parse(tt2, formatter2);
        LocalDateTime ldt3 = LocalDateTime.parse(tt3, formatter2);
        LocalDateTime ldt4 = LocalDateTime.parse(tt4, formatter2);
        LocalDateTime ldt5 = LocalDateTime.parse(tt5, formatter2);
        LocalDateTime ldt6 = LocalDateTime.parse(tt6, formatter2);
        ZonedDateTime zdt6 = ldt6.atZone(ZoneId.of("GMT"));
        logger.info("ldt5={}",ldt5);
        logger.info("ldt6={}",ldt6);
        logger.info("zdt6={}",zdt6);


        zdt = zdt.withZoneSameInstant(ZoneId.systemDefault());
        zdt6 = zdt6.withZoneSameInstant(ZoneId.systemDefault());
        DateTimeFormatter formatter3 = new DateTimeFormatterBuilder()
                .appendOptional(baseDtf1)
//                .appendOptional(baseDtf2)
                .appendFraction(ChronoField.MICRO_OF_SECOND, 0,9, true)
                .appendOffsetId()
                .toFormatter();

        logger.info("gmt+8 zdt={}",zdt.format(formatter3));
        logger.info("gmt+8 zdt6={}",zdt6.format(formatter3));







//        logger.info("local zone id={}", ZoneOffset.systemDefault());
//
//        logger.info("seconds between ldt1 and ldt2 ={}",
//                ldt2.toEpochSecond(ZoneOffset.ofHours(8)) - ldt1.toEpochSecond(ZoneOffset.ofHours(8)));
//        //LocalDateTime.parse("2019-12-17T11:30:38.000000", formatter2);
//
//        DateTimeFormatter dtf3 = new DateTimeFormatterBuilder()
//                .appendPattern("yyyy-MM-dd")
//                .toFormatter();
//        LocalDate ldt7 = LocalDate.parse("2022-08-09",dtf3);
//
//        logger.info(ldt7.atStartOfDay().toString());
//
//        DateTimeFormatter dtf33 = new DateTimeFormatterBuilder()
//                .appendPattern("yyyyMMddHHmmss")
//                .toFormatter();
//
//        logger.info(LocalDateTime.now().format(dtf3));
//        logger.info(LocalDateTime.now().format(dtf33));
//
//        DateTimeFormatter dtf4 = new DateTimeFormatterBuilder()
//                .appendPattern("yyyy-MM-dd['T']HH:mm:ss.SSSXXX")
//                .toFormatter();
//        logger.info(ZonedDateTime.now().format(dtf4));
//
//
//        logger.info(String.valueOf(new Date().getTime()));
    }
}
