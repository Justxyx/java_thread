package com.example.xm.p10线程池.p4ForkJoinPool并行计算;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Test01 {
    static class CountTask extends RecursiveTask<Long> {
            private static final long TASKNUM = 100;  //定义每次把任务分成100个小任务
        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;

            if (end - start < TASKNUM){
                for (int i = start; i <= end ; i++) {
                    sum += i;
                }
            }else {
                // 需要分解计算
                int step = (int) ((end - start) / TASKNUM);
                ArrayList<CountTask> list = new ArrayList<>();
                int pos = start;
                for (int i = 0; i < TASKNUM; i++) {
                    int lastOne =  pos + start;
                    if (lastOne > end){
                        lastOne = end;
                    }
                    CountTask task = new CountTask(pos, lastOne);
                    list.add(task);
                    task.fork();
                    pos += step +1;
                }
                for (CountTask countTask : list) {
                    Long a = countTask.join();
                    sum  += a;
                }
            }


            return sum;
        }
    }


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(0, 20000);
        ForkJoinTask<Long> submit = pool.submit(task);
        try {
            Long aLong = submit.get();
            System.out.println(aLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
