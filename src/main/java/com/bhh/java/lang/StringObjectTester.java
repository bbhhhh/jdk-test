package com.bhh.java.lang;

import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author : haihuab
 * @Date : 2023/7/27 9:30
 * @Description:
 */

@Slf4j
public class StringObjectTester {

    public static void main(String[] args) throws InterruptedException {
        String a = "ab";
        new ClassA(a).start();
        synchronized (a){
            a.wait(10000);
        }
        log.info("wakeup");
    }


}
@Slf4j
class ClassA extends Thread{
    String s ;
    ClassA(String str){
        s = str ;
        log.info("{}",s==str);
    }


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            synchronized (s){
                s.notifyAll();
            }
            log.info("notified");
        }catch (InterruptedException e){

        }
    }
}
