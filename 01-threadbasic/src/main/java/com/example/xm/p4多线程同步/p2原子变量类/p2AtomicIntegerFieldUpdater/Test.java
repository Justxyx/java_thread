package com.example.xm.p4多线程同步.p2原子变量类.p2AtomicIntegerFieldUpdater;

public class Test {
    public static void main(String[] args) {
        User user = new User(123, 1);
        for (int i = 0; i < 100; i++) {
            Threadxx threadxx = new Threadxx(user);
            threadxx.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(user.toString());

    }
}
