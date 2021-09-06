package com.example.xm.p5线程间的通信.p3操作栈;

/**
 * 一对一模式
 *      生产者 消费者
 */
public class Test01 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        Produer t1 = new Produer(stack);
        Consumer t2 = new Consumer(stack);

        t2.start();

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
