package com.example.xm.p3锁.p1sync;

/**
 * synchronized 同步代码块
 * 传入不同对象
 * 排他锁不起作用
 */
public class Test02 {
    public static void main(String[] args) {
        Test02 test = new Test02();
        Test02 test2 = new Test02();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.mm();
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
}
