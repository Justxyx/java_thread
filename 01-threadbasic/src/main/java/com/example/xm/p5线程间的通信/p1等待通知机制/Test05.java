package com.example.xm.p5线程间的通信.p1等待通知机制;

/**
 * wait() 的一个重载方法
 */
public class Test05 {

    public static void main(String[] args) {
        Object o = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println("线程进入等待.....");
                    try {
                        o.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程结束等待......");
                }
            }
        }).start();
    }
}
