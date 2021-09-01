package com.example.xm.p3锁.p1sync;

/**
 * 死锁问题
 * 死锁问题产生的原因：
 *         多线程需要用到多把锁
 * 解决方法：
 *          当需要用到多把锁时，所有线程获得锁的顺序保持一致即可
 */
public class Test10 {
    public static void main(String[] args) {
        Threadxx a = new Threadxx();
        a.setName("a");
        a.start();

        Threadxx b = new Threadxx();
        b.setName("b");
        b.start();
    }

    static class Threadxx extends Thread{
        private static final Object o1 = new Object();
        private static final Object o2 = new Object();


        @Override
        public void run() {
            if ("a".equals(Thread.currentThread().getName())){
                synchronized (o1){
                    System.out.println("线程a获得了锁1");
                    synchronized (o2){
                        System.out.println("线程a获得了锁2");
                    }
                }
            }
            if ("b".equals(Thread.currentThread().getName())){
                synchronized (o2){
                    System.out.println("线程b获得了锁2");
                    synchronized (o1){
                        System.out.println("线程b获得了锁1");
                    }
                }
            }
        }
    }
}
