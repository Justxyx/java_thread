package com.example.xm.p3锁.p1sync;

/**
 * synchronized 同步方法
 * 使用synchronized 关键字修饰静态方法，默认使用 当前运行时类对象 为锁
 * 有人称之为  *** 类锁 ***
 * 把整个方法体作为同步代码块
 * 演示如下
 */
public class Test06 {
    public static void main(String[] args) {
        Test06 test = new Test06();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test06.mm22();
            }
        }).start();
    }


    public void mm() {
        synchronized (Test06.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }

    public synchronized static void mm22() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }

    }
}
