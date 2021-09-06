package com.example.xm.p7lock锁.p2公平锁与非公平锁;

import com.example.xm.p1createthread.p3.Runable;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁
 *      一般默认非公平锁
 *      公平锁性能较低。
 */
public class Test01 {
    public static void main(String[] args) {
//        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantLock reentrantLock = new ReentrantLock(true);  // 公平锁


        Runnable r = new Runable(){
            @Override
            public void run() {
                while (true){
                    reentrantLock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + "获得了锁");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        };


        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(r);
            t.start();
        }
    }
}
