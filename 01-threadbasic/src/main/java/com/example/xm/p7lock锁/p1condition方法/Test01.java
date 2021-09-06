package com.example.xm.p7lock锁.p1condition方法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  关键字synchronized 的wait 与 notify 可实现等待通知机制
 *  Lock 锁中，Condition 与上述一样
 *  不过要注意一点：
 *         Condition 与 synchronized 一样， 需要先获得锁才可以
 */
public class Test01 {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static class Threadxx extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("线程被锁住");
                System.out.println("线程开始等待");
                condition.await();
                System.out.println("子线程被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("111111111111111111111111");
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Threadxx t1 = new Threadxx();
        t1.start();

        Thread.sleep(1000);
        try {
            lock.lock();
            System.out.println("主线程获得锁");
            condition.signal();
            System.out.println("主线程唤醒");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
