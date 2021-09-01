package com.example.xm.p3threadsafe;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示线程原子性问题
 */
public class Test01 {
    public static void main(String[] args) {
        MyInt myInt = new MyInt();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName() + "当前值为" + myInt.getNum());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

    }

    static class MyInt{
        AtomicInteger num = new AtomicInteger();
        public int getNum(){
            return num.getAndIncrement();
        }
    }
}
