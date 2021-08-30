package com.example.xm.threadmethod.p2isalive;

public class Test03 {
    public static void main(String[] args) {
        Thread03 t03 = new Thread03();
        System.out.println("begin -- " + t03.isAlive());
        t03.start();
        System.out.println("end -- "  + t03.isAlive());
    }
}
