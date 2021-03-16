package com.bhh.java.interfac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/25 16:28
 * @Description: TODO
 */
public interface IntA {
    void a();
}

interface IntAA {

    void a();
}

class ClassB {
    int a() {
        System.out.println("print by a()");
        return 0;
    }
}

// Wrong code
//class ClassSubB extends ClassB implements IntA {
//
//    @Override
//    public void a() {
//
//    }
//}

interface IntC extends IntA, IntAA {
    // wrong code
    //int a();

    void a(int b);

}

class IntA_IntAA_Impl implements IntA, IntAA {
    private static final Logger logger = LoggerFactory.getLogger(IntA_IntAA_Impl.class);


    public static void main(String[] args) {
        IntA a1 = new IntA_IntAA_Impl();
        IntAA a2 = new IntA_IntAA_Impl();
        a1.a();
        a2.a();
    }


    @Override
    public void a() {
        
    }
}
