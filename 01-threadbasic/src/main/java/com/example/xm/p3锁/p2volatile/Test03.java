package com.example.xm.p3锁.p2volatile;

/**
 * volatile 不具备原子性
 * volatile 关键字仅仅表示，所有的线程从主内存中读取count变量值
 */
public class Test03 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Threadxx threadxx = new Threadxx();
            threadxx.start();
        }
    }

    static class Threadxx extends Thread{
        public volatile static int count = 0;

        public synchronized static void countAdd(){
            for (int i = 0; i < 10000; i++) {
                count ++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获得的count值为：" + count);
        }

        @Override
        public void run() {
            countAdd();
        }
    }
}
