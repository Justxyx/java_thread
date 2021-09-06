package com.example.xm.p5线程间的通信.p1等待通知机制;

/**
 * 通知过早的问题
 *      问题原因：
 *          t2线程先运行，发出唤醒通知。
 *          t1 线程后运行，上锁后永远接受不到唤醒通知。
 *          或者通俗的说， 很多线程同时运行，你并不知道哪个线程先运行哪个线程后运行
 *      解决方案：
 *          见Test07
 */
public class Test06 {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("wait .. begin");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait .. end");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("notify .. begin");
                    lock.notify();
                    System.out.println("notify .. end");
                }
            }
        });
//
//        t1.start();
//        t2.start();

        t2.start();
        t1.start();
    }
}
