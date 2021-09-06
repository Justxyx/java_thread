package com.example.xm.p5线程间的通信.p1等待通知机制;

/**
 * notify() 与 nofityall()
 */
public class Test04 {
    public static void main(String[] args) {
        Object o = new Object();
        Threadxx t1 = new Threadxx(o);
        Threadxx t2 = new Threadxx(o);
        Threadxx t3 = new Threadxx(o);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (o){
            o.notifyAll();
        }
    }

    static class Threadxx extends Thread{
        private Object o;

        public Threadxx(Object o) {
            this.o = o;
        }

        @Override
        public void run() {
            synchronized (o){
                System.out.println(Thread.currentThread().getName() + "线程进入等待");
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程被唤醒");

            }

        }
    }
}
