package com.example.xm.p5线程间的通信.p2生产者消费者模式;

/**
 * 生产者
 */
public class Porducer extends Thread{
    private ValueOP op;

    public Porducer(ValueOP op) {
        this.op = op;
    }

    @Override
    public void run() {
        while (true){
            op.setValue();
        }
    }
}
