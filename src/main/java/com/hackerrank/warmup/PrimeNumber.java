package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/1/29 11:09
 * @Description: TODO
 */


public class PrimeNumber {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PrimeNumber.class);

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

class Prime {

    public void checkPrime(int... nums) {
        int i = 1;
        boolean flag = false;
        for (int j = 0; j < nums.length; j++) {
            i = 2;
            flag = false;
            while (i <= nums[j]) {
                if (nums[j] % i == 0) {
                    if (i != nums[j]) {
                        flag = true;
                        break;
                    }
                }
                i++;
            }
            if (!flag && nums[j] != 1) {
                System.out.print(nums[j]);
                if (j < nums.length - 1) {
                    System.out.print(" ");
                }
            }
        }
        System.out.print("\n");
    }
}