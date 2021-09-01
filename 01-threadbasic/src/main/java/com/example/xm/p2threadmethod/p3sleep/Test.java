package com.example.xm.p2threadmethod.p3sleep;

public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread();
        long millis = System.currentTimeMillis();
        thread.run();
        long l = System.currentTimeMillis() - millis;
        System.out.println("-------------"  + l);
    }
}
