package com.example.xm.p2threadmethod.p8setDaemon;

public class Thread  extends java.lang.Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("子线程启动打印");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
