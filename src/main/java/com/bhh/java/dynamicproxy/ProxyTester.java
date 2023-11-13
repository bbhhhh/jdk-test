package com.bhh.java.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/24 14:33
 * @Description: TODO
 */

public class ProxyTester {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProxyTester.class);

    public static void main(String[] args) {
        Class proxyClass = Proxy.getProxyClass(ProxyTester.class.getClassLoader(), Comparable.class, Runnable.class);
        String s = "abc";
        MyInvocationHandler stringHandler = new MyInvocationHandler(s);
        MyRunner myRunner = new MyRunner();
        MyInvocationHandler runnableHandler = new MyInvocationHandler(myRunner);
        Comparable comparableProxy;
        Runnable runnableProxy;
        Object obj;
        try {
            logger.info("{}", proxyClass.getSimpleName());
            obj = proxyClass.getConstructor(InvocationHandler.class).newInstance(stringHandler);
            logger.info("{}", obj.getClass().getSimpleName());
            logger.info("{}", (obj instanceof Comparable));
            logger.info("{}", (obj instanceof Runnable));
            comparableProxy = (Comparable) obj;
            runnableProxy = (Runnable) proxyClass.getConstructor(InvocationHandler.class).newInstance(runnableHandler);
            logger.info("compare result={}", comparableProxy.compareTo("asdfsdf"));
            new Thread(runnableProxy).start();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e.getMessage(), e);
        }
    }


}

class MyInvocationHandler implements InvocationHandler {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MyInvocationHandler.class);
    private Object realObj;

    public MyInvocationHandler(Object realObj) {
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method = Objects.requireNonNull(method, "obj can't be null");
        logger.info("method name={},args={}", method.getName(), Arrays.deepToString(args));
        return method.invoke(this.realObj, args);
    }
}

class MyRunner implements Runnable {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MyRunner.class);

    @Override
    public void run() {
        logger.info("{} running.", this.getClass().getSimpleName());
    }
}


