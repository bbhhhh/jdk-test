package com.bhh.java.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/12/16 13:47
 * @Description: TODO
 */

public class PropertyLoader {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PropertyLoader.class);

    public static void main(String[] args) throws IOException {
        InputStream in = PropertyLoader.class.getClassLoader().getResourceAsStream("test.properties");
        Properties p = new Properties();
        p.load(in);
        logger.info(" p has {} properties", p.keySet().size());
        in.close();
    }
}
