package com.example.xm.threadmethod.p1currentthread;

public class Test02 {
    public static void main(String[] args) {
        SubThread02 t2 = new SubThread02();
        t2.setName("t2");
        t2.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------");

        Thread thread = new Thread(t2);
        thread.start();
    }
}
