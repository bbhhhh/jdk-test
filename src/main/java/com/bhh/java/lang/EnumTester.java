package com.bhh.java.lang;

import java.util.Arrays;
import java.util.Collections;

import com.bhh.java.lang.json.JsonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2022/9/15 15:23
 * @Description:
 */

@Slf4j
public class EnumTester {
    public static void main(String[] args) {
        int v = 1;
        log.info("{}={}", v, Vendor.getName(v));
        log.info("{}", Vendor.getName(8));
        log.info("{}", Vendor.getName(12));
        log.info("{}", Vendor.getName(13));
        log.info("{}", Vendor.getName(14));
        log.info("{}", Vendor.getName(15));
        log.info("{}", Vendor.getName(16));
        log.info("{}", Vendor.getName(0));
        log.info("{}", Vendor.getName(-99));
        log.info("{}", Vendor.getName(20));


        Vendor vd = Vendor.BELL ;
        log.info("{}",Vendor.BELL.equals(vd));
        Vendor[] va = {Vendor.BELL, Vendor.CIOT} ;
        log.info("{}", Arrays.toString(va));
        EnumWrapper enumWrapper = new EnumWrapper();
        log.info("{}", JsonUtils.objectToJson(enumWrapper));

    }
}

class EnumWrapper {
    Vendor v = Vendor.BELL;
    int xx ;
}

enum Vendor {
    EMPTY(-99, ""),
    OTHER(0, "其他"),
    BELL(1, "贝尔"),
    HUAWEI(2, "华为"),
    ZTE(3, "中兴"),
    DAYA(4, "大亚"),
    FIBER(5, "烽火"),
    HUAQIN(6, "华勤"),
    BELLMAN(7, "贝曼"),
    SKYW(8, "创维"),
    CMDC(9, "杭研 "),
    JIULIAN(10, "九联"),
    TIANYI(11, "天邑"),
    CIOT(12, "物联网"),
    STARNET(13, "星网锐捷"),
    YHTC(14, "友华"),
    ZHAONENG(15, "兆能"),
    CMCC(16, "终端公司");

    private String name;
    private int index;

    private Vendor(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static String getName(int index) {
        for (Vendor v : Vendor.values()) {
            if (v.getIndex() == index) {
                return v.name;
            }
        }
        return OTHER.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
