package com.example.xm.p6线程通信与锁.p2Lock显示锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock(long time, TimeU)   与 tryLock（）方法
 */

public class Test05tryLock {
    public static void main(String[] args) {
        TimeLock lock = new TimeLock();

        Thread t1 = new Thread(lock);
        Thread t2 = new Thread(lock);

        t1.start();
        t2.start();

    }

    static class TimeLock implements Runnable{
        private static ReentrantLock lock = new ReentrantLock();


        @Override
        public void run() {
            try {
                if (lock.tryLock(3, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName() + "获得锁");
                    Thread.sleep(3000);
                }else {
                    System.out.println(Thread.currentThread().getName() + "没有获得锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
