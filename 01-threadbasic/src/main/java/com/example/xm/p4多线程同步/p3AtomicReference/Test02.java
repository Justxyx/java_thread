package com.example.xm.p4多线程同步.p3AtomicReference;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference 可能会出现的cas  的ABA问题
 * 演示如下：
 */
public class Test02 {
    private static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicReference.compareAndSet("abc","edf");
                System.out.println("---------------------------");
                atomicReference.compareAndSet("def","abc");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicReference.compareAndSet("abc","xxx");
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicReference.get());
    }
}
