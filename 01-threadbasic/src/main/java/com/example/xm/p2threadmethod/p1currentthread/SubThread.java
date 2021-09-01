package com.example.xm.p2threadmethod.p1currentthread;

public class SubThread extends Thread {

    public SubThread() {
        System.out.println("构造方法中的---" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("子线程启动 --- " + Thread.currentThread().getName());
    }
}
