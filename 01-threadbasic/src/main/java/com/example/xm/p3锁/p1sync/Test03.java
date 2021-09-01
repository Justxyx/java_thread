package com.example.xm.p3锁.p1sync;

/**
 * synchronized 同步代码块
 * 使用一个常量作为同步锁
 */
public class Test03 {
    public static void main(String[] args) {
        Test03 test = new Test03();

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
}
