package com.example.xm.threadmethod.p1currentthread;

public class Test1 {


    public static void main(String[] args) {
        System.out.println("主线程---" + Thread.currentThread().getName());

        SubThread thread = new SubThread();
        thread.start();
    }
}
