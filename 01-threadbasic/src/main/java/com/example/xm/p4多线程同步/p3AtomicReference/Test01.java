package com.example.xm.p4多线程同步.p3AtomicReference;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用AtomicReference原子读写一个对象
 */
public class Test01 {
    static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(atomicReference.compareAndSet("abc","def"));{
                        System.out.println(Thread.currentThread().getName() + "修改为def");
                    }
                }
            }).start();
        }

        for (int i = 0; i < 100; i++) {



                    if(atomicReference.compareAndSet("def","abc"));{
                        System.out.println(Thread.currentThread().getName() + "修改为abc");
                    }

        }
    }
}
