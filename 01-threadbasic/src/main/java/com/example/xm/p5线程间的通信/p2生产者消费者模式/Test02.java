package com.example.xm.p5线程间的通信.p2生产者消费者模式;

/**
 *
 * 多生产者消费者情况
 *      解决优化的两个问题：
 *          1. while 解决读取空值的问题
 *          2. notifyall() 解决假死问题
 *              假死原因，生产者只唤醒生产者，消费者只唤醒消费者。死循环。
 */
public class Test02 {
    public static void main(String[] args) {
        ValueOP valueOP = new ValueOP();

        Porducer porducer = new Porducer(valueOP);
        Porducer porducer2 = new Porducer(valueOP);
        Porducer porducer3 = new Porducer(valueOP);
        Consumer consumer = new Consumer(valueOP);
        Consumer consumer2 = new Consumer(valueOP);
        Consumer consumer3 = new Consumer(valueOP);

        porducer.start();
        porducer2.start();
        porducer3.start();

        consumer.start();
        consumer2.start();
        consumer3.start();
    }
}
