package com.example.xm.p6线程通信与锁.p2Lock显示锁;

/**
 *  分为内部锁与显示锁
 *      1. 内部锁： synchronized
 *      2. 显示锁： Lock
 */

/**
 * 本文演示，锁的可重入性
 */
public class Test01 {
    public synchronized void  sm(){
        System.out.println("sm");
        sm2();
    }

    private synchronized void sm2() {
        System.out.println("sm2");
        sm3();
    }

    private synchronized void sm3() {
        System.out.println("sm3");
    }

    public static void main(String[] args) {
        Test01 test = new Test01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.sm();
            }
        }).start();
    }
}
