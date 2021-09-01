package com.example.xm.p2threadmethod.p6setpriority;

public class ThreadA extends Thread{
    @Override
    public void run() {
        long sum = 0;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();

        System.out.println("子线程A的时间为，" + (end - begin));
    }
}
