package com.example.xm.p1createthread.p3;

public class Test3 {
    public static void main(String[] args) {
        Runable runable = new Runable();
        Thread thread = new Thread(runable);
        thread.run();

//        -------------------------

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程开起来---"+ i);
        }

//        ----------------------

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程3开启啦---" + i );
                }
            }
        }).run();
    }
}
