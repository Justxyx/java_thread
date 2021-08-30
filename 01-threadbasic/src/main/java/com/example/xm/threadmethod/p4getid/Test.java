package com.example.xm.threadmethod.p4getid;

public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "id," + Thread.currentThread().getId());


        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread();
            thread.start();
        }
    }
}
