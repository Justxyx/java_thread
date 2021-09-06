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
public class Test09 {
    public static void main(String[] args) {

        /**
         * 测试二：
         *      开启两个取数据线程，再开启添加数据线程
         *      会发生错误
         *
         *      分析可能的执行顺序:
         threadSubtract 线程先启动, 取数据时,集合中没有数据,wait()等待
         threadAdd 线程获得 CPU 执行权, 添加数据 , 把 threadSubtract 线程唤醒, threadSubtract2 线程开启后获得 CPU 执行权, 正常取数据
         threadSubtract 线程获得 CPU 执行权, 打印 end wait..., 然后再执行
         list.remove(0) 取 数 据 时 , 现 在 list 集 合 中 已 经 没 有 数 据 了 , 这 时 会 产 生
         java.lang.IndexOutOfBoundsException 异常
         出现异常的原因是: 向 list 集合中添加了一个数据,remove()了两次

         */

        TheradAbstract t1 = new TheradAbstract();
        TheradAbstract t2 = new TheradAbstract();
        ThreadAdd t3 = new ThreadAdd();

        t1.start();
        t2.start();
        t3.start();


    }

    // 1. 定义一个List集合
    static List list = new ArrayList();

    //2. 定义一个方法向集合中删除数据
    static void substract(){

        synchronized (list){

            while (list.size() == 0){
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
