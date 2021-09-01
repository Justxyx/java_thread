package com.example.xm.p3锁.p1sync;

/**
 * 在实际开发任务中， 同步代码块与同步方法该如何选择 ？
 * 同步代码块，粒度细效率较高。
 * 同步方法粒度较粗，执行效率较低。
 */

public class Test07 {
    public static void main(String[] args) {
        Test07 test = new Test07();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.doSomeThing2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.doSomeThing2();
            }
        }).start();
    }

//    同步方法
    public synchronized void doSomeThing(){
        System.out.println("任务主备中");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
        System.out.println("------------");
        System.out.println("任务结束");
    }


//    同步代码块
    public  void doSomeThing2(){
        System.out.println("任务主备中");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }}
        System.out.println("------------");
        System.out.println("任务结束");
    }
}
