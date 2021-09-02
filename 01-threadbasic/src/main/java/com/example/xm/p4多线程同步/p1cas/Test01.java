package com.example.xm.p4多线程同步.p1cas;

/**
 * 手撸cas算法 (compareAndSwap)
 *      算法核心点：
 *      1. 线程从主内存中读取变量到工作内存中
 *      2. 对工作内存中的变量进行操作
 *      3. 再次读取主内存中的变量值，
 *          如果值不一样，则撤销此次操作
 *          如果值一样，将count值更新到主内存中
 */

/***
 * cas算法所产生的aba问题，将会在后期详解。  AtomicStampedReference
 * 到时候详细博客
 */
public class Test01 {
    public static void main(String[] args) {
        CasCount casCount = new CasCount();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(casCount.increamentAndGet());
                }
            }).start();
        }

    }
}

class CasCount{
    volatile private long value;

    public long getCount() {
        return value;
    }

    private boolean compareAndSwap(long oldValue,long newValue){
        synchronized (this){
            if (value == oldValue){
                value = newValue;
                return true;
            }else {
                return false;
            }
        }
    }

    public long increamentAndGet(){
        long oldvalue ;
        long newvalue;

        do{
            oldvalue = value;
            newvalue = value + 1;
        }while (!compareAndSwap(oldvalue,newvalue));
        return newvalue;
    }

}
