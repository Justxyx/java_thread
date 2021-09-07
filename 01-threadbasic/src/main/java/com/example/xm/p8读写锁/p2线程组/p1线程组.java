package com.example.xm.p8读写锁.p2线程组;

/**
 * 略 。。。
 *      线程组不太用了已经
 */
public class p1线程组 {
    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup);
        System.out.println("-------------------------");

        ThreadGroup group1 = new ThreadGroup("group1");
        System.out.println(group1);


    }
}
