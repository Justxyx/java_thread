package com.example.xm.p2threadmethod.p7interrupt;

public class Test {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程--> " + i);
        }
        threadA.interrupt();
    }
}
