package com.example.xm.p5线程间的通信.p2生产者消费者模式;

/**
 * 单消费者生产者的情况
 */
public class Test01 {
    public static void main(String[] args) {
        ValueOP valueOP = new ValueOP();

        Porducer porducer = new Porducer(valueOP);
        Consumer consumer = new Consumer(valueOP);

        porducer.start();
        consumer.start();
    }
}
