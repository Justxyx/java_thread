package com.example.xm.p3锁.p2volatile;

/**
 * 一点笔记
 *  最重要的一点 ：  *** volatile的作用是强制线程从公共内存中读取变量的值，而不是从工作内存中读取 ***
 *  volatile 与 synchronized 的比较：
 *      1. volatile 是线程同步的轻量级实现，所以volatile的性能肯定比synchronized要好。 但是随着jdk的新版本发布，synchronized的执行效率也有较大的提升。
 *      2. volatile 变量不会发生阻塞。
 *      3. volatile只能保证数据的可见性，原子性暂时得不到保证。
 *      4. 关键字volatile解决的是变量在多个线程之间的可见性，
 *          关键字synchornized解决的是多个线程之间访问公共资源的同步性
 */
public class Test02 {
}
