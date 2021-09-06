package com.example.xm.p5线程间的通信.p3操作栈;

/**
 * 一生产者多消费者情况
 */

/**
 * 还是跟上一节类似
 *
 * 容易出现假死 与 找不到数据的问题
 *
 * 解决方法：
 *      1. if 换为 while
 *      2. notify 换为 notifyall
 */
public class Test02 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Produer produer = new Produer(stack);
        Consumer c1 = new Consumer(stack);
        Consumer c2 = new Consumer(stack);
        Consumer c3 = new Consumer(stack);

        produer.start();

        c1.setName("c1");
        c2.setName("c2");
        c3.setName("c3");

        c1.start();
        c2.start();
        c3.start();
    }
}
