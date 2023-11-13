/**   
 *
 */
package com.bhh.java.lang;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author haihuab
 * @date 2020年4月3日 上午10:39:42
 */
public class PropertiesTester {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesTester.class);

    /** 
    * @author haihuab 
    * @param args
    * @throws
    */
    public static void main(String[] args) {
        Properties p1 = new Properties();
        p1.put("k1", "v1");
        p1.put("k2", "v2");
        Properties p2 = (Properties) p1.clone();

        p2.forEach((k, v) -> logger.info("{}:{}", k, v));

        try{
            p2.setProperty("k3",null);
        }catch (Exception e){
            logger.info("{}",e==null);
            logger.info(e.getMessage(),e);
        }
    }
}
