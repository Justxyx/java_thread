package com.example.xm.p3threadsafe;


/**
 * 测试线程的可见性
 */

/**
 * 笔记：
 *      可能会出现一下情况：
 *       main线程调用了取消任务的task.cancel 方法，把task对象中的toCancel变量修改为true，但是子线程看不到main线程对toCancel的修改。
 *       原因暂时略。
 */
public class Test02 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        new Thread(myTask).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myTask.cancel();

    }



    static class MyTask implements Runnable{
        private boolean toCancel = false;
        @Override
        public void run() {
            while (!toCancel){
                if(doSomething()) {
                }
                }
                if(toCancel){
                    System.out.println("任务被取消");
                }else {
                    System.out.println("任务正常结束");
                }
            }

        private boolean doSomething() {
            System.out.println("执行了某个任务 - - ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        public void cancel(){
            toCancel = true;
            System.out.println("收到取消线程的消息");

        }
    }



}
