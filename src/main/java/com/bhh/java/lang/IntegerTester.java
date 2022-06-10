package com.bhh.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerTester {
    private static final Logger logger = LoggerFactory.getLogger(IntegerTester.class);

    public static void main(String... args) {
        Integer IntegerVar1 = 1;
        int intVar1 = 1;
        logger.info("1==IntegerVar1 is: {}", 1 == IntegerVar1);
        logger.info("intVar1 == IntegerVar1 is: {}", intVar1 == IntegerVar1);
        Integer IntegerVar2 = 1;
        logger.info("IntegerVar1 == IntegerVar2 is: {}", IntegerVar1 == IntegerVar2);
        Integer IntegerVar3 = new Integer(1);
        logger.info("IntegerVar1 == IntegerVar3 is: {}", IntegerVar1 == IntegerVar3);
        Integer IntegerVar4 = new Integer(1);
        logger.info("IntegerVar4 == IntegerVar3 is: {}", IntegerVar4 == IntegerVar3);
        logger.info("IntegerVar4.equals(IntegerVar3) is: {}", IntegerVar4.equals(IntegerVar3));
        int intVar2 = 128;
        Integer IntegerVar5 = 128;
        Integer IntegerVar6 = new Integer(128);
        logger.info("intVar2 == IntegerVar5 is: {}", intVar2 == IntegerVar5);
        logger.info("IntegerVar5 == IntegerVar6 is: {}", IntegerVar5 == IntegerVar6);
        logger.info("IntegerVar5.equals(IntegerVar5) is: {}", IntegerVar5.equals(IntegerVar6));

        logger.info("binary of {} = {}", IntegerVar5, Integer.toBinaryString(IntegerVar5));
        logger.info("binary of {} = {}", -232, Integer.toBinaryString(-232));


        Integer i1 = 1;
        Integer i2 = i1;
        i2++;
        logger.info("i1={},i2={}",i1,i2);

    }
}
