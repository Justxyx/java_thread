package com.example.xm.p3锁.p1sync;

/**
 * synchronized 同步方法
 * 使用synchronized 关键字修饰实例方法，默认使用this关键字作为锁
 * 把整个方法体作为同步代码块
 * 演示如下
 */
public class Test05 {
    public static void main(String[] args) {
        Test05 test = new Test05();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.mm22();
            }
        }).start();
    }


    public void mm() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }

    public synchronized void mm22() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }

    }
}
