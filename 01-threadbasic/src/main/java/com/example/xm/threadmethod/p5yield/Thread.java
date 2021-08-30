package com.example.xm.threadmethod.p5yield;

public class Thread extends java.lang.Thread {
    @Override
    public void run() {

        long sum = 0;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sum += i;
            Thread.yield();
        }
        long end = System.currentTimeMillis();

        System.out.println("运行时间为，" + (end - begin));
    }
}
