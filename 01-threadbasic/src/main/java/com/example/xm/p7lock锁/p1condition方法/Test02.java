package com.example.xm.p7lock锁.p1condition方法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 conditon 唤醒指定等待
 */
public class Test02 {
    static class Service{
        private ReentrantLock lock = new ReentrantLock();
        // 定义两个锁对象
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        // A等待
        void waitA(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
                System.out.println(Thread.currentThread().getName() + "A开始等待");
                conditionA.await();
                System.out.println("A继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        // B等待
        void waitB(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
                System.out.println(Thread.currentThread().getName() + "B开始等待");
                conditionB.await();
                System.out.println("B继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void singA(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
                conditionA.signal();
                System.out.println(Thread.currentThread().getName() + "唤醒了A");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


        void singB(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
                conditionB.signal();
                System.out.println(Thread.currentThread().getName() + "唤醒了B");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Service service = new Service();

        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitB();
            }
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.singB();
        service.singA();
    }
}
