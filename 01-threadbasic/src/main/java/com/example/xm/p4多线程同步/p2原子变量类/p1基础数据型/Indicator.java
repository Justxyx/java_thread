package com.example.xm.p4多线程同步.p2原子变量类.p1基础数据型;


import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例设计模式
 *      该计数器，在整个程序中都能使用
 */
public class Indicator {
    // 构造方法私有化
    private Indicator(){};
    // 定义一个私有的本类静态对象
    private static final Indicator INSTANCE  = new Indicator();

    // 提供一个公共静态方法返回该类的唯一实例
    public static Indicator getInstance(){
        return INSTANCE;
    }


    private final AtomicLong requestCount = new AtomicLong(0); //记录请求总数
    private final AtomicLong successCount = new AtomicLong(0); //处理成功总数
    private final AtomicLong fialureCount = new AtomicLong(0); //处理失败总数

    //有新的请求
    public void newRequestReceive(){
        requestCount.incrementAndGet();
    }
    //处理成功
    public void requestProcessSuccess(){
        successCount.incrementAndGet();
    }
    //处理失败
    public void requestProcessFailure(){
        fialureCount.incrementAndGet();
    }


    //查看总数,成功数,失败数
    public long getRequestCount(){
        return requestCount.get();
    }
    public long getSuccessCount(){
        return successCount.get();
    }
    public long getFailureCount(){
        return fialureCount.get();
    }

}
