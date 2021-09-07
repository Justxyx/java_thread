package com.example.xm.p10线程池.p2扩展线程池;

import com.example.xm.p1createthread.p3.Runable;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 扩展线程池
 *      在执行前后
 */
public class Test01 {
    static class tsak implements Runnable{
        String name;

        public tsak(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "  任务正在被执行" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>()){
            // 执行前
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                tsak a = (tsak) r;
                System.out.println(t.getId() + "线程准备执行任务 " + ((tsak) r).name);
            }

            //执行后
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println( "线程任务执行完成 " + ((tsak) r).name);

            }

            @Override
            protected void terminated() {
                System.out.println("任务结束啦");
            }
        };

        for (int i = 0; i < 5; i++) {
            tsak tsak = new tsak("name " + i);
            poolExecutor.execute(tsak);
        }
    }
}
