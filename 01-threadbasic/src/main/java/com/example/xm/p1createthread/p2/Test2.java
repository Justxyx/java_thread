package com.example.xm.p1createthread.p2;

public class Test2 {
    public static void main(String[] args) {
        Thread2 mythread = new Thread2();
        mythread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("---主程启动" + i + "---");
            int rand = (int) (Math.random() * 1000);
            try {
                Thread.sleep(rand);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
