package com.bhh.java.jdk8.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/6/2 14:04
 * @Description:
 */

@Slf4j
public class NewDateTimeApiTester3 {
    public static void main(String[] args){
        LocalDate threeDaysAgo = LocalDate.now().minusDays(3);
        log.info("{}",threeDaysAgo.atStartOfDay(ZoneId.systemDefault()));
        log.info("{}",new Date(threeDaysAgo.atStartOfDay(ZoneId.systemDefault()).toEpochSecond()*1000L));
        log.info("{}",threeDaysAgo.toString());
    }

}
