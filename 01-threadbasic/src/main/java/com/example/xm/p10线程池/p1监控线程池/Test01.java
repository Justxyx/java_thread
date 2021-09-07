package com.example.xm.p10线程池.p1监控线程池;

import com.example.xm.p1createthread.p3.Runable;
import com.example.xm.p2threadmethod.p3sleep.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
        Runable r = new Runable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + "编号， 开始的线程开始执行任务" + System.currentTimeMillis());
                try {
                    Thread.sleep(3000);  // 睡眠3秒模拟执行任务时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 定义线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new
                ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 30; i++) {
            poolExecutor.submit(r);
            System.out.println(" 当 前 线 程 池 核 心 线 程 数 量 : " +
                            poolExecutor.getCorePoolSize() + ", 最大线程数:" + poolExecutor.getMaximumPoolSize() + ",当 前 线 程 池 大 小 :" + poolExecutor.getPoolSize() + ", 活 动 线 程 数 量 :" +
            poolExecutor.getActiveCount()+ ",收到任务数量:" + poolExecutor.getTaskCount() + ",完成任务 数 : " + poolExecutor.getCompletedTaskCount() + ", 等 待 任 务 数 :" +
            poolExecutor.getQueue().size()) ;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
