package com.example.xm.p3锁.p1sync;

/**
 * 同步过程中，线程出现异常情况
 *      线程是相互独立的 一个线程出现问题 不影响别的线程
 *      线程出现异常会自动的释放锁
 */
public class Test09 {
    public static void main(String[] args) {
        Test09 test = new Test09();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.mm2();
            }
        }).start();
    }


    public void mm() {
        synchronized (Test09.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
                if (i == 50){
                    int ac = Integer.parseInt("ac");
                    System.out.println(ac);
                }
            }
        }
    }
    public void mm2() {
        synchronized (Test09.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }

}
