package com.bhh.java.jdk8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : haihuab
 * @Date : 2023/8/9 15:44
 * @Description:
 */

@Slf4j
public class WeekTester {

    public static void main(String[] args){
        LocalDate ld = LocalDate.parse("2023-10-02");

        WeekFields weekFields =WeekFields.of(DayOfWeek.MONDAY,1);
        int weekOfMon = ld.get(weekFields.weekOfMonth());
        log.info("the {} of month",weekOfMon);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM");
        log.info("{}", ld.format(dtf));
    }
}
