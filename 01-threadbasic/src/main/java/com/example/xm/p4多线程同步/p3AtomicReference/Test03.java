package com.example.xm.p4多线程同步.p3AtomicReference;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *  解决AtomicReference 出现的cas ABA 问题
 *   AtomicStampedReference
 *   加了一个时间标记
 */
public class Test03 {
    private static AtomicStampedReference<String> stampedReference = new AtomicStampedReference<>("abc",0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stampedReference.compareAndSet("abc","edf",stampedReference.getStamp(),stampedReference.getStamp()+1);
                System.out.println("---------------------------");
                stampedReference.compareAndSet("def","abc",stampedReference.getStamp(),stampedReference.getStamp()+1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = stampedReference.getStamp();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                };
                stampedReference.compareAndSet("abc","xxx",stamp,stamp+1);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(stampedReference.getReference());

    }
}
