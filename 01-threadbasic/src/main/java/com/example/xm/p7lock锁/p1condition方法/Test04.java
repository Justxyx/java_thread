package com.example.xm.p7lock锁.p1condition方法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个conditon 循环打印
 */
public class Test04 {
    static class service{
        static private ReentrantLock lock = new ReentrantLock();
        static private Condition conditionA = lock.newCondition();
        static private Condition conditionB = lock.newCondition();

        static private int count = 0;

        static class ThreadA extends Thread{
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; i++) {
                        while (count%2 ==0){
                            conditionA.await();
                        }
                        System.out.println("-----------");
                        count ++ ;
                        conditionB.signal();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        static class ThreadB extends Thread{
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; i++) {
                        while (count%2 ==1){
                            conditionB.await();
                        }
                        System.out.println("*************");
                        count ++ ;
                        conditionA.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public static void main(String[] args) {

        new service.ThreadA().start();
        new service.ThreadB().start();
    }
}
