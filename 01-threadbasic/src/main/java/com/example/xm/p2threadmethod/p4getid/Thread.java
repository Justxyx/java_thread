package com.example.xm.p2threadmethod.p4getid;

public class Thread  extends java.lang.Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "id," + Thread.currentThread().getId());
    }
}
