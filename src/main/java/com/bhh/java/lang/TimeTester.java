package com.bhh.java.lang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/5/8 13:53
 * @Description: TODO
 */

public class TimeTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TimeTester.class);

    protected static Date parseTime(String timeStr) {
        Date newTime = null;
        if (StringUtils.isBlank(timeStr))
            return newTime;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        sdf.setLenient(false);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            timeStr = timeStr.substring(0, 23);
            newTime = sdf.parse(timeStr);
        } catch (IndexOutOfBoundsException | ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return newTime;
    }

    public static void main(String[] args){
        logger.info("{}",parseTime("2021-05-08T02:13:22.780Z"));
    }
}
