package com.example.xm.p9捕获线程异常.p3线程池;

import java.util.concurrent.*;

/**
 * 线程池的计划任务
 */

public class Test02线程池的计划任务 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        // 1.延迟两秒后执行任务
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
            }
        },2, TimeUnit.SECONDS);


        // 2. 三秒钟后执行，并且每间隔两秒执行一次
        // 如果执行时间大于间隔时间，那就以任务时间为间隔
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getId() + "----------" + System.currentTimeMillis());
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },3,2,TimeUnit.SECONDS);


        // 3. 任务结束后再等两秒，五秒一循环。
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "----------" + System.currentTimeMillis());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },3,2,TimeUnit.SECONDS);
    }
}
