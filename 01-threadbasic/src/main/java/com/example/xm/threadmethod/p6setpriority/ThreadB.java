package com.example.xm.threadmethod.p6setpriority;

public class ThreadB extends Thread{
    @Override
    public void run() {
        long sum = 0;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();

        System.out.println("子线程B的时间为，" + (end - begin));
    }
}
