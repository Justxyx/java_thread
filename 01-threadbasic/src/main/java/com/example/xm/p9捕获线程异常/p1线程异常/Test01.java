package com.example.xm.p9捕获线程异常.p1线程异常;

/**
 * 设置全局回调接口
 *
 *  java 异常：
 *      1. 受检异常： 在多线程中必须用try catch处理
 *      2. 运行异常：
 */
public class Test01 {
    public static void main(String[] args) {
         // 设置全局接口
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + "产生了" + e.getMessage() + "异常");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始运行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(3/0);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始运行");
                String s = null;
                System.out.println(s.length());
            }
        }).start();
    }
}
