/**   
 *
 */
package com.bhh.java.lang;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年2月11日 下午3:49:28
 */
public class SplitArrayTester {
    private static final Logger logger = LoggerFactory.getLogger(SplitArrayTester.class);

    /** 
    * @author haihuab 
    * @param args
    * @throws
    */
    public static void main(String[] args) {
        String a = "a||g";
        logger.info("len={}", a.split(";").length);
        logger.info("array[0]={}", a.split(";")[0]);
        logger.info("{},{}",a.split("\\|"),a.split("\\|").length);

        logger.info("{},{}", StringUtils.split(a,"|"),StringUtils.split(a,"|").length);
    }
}
