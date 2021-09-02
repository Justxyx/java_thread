package com.example.xm.p4多线程同步.p2原子变量类.p2AtomicIntegerFieldUpdater;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Threadxx extends Thread{
    private User user;

    private AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public Threadxx(User user){
        this.user = user;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(updater.getAndIncrement(user));
        }
    }
}
