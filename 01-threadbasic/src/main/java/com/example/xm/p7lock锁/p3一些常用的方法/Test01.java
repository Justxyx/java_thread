package com.example.xm.p7lock锁.p3一些常用的方法;

import com.example.xm.p1createthread.p3.Runable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    static ReentrantLock reentrantLock = new ReentrantLock();


    static void waie() throws InterruptedException {
        try {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
            Thread.sleep(1000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁对象");
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable r =  new Runable(){
            @Override
            public void run() {
                try {
                    Test01.waie();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread[] t = new Thread[5];

        for (int i = 0; i < 5; i++) {
            t[i] = new Thread(r);
            t[i].setName(String.valueOf(i));
            t[i].start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(reentrantLock.hasQueuedThreads());
        System.out.println("==================");

        System.out.println(reentrantLock.hasQueuedThread(t[0]));
        System.out.println(reentrantLock.hasQueuedThread(t[1]));
        System.out.println(reentrantLock.hasQueuedThread(t[2]));
        System.out.println(reentrantLock.hasQueuedThread(t[3]));
        System.out.println(reentrantLock.hasQueuedThread(t[4]));



    }


}
