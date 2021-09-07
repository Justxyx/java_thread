package com.example.xm.p9捕获线程异常.p3线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *      Executors 为一个线程池工具类，快速创建线程池
 *      Executor 为一个接口
 */
public class p1线程池的基本使用 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 18; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "执行任务");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
