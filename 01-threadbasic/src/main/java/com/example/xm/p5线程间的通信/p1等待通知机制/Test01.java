package com.example.xm.p5线程间的通信.p1等待通知机制;

/**
 *  通过锁对象，实现等待唤醒机制
 *  注意 ， 只有通过锁对象才能
 */
public class Test01 {
    public static void main(String[] args) {
        String lock = "whm";  // 定义一个字符串作为锁对象
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程1开始等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1被唤醒");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程2开始唤醒。。。 等待中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ok");
                    lock.notify();
                    System.out.println("线程2结束唤醒");
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}
