package com.example.xm.p2threadmethod.p3sleep;

public class Thread extends java.lang.Thread{
    @Override
    public void run() {
        long millis = System.currentTimeMillis();
        System.out.println("子线程睡眠");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("休眠时间为" + (System.currentTimeMillis() - millis));
    }
}
