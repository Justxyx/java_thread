package com.example.xm.p6线程通信与锁.p2Lock显示锁;

import com.example.xm.p1createthread.p3.Runable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *         private static Lock lock = new ReentrantLock();
 *         ***用静态变量描述这个锁对象***
 *         既可保证每一个对象共用一个锁对象
 *
 */

public class Test03 {
    static class Threadxx extends Thread{
        private static Lock lock = new ReentrantLock();
        static int num = 0;

        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i < 10000; i++) {
                num ++;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Threadxx t1 = new Threadxx();
        Threadxx t2 = new Threadxx();

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Threadxx.num);
    }
}
