package com.example.xm.createthread.p1;

public class Mythread  extends Thread{
    @Override
    public void run() {
        System.out.println("子线程启动");
    }
}
