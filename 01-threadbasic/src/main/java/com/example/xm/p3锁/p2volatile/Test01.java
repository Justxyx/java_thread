package com.example.xm.p3锁.p2volatile;

/**
 * 程序运行，可能会出现死循环的情况
 * 原因：main线程修改了continuePrint属性值，然而子线程看不到，所以继续打印；
 * 解决方法： 使用volatile关键字修饰PrintString 对象的 continuePrint 属性，
 *              *** volatile的作用是强制线程从公共内存中读取变量的值，而不是从工作内存中读取 ***
 *              即对多个线程可见
 */

public class Test01 {
    public static void main(String[] args) {

        PrintString printString = new PrintString();
        printString.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printString.setContinuePrint(false);

    }

    static class PrintString extends Thread{
        private volatile boolean continuePrint = true;

        public void setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
        }

        @Override
        public void run() {
            while (continuePrint){

            }
        }
    }
}
