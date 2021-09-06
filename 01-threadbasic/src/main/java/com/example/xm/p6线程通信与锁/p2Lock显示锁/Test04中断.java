package com.example.xm.p6线程通信与锁.p2Lock显示锁;

import java.util.concurrent.locks.ReentrantLock;

/**
 *      1.对于 synchronized 内部锁来说,如果一个线程在等待锁,只有两个结
 *          果:要么该线程获得锁继续执行;要么就保持等待.
 *       2. 对于 ReentrantLock 可重入锁来说,提供另外一种可能,在等待锁的
 *          过程中,程序可以根据需要取消对锁的请求.
 *
 *       重点：
 *              *** 在等待状态下，synchronized 是不可以被中断的  synchornized 不可以被中断说的也是这个
 *                  在运行状态下， interrupt 是可以改变标志位来中断的
 *              ***
 */
public class Test04中断 {
    static class IntLock implements Runnable{
        static ReentrantLock lock1 = new ReentrantLock();
        static ReentrantLock lock2 = new ReentrantLock();

        private int lockNum;  // 定义一个变量，决定用哪一把锁

        public IntLock(int lockNum) {
            this.lockNum = lockNum;
        }

        @Override
        public void run() {
            try {
                if(lockNum % 2 == 0){  // 偶数，先锁1 再锁2
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "锁1已上锁");
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "锁2已上锁");

                }else {
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "锁2已上锁");
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "锁1已上锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (lock1.isHeldByCurrentThread()){
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()){
                    lock2.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        IntLock lock = new IntLock(11);
        IntLock lock1 = new IntLock(22);

        Thread t1 = new Thread(lock);
        Thread t2 = new Thread(lock1);

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (t1.isAlive()){
            t1.interrupt();
        }
    }
}
