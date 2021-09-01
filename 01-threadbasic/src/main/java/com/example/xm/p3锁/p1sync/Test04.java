package com.example.xm.p3锁.p1sync;

/**
 * synchronized 同步代码块
 * 静态方法 锁对象 演示
 */
public class Test04 {
    public static void main(String[] args) {
        Test04 test = new Test04();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sm();
            }
        }).start();
    }

    public static final Object o = new Object();

//    实例方法
    public void mm() {
        synchronized (o) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }

    //    静态方法
    public static void sm() {
        synchronized (o) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }
}
