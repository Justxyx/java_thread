package com.example.xm.p5线程间的通信.p1等待通知机制;

/**
 * 解决通知过早的问题
 * 加入标志位 isFirst
 *
 */
public class Test07 {
    public static boolean isFirst = true;
    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (isFirst) {
                        System.out.println("isFirst" + isFirst);
                        System.out.println("wait .. begin");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("wait .. end");
                    }
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
                    isFirst = false;
                }
            }
        });
//
        t1.start();
        t2.start();
//
//        t2.start();
//        t1.start();
    }
}
