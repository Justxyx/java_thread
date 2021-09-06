package com.example.xm.p5线程间的通信.p1等待通知机制;

import java.util.ArrayList;
import java.util.List;

/**
 * wait 等待条件发生了变化，可能会造成逻辑混乱。
 *      演示流程：
 *      1. 定义一个集合
 *      2. 定义一个线程向集合中添加数据，添加完成后通知另外的线程从集合中取数据。
 *      3. 定义一个线程从集合中取数据，如果没有就等待。
 */
public class Test08 {
    public static void main(String[] args) {

        /**
         * 测试一：
         *      先开启增加数据的线程，再开启读取数据的线程。
         *      大多数情况下都会正常
         */

        TheradAbstract t1 = new TheradAbstract();
        ThreadAdd t2 = new ThreadAdd();


        t1.start();
        t2.start();


    }

    // 1. 定义一个List集合
    static List list = new ArrayList();

    //2. 定义一个方法向集合中删除数据
    static void substract(){

        synchronized (list){

            if (list.size() == 0){
                try {
                    System.out.println("substract方法，集合size为0，进入等待中");
                    list.wait();
                    System.out.println("substract方法，等待被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            Object remove = list.remove(0);
            System.out.println("abstract方法取出了数据" + remove);
        }
    }

    //3. 定义一个方法向集合中添加数据然后通知线程取数据
    static void add(){
        synchronized (list){
            System.out.println("进入add方法，添加数据");
            list.add("data");
            System.out.println("add方法添加数据已完成");
            list.notifyAll();
        }
    }

    static class TheradAbstract extends Thread{
        @Override
        public void run() {
            substract();
        }
    }

    static class ThreadAdd extends Thread{
        @Override
        public void run() {
            add();
        }
    }
}
