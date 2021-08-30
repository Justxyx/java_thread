package com.example.xm.threadmethod.p1currentthread;

public class SubThread02 extends Thread {
    public SubThread02() {
        System.out.println("构造方法Thread.currentThread().getName()" + Thread.currentThread().getName());
        System.out.println("构造方法" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run方法Thread.currentThread().getName()" + Thread.currentThread().getName());
        System.out.println("run方法" + this.getName());
    }
}
