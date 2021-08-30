package com.example.xm.createthread.p1;

public class Test {
    public static void main(String[] args) {
        System.out.println("---主线程启动---");
        Mythread thread = new Mythread();
        thread.run();
        System.out.println("---主线程关闭---");
    }
}
