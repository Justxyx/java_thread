package com.example.xm.p6线程通信与锁.p2Lock显示锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁的基本使用
 *
 * ReentrantLock 的lock 与 unlock
 */
public class Test02 {
    static Lock lock = new ReentrantLock();

    static void sm(){
        lock.lock();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                sm();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
    }
}
