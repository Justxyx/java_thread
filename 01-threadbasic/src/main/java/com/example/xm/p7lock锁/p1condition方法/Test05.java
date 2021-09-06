package com.example.xm.p7lock锁.p1condition方法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印   十个线程打印
 */
public class Test05 {
    static  class servicexx{
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private Boolean flag = true;

        // 打印----
        public  void printA(){
            try {
                lock.lock();
                while (flag){
                    condition.await();
                }
                System.out.println("-----------------");
                flag = true;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        // 打印***
        public void printB(){
            try {
                lock.lock();
                while (!flag){

                    condition.await();
                }
                System.out.println("***********");
                flag = false;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        servicexx service = new servicexx();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        service.printA();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        service.printB();
                    }
                }
            }).start();
        }
    }

}
