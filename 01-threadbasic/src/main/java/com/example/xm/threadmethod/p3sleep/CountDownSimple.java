package com.example.xm.threadmethod.p3sleep;

public class CountDownSimple {
    public static void main(String[] args) {
        int i = 10;
        while (true){
            System.out.println("current time " + i);
            try {
                Thread.sleep(1000);
                i --;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i < 0 ){
                break;
            }
        }
        System.out.println("down!");
    }
}
