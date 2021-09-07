package com.example.xm.p9捕获线程异常.p2Hook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hook钩子线程的作用：
 *      校验线程是否已经启动，防止重复启动程序。
 * 过程：
 *      启动的时候创建一个.lock 文件， jvm退出的时候删除这个文件
 */
public class Test01 {
    public static void main(String[] args) {

        // 1. 注入hook线程，在程序退出时候删除.lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("jvm退出，会启动当前hock线程，在hock线程中删除.lock文件");
                getLockFile().toFile().delete();
            }
        });

        // 2. 程序运行时候检查.lock文件是否存在，如果存在则抛出异常
        if (getLockFile().toFile().exists()){
            throw new RuntimeException("程序已经启动啦");
        }else {
            try {
                getLockFile().toFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private static Path getLockFile(){
        return Paths.get("", "tmp.lock");
    }
}
