package com.example.xm.createthread.p3;

public class Runable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程1开启啦 --- " + i);
        }
    }
}
