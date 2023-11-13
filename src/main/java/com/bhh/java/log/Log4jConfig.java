/**   
 *
 */
package com.bhh.java.log;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author haihuab
 * @date 2017年8月29日 上午10:35:01
 */
public final class Log4jConfig {

    public static void initLog4j2() {
        // enable log4j2 async logger
//        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");

        if (StringUtils.isBlank(System.getProperty("log4j.configurationFile"))) {
            URL url = com.bhh.java.log.Log4jConfig.class.getClassLoader().getResource("./log4j2.xml");
            String log4jpath = System.getProperty("conf.dir") + File.separator + "log4j2.xml";
            if (Files.exists(Paths.get(log4jpath))) {
                System.setProperty("log4j.configurationFile", log4jpath);
                System.out.println("load log4j2.xml file from -Dconf.dir: " + log4jpath);
            } else {
                if (url != null) {
                    System.out.println("load log4j2.xml file from classpath");
                } else {
                    System.err.println("Not found log4j2.xml file, exit!!!");
                    System.exit(1);
                }
            }

        } else {
            System.out.println(
                    "load log4j2.xml from system property log4j.configurationFile=" + System.getProperty("log4j.configurationFile"));
        }

    }
}
