package com.example.xm.p8读写锁.p1读写锁;

import com.example.xm.p1createthread.p3.Runable;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  可以同时获得锁
 */

public class p2读读共享 {
    static class service{
        private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        public void read(){
            try {
                reentrantReadWriteLock.readLock().lock();    // 读锁
                System.out.println(Thread.currentThread().getName() + "获得了读锁的时间为：" + System.currentTimeMillis());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        service service = new service();
        Runable r =  new Runable(){
            @Override
            public void run() {
                service.read();
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}
