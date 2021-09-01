package com.example.xm.p3锁.p1sync;

/**
 * synchronized 同步代码块
 * this 锁对象
 * test 作为对象传入 锁对象为test
 * 为同一把锁
 */
public class Test01 {
    public static void main(String[] args) {
        Test01 test = new Test01();

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


    public void mm() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }
}
