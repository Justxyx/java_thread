package com.example.xm.threadmethod.p7interrupt;

public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (this.isInterrupted()){
                return;
            }
            System.out.println("线程A -->" + i);
        }
    }
}
