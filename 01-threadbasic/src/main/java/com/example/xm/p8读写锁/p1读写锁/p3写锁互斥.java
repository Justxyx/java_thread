package com.example.xm.p8读写锁.p1读写锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class p3写锁互斥 {

    static class service{
        static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void write(){
            try {
                lock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " 获得了写读锁");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "写锁处理完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        service service = new service();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.write();
                }
            }).start();
        }
    }
}
