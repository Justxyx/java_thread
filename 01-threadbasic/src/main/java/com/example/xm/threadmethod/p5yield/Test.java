package com.example.xm.threadmethod.p5yield;

public class Test {
    public static void main(String[] args) {
        long sum = 0;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();

        System.out.println("主线程运行时间为，" + (end - begin));

        Thread thread = new Thread();
        thread.start();
    }
}
