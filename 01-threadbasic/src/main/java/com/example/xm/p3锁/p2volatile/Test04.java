package com.example.xm.p3锁.p2volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用原子类进行自增自减操作
 */

/**
 * 一点笔记，自己的理解
 *  为什么在引入synchronized 关键字和 volatile 关键字以后，还要引入原子类 ？
 *  以下面源程序 十个线程，每个线程对静态变量自增10000 的程序来看，我们比较三个关键字的区别：
 *      1. volatile
 *      该关键字只能保证变量对每个线程都可见，但是完全不能保证数据同步。
 *      2. synchronized
 *      该关键字，对代码块保持同步，每个线程争抢该代码块的使用权。
 *      问题在于，只能单线程处理该代码块，失去了多线程的意义。
 *      假如该代码块要处理10s，那么十个线程争夺就要耗费100s。
 *      3.AtomicInteger 原子类
 *      完全避免了上述两个问题
 */
public class Test04 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Threadxx threadxx = new Threadxx();
            threadxx.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Threadxx threadxx = new Threadxx();
        AtomicInteger count = threadxx.getCount();
        System.out.println("---------------------");
        System.out.println(count);
    }

    static class Threadxx extends Thread{
        private static AtomicInteger count = new AtomicInteger();

        public static void countAdd(){
            for (int i = 0; i < 10000; i++) {
                count.getAndIncrement();
            }

            System.out.println(Thread.currentThread().getName() + "获得的count值为：" + count);
        }

        public static AtomicInteger getCount() {
            return count;
        }

        @Override
        public void run() {
            countAdd();
        }
    }
}
