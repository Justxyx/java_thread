package com.example.xm.createthread.p2;

public class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("---子线程启动" + i + "---");
            int rand = (int) (Math.random() * 1000);
            try {
                Thread.sleep(rand);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
