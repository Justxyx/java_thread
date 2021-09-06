package com.example.xm.p5线程间的通信.p3操作栈;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private List list = new ArrayList();

    private static final int max = 1;

    // 定义压栈操作
    public synchronized void push(){
        while (list.size() >= max){
            System.out.println(Thread.currentThread().getName() + " begin wait");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String data = "data--" + Math.random();
        System.out.println(Thread.currentThread().getName() + "添加了数据 ： " + data);
        list.add(data);
        this.notifyAll();
    }

    // 定义出栈操作
    public synchronized void pop(){
            while (list.size()==0){
                System.out.println(Thread.currentThread().getName() + "begin wait");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println(Thread.currentThread().getName() + "出栈的数据 ： " + list.remove(0));
            this.notifyAll();
    }



}
