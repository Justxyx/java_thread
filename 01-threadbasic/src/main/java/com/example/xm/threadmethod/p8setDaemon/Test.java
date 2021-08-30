package com.example.xm.threadmethod.p8setDaemon;

public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
