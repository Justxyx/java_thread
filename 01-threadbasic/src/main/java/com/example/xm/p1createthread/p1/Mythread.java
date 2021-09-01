package com.example.xm.p1createthread.p1;

public class Mythread  extends Thread{
    @Override
    public void run() {
        System.out.println("子线程启动");
    }
}
