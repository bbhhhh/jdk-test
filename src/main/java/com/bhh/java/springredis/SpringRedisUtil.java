package com.bhh.java.springredis;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2020/7/10 13:38
 * @Description: TODO
 */

public class SpringRedisUtil {
    static {
        System.setProperty("redis.ip", "135.251.218.88");
        System.setProperty("redis.port", "6379");
        System.setProperty("redis.password", "iprobe");
    }

    private static final Logger logger = LoggerFactory.getLogger(SpringRedisUtil.class);

    private static SpringRedisUtil instance = new SpringRedisUtil();
    private static RedisConnectionFactory redisConnectionFactory;
    private StringRedisTemplate stringRedisTemplate;
    private static volatile boolean inited = false;

    public static SpringRedisUtil getInstance() {
        if (instance == null) {
            instance = new SpringRedisUtil();
        }
        return instance;
    }

    private SpringRedisUtil() {
        init();
    }

    private synchronized void init() {
        if (inited)
            return;

        try {
            logger.info("initializing redis connection...");
            String hostname = System.getProperty("redis.ip");
            int port = Integer.parseInt(System.getProperty("redis.port"));
            String password = System.getProperty("redis.password");
            redisConnectionFactory = getRedisConnectionFactory(hostname, port, password);
            stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
            logger.info("stringRedisTemplate ready");
            stringRedisTemplate.opsForValue().get("test");
            inited = true;
            logger.info("redis server connected, ip={},port={},password={}", hostname, port, password);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            System.exit(1);
        }
    }


    private RedisConnectionFactory getRedisConnectionFactory(String hostname, int port, String password) {
        logger.info("init RedisStandaloneConfiguration...");
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostname);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(password);
        logger.info("init LettuceConnectionFactory...");

        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        lettuceConnectionFactory.afterPropertiesSet();
        logger.info("RedisStandaloneConfiguration ready");

        return lettuceConnectionFactory;
    }

    public void set(String key, String value) {
        Assert.hasText(key, "argument key must not be null or empty");
        Assert.notNull(value, "argument value must not be null");
        this.stringRedisTemplate.opsForValue().set(key, value);
    }


    public static void main(String[] args) {

        SpringRedisUtil.getInstance();

        for (int i = 0; i < 5; i++) {
            logger.info("{} to be set", i);
            SpringRedisUtil.getInstance().set(String.valueOf(System.currentTimeMillis()), String.valueOf(i));
            logger.info("{} be set.", i);
        }

        logger.info("finished.");

    }
}
