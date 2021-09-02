package com.example.xm.p4多线程同步.p2原子变量类.p1基础数据型;


import java.util.Random;

/**
 * 模拟服务器的请求总数，处理成功数，处理失败数。
 *
 * 每一个线程就是一个请求
 *
 * 通过线程模拟请求，在实际开发中，一般在servletFilter 过滤器中增加相关的方法。
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Indicator.getInstance().newRequestReceive();
                    int nextInt = new Random().nextInt();
                    if (nextInt % 2 == 0){
                        Indicator.getInstance().requestProcessSuccess();
                    }else {
                        Indicator.getInstance().requestProcessFailure();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Indicator.getInstance().getRequestCount());
        System.out.println(Indicator.getInstance().getSuccessCount());
        System.out.println(Indicator.getInstance().getFailureCount());

    }
}
