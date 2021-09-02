package com.example.xm.p5线程间的通信.p1等待通知机制;

/**
 * 中断线程  interrupet（）方法
 */
public class Test03 {

    public static void main(String[] args) {
        Threadxx threadxx = new Threadxx();
        threadxx.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程开始中断程序");

        threadxx.interrupt();
        System.out.println("主线程中断完毕");
    }



    static class Threadxx extends Thread{
        static public final Object o = new Object();

        @Override
        public void run() {
            synchronized (o){
                System.out.println("线程等待");
                try {
                    o.wait();
                    System.out.println("线程等待结束---------------");

                } catch (InterruptedException e) {
                    System.out.println("interrupet方法打断");
                }
            }
        }
    }
}
