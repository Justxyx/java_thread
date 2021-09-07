package com.example.xm.p10线程池.p3线程池的异常;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  线程池并没有进行提示,即线程池把任务中的异常给吃掉了
 *  演示如下：
 *
 *  解决方法：
 *      submit换为execute
 */
public class Test01 {
    public static class DividieTask implements Runnable{
        private int x;
        private int y;

        public DividieTask(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            System.out.println(x +"除以"+ y+"的结果为" + x/y  );
        }
    }

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,Integer.MAX_VALUE,0, TimeUnit.SECONDS,new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {
//            threadPoolExecutor.submit(new DividieTask(10, i));
            threadPoolExecutor.execute(new DividieTask(10, i));
        }
    }
}
