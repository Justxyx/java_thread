package com.example.xm.p5线程间的通信.p1等待通知机制;

import java.util.ArrayList;

/**
 * notify（）不会立即释放锁对象
 * 代码演示如下
 */
public class Test02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (list.size() != 5){
                    synchronized (list){
                        System.out.println("线程1被锁住啦！！");
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程1被唤醒啦");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list){
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        list.add("add");
                    if (list.size() == 5){
                            System.out.println("线程2准备唤醒线程1啦");
                            list.notify();
                            System.out.println("线程2已经唤醒线程1啦");
                        }
                        System.out.println("----- "  + i);
                    }
                }
            }
        });

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}
