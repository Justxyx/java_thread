package com.example.xm.p5线程间的通信.p2生产者消费者模式;

/**
 * 定义一个操作数据的类
 */

public class ValueOP {
    private String value = "";

    public void setValue() {
        synchronized (this){
            // 1. 如果不是空串就等待
            while (!value.equals("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 2. 是空串，就设置value字段的值
            this.value = System.currentTimeMillis() + "";
            System.out.println("value值已经设置完毕");
            this.notify();
        }
    }

    public void getValue(){
        synchronized (this){
            //1.如果是空串就等待
            while (value.equals("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.如果不是空串， 消费该字段， 读取
            System.out.println("get的值是" + this.value);
            this.value = "";
            this.notify();
        }
    }
}
