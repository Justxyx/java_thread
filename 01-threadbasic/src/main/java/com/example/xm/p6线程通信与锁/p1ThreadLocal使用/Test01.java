package com.example.xm.p6线程通信与锁.p1ThreadLocal使用;

import com.example.xm.p2threadmethod.p3sleep.Thread;

/**
 *   ThreadLocal   的基本用法
 *      总感觉这个例子有点小问题
 *      有点类似于每个线程的局部变量 注意只是类似！
 */
public class Test01 {


    // 设置默认值 如果不赋值的默认值
    static ThreadLocal local = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return "xxx";
        }
    };

    static class Threadxx extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
//                local.set(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + "--->" +local.get());
            }
        }
    }

    public static void main(String[] args) {
        Threadxx t1 = new Threadxx();
        Threadxx t2 = new Threadxx();

        t1.start();
        t2.start();
    }

}
