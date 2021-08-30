package com.example.xm.threadmethod.p2isalive;

public class Thread03 extends Thread {

    @Override
    public void run() {
        System.out.println("run 方法 " + this.isAlive() );
    }
}
